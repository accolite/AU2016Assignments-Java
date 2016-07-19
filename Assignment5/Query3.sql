USe Assignment5
SELECT DISTINCT CAW.CompanyName
FROM   Person.Customer as CAW 
  JOIN dbo.CustomerAddress as CA ON CAW.CustomerID = CA.CustomerID
  JOIN Person.Address as  ADR ON CA.AddressID = ADR.AddressID
WHERE ADR.City = 'Dallas';
