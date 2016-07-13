use [tset_set]
//Quetion1

select * from SalesLT.Customer where CompanyName = 'Modular Cycle Systems';
SELECT ad.AddressID, ad.AddressLine1, ad.AddressLine2, c.CustomerID
FROM 
SalesLT.Customer AS c, SalesLT.CustomerAddress AS ca, SalesLT.Address AS ad 
WHERE c.CustomerID=ca.CustomerID AND ca.AddressID=ad.addressID AND c.CompanyName = 'Modular Cycle Systems'

//Quetion 2
SELECT s.OrderQty,p.Name,p.ListPrice
FROM SalesLT.Product p INNER JOIN SalesLT.SalesOrderDetail s
ON p.ProductId=s.ProductId
inner join SalesLT.SalesOrderHeader s2
on s2.SalesOrderID=s.SalesOrderId
where s2.CustomerID=635

select * from SalesLT.CustomerAddress

//Quetion 3
SELECT DISTINCT cc.CompanyName
FROM SalesLT.Address a INNER JOIN SalesLT.CustomerAddress c
ON a.AddressID=c.AddressId
inner join SalesLT.Customer cc
on c.CustomerID=cc.CustomerID
where a.City='Dallas'

//Quetion 4
SELECT c.CompanyName
FROM SalesLT.SalesOrderHeader s INNER JOIN SalesLT.Customer c
on s.CustomerID=c.CustomerID
where s.SubTotal+s.TaxAmt+s.Freight>100000


//Question 5
SELECT sod.SalesOrderId ,sod.UnitPrice
FROM SalesLT.SalesOrderDetail sod
where sod.SalesOrderId in
(SELECT s.SalesOrderId
FROM SalesLT.SalesOrderDetail s
GROUP BY s.SalesOrderId
HAVING COUNT(s.SalesOrderId)=1);

//Question 6
SELECT c.CompanyName
FROM SalesLT.ProductModel pm
 INNER JOIN SalesLT.Product p ON pm.ProductModelId = p.ProductModelId
 INNER JOIN SalesLT.SalesOrderDetail sod ON sod.ProductId = p.ProductId
 INNER JOIN SalesLT.SalesOrderHeader soh ON soh.SalesOrderID=sod.SalesOrderId
 INNER JOIN SalesLT.Customer c ON c.CustomerID = soh.CustomerID
 where pm.Name='Racing Socks'

 //Question 7
 SELECT count(*) AS NumberOfProducts
FROM SalesLT.SalesOrderHeader AS soh, SalesLT.SalesOrderDetail AS sod, SalesLT.Product AS p, SalesLT.ProductCategory AS pc
WHERE soh.SalesOrderID=sod.SalesOrderID AND sod.ProductID=p.ProductID AND p.ProductCategoryID=pc.ProductCategoryID AND pc.Name='Cranksets' 
 AND soh.CustomerID IN (SELECT c.CustomerID
FROM SalesLT.Customer AS c, SalesLT.CustomerAddress AS ca, SalesLT.Address AS ad
WHERE c.CustomerID=ca.CustomerID AND ca.AddressID=ad.AddressID and ad.City='London')


 //Question 8
 SELECT Sum(soh.SubTotal),a.CountryRegion
FROM SalesLt.SalesOrderHeader soh
 INNER JOIN SalesLT.CustomerAddress ca ON ca.CustomerID = soh.CustomerID
 INNER JOIN SalesLT.Address a ON a.AddressID = ca.AddressId
 GROUP BY a.CountryRegion