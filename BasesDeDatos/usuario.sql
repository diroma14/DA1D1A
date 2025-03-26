
CREATE USER 'casuario'@'localhost' IDENTIFIED BY 'contraseña';
DROP USER 'casuario'@'localhost';

GRANT CREATE,DROP,ALTER,GRANT ON *.* TO 'casuario'@'localhost';
GRANT ALL PRIVILEGES ON editorial.* TO 'casuario'@'localhost'; -- All privileges no incluye GRANT --
GRANT ALL PRIVILEGES ON editorial.* TO 'casuario'@'localhost' WITH GRANT PRIVILEGES;

CREATE USER 'joel'@'localhost' IDENTIFIED BY '1234';
SHOW GRANTS FOR 'joel'@'localhost';

ALTER USER 'joel'@'localhost' IDENTIFIED BY '1234';

REVOKE DROP ON *.* FROM 'joel'@'localhost';

FLUSH PRIVILEGES;

--------------------------------------------------------------------------------------------------------
ALTER USER 'root'@'localhost' IDENTIFIED BY '1234';

CREATE USER 'user'@'localhost' IDENTIFIED BY '1234';

GRANT CREATE, INSERT, SELECT ON test.* TO 'user'@'localhost';
GRANT CREATE, INSERT, SELECT ON tmdb.* TO 'user'@'localhost';

SHOW GRANTS FOR 'user'@'localhost';

USE tmdb;
SELECT * FROM movies;

CREATE TABLE prueba(
    id SERIAL PRIMARY KEY,
    texto VARCHAR(20)
);

DROP TABLE prueba;

REVOKE CREATE ON *.* FROM 'user'@'localhost';
