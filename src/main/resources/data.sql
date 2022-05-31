INSERT INTO users (email, first_name, last_name, password)
VALUES ('mitchell.hudson11@example.com', 'Mitchell', 'Hudson', '{noop}password'),
       ('melanie.bell51@example.com', 'Melanie', 'Bell', '{noop}admin'),
       ('admin@example.com', 'Admin', '', '{noop}admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2),
       ('ADMIN', 3),
       ('USER', 3);