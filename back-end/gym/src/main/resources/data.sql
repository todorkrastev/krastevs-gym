-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization.using-basic-sql-scripts

-- user roles
INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'USER');

INSERT INTO activities (id, description, file, title)
VALUES (1, 'Description for text 1', 'File 1', 'Title 1'),
       (2, 'Description for text 2', 'File 2', 'Title 2'),
       (3, 'Description for text 3', 'File 3', 'Title 3');
