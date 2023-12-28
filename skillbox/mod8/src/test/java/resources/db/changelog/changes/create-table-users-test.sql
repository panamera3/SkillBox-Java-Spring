--liquibase formatted sql
--changeset drop_create_table_users:7
drop table if exists users;

create table users
(
    id bigserial primary key,
    name varchar (255),
    email varchar (255),
    phone varchar (255),
    password varchar (255)
);



