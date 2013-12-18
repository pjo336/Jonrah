# drop table user if exists
DROP TABLE IF EXISTS USER;
# USER TABLE
create table user (
	id bigint(11) not null auto_increment,
	first_name varchar(45) default null,  
    last_name varchar(45) default null,  
    gender int(1) default null,
	email varchar(60) not null,
	user_type int(2) not null,
	primary key (id)
);

# initial data to enter
insert into User(first_name, last_name, gender, email, user_type)
values("Peter", "Johnston", 0, "pjohnston@biggertime.com", 0);
insert into User(first_name, last_name, gender, email, user_type)
values("David", "Hara", 0, "dhara@biggertime.com", 0);