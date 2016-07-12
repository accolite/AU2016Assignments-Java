use [AU_assignment]

Select CustomerAW.CompanyName, CustomerAW.FirstName 
from CustomerAW, CustomerAddress, Address
where CustomerAW.CustomerID = CustomerAddress.CustomerID and 
CustomerAddress.AddressID = Address.AddressID and 
Address.City = 'Dallas' 