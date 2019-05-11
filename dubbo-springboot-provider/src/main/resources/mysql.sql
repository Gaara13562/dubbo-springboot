create database db_springboot;
use db_springboot;
create table tbl_user
(
	id int primary key auto_increment,
	name varchar(256) not null,
	age int not null
);