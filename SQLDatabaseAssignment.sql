use SQLDatabaseAssignment


select * from  SalesLT.SalesOrderHeader
SELECT ad.AddressID, ad.AddressLine1, ad.AddressLine2 FROM 
SalesLT.Customer AS c, SalesLT.CustomerAddress AS ca, SalesLT.Address AS ad 
WHERE c.CustomerID=ca.CustomerID AND ca.AddressID=ad.addressID AND c.CompanyName = 'Modular Cycle Systems'




SELECT c.CustomerID, c.FirstName, c.MiddleName, c.LastName, sod.OrderQty, p.ListPrice  
FROM SalesLT.Customer AS c, SalesLT.SalesOrderHeader AS soh, SalesLT.SalesOrderDetail AS sod, SalesLT.Product AS p
WHERE c.CustomerID=soh.CustomerID AND c.CustomerID=635 AND soh.SalesOrderID=sod.SalesOrderID AND sod.ProductID=p.ProductID 



SELECT c.CustomerID, c.FirstName, c.MiddleName, c.LastName, sod.OrderQty, p.ListPrice  
FROM SalesLT.Customer AS c, SalesLT.SalesOrderHeader AS soh, SalesLT.SalesOrderDetail AS sod, SalesLT.Product AS p
WHERE c.CustomerID=soh.CustomerID AND soh.SalesOrderID=sod.SalesOrderID AND sod.ProductID=p.ProductID 

select * from SalesLT.Customer, where CustomerID=635

select * from SalesLT.SalesOrderHeader as c,  SalesLT.SalesOrderHeader AS soh where c.CustomerID=soh.CustomerID



SELECT DISTINCT c.CustomerID, c.CompanyName FROM 
SalesLT.Customer AS c, SalesLT.CustomerAddress AS ca, SalesLT.Address AS ad 
WHERE c.CustomerID=ca.CustomerID AND ca.AddressID=ad.addressID AND ad.City IN ('Dallas')





SELECT c.CompanyName
FROM SalesLT.Customer AS c 
WHERE c.CustomerID IN (SELECT soh.CustomerID from SalesLT.SalesOrderHeader AS soh 
GROUP BY soh.CustomerID HAVING SUM (soh.SubTotal+soh.TaxAmt+soh.Freight)> 100000) 



select count(*) , customerID from SalesLT.SalesOrderHeader group by customerID having count(*)>1

select * from SalesLT.SalesOrderHeader


