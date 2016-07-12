use Assignment2
--select * from Person.AddressType

create schema SalesLT

create table SalesLT.Customer(
	CustomerID int Primary key not null,
	FirstName nvarchar(50) not null,
	MiddleName nvarchar(50) null,
	LastName nvarchar(50) not null,
	EmailAddress nvarchar(50) null,
	NameStyle bit not null,
	[Title] nvarchar(8) null, 
	[Suffix] nvarchar(10) null,
	[CompanyName] nvarchar(50) null,
	[SalesPerson] nvarchar(50) null,
	[Phone] nvarchar(50) null,
	[PasswordHash] varchar(128) null,
	[PasswordSalt] nvarchar(10) null,
	[rowguid] uniqueidentifier not null,
	[ModifiedDate] datetime not null
)
select * from SalesLT.Customer
create table SalesLT.Address(
	AddressID int primary key not null,
	AddressLine1 nvarchar(60) not null,
	AddressLine2 nvarchar(60) null,
	City nvarchar(30) not null,
	StateProvince nvarchar(50) not null,
	CountryRegion nvarchar(50) not null,
	PostalCode nvarchar(15) not null,
	[rowguid] uniqueidentifier not null,
	[ModifiedDate] datetime not null
)
select * from SalesLT.Address
create table SalesLT.CustomerAddress(
	CustomerID int references SalesLT.Customer(CustomerID) not null,
	AddressID int references SalesLT.Address(AddressID) not null,
	AddressType nvarchar(50) not null,
	[rowguid] uniqueidentifier not null,
	[ModifiedDate] datetime not null,
	CONSTRAINT [PK_CusterAddress] PRIMARY KEY -- index clustered
	(
		[CustomerID],
		[AddressID],
		[AddressType]
	)
)
select * from SalesLT.CustomerAddress
--Alter table SalesLT.CustomerAddress add constraint [PK_CusterAddress] primary key
create table SalesLT.ProductModel(
	ProductModelID int primary key not null,
	Name nvarchar(50) not null,
	[CatalogDescription] nvarchar(10) null,
	[rowguid] uniqueidentifier not null,
	[ModifiedDate] datetime not null
)
select * from SalesLT.ProductModel
--select ProductModelID, Name into Assignment.ProductModel from Production.ProductModel

create table SalesLT.ProductDescription(
	ProductDescriptionID int primary key not null,
	Description nvarchar(400) not null,
	[rowguid] uniqueidentifier not null,
	[ModifiedDate] datetime not null
)

--select ProductDescriptionID, Description into Assignment.ProductDescription from Production.ProductDescription

create table SalesLT.ProductModelProductDescription(
	ProductModelID int references SalesLT.ProductModel(ProductModelID) not null,
	ProductDescriptionID int references SalesLT.ProductDescription(ProductDescriptionID) not null,
	Culture nvarchar(50) not null,
	[rowguid] uniqueidentifier not null,
	[ModifiedDate] datetime not null,
	CONSTRAINT [PK_ProductModelProductDescription] PRIMARY KEY -- index clustered
	(
		[ProductModelID],
		[ProductDescriptionID],
		[Culture]
	)
)

create table SalesLT.SalesOrderHeader (
	SalesOrderID int primary key not null,
	RevisionNumber tinyint not null,
	OrderDate datetime not null,
	CustomerID int references SalesLT.Customer(CustomerID) not null,
	BillToAddressID int references SalesLT.Address(AddressID) not null,
	ShipToAddressID int references SalesLT.Address(AddressID) not null,
	ShipMethod nvarchar(50) not null,
	SubTotal money not null,
	TaxAmt money not null,
	Freight money not null,
	[rowguid] uniqueidentifier not null,
	[ModifiedDate] datetime not null,
	[DueDate] datetime not null,
	[ShipDate] datetime null,
	[Status] tinyint not null,
	[OnlineOrderFlag] bit not null,
	[PurchaseOrderNumber] nvarchar(25) null,
	[AccountNumber] nvarchar(15) null,
	[CreditCardApprovalCode] varchar(15) null,
	[Comment] nvarchar(128) null
)
select * from SalesLT.SalesOrderHeader
create table SalesLT.ProductCategory(
	[ProductCategoryID] int primary key not null,
	[ParentProductCategoryID] int null,
	[Name] nvarchar(50) not null,
	[rowguid] uniqueidentifier not null,
	[ModifiedDate] datetime not null
)
create table SalesLT.Product(
	[ProductID] int primary key not null,
	[Name] nvarchar(50) not null,
	[ProductNumber] nvarchar(25) not null,
	[Color] nvarchar(15) null,
	[StandardCost] money not null,
	[ListPrice] money not null,
	[Size] nvarchar(5) null,
	[Weight] decimal(8,2) null,
	[ProductCategoryID] int references SalesLT.ProductCategory(ProductCategoryID) not null,
	[ProductModelID] int references SalesLT.ProductModel(ProductModelID) not null,
	[SellStartDate] datetime not null,
	[SellEndDate] datetime null,
	[DiscontinuedDate] datetime null,
	[ThumbNailPhoto] varbinary(max) null,
	[ThumbnailPhotoFileName] nvarchar(50) null,
	[rowguid] uniqueidentifier not null,
	[ModifiedDate] datetime not null
)
select * from SalesLT.Product
create table SalesLT.SalesOrderDetail(
	[SalesOrderID] int references SalesLT.SalesOrderHeader(SalesOrderID) not null,
	[SalesOrderDetailID] int not null,
	[OrderQty] smallint not null,
	[ProductID] int references SalesLT.Product(ProductID) not null,
	[UnitPrice] money not null,
	[UnitPriceDiscount] money not null,
	[rowguid] uniqueidentifier not null,
	[ModifiedDate] datetime not null,
	CONSTRAINT [PK_SalesOrderDetail] PRIMARY KEY -- index clustered
	(
		[SalesOrderID],
		[SalesOrderDetailID]
	)
)
select * from SalesLT.SalesOrderDetail

--querys
--1
select * from SalesLT.Address
where AddressID in
	(
		select AddressID from SalesLT.CustomerAddress as ca inner join SalesLT.Customer as c on ca.CustomerID = c.CustomerID
		where c.CompanyName = 'Modular Cycle Systems'
	)
--3
select CompanyName from SalesLT.Customer
where CustomerID in
	(
		select CustomerID from SalesLT.CustomerAddress as ca inner join SalesLT.Address as a on ca.AddressID = a.AddressID
		where a.City = 'Dallas'
	)
order by CompanyName
--2
select sod.OrderQty, p.Name, p.ListPrice from SalesLT.SalesOrderDetail as sod inner join SalesLT.Product as p on sod.ProductID = p.ProductID
where sod.SalesOrderID in 
	(
		select SalesOrderID from SalesLT.SalesOrderHeader where CustomerID = 29660
	)
--4
select CompanyName from SalesLT.Customer
where CustomerID in
	(
		Select CustomerID from SalesLT.SalesOrderHeader where SubTotal + TaxAmt + Freight > $100000
 	)
Order by CompanyName
--6
select p.Name, c.CompanyName from SalesLT.Customer as c, SalesLT.Product as p
where c.CustomerID in
	(
		select CustomerID from SalesLT.SalesOrderHeader as soh
		where  soh.SalesOrderID in
			(
				select SalesOrderID from SalesLT.SalesOrderDetail as sod
				where sod.ProductID in
					(
						select ProductID from SalesLT.Product as prod inner join SalesLT.ProductModel as prodm
						on prod.ProductModelID = prodm.ProductModelID where prodm.Name='Racing Socks'
					)
			)
	)
	and p.ProductID in 
	(
		select ProductID from SalesLT.Product as prod inner join SalesLT.ProductModel as prodm
		on prod.ProductModelID = prodm.ProductModelID where prodm.Name='Racing Socks'
	)
