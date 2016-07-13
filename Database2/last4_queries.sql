USE [AdventureWorks1]
GO

/*Query5 */
SELECT SalesOrderID, SUM( SalesOrderDetail.UnitPrice ) AS UnitPrice FROM SalesLT.SalesOrderDetail
		 GROUP BY SalesOrderDetail.SalesOrderID
		 HAVING ( Count(*) = 1 )


/*Query6*/

SELECT DISTINCT CompanyName, Product.Name AS ProductName FROM SalesLT.Product 
					  INNER JOIN SalesLT.ProductModel ON Product.ProductModelID = ProductModel.ProductModelID
					  INNER JOIN SalesLT.SalesOrderDetail ON Product.ProductID = SalesOrderDetail.ProductID
					  INNER JOIN SalesLT.SalesOrderHeader ON SalesOrderDetail.SalesOrderID = SalesOrderHeader.SalesOrderID
					  INNER JOIN SalesLT.Customer ON SalesOrderHeader.CustomerID = Customer.CustomerID
		WHERE ProductModel.Name LIKE '%Racing Socks%'


/*Query7 */
SELECT COUNT(*) as TotalCount
FROM SalesLT.ProductCategory JOIN SalesLT.Product
	ON (ProductCategory.ProductCategoryID = Product.ProductCategoryID)
	JOIN SalesLT.SalesOrderDetail ON (SalesOrderDetail.ProductID = Product.ProductID)
	JOIN SalesLT.SalesOrderHeader ON (SalesOrderHeader.SalesOrderID = SalesOrderDetail.SalesOrderID)
	JOIN SalesLT.CustomerAddress ON (CustomerAddress.CustomerID = SalesOrderHeader.CustomerID)
	JOIN SalesLT.Address ON (CustomerAddress.AddressID = Address.AddressID)
WHERE ProductCategory.Name = 'Cranksets' AND Address.City = 'London'
GO

/*Query8 */

SELECT SUM(S.SubTotal) as TotalOrderValue,CountryRegion
FROM SalesLT.SalesOrderHeader as S JOIN SalesLT.CustomerAddress
	ON (S.CustomerID = CustomerAddress.CustomerID)
RIGHT OUTER	JOIN SalesLT.Address ON (CustomerAddress.AddressID = Address.AddressID)
GROUP BY CountryRegion
ORDER BY TotalOrderValue DESC
GO

