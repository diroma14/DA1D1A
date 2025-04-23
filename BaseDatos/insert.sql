CREATE DATABASE ejemplo_dml;

USE ejemplo_dml;

CREATE TABLE especies_animales(
    nombre VARCHAR(50)
);

INSERT INTO especies_animales VALUES ("gato"),("perro");
INSERT INTO especies_animales VALUES ("caballo");

ALTER TABLE especies_animales MODIFY nombre VARCHAR(50) NOT NULL UNIQUE;

DELETE FROM especies_animales WHERE nombre = "gato";
DELETE FROM especies_animales WHERE nombre IS NULL;

UPDATE FROM especies_animales SET nombre='rata' WHERE nombre='';




CREATE TABLE nominas(
    ID SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    salario INT NOT NULL,
    fecha DATE NOT NULL
);

INSERT INTO nominas VALUES(3,'El que sea',1134,"2024-11-25");

INSERT INTO nominas(nombre, salario, fecha) VALUES('El que sea otra vez',1134,"2024-11-25");

INSERT INTO nominas(nombre, fecha, salario) VALUES('El que sea de nuevo',"2024-11-25",1134);

UPDATE nominas SET fecha = "2024-11-26" WHERE id = 4;

UPDATE nominas SET nombre = "El favorito", salario = salario+(salario*0.25) WHERE id = 3;


----------------------------

CREATE DATABASE mi_empresa;

USE mi_empresa;

SET AUTOCOMMIT = 0; --Es una variable de sesión (hay que ponerla al volver a entrar)--

CREATE TABLE trabajadores(
    ID SERIAL PRIMARY KEY,
    nombre VARCHAR(250) NOT NULL,
    birthday DATE
);

INSERT INTO trabajadores(nombre, birthday) VALUES ("Buscabicho Diego", "1997-11-25");
INSERT INTO trabajadores(nombre, birthday) VALUES ("Niño Bien Joel", "2000-10-25");
INSERT INTO trabajadores(nombre, birthday) VALUES ("Pokeamantes Juan Carlos & Arnau", "2000-10-25");

----Transacciones----
--Funciona en todas las bases de datos relacionales, el autocommit solo funciona en algunas--

START TRANSACTION;


