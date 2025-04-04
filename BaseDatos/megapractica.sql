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
    WHERE l.localidad = localidadContrato COLLATE utf8mb4_unicode_ci;

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



CALL despedir('63416856Z');





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
    WHERE id = dni COLLATE utf8mb4_unicode_ci 
    LIMIT 1;

    -- Verificar si existe el departamento 
    SELECT nombre INTO existe_dpto 
    FROM dptos 
    WHERE dpto_code = dpto_nuevo COLLATE utf8mb4_unicode_ci 
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
    DECLARE done INT DEFAULT 0;

    -- Cursor para obtener los empleados con su salario y la fecha de última actualización
    DECLARE empleados_cursor CURSOR FOR 
        SELECT id, salario_bruto_anual, fecha_ultima_actualizacion_salario, cp, fecha_contratacion
        FROM personal
        WHERE fecha_ultima_actualizacion_salario IS NULL
           OR DATEDIFF(NOW(), fecha_ultima_actualizacion_salario) > 180;

    -- Controlador para cuando no haya más empleados
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN empleados_cursor;

    actualizar_salarios_loop: LOOP
        FETCH empleados_cursor INTO dni_emp, salario_actual, fecha_ultima_actualizacion, localidad_emp, fecha_contratacion;

        -- Salir del bucle si no hay más empleados
        IF done THEN
            LEAVE actualizar_salarios_loop;
        END IF;

        -- Obtener el nombre de la localidad a partir del código postal
        SELECT localidad
        INTO localidad_emp
        FROM localidades
        WHERE cp COLLATE utf8mb4_general_ci = localidad_emp COLLATE utf8mb4_general_ci
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


CALL actualizar_salarios();

-------------------------------------------------------------------------------------------------------

------------------------------------  Resumen  -------------------------------------------------------



-------------------------------------------------------------------------------------------------------

------------------------------------  Triggers  -------------------------------------------------------
--He creado una tabla logs
CREATE OR REPLACE TABLE logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensaje VARCHAR(250) NOT NULL,
    fecha TIMESTAMP DEFAULT NOW(),
    campo_afectado VARCHAR(250),
    dni VARCHAR(9)
);

-- Creación del trigger para registrar cambios
DELIMITER $$

CREATE OR REPLACE TRIGGER tg_actualizar_personal
AFTER UPDATE ON personal
FOR EACH ROW
BEGIN
    -- Comprobar si el salario ha cambiado
    IF OLD.salario_bruto_anual != NEW.salario_bruto_anual OR NEW.salario_bruto_anual = 0 THEN
        -- Comprobar si ya existe un log de salario hoy para este empleado
        IF NOT EXISTS (
            SELECT 1
            FROM logs
            WHERE dni = NEW.id AND campo_afectado = 'salario' AND DATE(fecha) = CURRENT_DATE
        ) THEN
            -- Insertar en contratos (si el salario cambió)
            INSERT INTO contratos (fecha, personal_id, dpto_origen, dpto_destino, puesto_origen, puesto_destino, salario_bruto_origen, salario_bruto_destino)
            VALUES (NOW(), NEW.id, OLD.dpto_code, NEW.dpto_code, OLD.puesto, NEW.puesto, OLD.salario_bruto_anual, NEW.salario_bruto_anual);

            -- Insertar log de cambio de salario
            INSERT INTO logs (mensaje, campo_afectado, dni)
            VALUES (CONCAT('Salario actualizado de ', IFNULL(OLD.salario_bruto_anual, 'desconocido'), ' a ', IFNULL(NEW.salario_bruto_anual, 'desconocido')), 'salario', NEW.id);
        END IF;
    END IF;

    -- Comprobar si el puesto ha cambiado
    IF (OLD.puesto IS NULL AND NEW.puesto IS NOT NULL) OR (OLD.puesto IS NOT NULL AND NEW.puesto IS NULL) OR OLD.puesto != NEW.puesto THEN
        -- Comprobar si ya existe un log de puesto hoy para este empleado
        IF NOT EXISTS (
            SELECT 1
            FROM logs
            WHERE dni = NEW.id AND campo_afectado = 'puesto' AND DATE(fecha) = CURRENT_DATE
        ) THEN
            -- Insertar en contratos (si el puesto cambió)
            INSERT INTO contratos (fecha, personal_id, dpto_origen, dpto_destino, puesto_origen, puesto_destino, salario_bruto_origen, salario_bruto_destino)
            VALUES (NOW(), NEW.id, OLD.dpto_code, NEW.dpto_code, OLD.puesto, NEW.puesto, OLD.salario_bruto_anual, NEW.salario_bruto_anual);

            -- Insertar log de cambio de puesto
            INSERT INTO logs (mensaje, campo_afectado, dni)
            VALUES (CONCAT('Puesto actualizado de ', IFNULL(OLD.puesto, 'desconocido'), ' a ', IFNULL(NEW.puesto, 'desconocido')), 'puesto', NEW.id);
        END IF;
    END IF;

    -- Comprobar si el departamento ha cambiado
    IF (OLD.dpto_code IS NULL AND NEW.dpto_code IS NOT NULL) OR (OLD.dpto_code IS NOT NULL AND NEW.dpto_code IS NULL) OR OLD.dpto_code != NEW.dpto_code THEN
        -- Comprobar si ya existe un log de departamento hoy para este empleado
        IF NOT EXISTS (
            SELECT 1
            FROM logs
            WHERE dni = NEW.id AND campo_afectado = 'dpto' AND DATE(fecha) = CURRENT_DATE
        ) THEN
            -- Insertar en contratos (si el departamento cambió)
            INSERT INTO contratos (fecha, personal_id, dpto_origen, dpto_destino, puesto_origen, puesto_destino, salario_bruto_origen, salario_bruto_destino)
            VALUES (NOW(), NEW.id, OLD.dpto_code, NEW.dpto_code, OLD.puesto, NEW.puesto, OLD.salario_bruto_anual, NEW.salario_bruto_anual);

            -- Insertar log de cambio de departamento
            INSERT INTO logs (mensaje, campo_afectado, dni)
            VALUES (CONCAT('Departamento actualizado de ', IFNULL(OLD.dpto_code, 'desconocido'), ' a ', IFNULL(NEW.dpto_code, 'desconocido')), 'dpto', NEW.id);
        END IF;
    END IF;

END $$

DELIMITER ;









-- Creamos un nuevo empleado
CALL contratar('Gandalf el Gris', '12345678A', 'Madrid', '1980-05-15', 654321987, 'i+d+i', 'Mago Supremo');
-- Cambiamos el puesto del empleado "Gandalf el Gris" a "Consejero Supremo"
CALL cambiar('12345678A', 'Consejero Supremo', NULL);
CALL cambiar('12345678A', 'Gran Consejero', 'rrhh');


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
--Terminado actualizar salarios
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








