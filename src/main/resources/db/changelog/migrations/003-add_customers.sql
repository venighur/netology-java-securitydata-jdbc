--liquibase formatted sql

--changeset aprokopenko:3
insert into customers values(1, 'John', 'Dow', 34, '001');
insert into customers values(2, 'Jane', 'Dow', 32, '002');

--rollback delete from customers where id='1';
--rollback delete from customers where id='2';