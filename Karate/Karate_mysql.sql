DROP SCHEMA

IF EXISTS Karate;
	CREATE SCHEMA Karate COLLATE = utf8_general_ci;

USE Karate;

CREATE TABLE user_types (
	id INT(2) UNSIGNED NOT NULL,
    name VARCHAR(15) NOT NULL,
    PRIMARY KEY(id)
    );

CREATE TABLE users (
	id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    name VARCHAR(30),
    lastname VARCHAR(30),
    email VARCHAR(40) NOT NULL,
    birthdate DATE NOT NULL,
    genre CHAR(1) NOT NULL,
    phone CHAR(9),
    picture_url VARCHAR(100),
    user_type_id INT(2) UNSIGNED NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT users_user_types_user_type_id FOREIGN KEY (user_type_id) REFERENCES user_types(id)
	);
  
CREATE TABLE informations(
	id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    description VARCHAR(100),
    average_points DECIMAL(3,2),
    vote_quantity INT(10),
    user_id INT(5) UNSIGNED NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT informations_users_user_id FOREIGN KEY (user_id) REFERENCES users(id)
);
  
  
CREATE TABLE events (
	id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR (50)  NOT NULL,
    picture_url VARCHAR(100) NOT NULL,
    ubication VARCHAR(150) NOT NULL,
    date DATE NOT NULL,
    date_limit DATE NOT NULL,
    description VARCHAR(300) NOT NULL,
    tags VARCHAR(100),
    websites VARCHAR(70),
    salary DECIMAL(10,2),
    user_id INT(5) UNSIGNED NOT NULL,
    PRIMARY KEY(id),
	CONSTRAINT events_users_user_id FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE postulants (
	event_id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT(5) UNSIGNED NOT NULL,
    date DATE NOT NULL,
    PRIMARY KEY(event_id,user_id),
    CONSTRAINT postulants_events_event_id FOREIGN  KEY (event_id) REFERENCES events(id),
    CONSTRAINT postulants_users_user_id FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE posts (
	id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT(5) UNSIGNED NOT NULL ,
    title VARCHAR(50),
    date DATE,
    description VARCHAR(300),
	url VARCHAR(100),
    PRIMARY KEY(id,user_id),
    CONSTRAINT posts_users_user_id FOREIGN KEY (user_id) REFERENCES users(id)
);
    
CREATE TABLE comments (
    post_id INT(5) UNSIGNED NOT NULL,
    id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    description VARCHAR(100) NOT NULL,
    date DATE NOT NULL,
    user_id INT(5) UNSIGNED NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT comments_posts_post_id FOREIGN KEY (post_id) REFERENCES posts(id),
    CONSTRAINT comments_users_user_id FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE points(
	origin INT(5) UNSIGNED NOT NULL,
    target INT(5) UNSIGNED NOT NULL,
    quantity INT(2) NOT NULL,
    PRIMARY KEY(origin,target),
    CONSTRAINT points_users_origin FOREIGN KEY (origin) REFERENCES users(id),
    CONSTRAINT points_users_target FOREIGN KEY (target) REFERENCES users(id)
);

INSERT INTO user_types
VALUES (
	1,
	'Sensei'
	);
    
INSERT INTO user_types
VALUES (
	2,
	'Alumno'
	);
    

INSERT INTO users (username,password,name,lastname,email,birthdate,genre,phone,picture_url,user_type_id)
VALUES (
    'Tatto123',
    'tatto123',
    'Renato',
    'Cortez',
    'tato.1995@hotmail.com',
    STR_TO_DATE('08-11-1995', '%d-%m-%Y'),
    'M',
    '956755046',
    NULL,
    1
	);
    
INSERT INTO users (username,password,name,lastname,email,birthdate,genre,phone,picture_url,user_type_id)
VALUES (
    'Mordekay',
    'joseph123',
    'Joseph',
    'Campos',
    'mordekay@hotmail.com',
    STR_TO_DATE('25-02-1995', '%d-%m-%Y'),
    'M',
    '999069069',
    NULL,
    2
	);
    
INSERT INTO users (username,password,name,lastname,email,birthdate,genre,phone,picture_url,user_type_id)
VALUES (
    'RoyVisitacion',
    'roy123',
    'Roy',
    'Visitación',
    'roy@hotmail.com',
    STR_TO_DATE('25-01-1999', '%d-%m-%Y'),
    'M',
    '978066359',
    NULL,
    1
	);
    
INSERT INTO informations (description,average_points,vote_quantity,user_id)
VALUES (
	'',
    0,
    0,
    1
    );
    
INSERT INTO informations (description,average_points,vote_quantity,user_id)
VALUES (
	'',
    0,
    0,
    2
    );
    
INSERT INTO informations (description,average_points,vote_quantity,user_id)
VALUES (
	'',
    0,
    0,
    3
    );
    
INSERT INTO posts (user_id,title,date,description,url) 
VALUES (
	1,
    'Lucha 1',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    'Descripción 1',
    'https://www.youtube.com/embed/Q4IKYsZApcc'
	);
    
INSERT INTO posts (user_id,title,date,description,url) 
VALUES (
	3,
    'Lucha 2',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    'Descripción 2',
    'https://www.youtube.com/embed/WPVuC6ugmAw'
	);
    
INSERT INTO posts (user_id,title,date,description,url) 
VALUES (
	1,
    'Lucha 3',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    'Descripción 3',
    'https://www.youtube.com/embed/w9kxtJpRmw4'
	);
    
INSERT INTO posts (user_id,title,date,description,url) 
VALUES (
	3,
    'Lucha 4',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    'Descripción 4',
    'https://www.youtube.com/embed/ovdsMzfVvbY'
	);
    
INSERT INTO posts (user_id,title,date,description,url) 
VALUES (
	1,
    'Lucha 5',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    'Descripción 5',
    'https://www.youtube.com/embed/59ma8keQHK0'
	);
    
INSERT INTO posts (user_id,title,date,description,url) 
VALUES (
	3,
    'Lucha 6',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    'Descripción 6',
    'https://www.youtube.com/embed/HxzXoBGzL_s'
	);
    
    

INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	1,
    'Buen video',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    1
	);    
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	1,
    'Excelente video',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    2
	);    
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	1,
    'Buen aporte',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    3
	);
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	2,
    'Me encanta sus videos',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    1
	);    
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	2,
    'Excelente video',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    2
	);    
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	2,
    'Equisde!',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    3
	);

INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	3,
    'Increible',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    1
	);    
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	3,
    'Excelente video',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    2
	);    
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	3,
    'Interesante!',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    3
	);

INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	4,
    'Interesante',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    1
	);    
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	4,
    'Excelente video',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    2
	);    
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	4,
    'Jaaaaaaaaaaaaaaaa!',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    3
	); 

INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	5,
    'que tal video',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    1
	);    
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	5,
    'Buen video',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    2
	);    
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	5,
    'hahaha!',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    3
	); 

INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	6,
    'Lol',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    1
	);    
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	6,
    'Me divierte',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    2
	);    
    
INSERT INTO comments (post_id,description,date,user_id)
VALUES (
	6,
    'Gran aporte!',
    STR_TO_DATE("15-06-2017", "%d-%m-%Y"),
    3
	); 

INSERT INTO events (title, picture_url, ubication, date, date_limit, description, tags, websites, salary, user_id) 
VALUES ('Evento 1', 'www.ew.com/as.jpg', 'local A', STR_TO_DATE("05-03-2018", "%d-%m-%Y"), STR_TO_DATE("10-03-2018", "%d-%m-%Y"), 'torneo 1', 'karate', 'www.karate.com', '500',1);

INSERT INTO events (title, picture_url, ubication, date, date_limit, description, tags, websites, salary, user_id) 
VALUES ('Evento 2', 'www.ew.com/bb.jpg', 'local B', STR_TO_DATE("15-06-2018", "%d-%m-%Y"), STR_TO_DATE("22-06-2018", "%d-%m-%Y"), 'torneo 2', 'karate', 'www.karate.com', '600',1);

