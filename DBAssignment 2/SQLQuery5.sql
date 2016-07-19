
--A "Single Item Order" is a customer order where only one item is ordered. Show the
--SalesOrderID and the UnitPrice for every Single Item Order.
--query 5
use [DBquery]

select soh.SalesOrderID,sum(sod.UnitPrice)
from Sales.SalesOrderDetail as sod inner join Sales.SalesOrderHeader as soh on soh.SalesOrderID=sod.SalesOrderID
group by soh.SalesOrderID
having count(*)=1