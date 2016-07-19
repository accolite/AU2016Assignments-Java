Use Assignment5
SElect sss.CountryRegion,Sum(s.Subtotal) as TotalOrder
From Sales.SalesOrderHeader as s Join dbo.CustomerAddress as ss
on s.CustomerId=ss.CustomerId
Join Person.Address as sss
on ss.AddressId=sss.AddressId
Group by sss.CountryRegion
Order by TotalOrder Desc 