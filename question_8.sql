
SELECT SUM(SubTotal) from (SalesOrderHeader as SH join CustomerAddress as CA on SH.CustomerID = CA.CustomerID join Address AS A ON A.AddressID = CA.AddressID) GROUP BY CountryRegion Order by SUM(SubTotal) DESC
