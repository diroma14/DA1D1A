CREATE PROCEDURE ejemplo_cursor()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_nombre VARCHAR(100);  -- Variable para almacenar datos del cursor

    DECLARE cur CURSOR FOR  --Declarar cursor
        SELECT nombre FROM empleados;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE; -- Manejo de fin de datos

    OPEN cur; -- Abrir el cursor

    bucle: LOOP
        FETCH cur INTO v_nombre; -- Obtener el siguiente registro
        IF done THEN
            LEAVE bucle;
        END IF;
    END LOOP;
    CLOSE cur; -- Cerrar cu
END$$