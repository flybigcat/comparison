use mysql;

-- 1. create a new database philips

-- create database philips;

-- 2. create a user philips, with password abcd, and grant the user
--    all privileges on the database philips. 

grant all privileges on philips.* to 'philips'@'localhost'
	identified by 'abcd' with grant option;

flush privileges;

-- 3. create a table items with two records.

use philips;

create table items (
	name		varchar(32),
	price		decimal(8,2),
	quantity	int
);

insert into items values ('apple', 1.49, 1);
insert into items values ('banana', 0.79, 2);

create table things (
	name		varchar(32),
	price		decimal(8,2),
	quantity	int
);

insert into things values ('apple', 6.49, 1);
insert into things values ('banana', 0.79, 2);

