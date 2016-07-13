--1--

SELECT DISTINCT addr.* FROM [Address] addr, CustomerAddress ca, CustomerAW customer
WHERE customer.CustomerID = ca.CustomerID AND
addr.AddressID = ca.AddressID AND
customer.CompanyName = 'Modular Cycle Systems'

-- select * from CustomerAW where CompanyName = 'Modular Cycle Systems'
-- select * from [Address]

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

-- select SubTotal,TaxAmt,Freight from SalesOrderHeader;

--5--

SELECT det1.SalesOrderID, det1.UnitPrice 
FROM SalesOrderDetail det1
WHERE det1.SalesOrderID = ANY(
	SELECT SalesOrderID 
	FROM SalesOrderDetail
	-- WHERE SalesOrderDetail.OrderQty = 1	// If single item doesn't mean single quantity
	Group by SalesOrderID
	Having count(SalesOrderID) = 1 
	)

-- select * from SalesOrderDetail

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

--7--

SELECT count(*) as No_of_products
from ProductAW product, ProductCategory category, SalesOrderDetail detail, SalesOrderHeader header, CustomerAW customer, CustomerAddress ca, [Address] addr
where category.Name = 'Cranksets'
AND product.ProductCategoryID = category.ProductCategoryID
AND detail.ProductID = product.ProductID
AND detail.SalesOrderID = header.SalesOrderID
AND header.CustomerID = customer.CustomerID
AND customer.CustomerID = ca.CustomerID
AND ca.AddressID = addr.AddressID
AND addr.City = 'London'

--8--

SELECT addr.CountryRegion, SUM(header.SubTotal+ header.TaxAmt+ header.Freight) AS TOTAL_SALES 
FROM SalesOrderHeader header, CustomerAddress ca, [Address] addr
WHERE header.CustomerID = ca.CustomerID 
AND ca.AddressID=addr.AddressID 
GROUP BY addr.CountryRegion
ORDER BY TOTAL_SALES DESC