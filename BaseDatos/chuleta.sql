---Cursores

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
    CLOSE cur; -- Cerrar cursor
END$$



--Triggers

CREATE TRIGGER tg_insert_empleado
    AFTER INSERT ON empleados
    FOR EACH ROW
BEGIN
    INSERT INTO logs(mensaje) 
    VALUES (CONCAT("Nuevo empleado agregado: ", NEW.nombre));
END$$



--Funciones (Devuelve 1 valor)

CREATE FUNCTION calcular_salario_neto(salario DECIMAL(10,2), impuestos DECIMAL(5,2))
DETERMINISTIC
BEGIN
    RETURN salario - (salario * impuestos / 100);
END$$

SELECT calcular_salario_neto(3000, 15) AS salario_neto;



--Procedimientos 

CREATE PROCEDURE aumentar_sueldo(IN empleado_id INT, IN porcentaje DECIMAL(5,2))
BEGIN
    UPDATE empleados
    SET salario = salario + (salario * porcentaje / 100)
    WHERE id = empleado_id;
END$$

CALL aumentar_sueldo(5, 10);
