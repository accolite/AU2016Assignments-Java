select count(distinct(sd.ProductID)) as TotalNumber
from [Assignment4].[SalesLT].[SalesOrderHeader] sh inner join [Assignment4].[SalesLT].[Address] a
on a.AddressID = sh.ShipToAddressID
inner join [Assignment4].[SalesLT].[SalesOrderDetail] sd on sd.SalesOrderID=sh.SalesOrderID
inner join [Assignment4].[SalesLT].[Product] p on p.ProductID = sd.ProductID
inner join [Assignment4].[SalesLT].[ProductCategory] pc on pc.ProductCategoryID = p.ProductCategoryID
where a.City = 'London' and pc.Name = 'Cranksets'


