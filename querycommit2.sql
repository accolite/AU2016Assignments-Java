
use SalesLT
select  ad.* from 
 Address as ad INNER JOIN CustomerAddress as ca ON ad.AddressId=ca.AddressId  
 inner join Customer aw on ca.CustomerId=aw.CustomerID
 where aw.CompanyName like '%Modular Cycle Systems%';



 
 --q2 ans
select p.ProductID,p.Name,p.ListPrice,sod.OrderQty 
from  SalesOrderHeader as soh 
inner join SalesOrderDetail as sod on sod.SalesOrderID=soh.SalesOrderID
inner join Product  as p on sod.ProductID=p.ProductID
where soh.CustomerID=29660; 



 

 --q3 ans

select aw.FirstName,aw.CompanyName,aw.CustomerID 
from Address as ad
INNER JOIN CustomerAddress as ca ON ad.AddressId=ca.AddressId 
inner join Customer aw on ca.CustomerId=aw.CustomerID
where ad.City='Dallas';





 --q4 ans
 
select  aw.CustomerID,aw.CompanyName 
from Customer as aw where aw.CustomerID 
in 
(
select sod.CustomerID  
from SalesOrderHeader  as sod group by (sod.CustomerID)
having sum(sod.Freight+sod.SubTotal+sod.TaxAmt)>100000
);






 /*q5 ans*/

 select sod.SalesOrderID,sod.UnitPrice 
 from SalesOrderHeader soh inner join SalesOrderDetail sod 
 on sod.SalesOrderID=soh.SalesOrderID and sod.SalesOrderID in
 (
 select sod.SalesOrderID 
 from SalesOrderDetail sod
  group by sod.SalesOrderID 
 having count(*)=1 )





/*q6 ans*/
select aw.companyname
from ProductModel pm 
inner join Product p on p.ProductModelID=pm.ProductModelID 
inner join SalesOrderDetail sod on p.ProductID=sod.ProductID
inner join SalesOrderHeader soh on sod.SalesOrderID=soh.SalesOrderID 
inner join Customer aw on aw.CustomerID=soh.CustomerID where pm.Name like 'Racing Socks';



/*q8*/





select sum(soh.SubTotal) as SumSubtotal
from address a inner join CustomerAddress ca  
on a.addressid=ca.addressid inner join SalesOrderHeader soh
on ca.customerid=soh.CustomerID 
group by a.CountryRegion;






/*q7*/
select count(*)
from Address as a inner join CustomerAddress ca on a.AddressID = ca.AddressID
inner join SalesOrderHeader as soh on ca.CustomerID = soh.CustomerID
inner join SalesOrderDetail as sod on sod.SalesOrderID = soh.SalesOrderID
inner join Product as p on sod.ProductID = p.ProductID
inner join ProductCategory as pc on pc.ProductCategoryID = p.ProductCategoryID
where a.City LIKE 'London' and pc.Name='Cranksets'