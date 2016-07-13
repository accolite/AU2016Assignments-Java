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

SELECT sod.SalesOrderID, SUM(sod.UnitPrice) AS UnitPrice
FROM SalesLT.SalesOrderDetail AS sod
GROUP BY sod.SalesOrderID
HAVING COUNT(sod.ProductID)=1



6

SELECT c.CustomerID, p.Name AS ProductName, c.CompanyName
FROM SalesLT.Product AS p, SalesLT.ProductModel AS pm, SalesLT.SalesOrderDetail AS sod, SalesLT.SalesOrderHeader AS soh, SalesLT.Customer AS c
WHERE pm.Name='Racing Socks' AND pm.ProductModelID=p.ProductModelID AND p.ProductID=sod.ProductID AND sod.SalesOrderID=soh.SalesOrderID AND soh.CustomerID=c.CustomerID


7.

SELECT count(*) AS NumberOfProducts 
FROM SalesLT.SalesOrderHeader AS soh, SalesLT.SalesOrderDetail AS sod, SalesLT.Product AS p, SalesLT.ProductCategory AS pc
WHERE soh.SalesOrderID=sod.SalesOrderID AND sod.ProductID=p.ProductID AND p.ProductCategoryID=pc.ProductCategoryID AND pc.Name='Cranksets'
	AND soh.CustomerID IN (SELECT c.CustomerID 
FROM SalesLT.Customer AS c, SalesLT.CustomerAddress AS ca, SalesLT.Address AS ad
WHERE c.CustomerID=ca.CustomerID AND ca.AddressID=ad.AddressID AND ad.City='London')


8.

SELECT ad.CountryRegion, SUM(soh.SubTotal) AS TotalValue
FROM SalesLT.CustomerAddress AS ca, SalesLT.Address AS ad, SalesLT.SalesOrderHeader AS soh
WHERE ad.AddressID=ca.AddressID AND ca.CustomerID=soh.CustomerID
GROUP BY ad.CountryRegion
ORDER BY TotalValue DESC
