---query 5 final
 Select sod.SalesOrderID as SalesOrderID, sum(sod.UnitPrice) as UnitPrice
from SalesOrderDetail as sod
group by sod.SalesOrderID 
having count(sod.SalesOrderID)=1


--query 6
--select * from SalesOrderHeader

select  distinct(p.Name),c.CompanyName
from Customer c
inner join SalesOrderHeader soh 
on soh.CustomerID =c.CustomerID
inner join SalesOrderDetail sod
on sod.SalesOrderID=soh.SalesOrderID
inner join Product p
on p.ProductID=sod.ProductID
inner join ProductModel pm
on pm.ProductModelID=p.ProductModelID
where pm.Name='Racing Socks'


--query 7 final

 Select count(distinct(sd.ProductID)) 
 from ProductCategory as pc 
 inner join Product  as p
 on pc.ProductCategoryID=p.ProductCategoryID 
 inner join SalesOrderDetail as sd 
 on p.ProductID= sd.ProductID
inner join SalesOrderHeader as sh 
on sd.SalesOrderID=sh.SalesOrderID 
inner join CustomerAddress as ca
on ca.CustomerID=sh.CustomerID 
inner join Address as a 
on a.AddressID=ca.AddressID 
where pc.Name='Cranksets' and a.City='London'


-- final query 8
select sum(SubTotal) as SubTotal, t.CountryRegion 
from  SalesOrderHeader soh
left outer join
( select a.AddressID, a.CountryRegion, ca.CustomerID
from Address a
inner join CustomerAddress ca
on a.AddressID=ca.AddressID
group by a.CountryRegion, a.AddressID, ca.CustomerID
) t
on t.CustomerID= soh.CustomerID
group by t.CountryRegion