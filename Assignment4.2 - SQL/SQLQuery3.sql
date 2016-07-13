USE assignmentFinal
GO

-- query 4

select  C.CompanyName from
SalesOrderHeader SOH 
join SalesOrderDetail SOD 
ON SOH.SalesOrderID=SOD.SalesOrderID 
join CustomerAddress CA ON CA.CustomerID = SOH.CustomerID 
JOIN Customer C ON C.CustomerID = CA.CustomerID 
where C.CustomerID 
IN (select C.CustomerID from SalesOrderHeader SOH 
join SalesOrderDetail SOD ON SOH.SalesOrderID=SOD.SalesOrderID 
join CustomerAddress CA ON CA.CustomerID = SOH.CustomerID 
JOIN Customer C ON C.CustomerID = CA.CustomerID 
GROUP BY(C.CustomerID) 
HAVING sum(OrderQty*(UnitPrice-UnitPriceDiscount)+SOH.Freight+SOH.SubTotal+SOH.TaxAmt)> $100000)
Go




-- query 5
SELECT soh.SalesOrderID, sod.UnitPrice 
FROM SalesOrderHeader soh INNER JOIN SalesOrderDetail sod
ON soh.SalesOrderID = sod.SalesOrderID
WHERE soh.SalesOrderID IN (SELECT soh.SalesOrderID
FROM SalesOrderHeader soh INNER JOIN SalesOrderDetail sod
ON soh.SalesOrderID = sod.SalesOrderID
GROUP BY (soh.SalesOrderID)
HAVING (COUNT(sod.SalesOrderDetailID)= 1));
GO





-- query 6

SELECT pm.Name, c.CompanyName 
FROM ProductModel pm INNER JOIN Product p 
ON pm.ProductModelID = p.ProductModelID 
INNER JOIN SalesOrderDetail sod 
ON sod.ProductID = p.ProductID
INNER JOIN SalesOrderHeader soh
ON soh.SalesOrderID = sod.SalesOrderID
INNER JOIN CustomerAddress ca
ON soh.CustomerID = ca.CustomerID
INNER JOIN Customer c
ON ca.CustomerID = c.CustomerID
WHERE pm.Name = 'Racing Socks';
GO




--query 7
 
SELECT COUNT(*)
FROM ProductCategory pc 
INNER JOIN Product p
ON pc.ProductCategoryID = p.ProductCategoryID
INNER JOIN SalesOrderDetail sod
ON p.ProductID = sod.ProductID
INNER JOIN SalesOrderHeader soh
ON soh.SalesOrderID = sod.SalesOrderID
INNER JOIN CustomerAddress ca
ON soh.CustomerID = ca.CustomerID
INNER JOIN Address a
ON ca.AddressID = a.AddressID
WHERE pc.Name = 'Cranksets' AND a.city = 'London';
GO






-- query 8

SELECT a.CountryRegion AS 'Country', SUM(soh.SubTotal) AS 'Total Order' 
FROM SalesOrderHeader soh
INNER JOIN CustomerAddress ca
ON soh.CustomerID = ca.CustomerID
INNER JOIN Address a
ON ca.AddressID = a.AddressID
GROUP BY (a.CountryRegion);
GO