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
