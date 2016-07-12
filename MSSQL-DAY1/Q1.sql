SELECT A.[AddressID]
      ,A.[AddressLine1]
      ,A.[AddressLine2]
      ,A.[City]
      ,A.[StateProvince]
      ,A.[CountryRegion]
      ,A.[PostalCode]

FROM	[NewAWAssignment].[SalesLT].[Address] as A ,
		[NewAWAssignment].[SalesLT].[Customer] as C , 
		[NewAWAssignment].[SalesLT].[CustomerAddress] as CA

WHERE	A.AddressID = CA.AddressID AND
		CA.CustomerID = C.CustomerID AND
		C.CompanyName = 'Modular Cycle Systems';

