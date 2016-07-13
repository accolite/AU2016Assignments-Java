use [AdventureWorks]

select count(*) 
from SalesOrderHeader,Address, CustomerAddress,SalesOrderDetail,ProductCategory,ProductAW
where SalesOrderHeader.CustomerID = CustomerAddress.CustomerID and
CustomerAddress.AddressID = Address.AddressID and
Address.City = 'Dallas' and
SalesOrderHeader.SalesOrderID = SalesOrderDetail.SalesOrderID and
ProductAW.ProductID = SalesOrderDetail.ProductID and
ProductAW.ProductCategoryID = ProductCategory.ProductCategoryID and
ProductCategory.Name = 'Dell'



SELECT PA.Name, CompanyName from (ProductModel as PM join ProductAW as PA on PM.ProductModelID = PA.ProductModelID)  join SalesOrderDetail AS SD on PA.ProductID = SD.ProductID join SalesOrderHeader AS SH on SH.SalesOrderID = SD.SalesOrderID join CustomerAW AS CA on CA.CustomerID = SH.CustomerID WHERE PM.Name = 'Racing Socks'
