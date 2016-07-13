
select CompanyName from CustomerAW where CustomerID IN (SELECT CustomerID from CustomerAddress join Address on Address.AddressID = CustomerAddress.AddressID where City = 'Dallas');
