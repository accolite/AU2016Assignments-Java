use master
GO

create database VideoPortal

use VideoPortal
create table UserTable
(
user_id int IDENTITY(1,1) primary key not null,
firstname varchar(max),
lastname varchar(max),
email_id varchar(max)
);


create table GroupTable
(

group_id int IDENTITY(1,1) PRIMARY KEY ,
groupname nvarchar(450) not null,
Unique(groupname)
);


create table SiteAdminTable
(
user_id int primary key not null,
FOREIGN KEY (user_id) REFERENCES UserTable(user_id)
on delete cascade
);


create table GroupUserTable
(
group_id int ,
user_id int,
FOREIGN KEY (user_id) REFERENCES UserTable(user_id) on delete cascade,
FOREIGN KEY (group_id) REFERENCES GroupTable(group_id) on delete cascade
);


create table EventTable
(
event_id int IDENTITY(1,1) PRIMARY KEY ,
eventname nvarchar(450) not null,
Unique(eventname),
dateOfEvent date

);

create table VideoTable
(
video_id int IDENTITY(1,1) PRIMARY KEY ,
user_id int ,
Approval_id int  ,
Privacy varchar(max),
Title varchar(max),
Topic varchar(max),
event_id int ,
statusflag int default 0 not null,
url varchar(max) not null,
FOREIGN KEY (user_id) REFERENCES UserTable(user_id),
FOREIGN KEY (Approval_id) REFERENCES UserTable(user_id) ,
FOREIGN KEY (event_id) REFERENCES EventTable(event_id)
);



create table CommentsTable
(
comment_id int IDENTITY(1,1) PRIMARY KEY ,
user_id int not null,
video_id int not null,
comment_description varchar(max),
comment_time datetime not null,
FOREIGN KEY (user_id) REFERENCES UserTable(user_id) on delete cascade,
FOREIGN KEY (video_id) REFERENCES VideoTable(video_id) on delete cascade
);



create table GroupVideoTable
(
group_id int ,
video_id int,
creation_time datetime,
FOREIGN KEY (video_id) REFERENCES VideoTable(video_id) on delete cascade,
FOREIGN KEY (group_id) REFERENCES GroupTable(group_id) on delete cascade
);

create table GroupAdminTable
(
group_id int ,
admin_id int,
Foreign key(admin_id) REFERENCES UserTable(user_id) on delete cascade,
FOREIGN KEY (group_id) REFERENCES GroupTable(group_id) on delete cascade
);