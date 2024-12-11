--liquibase formatted sql

--changeset aprokopenko:4
insert into orders values(1, '21.02.2024', 1, 'Milk', 100);
insert into orders values(2, '21.02.2024', 2, 'Chips', 80);
insert into orders values(3, '21.02.2024', 2, 'Fish', 500);
insert into orders values(4, '21.02.2024', 1, 'Coffee', 330);
insert into orders values(5, '21.02.2024', 1, 'Cookies', 55);

--rollback delete from orders where id='1';
--rollback delete from orders where id='2';
--rollback delete from orders where id='3';
--rollback delete from orders where id='4';
--rollback delete from orders where id='5';