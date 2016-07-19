Use Assignment5
select ss.SalesOrderID,ss.UnitPrice
From Sales.SalesOrderDetail as ss Join Sales.SalesOrderHeader as s
on ss.SalesOrderID=s.SalesOrderID
Group by ss.SalesOrderID,ss.UnitPrice
having count(*)=1