use [AU_assignment]

SELECT OrderQty,Name,ListPrice
FROM SalesOrderHeader,SalesOrderDetail,ProductAW
WHERE SalesOrderHeader.SalesOrderID = SalesOrderDetail.SalesOrderID and
SalesOrderDetail.ProductID = ProductAW.ProductID and CustomerID=635
