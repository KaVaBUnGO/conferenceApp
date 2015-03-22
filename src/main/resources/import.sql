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
insert into user (name, password) values ('user', 'user');
insert into user (name, password) values ('admin', 'admin');

-- User_presentation
INSERT INTO user_presentation(user_id, presentation_id) VALUES (1, 1)
INSERT INTO user_presentation(user_id, presentation_id) VALUES (1, 2)
INSERT INTO user_presentation(user_id, presentation_id) VALUES (2, 1)