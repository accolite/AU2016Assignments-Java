USE [Database2]
GO

Create table Citizen(
citizen_id int primary key,name nvarchar(50),age int,flag int,district_id int)
GO

Insert into Citizen
values
(1,'Jayesh',22,1,1),
(2,'Rajesh',22,1,2),
(3,'Sunil',22,1,1),
(4,'Lingappa',50,1,2),
(5,'Mohit',22,1,3),
(6,'Rohan',24,1,3),
(7,'Priya',25,1,4),
(8,'Komal',25,1,4),
(9,'Smruti',22,1,5),
(10,'Monica',22,1,5),
(11,'Sachin',60,1,6),
(12,'Ankush',43,1,6),
(13,'Chirag',32,1,7),
(14,'Juhi',55,1,7),
(15,'Gagan',47,1,8),
(16,'Sumit',46,1,8)
GO


