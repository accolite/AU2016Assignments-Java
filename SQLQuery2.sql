SELECT OrderQty,Name,ListPrice
  FROM [Assignment4].[SalesLT].[SalesOrderHeader],[Assignment4].[SalesLT].[SalesOrderDetail] ,
                [Assignment4].[SalesLT].[Product]
WHERE CustomerID=635