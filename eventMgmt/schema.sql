create database eventmgmt;

create table admins(
_id int primary key identity(1,1),
name varchar(50) not null,
email_id varchar(50) not null);

create table users(
_id int primary key identity(1,1),
name varchar(50) not null,
email_id varchar(50) not null);

create table roles(
_id int primary key identity(1,1),
role_name varchar(30) not null,
);

create table events(
_id int primary key identity(1,1),
event_name varchar(40) not null,
description varchar(200),
type varchar(10),
start_time datetime,
end_time datetime,
venue varchar(50));

create table roles_users(
user_id int foreign key references users,
event_id int foreign key references events,
role_id int foreign key references roles,
primary key(user_id, event_id, role_id));

create table groups(
group_id int not null,
event_id int foreign key references events,
group_name varchar(30) not null,
points int not null,
primary key(group_id, event_id));


create table participants(
user_id int not null foreign key references users,
group_id int not null,
event_id int not null,
primary key(user_id,group_id,event_id),
foreign key(group_id, event_id) references groups(group_id, event_id));