CREATE TABLE alumnos (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(80) NOT NULL
);

CREATE TABLE asignaturas (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(80) NOT NULL
);

CREATE TABLE calificaciones (
    dni VARCHAR(9),
    id_asignatura SERIAL,
    calificacion FLOAT,
    PRIMARY KEY (dni, id_asignatura),
    FOREIGN KEY (dni) REFERENCES alumnos(dni),
    FOREIGN KEY (id_asignatura) REFERENCES asignaturas(id) ON DELETE CASCADE ON UPDATE CASCADE
);

------------------------------------------------------------------------

CREATE DATABASE libreria;

USE libreria;

CREATE TABLE libros (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(250) NOT NULL,
    paginas INT NOT NULL
);

CREATE TABLE autores (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE libros_autores(
    id_libro BIGINT(20) UNSIGNED,
    id_autor BIGINT(20) UNSIGNED,
    PRIMARY KEY(id_libro,id_autor),
    FOREIGN KEY(id_libro) REFERENCES libros(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    FOREIGN KEY(id_autor) REFERENCES autores(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

INSERT INTO autores(nombre) VALUES("Eichiro Oda");
INSERT INTO autores(nombre) VALUES("Boichi");
INSERT INTO autores(nombre) VALUES("Akira Toriyama");
INSERT INTO autores(nombre) VALUES("Q Hayashida");

INSERT INTO libros(nombre,paginas) VALUES("One Piece",19800);
INSERT INTO libros(nombre,paginas) VALUES("Dr Stone",4176);
INSERT INTO libros(nombre,paginas) VALUES("Dragon Ball",8823);
INSERT INTO libros(nombre,paginas) VALUES("Dorohedoro",5344);

INSERT INTO libros_autores(id_libro,id_autor) VALUES(1,1);
INSERT INTO libros_autores(id_libro,id_autor) VALUES(2,2);
INSERT INTO libros_autores(id_libro,id_autor) VALUES(3,3);
INSERT INTO libros_autores(id_libro,id_autor) VALUES(4,4);

CREATE TABLE editoriales(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE libros_editoriales(
    id_libro BIGINT(20) UNSIGNED,
    id_editorial BIGINT(20) UNSIGNED,
    PRIMARY KEY(id_libro,id_editorial),
    FOREIGN KEY(id_libro) REFERENCES libros(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    FOREIGN KEY(id_editorial) REFERENCES editoriales(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

INSERT INTO editoriales(nombre) VALUES("Shonen Jump");
INSERT INTO editoriales(nombre) VALUES("Jump Square");

INSERT INTO libros_editoriales(id_libro,id_editorial) VALUES(1,1);
INSERT INTO libros_editoriales(id_libro,id_editorial) VALUES(2,1);
INSERT INTO libros_editoriales(id_libro,id_editorial) VALUES(3,2);
INSERT INTO libros_editoriales(id_libro,id_editorial) VALUES(4,2);

-----------------------------------------------------------------------------------------------------------

CREATE DATABASE repositories;

CREATE TABLE devs(
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL
);

CREATE TABLE projects(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    propietario BIGINT(20) UNSIGNED NOT NULL,
    FOREIGN KEY(propietario) REFERENCES devs(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    UNIQUE(nombre,propietario) /*Al poner el unique ahí se crea una dupla*/
);

CREATE TABLE devs_projs(
    id_dev BIGINT(20) UNSIGNED,
    id_proj BIGINT(20) UNSIGNED,
    PRIMARY KEY(id_dev,id_proj),
    FOREIGN KEY(id_dev) REFERENCES devs(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    FOREIGN KEY(id_proj) REFERENCES projects(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

SHOW CREATE TABLE projects;

ALTER TABLE projects DROP CONSTRAINT nombre;
ALTER TABLE projects ADD CONSTRAINT patata UNIQUE(nombre,propietario); /*Puedes ponerle nombre al constraint*/
ALTER TABLE projects MODIFY nombre VARCHAR(25) NOT NULL;

------------------------------------------------------------------------------------------------------------------------------------------------

CREATE DATABASE LLMM;

USE LLMM;

CREATE TABLE etiquetas(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(20)

);

CREATE TABLE atributos(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(20)
);

CREATE TABLE etiquetas_atributos(
    id SERIAL PRIMARY KEY,
    id_etiqueta BIGINT(20) UNSIGNED,
    id_atributo BIGINT(20) UNSIGNED,
    valor VARCHAR(20),
    FOREIGN KEY(id_etiqueta) REFERENCES etiquetas(id),
    FOREIGN KEY(id_atributo) REFERENCES atributos(id) 
);

ALTER TABLE etiquetas MODIFY nombre VARCHAR(20) UNIQUE;

ALTER TABLE etiquetas_atributos DROP CONSTRAINT etiquetas_atributos_ibfk_2;

ALTER TABLE etiquetas_atributos ADD CONSTRAINT fk_id_a FOREIGN KEY(id_atributo) REFERENCES atributos(id);

------------------------------------------------------------------------------------------------------------




