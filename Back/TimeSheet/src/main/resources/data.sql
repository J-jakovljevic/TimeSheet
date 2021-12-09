insert into users(name,surname,email,username,password) values ('Jovana', 'Jakovljevic', 'jovanajako@gmail.com', 'j_jakovljevic', 'j123')
insert into roles(name) values ('admin')
insert into roles(name) values ('employee')
insert into users_roles(user_id, roles_id) values (1, 1)