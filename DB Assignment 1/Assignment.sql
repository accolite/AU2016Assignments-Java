--1--

SELECT DISTINCT addr.* FROM [Address] addr, CustomerAddress ca, CustomerAW customer
WHERE customer.CustomerID = ca.CustomerID AND
addr.AddressID = ca.AddressID AND
customer.CompanyName = 'Modular Cycle Systems'

select * from CustomerAW where CompanyName = 'Modular Cycle Systems'
select * from [Address]

--2--

SELECT detail.OrderQty, product.Name, product.ListPrice 
FROM SalesOrderDetail detail, ProductAW product, SalesOrderHeader header
WHERE	detail.ProductID = product.ProductID AND
		header.SalesOrderID = detail.SalesOrderID AND
		header.CustomerID = 635 ;

--3--

SELECT customer.CompanyName 
FROM CustomerAW customer, [Address] addr, CustomerAddress ca
WHERE	customer.CustomerID = ca.CustomerID AND
		addr.AddressID = ca.AddressID AND
		addr.City = 'Dallas'


--4--

SELECT DISTINCT customer.CompanyName 
FROM CustomerAW customer
WHERE customer.CustomerID IN
(	SELECT DISTINCT header.CustomerID 
	FROM SalesOrderHeader header
	WHERE (header.SubTotal+header.TaxAmt+header.Freight)>100000 )

select SubTotal,TaxAmt,Freight from SalesOrderHeader;

--5--

SELECT det1.SalesOrderID, det1.UnitPrice 
FROM SalesOrderDetail det1
WHERE det1.SalesOrderID = ANY(
	SELECT SalesOrderID 
	FROM SalesOrderDetail
	WHERE SalesOrderDetail.OrderQty = 1
	Group by SalesOrderID
	Having count(SalesOrderID) = 1 
	)

select * from SalesOrderDetail

---SELECT SalesOrderID, UnitPrice
---FROM SalesOrderDetail
---Group by SalesOrderID
---Having count(*) = 1 

--6--

SELECT customer.CompanyName, product.Name AS Product_Name , productModel.Name AS Model_name 
FROM ProductAW product, ProductModel productModel, CustomerAW customer, SalesOrderDetail detail, SalesOrderHeader header
WHERE product.ProductModelID = productModel.productModelID
AND productModel.Name = 'Racing Socks'
AND header.SalesOrderID = detail.SalesOrderID
AND product.ProductID = detail.ProductID
AND header.CustomerID = customer.CustomerID


--select ProductAW.Name , ProductModel.Name from ProductAW, ProductModel 
--where ProductAW.ProductModelID = ProductModel.ProductModelID

---7---

SELECT count(*) 
from ProductAW product, ProductCategory category
where product.ProductCategoryID = category.ProductCategoryID
AND category.Name LIKE '%'

SELECT count(*) 
from ProductAW product, ProductCategory category, SalesOrderDetail detail, SalesOrderHeader header, CustomerAW customer, CustomerAddress ca, [Address] addr
where category.Name LIKE '%'
AND product.ProductCategoryID = category.ProductCategoryID
AND detail.ProductID = product.ProductID
--AND details.SalesOrderID = header.SalesOrderID
AND header.CustomerID = customer.CustomerID
AND customer.CustomerID = ca.CustomerID
AND ca.AddressID = addr.AddressID
AND addr.City = 'Dallas'


SELECT ProductID from
ProductAW, SalesOrderDetails, CustomerAW, 

--update [Address] set City = 'Dallas' WHERE [Address].AddressID in (2, 3, 6, 9)



INSERT INTO ProductModel

SELECT p.ProductID, p.Name, p.ListPrice, p.S FROM AdventureWorks2014.Production.Product p

INSERT INTO SalesOrderHeader
values
(5,getdate(),1,5,5,1,1500,120, 500),
(6,getdate(),1,5,5,1,15000,1200, 500),
(7,getdate(),1,5,5,5,1000,80, 500),
(8,getdate(),3,10,5,1,1100,95, 200),
(9,getdate(),7,1,5,3,2000,150, 500),
(10,getdate(),7,9,2,2,1560,100, 500)


SET IDENTITY_INSERT SalesOrderDetail on

INSERT INTO SalesOrderDetail (SalesOrderID, SalesOrderDetailID, OrderQty, ProductID, UnitPrice, UnitPriceDiscount)
values
(1, 1, 100, 1001, 15, 1),
(2, 2, 120, 1001, 150, 10),
(3, 3, 130, 1002, 50, 1),
(4, 4, 300, 1004, 120, 8),
(5, 5, 1000, 1005, 400, 12),
(6, 6, 500, 1003, 1000, 3)


SET IDENTITY_INSERT ProductModel Off

INSERT INTO ProductModel (ProductModelID, Name)
SELECT m.ProductModelID, m.Name FROM AdventureWorks2014.Production.ProductModel m

SET IDENTITY_INSERT ProductDescription off

INSERT INTO ProductDescription (ProductDescriptionID, Description)
SELECT d.ProductDescriptionID, d.Description FROM AdventureWorks2014.Production.ProductDescription d

SET IDENTITY_INSERT ProductCategory off

INSERT INTO ProductCategory (ProductCategoryID, ParentProductCategoryID, Name)
SELECT c.ProductCategoryID, c.ProductCategoryID, c.Name from AdventureWorks2014.Production.ProductCategory c

SET IDENTITY_INSERT dbo.ProductAW off

INSERT INTO ProductAW (ProductID, Name, Color, ListPrice, Size, Weight, ProductModelID, ProductCategoryID)
SELECT p.ProductID, p.Name, p.Color, p.ListPrice, p.Size, p.Weight, p.ProductModelID, p.ProductSubcategoryID from AdventureWorks2014.Production.Product p

SELECT * from ProductDescription
SELECT * from ProductModel
SELECT * from ProductCategory
Select * from ProductAW
SELECT * FROM SalesOrderHeader

