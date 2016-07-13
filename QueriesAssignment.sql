
--select * from Product 
-- ques 1

select AddressLine1,AddressLine2,City, StateProvince, CountryRegion,PostalCode  from Address where AddressID IN
(select distinct A.AddressID from CustomerAw as C,Address as A,CustomerAddress as CA where C.CustomerID = CA.CustomerID AND A.AddressId = CA.AddressId AND C.CompanyName = 'Modular Cycle Systems')

-- que2
select OrderQty,Name,ListPrice from SalesOrderHeader as SOH,SalesOrderDetail as SOD,Product as PA where SOH.SalesOrderID = SOD.SalesOrderID AND SOD.ProductID = PA.ProductID AND SOH.CustomerID = 635

-- ques3

select distinct CompanyName from CustomerAw as C,CustomerAddress as CA,address as A where C.CustomerID = CA.CustomerID AND A.AddressId = CA.AddressId AND A.City = 'dallas'

-- ques4
select distinct CompanyName from CustomerAw as C , SalesOrderHeader as SO where C.CustomerID = SO.CustomerID AND SO.SubTotal + SO.TaxAmt + SO.Freight > 10000


--ques5
;with x(ProductID,No_Of_Products)
  as
  (
	select ProductID,Count(ProductID) as No_Of_Products
	from SalesOrderDetail
	Group By ProductID
  )
  
 select UnitPrice,SalesOrderID from x,SalesOrderDetail where No_Of_Products = 1; 

--ques6
select CompanyName , P.Name as PNAME from CustomerAw as C,SalesOrderHeader as SOH,SalesOrderDetail as SOD,Product as P,ProductModel as PM where C.CustomerID = SOH.CustomerID AND SOH.SalesOrderID = SOD.SalesOrderID AND SOD.ProductID = P.ProductID AND P.ProductModelID = PM.ProductModelID AND PM.Name = N'Racing Socks'; 

--ques7
select COUNT(distinct P.ProductID) as Total_Orders from Address as A,SalesOrderHeader as SOH,SalesOrderDetail as SOD,Product as P, ProductCategory as PC where PC.ProductCategoryID = P.ProductCategoryID AND P.ProductID = SOD.ProductID AND SOD.SalesOrderID = SOH.SalesOrderID AND SOH.BillToAddressID = A.AddressID AND CITY like '%LONDON%' AND PC.Name = 'Cranksets';

-- ques8

;With x (subtotal,TaxAmt,Freight,CountryRegion)
	as
	   (
		select SUM(subTotal) as subTotal , SUM(TaxAmt) as TaxAmt , SUM(Freight) as Freight,Address.CountryRegion as CountryRegion 
		from SalesOrderHeader , Address
		where Address.AddressID = SalesOrderHeader.BillToAddressID
		Group By Address.CountryRegion
	   )

select SUM(subTotal + TaxAmt + Freight)	as Total_Value,CountryRegion
from x
Group By CountryRegion
Order By Total_Value DESC 