
SELECT Cust.CompanyName, SOH.SubTotal, SOH.TaxAmt, SOH.Freight
FROM [Assignment4].[SalesLT].[Customer] AS Cust
INNER JOIN [Assignment4].[SalesLT].[SalesOrderHeader] AS SOH
ON SOH.CustomerID = Cust.CustomerID
WHERE 
(SOH.SubTotal+SOH.TaxAmt+SOH.Freight)> 100000