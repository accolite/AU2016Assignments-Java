select * from admins
insert into admins (name,email_id) values('monika dangi','monika.dangi@accoliteindia.com')

select * from events

insert into events (event_name,description,type,start_time, end_time,venue) values('Techkriti', 'Technical event for great tech minds','individual',GETDATE(),GETDATE(),'Seminar hall');
insert into events (event_name,description,type,start_time, end_time,venue) values('Kalakriti', 'Cultural fest, bring your critivity out','individual',GETDATE(),GETDATE(),'Seminar hall 2');
insert into events (event_name,description,type,start_time, end_time,venue) values('Add- diction', 'cultural event for marketing and advertisement bizz','Group',GETDATE(),GETDATE(),'Seminar hall 3');
insert into events (event_name,description,type,start_time, end_time,venue) values('Soap-Opera', 'Bring your inside character out','Group',GETDATE(),GETDATE(),'Seminar hall');
insert into events (event_name,description,type,start_time, end_time,venue) values('Nukkad', 'Let the street sing along','individual',GETDATE(),GETDATE(),'Seminar hall');
insert into events (event_name,description,type,start_time, end_time,venue) values('Sing-a-sing', 'Singing event for you','individual',GETDATE(),GETDATE(),'Seminar hall');
insert into events (event_name,description,type,start_time, end_time,venue) values('Ding-Dong Dance Event', 'Bring your Inside Micheal Jackson outside','individual',GETDATE(),GETDATE(),'Seminar hall');

select * from users

insert into users(name,email_id) values('monika dangi','monika.dangi@accoliteindia.com');
insert into users(name,email_id) values('Sharukh Mohamed','sharukh.mohamed@accoliteindia.com');
insert into users(name,email_id) values('Padmaja Ramesh','padmaja.ramesh@accoliteindia.com');
insert into users(name,email_id) values('sumeet  kumar','sumeet.kumar@accolitelabs.com');

select * from roles


insert into roles(role_name) values('user');

insert into roles(role_name) values('organizer');

select * from roles;
select * from roles_users;

insert into roles_users(user_id,event_id,role_id) values(1,1,1);
insert into roles_users(user_id,event_id,role_id) values(1,2,0);
insert into roles_users(user_id,event_id,role_id) values(2,1,0);
insert into roles_users(user_id,event_id,role_id) values(2,2,1);
insert into roles_users(user_id,event_id,role_id) values(3,3,0);
insert into roles_users(user_id,event_id,role_id) values(1,3,0);
insert into roles_users(user_id,event_id,role_id) values(2,3,0);
insert into roles_users(user_id,event_id,role_id) values('4','3','0');

select * from groups;


insert into groups(event_id,group_name,points) values(2,'monika dangi',10);
insert into groups(event_id,group_name,points) values(1,'Sharukh Mohamed',10);
insert into groups(event_id,group_name,points) values(3,'Legends',10);
select * from participants;

insert into participants(user_id,group_id,event_id) values(1,1,2);
insert into participants(user_id,group_id,event_id) values(2,2,1);
insert into participants(user_id,group_id,event_id) values(1,3,3);
insert into participants(user_id,group_id,event_id) values(2,3,3);
insert into participants(user_id,group_id,event_id) values(3,3,3);

select * from admins;
select * from roles_users;

select * from events;
