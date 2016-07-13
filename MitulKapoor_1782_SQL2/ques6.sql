use [AU_assignment]

--Select ProductModel.Name, CompanyName 
--from ProductModel,CustomerAW, ProductAW,SalesOrderDetail,SalesOrderHeader
-- where (ProductAW.Name = 'Racing Socks' and 
--	ProductModel.ProductModelID = ProductAW.ProductModelID and 
--	ProductAW.ProductID = SalesOrderDetail.ProductID and 
--	SalesOrderDetail.SalesOrderID = SalesOrderHeader.SalesOrderID and
--	 SalesOrderHeader.CustomerID = CustomerAW.CustomerID);


-- using joins

Select ProductModel.Name, CompanyName
from(
		(
			(
			(ProductModel inner join ProductAW 
			On ProductModel.ProductModelID = ProductAW.ProductModelID)
				inner join SalesOrderDetail	
				On ProductAW.ProductID = SalesOrderDetail.ProductID)
					inner join SalesOrderHeader
					On SalesOrderDetail.SalesOrderID = SalesOrderHeader.SalesOrderID)
						inner join CustomerAW 
						On SalesOrderHeader.CustomerID = CustomerAW.CustomerID)
							where ProductModel.Name = 'hii'