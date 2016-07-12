
--Final 1

SELECT AddressLine1, AddressLine2 , City, 'Modular Cycle Systems' as Company FROM Address WHERE AddressID 
IN(
	SELECT AddressID FROM CustomerAddress ca join  Customer c 
	on ca.CustomerID = c.CustomerID AND c.CompanyName='Modular Cycle Systems'
)
GO

/*Optimized --@author: Naveen Kumar */
SELECT * FROM CustomerAddress ca 
    join  
	Customer c 
	ON 
	ca.CustomerID = c.CustomerID AND  c.CompanyName='Modular Cycle Systems'
	join 
	Address a
	ON a.AddressID = ca.AddressID

--Custom 2
SELECT sd.OrderQty, p.Name, p.ListPrice 
FROM SalesOrderHeader as sh, SalesOrderDetail as sd, Product as p 
WHERE sh.CustomerID=29660 and sh.SalesOrderID = sd.SalesOrderID and sd.ProductID=p.ProductID; 
GO

--Final 2
SELECT sd.OrderQty, p.Name, p.ListPrice 
FROM SalesOrderHeader as sh join SalesOrderDetail as sd 
on sh.CustomerID=29660 and sh.SalesOrderID = sd.SalesOrderID 
join Product p on sd.ProductID=p.ProductID; 
GO

--Test 2
Select * from SalesOrderHeader where CustomerID=29660;

--Final 3

select CompanyName from Customer where CustomerID IN (
select CustomerID from CustomerAddress where AddressID in
 ( select AddressID from Address where City = 'Dallas' )
 )


--Final 4
select CompanyName from Customer where CustomerID
IN ( select distinct CustomerID from SalesOrderHeader where SubTotal + TaxAmt + Freight > 100000 ) 
 

--Final 5
select s.OrderQty,s.SalesOrderID, s.UnitPrice FROM SalesOrderDetail s WHERE SalesOrderID in (
	select d.SalesOrderID FROM SalesOrderDetail d 
	GROUP BY(d.SalesOrderID) HAVING SUM(d.OrderQty)=1	
);

--Final 6

SELECT p.name, c.companyname from Product p
join ProductModel pm on pm.ProductModelID=p.ProductModelID and pm.Name='Racing Socks'
join SalesOrderDetail sod on sod.ProductID=p.ProductID
join SalesOrderHeader soh on soh.SalesOrderID = sod.SalesOrderID
join Customer c on c.CustomerID = soh.CustomerID;

--Final 7

SELECT COUNT(*) AS CranksetsShippedToLondon from Product p where ProductCategoryID in (	
	 SELECT ProductCategoryID from ProductCategory
	 join SalesOrderDetail sod on Name='Cranksets' 
	 and sod.ProductID = p.ProductID
	 join SalesOrderHeader soh on soh.SalesOrderID = sod.SalesOrderID
	 join Address a on soh.ShipToAddressID = a.AddressID
);


--Final 8
--Show the total order value for each CountryRegion. 

SELECT SUM(TaxAmt+SubTotal+Freight) as CountryTotal from SalesOrderHeader soh
join Address a on soh.BillToAddressID = a.AddressID
group by(CountryRegion) ORDER BY 1 DESC;
