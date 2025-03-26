--En las funciones no puedes modificar datos
--Los procedimientos si que modifican datos
DELIMITER $$
CREATE OR REPLACE FUNCTION insertar_cosas(nombre VARCHAR(250)) RETURNS VARCHAR(250)
DETERMINISTIC
BEGIN
    INSERT INTO movies(title) VALUES(nombre);
    RETURN nombre;
END $$

DELIMITER ;
--4 posibles resultados(deterministic o nondeterministic)

--Que diga si la fecha pasada por parámetro se corresponde con aries,acuario...
DELIMITER $$

CREATE OR REPLACE FUNCTION sf_horoscopo(birthday DATE) RETURNS VARCHAR(15)
DETERMINISTIC
BEGIN
    DECLARE signo VARCHAR(15);

    CASE 
        WHEN (MONTH(birthday) = 1 AND DAY(birthday) >= 20) OR (MONTH(birthday) = 2 AND DAY(birthday) <= 18) THEN SET signo = 'Aquarius';
        WHEN (MONTH(birthday) = 2 AND DAY(birthday) >= 19) OR (MONTH(birthday) = 3 AND DAY(birthday) <= 20) THEN SET signo = 'Pisces';
        WHEN (MONTH(birthday) = 3 AND DAY(birthday) >= 21) OR (MONTH(birthday) = 4 AND DAY(birthday) <= 19) THEN SET signo = 'Aries';
        WHEN (MONTH(birthday) = 4 AND DAY(birthday) >= 20) OR (MONTH(birthday) = 5 AND DAY(birthday) <= 20) THEN SET signo = 'Taurus';
        WHEN (MONTH(birthday) = 5 AND DAY(birthday) >= 21) OR (MONTH(birthday) = 6 AND DAY(birthday) <= 20) THEN SET signo = 'Gemini';
        WHEN (MONTH(birthday) = 6 AND DAY(birthday) >= 21) OR (MONTH(birthday) = 7 AND DAY(birthday) <= 22) THEN SET signo = 'Cancer';
        WHEN (MONTH(birthday) = 7 AND DAY(birthday) >= 23) OR (MONTH(birthday) = 8 AND DAY(birthday) <= 22) THEN SET signo = 'Leo';
        WHEN (MONTH(birthday) = 8 AND DAY(birthday) >= 23) OR (MONTH(birthday) = 9 AND DAY(birthday) <= 22) THEN SET signo = 'Virgo';
        WHEN (MONTH(birthday) = 9 AND DAY(birthday) >= 23) OR (MONTH(birthday) = 10 AND DAY(birthday) <= 22) THEN SET signo = 'Libra';
        WHEN (MONTH(birthday) = 10 AND DAY(birthday) >= 23) OR (MONTH(birthday) = 11 AND DAY(birthday) <= 21) THEN SET signo = 'Scorpio';
        WHEN (MONTH(birthday) = 11 AND DAY(birthday) >= 22) OR (MONTH(birthday) = 12 AND DAY(birthday) <= 21) THEN SET signo = 'Sagittarius';
        WHEN (MONTH(birthday) = 12 AND DAY(birthday) >= 22) OR (MONTH(birthday) = 1 AND DAY(birthday) <= 19) THEN SET signo = 'Capricorn';
        ELSE SET signo = 'Unknown';
    END CASE;

    RETURN signo;
END $$

DELIMITER ;

SELECT sf_horoscopo('2004-09-14') SIGNO;

--Sin usar year() devuelve el año de una fecha
DELIMITER $$
CREATE OR REPLACE FUNCTION sf_anio(fecha DATE) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE anio INT;
    SET anio = SUBSTR(fecha,1,4);
    RETURN anio;
END $$
DELIMITER ;

SELECT sf_anio('2004-09-14');

--Recibe dos valores retorna la diferencia sf_diff 
DELIMITER $$
CREATE OR REPLACE FUNCTION sf_diff(param1 INT, param2 INT) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE result INT;
    SET result = param1 - param2;
    RETURN result;
END $$
DELIMITER ;

SELECT sf_diff(2,4);

--Recibe una fecha y retorna la edad que tiene año
DELIMITER $$
CREATE OR REPLACE FUNCTION sf_dateDiff(fecha DATE) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE result INT;
    SET result = TIMESTAMPDIFF(YEAR, fecha, NOW());
    RETURN result;
END $$

DELIMITER ;

SELECT sf_dateDiff('2004-09-14');


