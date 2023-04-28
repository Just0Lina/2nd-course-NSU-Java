INSERT INTO usr (id, username, password, active)
VALUES (1, 'admin', 'admin', true);

INSERT INTO user_role (user_id, roles)
VALUES (1, 'USER'),
       (1, 'ADMIN');

INSERT INTO usr (id, username, password, active)
VALUES (2, 'Alina', 'Alina', true);

INSERT INTO user_role (user_id, roles)
VALUES (2, 'USER');


-- delete
-- from user_role
-- where user_id = 2
--    or user_id = 1;
-- delete
-- from usr
-- where id = 2
--    or id = 1;
