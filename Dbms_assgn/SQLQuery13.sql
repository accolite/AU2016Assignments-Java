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

