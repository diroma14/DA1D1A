--Procedimientos: Rebaja por marca,rebaja por categoría, rebaja por marca y categoría. 
--Función: Mejor producto calidad precio.
--3 triggers (cualquier modificación en productos se ve reflejada en teórico)

CREATE DATABASE IF NOT EXISTS tienda;

USE tienda;

CREATE OR REPLACE TABLE marcas (
    nombre VARCHAR(250) PRIMARY KEY,
    total_ganado DECIMAL(10,2) NOT NULL DEFAULT 0
);

CREATE OR REPLACE TABLE categorias (
    nombre VARCHAR(250) PRIMARY KEY,
    cantidad int NOT NULL DEFAULT 0
);

CREATE OR REPLACE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(250) NOT NULL,
    precio DECIMAL(10,2) NOT NULL DEFAULT 0,
    valoracion DECIMAL(2,2) NOT NULL DEFAULT 0,
    nombre_categoria VARCHAR(250),
    nombre_marca VARCHAR(250),
    FOREIGN KEY (nombre_categoria) REFERENCES categorias(nombre),
    FOREIGN KEY (nombre_marca) REFERENCES marcas(nombre)
);

CREATE OR REPLACE TABLE logs(
    id INT AUTO_INCREMENT PRIMARY KEY,
    log VARCHAR(250),
    id_producto INT,
    fecha_log DATETIME DEFAULT NOW(),
    FOREIGN KEY (id_producto) REFERENCES productos(id)
);

--Procedimientos:
--Usando la función concat
--Crear un procedimiento llamado sp_crear_productos que reciba por parámetro dos cadenas de texto no nulas,una cadena de texto que puede ser nula (IFNULL) y la valoración del producto y
--el precio.
--Call sp_crear_productos("zapatillas","converse","rojas",3.5,50.5)

DELIMITER $$

CREATE OR REPLACE PROCEDURE sp_crear_productos(IN producto VARCHAR(250),IN marca VARCHAR(250),IN comentario VARCHAR(250),IN valoracion DECIMAL(2,2),IN precio DECIMAL(10,2))
BEGIN
    IF comentario IS NULL THEN
        INSERT INTO productos(nombre,precio,valoracion,nombre_categoria,nombre_marca) VALUES ((CONCAT(producto," ",marca)),precio,valoracion,producto,marca);
    ELSE
        INSERT INTO productos(nombre,precio,valoracion,nombre_categoria,nombre_marca) VALUES ((CONCAT(producto," ",marca," ",comentario)),precio,valoracion,producto,marca);
    END IF;
END $$

DELIMITER ;

DELIMITER $$

CREATE OR REPLACE TRIGGER tg_before_insert_productos
    BEFORE INSERT ON productos
    FOR EACH ROW
        BEGIN
            DECLARE existe_marca VARCHAR(25) DEFAULT NULL;
            SELECT nombre INTO existe_marca FROM marcas WHERE nombre = NEW.nombre_marca;
            DECLARE existe_categoria VARCHAR(25) DEFAULT NULL;
            SELECT nombre INTO existe_categoria FROM categorias WHERE nombre = NEW.nombre_categoria;
            IF existe_marca IS NULL THEN
                INSERT INTO marcas(nombre) VALUES(NEW.nombre_marca);
            END IF;
            IF existe_categoria IS NULL THEN
                INSERT INTO categorias(nombre) VALUES(NEW.nombre_categoria);
            END IF;          
        END $$

DELIMITER ;


CREATE OR REPLACE TABLE calidad_precio(
    categoria VARCHAR(250) PRIMARY KEY,
    valoracion DECIMAL(2,2) NOT NULL DEFAULT 0,
    precio DECIMAL(10,2) NOT NULL DEFAULT 0
);

DELIMITER $$

CREATE OR REPLACE FUNCTION sf_mejor_calidad(precioEntrada int)
DETERMINISTIC
BEGIN
    
    SELECT nombre, valoracion, precio, nombre_categoria 
    FROM productos 
    WHERE valoracion > 4 
    AND precio < precioEntrada
    AND nombre_categoria IN (SELECT nombre FROM categorias)
    ORDER BY valoracion, precio;

END$$

DELIMITER ;

INSERT INTO categorias(nombre,cantidad) VALUES("Zapatillas",10);
INSERT INTO categorias(nombre,cantidad) VALUES("Cinturones",20);
INSERT INTO categorias(nombre,cantidad) VALUES("Camisetas",60);

INSERT INTO marcas(nombre,total_ganado) VALUES("Nike",10000.0);
INSERT INTO marcas(nombre,total_ganado) VALUES("Pokemon Inc",20000.0);

INSERT INTO productos(nombre, precio, valoracion, nombre_categoria, nombre_marca) VALUES('Zapatillas de colores', 70, 5.0, 'Zapatillas', 'Nike');
INSERT INTO productos(nombre, precio, valoracion, nombre_categoria, nombre_marca) VALUES('Cinturón', 20, 3.2, 'Cinturones', 'Pokemon Inc');
INSERT INTO productos(nombre, precio, valoracion, nombre_categoria, nombre_marca) VALUES('Camiseta Psyduck', 20, 4.1, 'Camisetas', 'Pokemon Inc');
INSERT INTO productos(nombre, precio, valoracion, nombre_categoria, nombre_marca) VALUES('Cinturón 2', 10, 4.5, 'Cinturones', 'Nike');
