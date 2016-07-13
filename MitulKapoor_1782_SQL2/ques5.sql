use [AU_assignment]

select SalesOrderID, UnitPrice
from SalesOrderDetail
where SalesOrderID in
	(select SalesOrderID
	from SalesOrderDetail
	group by SalesOrderID
	having count(SalesOrderID) = 1)