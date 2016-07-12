SELECT DISTINCT CompanyName
FROM   [Assignment4].[SalesLT].[Customer] Caw
  JOIN [Assignment4].[SalesLT].[CustomerAddress] Ca ON Caw.CustomerID = Ca.CustomerID
  JOIN [Assignment4].[SalesLT].[Address] ADR ON Ca.AddressID = ADR.AddressID
WHERE  City = 'Dallas';
