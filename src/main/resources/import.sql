-- Rooms
INSERT INTO room(name) VALUES ('Red room')
INSERT INTO room(name) VALUES ('Green room')
INSERT INTO room(name) VALUES ('Blue room')
INSERT INTO room(name) VALUES ('Orange room')
INSERT INTO room(name) VALUES ('Yellow room')


-- Presentations
INSERT INTO presentation(name, room_id) VALUES ('Presentation 1', 1)
INSERT INTO presentation(name, room_id) VALUES ('Presentation 2', 1)
INSERT INTO presentation(name, room_id) VALUES ('Presentation 3', 2)

-- Users
insert into user (name, password, role) values ('user', 'user', 'ROLE_LISTENER');
insert into user (name, password, role) values ('presenter', 'presenter', 'ROLE_PRESENTER');
insert into user (name, password, role) values ('admin', 'admin', 'ROLE_ADMIN');

-- User_presentation
INSERT INTO presentation_user(presentation_id, user_id) VALUES (1, 1)
INSERT INTO presentation_user(presentation_id, user_id) VALUES (2, 1)
INSERT INTO presentation_user(presentation_id, user_id) VALUES (2, 2)