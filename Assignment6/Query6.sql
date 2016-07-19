Use Assignment5
SElect Distinct  ppp.Name,pp.CompanyName
From Production.ProductModel as p Join Production.Product as ppp
on p.ProductModelID=ppp.ProductModelID
Join Sales.SalesOrderDetail as pppp
on ppp.ProductID=pppp.ProductID
Join Sales.SalesOrderHeader as ppppp
on pppp.SalesOrderID=ppppp.SalesOrderID
Join Person.Customer as pp 
on ppppp.CustomerID=pp.CustomerId
where p.name='Racing Socks'