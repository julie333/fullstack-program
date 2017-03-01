 drop table tweet;

 CREATE TABLE TWEET( 
  id Integer identity PRIMARY KEY,
  text Varchar(160) not null,
  author Varchar(160) not null
 );

 drop table user;
 
 CREATE TABLE USER(
  id Integer identity PRIMARY KEY,
  first_name Varchar(160) not null,
  last_name Varchar(160) not null,
  email_address Varchar(160) not null,
  username Varchar(160) not null,
  password Varchar(160) not null,
);

insert into User(first_name,last_name,email_address,username,password) values ('User Test','','','','')
select * from user

select * from users
truncate table users

insert into Tweet(text,author) values ('Tweet Test','Author Test')
select * from tweet

select * from Tweet where locate('bla',text) > 0



	


