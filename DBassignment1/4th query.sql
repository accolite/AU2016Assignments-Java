--4

use[DBquery]
Select Distinct s.CompanyName
From dbo.Customer as s
Where s.CustomerId IN
(
SELECT Distinct Cust.CustomerID
FROM dbo.Customer AS Cust
INNER JOIN Sales.SalesOrderHeader As SOH
ON SOH.CustomerID = Cust.CustomerID
GROUP BY Cust.CustomerID
HAVING SUM(SOH.SubTotal+SOH.TaxAmt+SOH.Freight)> 10000
)

