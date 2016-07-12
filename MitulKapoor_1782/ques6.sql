use [AU_assignment]

Select ProductModel.Name, CompanyName 
from ProductModel,CustomerAW, ProductAW,SalesOrderDetail,SalesOrderHeader
 where (ProductAW.Name = 'Racing Socks' and 
	ProductModel.ProductModelID = ProductAW.ProductModelID and 
	ProductAW.ProductID = SalesOrderDetail.ProductID and 
	SalesOrderDetail.SalesOrderID = SalesOrderHeader.SalesOrderID and
	 SalesOrderHeader.CustomerID = CustomerAW.CustomerID);