--liquibase formatted sql

--changeset aprokopenko:1
create table customers (
  id serial primary key,
  name varchar(255) not null,
  surname varchar(255) not null,
  age int,
  phone_number varchar(20)
);

--rollback drop table customers;