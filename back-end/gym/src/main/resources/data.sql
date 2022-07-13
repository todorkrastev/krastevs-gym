-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization.using-basic-sql-scripts

-- user roles
INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'USER');

INSERT INTO activities (id, long_description, short_description, title)
VALUES (1, 'Long Description for text 1', 'Short description for text 1', 'Title 1'),
       (2, 'Long Description for text 2', 'Short description for text 2', 'Title 2'),
       (3, 'Long Description for text 3', 'Short description for text 3', 'Title 3');
