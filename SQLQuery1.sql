SELECT CompanyName,AddressType,AddressLine1,City,StateProvince,CountryRegion,PostalCode
  FROM [Assignment4].[SalesLT].[Customer] JOIN [Assignment4].[SalesLT].[CustomerAddress]
    ON ([Assignment4].[SalesLT].[Customer].[CustomerID]=[Assignment4].[SalesLT].[CustomerAddress].[CustomerID])
                  JOIN [Assignment4].[SalesLT].[Address]
    ON ([Assignment4].[SalesLT].[CustomerAddress].[AddressID]=[Assignment4].[SalesLT].[Address].[AddressID])
 WHERE CompanyName='Modular Cycle Systems'


