use FinalSQLDatabase

SELECT * from SalesLT.SalesOrderHeader

1

SELECT c.CustomerID, ad.AddressID, ad.AddressLine1, ad.AddressLine2 
FROM SalesLT.Customer AS c, SalesLT.CustomerAddress AS ca, SalesLT.Address AS ad 
WHERE c.CustomerID=ca.CustomerID AND ca.AddressID=ad.addressID AND c.CompanyName='Modular Cycle Systems'

2

SELECT c.CustomerID, c.FirstName, c.MiddleName, c.LastName, sod.OrderQty, p.ListPrice  
FROM SalesLT.Customer AS c, SalesLT.SalesOrderHeader AS soh, SalesLT.SalesOrderDetail AS sod, SalesLT.Product AS p
WHERE c.CustomerID=soh.CustomerID AND c.CustomerID=635 AND soh.SalesOrderID=sod.SalesOrderID AND sod.ProductID=p.ProductID


3

SELECT DISTINCT c.CustomerID, c.CompanyName
FROM SalesLT.Customer AS c, SalesLT.CustomerAddress AS ca, SalesLT.Address AS ad 
WHERE c.CustomerID=ca.CustomerID AND ca.AddressID=ad.addressID AND ad.City IN ('Dallas')


4

SELECT c.CompanyName
FROM SalesLT.Customer AS c 
WHERE c.CustomerID IN (SELECT soh.CustomerID from SalesLT.SalesOrderHeader AS soh 
GROUP BY soh.CustomerID HAVING SUM(soh.SubTotal+soh.TaxAmt+soh.Freight)> 100000)

5

