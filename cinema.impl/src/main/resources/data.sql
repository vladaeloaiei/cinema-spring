-- ROOMS
INSERT INTO rooms(room_type, number_of_rows, number_of_columns)
VALUES ('LARGE', 16, 10);

INSERT INTO rooms(room_type, number_of_rows, number_of_columns)
VALUES ('LARGE', 16, 10);

INSERT INTO rooms(room_type, number_of_rows, number_of_columns)
VALUES ('SMALL', 10, 10);

INSERT INTO rooms(room_type, number_of_rows, number_of_columns)
VALUES ('SMALL', 10, 10);

-- MOVIES
INSERT INTO movies(name, length, price)
VALUES ('Rampage', 107, 22);

INSERT INTO movies(name, length, price)
VALUES ('Deadpool 2', 120, 21);

INSERT INTO movies(name, length, price)
VALUES ('Avengers', 151, 23);

INSERT INTO movies(name, length, price)
VALUES ('Peter iepurasul', 95, 20);

INSERT INTO movies(name, length, price)
VALUES ('Amnezie cu surprize', 112, 20);


-- MOVIE_DETAILS
INSERT INTO movie_details(movie_id, launch_date, movie_type, description)
VALUES (1, '2018-04-13', 'Actiune, Fictiune, Aventura',
        'O gorila, un crocodil şi un lup cad victime unor malefice experimente genetice.');

INSERT INTO movie_details(movie_id, launch_date, movie_type, description)
VALUES (2, '2018-05-18', 'Actiune, Aventura, Comedie', 'Guralivul mercenar de la Marvel se intoarce.');

INSERT INTO movie_details(movie_id, launch_date, movie_type, description)
VALUES (3, '2018-04-27', 'Fantastic, Actiune, Aventura',
        'L-am intrezarit la finalul lui The Avengers, furios ca Chitauri nu au reușit sa infranga Pamantul și, mai ales, sa obtina Tesseractul: este Thanos');

INSERT INTO movie_details(movie_id, launch_date, movie_type, description)
VALUES (4, '2018-03-30', 'Romantic, Comedie',
        'Peter Rabbit este adaptarea pentru marele ecran a clasicei povesti semnate de Beatrix Potter.');

INSERT INTO movie_details(movie_id, launch_date, movie_type, description)
VALUES (5, '2018-05-11', 'Actiune, Fictiune, Aventura',
        'Un bogatas rasfatat si obraznic devine amnezic in urma unui accident.');

-- SCHEDULES
INSERT INTO schedules(starting_at, movie_id, room_id)
values ('2018-05-29 12:00:00', 1, 1);

INSERT INTO schedules(starting_at, movie_id, room_id)
values ('2018-05-29 12:00:00', 2, 2);

INSERT INTO schedules(starting_at, movie_id, room_id)
values ('2018-05-29 12:00:00', 3, 3);

INSERT INTO schedules(starting_at, movie_id, room_id)
values ('2018-05-29 14:30:00', 4, 4);

INSERT INTO schedules(starting_at, movie_id, room_id)
values ('2018-05-29 14:30:00', 1, 5);

-- BOOKINGS
INSERT INTO bookings(email, booking_row, booking_column, schedule_id)
values ('email1@gmail.com', 10, '12,13,14', 1);

INSERT INTO bookings(email, booking_row, booking_column, schedule_id)
values ('email2@yahoo.com', 8, '9,10', 2);

INSERT INTO bookings(email, booking_row, booking_column, schedule_id)
values ('email3@gmail.com', 5, '1,2', 3);

INSERT INTO bookings(email, booking_row, booking_column, schedule_id)
values ('email4@gmail.com', 6, '3,4,5,6', 4);

INSERT INTO bookings(email, booking_row, booking_column, schedule_id)
values ('email5@yahoo.com', 7, '6,7,8,9,10', 5);

-- USERS
INSERT INTO users(username, password, user_role)
VALUES ('admin', 'admin', 'ADMINISTRATOR');

INSERT INTO users(username, password, user_role)
VALUES ('casier', 'casier', 'CUSTOMER');
