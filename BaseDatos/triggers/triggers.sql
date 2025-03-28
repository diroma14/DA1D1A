CREATE DATABASE IF NOT EXISTS triggers4m;

CREATE TABLE IF NOT EXISTS animales(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50),
    categoria VARCHAR(20),
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS logs(
    id SERIAL PRIMARY KEY,
    log VARCHAR(255),
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS categorias(
    id SERIAL PRIMARY KEY,
    categoria VARCHAR(20),
    num_animalicos INT,
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME DEFAULT NOW()
);

DELIMITER $$

--Después de actualizar la tabla animales para cada linea actualizada hace todo lo que está en begin

CREATE OR REPLACE TRIGGER tg_update_animales
    AFTER UPDATE ON animales
    FOR EACH ROW
    BEGIN
        DECLARE existe_categoria varchar(25) DEFAULT NULL;
        IF IFNULL(old.categoria, "null") != new.categoria THEN
            INSERT INTO logs(log) VALUES(
                CONCAT("actualizado ", ifnull(old.categoria, "null"), " a ", new.categoria)
            );
            UPDATE categorias SET num_animalicos = num_animalicos - 1 WHERE categoria = old.categoria;
            SELECT categoria INTO existe_categoria FROM categorias WHERE categoria = NEW.categoria;
            IF existe_categoria IS NOT NULL THEN
                UPDATE categorias SET num_animalicos = num_animalicos + 1 WHERE categoria = new.categoria;
            ELSE
                INSERT INTO categorias(categoria, num_animalicos) VALUES(new.categoria, 1);
            END IF;
        END IF;
        IF old.nombre != new.nombre THEN
            INSERT INTO logs(log) VALUES(
                CONCAT("actualizado ", old.nombre, " a ", new.nombre)
            );
        END IF;
    END$$

DELIMITER ;

--Crear el de insertar (cuando se inserta un animal se actualiza la categoría respecto a la nueva cantidad de aniamales y además deje un log)

DELIMITER $$

CREATE OR REPLACE TRIGGER tg_insert_animales
    AFTER INSERT ON animales
    FOR EACH ROW
    BEGIN
        DECLARE existe_categoria VARCHAR(25) DEFAULT NULL;
        SELECT categoria INTO existe_categoria FROM categorias WHERE categoria = NEW.categoria;
        
        IF existe_categoria IS NULL THEN
            INSERT INTO categorias(categoria, num_animalicos) VALUES (NEW.categoria, 0);
        END IF;

        UPDATE categorias SET num_animalicos = num_animalicos + 1 WHERE categoria = NEW.categoria;
        INSERT INTO logs(log) VALUES (
            CONCAT("Insertado la línea con categoría: ", IFNULL(NEW.categoria, "NULL"))
        );

    END$$

DELIMITER ;

--Crear el de eliminar

DELIMITER $$

CREATE OR REPLACE TRIGGER tg_delete_animales
    AFTER DELETE ON animales
    FOR EACH ROW
    BEGIN       
        UPDATE categorias SET num_animalicos = num_animalicos - 1 WHERE categoria = old.categoria;
        INSERT INTO logs(log) VALUES (
            CONCAT("Insertado la línea con categoría: ", IFNULL(old.categoria, "NULL"))
        );
    END$$

DELIMITER ;

--Insert en la tabla categoria

DELIMITER $$

CREATE OR REPLACE TRIGGER tg_insert_categoria
    AFTER INSERT ON categorias
    FOR EACH ROW
    BEGIN
        INSERT INTO logs(log) VALUES (
            CONCAT("Insertada la categoría con nombre: ",IFNULL(new.categoria,"NULL"))
        );
    END$$

DELIMITER ;

--Delete en la tabla categoría

DELIMITER $$

CREATE OR REPLACE TRIGGER tg_delete_categoria
    AFTER DELETE ON categorias
    FOR EACH ROW
    BEGIN
        INSERT INTO logs(log) VALUES (
            CONCAT("Insertada la categoría con nombre: ",IFNULL(old.categoria,"NULL"))
        );
    END$$

DELIMITER ;

--Update en la tabla categoría

DELIMITER $$

CREATE OR REPLACE TRIGGER tg_delete_categoria
    AFTER UPDATE ON categorias
    FOR EACH ROW
    BEGIN
        IF NEW.num_animalicos = 0 THEN
            INSERT INTO logs(log) VALUES (
                CONCAT("Eliminada la categoría con nombre: ", IFNULL(OLD.categoria, "NULL"))
            );
            DELETE FROM categorias WHERE categoria = OLD.categoria;
        ELSEIF OLD.num_animalicos > NEW.num_animalicos THEN
            INSERT INTO logs(log) VALUES (
                CONCAT("Decrementado la cantidad de: ", IFNULL(OLD.categoria, "NULL"))
            );
        ELSEIF NEW.num_animalicos > OLD.num_animalicos THEN
            INSERT INTO logs(log) VALUES (
                CONCAT("Aumentada la cantidad de: ", IFNULL(OLD.categoria, "NULL"))
            );
        ELSE
            INSERT INTO logs(log) VALUES (
                "Error en tg_delete_categoria: sin cambios detectados en num_animalicos."
            );
        END IF;
    END$$

DELIMITER ;

