USE SalesLT;
GO

create table Customer(
	[CustomerID] [int] , 
	[NameStyle] [int],
	[Title] varchar(max),
	[FirstName] varchar(max) ,  
	[MiddleName] varchar(max) ,   
	[LastName] varchar(max) , 
	[Suffix]  varchar(max) , 
	[CompanyName] varchar(max) , 
	[SalesPerson] varchar(max) , 
	[EmailAddress] varchar(max) , 
	[Phone] varchar(max) , 
	[PasswordHash] varchar(max) , 
	[PasswordSalt] varchar(max) , 
	[rowguid] varchar(max) , 
	[ModifiedDate] [datetime],
	);
GO

create table CustomerAddress(
	[CustomerID] [int],
	[AddressID] [int], 
	[AddressType] varchar(max), 
	[rowguid] varchar(max), 
	[ModifiedDate] [datetime],
);
GO

create table Address(
	[AddressID] [int], 
	[AddressLine1]varchar(max),
	[AddressLine2]varchar(max),
	[City]varchar(max),
	[StateProvince]varchar(max),
	[CountryRegion]varchar(max),
	[PostalCode]varchar(max),
	[rowguid]varchar(max),
	[ModifiedDate] [datetime],
	);
GO

create table SalesOrderHeader(
	[SalesOrderID] [int], 
	[RevisionNumber] [int], 
	[OrderDate][datetime], 
	[DueDate][datetime], 
	[ShipDate][datetime], 
	[Status][int], 
	[OnlineOrderFlag][int], 
	[PurchaseOrderNumber]varchar(max),
	[AccountNumber] varchar(max), 
	[CustomerID][int], 
	[ShipToAddressID][int], 
	[BillToAddressID][int], 
	[ShipMethod]varchar(max),
	[CreditCardApprovalCode][int],
	[SubTotal][float], 
	[TaxAmt][float], 
	[Freight][float], 
	[Comment]varchar(max),
	[rowguid]varchar(max), 
	[ModifiedDate][datetime],
	);
GO

create table SalesOrderDetail(
	[SalesOrderID][int], 
	[SalesOrderDetailID][int], 
	[OrderQty][int], 
	[ProductID][int], 
	[UnitPrice][float], 
	[UnitPriceDiscount][float], 
	[rowguid]varchar(max),
	[ModifiedDate][datetime],
	);
GO

create table Product(
	[ProductID][int] , 
	[Name]varchar(max),
	[ProductNumber]varchar(max),
	[Color]varchar(max),
	[StandardCost][float],
	[ListPrice][float], 
	[Size]nvarchar(max),
	[Weight]Decimal(8, 2),
	[ProductCategoryID][int] ,
	[ProductModelID][int] ,
	[SellStartDate][datetime], 
	[SellEndDate][datetime], 
	[DiscontinuedDate][datetime], 
	[ThumbNailPhoto]nvarchar(max),
	[ThumbnailPhotoFileName]nvarchar(max),
	[rowguid]nvarchar(max),
	[ModifiedDate][datetime],
	
	);
GO

create table ProductModel(
	[ProductModelID][int], 
	[Name]nvarchar(max) , 
	[CatalogDescription]nvarchar(max) , 
	[rowguid]nvarchar(max) , 
	[ModifiedDate][datetime]
);
GO

create table ProductCategory(
	[ProductCategoryID][int], 
	[ParentProductCategoryID][int], 
	[Name]nvarchar(max) , 
	[rowguid]nvarchar(max) , 
	[ModifiedDate][datetime],
);
GO

create table ProductModelProductDescription(
	[ProductModelID][int], 
	[ProductDescriptionID][int], 
	[Culture]nvarchar(max) , 
	[rowguid]nvarchar(max) , 
	[ModifiedDate][datetime],
);
GO

create table ProductDescription(
	[ProductDescriptionID][int], 
	[Description]varchar(max) ,  
	[rowguid]varchar(max) ,  
	[ModifiedDate][datetime],
);
GO


-----------------------------------------------------
select AddressID,AddressLine1,AddressLine2,City,StateProvince,CountryRegion,PostalCode from Address 
where AddressID in
(select c2.AddressID 
from Customer c1 inner join CustomerAddress c2 
on c1.CustomerID=c2.CustomerID 
where c1.CompanyName='Modular Cycle Systems');


------------------------------------------------------
select * from SalesOrderHeader JOIN SalesOrderDetail on SalesOrderHeader.SalesOrderID=SalesOrderDetail.SalesOrderID Join
 Product on SalesOrderDetail.ProductID=Product.ProductID 
where SalesOrderHeader.CustomerID=635;


---------------------------------------------------

select c.CompanyName from Customer as c
where c.CustomerID in 
(
select c1.CustomerID 
from CustomerAddress c1 inner join Address c2 
on c1.AddressID=c2.AddressID 
where c2.City='Dallas');


--------------------------------

--fourth
select CompanyName 
from Customer 
where CustomerID in
( select CustomerID 
from SalesOrderHeader 
Group By CustomerID 
Having ((Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight))>100000));
