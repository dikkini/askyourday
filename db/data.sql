INSERT INTO public.roles (name) VALUES ('user');
INSERT INTO public.roles (name) VALUES ('admin');

INSERT INTO public.users (uuid, username, firstname, lastname, email, password, enabled, accountnonexpired, accountnonlocked, credentialsnonexpired) VALUES ('00000000-user-0000-0000-000000000001', 'dikkini', 'Артур', 'Карапетов', 'dikkini@gmail.com', 'dc429d7bebcf1352572acb5e8e1c5f75fce4807a92f86bd8e650dceacaf72413fabd26950740e728', true, true, true, true);

INSERT INTO public.user_roles (user_uuid, role_id) VALUES ('00000000-user-0000-0000-000000000001', 2);

INSERT INTO public.privilege (name) VALUES ('main');
INSERT INTO public.privilege (name) VALUES ('calendar');

INSERT INTO public.roles_privileges (role_id, privilege_id) VALUES (1, 1);
INSERT INTO public.roles_privileges (role_id, privilege_id) VALUES (1, 2);
INSERT INTO public.roles_privileges (role_id, privilege_id) VALUES (2, 1);
INSERT INTO public.roles_privileges (role_id, privilege_id) VALUES (2, 2);

/* QUESTIONS START */
INSERT INTO public.question (day, month, year) VALUES ('01', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('02', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('03', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('04', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('05', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('06', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('07', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('08', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('09', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('10', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('11', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('12', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('13', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('14', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('15', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('16', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('17', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('18', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('19', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('20', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('21', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('22', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('23', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('24', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('25', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('26', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('27', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('28', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('29', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('30', '01', '2017');
INSERT INTO public.question (day, month, year) VALUES ('31', '01', '2017');

/* ru */
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (1, 'Как тебя зовут?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (2, 'Как у тебя дела?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (3, 'Когда у тебя день рождение?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (4, 'Что ты кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (5, 'Как ты кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (6, 'Как тебя зовут?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (7, 'Как у тебя дела?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (8, 'Когда у тебя день рождение?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (9, 'Что ты кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (10,'Как ты 10 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (11,'Как ты 11 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (12,'Как ты 12 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (13,'Как ты 13 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (14,'Как ты 14 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (15,'Как ты 15 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (16,'Как ты 16 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (17,'Как ты 17 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (18,'Как ты 18 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (19,'Как ты 19 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (20,'Как ты 20 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (21,'Как ты 21 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (22,'Как ты 22 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (23,'Как ты 23 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (24,'Как ты 24 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (25,'Как ты 25 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (26,'Как ты 26 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (27,'Как ты 27 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (28,'Как ты 28 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (29,'Как ты 29 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (30,'Как ты 30 кушал сегодня?', 'ru');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (31,'Как ты 31 кушал сегодня?', 'ru');
/* en */
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (1, 'What is your name?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (2, 'How do u do?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (3, 'When is your bd?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (4, 'What do u eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (5, 'How do u eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (6, 'What is your name?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (7, 'How is your business?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (8, 'When bd?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (9, 'What eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (10,'How u 10 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (11,'How u 11 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (12,'How u 12 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (13,'How u 13 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (14,'How u 14 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (15,'How u 15 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (16,'How u 16 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (17,'How u 17 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (18,'How u 18 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (19,'How u 19 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (20,'How u 20 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (21,'How u 21 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (22,'How u 22 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (23,'How u 23 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (24,'How u 24 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (25,'How u 25 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (26,'How u 26 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (27,'How u 27 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (28,'How u 28 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (29,'How u 29 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (30,'How u 30 eat?', 'en');
INSERT INTO public.question_translation (question_id, question_text, language) VALUES (31,'How u 31 eat?', 'en');
/* QUESTIONS END */

/*
TEST
 */

INSERT INTO public.user_answer(uuid, user_uuid, question_id, answer) VALUES ('00000000-user-answ-er00-000000000001', '00000000-user-0000-0000-000000000001', 1, 'Артур');
INSERT INTO public.user_answer(uuid, user_uuid, question_id, answer) VALUES ('00000000-user-answ-er00-000000000002', '00000000-user-0000-0000-000000000001', 2, 'Нормально');
INSERT INTO public.user_answer(uuid, user_uuid, question_id, answer) VALUES ('00000000-user-answ-er00-000000000003', '00000000-user-0000-0000-000000000001', 3, '18 марта');
INSERT INTO public.user_answer(uuid, user_uuid, question_id, answer) VALUES ('00000000-user-answ-er00-000000000004', '00000000-user-0000-0000-000000000001', 4, 'Кашу');
INSERT INTO public.user_answer(uuid, user_uuid, question_id, answer) VALUES ('00000000-user-answ-er00-000000000005', '00000000-user-0000-0000-000000000001', 5, 'Руками');
