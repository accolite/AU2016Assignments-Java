Use Assignment5
Select Distinct ss.CompanyName
From Person.Customer as ss
Where ss.CustomerId IN
(
SELECT Cust.CustomerID
FROM Person.Customer AS Cust
INNER JOIN Sales.SalesOrderHeader As SOH
ON SOH.CustomerID = Cust.CustomerID
GROUP BY Cust.CustomerID
HAVING SUM(SOH.SubTotal+SOH.TaxAmt+SOH.Freight)> 10000
)