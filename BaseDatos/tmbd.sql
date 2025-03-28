CREATE DATABASE tmdb;

USE tmdb;

CREATE TABLE movies(
    id INT PRIMARY KEY,
    imdb_id VARCHAR(9) UNIQUE NOT NULL,
    title VARCHAR(100) NOT NULL,
    original_title VARCHAR(200),
    adult BOOLEAN NOT NULL,
    budget INT,
    revenue INT,
    popularity FLOAT,
    release_date DATE NOT NULL,
    runtime INT NOT NULL,
    tagline VARCHAR(200),
    vote_average FLOAT,
    vote_count INT,
    original_language VARCHAR(5) NOT NULL
);

CREATE TABLE genres(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE countries(
    id SERIAL PRIMARY KEY,
    name VARCHAR(5) NOT NULL UNIQUE
);

CREATE TABLE people (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    original_name VARCHAR(100),
    birthdate DATE NOT NULL,
    deathdate DATE,
    gender INT(1) NOT NULL CHECK (gender >= 0 AND gender <=3)
);

/*Una persona sólo puede interpretar a un personaje en una película*/
CREATE TABLE casting(
    id SERIAL PRIMARY KEY,
    role VARCHAR(50),
    movie_id INT(11),
    person_id INT(11),
    FOREIGN KEY(movie_id) REFERENCES movies(id),
    FOREIGN KEY(person_id) REFERENCES people(id),
    UNIQUE(movie_id,person_id)
);

CREATE TABLE crew(
    id SERIAL PRIMARY KEY,
    department VARCHAR(50),
    job VARCHAR(50),
    movie_id INT(11),
    person_id INT(11),
    FOREIGN KEY(movie_id) REFERENCES movies(id),
    FOREIGN KEY(person_id) REFERENCES people(id)
);

CREATE TABLE countries_movies(
    id SERIAL PRIMARY KEY,
    country_id BIGINT(20) UNSIGNED,
    movie_id INT(11),
    FOREIGN KEY(country_id) REFERENCES countries(id),
    FOREIGN KEY(movie_id) REFERENCES movies(id)
);

CREATE TABLE movies_genres(
    id SERIAL PRIMARY KEY,
    movie_id INT(11),
    genre_id BIGINT(20) UNSIGNED,
    FOREIGN KEY(movie_id) REFERENCES movies(id),
    FOREIGN KEY(genre_id) REFERENCES genres(id) 
);

--ALTERS--

ALTER TABLE genres DROP CONSTRAINT name;
ALTER TABLE countries DROP CONSTRAINT name;

ALTER TABLE casting DROP FOREIGN KEY casting_ibfk_1,ADD CONSTRAINT fk_movies_movie_id FOREIGN KEY (movie_id) REFERENCES movies(id) ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE casting DROP FOREIGN KEY casting_ibfk_2,ADD CONSTRAINT fk_people_person_id FOREIGN KEY (person_id) REFERENCES people(id) ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE crew DROP FOREIGN KEY crew_ibfk_1,ADD CONSTRAINT fk_movies_movie_id_crew FOREIGN KEY (movie_id) REFERENCES movies(id) ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE crew DROP FOREIGN KEY crew_ibfk_2,ADD CONSTRAINT fk_people_person_id_crew FOREIGN KEY (person_id) REFERENCES people(id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE countries_movies DROP FOREIGN KEY countries_movies_ibfk_1,ADD CONSTRAINT fk_countries_country_id FOREIGN KEY (country_id) REFERENCES countries(id) ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE countries_movies DROP FOREIGN KEY countries_movies_ibfk_2,ADD CONSTRAINT fk_movies_movie_id_countries FOREIGN KEY (movie_id) REFERENCES movies(id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE movies_genres DROP FOREIGN KEY movies_genres_ibfk_1,ADD CONSTRAINT fk_movies_movie_id_genres FOREIGN KEY (movie_id) REFERENCES movies(id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE people MODIFY gender INT(1) NOT NULL DEFAULT 0 CHECK (gender >= 0 AND gender <=3);

ALTER TABLE movies MODIFY original_language VARCHAR(5) NOT NULL DEFAULT "en";


ALTER TABLE casting DROP CONSTRAINT movie_id;



