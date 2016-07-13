select a.[CountryRegion],sum(soh.SubTotal) TotalOrderValue
from [Assignment4].[SalesLT].[Customer] c inner join [Assignment4].[SalesLT].[CustomerAddress] ca
	on (c.CustomerID = ca.CustomerID)
	inner join [Assignment4].[SalesLT].[Address] a
	on (a.AddressID = ca.AddressID)
	inner join [Assignment4].[SalesLT].[SalesOrderHeader] soh
	on (soh.CustomerID= c.CustomerID)
group by a.CountryRegion

