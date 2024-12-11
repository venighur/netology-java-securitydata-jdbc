--liquibase formatted sql

--changeset aprokopenko:2
create table orders (
  id serial primary key,
  date date not null,
  customer_id int not null,
  product_name varchar(100) not null,
  amount int not null,
  foreign key (customer_id) references customers(id)
);

--rollback drop table orders;
