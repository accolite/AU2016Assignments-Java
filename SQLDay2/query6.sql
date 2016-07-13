
select pro.Name,cus.CompanyName
from Customer as cus,
SalesOrderHeader as soh,
SalesOrderDetail as sod ,
Product as pro,
ProductModel as pm 

where cus.CustomerID=soh.CustomerID and 
  soh.SalesOrderID=sod.SalesOrderID and 
  sod.ProductID=pro.ProductID and
  pro.ProductModelID=pm.ProductModelID --and
  --pm.Name = 'Racing Socks'
