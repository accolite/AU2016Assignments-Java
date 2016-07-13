use d1;

--q1

SELECT CompanyName,AddressType,AddressLine1,AddressLine2,StateProvince, CountryRegion,PostalCode
  FROM CustomerAW JOIN CustomerAddress
    ON (CustomerAW.CustomerID=CustomerAddress.CustomerID)
                  JOIN Address
    ON (CustomerAddress.AddressID=Address.AddressID)
 WHERE CompanyName='Modular Cycle Systems'

--q2

SELECT ProductAW.ListPrice,ProductAW.Name, SalesOrderDetail.OrderQty
FROM ProductAW INNER JOIN SalesOrderDetail 
  ON (ProductAW.ProductID=SalesOrderDetail.ProductID) 
              INNER JOIN  SalesOrderHeader 
  ON (SalesOrderHeader.​SalesOrderID=SalesOrderDetail​.SalesOrderID)
WHERE SalesOrderHeader.CustomerID=635;

--q3

SELECT CompanyName 
FROM CustomerAW INNER JOIN CustomerAddress 
  ON (CustomerAW.CustomerID=CustomerAddress.CustomerID) 
              INNER JOIN  Address 
  ON (CustomerAddress​.AddressID=Address.AddressID)
WHERE Address.City='Dallas';

--q4

select CompanyName
from CustomerAW 
where CustomerID in(   select CustomerID
                        from SalesOrderHeader 
						Group By CustomerID 
						Having (Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight)>100000)
					);   
     
--q5

--SELECT SalesOrderID , UnitPrice
--FROM SalesOrderDetail
--WHERE OrderQty=1;

Select SalesOrderDetail.SalesOrderID,SalesOrderDetail.UnitPrice 
from SalesOrderDetail 
where SalesOrderID in (
			 select sod.SalesOrderID 
			 from SalesOrderDetail as sod 
					   inner join SalesOrderHeader as sh 
			 on (sod.SalesOrderID = sh.SalesOrderID) 
			 group by sod.SalesOrderID 
			 having count(sod.SalesOrderID) = 1
) ;

select * from SalesOrderDetail where SalesOrderID IN (71776,
71867,
71917,
71946)
--q6

SELECT ProductAW.Name,CustomerAW.CompanyName,ProductModel.Name
FROM CustomerAW JOIN SalesOrderHeader
ON (CustomerAW.CustomerID=SalesOrderHeader.CustomerID)
                JOIN SalesOrderDetail
ON (SalesOrderHeader.SalesOrderID=SalesOrderDetail.SalesOrderID)
                JOIN ProductAW
ON (SalesOrderDetail.ProductID=ProductAW.ProductID)
                JOIN ProductModel
ON (ProductAW.ProductModelID=ProductModel.ProductModelID)
WHERE ProductModel.Name='Racing Socks'

--q7
SELECT s1.productID, a1.city
FROM   ProductCategory p2 JOIN ProductAW p1 
ON p1.ProductCategoryID = p2.ProductCategoryID 
                          JOIN SalesOrderDetail s1
 ON p1.ProductID = s1.ProductID  
                          JOIN SalesOrderHeader s2 
 ON s2.SalesOrderID = s1.SalesOrderID 
                          JOIN CustomerAW c1 
ON s2.CustomerID = c1.CustomerID
                          JOIN CustomerAddress c2 
ON c1.CustomerID = c2.CustomerID
                          JOIN Address a1 
ON c2.AddressID = a1.AddressID 
where p2.Name='Cranksets'and a1.City='London';   

select * from ProductCategory p1 JOIN ProductAW p2 ON p1.ProductCategoryID = p2.ProductCategoryID 
where p1.Name='Cranksets'

select * from SalesOrderDetail where ProductID in ('949','950','951')
--q8

SELECT Address.CountryRegion, sum(subtotal) AS NumberOfOrders 
FROM Address
JOIN SalesOrderHeader  
ON Address.AddressID=SalesOrderHeader.ShipToAddressID
GROUP BY Address.CountryRegion;

        