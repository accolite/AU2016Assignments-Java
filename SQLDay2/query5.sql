select SalesOrderID,UnitPrice
from SalesOrderDetail
where SalesOrderID in (
select SalesOrderID 
from SalesOrderDetail  
group by SalesOrderID
having count(*) = 1 and sum(OrderQty) >= 1)  