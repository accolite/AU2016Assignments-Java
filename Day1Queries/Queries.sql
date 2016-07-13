USE [AdventureWorks2014]
GO
--Q1
Select a.AddressId,a.AddressLine1,a.AddressLine2
from dbo.CustomerAW as c
JOIN dbo.CustomerAddress as ca
	on c.CustomerID=ca.CustomerID
JOIN dbo.Address as a
	on a.AddressID=ca.AddressID
where c.CompanyName='Modular Cycle Systems';
 GO
 --Q2
 SELECT sod.OrderQty,p.Name,p.ListPrice
  FROM dbo.SalesOrderHeader as soh 
  JOIN dbo.SalesOrderDetail as sod
  on soh.SalesOrderID=sod.SalesOrderId
  JOIN dbo.Product as p
  on p.ProductID=sod.ProductID
WHERE CustomerID='635'


--Q3
--SELECT DISTINCT CompanyName
--FROM   CustomerAW as CAW
--  JOIN CustomerAddress CA ON CAW.CustomerID = CA.CustomerID
--  JOIN Address ADR ON CA.AddressID = ADR.AddressID
--WHERE  City = 'Dallas';



 --Q3
 select caw.CompanyName 
 from dbo.CustomerAW as caw 
 where caw.CustomerID IN (SELECT CustomerID 
						   from dbo.CustomerAddress as ca 
						   join Address as a 
						   on a.AddressID = ca.AddressID 
						   where a.City = 'Dallas');

 --Q4
 
--Q4wrong one
--SELECT c.CompanyName
--FROM CustomerAW AS c 
--WHERE c.CustomerID IN (SELECT soh.CustomerID from SalesOrderHeader AS soh 
--WHERE (soh.SubTotal+soh.TaxAmt+soh.Freight)> 100000)
 --Select *
-- from dbo.SalesOrderHeader

select caw.customerid
from SalesOrderHeader as soh
join CustomerAW as caw
on soh.CustomerID=caw.customerid
group by caw.CustomerID
having Sum(soh.SubTotal +soh.TaxAmt+soh.Freight)>100000


