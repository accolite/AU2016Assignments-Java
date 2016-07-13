use [AU_assignment]

select CountyRegion,sum(SubTotal) as TotalAmount
from ((SalesOrderHeader inner join CustomerAddress
		on SalesOrderHeader.CustomerID = CustomerAddress.CustomerID)
		inner join Address on Address.AddressID = CustomerAddress.AddressID)
		group by CountyRegion 
		order by TotalAmount desc