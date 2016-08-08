select * from events;

drop table roles;

drop table roles_users;

drop table participants;

drop table groups;

drop table admins;

drop table users;

create table admins(
_id int primary key identity(1,1),
name varchar(50),
email_id varchar(50) unique not null);

create table users(
_id int primary key identity(1,1),
name varchar(50),
email_id varchar(50) unique not null);


create table roles(
_id int primary key identity(0,1),
role_name varchar(30) not null,
);

create table roles_users(
user_id int foreign key references users,
event_id int foreign key references events on delete cascade,
role_id int foreign key references roles,
primary key(user_id, event_id, role_id)
);


create table groups(
group_id int primary key identity(1,1),
event_id int foreign key references events on delete cascade,
group_name varchar(30) not null,
points int default 0
);

create table participants(
user_id int not null foreign key references users,
group_id int not null foreign key references groups,
event_id int not null foreign key references events on delete cascade,
primary key(user_id,group_id,event_id)
);