drop database if exists hats;

create database hats;

use hats;

create table hat (
id serial,
hatname varchar(45)
);

insert into hat (hatname) values ('wizard hat'),('viking helmet');