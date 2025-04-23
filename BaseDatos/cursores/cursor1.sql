--Crea una función que cacule la suma total de las edades de todas las personas que están muertas y que han estado en algún momento vivas
DELIMITER $$

CREATE FUNCTION sumaEdad()
RETURNS INT READS SQL DATA 
BEGIN

    DECLARE finalizar BOOLEAN DEFAULT FALSE;
    DECLARE suma INT DEFAULT 0;
    DECLARE edad INT DEFAULT 0;

    DECLARE cur1 CURSOR FOR 
    SELECT TIMESTAMPDIFF(YEAR, birthday, deathday) 
    FROM people 
    WHERE birthday IS NOT NULL AND deathday IS NOT NULL;

    DECLARE CONTINUE HANDLER FOR NOT FOUND 
    SET finalizar = TRUE;

    OPEN cur1;

    l_curl1: LOOP
        FETCH cur1 INTO edad;
        IF finalizar THEN 
            LEAVE l_curl1;
        END IF;
        SET suma = suma + edad;
    END LOOP;

    CLOSE cur1;

    RETURN suma;
END$$

DELIMITER ;

SELECT sumaEdad();