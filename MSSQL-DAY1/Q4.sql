SELECT		DISTINCT C.CompanyName
FROM		[NewAWAssignment].[SalesLT].[Customer] AS C
INNER JOIN	[NewAWAssignment].[SalesLT].[SalesOrderHeader] AS SOH
		
ON SOH.CustomerID = C.CustomerID
GROUP BY C.CompanyName
HAVING SUM(SOH.SubTotal+SOH.TaxAmt+SOH.Freight) > 100000 
