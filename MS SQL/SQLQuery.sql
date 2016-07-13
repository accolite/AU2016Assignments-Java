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
select * from SalesLT.Address as a inner join
	(
		select AddressID from SalesLT.CustomerAddress as ca inner join SalesLT.Customer as c on ca.CustomerID = c.CustomerID
		where c.CompanyName = 'Modular Cycle Systems'
	) as ca on a.AddressID=ca.AddressID 
--3
select distinct CompanyName from SalesLT.Customer as c inner join
	(
		select CustomerID from SalesLT.CustomerAddress as ca inner join SalesLT.Address as a on ca.AddressID = a.AddressID
		where a.City = 'Dallas'
	) as ca on c.CustomerID = ca.CustomerID
--order by CompanyName
--2
select sod.OrderQty, p.Name, p.ListPrice from SalesLT.SalesOrderDetail as sod inner join SalesLT.Product as p on sod.ProductID = p.ProductID
inner join  
	(
		select SalesOrderID from SalesLT.SalesOrderHeader where CustomerID = 635
	) as soh on sod.SalesOrderID = soh.SalesOrderID
--4
select distinct CompanyName from SalesLT.Customer as c inner join
	(
		Select CustomerID from SalesLT.SalesOrderHeader where SubTotal + TaxAmt + Freight > $100000
 	) as soh on c.CustomerID = soh.CustomerID
--Order by CompanyName
--6
select p.Name, c.CompanyName from SalesLT.Customer as c inner join SalesLT.SalesOrderHeader as soh
	on c.CustomerID = soh.CustomerID inner join SalesLT.SalesOrderDetail as sod
	on soh.SalesOrderID = sod.SalesOrderID inner join SalesLT.Product as p
	on sod.ProductID = p.ProductID inner join SalesLT.ProductModel as pm
	on p.ProductModelID = pm.ProductModelID where pm.Name='Racing Socks'
--5
select c.CustomerID as 'Single Item Order',soh.SalesOrderID,sod.UnitPrice--, sod.OrderQty
	from SalesLT.Customer as c inner join SalesLT.SalesOrderHeader as soh
	on c.CustomerID = soh.CustomerID inner join SalesLT.SalesOrderDetail as sod
	on soh.SalesOrderID = sod.SalesOrderID
	where soh.SalesOrderID in
		(
			select SalesOrderID from SalesLT.SalesOrderDetail group by SalesOrderID having count(SalesOrderID)=1
		)
--7
select count(*) as 'Cranksets to London' from SalesLT.Product as p inner join SalesLT.ProductCategory as pc
	on p.ProductCategoryID = pc.ProductCategoryID and pc.Name like 'Cranksets'
	inner join SalesLT.SalesOrderDetail as sod
	on sod.ProductID = p.ProductID
	inner join SalesLT.SalesOrderHeader as soh
	on soh.SalesOrderID = sod.SalesOrderID
	inner join SalesLT.Address as a
	on soh.BillToAddressID = a.AddressID and City like 'London'
--8
select coalesce(sum(soh.SubTotal),0) as 'Total Order Value', a.CountryRegion from SalesLT.SalesOrderHeader as soh
	right join SalesLT.Address as a on soh.BillToAddressID = a.AddressID
	group by a.CountryRegion
	order by sum(soh.SubTotal) desc







--test queries
select * from SalesLT.SalesOrderHeader as soh
	full join SalesLT.Address as a 
	on (soh.BillToAddressID = a.AddressID or soh.ShipToAddressID = a.AddressID) and a.CountryRegion like 'Canada'

select CountryRegion from SalesLT.Address group by CountryRegion