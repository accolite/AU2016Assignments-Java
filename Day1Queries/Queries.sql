USE [AdventureWorks2014]
GO

Select a.AddressId,a.AddressLine1,a.AddressLine2
from dbo.CustomerAW as c
JOIN dbo.CustomerAddress as ca
	on c.CustomerID=ca.CustomerID
JOIN dbo.Address as a
	on a.AddressID=ca.AddressID
where c.CompanyName='Modular Cycle Systems';
 GO