--question 5
(select sod.SalesOrderID, SUM( UnitPrice ) from SalesOrderDetail as sod 
group by sod.SalesOrderID
having count(sod.SalesOrderID) = 1)


SELECT * FROM SalesOrderDetail
     INNER JOIN SalesOrderHeader ON SalesOrderDetail.SalesOrderID = SalesOrderHeader.SalesOrderID
   WHERE SalesOrderDetail.SalesOrderID = 71776


--question 6
select  caw.CompanyName,cid.Name from dbo.Customer as caw join
(select soh.CustomerID,pm.Name from dbo.SalesOrderHeader as soh join dbo.SalesOrderDetail as sod
on soh.SalesOrderID = sod.SalesOrderID join
(select paw.ProductID,paw.Name from dbo.Product as paw join dbo.ProductModel as pm
on pm.ProductModelID = paw.ProductModelID where pm.Name = 'Racing Socks') as pm on  sod.ProductID  =  pm.ProductID) as cid on caw.CustomerID = cid.CustomerID 

select * from ProductModel as pm where pm.Name like '%Racing Socks%'

select  p.Name ,(c.CompanyName) from Product p
 join ProductModel pm on p.ProductModelID=pm.ProductModelID
 join SalesOrderDetail s1 on p.ProductID=s1.ProductID
 join SalesOrderHeader s2 on s1.SalesOrderID=s2.SalesOrderID
 join Customer c on c.CustomerID=s2.CustomerID where pm.Name='Racing Socks'
--question7
select count (distinct pid.ProductID) from Address as a join (select ca.AddressID, pid.ProductID from CustomerAddress as ca join
(select sod.ProductID, soh.CustomerID from SalesOrderHeader as soh join SalesOrderDetail as sod
on sod.SalesOrderID = soh.SalesOrderID where sod.ProductID in
(select distinct paw.ProductID as ProductID from Product as paw join ProductCategory as pc 
on pc.ProductCategoryID = paw.ProductCategoryID  where pc.Name = 'Cranksets')
)
as pid
on pid.CustomerID = ca.CustomerID) as pid on pid.AddressID = a.AddressID where a.city = 'London' 

--question 8
select sum(st.SubTotal) as mysum, a.CountryRegion from Address as a left outer join
(select ca.AddressID as AddressID, soh.SubTotal as SubTotal from SalesOrderHeader as soh join CustomerAddress as ca 
on ca.CustomerID = soh.CustomerID) as st on 
st.AddressID = a.AddressID
group by a.CountryRegion
order by sum(st.SubTotal) desc

