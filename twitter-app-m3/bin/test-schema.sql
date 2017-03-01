drop table user;

// if exists; -- this line is put in place of .ignoreFailedDrops(true)in TestDataAccessConfig

 CREATE TABLE user(
  id Integer identity PRIMARY KEY,
  first_name Varchar(160) not null,
  last_name Varchar(160) not null,
  email_address Varchar(160) not null,
  username Varchar(160) not null,
  password Varchar(160) not null,
);

drop table tweet;


 CREATE TABLE tweet(
  id Integer identity PRIMARY KEY,
  author Varchar(160) not null,
  text Varchar(160) not null
);