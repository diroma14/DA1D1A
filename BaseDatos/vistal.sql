CREATE VIEW persona_director_peliculas AS (
SELECT person_id, COUNT(movie_id) directed_movies
FROM crew
WHERE job = "Director"
GROUP BY person_id
);

DROP VIEW persona_director_peliculas;
----
CREATE VIEW movie_profitability AS (
    SELECT title, budget, revenue,(revenue - budget) AS profit
    FROM movies
);

SELECT title
FROM movie_profitability
WHERE profit > 100000000
ORDER BY profit DESC;

DROP VIEW movie_profitability;
----
CREATE VIEW actors_by_genre AS(
    SELECT p.name personName, g.name genreName, COUNT(c.movie_id) movie_count
    FROM people p
    INNER JOIN cast c ON p.id = c.person_id
    INNER JOIN movie_genres mg ON c.movie_id = mg.movie_id
    INNER JOIN genres g ON mg.genre_id = g.id
    GROUP BY p.name,  g.name
);

SELECT personName
FROM actors_by_genre
WHERE movie_count >= 2
ORDER BY movie_count DESC;

DROP VIEW actors_by_genre;
------
CREATE VIEW movies_by_language AS(
    SELECT original_language, COUNT(original_language) movie_count, SUM(revenue) total_revenue
    FROM movies
    GROUP BY original_language
);

SELECT original_language, total_revenue
FROM movies_by_language
WHERE movie_count > 5
ORDER BY total_revenue DESC;
------
CREATE VIEW people_cast_crew AS(

);

SELECT p.id,p.name,
    (
        CASE
            WHEN p.gender = 1 THEN 'Male'
            WHEN p.gender = 2 THEN 'Female'
            WHEN p.gender = 3 THEN 'Non-Binary'
            ELSE 'Not set / not specified'
        END
    ) gender,
    m.title,
FROM people p
INNER JOIN cast c ON p.id = c.person_id
INNER JOIN movies m ON c.movie_id = m.id;

----
INSERT INTO movies (title, budget, revenue, release_date)
VALUES ('Más allá de los 42 segundos eternos', 50000000, 100000000, '2023-03-15');
-----
UPDATE movies m
SET m.budget = m.budget * 1.10
WHERE m.id IN (
    SELECT mg.movie_id
    FROM movie_genres mg
    INNER JOIN genres g ON mg.genre_id = g.id
    WHERE g.name = 'Action'
);
-----
DELETE FROM crew
WHERE id IN(
    SELECT c.id
    FROM crew c
    INNER JOIN movies m ON c.movie_id = m.id
    WHERE c.job LIKE "Assistant Director" AND YEAR(m.release_date) < 2000
);
----

CREATE TABLE IF NOT EXISTS popular_actors (
    name VARCHAR(255),
    popularity DECIMAL(10, 2),
    movie_count INT
);


INSERT INTO popular_actors (name, popularity, movie_count)
SELECT p.name,p.popularity,COUNT(c.movie_id) movie_count
FROM people p
INNER JOIN cast c ON p.id = c.person_id
INNER JOIN movies m ON c.movie_id = m.id
WHERE p.popularity > 80
GROUP BY p.id;

START TRANSACTION;









