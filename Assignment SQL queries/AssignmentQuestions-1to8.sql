--Q1
select * from Address where AddressID IN (SELECT AddressID from CustomerAddress join CustomerAW on CustomerAW.CustomerID = CustomerAddress.CustomerID where CompanyName = 'Modular Cycle Systems');

select * from CustomerAW where CompanyName='Modular Cycle Systems';
--Q2
select SalesOrderDetail.OrderQty, ProductAW.Name,ProductAW.ListPrice from
SalesOrderDetail inner join ProductAW ON SalesOrderDetail.ProductID = ProductAW.ProductID
inner join SalesOrderHeader ON SalesOrderDetail.SalesOrderID = SalesOrderHeader.SalesOrderID
where SalesOrderHeader.CustomerID = 635;

--Q3
select  CompanyName from CustomerAW Join CustomerAddress on(CustomerAW.CustomerID=CustomerAddress.CustomerID) where 

AddressID in(select AddressID from Address where City='Dallas')
--Q4
select CompanyName from CustomerAW where CustomerID in( select CustomerID from SalesOrderHeader Group By CustomerID Having 

(Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight)>100000));

--Q5

Select SalesOrderDetail.SalesOrderID,SalesOrderDetail.UnitPrice from SalesOrderDetail where SalesOrderID in (select sod.SalesOrderID from SalesOrderDetail as sod inner join SalesOrderHeader as soh 
on (sod.SalesOrderID = soh.SalesOrderID) group by sod.SalesOrderID having count(sod.SalesOrderID) = 1) ; 

--select SalesOrderID, UnitPrice from SalesOrderDetail where OrderQty = 1;
 --Q6

 select  distinct paw.Name , caw.CompanyName 
 from CustomerAW as caw inner join SalesOrderHeader as soh on (caw.CustomerID=soh.CustomerID)
 inner join SalesOrderDetail as sod on (soh.SalesOrderID = sod.SalesOrderID) inner join ProductAW as paw on 
 (sod.ProductID = paw.ProductID) inner join ProductModel as pm on (paw.ProductModelID = pm.ProductModelID)  where pm.Name = N'Racing Socks';

 --select Name from ProductModel;
 --Q7

 select COUNT (distinct(paw.ProductID))
 from ProductCategory as pc inner join ProductAW as paw on (pc.ProductCategoryID = paw.ProductCategoryID)
 inner join SalesOrderDetail as sod on (paw.ProductID = sod.ProductID)
 inner join SalesOrderHeader as soh on (sod.SalesOrderID = soh.SalesOrderID)
 inner join CustomerAddress as ca on (soh.CustomerID = ca.CustomerID)
 inner join Address as ad on (ca.AddressID = ad.AddressID) where ad.City = 'London' AND pc.Name = 'Cranksets'; 

 --select Address.CountryRegion from Address;
 --select * from ProductCategory ;--where ProductCategory.Name = 'Cranksets';
 --select ProductAW.ProductID from ProductAW where ProductCategoryID = 12;
 --Q8

 select ad.CountryRegion, sum(SubTotal) as TotalOrderValue from Address as ad left join SalesOrderHeader as soh on (ad.AddressID = soh.BillToAddressID) Group by ad.CountryRegion order by sum(SubTotal) desc;

 select distinct Address.CountryRegion from Address; 