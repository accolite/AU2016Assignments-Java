Use Assignment5
select count(distinct(sd.ProductID)) as totalNumber
from Sales.SalesOrderHeader as sh inner join Person.Address as a
on a.AddressID = sh.ShipToAddressID
inner join Sales.SalesOrderDetail as sd on sd.SalesOrderID=sh.SalesOrderID
inner join Production.Product as p on p.ProductID = sd.ProductID
inner join Production.ProductCategory as pc on pc.ProductCategoryID = p.ProductCategoryID
where a.City = 'London' and pc.Name = 'Cranksets'