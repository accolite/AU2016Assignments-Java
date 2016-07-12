SELECT CompanyName,AddressType,AddressLine1,AddressLine2 
FROM AU_assignment.dbo.CustomerAW, AU_assignment.dbo.CustomerAddress,AU_assignment.dbo.Address 
WHERE CustomerAW.CustomerID = CustomerAddress.CustomerID and
CustomerAddress.AddressID = Address.AddressID and 
CustomerAW.CompanyName ='Modular Cycle System'