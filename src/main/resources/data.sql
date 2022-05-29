INSERT INTO users (email, first_name, last_name, password)
VALUES ('mitchell.hudson11@example.com', 'Mitchell', 'Hudson', '{noop}password'),
       ('melanie.bell51@example.com', 'Melanie', 'Bell', '{noop}admin');

INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 1),
       ('ROLE_ADMIN', 2),
       ('ROLE_USER', 2);