--Question1--
select * from Address where AddressID IN (SELECT AddressID from CustomerAddress join CustomerAW 
on CustomerAW.CustomerID = CustomerAddress.CustomerID 
where CompanyName = 'Modular Cycle Systems');

--Question2--
select * from SalesOrderHeader JOIN SalesOrderDetail 
on SalesOrderHeader.SalesOrderID=SalesOrderDetail.SalesOrderID Join ProductAW 
on SalesOrderDetail.ProductID=ProductAW.ProductID where SalesOrderHeader.CustomerID=29957;

--Question3--
select CompanyName from CustomerAW where CustomerID IN (SELECT CustomerID 
from CustomerAddress join Address on Address.AddressID = CustomerAddress.AddressID 
where City = 'Dallas');

--Question4--
select CompanyName from CustomerAW where CustomerID in( select CustomerID 
from SalesOrderHeader Group By CustomerID Having (Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight)>100000));

--Question5--
select * from SalesOrderDetail
select * from ProductAW

select SalesOrderID, UnitPrice from SalesOrderDetail where SalesOrderID 
IN (select SalesOrderID from SalesOrderDetail 
Group by(SalesOrderID) 
Having count(SalesOrderID)=1);


-- solution 2
select DISTINCT SalesOrderID, Count(DISTINCT ProductCategoryID) from SalesOrderDetail sod Join ProductAW pa on sod.ProductID=pa.ProductID
Group by SalesOrderID
Order by SalesOrderID;


--Question6--
Select pa.Name , ca.CompanyName from CustomerAW ca Join SalesOrderHeader soh on ca.CustomerID=soh.CustomerID Join SalesOrderDetail sod 
on soh.SalesOrderID=sod.SalesOrderID Join  ProductAW pa on sod.ProductID=pa.ProductID  Join  ProductModel pm 
on pa.ProductModelID=pm.ProductModelID
where pm.Name='Racing Socks';

--Question7--
select * from Address ad Join CustomerAddress cad on ad.AddressID=cad.AddressID Join SalesOrderHeader soh 
on cad.CustomerID=soh.CustomerID Join SalesOrderDetail sod on soh.SalesOrderID=sod.SalesOrderID 
Join ProductAW pa on sod.ProductID=pa.ProductID Join ProductCategory pc on pa.ProductCategoryID=pc.ProductCategoryID
  where ad.City='London' and pc.Name='Cranksets';


--Question8--
select TotalOrderValue=Sum(soh.SubTotal) 
from SalesOrderHeader soh
 JOIN CustomerAddress cadd on soh.CustomerID=cadd.CustomerID JOIN Address ad 
 on cadd.AddressID=ad.AddressID
Group by ad.CountryRegion
Order by Sum(soh.SubTotal) desc;   

