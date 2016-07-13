USE [AdventureWorks2014]
GO
--Q5
select sod1.SalesOrderID,sod1.UnitPrice
from salesorderdetail sod1,
(select sod.salesorderid
from dbo.SalesOrderDetail as sod
group by sod.SalesOrderID
having Count(sod.ProductId)=1 and sum(sod.OrderQty)>=1) t1
where sod1.SalesOrderID=t1.SalesOrderID
Go


select * from  dbo.SalesOrderDetail
select * from  dbo.SalesOrderHeader

--Q6
select p.Name,c.CompanyName
from dbo.CustomerAW as c,dbo.SalesOrderHeader as soh
	 ,dbo.SalesOrderDetail as sod ,dbo.Product as p
      ,dbo.ProductModel as pm 
where c.Customerid=soh.customerid and 
		soh.sod=sod.salesorderid and 
		sod.productid=p.productid and
		p.productmodelid=pm.productmodelid and
		pm.Name = 'Racing Socks' 

select * from product

--Q7
select count(*)
from dbo.productcategory as pc,
	 dbo.product as p,
	 dbo.salesorderdetail as sod,
	 dbo.salesorderheader as soh,
	 dbo.address as a
where
	a.city='london' and 
	soh.shiptoaddressid=a.addressid and 
 	sod.salesorderid=soh.sod and 
	p.productid=sod.productid and 
	pc.productcategoryid=p.productcategoryid and 
	pc.name='cranksets'
 
 --Q8
 select a.CountryRegion,sum(soh.SubTotal) as ordervalue 
 from dbo.address as a
	full outer join   dbo.SalesOrderHeader as soh
	on a.AddressID=soh.BillToAddressID
group by a.CountryRegion 
order by ordervalue Desc

select distinct a.CountryRegion from dbo.address as a





