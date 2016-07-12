select a.AddressLine1,a.AddressLine2, a.City, a.StateProvince, a.CountryRegion,
a.PostalCode 
from Address as a
inner join CustomerAddress as ca 
on ca.AddressID=a.AddressID 
inner join 
(select CustomerID from Customer as c
where c.CompanyName= 'Modular Cycle Systems') t 
on t.CustomerID =ca.CustomerID ;



select sod.OrderQty as OrderQty, paw.Name as Name, paw.ListPrice as ListPrice
from Product as paw 
inner join SalesOrderDetail as sod 
on sod.ProductID = paw.ProductID 
inner join
( select SalesOrderID from SalesOrderHeader as soh 
where soh.CustomerID= 29660) t
on sod.SalesOrderID=t.SalesOrderID;
 


select distinct(caw.CompanyName) as CompanyName 
from Customer caw
inner join CustomerAddress as ca
on caw.CustomerID= ca.CustomerID
inner join 
(select AddressID from Address as a
where a.City='Dallas') t
on t.AddressID=ca.AddressID;



select caw.CompanyName as CompanyName
from Customer as caw
where CustomerID in (select CustomerID 
						from SalesOrderHeader
						group by CustomerID
						having SUM(SubTotal+TaxAmt+Freight)> $100000);

select * from SalesOrderHeader;

select CustomerID 
						from SalesOrderHeader
						group by CustomerID
						having SUM(SubTotal+TaxAmt+Freight)> $100000;						
					
					
					
					
		
					select * from SalesOrderHeader

					select * from SalesOrderHeader as soh 
								where soh.CustomerID= 29660

								select * from SalesOrderDetail as sod  
								where sod.SalesOrderID= 71796