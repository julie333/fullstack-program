drop table users if exists;

create table users (
	id bigint generated by default as identity (start with 1),
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	age integer not null,
	primary key (id)
);

drop table address if exists;

create table address (
	id bigint generated by default as identity (start with 1),
	street varchar(50) not null,
	city varchar(50) not null,
	country integer not null,
	primary key (id)
);