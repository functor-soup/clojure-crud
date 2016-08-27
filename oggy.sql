create database gintama;
use gintama;
create table polls (id int auto_increment, name varchar(20), rank int, primary key (id));
insert into polls (name,rank) values ('gintoki',1), ('sougo',2),('hijikata',3);
GRANT all privileges ON gintama.* TO 'katsura'@'localhost' IDENTIFIED BY 'elizebethe';
