 drop table tweet;

 CREATE TABLE TWEET( 
  tweet_id Integer identity PRIMARY KEY,
  text Varchar(160) not null,
  fk_user_id Integer 
 );

 drop table user;
 
 CREATE TABLE USER(
  user_id Integer identity PRIMARY KEY,
  first_name Varchar(160) not null,
  last_name Varchar(160) not null,
  email_address Varchar(160) not null,
  username Varchar(160) not null,
  password Varchar(160) not null,
  fk_tweet_id Integer
);

 ALTER TABLE TWEET
    ADD FOREIGN KEY(fk_user_id) 
    REFERENCES public.user(user_id) ;

 ALTER TABLE USER
    ADD FOREIGN KEY(fk_tweet_id) 
    REFERENCES public.tweet(tweet_id) ;
    
     
ALTER TABLE TWEET
ALTER COLUMN fk_user_id Integer 

	
insert into User(first_name,last_name,email_address,username,password) values ('User Test','','','','')
select * from user
insert into Tweet(text,fk_user_id) values ('Tweet Test',1)
insert into Tweet(text) values ('Tweet Test 2')
select * from tweet



	


