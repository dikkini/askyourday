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
INSERT INTO public.question (question, day, month, year) VALUES ('Как тебя зовут?', '01', '12', '2016');
INSERT INTO public.question (question, day, month, year) VALUES ('Как у тебя дела?', '02', '12', '2016');
INSERT INTO public.question (question, day, month, year) VALUES ('Когда у тебя день рождение?', '03', '12', '2016');
INSERT INTO public.question (question, day, month, year) VALUES ('Что ты кушал сегодня?', '04', '12', '2016');
INSERT INTO public.question (question, day, month, year) VALUES ('Как ты кушал сегодня?', '05', '12', '2016');

INSERT INTO public.question (question, day, month, year) VALUES ('Как тебя зовут?', '01', '01', '2017');
INSERT INTO public.question (question, day, month, year) VALUES ('Как у тебя дела?', '02', '01', '2017');
INSERT INTO public.question (question, day, month, year) VALUES ('Когда у тебя день рождение?', '03', '01', '2017');
INSERT INTO public.question (question, day, month, year) VALUES ('Что ты кушал сегодня?', '04', '01', '2017');
INSERT INTO public.question (question, day, month, year) VALUES ('Как ты кушал сегодня?', '05', '01', '2017');
/* QUESTIONS END */

/*
TEST
 */

INSERT INTO public.user_answer(uuid, user_uuid, question_id, answer) VALUES ('00000000-user-answ-er00-000000000001', '00000000-user-0000-0000-000000000001', 1, 'Артур');
INSERT INTO public.user_answer(uuid, user_uuid, question_id, answer) VALUES ('00000000-user-answ-er00-000000000002', '00000000-user-0000-0000-000000000001', 2, 'Нормально');
INSERT INTO public.user_answer(uuid, user_uuid, question_id, answer) VALUES ('00000000-user-answ-er00-000000000003', '00000000-user-0000-0000-000000000001', 3, '18 марта');
INSERT INTO public.user_answer(uuid, user_uuid, question_id, answer) VALUES ('00000000-user-answ-er00-000000000004', '00000000-user-0000-0000-000000000001', 4, 'Кашу');
INSERT INTO public.user_answer(uuid, user_uuid, question_id, answer) VALUES ('00000000-user-answ-er00-000000000005', '00000000-user-0000-0000-000000000001', 5, 'Руками');
