CREATE DATABASE soaprest;

CREATE TABLE users(user_id int primary key identity(1,1), name varchar(50));

CREATE TABLE friendship(
friendship_id int primary key identity(1,1), 
friend1_id int foreign key references users(user_id),
friend2_id int foreign key references users(user_id));

CREATE TABLE posts(
post_id int primary key identity(1,1),
user_id int foreign key references users(user_id),
post_content varchar(100) not null,
time_posted datetime default getdate());

CREATE TABLE likes(
like_id int primary key identity(1,1),
user_id int foreign key references users(user_id),
post_id int foreign key references posts(post_id),
time_liked datetime default getdate());

CREATE TABLE comments(
comment_id int primary key identity(1,1),
user_id int foreign key references users(user_id),
post_id int foreign key references posts(post_id),
comment varchar(100),
time_commented datetime default getdate());



Select * from posts;
select * from users;
select * from comments;
select * from likes;
select * from friendship;
