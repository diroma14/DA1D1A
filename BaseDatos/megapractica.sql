----------------------------------Calcular salario-----------------------------------------------------

DELIMITER $$

CREATE OR REPLACE FUNCTION calcular_salario(localidadContrato VARCHAR(250), añosContrato INT)
RETURNS DOUBLE
BEGIN
    DECLARE existe_localidad VARCHAR(25) DEFAULT NULL;
    DECLARE salario DOUBLE(10,5);
    DECLARE pVidaComunidad DOUBLE(10,5);
    DECLARE semestres INT;
    DECLARE media DOUBLE(10,5);
    DECLARE i INT;

    -- Verificar si la localidad existe
    SELECT localidad INTO existe_localidad 
    FROM localidades 
    WHERE localidad = localidadContrato COLLATE utf8mb4_unicode_ci;

    IF añosContrato < 0 OR existe_localidad IS NULL THEN
        SET salario = 0;
    ELSE
        -- Obtener el precio de vida de la comunidad
        SELECT precio_vida INTO pVidaComunidad 
        FROM comunidades_autonomas 
        WHERE ca = (SELECT ca FROM localidades WHERE localidad = localidadContrato COLLATE utf8mb4_unicode_ci);

        -- Obtener la media del precio de vida
        SELECT AVG(precio_vida) INTO media FROM comunidades_autonomas;

        -- Asignar el salario inicial
        SET salario = pVidaComunidad;

        -- Calcular semestres
        SET semestres = añosContrato * 2;

        -- Bucle semestres
        SET i = semestres;
        WHILE i > 0 DO
            SET salario = salario + pVidaComunidad * 0.01;
            SET i = i - 1;
        END WHILE;

        -- Bucle años
        SET i = añosContrato;
        WHILE i > 0 DO
            SET salario = salario + media * 0.05;
            SET i = i - 1;
        END WHILE;

        -- Bucle trienios 
        SET i = FLOOR(añosContrato / 3);  -- Redondear hacia abajo
        WHILE i > 0 DO
            SET salario = salario + salario * 0.03;
            SET i = i - 1;
        END WHILE;

    END IF;

    
    RETURN ROUND(salario);
END$$

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
        SELECT"El empleado introducido es menor de edad, contrato cancelado." as Error ;
    ELSE
        IF existe_departamento IS NULL THEN
            SELECT"El departamento introducido no existe, contrato cancelado." as Error ;
        ELSE
            IF existe_localidad IS NULL THEN
                SELECT'La localidad introducida no existe, contrato cancelado.' as Error ;
            ELSE
                -- Obtener código postal y salario
                SELECT cp INTO codigo_postal FROM localidades WHERE localidad = localidad_emp COLLATE utf8mb4_unicode_ci;
                SELECT calcular_salario(localidad_emp, 0) INTO salario_emp;

                -- Insertar el empleado en la tabla de personal
                INSERT INTO personal(id, nombre, telefono, fecha_nacimiento, cp, fecha_contratacion, salario_bruto_anual, dpto_code, puesto)
                VALUES(dni, nombre_emp, telefono_emp, nacimiento, codigo_postal, NOW(), salario_emp, departamento, cargo);

                -- Insertar contrato
                INSERT INTO contratos(fecha, personal_id, dpto_origen, dpto_destino, puesto_origen, puesto_destino, salario_bruto_origen, salario_bruto_destino)
                VALUES(NOW(), dni, NULL, departamento, NULL, cargo, NULL, salario_emp);
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

------------------------------------  Contratar -------------------------------------------------------

DELIMITER $$

CREATE OR REPLACE PROCEDURE despedir(dni VARCHAR(9))
BEGIN
    DECLARE despedido DATE DEFAULT NULL;
    DECLARE contratado VARCHAR(9) DEFAULT NULL;
    DECLARE dpto_original VARCHAR(250);
    DECLARE puesto_original VARCHAR(250);
    DECLARE salario_original DOUBLE(10,5);

    /* Verificar si está contratado */
    SELECT id INTO contratado 
    FROM personal 
    WHERE id = dni COLLATE utf8mb4_unicode_ci;

    /* Verificar si no está despedido */
    SELECT fecha_despido INTO despedido 
    FROM personal 
    WHERE id = dni COLLATE utf8mb4_unicode_ci;

    IF contratado IS NULL THEN
        SELECT 'No hay ningún empleado con el dni que has introducido. Despido cancelado.' as Error;
    ELSE
        IF despedido IS NOT NULL THEN
            SELECT 'Ya se ha despedido a ese empleado. Despido cancelado.' as Error;
        ELSE
            /* Obtener el departamento, puesto y salario original */
            SELECT dpto_destino, puesto_destino, salario_bruto_destino 
            INTO dpto_original, puesto_original, salario_original 
            FROM contratos 
            WHERE personal_id = dni COLLATE utf8mb4_unicode_ci;

            /* Actualizar los registros en personal */
            UPDATE personal
            SET fecha_despido = NOW(), salario_bruto_anual = 0, dpto_code = NULL, puesto = NULL
            WHERE id = dni COLLATE utf8mb4_unicode_ci;

            /* Actualizar los contratos */
            UPDATE contratos
            SET fecha = NOW(), 
                dpto_origen = dpto_original, 
                dpto_destino = NULL, 
                puesto_origen = puesto_original, 
                puesto_destino = NULL, 
                salario_bruto_origen = salario_original, 
                salario_bruto_destino = NULL
            WHERE personal_id = dni COLLATE utf8mb4_unicode_ci;
        END IF;
    END IF;
END$$

DELIMITER ;

CALL despedir('23456789B');


-------------------------------------------------------------------------------------------------------

------------------------------------  Cambiar -------------------------------------------------------

DELIMITER $$

CREATE OR REPLACE PROCEDURE cambiar(dni VARCHAR(9), puesto_nuevo VARCHAR(250), dpto_nuevo VARCHAR(250))
BEGIN
    DECLARE existe_empleado VARCHAR(250) DEFAULT NULL;
    DECLARE existe_dpto VARCHAR(250) DEFAULT NULL;
    DECLARE dpto_original VARCHAR(250);
    DECLARE puesto_original VARCHAR(250);

    -- Verificar si existe el empleado
    SELECT nombre INTO existe_empleado FROM personal WHERE id = dni COLLATE utf8mb4_unicode_ci;
    
    -- Verificar si existe el departamento
    SELECT nombre INTO existe_dpto FROM dptos WHERE dpto_code = dpto_nuevo COLLATE utf8mb4_unicode_ci;

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
        -- Obtener el departamento y puesto original del contrato
        SELECT dpto_destino, puesto_destino 
        INTO dpto_original, puesto_original
        FROM contratos 
        WHERE personal_id = dni COLLATE utf8mb4_unicode_ci;

        -- Si existe un departamento nuevo y puesto nuevo, se actualizan ambos
        IF puesto_nuevo IS NOT NULL THEN
            -- Actualizar contratos con el nuevo puesto y departamento
            UPDATE contratos
            SET fecha = NOW(),
                dpto_origen = dpto_original, 
                dpto_destino = dpto_nuevo, 
                puesto_origen = puesto_original, 
                puesto_destino = puesto_nuevo
            WHERE personal_id = dni COLLATE utf8mb4_unicode_ci;
        ELSE
            -- Si solo se cambia el departamento pero no el puesto
            UPDATE contratos
            SET fecha = NOW(),
                dpto_origen = dpto_original, 
                dpto_destino = dpto_nuevo
            WHERE personal_id = dni COLLATE utf8mb4_unicode_ci;
        END IF;

        -- Actualizar la tabla personal
        UPDATE personal
        SET puesto = puesto_nuevo, dpto_code = dpto_nuevo
        WHERE id = dni COLLATE utf8mb4_unicode_ci;

    ELSE
        -- Si solo se cambia el puesto pero no el departamento
        IF puesto_nuevo IS NOT NULL THEN
            -- Obtener el puesto original del contrato
            SELECT puesto_destino 
            INTO puesto_original
            FROM contratos 
            WHERE personal_id = dni COLLATE utf8mb4_unicode_ci;

            -- Actualizar contratos con el nuevo puesto
            UPDATE contratos
            SET fecha = NOW(),
                puesto_origen = puesto_original, 
                puesto_destino = puesto_nuevo
            WHERE personal_id = dni COLLATE utf8mb4_unicode_ci;

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
CALL cambiar('29473783L', "Miembro del team rocket", NULL);
--Cambiar de puesto y de departamento
CALL cambiar('18917851Y', "Vendedor de frutas del diablo", "comer");



+------------------------------------------------+-------------------+
|                   Tarea                        | Completado (✔/✘)  |
+------------------------------------------------+-------------------+
| 1. Crear procedimiento "contratar"              |        ✔          |
| 2. Crear procedimiento "despedir"               |        ✔          |
| 3. Crear procedimiento "cambiar"                |        ✔          |
| 4. Crear procedimiento "actualizar_salarios"    |                   |
| 5. Crear función "calcular_impuestos"           |                   |
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




