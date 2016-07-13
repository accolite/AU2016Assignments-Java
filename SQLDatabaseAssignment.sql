use SQLDatabaseAssignment


select * from  SalesLT.SalesOrderHeader

QUESTION 1.

SELECT ad.AddressID, ad.AddressLine1, ad.AddressLine2 FROM 
SalesLT.Customer AS c, SalesLT.CustomerAddress AS ca, SalesLT.Address AS ad 
WHERE c.CustomerID=ca.CustomerID AND ca.AddressID=ad.addressID AND c.CompanyName = 'Modular Cycle Systems'



QUESTION 2.

SELECT c.CustomerID, c.FirstName, c.MiddleName, c.LastName, sod.OrderQty, p.ListPrice  
FROM SalesLT.Customer AS c, SalesLT.SalesOrderHeader AS soh, SalesLT.SalesOrderDetail AS sod, SalesLT.Product AS p
WHERE c.CustomerID=soh.CustomerID AND c.CustomerID=635 AND soh.SalesOrderID=sod.SalesOrderID AND sod.ProductID=p.ProductID 




SELECT c.CustomerID, c.FirstName, c.MiddleName, c.LastName, sod.OrderQty, p.ListPrice  
FROM SalesLT.Customer AS c, SalesLT.SalesOrderHeader AS soh, SalesLT.SalesOrderDetail AS sod, SalesLT.Product AS p
WHERE c.CustomerID=soh.CustomerID AND soh.SalesOrderID=sod.SalesOrderID AND sod.ProductID=p.ProductID 

select * from SalesLT.Customer, where CustomerID=635

select * from SalesLT.SalesOrderHeader as c,  SalesLT.SalesOrderHeader AS soh where c.CustomerID=soh.CustomerID


QUESTION 3.

SELECT DISTINCT c.CustomerID, c.CompanyName FROM 
SalesLT.Customer AS c, SalesLT.CustomerAddress AS ca, SalesLT.Address AS ad 
WHERE c.CustomerID=ca.CustomerID AND ca.AddressID=ad.addressID AND ad.City IN ('Dallas')



QUESTION 4.

SELECT c.CompanyName
FROM SalesLT.Customer AS c 
WHERE c.CustomerID IN (SELECT soh.CustomerID from SalesLT.SalesOrderHeader AS soh 
GROUP BY soh.CustomerID HAVING SUM (soh.SubTotal+soh.TaxAmt+soh.Freight)> 100000) 


select count(*) , customerID from SalesLT.SalesOrderHeader group by customerID having count(*)>1

select * from SalesLT.SalesOrderHeader




QUESTION 5.

SELECT sod.SalesOrderID, SUM(sod.UnitPrice) AS UnitPrice
FROM SalesLT.SalesOrderDetail AS sod
GROUP BY sod.SalesOrderID
HAVING COUNT(sod.ProductID)=1



QUESTION 6.

SELECT c.CustomerID, p.Name AS ProductName, c.CompanyName
FROM SalesLT.Product AS p, SalesLT.ProductModel AS pm, SalesLT.SalesOrderDetail AS sod, SalesLT.SalesOrderHeader AS soh, SalesLT.Customer AS c
WHERE pm.Name ='Racing Socks' AND pm.ProductModelID=p.ProductModelID AND p.ProductID=sod.ProductID AND sod.SalesOrderID=soh.SalesOrderID AND soh.CustomerID=c.CustomerID


QUESTION 7.

SELECT count(*) AS NumberOfProducts
FROM SalesLT.SalesOrderHeader AS soh, SalesLT.SalesOrderDetail AS sod, SalesLT.Product AS p, SalesLT.ProductCategory AS pc
WHERE soh.SalesOrderID=sod.SalesOrderID AND sod.ProductID=p.ProductID AND p.ProductCategoryID=pc.ProductCategoryID AND pc.Name='Cranksets' 
 AND soh.CustomerID IN (SELECT c.CustomerID
FROM SalesLT.Customer AS c, SalesLT.CustomerAddress AS ca, SalesLT.Address AS ad
WHERE c.CustomerID=ca.CustomerID AND ca.AddressID=ad.AddressID and ad.City='London')



QUESTION 8.

SELECT ad.countryRegion, SUM(soh.SubTotal) AS TotalValue
FROM SalesLT.CustomerAddress As ca, SalesLT.Address AS ad, SalesLT.SalesOrderHeader AS soh
WHERE ad.AddressID=ca.AddressID AND ca.CustomerID=soh.CustomerID
GROUP BY ad.CountryRegion
ORDER BY TotalValue DESC


