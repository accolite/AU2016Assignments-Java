Use assign7;
Go

Select AddressLine1, AddressLine2, City,StateProvince,CountryRegion
from Customer cw join CustomerAddress ca on cw.CustomerID =ca.CustomerID join Address a on a.AddressID=ca.AddressID
where CompanyName = 'Modular Cycle Systems'
Go

select OrderQty,Name,ListPrice
from SalesOrderHeader soh join SalesOrderDetail sod on soh.SalesOrderID=sod.SalesOrderID join Product paw on sod.ProductID=paw.ProductID 
where CustomerID =635

select distinct CompanyName
from Customer cw join CustomerAddress ca on cw.CustomerID =ca.CustomerID join Address a on a.AddressID=ca.AddressID
where City = 'Dallas'
Go

select distinct CompanyName from
Customer c1 where CustomerID=(select CustomerID from SalesOrderHeader SOH join SalesOrderDetail SOD ON SOH.SalesOrderID=SOD.SalesOrderID GROUP BY(CustomerID) HAVING sum(OrderQty*(UnitPrice-UnitPriceDiscount)+SOH.Freight+SOH.SubTotal+SOH.TaxAmt)> $100000)
Go



