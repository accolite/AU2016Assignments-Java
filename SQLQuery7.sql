select * from CustomerAddress
select * from CustomerAW

--Question1

Select Address.AddressLine1, Address.AddressLine2,Address.City,Address.CountryRegion,Customer.CompanyName
from Customer
inner join CustomerAddress on Customer.customerid = CustomerAddress.customerid 
inner join Address on CustomerAddress.AddressId = Address.AddressId 
where Customer.CompanyName = 'Modular Cycle Systems'

--Question 2
Select SalesOrderDetail.OrderQty, Product.Name, Product.ListPrice
from SalesOrderDetail 
inner join SalesOrderHeader on SalesOrderDetail.SalesOrderID =SalesOrderHeader.SalesOrderID 
inner join Product on Product.ProductID = SalesOrderDetail.ProductID
where SalesOrderHeader.CustomerID = 29660


--Question 3

Select Customer.CompanyName,Customer.FirstName
from Customer
inner join CustomerAddress on Customer.customerid = CustomerAddress.customerid 
inner join Address on CustomerAddress.AddressId = Address.AddressId 
where Address.City = 'Dallas'

--Question 4
Select Customer.customerid, Customer.CompanyName
from Customer
where Customer.customerid IN(
    Select Customer.customerid from Customer inner join SalesOrderHeader
	on Customer.customerid = SalesOrderHeader.CustomerID
	group by Customer.customerid
	having 
	sum(SalesOrderHeader.Freight+SalesOrderHeader.SubTotal+SalesOrderHeader.TaxAmt) > 100000
	)

--Question 5
select SalesOrderDetail.SalesOrderID,SalesOrderDetail.UnitPrice 
 from SalesOrderHeader inner join SalesOrderDetail 
 on SalesOrderDetail.SalesOrderID=SalesOrderHeader.SalesOrderID and SalesOrderDetail.SalesOrderID in
 (
 select SalesOrderDetail.SalesOrderID 
 from SalesOrderDetail 
  group by SalesOrderDetail.SalesOrderID 
 having count(*)=1 )


--Question 6
select DISTINCT Customer.companyname
from ProductModel  
inner join Product on Product.ProductModelID=ProductModel.ProductModelID 
inner join SalesOrderDetail on Product.ProductID=SalesOrderDetail.ProductID
inner join SalesOrderHeader on SalesOrderDetail.SalesOrderID=SalesOrderHeader.SalesOrderID 
inner join Customer on Customer.CustomerID=SalesOrderHeader.CustomerID where ProductModel.Name like 'Racing Socks';


--Question 7

select count(*)
from Address as a inner join CustomerAddress ca on a.AddressID = ca.AddressID
inner join SalesOrderHeader as soh on ca.CustomerID = soh.CustomerID
inner join SalesOrderDetail as sod on sod.SalesOrderID = soh.SalesOrderID
inner join Product as p on sod.ProductID = p.ProductID
inner join ProductCategory as pc on pc.ProductCategoryID = p.ProductCategoryID
where a.City LIKE 'London' and pc.Name='Cranksets'

--Question 8
select sum(SalesOrderHeader.SubTotal)
from address inner join CustomerAddress 
on Address.addressid=CustomerAddress.addressid inner join SalesOrderHeader
on CustomerAddress.customerid=SalesOrderHeader.CustomerID 
group by Address.CountryRegion;