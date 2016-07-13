USE AdventureWorksImported

-- Last 4 Queries--


--5. A "Single Item Order" is a customer order where only one item is ordered. Show the
--SalesOrderID and the UnitPrice for every Single Item Order. 15 Marks
SELECT SalesOrderID, SUM( SalesOrderDetail.UnitPrice ) AS UnitPrice FROM SalesOrderDetail
		 GROUP BY SalesOrderDetail.SalesOrderID
		 HAVING ( Count(*) = 1 )


--6. List the product name and the CompanyName for all Customers who ordered ProductModel
--'Racing Socks'. 15 Marks
SELECT DISTINCT CompanyName, Product.Name AS ProductName FROM Product 
					  INNER JOIN ProductModel ON Product.ProductModelID = ProductModel.ProductModelID
					  INNER JOIN SalesOrderDetail ON Product.ProductID = SalesOrderDetail.ProductID
					  INNER JOIN SalesOrderHeader ON SalesOrderDetail.SalesOrderID = SalesOrderHeader.SalesOrderID
					  INNER JOIN Customer ON SalesOrderHeader.CustomerID = Customer.CustomerID
		WHERE ProductModel.Name LIKE '%Racing Socks%'

--7. How many products in ProductCategory 'Cranksets' have been sold to an address in
--'London'? 15 Marks
SELECT COUNT(*) FROM Product INNER JOIN ProductCategory ON Product.ProductCategoryID = ProductCategory.ProductCategoryID
					  INNER JOIN SalesOrderDetail ON Product.ProductID = SalesOrderDetail.ProductID
					  INNER JOIN SalesOrderHeader ON SalesOrderDetail.SalesOrderID = SalesOrderHeader.SalesOrderID
					  INNER JOIN Customer ON SalesOrderHeader.CustomerID = Customer.CustomerID
					  INNER JOIN CustomerAddress ON CustomerAddress.CustomerID = Customer.CustomerID
					  INNER JOIN Address ON CustomerAddress.AddressID = Address.AddressID
		WHERE ProductCategory.Name LIKE '%Cranksets%' AND Address.City LIKE '%LONDON%'

--8. Show the total order value for each CountryRegion. List by value with the highest first. 15
--Marks

 SELECT CountryRegion, SUM( SalesOrderHeader.SubTotal ) AS TotalOrderValue FROM Address 
					INNER JOIN CustomerAddress ON Address.AddressID = CustomerAddress.AddressID	
					INNER JOIN Customer ON CustomerAddress.CustomerID = Customer.CustomerID 
					LEFT OUTER JOIN SalesOrderHeader ON Customer.CustomerID = SalesOrderHeader.CustomerID
GROUP BY CountryRegion
ORDER BY SUM( SalesOrderHeader.SubTotal ) DESC


