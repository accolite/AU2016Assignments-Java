--Q1
select * from Address where AddressID IN (SELECT AddressID from CustomerAddress join CustomerAW on CustomerAW.CustomerID = CustomerAddress.CustomerID where CompanyName = 'Modular Cycle Systems');


--Q2
select Name, ListPrice, OrderQty from (SalesOrderHeader as sh join SalesOrderDetail as sd on sh.SalesOrderID = sd.SalesOrderID ) join ProductAW as p on sd.ProductID = p.ProductID where sh.CustomerID = '635' ;

--Q3
select CompanyName from CustomerAW where CustomerID IN (SELECT CustomerID from CustomerAddress join Address on Address.AddressID = CustomerAddress.AddressID where City = 'Dallas');

--Q4
select CompanyName from CustomerAW where CustomerID in( select CustomerID from SalesOrderHeader Group By CustomerID Having (Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight)>100000));

--Q5
select SalesOrderID, UnitPrice from SalesLT.SalesOrderDetail where SalesOrderID IN (select SalesOrderID from SalesLT.SalesOrderDetail group by(SalesOrderID) having count(SalesOrderID)=1);

--Q6
select p.name,c.CompanyName from SalesLT.Customer c JOIN SalesLT.SalesOrderHeader s ON c.CustomerID = s.CustomerID 
JOIN SalesLT.SalesOrderDetail  s1 ON s.SalesOrderID = s1.SalesOrderID 
JOIN SalesLT.Product p ON s1.ProductID = p.ProductID  
JOIN SalesLT.ProductModel p2 ON p.ProductModelID = p2.ProductModelID
 where p2.Name = 'Racing Socks';

 --Q7

 SELECT count(*) as No_Of_Products
from SalesLT.Product product, SalesLT.ProductCategory category, SalesLT.SalesOrderDetail detail, SalesLT.SalesOrderHeader header, SalesLT.Customer customer, SalesLT.CustomerAddress ca, SalesLT.Address addr
where category.Name = 'Cranksets'
AND product.ProductCategoryID = category.ProductCategoryID
AND detail.ProductID = product.ProductID
AND detail.SalesOrderID = header.SalesOrderID
AND header.CustomerID = customer.CustomerID
AND customer.CustomerID = ca.CustomerID
AND ca.AddressID = addr.AddressID
AND addr.City = 'London'

--Q8

select TotalOrderValue=Sum(header.SubTotal) 
from SalesLT.SalesOrderHeader header
 JOIN SalesLT.CustomerAddress ca on header.CustomerID=ca.CustomerID JOIN SalesLT.Address ad 
 on ca.AddressID=ad.AddressID
Group by ad.CountryRegion
Order by Sum(header.SubTotal) desc;
