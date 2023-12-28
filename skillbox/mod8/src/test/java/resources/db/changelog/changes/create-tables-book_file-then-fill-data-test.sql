--liquibase formatted sql
--changeset drop_create_table_book_file:5
drop table if exists book_file;

create table book_file
(
    id bigserial primary key,
    hash varchar (255),
    type_id INTEGER,
    path varchar (255),
    book_id bigint,
    constraint fk_book foreign key(book_id) references books(id)
);

--changeset fill_table_book_file:6
insert into book_file (id, hash, type_id, path, book_id) values (1, 'fsdl342ladads76432', 1, '/Kissing Jessica Stein.pdf',
                                                                 1);
insert into book_file (id, hash, type_id, path, book_id) values (2, 'fsdlawdaws76432', 2, '/Kissing Jessica Stein.epub',
                                                                 1);
insert into book_file (id, hash, type_id, path, book_id) values (3, 'fsdl3afws4e434576432', 3, '/Kissing Jessica Stein.fb2',
                                                                 1);

insert into book_file (id, hash, type_id, path, book_id) values (4, 'fsdsseff32ngh576432', 3, '/Tape.fb2',
                                                                 2);


