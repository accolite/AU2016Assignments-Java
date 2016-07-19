
--How many products in ProductCategory 'Cranksets' have been sold to an address in 'London'? 
--query 7
use [DBquery]

select count(p.ProductID)
from
 Production.ProductCategory as pc INNER JOIN Production.Product as p ON p.ProductCategoryID=pc.ProductCategoryID
  --INNER JOIN Production.Product as p ON pm.ProductModelID=p.ProductModelID
    INNER JOIN  Sales.SalesOrderDetail as so on so.ProductID=p.ProductID
	 INNER JOIN Sales.SalesOrderHeader as soh  on soh.SalesOrderID=so.SalesOrderID
     INNER JOIN dbo.Customer as c on c.CustomerID=soh.CustomerID
	 INNER JOIN dbo.CustomerAddress as ca on c.CustomerID=ca.CustomerID
	 INNER JOIN Person.Address as pa on pa.AddressID=ca.AddressID
	 where pc.Name='Cranksets' and pa.City='London'