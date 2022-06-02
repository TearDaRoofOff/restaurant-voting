INSERT INTO users (email, first_name, last_name, password)
VALUES ('mitchell.hudson11@example.com', 'Mitchell', 'Hudson', '{noop}password'),
       ('melanie.bell51@example.com', 'Melanie', 'Bell', '{noop}admin'),
       ('admin@example.com', 'Admin', '', '$2a$12$zZZ5RTpP9EkTgAD9G.7aqOj2UeI78QgVZ.1KdNqJLJC/r1WbfGl56');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2),
       ('ADMIN', 3),
       ('USER', 3);