# drop table user if exists
DROP TABLE IF EXISTS USER;
# USER TABLE
create table USER (
	id bigint(11) not null auto_increment,
  user_name varchar(45) not null,
  password varchar(45) not null,
	first_name varchar(45) default null,  
  last_name varchar(45) default null,
  gender int(1) default null,
	email varchar(60) not null,
	user_type int(2) not null,
	primary key (id)
);