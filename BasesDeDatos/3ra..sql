set @resultado = 100;
DELIMITER &&

--La variables de salida reciben una variable
CREATE PROCEDURE
sp_sumar(n1 INT,n2 INT,OUT result INT)
    begin
        SELECT n1;
        SELECT n2;
        --SELECT n1+n2 INTO result; #Una opción
        SET result = n1 + n2;
    end$$

DELIMITER ;

CALL sp_sumar(1,2)

DELIMITER &&
CREATE PROCEDURE sp_operaciones(n1 int, n2 int, out result_suma int, out result_resta int, out result_fecha date)
    begin
        SET result_suma = n1 + n2;
        SET result_resta = n1 - n2;
        SET result_fecha = now();
    end$$

DELIMITER ;

CALL sp_operaciones(2,1,@result1,@result2,@result3);


DELIMITER &&
CREATE PROCEDURE sp_parimpar(n1 int)
    begin
      IF n1%2 == 0 THEN
        SELECT = "PAR";
      ELSE
        SELECT = "IMPAR";
      END IF;
    end$$

DELIMITER ;

set @resultado = 0;

DELIMITER $$
CREATE PROCEDURE sp_comparar(n1 int,n2 int,out result int)
    begin
        if n1 > n2 then
          SET result = n1;
        else
          SET result = n2;
        end if;
    end $$

DELIMITER ;

CALL sp_comparar(2,1,@resultado);

SELECT @resultado;

--
DELIMITER $$

CREATE PROCEDURE sp_contar_5_loop(
  IN num_inicial INT
)
BEGIN
  DECLARE suma INT DEFAULT 0;

  repeticion: LOOP
    SELECT num_inicial + suma AS resultado, CONCAT('paso', suma) AS paso_actual;
    
    SET suma = suma + 1;
    
    IF suma = 5 THEN
      SELECT num_inicial + suma AS resultado, CONCAT('paso', suma) AS paso_actual;
      LEAVE repeticion;
    END IF;
  END LOOP;

END $$

DELIMITER ;
--

--Que mire los números pares que hay entre el valor pasado por parámetro y 0--Si el valor pasado por parámetro es NULL entonces deberá considerar que es 100.
DELIMITER $$

CREATE PROCEDURE sp_pares_null(IN num_inicial INT)
BEGIN
  DECLARE num_actual INT;

  IF num_inicial IS NULL THEN
    SET num_actual = 100;
  ELSE
    SET num_actual = num_inicial;
  END IF;

  repeticion: LOOP
    IF num_actual % 2 = 0 THEN
      SELECT CONCAT(num_actual, " es par") AS resultado;
    END IF;

    SET num_actual = num_actual - 1;

    IF num_actual = 0 THEN
      LEAVE repeticion;
    END IF;
  END LOOP;

END $$

DELIMITER ;

--Insertar 10 números aleatorios introducidos en dos parámetros

CREATE TABLE tabla_random (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL
);


DELIMITER $$
CREATE PROCEDURE sp_random10(IN minimo INT, IN maximo INT,IN repeticiones INT)
BEGIN
  DECLARE numero INT;

  IF repeticiones IS NULL THEN
    SET repeticiones = 0;
  END IF;

  WHILE repeticiones > 0 DO
    SET numero = ROUND(RAND() * (maximo - minimo) + minimo);
    INSERT INTO tabla_random (numero) VALUES (numero);
    SET repeticiones = repeticiones - 1;
  END WHILE;
END $$

DELIMITER ;

--Ejercicio 1 
DELIMITER $$

CREATE PROCEDURE sp_add_movie_with_genres(IN titulo VARCHAR(250),IN presupuesto INT,IN ingresos INT,IN estreno DATE)
BEGIN
  INSERT INTO movies (title, budget, revenue, release_date) VALUES (titulo, presupuesto, ingresos, estreno);
END $$

DELIMITER ;

CALL sp_add_movie_with_genres("Doraemon", 19000, 205000, '2005-12-01');

--Ejercicio 2 con transacciones
SET @revenue = 0;

DELIMITER $$
CREATE PROCEDURE sp_update_actor_revenue (IN nombre VARCHAR(250),OUT actor_revenue INT)

BEGIN
SET actor_revenue = (
  SELECT SUM(revenue) total
  FROM movies
  WHERE id IN(
    SELECT movie_id
    FROM cast
    WHERE person_id IN (
      SELECT id 
      FROM people
      WHERE name LIKE nombre
    )
  )
);
  
END $$

DELIMITER ;

CALL sp_update_actor_revenue('Tom Hanks', @revenue);
SELECT @revenue;

--Ejercicio 4
DELIMITER $$

CREATE OR REPLACE PROCEDURE sp_adjust_actor_popularity(IN umbral INT)
BEGIN
  SELECT person_id,COUNT(movie_id) AS movieCount,
      CASE
          WHEN COUNT(movie_id) > umbral THEN 'Mayor'
          WHEN COUNT(movie_id) = umbral THEN 'Igual'
          ELSE 'Menor'
      END
  FROM cast
  GROUP BY person_id
  ORDER BY movieCount;
END $$

DELIMITER ;

CALL sp_adjust_actor_popularity(3);










