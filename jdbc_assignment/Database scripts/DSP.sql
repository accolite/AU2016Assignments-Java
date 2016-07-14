USE [Database1]
GO

Create table District(
	district_id int primary key ,name nvarchar(50), state_id int foreign key references [State], head_id int, flag int)

GO

Create table State(
	state_id int primary key,name nvarchar(50),president_id int foreign key references President )
GO

Create table President(
	president_id int primary key,citizen_id int)
GO


INSERT INTO District
values
(1,'Pune',1,2,1),
(2,'Ahmdabad',1,4,1),
(3,'Jalna',2,5,1),
(4,'Haryana',2,7,1),
(5,'Bhopal',3,10,1),
(6,'Mys',3,12,1),
(7,'HighG',4,15,1),
(8,'Caster',4,13,1)

INSERT INTO State
values
(1,'Maharashtra',1),
(2,'Punjab',1),
(3,'Madhya Pradesh',1),
(4,'Westeros',1)

INSERT INTO President
values
(1,8)

/Query 3

SELECT state.name as StateName, citizen.name as Name_of_Citizen
     FROM Database2.dbo.Citizen citizen, Database1.dbo.District district
     WHERE citizen.district_id = district.district_id
     
	 AND state.name = 'Punjab'
	 /*AND citizen.flag = 1
     GROUP BY state.name, district.state_id*/

	 SELECT citizen.name as Head_of_District
    FROM Database2.dbo.Citizen citizen,  Database1.dbo.District district
    
    WHERE district.head_id = citizen.citizen_id 
    AND district.name = 'Pune'

AlTER Trigger verify_district on Citizen
     After Insert
     As Begin

     IF NOT EXISTS(SELECT * from District where district_id = (SELECT district_id from inserted))
     Begin 
     RAISERROR('District ID does not exist',1,1)
     rollback transaction  
     End
END
     GO

DROP Trigger verify_district
GO

CREATE Trigger verify_head on District
     After Insert
     As Begin

     IF NOT EXISTS(SELECT * from Citizen where citizen_id = (SELECT head_id from inserted))
     Begin 
     RAISERROR('Head doesnt exist as a Citizen',1,1)
     rollback transaction  
     End
END
     GO

CREATE Trigger verify_president on President
     After Insert
     As Begin

     IF NOT EXISTS(SELECT * from Citizen where citizen_id = (SELECT citizen_id from inserted))
     Begin 
     RAISERROR('President doesnt exist as a Citizen',1,1)
     rollback transaction  
     End
END
     GO

