IF NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'Org')
	CREATE DATABASE Org

IF NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'People')
	CREATE DATABASE People

IF OBJECT_ID('Org.dbo.President', 'U') IS NOT NULL
	DROP TABLE Org.dbo.President;
CREATE TABLE Org.dbo.President ( ID int IDENTITY(1,1) PRIMARY KEY, CitizenID int) 
	
IF OBJECT_ID('Org.dbo.State', 'U') IS NOT NULL
	DROP TABLE Org.dbo.State;
CREATE TABLE Org.dbo.State ( ID smallint IDENTITY(1,1) PRIMARY KEY, Name nvarchar(50), PresidentID int FOREIGN KEY REFERENCES Org.dbo.President, Active smallint default 1) 

	ALTER TABLE [State]
	ADD FOREIGN KEY (PresidentID) REFERENCES President

	
IF OBJECT_ID('Org.dbo.District', 'U') IS NOT NULL
	DROP TABLE Org.dbo.District;
CREATE TABLE Org.dbo.District ( ID smallint IDENTITY(1,1) PRIMARY KEY, Name nvarchar(50), StateID smallint FOREIGN KEY REFERENCES Org.dbo.State, Head int, Active smallint default 1)

IF OBJECT_ID('People.dbo.District', 'U') IS NOT NULL
	DROP TABLE People.dbo.Citizen;
CREATE TABLE People.dbo.Citizen ( ID smallint IDENTITY(1,1), Name nvarchar(100), Age smallint, Active smallint DEFAULT 1, DistrictID smallint);


INSERT INTO Org.dbo.State (Name) values
	('Tamilnadu'),
	('Kerala'),
	('Andhra'),
	('Karnataka'),
	('Maharashtra');

SELECT * FROM Org.dbo.State

INSERT INTO Org.dbo.District (Name, StateID) values
	('Chennai', 1),
	('Madurai', 1),
	('Kochin', 2),
	('Munnar', 2),
	('Hyderabad', 3),
	('Nellur', 3),
	('Bangalore', 4),
	('Pune', 5);

SELECT * FROM Org.dbo.District;
SELECT * FROM People.dbo.Citizen;
GO



GO

CREATE TRIGGER [dbo].[PreventDistrictIntegrity] ON [dbo].[Citizen]
INSTEAD OF INSERT
AS
BEGIN
	SET NOCOUNT ON;
	IF EXISTS (SELECT * FROM Org.dbo.District WHERE ID= (SELECT DistrictID FROM INSERTED))
		INSERT INTO People.dbo.Citizen (Name, Age, DistrictID, Active) 
			SELECT Name, Age, DistrictID, 1 FROM INSERTED
	ELSE
		RAISERROR ( 'DISTRICT ID DOES NOT EXIST', 1, 1);
END;

GO
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('Ganesh', 24, 1);
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('Kishore', 23, 1);
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('Rajesh', 23, 2);
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('Azar', 23, 2);
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('Karthik', 23, 3);
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('A', 24, 3);
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('B', 27, 4);
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('C', 32, 5);
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('D', 65, 5);
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('E', 60, 6);
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('F', 39, 8);
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('G', 28, 9);
INSERT INTO People.dbo.Citizen(Name, Age, DistrictID) values
	('G', 28, 13);

SELECT * FROM People.dbo.Citizen

GO

CREATE TRIGGER [dbo].[CitizenIntegrityOnDistrict] ON [dbo].District
AFTER UPDATE
AS
BEGIN
	SET NOCOUNT ON;
	IF (SELECT Head FROM inserted) IS NOT NULL
		IF NOT EXISTS (SELECT * FROM People.dbo.Citizen WHERE ID = (SELECT Head FROM inserted) AND DistrictID = (SELECT ID FROM inserted))
			BEGIN
				RAISERROR ( 'CITIZEN ID DOES NOT EXIST OR NOT BELONG TO CURRENT DISTRICT', 1, 1);
				ROLLBACK TRANSACTION
			END
END;

GO

CREATE TRIGGER [dbo].[CitizenIntegrityOnPresidentInsert] ON [dbo].President
AFTER INSERT
AS
BEGIN
	SET NOCOUNT ON;
	IF NOT EXISTS (SELECT * FROM People.dbo.Citizen WHERE ID IN (SELECT CitizenID FROM inserted))
		BEGIN
			RAISERROR ( 'CITIZEN ID DOES NOT EXIST', 1, 1);
			ROLLBACK TRANSACTION
		END
END;


INSERT INTO Org.dbo.District (Name, StateID) values
	('Chennai', 1),
	('Madurai', 1),
	('Kochin', 2),
	('Munnar', 2),
	('Hyderabad', 3),
	('Nellur', 3),
	('Bangalore', 4),
	('Pune', 5);

UPDATE Org.dbo.District SET Head = 1 WHERE ID = 1  
UPDATE Org.dbo.District SET Head = 4 WHERE ID = 2 
UPDATE Org.dbo.District SET Head = 5 WHERE ID = 3  
UPDATE Org.dbo.District SET Head = 7 WHERE ID = 4  
UPDATE Org.dbo.District SET Head = 9 WHERE ID = 5  
UPDATE Org.dbo.District SET Head = 10 WHERE ID = 6  
UPDATE Org.dbo.District SET Head = 1 WHERE ID = 7  
UPDATE Org.dbo.District SET Head = 11 WHERE ID = 8  

CREATE TRIGGER [dbo].[DistrictIntegrityOnCitizen] ON [dbo].Citizen
AFTER INSERT, UPDATE
AS
BEGIN
	SET NOCOUNT ON;
	IF NOT EXISTS (SELECT * FROM Org.dbo.District WHERE ID IN (SELECT DistrictID FROM inserted))
		BEGIN
			RAISERROR ( 'District ID DOES NOT EXIST', 1, 1);
			ROLLBACK TRANSACTION
		END
END;


CREATE TRIGGER DeleteDistrict 
ON District
INSTEAD OF DELETE
AS
BEGIN
	UPDATE People.dbo.Citizen SET Active = 0 WHERE Citizen.DistrictID IN (SELECT ID FROM deleted);
	UPDATE District SET Active=0 WHERE ID IN (SELECT ID FROM deleted);
END

CREATE TRIGGER DeleteState 
ON Org.dbo.[State]
INSTEAD OF DELETE
AS
BEGIN
	UPDATE Org.dbo.[State] SET Active = 0 WHERE Org.dbo.[State].ID IN (SELECT ID FROM deleted);
	UPDATE Org.dbo.District SET Active=0 WHERE Org.dbo.District.StateID IN (SELECT ID FROM deleted);
	UPDATE People.dbo.Citizen SET Active = 0 WHERE People.dbo.Citizen.DistrictID IN (SELECT ID FROM District WHERE Active=0);
END