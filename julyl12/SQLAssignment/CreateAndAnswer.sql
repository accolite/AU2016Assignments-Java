use AdventureWorks2014;
/*Customer Table*/

IF OBJECT_ID ( 'dbo.Customer', 'U' ) IS NOT NULL   
    DROP TABLE dbo.Customer;  
GO  


CREATE TABLE [Customer](
	[CustomerID] int primary key identity(1,1), 
	[NameStyle] int, 
	[Title] nvarchar(8), 
	[FirstName] nvarchar(50), 
	[MiddleName] nvarchar(50), 
	[LastName] nvarchar(50), 
	[Suffix] nvarchar(10), 
	[CompanyName] nvarchar(50), 
	[SalesPerson] varchar(50), 
	[EmailAddress] varchar(50), 
	[Phone] varchar(30), 
	[PasswordHash] varchar(200), 
	[PasswordSalt] varchar(30), 
	[rowguid] varchar(100), 
	[ModifiedDate] datetime
);

SELECT * from dbo.Customer;

/*Address Table*/

IF OBJECT_ID ( 'dbo.Address', 'U' ) IS NOT NULL   
    DROP TABLE dbo.Address;  
GO  


CREATE TABLE [Address](
	[AddressID] int primary key identity(1,1), 
	[AddressLine1] nvarchar(60), 
	[AddressLine2] nvarchar(60), 
	[City] nvarchar(30), 
	[StateProvince] nvarchar(50), 
	[CountryRegion] nvarchar(50), 
	[PostalCode] nvarchar(30), 
	[rowguid] nvarchar(100), 
	[ModifiedDate] datetime
);


/*CustomerAddress Table*/

IF OBJECT_ID ( 'dbo.CustomerAddress', 'U' ) IS NOT NULL   
    DROP TABLE dbo.CustomerAddress;  
GO  

CREATE TABLE [CustomerAddress] (
[CustomerID] int foreign key references Customer(CustomerID), 
[AddressID] int foreign key references Address(AddressID), 
[AddressType] nvarchar(40), 
[rowguid] nvarchar(100), 
[ModifiedDate] datetime
);

/*SalesOrderHeader Table*/

IF OBJECT_ID ( 'dbo.SalesOrderHeader', 'U' ) IS NOT NULL   
    DROP TABLE dbo.SalesOrderHeader;  
GO  


CREATE TABLE [SalesOrderHeader] (
[SalesOrderID] int primary key identity(1,1), 
[RevisionNumber] tinyint, 
[OrderDate] datetime, 
[DueDate] datetime, 
[ShipDate] datetime, 
[Status] tinyint, 
[OnlineOrderFlag] bit, 
[PurchaseOrderNumber] nvarchar(25), 
[AccountNumber] nvarchar(25), 
[CustomerID] int foreign key references Customer(CustomerID), 
[ShipToAddressID] int, 
[BillToAddressID] int, 
[ShipMethod] nvarchar(25), 
[CreditCardApprovalCode] varchar(15), 
[SubTotal] money, 
[TaxAmt] money, 
[Freight] money, 
[Comment] nvarchar(128), 
[rowguid] varchar(200), 
[ModifiedDate] datetime);

/*ProductCategory Table*/

IF OBJECT_ID ( 'dbo.ProductCategory', 'U' ) IS NOT NULL   
    DROP TABLE dbo.ProductCategory;  
GO
  
CREATE TABLE [ProductCategory] (
[ProductCategoryID] int primary key identity(1,1),
[ParentProductCategoryID] int, 
[Name] nvarchar(40), 
[rowguid] varchar(200), 
[ModifiedDate] datetime);


/*ProductModel Table*/

IF OBJECT_ID ( 'dbo.ProductModel', 'U' ) IS NOT NULL   
    DROP TABLE dbo.ProductModel;  
GO

CREATE TABLE [ProductModel] (
[ProductModelID] int primary key identity(1,1), 
[Name] nvarchar(50), 
[CatalogDescription] nvarchar(1000),
[rowguid] varchar(200), 
[ModifiedDate] datetime);

/*Product Table*/

IF OBJECT_ID ( 'dbo.Product', 'U' ) IS NOT NULL   
    DROP TABLE dbo.Product;  
GO

CREATE TABLE [Product] (
[ProductID] int primary key identity(1,1), 
[Name] nvarchar(50), 
[ProductNumber] nvarchar(20), 
[Color] nvarchar(15), 
[StandardCost] money, 
[ListPrice] money, 
[Size] nvarchar(5), 
[Weight] decimal(8,2), 
[ProductCategoryID] int foreign key references ProductCategory(ProductCategoryID), 
[ProductModelID] int foreign key references ProductModel(ProductModelID), 
[SellStartDate] datetime, 
[SellEndDate] datetime, 
[DiscontinuedDate] datetime, 
[ThumbNailPhoto] image, 
[ThumbnailPhotoFileName] nvarchar(50), 
[rowguid] varchar(200), 
[ModifiedDate] datetime);

/*SalesOrderDetail Table*/

IF OBJECT_ID ( 'dbo.SalesOrderDetail', 'U' ) IS NOT NULL   
    DROP TABLE dbo.SalesOrderDetail;  
GO

CREATE TABLE [SalesOrderDetail] (
[SalesOrderID] int, 
[SalesOrderDetailID] int primary key identity(1,1), 
[OrderQty] smallint, 
[ProductID] int, 
[UnitPrice] money, 
[UnitPriceDiscount] money, 
[rowguid] varchar(200), 
[ModifiedDate] datetime);


/*ProductDescription Table*/

IF OBJECT_ID ( 'dbo.ProductDescription', 'U' ) IS NOT NULL   
    DROP TABLE dbo.ProductDescription;  
GO

CREATE TABLE [ProductDescription] 
([ProductDescriptionID] int primary key identity(1,1), 
[Description] nvarchar(400), 
[rowguid] varchar(200), 
[ModifiedDate] datetime);

IF OBJECT_ID ( 'dbo.ProductModelDescription', 'U' ) IS NOT NULL   
    DROP TABLE dbo.ProductModelDescription;  
GO

create table [ProductModelProductDescription] (
[ProductModelID] int foreign key references ProductModel(ProductModelID), 
[ProductDescriptionID] int foreign key references ProductDescription(ProductDescriptionID), 
[Culture] nvarchar(10), 
[rowguid] varchar(200), 
[ModifiedDate] datetime);

/*1
	SELECT AddressLine1, AddressLine2, City 
	FROM dbo.Address WHERE AddressID in (
	SELECT AddressID FROM dbo.CustomerAddress ca, 
	WHERE ca.AddressID = s.BusinessEntityID AND s.Name='Modular Cycle Systems');

/*2*/
	SELECT OrderQty, Name, ListPrice FROM Sales.SalesOrderDetail s, Production.Product p, Sales.SalesOrderHeader se
	where p.ProductID = s.ProductID and se.CustomerID = 12000 and se.SalesOrderID = s.SalesOrderID;

/*3*/
	
	SELECT Name FROM Sales.Store WHERE BusinessEntityID in (
			SELECT BusinessEntityID from Person.BusinessEntityAddress bea where bea.AddressID in(
				SELECT AddressID FROM Person.Address a where a.City='Dallas')
		)

/*4*/
	
	SELECT Name FROM Sales.Store s WHERE s.BusinessEntityID in (
			SELECT BusinessEntityID from Person.Person p where p.BusinessEntityID in(
				SELECT CustomerID from Sales.SalesOrderHeader where TotalDue<>0
				)
		)

		*/



--Final 1

SELECT AddressLine1, AddressLine2 , City, 'Modular Cycle Systems' as Company FROM Address WHERE AddressID 
IN(
	SELECT AddressID FROM CustomerAddress ca join  Customer c 
	on ca.CustomerID = c.CustomerID AND c.CompanyName='Modular Cycle Systems'
)
GO


--Custom 2
SELECT sd.OrderQty, p.Name, p.ListPrice 
FROM SalesOrderHeader as sh, SalesOrderDetail as sd, Product as p 
WHERE sh.CustomerID=29660 and sh.SalesOrderID = sd.SalesOrderID and sd.ProductID=p.ProductID; 
GO

--Final 2
SELECT sd.OrderQty, p.Name, p.ListPrice 
FROM SalesOrderHeader as sh join SalesOrderDetail as sd 
on sh.CustomerID=29660 and sh.SalesOrderID = sd.SalesOrderID 
join Product p on sd.ProductID=p.ProductID; 
GO

--Test 2
Select * from SalesOrderHeader where CustomerID=29660;

--Final 3

select CompanyName from Customer where CustomerID IN (
select CustomerID from CustomerAddress where AddressID in
 ( select AddressID from Address where City = 'Dallas' )
 )


--Final 4
select CompanyName from Customer where CustomerID
IN ( select distinct CustomerID from SalesOrderHeader where SubTotal + TaxAmt + Freight > 100000 ) 
 

--Final 5
select s.OrderQty,s.SalesOrderID, s.UnitPrice FROM SalesOrderDetail s WHERE SalesOrderID in (
	select d.SalesOrderID FROM SalesOrderDetail d 
	GROUP BY(d.SalesOrderID) HAVING SUM(d.OrderQty)=1	
);

--Check 6



--Final 7
SELECT COUNT(AddressID) AS LondonShipped from Address where City='London' and AddressID in(
	SELECT ShipToAddressID from SalesOrderHeader where SalesOrderID in(
		SELECT SalesOrderID from SalesOrderDetail where ProductID in(
			SELECT ProductID from Product where ProductCategoryID in(
				SELECT ProductCategoryID from ProductCategory where Name='Cranksets'
			)
		)
	)
);

--Check 8
