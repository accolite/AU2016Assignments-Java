 --2
 use [DBquery]
 SELECT cc.OrderQty,ccc.Name,ccc.ListPrice
  FROM Sales.SalesOrderHeader as c JOIN Sales.SalesOrderDetail as cc on c.SalesOrderID=cc.SalesOrderID
   JOIN Production.Product as ccc on cc.ProductID=ccc.ProductID
	where c.CustomerID=29660;