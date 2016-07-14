USE[Database1]

create table Citizen(citizenID int not null, firstname nvarchar(10),lastname nvarchar(10), age int,districtID int not null,citizenflag int not null, primary key(citizenID));

USE[Database2]

create table District(districtID int not null, districtName nvarchar(20),stateID int not null,headID int not null, districtflag int not null,primary key(districtID));


create table State(stateID int not null, stateName nvarchar(20),stateFlag int not null, primary key(stateID));

create table President(presidentID int not null,citizenID int not null, primary key(presidentID));

alter table District
add foreign key(stateID)
references State(stateID);


GO

USE[Database1]
GO

Create Trigger dbo.districtCitizenTrigger ON dbo.Citizen
 After Insert, Update,Delete
As
Begin
   If NOT Exists(select districtID from [Database2].dbo.District where districtID in (Select districtID from inserted))
   BEGIN
      raiserror('error',1,1);
	  rollback transaction;
   END
END


USE[Database2]
GO

Create Trigger dbo.presidentCitizenTrigger ON dbo.President
 After Insert, Update,Delete
As
Begin
   If NOT Exists(select citizenID from [Database1].dbo.Citizen where citizenID in (Select citizenID from inserted))
   BEGIN
      raiserror('error',1,1);
	  rollback transaction;
   END
END

alter table [Database2].District
add foreign key(headID)
references [Database1].Citizen.citizenID;

USE[Database2]
GO

Create Trigger dbo.citizenHeadTrigger ON dbo.District
 After Update,Delete
As
Begin
   If NOT Exists(select citizenID from [Database1].dbo.Citizen where citizenID in (Select citizenID from inserted))
   BEGIN
      raiserror('error',1,1);
	  rollback transaction;
   END
END

USE[Database2]
GO
insert into dbo.State values(1,'Telangana',1);
insert into dbo.State values(2,'Delhi',1);
insert into dbo.State values(3,'UP',1);
INSERT INTO State VALUES ('4',N'Karnataka','1');
INSERT INTO State VALUES('5',N'Maharastra','1');
INSERT INTO State VALUES('6',N'Kerala','1');

select * from dbo.state;

insert into dbo.District values(1,'Hyderabad',1,1,1);
insert into dbo.District values(2,'Rangareddy',1,2,1);
insert into dbo.District values(3,'Nizambad',1,3,1);
insert into dbo.District values(4,'Noida',2,4,1);
insert into dbo.District values(5,'Gurgaon',2,5,1);
insert into dbo.District values(6,'NCR',2,6,1);
insert into dbo.District values(7,'Varansi',3,7,1);
insert into dbo.District values(8,'Ghaziabad',3,8,1);
insert into dbo.District values(9,'Lucknow',3,9,1);

insert into dbo.District values('10',N'Bellandur','4','10','1');
insert into dbo.District values('11',N'KB','4','11','1')
insert into dbo.District values('12',N'MT','4','12','1')
insert into dbo.District values('13',N'AB','5','13','1')
insert into dbo.District values('14',N'BC','5','14','1')
insert into dbo.District values('15',N'Bandra','5','15','1')
insert into dbo.District values('16',N'KEA','6','16','1')
insert into dbo.District values('17',N'KEB','6','17','1')
insert into dbo.District values('18',N'KEC','6','18','1')

select * from dbo.District;

insert into dbo.Citizen values(1,'Lowkya','Vuppu',21,1,1);
insert into dbo.Citizen values(20,'ABC','Reddy',21,1,1);
insert into dbo.Citizen values(21,'DEF','Reddy',21,1,1);
insert into dbo.Citizen values(2,'Mounika','Reddy',21,2,1);
insert into dbo.Citizen values(3,'Hari','Chandana',21,3,1);
insert into dbo.Citizen values(4,'Rezwana','Begum',21,4,1);
insert into dbo.Citizen values(5,'Chandra','Mounika',21,5,1);
insert into dbo.Citizen values(6,'Srujana','Reddy',21,6,1);
insert into dbo.Citizen values(7,'Sushmitha','Sai',21,7,1);
insert into dbo.Citizen values(8,'Shambhavi','Reddy',21,8,1);
insert into dbo.Citizen values(9,'Likitha','CH',21,9,1);
insert into dbo.Citizen values(10,'Lowkya','Vuppu',21,10,1);
insert into dbo.Citizen values(11,'Mounika','Reddy',21,11,1);
insert into dbo.Citizen values(12,'Hari','Chandana',21,12,1);
insert into dbo.Citizen values(13,'Rezwana','Begum',21,13,1);
insert into dbo.Citizen values(14,'Chandra','Mounika',21,14,1);
insert into dbo.Citizen values(15,'Srujana','Reddy',21,15,1);
insert into dbo.Citizen values(16,'Sushmitha','Sai',21,16,1);
insert into dbo.Citizen values(17,'Shambhavi','Reddy',21,17,1);
insert into dbo.Citizen values(18,'Likitha','CH',21,18,1);
insert into dbo.Citizen values(19,'Lowkya','Vuppu',21,1,1);

select * from dbo.Citizen;

insert into dbo.President values(1,19);

select * from dbo.President;

--first

select stateName from dbo.State;

--second

select districtName from dbo.District;

--third
USE[Database1]
GO
select state.stateID SNO,state.stateName StateName,count(citizen.citizenID) Population  from dbo.Citizen citizen join Database2.dbo.District district
on citizen.districtID = district.districtID join
Database2.dbo.State state
on district.stateID =state.stateID group by state.stateName,state.stateID;


--fourth
USE[Database2]
update District set districtflag=0 where districtName='BC';
update Database1.dbo.Citizen set Database1.dbo.Citizen.citizenflag=0 where Database1.dbo.Citizen.districtID IN(select District.districtID where District.districtName='BC');
GO

--sixth
USE[Database2]
select citizen.firstname,citizen.lastname,State.stateName from Database1.dbo.Citizen citizen join 
District on
citizen.districtID=District.districtID
join State
on
District.stateID=State.stateID where State.stateName='Delhi';

--seventh
select citizen.firstname,citizen.lastname,District.districtName from C join 
District on
citizen.districtID=District.districtID and 
citizen.citizenID=District.headID;

--ninth
update Database2.dbo.District set Database2.dbo.District.headID = (select citizen.citizenID from Database1.dbo.Citizen citizen join Database2.dbo.District district
on citizen.districtID=district.districtID where citizen.firstname='ABC' and citizen.lastname='Reddy' and district.districtID=1 and citizen.age < 60);

select * from Database2.dbo.District;
select * from Database1.dbo.Citizen;