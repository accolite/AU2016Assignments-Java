
--Show the total order value for each CountryRegion. List by value with the highest first.
--8th query
use [DBquery]
select pa.countryregion,sum(subtotal)
from Sales.SalesOrderHeader as soh full outer join dbo.CustomerAddress as ca on ca.CustomerID=soh.CustomerID
        inner join Person.Address as pa on ca.AddressID=pa.AddressID
		group by(pa.countryregion)
		order by sum(subtotal) DESC