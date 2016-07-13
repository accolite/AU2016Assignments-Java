use [AU_assignment]


--select count(*) 
--from SalesOrderHeader,Address, CustomerAddress,SalesOrderDetail,ProductCategory,ProductAW
--where SalesOrderHeader.CustomerID = CustomerAddress.CustomerID and
--CustomerAddress.AddressID = Address.AddressID and
--Address.City = 'Dallas' and
--SalesOrderHeader.SalesOrderID = SalesOrderDetail.SalesOrderID and
--ProductAW.ProductID = SalesOrderDetail.ProductID and
--ProductAW.ProductCategoryID = ProductCategory.ProductCategoryID and
--ProductCategory.ParentProductCategoryIDName = 'Google'


select count(*) 
from SalesOrderHeader,Address, CustomerAddress,SalesOrderDetail,ProductCategory,ProductAW
where SalesOrderHeader.CustomerID = CustomerAddress.CustomerID and
CustomerAddress.AddressID = Address.AddressID and
Address.City = 'Dallas' and
SalesOrderHeader.SalesOrderID = SalesOrderDetail.SalesOrderID and
ProductAW.ProductID = SalesOrderDetail.ProductID and
ProductAW.ProductCategoryID = ProductCategory.ProductCategoryID and
ProductCategory.ParentProductCategoryIDName = 'Dell'


