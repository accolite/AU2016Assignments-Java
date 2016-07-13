use[Assignment]

--Query 1
--Show all the addresses listed for Company Name 'Modular Cycle Systems'
SELECT CompanyName,AddressType,AddressLine1,AddressLine2,City
  FROM SalesLT.Customer caw JOIN SalesLT.CustomerAddress ca
     ON (caw.CustomerID=ca.CustomerID)
    JOIN SalesLT.Address ad
    ON (ca.AddressID=ad.AddressID)
 WHERE CompanyName='Modular Cycle Systems';

--Query 2 
--Show OrdeQty, the Name and the ListPrice of the order made by CustomerID 635
SELECT OrderQty,Name,ListPrice
  FROM SalesLT.SalesOrderHeader soh join SalesLT.SalesOrderDetail sod
  on soh.SalesOrderID=sod.SalesOrderID 
  JOIN SalesLT.Product p
  on p.ProductID = sod.ProductID
WHERE soh.CustomerID=635;

--Query 3
--Show the CompanyName for all customers with an address in City 'Dallas'
SELECT CompanyName 
FROM SalesLT.Customer caw join SalesLT.CustomerAddress ca 
ON  caw.CustomerID=ca.CustomerID
JOIN SalesLT.Address ad
    ON (ca.AddressID=ad.AddressID)
	where ad.city like 'Dallas';

--Query 4
--Give the CompanyName of those customers with orders over $100000. Include the subtotal plus tax plus freight.
select CompanyName from SalesLT.Customer
where CustomerID in (select caw.CustomerID
FROM SalesLT.Customer caw join SalesLT.SalesOrderHeader soh
ON  caw.CustomerID=soh.CustomerID where (soh.SubTotal+soh.TaxAmt+soh.Freight) >100000)


--5
--A "Single Item Order" is a customer order where only one item is ordered. Show the SalesOrderID and the UnitPrice for every Single Item Order
SELECT OrderQty, SalesOrderID, UnitPrice 
FROM SalesLT.SalesOrderDetail 
WHERE SalesOrderID IN (
	SELECT SalesOrderID 
	FROM SalesLT.SalesOrderDetail 
	GROUP BY(SalesOrderID) 
	HAVING SUM(OrderQty)=1 
)
GO

--6
--List the product name and the CompanyName for all Customers who ordered ProductModel 'Racing Socks'.
DROP VIEW CustomerTable
GO

CREATE View SalesLT.CustomerTable
AS SELECT soh.CustomerID 
FROM SalesLT.SalesOrderHeader soh join SalesLT.SalesOrderDetail sod
on soh.SalesOrderId = sod.SalesOrderId
join SalesLT.Product p on sod.ProductId=p.ProductId
join SalesLT.ProductModel pm on pm.ProductModelID=p.ProductModelID
Where pm.Name='Racing Socks';

Go

SELECT distinct CompanyName 
FROM SalesLT.CustomerTable cv join SalesLT.Customer cu 
on cu.CustomerId=cv.CustomerId

SELECT Name 
FROM SalesLT.Product 
Where ProductModelID IN (
	SELECT ProductModelID 
	FROM SalesLT.ProductModel 
	Where Name='Racing Socks') AND EXISTS(SELECT * FROM SalesLT.CustomerTable)


--Query 7
--How many products in ProductCategory 'Cranksets' have been sold to an address in 'London'?
select count(*) from SalesLT.Address ad join SalesLT.SalesOrderHeader soh 
	on ad.AddressId=soh.ShipToAddressID
	join SalesLT.SalesOrderDetail sod on soh.SalesOrderId=sod.SalesOrderID
	join SalesLT.Product p on sod.ProductID=p.ProductID
	join SalesLT.ProductCategory pc on pc.ProductCategoryId=p.ProductCategoryId
	where ad.City='London' and pc.Name='Cranksets'


--Query 8
--Show the total order value for each CountryRegion. List by value with the highest first
select CountryRegion,SUM(soh.SubTotal+soh.TaxAmt+soh.Freight) CountryTotalOrder 
from SalesLT.SalesOrderHeader soh full join SalesLT.Address ad 
on soh.BillToAddressId=ad.AddressId
group by ad.CountryRegion 
order by 2 desc
