SELECT
    c.nombre,
    MONTHNAME (fecha_venta) mes,
    count(id_venta) compras,
    sum(cantidad) productos
FROM
    ventas v
    INNER JOIN clientes c ON c.id_cliente = v.id_cliente
GROUP BY
    v.id_cliente,
    mes
HAVING
    productos > 8;

--------------------------------------------------------------------------------------------------------------------------
SELECT
    *
FROM
    ventas v
    INNER JOIN clientes c ON c.id_cliente = v.id_cliente
GROUP BY
    MONTH (fecha_venta),
    v.id_cliente
HAVING
    count(*) > 1;

--------------------------------------------------------------------------------------------------------------------------
--Muestra qué cantidad de cada producto se ha vendido--
SELECT
    p.nombre_producto producto,
    sum(cantidad) ventas
FROM
    ventas v
    INNER JOIN productos p ON v.id_producto = p.id_producto
GROUP BY
    v.id_producto;

--------------------------------------------------------------------------------------------------------------------------
--Muestra el nombre de los cinco productos más vendidos, ordenados por fecha de venta y junto a la cantidad total de productos vendidos--
SELECT
    p.nombre_producto producto,
    sum(cantidad) ventas
FROM
    ventas v
    INNER JOIN productos p ON v.id_producto = p.id_producto
GROUP BY
    v.id_producto
ORDER BY
    fecha_venta LIMIT 5;

--------------------------------------------------------------------------------------------------------------------------
--Nombre de las personas que han comprado un número de veces mayor o igual a la media--
SELECT
    c.nombre,
    COUNT(v.id_cliente) COMPRAS
FROM
    clientes c
    INNER JOIN ventas v ON c.id_cliente = v.id_cliente
GROUP BY
    v.id_cliente
HAVING
    COUNT(v.id_cliente) >= (
        SELECT
            AVG(compras_totales)
        FROM
            (
                SELECT
                    COUNT(id_cliente) AS compras_totales
                FROM
                    ventas
                GROUP BY
                    id_cliente
            ) consulta
    );

-----
-----Extras
-----------------------------------------
--Selecciona todos los directores--
SELECT * from crew WHERE job = "Director";


--selecciona el id de los directores que han dirigido el máximo de películas
SELECT person_id
FROM crew
WHERE job = "Director"
GROUP BY person_id
HAVING COUNT(movie_id) = (
   SELECT  COUNT(movie_id) AS directed_movies
    FROM crew
    WHERE job = "Director"
    GROUP BY person_id
    ORDER BY directed_movies  DESC
    LIMIT 1 
);


SELECT p.name
FROM people p
INNER JOIN crew c ON p.id = c.person_id
WHERE c.person_id IN (
    SELECT person_id
FROM crew
WHERE job = "Director"
GROUP BY person_id
HAVING COUNT(movie_id) = (
   SELECT  COUNT(movie_id) AS directed_movies
    FROM crew
    WHERE job = "Director"
    GROUP BY person_id
    ORDER BY directed_movies  DESC
    LIMIT 1 
)
)
GROUP BY p.name;

--Máximo de películas dirigidas--
SELECT  COUNT(movie_id) AS directed_movies
FROM crew
WHERE job = "Director"
GROUP BY person_id
ORDER BY directed_movies  DESC
LIMIT 1;


SELECT pc.name, SUM(m.revenue)
FROM production_companies pc
INNER JOIN movie_production_companies mpc ON pc.id = mpc.company_id
INNER JOIN movies m ON mpc.movie_id = m.id
GROUP BY pc.name
LIMIT 20;


SELECT title, YEAR(release_date) 
FROM  movies
WHERE MONTH(release_date) BETWEEN 6 AND 8
ORDER BY YEAR(release_date) DESC
LIMIT 20;



--
SELECT msp.language_id, COUNT(msp.movie_id)
FROM movie_spoken_languages msp
GROUP BY msp.language_id;

SELECT sl.english_name, COUNT(m.id)
FROM movies m
INNER JOIN spoken_languages sl ON m.original_language = sl.iso_639_1
GROUP BY m.original_language;


--La o las personas que han participado en más dramas cuyo idioma original sea el japonés



SELECT name
FROM people
WHERE id IN (
    SELECT person_id
    FROM cast
    WHERE movie_id IN (
        SELECT movie_id
        FROM movie_genres
        WHERE genre_id = (
            SELECT id
            FROM genres
            WHERE name = "Drama"
        )
        AND movie_id IN (
            SELECT movie_id
            FROM movie_spoken_languages
            WHERE language_id = (
                SELECT iso_639_1
                FROM spoken_languages
                WHERE english_name = "Japanese"
            )
        )
    )
    GROUP BY person_id
    HAVING COUNT(movie_id) = (
        SELECT MAX(movie_count)
        FROM (
            SELECT person_id, COUNT(movie_id) AS movie_count
            FROM cast
            WHERE movie_id IN (
                SELECT movie_id
                FROM movie_genres
                WHERE genre_id = (
                    SELECT id
                    FROM genres
                    WHERE name = "Drama"
                )
                AND movie_id IN (
                    SELECT movie_id
                    FROM movie_spoken_languages
                    WHERE language_id = (
                        SELECT iso_639_1
                        FROM spoken_languages
                        WHERE english_name = "Japanese"
                    )
                )
            )
            GROUP BY person_id
        ) AS max_peliculas
    )
);









