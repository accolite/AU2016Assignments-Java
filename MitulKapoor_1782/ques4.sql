use [AU_assignment]

select CustomerAW.CompanyName
from CustomerAW,SalesOrderHeader
where CustomerAW.CustomerID = SalesOrderHeader.CustomerID and
(SalesOrderHeader.Freight + SalesOrderHeader.SubTotal + SalesOrderHeader.TaxAmt) > 4000
