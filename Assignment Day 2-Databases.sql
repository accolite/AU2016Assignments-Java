
--Fifth-Query
-----------------------------------------------

select s2.SalesOrderID,sum(s2.UnitPrice) from SalesOrderHeader s1 
	join SalesOrderDetail s2 on s1.SalesOrderID=s2.SalesOrderID  
	group by s2.SalesOrderID 
	having count(s2.SalesOrderID)=1 
----------------------------------------------
--Sixth-Query

select  p.Name ,(c.CompanyName) from Product p
	join ProductModel pm on p.ProductModelID=pm.ProductModelID
	join SalesOrderDetail s1 on p.ProductID=s1.ProductID
	join SalesOrderHeader s2 on s1.SalesOrderID=s2.SalesOrderID
	join Customer c on c.CustomerID=s2.CustomerID where pm.Name='Racing Socks'
-----------------------------------------------
--Seventh-Query

SELECT COUNT(DISTINCT p1.ProductID)
FROM   ProductCategory p2
  JOIN Product p1 ON p1.ProductCategoryID = p2.ProductCategoryID 
  JOIN SalesOrderDetail s1 ON p1.ProductID = s1.ProductID
  JOIN SalesOrderHeader s2 ON s2.SalesOrderID = s1.SalesOrderID
  JOIN Customer c1 ON s2.CustomerID = c1.CustomerID
  JOIN CustomerAddress c2 ON c1.CustomerID = c2.CustomerID
  JOIN Address a1 ON c2.AddressID = a1.AddressID where p2.Name='Cranksets'and a1.City='London';
-----------------------------------------------------------------------------------------------

--Eight-Query

select a1.CountryRegion,sum(s1.SubTotal) 
	from Address a1 
	join SalesOrderHeader s1 on a1.AddressID=s1.ShipToAddressID  
	group by a1.CountryRegion 
	order by sum(s1.SubTotal) desc;

