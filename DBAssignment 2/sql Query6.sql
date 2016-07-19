
--List the product name and the CompanyName for all Customers who ordered ProductModel 'Racing Socks'.
--query 6
use [DBquery]

select Distinct c.CompanyName
from Production.ProductModel as pm INNER JOIN Production.Product as p ON pm.ProductModelID=p.ProductModelID
    INNER JOIN  Sales.SalesOrderDetail as so on so.ProductID=p.ProductID
	 INNER JOIN Sales.SalesOrderHeader as soh  on soh.SalesOrderID=so.SalesOrderID
     INNER JOIN dbo.Customer as c on c.CustomerID=soh.CustomerID
	 where pm.Name='Racing Socks'