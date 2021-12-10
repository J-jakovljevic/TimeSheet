insert into users(name,surname,email,username,password, house_number_as_child, first_job_city, grandmother_name, first_pet_name, oldest_child_name, first_concert, first_car_model, parents_meet_city, favorite_place_as_child, dream_job_as_child) values ('Jovana', 'Jakovljevic', 'jovanajako@gmail.com', 'j_jakovljevic', 'j123', '38', '', 'Radojka', 'Miki', '', 'Zdravko Colic', 'peugeot', 'Novi Sad', 'Bar', 'uciteljica')
insert into roles(name) values ('admin')
insert into roles(name) values ('employee')
insert into users_roles(user_id, roles_id) values (1, 1)