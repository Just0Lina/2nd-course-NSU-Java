INSERT INTO usr (id, username, password, active)
VALUES (1, 'admin', '$2a$08$4AA/GYivlvTYb/X9KihqUene54wqSJPu7xypTW1p0A2.asdHe6gCS', true);

INSERT INTO user_role (user_id, roles)
VALUES (1, 'USER'),
       (1, 'ADMIN');

INSERT INTO usr (id, username, password, active)
VALUES (2, 'Alina', '$2a$08$2.Qp3Cd8zX3A8Pxq04SjVel8Uzm2er9/NrcJaO5JUylaw.VybT9e.', true);

INSERT INTO user_role (user_id, roles)
VALUES (2, 'USER');
