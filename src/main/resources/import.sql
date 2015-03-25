-- Rooms
INSERT INTO room(name) VALUES ('Yellow room')
INSERT INTO room(name) VALUES ('Red room')
INSERT INTO room(name) VALUES ('Green room')
INSERT INTO room(name) VALUES ('Blue room')


-- Presentations
INSERT INTO presentation(name, room_id) VALUES ('Presentation 1', 1)
INSERT INTO presentation(name, room_id) VALUES ('Presentation 2', 1)
INSERT INTO presentation(name, room_id) VALUES ('Presentation 3', 2)

-- Users
-- password == username
insert into user (name, password, email, role) values ('user', '$2a$10$299sabD09jWyfys2OtUSMeoXSypH6riqrqqeJrQKZNQAvvdg/awB6', 'test0@mail.com', 'ROLE_LISTENER');
insert into user (name, password, email, role) values ('presenter', '$2a$10$cuD73mlQ4LHP7oEQ0Ytf8.KSkVIAQj2cyxIdgbuP821ziPBOYsPAy', 'test1@mail.com', 'ROLE_PRESENTER');
insert into user (name, password, email, role) values ('admin', '$2a$10$XIMNUKC5391WYGxbW.y4QurP67diyTHqvphPgZF2QSjEaAE5M4aiW', 'test2@mail.com', 'ROLE_ADMIN');

-- User_presentation
INSERT INTO presentation_user(presentation_id, user_id) VALUES (1, 1)
INSERT INTO presentation_user(presentation_id, user_id) VALUES (2, 1)
INSERT INTO presentation_user(presentation_id, user_id) VALUES (2, 2)
INSERT INTO presentation_user(presentation_id, user_id) VALUES (3, 1)