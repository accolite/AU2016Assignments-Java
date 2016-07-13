
 select Name, ListPrice, OrderQty from (SalesOrderHeader as sh join SalesOrderDetail as sd on sh.SalesOrderID = sd.SalesOrderID ) join ProductAW as p on sd.ProductID = p.ProductID where sh.CustomerID = '635' ;
