SELECT	DISTINCT [CompanyName] 

FROM	[NewAWAssignment].[SalesLT].[Address] as A ,
		[NewAWAssignment].[SalesLT].[Customer] as C , 
		[NewAWAssignment].[SalesLT].[CustomerAddress] as CA
WHERE	A.AddressID = CA.AddressID AND
		CA.CustomerID = C.CustomerID AND
		A.City = 'Dallas'

