----------------------------------Calcular salario-----------------------------------------------------

DELIMITER $$

CREATE OR REPLACE FUNCTION calcular_salario(
    localidadContrato VARCHAR(250),
    añosContrato INT
) 
RETURNS DECIMAL(10,2) 
DETERMINISTIC
BEGIN
    DECLARE precio_ca DECIMAL(10,2);
    DECLARE precio_pais DECIMAL(10,2);
    DECLARE semestres INT;
    DECLARE salario_total DECIMAL(10,2);
    DECLARE i INT;

    -- Guardar el precio de vida de la comunidad
    SELECT ROUND(c.precio_vida) INTO precio_ca
    FROM comunidades_autonomas c 
    INNER JOIN localidades l ON c.ca = l.ca 
    WHERE l.localidad  = localidadContrato  LIMIT 1;

    -- La media del precio de vida
    SELECT ROUND(AVG(precio_vida)) INTO precio_pais 
    FROM comunidades_autonomas;

    -- Verificar si no hay errores
    IF precio_ca IS NULL OR añosContrato < 0 THEN
        RETURN 0;
    END IF;

    -- Calcular los semestres
    SET semestres = añosContrato * 2;
    SET salario_total = precio_ca;
    SET i = 1;

    -- Bucle semestres
    WHILE i <= semestres DO
        SET salario_total = ROUND(salario_total + (precio_ca * 0.01));

        -- Si es un semestre par, se añade el aumento del precio de vida promedio
        IF i % 2 = 0 THEN
            SET salario_total = ROUND(salario_total + (precio_pais * 0.05));
        END IF;

        -- Cada 6 semestres, se añade un aumento del 3% al salario total
        IF i % 6 = 0 THEN
            SET salario_total = ROUND(salario_total + (salario_total * 0.03));
        END IF;

        SET i = i + 1;
    END WHILE;

    RETURN ROUND(salario_total, 2);
END $$

DELIMITER ;


-- Pruebas
SELECT calcular_salario("Majadahonda", 0); 
SELECT calcular_salario("Torrejon de Ardoz", 6);


-------------------------------------------------------------------------------------------------------

------------------------------------  Contratar -------------------------------------------------------

DELIMITER $$

CREATE OR REPLACE PROCEDURE contratar(
    nombre_emp VARCHAR(250),
    dni VARCHAR(9),
    localidad_emp VARCHAR(250),
    nacimiento DATE,
    telefono_emp INT,
    departamento VARCHAR(250),
    cargo VARCHAR(250)
)
BEGIN
    DECLARE existe_localidad VARCHAR(25) DEFAULT NULL;
    DECLARE existe_departamento VARCHAR(25) DEFAULT NULL;
    DECLARE codigo_postal VARCHAR(25);
    DECLARE salario_emp DOUBLE(10,5); 
    DECLARE edad INT;

    -- Verificar si la localidad existe
    SELECT localidad INTO existe_localidad 
    FROM localidades 
    WHERE localidad = localidad_emp COLLATE utf8mb4_unicode_ci;

    -- Verificar si el departamento existe
    SELECT dpto_code INTO existe_departamento 
    FROM dptos 
    WHERE dpto_code = departamento COLLATE utf8mb4_unicode_ci;

    -- Verificar la edad
    SET edad = TIMESTAMPDIFF(YEAR, nacimiento, NOW());

    IF edad < 18 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El empleado introducido es menor de edad, contrato cancelado.';
    ELSE
        IF existe_departamento IS NULL THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El departamento introducido no existe, contrato cancelado.';
        ELSE
            IF existe_localidad IS NULL THEN
                SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La localidad introducida no existe, contrato cancelado.';
            ELSE
                -- Obtener código postal y salario
                SELECT cp INTO codigo_postal FROM localidades WHERE localidad = localidad_emp COLLATE utf8mb4_unicode_ci;
                SELECT calcular_salario(localidad_emp, 0) INTO salario_emp;

                -- Insertar el empleado en la tabla de personal
                INSERT INTO personal(id, nombre, telefono, fecha_nacimiento, cp, fecha_contratacion, salario_bruto_anual, dpto_code, puesto)
                VALUES(dni, nombre_emp, telefono_emp, nacimiento, codigo_postal, NOW(), salario_emp, departamento, cargo);

            END IF;
        END IF;
    END IF;

END$$

DELIMITER ;


--Pruebas que funcionan
CALL contratar('Son Goku', '77722032H', 'Almeria', '1986-04-16', 987654321, 'comer', 'Embajador de los Guerreros Z');
CALL contratar('Naruto Uzumaki', '41270070C', 'Madrid', '1999-10-10', 612345678, 'finan', 'Tesorero Hokage');
CALL contratar('Monkey D. Luffy', '18917851Y', 'Oviedo', '1993-05-05', 634567890, 'infor', 'Capitán de los Piratas informáticos');
CALL contratar('Eren Yeager', '09715974S', 'Barcelona', '1995-03-30', 645678901, 'i+d+i', 'Explorador de la Humanidad');
CALL contratar('Usagi Tsukino', '29473783L', 'Pamplona/Iruna', '1992-06-30', 656789012, 'rrhh', 'Defensora de los trabajadores');

--Error Menor de edad
CALL contratar('Ash Ketchum', '42690527C', 'Almeria', '2010-05-22', 698765432, 'comer', 'Entrenador Pokémon');
--Error localidad no existe
CALL contratar('Vegeta', '80846935A', 'Planeta Vegeta', '1986-08-29', 609876543, 'finan', 'Príncipe de los Saiyajin');
--Departamento
CALL contratar('Yugi Muto', '26299110J', 'Oviedo', '1995-02-04', 620987654, 'Its time to duel', 'Maestro Duelista');




-------------------------------------------------------------------------------------------------------

------------------------------------  Despedir -------------------------------------------------------

DELIMITER $$

CREATE OR REPLACE PROCEDURE despedir(dni VARCHAR(15))
BEGIN
    DECLARE fecha_actual DATE;
    DECLARE dpto_original VARCHAR(100);
    DECLARE puesto_original VARCHAR(100);
    DECLARE salario_original DECIMAL(10, 2);
    DECLARE despedido DATE;

    -- Obtener la fecha actual
    SET fecha_actual = CURDATE();
    
    -- Verificar si el empleado ya ha sido despedido
    SELECT fecha_despido INTO despedido
    FROM personal
    WHERE id = dni;

    IF despedido IS NOT NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ya se ha despedido a ese empleado. Despido cancelado.';
    ELSE
        /* Obtener el departamento, puesto y salario original */
        SELECT dpto_destino, puesto_destino, salario_bruto_destino 
        INTO dpto_original, puesto_original, salario_original 
        FROM contratos 
        WHERE personal_id = dni COLLATE utf8mb4_unicode_ci
        LIMIT 1;  -- Seleccionamos solo el primer contrato si hay varios
        
        /* Actualizar los registros en personal */
        UPDATE personal
        SET fecha_despido = fecha_actual, salario_bruto_anual = 0, dpto_code = NULL, puesto = NULL
        WHERE id = dni COLLATE utf8mb4_unicode_ci;
    END IF;

END $$

DELIMITER ;

-------------------------------------------------------------------------------------------------------

------------------------------------  Cambiar -------------------------------------------------------

DELIMITER $$

CREATE OR REPLACE PROCEDURE cambiar(dni VARCHAR(9), puesto_nuevo VARCHAR(250), dpto_nuevo VARCHAR(250))
BEGIN
    DECLARE existe_empleado VARCHAR(250) DEFAULT NULL;
    DECLARE existe_dpto VARCHAR(250) DEFAULT NULL;

    -- Verificar si existe el empleado
    SELECT nombre INTO existe_empleado 
    FROM personal 
    WHERE id = dni 
      AND fecha_despido IS NULL
    LIMIT 1;

    -- Verificar si existe el departamento 
    SELECT nombre INTO existe_dpto 
    FROM dptos 
    WHERE dpto_code = dpto_nuevo 
    LIMIT 1;

    -- Si el empleado no existe
    IF existe_empleado IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No existe ningún empleado con el dni proporcionado.';
    END IF;

    -- Si el departamento no existe y se intenta cambiar de departamento
    IF dpto_nuevo IS NOT NULL AND existe_dpto IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No existe ningún departamento con el código de departamento proporcionado.';
    END IF;

    -- Si no se especifica ni puesto ni departamento
    IF puesto_nuevo IS NULL AND dpto_nuevo IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Debes de especificar al menos un puesto nuevo.';
    END IF;

    -- Si se proporciona un departamento pero no un puesto, se lanza un error
    IF dpto_nuevo IS NOT NULL AND puesto_nuevo IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Si cambias de departamento, debes especificar un puesto nuevo.';
    END IF;

    -- Si el departamento se cambia, se debe cambiar también el puesto
    IF dpto_nuevo IS NOT NULL THEN
        -- Si se cambia el departamento, actualizar el puesto también
        IF puesto_nuevo IS NOT NULL THEN
            -- Actualizar la tabla personal con el nuevo puesto y departamento
            UPDATE personal
            SET puesto = puesto_nuevo, dpto_code = dpto_nuevo
            WHERE id = dni COLLATE utf8mb4_unicode_ci;
        ELSE
            -- Si solo se cambia el departamento pero no el puesto
            UPDATE personal
            SET dpto_code = dpto_nuevo
            WHERE id = dni COLLATE utf8mb4_unicode_ci;
        END IF;
    ELSE
        -- Si solo se cambia el puesto pero no el departamento
        IF puesto_nuevo IS NOT NULL THEN
            -- Actualizar solo la tabla personal para el puesto
            UPDATE personal
            SET puesto = puesto_nuevo
            WHERE id = dni COLLATE utf8mb4_unicode_ci;
        END IF;
    END IF;

END $$

DELIMITER ;




--Hay cuatro casos de error: 
--Cuando no se especifica ni puesto ni departamento
CALL cambiar('09715974S', NULL, NULL);
--Cuando el DNI no existe
CALL cambiar('202122', "Vendedor", "Comer");
--Cuando el departamento no existe
CALL cambiar('09715974S', "Genocida Profesional", "SNK");
--Cuando se indica un departamento pero no un puesto nuevo
CALL cambiar('09715974S', NULL, "infor");

--Casos de prueba que funcionan:
--Cambiar de puesto pero no de departamento
CALL cambiar('29473783L', "Miembro del team rocket xd", NULL);
--Cambiar de puesto y de departamento
CALL cambiar('18917851Y', "Youtuber", "infor");




-------------------------------------------------------------------------------------------------------

------------------------------------  Calcular impuestos  -------------------------------------------------------
DELIMITER $$

CREATE OR REPLACE FUNCTION calcularImpuestos(salarioNeto INT)
RETURNS DOUBLE
BEGIN
    DECLARE deuda DOUBLE DEFAULT 0;
    DECLARE salario_actual INT DEFAULT salarioNeto;

    -- Primer tramo (hasta 12450€ a 19%)
    IF salario_actual <= 12450 THEN
        SET deuda = deuda + (salario_actual * 0.19);
    ELSE
        SET deuda = deuda + (12450 * 0.19);
        SET salario_actual = salario_actual - 12450;

        -- Segundo tramo (de 12450€ a 20200€ a 24%)
        IF salario_actual <= 7750 THEN
            SET deuda = deuda + (salario_actual * 0.24);
        ELSE
            SET deuda = deuda + (7750 * 0.24);
            SET salario_actual = salario_actual - 7750;

            -- Tercer tramo (de 20200€ a 35200€ a 30%)
            IF salario_actual <= 15000 THEN
                SET deuda = deuda + (salario_actual * 0.30);
            ELSE
                SET deuda = deuda + (15000 * 0.30);
                SET salario_actual = salario_actual - 15000;

                -- Cuarto tramo (de 35200€ a 60000€ a 37%)
                IF salario_actual <= 24800 THEN
                    SET deuda = deuda + (salario_actual * 0.37);
                ELSE
                    SET deuda = deuda + (24800 * 0.37);
                    SET salario_actual = salario_actual - 24800;

                    -- Quinto tramo (más de 60000€ a 47%)
                    SET deuda = deuda + (salario_actual * 0.47);
                END IF;
            END IF;
        END IF;
    END IF;

    RETURN deuda;
END $$

DELIMITER ;

--Pruebas para cada tramo
--tramo 1:
SELECT calcularImpuestos(12450);
--tramo 2:
SELECT calcularImpuestos(15000);
--tramo 3:
SELECT calcularImpuestos(25000);
--tramo 4:
SELECT calcularImpuestos(45000);
--tramo 5:
SELECT calcularImpuestos(66600);

-------------------------------------------------------------------------------------------------------

------------------------------------  Actualizar salarios  -------------------------------------------------------
--Crearé una columna nueva en personal que guarde la fecha de la última modificación salarial
ALTER TABLE personal
ADD COLUMN fecha_ultima_actualizacion_salario DATE DEFAULT NULL;

DELIMITER $$

CREATE OR REPLACE PROCEDURE actualizar_salarios()
BEGIN
    DECLARE salario_actual DECIMAL(10, 2);
    DECLARE salario_nuevo DECIMAL(10, 2);
    DECLARE dni_emp VARCHAR(9);
    DECLARE localidad_emp VARCHAR(250);
    DECLARE fecha_ultima_actualizacion DATE;
    DECLARE fecha_contratacion DATE;
    DECLARE años_contratado INT;
    DECLARE salir INT DEFAULT 0;

    -- Cursor para obtener los empleados con su salario y la fecha de última actualización
    DECLARE empleados_cursor CURSOR FOR 
    SELECT p.id, p.salario_bruto_anual, p.fecha_ultima_actualizacion_salario, p.cp, p.fecha_contratacion
    FROM personal p
    WHERE (p.fecha_ultima_actualizacion_salario IS NULL 
           OR TIMESTAMPDIFF(MONTH, p.fecha_ultima_actualizacion_salario, CURDATE()) > 6)
      AND p.fecha_despido IS NULL;

    -- Controlador para cuando no haya más empleados
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET salir = 1;

    OPEN empleados_cursor;

    actualizar_salarios_loop: LOOP
        FETCH empleados_cursor INTO dni_emp, salario_actual, fecha_ultima_actualizacion, localidad_emp, fecha_contratacion;

        -- Salir del bucle si no hay más empleados
        IF salir THEN
            LEAVE actualizar_salarios_loop;
        END IF;

        -- Obtener el nombre de la localidad a partir del código postal
        SELECT l.localidad
        INTO localidad_emp
        FROM localidades l
        INNER JOIN personal p ON l.cp = p.cp 
        WHERE l.cp = localidad_emp
        LIMIT 1;

        -- Calcular los años contratados
        SET años_contratado = TIMESTAMPDIFF(YEAR, fecha_contratacion, NOW());

        -- Llamar a la función calcular_salario para obtener el nuevo salario
        SET salario_nuevo = calcular_salario(localidad_emp, años_contratado);

        -- Actualizar el salario en la tabla de empleados
        UPDATE personal
        SET salario_bruto_anual = salario_nuevo, 
            fecha_ultima_actualizacion_salario = NOW()
        WHERE id = dni_emp;

    END LOOP actualizar_salarios_loop;

    CLOSE empleados_cursor;
END $$

DELIMITER ;




update personal set fecha_ultima_actualizacion_salario = "2000-01-01";
update personal set salario_bruto_anual = 1000;
CALL actualizar_salarios();


-------------------------------------------------------------------------------------------------------

------------------------------------  Resumen  -------------------------------------------------------



-------------------------------------------------------------------------------------------------------

------------------------------------  Trigger actualizar_contratos  -------------------------------------------------------
DELIMITER $$

CREATE OR REPLACE TRIGGER actualizar_contratos
BEFORE UPDATE ON personal
FOR EACH ROW
BEGIN
    DECLARE existe_registro INT DEFAULT 0;

  
    SELECT COUNT(*) INTO existe_registro
    FROM contratos
    WHERE personal_id = OLD.id AND fecha = CURDATE();

    
    IF existe_registro > 0 THEN
        UPDATE contratos
        SET 
            salario_bruto_origen = IF(OLD.salario_bruto_anual <> NEW.salario_bruto_anual AND NEW.salario_bruto_anual IS NOT NULL, OLD.salario_bruto_anual, salario_bruto_origen),
            puesto_origen = IF(OLD.puesto <> NEW.puesto AND NEW.puesto IS NOT NULL, OLD.puesto, puesto_origen),
            dpto_origen = IF(OLD.dpto_code <> NEW.dpto_code AND NEW.dpto_code IS NOT NULL, OLD.dpto_code, dpto_origen),
            dpto_destino = IF(OLD.dpto_code <> NEW.dpto_code AND NEW.dpto_code IS NOT NULL, NEW.dpto_code, dpto_destino),
            puesto_destino = IF(OLD.puesto <> NEW.puesto AND NEW.puesto IS NOT NULL, NEW.puesto, puesto_destino),
            salario_bruto_destino = IF(OLD.salario_bruto_anual <> NEW.salario_bruto_anual AND NEW.salario_bruto_anual IS NOT NULL, NEW.salario_bruto_anual, salario_bruto_destino)
        WHERE personal_id = OLD.id AND fecha = CURDATE();
    
    ELSE
        INSERT INTO contratos (
            fecha, personal_id, 
            dpto_origen, dpto_destino, 
            puesto_origen, puesto_destino, 
            salario_bruto_origen, salario_bruto_destino
        )
        VALUES (
            CURDATE(), OLD.id, 
            OLD.dpto_code, NEW.dpto_code, 
            OLD.puesto, NEW.puesto, 
            OLD.salario_bruto_anual, NEW.salario_bruto_anual
        );
    END IF;
    
END$$

DELIMITER ;


------------------------------------------------------------------------------------------------------------------------

------------------------------------  Trigger insertar contrato  -------------------------------------------------------

DELIMITER $$

CREATE TRIGGER insertar_contrato
AFTER INSERT ON personal
FOR EACH ROW
BEGIN
    INSERT INTO contratos (
        fecha, personal_id, dpto_origen, dpto_destino, puesto_origen, puesto_destino, salario_bruto_origen,
        salario_bruto_destino
    )
    VALUES (CURDATE(),NEW.id,NULL,NEW.dpto_code,NULL,NEW.puesto,NULL,NEW.salario_bruto_anual
    );
END$$

DELIMITER ;


UPDATE personal SET salario_bruto_anual = 50000, puesto="hola" WHERE id = '28924640R';


SELECT *
FROM contratos
WHERE fecha = CURDATE();


UPDATE personal SET salario_bruto_anual = 5000006 WHERE id = '28924640R';
CALL cambiar('28924640R', 'Especialista en Marketing', NULL);

SELECT *
FROM contratos
WHERE fecha = CURDATE();












+------------------------------------------------+-------------------+
|                   Tarea                        | Completado (✔/✘)  |
+------------------------------------------------+-------------------+
| 1. Crear procedimiento "contratar"              |        ✔          |
| 2. Crear procedimiento "despedir"               |        ✔          |
| 3. Crear procedimiento "cambiar"                |        ✔          |
| 4. Crear procedimiento "actualizar_salarios"    |        ✔          |
| 5. Crear función "calcular_impuestos"           |        ✔          |
| 6. Crear función "calcular_salario"             |        ✔          |
| 7. Crear función "resumen"                      |                   |
| 8. Crear triggers para actualizaciones en       |                   |
|    salario, puesto y departamento               |                   |
+------------------------------------------------+-------------------+

--28/03/2025 
--Procedimiento despedir terminado
--Procedimiento cambiar empezado y terminado
--**Hay que cambiar los errores de contratar/despedir/calcular_salario para que funcionen con signal**
--**Hay que corregir calcular_salario**

--31/03/2025
--Corregido calcular_salario
--Cambiados los errores de contratar/despedir para que funcione con signal en vez de un select
--Empezado calcular impuestos
--Terminado calcular impuestos
--Empezado actualizar salarios
--Terminado actualizar_salarios
--Empezado resumen

--01/04/2025
--Resumen dejado en pausa
--Empezados los triggers
--"Reparado" el procedimiento cambiar después de hacer el primer trigger
--"Reparado" el procedimiento actualizar_salarios después de hacer el primer trigger
--"Reparado" el procedimiento despedir después de hacer el primer trigger
--Los triggers han roto el procedimiento cambiar para cuando se cambia de puesto y departamento

--04/04/2025
--Empezado los triggers desde cero
--Los triggers siguen sin funcionar
--El trigger solo funciona para una cosa en caso de varios cambios (por ejemplo si se cambia dpto y puesto solo guarda dpto)

--07/04/2025
--Empezado el trigger desde cero otra vez
--He descubierto un fallo al actualizarSalarios, hace que todos los salarios actualizados tengan el mismo valor
--"Terminado el trigger de actualizar personal"

--08/04/2025
-- No funciona actualizar_salarios XD, otra vez a corregirlo
--Corregido en principio actualizar_salarios
-- Creado y terminado el trigger insertar_contrato
--Modificado actualizar-salarios y cambiar para que no actúe sobre empleados despedidos






