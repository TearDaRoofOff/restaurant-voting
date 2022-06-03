INSERT INTO users (email, first_name, last_name, password)
VALUES ('mitchell.hudson11@example.com', 'Mitchell', 'Hudson',
        '$2a$12$n.5Gb0II.GFoqc4s0PbzXeEV5WPZO0PZ38OUB6dbapBD848s.TI8y'),
       ('melanie.bell51@example.com', 'Melanie', 'Bell',
        '$2a$12$n.5Gb0II.GFoqc4s0PbzXeEV5WPZO0PZ38OUB6dbapBD848s.TI8y'),
       ('admin@example.com', 'Admin', '', '$2a$12$zZZ5RTpP9EkTgAD9G.7aqOj2UeI78QgVZ.1KdNqJLJC/r1WbfGl56');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 1),
       ('USER', 2),
       ('ADMIN', 3),
       ('USER', 3);

INSERT INTO RESTAURANT (TITLE)
VALUES ('TomYamBar'),
       ('Сыроварня'),
       ('Шафран'),
       ('Пельмень-кафе');

INSERT INTO MENU (MENU_DATE, RESTAURANT_ID)
VALUES ('2022-06-01', 1),
       (CURRENT_DATE, 1),
       ('2022-06-02', 2),
       (CURRENT_DATE, 2),
       ('2022-06-01', 3),
       (CURRENT_DATE, 3),
       ('2022-06-02', 4),
       (CURRENT_DATE, 4);

INSERT INTO MEAL (NAME, PRICE, MENU_ID)
VALUES ('Том-ям', 650, 1),
       ('Рис по-тайски', 50, 1),
       ('Говядина в кисло-сладком соусе', 370, 1),
       ('Уха из петуха', 330, 2),
       ('Плов праздничный', 420, 2),
       ('Чучвара', 288, 2),
       ('Пицца "Огонёк"', 480, 3),
       ('Манты с бараниной', 450, 3),
       ('Щи', 232, 3),
       ('Пельмени с рыбой', 190, 4),
       ('Пельмени с говядиной', 175, 4),
       ('Солянка', 120, 4);