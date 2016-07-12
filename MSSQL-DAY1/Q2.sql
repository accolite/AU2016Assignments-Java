SELECT	SOD.OrderQty,
		P.ListPrice,
		p.Name
		

FROM	[NewAWAssignment].[SalesLT].[Product] as P ,
		[NewAWAssignment].[SalesLT].[SalesOrderHeader] as SOH , 
		[NewAWAssignment].[SalesLT].[SalesOrderDetail] as SOD

WHERE	SOH.CustomerID = 635 AND
		SOD.SalesOrderID = SOH.SalesOrderID AND
		P.ProductID = SOD.ProductID



		