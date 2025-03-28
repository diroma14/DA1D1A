--1--
SELECT name FROM genres ORDER BY name ASC;
--2--
SELECT * FROM production_countries ORDER BY iso_3166_1;
--3--
SELECT iso_639_1,english_name FROM spoken_languages;
--4--
SELECT title FROM movies WHERE budget=0 AND revenue=0 ORDER BY release_date ASC;
--5--
SELECT title,runtime FROM movies ORDER BY runtime DESC LIMIT 5;
--6--
SELECT title FROM movies WHERE revenue<budget AND revenue > 0 AND budget > 0 ORDER BY budget DESC;
--7--
SELECT title,release_date FROM movies WHERE YEAR(release_date) = 2024 ORDER BY release_date DESC;
--8--
SELECT title,YEAR(release_date) FROM movies WHERE MONTH(release_date) BETWEEN 6 AND 8 ORDER BY YEAR(release_date) DESC LIMIT 20;
--9--
SELECT name,TIMESTAMPDIFF(year,birthday,deathday) as age FROM people WHERE YEAR(deathday)=2024 AND BIRTHDAY IS NOT NULL AND deathday IS NOT NULL;
--10--
SELECT name,TIMESTAMPDIFF(year,birthday,NOW()) as age FROM people WHERE BIRTHDAY IS NOT NULL AND deathday IS NULL AND TIMESTAMPDIFF(year,birthday,NOW()) > 100 ORDER BY TIMESTAMPDIFF(year,birthday,NOW()) DESC LIMIT 20;
--11--
SELECT name,birthday FROM people WHERE birthday IS NOT NULL AND name LIKE '%Freeman' ORDER BY popularity DESC;
--12--
SELECT
    name,
    (
        CASE
            WHEN deathday IS NULL THEN TIMESTAMPDIFF(YEAR, birthday, NOW())
            WHEN deathday IS NOT NULL THEN TIMESTAMPDIFF(YEAR, birthday, deathday)
            ELSE NULL
        END
    ) AS age,
    IF(deathday IS NULL, "ALIVE", "DEAD") AS status
FROM
    people
WHERE
    (
        CASE
            WHEN deathday IS NULL THEN TIMESTAMPDIFF(YEAR, birthday, NOW())
            WHEN deathday IS NOT NULL THEN TIMESTAMPDIFF(YEAR, birthday, deathday)
            ELSE NULL
        END
    ) BETWEEN 80 AND 90
ORDER BY age ASC,popularity DESC
LIMIT 10;
--13--
SELECT COUNT(*) as "rows" FROM people;
--14--
SELECT
    name,
    birthday,
    (
        CASE
            WHEN MONTH(birthday) = 1 AND DAY(birthday) >= 20 OR MONTH(birthday) = 2 AND DAY(birthday) <= 18 THEN 'Aquarius'
            WHEN MONTH(birthday) = 2 AND DAY(birthday) >= 19 OR MONTH(birthday) = 3 AND DAY(birthday) <= 20 THEN 'Pisces'
            WHEN MONTH(birthday) = 3 AND DAY(birthday) >= 21 OR MONTH(birthday) = 4 AND DAY(birthday) <= 19 THEN 'Aries'
            WHEN MONTH(birthday) = 4 AND DAY(birthday) >= 20 OR MONTH(birthday) = 5 AND DAY(birthday) <= 20 THEN 'Taurus'
            WHEN MONTH(birthday) = 5 AND DAY(birthday) >= 21 OR MONTH(birthday) = 6 AND DAY(birthday) <= 20 THEN 'Gemini'
            WHEN MONTH(birthday) = 6 AND DAY(birthday) >= 21 OR MONTH(birthday) = 7 AND DAY(birthday) <= 22 THEN 'Cancer'
            WHEN MONTH(birthday) = 7 AND DAY(birthday) >= 23 OR MONTH(birthday) = 8 AND DAY(birthday) <= 22 THEN 'Leo'
            WHEN MONTH(birthday) = 8 AND DAY(birthday) >= 23 OR MONTH(birthday) = 9 AND DAY(birthday) <= 22 THEN 'Virgo'
            WHEN MONTH(birthday) = 9 AND DAY(birthday) >= 23 OR MONTH(birthday) = 10 AND DAY(birthday) <= 22 THEN 'Libra'
            WHEN MONTH(birthday) = 10 AND DAY(birthday) >= 23 OR MONTH(birthday) = 11 AND DAY(birthday) <= 21 THEN 'Scorpio'
            WHEN MONTH(birthday) = 11 AND DAY(birthday) >= 22 OR MONTH(birthday) = 12 AND DAY(birthday) <= 21 THEN 'Sagittarius'
            WHEN MONTH(birthday) = 12 AND DAY(birthday) >= 22 OR MONTH(birthday) = 1 AND DAY(birthday) <= 19 THEN 'Capricorn'
            ELSE 'Unknown'
        END
    ) AS "star sign"
FROM
    (
        SELECT * FROM people ORDER BY popularity DESC LIMIT 10
    ) subquery
ORDER BY
    popularity DESC;
--15--
SELECT
    (
        CASE
            WHEN MONTH(birthday) = 1 AND DAY(birthday) >= 20 OR MONTH(birthday) = 2 AND DAY(birthday) <= 18 THEN 'Aquarius'
            WHEN MONTH(birthday) = 2 AND DAY(birthday) >= 19 OR MONTH(birthday) = 3 AND DAY(birthday) <= 20 THEN 'Pisces'
            WHEN MONTH(birthday) = 3 AND DAY(birthday) >= 21 OR MONTH(birthday) = 4 AND DAY(birthday) <= 19 THEN 'Aries'
            WHEN MONTH(birthday) = 4 AND DAY(birthday) >= 20 OR MONTH(birthday) = 5 AND DAY(birthday) <= 20 THEN 'Taurus'
            WHEN MONTH(birthday) = 5 AND DAY(birthday) >= 21 OR MONTH(birthday) = 6 AND DAY(birthday) <= 20 THEN 'Gemini'
            WHEN MONTH(birthday) = 6 AND DAY(birthday) >= 21 OR MONTH(birthday) = 7 AND DAY(birthday) <= 22 THEN 'Cancer'
            WHEN MONTH(birthday) = 7 AND DAY(birthday) >= 23 OR MONTH(birthday) = 8 AND DAY(birthday) <= 22 THEN 'Leo'
            WHEN MONTH(birthday) = 8 AND DAY(birthday) >= 23 OR MONTH(birthday) = 9 AND DAY(birthday) <= 22 THEN 'Virgo'
            WHEN MONTH(birthday) = 9 AND DAY(birthday) >= 23 OR MONTH(birthday) = 10 AND DAY(birthday) <= 22 THEN 'Libra'
            WHEN MONTH(birthday) = 10 AND DAY(birthday) >= 23 OR MONTH(birthday) = 11 AND DAY(birthday) <= 21 THEN 'Scorpio'
            WHEN MONTH(birthday) = 11 AND DAY(birthday) >= 22 OR MONTH(birthday) = 12 AND DAY(birthday) <= 21 THEN 'Sagittarius'
            WHEN MONTH(birthday) = 12 AND DAY(birthday) >= 22 OR MONTH(birthday) = 1 AND DAY(birthday) <= 19 THEN 'Capricorn'
        END
    ) AS star_sign,
    COUNT(*) quantity
FROM
    people
WHERE birthday IS NOT NULL
GROUP BY
    star_sign
ORDER BY
    quantity DESC;

--16--
SELECT
    (
        CASE
            WHEN gender = 1 THEN 'Male'
            WHEN gender = 2 THEN 'Female'
            WHEN gender = 3 THEN 'Non-Binary'
            ELSE 'Not set / not specified'
        END
    ) gender,
    COUNT(*) quantity
FROM
    people
GROUP BY
    gender
ORDER BY
    quantity DESC;
--17--
SELECT
    YEAR (release_date) releaseYear,
    count(*) quantity
FROM
    movies
GROUP BY
    releaseYear
HAVING
    quantity > 5
ORDER BY
    releaseYear DESC;
--18--
SELECT
    YEAR (release_date) releaseYear,
    SUM(revenue)
FROM
    movies
GROUP BY
    releaseYear
HAVING
    count(*) > 5
ORDER BY
    releaseYear DESC;
--19--
SELECT
    YEAR (release_date) releaseYear,
    round(avg(budget), 2) averageBudget
FROM
    movies
GROUP BY
    releaseYear
HAVING
    releaseYear > 2000;
--20--
SELECT
    title,
    vote_average,
    vote_count
FROM
    movies
WHERE
    vote_count > 20000
ORDER BY
    vote_average DESC;
--21--
SELECT
    ROUND(AVG(runtime)) averageRuntime
FROM movies;
--22--
SELECT
    ROUND(AVG(TIMESTAMPDIFF (year, birthday, deathday)))
FROM
    people;
--23--
SELECT
    department,
    count(distinct job)
FROM crew
GROUP BY department;
--24--
SELECT
    m.title,
    COUNT(c.person_id) actors
FROM
    movies m
    INNER JOIN cast c ON m.id = c.movie_id
GROUP BY
    m.id
ORDER BY budget DESC
LIMIT 10;
--25--
SELECT p.name, m.title
FROM people p 
INNER JOIN crew c ON p.id = c.person_id
INNER JOIN movies m ON c.movie_id = m.id
WHERE job = "Director"
AND p.id IN (
    SELECT person_id
    FROM crew
    WHERE job = "Director"
    GROUP BY person_id
    HAVING COUNT(movie_id) = (
            SELECT MAX(directed_movies) 
        FROM (
            SELECT person_id, COUNT(movie_id) directed_movies
            FROM crew
            WHERE job = "Director"
            GROUP BY person_id
        ) max_directed
    )
);
--26--
--27--
SELECT 
    p.name,
    c.character
FROM 
    people p
    INNER JOIN cast c ON c.person_id = p.id
    INNER JOIN movies m ON c.movie_id = m.id
WHERE 
    m.title = "Se7en"
ORDER BY 
    p.popularity DESC
LIMIT 30;
--28--
SELECT 
    p.name
FROM 
    people p
    INNER JOIN cast c ON c.person_id = p.id
    INNER JOIN movies m ON c.movie_id = m.id
WHERE 
    m.title LIKE "%Star Wars%" 
    AND c.character NOT LIKE "%Uncredited%"
ORDER BY 
    p.popularity ASC
LIMIT 30;
--29--
--30--
SELECT 
    COUNT(DISTINCT p.id) AS "dead actors"
FROM 
    people p
    INNER JOIN cast c ON p.id = c.person_id
    INNER JOIN (
        SELECT 
            m.id AS movie_id
        FROM 
            movies m
        ORDER BY 
            m.vote_count DESC, 
            m.vote_average DESC
        LIMIT 10
    ) top_movies ON c.movie_id = top_movies.movie_id
WHERE 
    p.deathday IS NOT NULL;
--31--
SELECT
    m.title,
    COUNT(c.person_id) actors
FROM
    cast c
    INNER JOIN movies m ON c.movie_id = m.id
GROUP BY
    c.movie_id
HAVING
    COUNT(c.person_id) = (
        SELECT
            MIN(cast_count)
        FROM
            (
                SELECT
                    COUNT(person_id) AS cast_count
                FROM
                    cast
                GROUP BY
                    movie_id
            ) AS maxCast
    );
--32--
SELECT
    m.title
FROM
    cast c
    INNER JOIN movies m ON c.movie_id = m.id
WHERE
    m.budget < (
        SELECT
            AVG(budget)
        FROM
            movies
    )
GROUP BY
    m.id
HAVING
    COUNT(c.person_id) = (
        SELECT
            MAX(cast_count)
        FROM
            (
                SELECT
                    COUNT(c2.person_id) AS cast_count
                FROM
                    cast c2
                    INNER JOIN movies m2 ON c2.movie_id = m2.id
                WHERE
                    m2.budget < (
                        SELECT
                            AVG(budget)
                        FROM
                            movies
                    )
                GROUP BY
                    m2.id
            ) AS maxCast
    );
--33--
SELECT
    m.title,
    c.character,
    m.release_date,
    TIMESTAMPDIFF (YEAR, p.birthday, m.release_date) AS releaseAge
FROM
    movies m
    INNER JOIN cast c ON c.movie_id = m.id
    INNER JOIN people p ON c.person_id = p.id
WHERE
    p.id = (
        SELECT
            id
        FROM
            people
        WHERE
            name LIKE '%Morgan Freeman%'
    )
ORDER BY
    m.release_date ASC;
--34--
SELECT 
    pc.name, 
    COUNT(mpc.movie_id) AS movieCount
FROM 
    production_companies pc
    INNER JOIN movie_production_companies mpc ON mpc.company_id = pc.id
    INNER JOIN movies m ON mpc.movie_id = m.id
WHERE 
    YEAR(m.release_date) BETWEEN 2000 AND 2020
GROUP BY 
    pc.name
ORDER BY movieCount DESC
LIMIT 10;
--35--
SELECT p.name
FROM people p
    INNER JOIN cast c ON c.person_id = p.id
    INNER JOIN movies m ON m.id = c.movie_id
WHERE c.movie_id IN (
    SELECT id
    FROM movies
    WHERE YEAR(release_date) BETWEEN 1990 AND 2000
      AND budget = (
          SELECT MAX(budget) 
          FROM movies 
          WHERE YEAR(release_date) BETWEEN 1990 AND 2000
      )
);
--36--
SELECT
    m.title
FROM
    movies m
WHERE
    m.id IN (
        SELECT
            c.movie_id
        FROM
            cast c
        WHERE
            c.person_id IN (
                SELECT
                    id
                FROM
                    people
                WHERE
                    gender = 3
            )
    );
--37--
SELECT
    g.name,
    COUNT(mg.movie_id) AS movie_count
FROM
    genres g
    INNER JOIN movie_genres mg ON mg.genre_id = g.id
GROUP BY
    g.id
ORDER BY
    movie_count DESC;
--38--
SELECT m.title
FROM movies m
    INNER JOIN movie_genres mg ON mg.movie_id = m.id
WHERE mg.genre_id = (
    SELECT genre_id
    FROM (
        SELECT genre_id,COUNT(genre_id) AS genre_count
        FROM movie_genres
        GROUP BY genre_id
        ORDER BY genre_count DESC
        LIMIT 1
    ) AS top_genre 
)
ORDER BY m.release_date DESC
LIMIT 20;
--39--
SELECT m.title
FROM movies m
INNER JOIN movie_spoken_languages msl ON m.id = msl.movie_id
WHERE msl.language_id IN (
    SELECT iso_639_1
    FROM spoken_languages
    WHERE english_name NOT IN ('English')
)
LIMIT 20;
--42--
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
--44--

SELECT pc.name
FROM movie_production_companies mpc
INNER JOIN production_companies pc ON mpc.company_id = pc.id
GROUP BY company_id
ORDER BY COUNT(mpc.movie_id) DESC
LIMIT 20;

--45--
SELECT m.title, COUNT(msl.language_id) language_count
FROM movie_spoken_languages msl
INNER JOIN movies m ON msl.movie_id = m.id
GROUP BY msl.movie_id
HAVING language_count > 2
ORDER BY language_count DESC;

--46--
SELECT pc.name , COUNT(mpc.movie_id) producted_movies
FROM movie_production_countries mpc
INNER JOIN production_countries pc ON mpc.country_id = pc.iso_3166_1
GROUP BY mpc.country_id
HAVING producted_movies > 5
ORDER BY producted_movies DESC;

--47--
SELECT title,revenue
FROM movies
WHERE (revenue > budget*2)
ORDER BY revenue DESC
LIMIT 20;

--49--
SELECT pc.name, SUM(m.revenue)
FROM production_companies pc
INNER JOIN movie_production_companies mpc ON pc.id = mpc.company_id
INNER JOIN movies m ON mpc.movie_id = m.id
GROUP BY pc.name
LIMIT 20;

