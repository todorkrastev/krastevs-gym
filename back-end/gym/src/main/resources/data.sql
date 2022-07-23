-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization.using-basic-sql-scripts


-- user roles
INSERT INTO roles (id, role)
VALUES (1, 'ADMIN'),
       (2, 'MODERATOR'),
       (3, 'USER');

INSERT INTO users (id, username, email, password)
VALUES (1, 'admin', 'admin@example.com', 'admin'),
       (2, 'moderator', 'moderator@example.com', 'moderator'),
       (3, 'johndoe', 'johndoe@example.com', 'johndoe');


INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 3);

INSERT INTO activities (id, description, file, title)
VALUES (1, 'Description for text 1', 'File 1', 'Title 1'),
       (2, 'Description for text 2', 'File 2', 'Title 2'),
       (3, 'Description for text 3', 'File 3', 'Title 3');

INSERT INTO posts (id, title, description, content)
VALUES (1, 'Title 1', 'Description for text 1', 'Content 1'),
       (2, 'Title 2', 'Description for text 2', 'Content 2'),
       (3, 'Title 3', 'Description for text 3', 'Content 3'),
       (4, 'Title 4', 'Description for text 4', 'Content 4'),
       (5, 'Title 5', 'Description for text 5', 'Content 5'),
       (6, 'Title 6', 'Description for text 6', 'Content 6'),
       (7, 'Title 7', 'Description for text 7', 'Content 7'),
       (8, 'Title 8', 'Description for text 8', 'Content 8'),
       (9, 'Title 9', 'Description for text 9', 'Content 9'),
       (10, 'Title 10', 'Description for text 10', 'Content 10'),
       (11, 'Title 11', 'Description for text 11', 'Content 11'),
       (12, 'Title 12', 'Description for text 12', 'Content 12'),
       (13, 'Title 13', 'Description for text 13', 'Content 13'),
       (14, 'Title 14', 'Description for text 14', 'Content 14'),
       (15, 'Title 15', 'Description for text 15', 'Content 15'),
       (16, 'Title 16', 'Description for text 16', 'Content 16'),
       (17, 'Title 17', 'Description for text 17', 'Content 17'),
       (18, 'Title 18', 'Description for text 18', 'Content 18'),
       (19, 'Title 19', 'Description for text 19', 'Content 19'),
       (20, 'Title 20', 'Description for text 20', 'Content 20'),
       (21, 'Title 21', 'Description for text 21', 'Content 21');

INSERT INTO comments (id, name, body, post_id)
VALUES (1, 'Comment 1', 'Body 1', '1'),
       (2, 'Comment 2', 'Body 2', '1');