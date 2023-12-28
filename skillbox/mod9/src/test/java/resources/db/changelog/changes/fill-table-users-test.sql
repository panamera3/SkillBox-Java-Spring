--liquibase formatted sql
--changeset drop_create_table_users:8

insert into users (email, name, password, phone)
values ('koshaevk@gmail.com', 'Kirill', '$2a$10$klXmtKUs.cXgFiyVytrs5u9lNHFUBuGHFGozh1x0SOco3kIACwyPK', '9031232323');


