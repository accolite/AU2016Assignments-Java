select p.Name,c.CompanyName
from [Assignment4].[SalesLT].[Customer] c inner join [Assignment4].[SalesLT].[SalesOrderHeader] s
on c.CustomerID = s.CustomerID
inner join [Assignment4].[SalesLT].[SalesOrderDetail] sd on sd.SalesOrderID = s.SalesOrderID
inner join [Assignment4].[SalesLT].[Product] p on p.ProductID = sd.ProductID
inner join [Assignment4].[SalesLT].[ProductModel] pm on pm.ProductModelID = p.ProductModelID
where pm.Name = 'Racing Socks' 