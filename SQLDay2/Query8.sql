select addr.CountryRegion,sum(SubTotal) as finalcolumn
from Address as addr full outer join 
	 SalesOrderHeader as soh on (addr.AddressID=soh.BillToAddressID)
	 group by addr.CountryRegion
	 order by finalcolumn desc