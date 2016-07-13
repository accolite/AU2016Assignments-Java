USE [AdventureWorks1]
GO

/*Query1 */
SELECT CompanyName,AddressType,AddressLine1
  FROM SalesLT.Customer JOIN SalesLT.CustomerAddress
    ON (Customer.CustomerID=CustomerAddress.CustomerID)
                  JOIN SalesLT.Address
    ON (CustomerAddress.AddressID=Address.AddressID)
 WHERE CompanyName='Modular Cycle Systems'
 GO


 /*Query2 */
 SELECT OrderQty,Name,ListPrice
  FROM SalesLT.SalesOrderHeader JOIN SalesLT.SalesOrderDetail
	ON (SalesOrderHeader.SalesOrderID = SalesOrderDetail.SalesOrderID)
                        JOIN SalesLT.Product
	ON (SalesOrderDetail.ProductID = Product.ProductID)
WHERE CustomerID=29660
GO


/*Query3 */
SELECT	DISTINCT [CompanyName] 
FROM	SalesLT.Address,
		SalesLT.Customer, 
	    SalesLT.CustomerAddress
WHERE	SalesLT.Address.AddressID =  SalesLT.CustomerAddress.AddressID AND
		 SalesLT.CustomerAddress.CustomerID = SalesLT.Customer.CustomerID AND
		SalesLT.Address.City = 'Dallas'
GO


/*Query4 */
SELECT		Distinct C.CompanyName
FROM		SalesLT.Customer AS C
INNER JOIN	SalesLT.SalesOrderHeader AS S
		
ON S.CustomerID = C.CustomerID
GROUP BY C.CompanyName
HAVING SUM(S.SubTotal+S.TaxAmt+S.Freight) > 100000 
GO



/*Query5 */
SELECT SalesLT.SalesOrderDetail.SalesOrderID,UnitPrice
FROM SalesLT.SalesOrderHeader JOIN SalesLT.SalesOrderDetail
	ON (SalesOrderHeader.SalesOrderID = SalesOrderDetail.SalesOrderID)
WHERE OrderQty = 1
GO


/*SELECT SalesLT.Customer.CompanyName,SalesLT.Product.Name
FROM SalesLT.Customer,SalesLT.Product JOIN SalesLT.ProductModel
	ON (Product.ProductModelID = ProductModel.ProductModelID)
WHERE ProductModel.Name = 'Racing Stocks'
GROUP BY Customer.CustomerID
GO*/

/*SELECT SalesLT.Product.Name
FROM SalesLT.Product JOIN SalesLT.ProductModel
	ON (Product.ProductModelID = ProductModel.ProductModelID)
WHERE ProductModel.Name = 'Racing Socks'
GO*/

/*SELECT SalesLT.Customer.CompanyName,SalesLT.Product.Name
FROM SalesLT.Customer,
	 SalesLT.SalesOrderHeader,
	 SalesLT.SalesOrderDetail,
	 SalesLT.Product,
	 SalesLT.ProductModel
WHERE Customer.CustomerID = SalesOrderHeader.CustomerID AND
		SalesOrderHeader.SalesOrderID = SalesOrderDetail.SalesOrderID AND
		SalesOrderDetail.ProductID = Product.ProductID AND
		Product.ProductModelID = ProductModel.ProductModelID AND
		ProductModel.Name = 'Racing Socks'
GROUP BY Customer.CustomerID
GO*/


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

SELECT SUM(S.SubTotal + S.TaxAmt + S.Freight) as TotalOrderValue,CountryRegion
FROM SalesLT.SalesOrderHeader as S JOIN SalesLT.CustomerAddress
	ON (S.CustomerID = CustomerAddress.CustomerID)
	JOIN SalesLT.Address ON (CustomerAddress.AddressID = Address.AddressID)
GROUP BY CountryRegion
ORDER BY TotalOrderValue DESC
GO

