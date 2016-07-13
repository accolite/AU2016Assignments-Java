

select addr.CountryRegion,sum(SubTotal) as final
from Address as ad full outer join 
  SalesOrderHeader as sh on (ad.AddressID=sh.BillToAddressID)
  group by ad.CountryRegion
  order by final desc


 select count(*) from
ProductCategory as pccc,
Product as pro,
SalesOrderDetail as sd,
SalesOrderHeader as sh,
Address as ad, 
CustomerAddress as cusa where pccc.ProductCategoryID=pro.ProductCategoryID and
  pro.ProductID=sd.ProductID and
  sd.SalesOrderID=sh.SalesOrderID and 
  sh.CustomerID=cusadd.CustomerID and
  cusa.AddressID=ad.AddressID and
  pccc.name='Cranksets' and
  ad.City='London'


select SalesOrderID,UnitPrice from SalesOrderDetail
where SalesOrderID in ( select SalesOrderID from SalesOrderDetail  
group by SalesOrderID
having count(*) = 1 and sum(OrderQty) >= 1)



select count(*) from
ProductCategory as pc,
Product as pro,
SalesOrderDetail as sod,
SalesOrderHeader as soh,
Address as addr, 
CustomerAddress as cusadd


where pc.ProductCategoryID=pro.ProductCategoryID and
  pro.ProductID=sod.ProductID and
  sod.SalesOrderID=soh.SalesOrderID and 
  soh.CustomerID=cusadd.CustomerID and
  cusadd.AddressID=addr.AddressID and
  pc.name='Cranksets' and
  addr.City='London'