select s.SalesOrderID,sum(p.ListPrice) UnitPrice
from [Assignment4].[SalesLT].[Product] p inner join [Assignment4].[SalesLT].[SalesOrderDetail] s
on p.ProductID = s.ProductID
group by s.SalesOrderID
having count(s.ProductID) = 1