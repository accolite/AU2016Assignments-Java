﻿
USE Assin1Database;
GO

create table CustomerAW(
	[CustomerID] [int] NOT null , 
	[FirstName] [VARCHAR](50) NOT null ,  
	[MiddleName] [VARCHAR](50) NOT null , 
	[LastName] [VARCHAR](50) NOT null , 
	[CompanyName] [VARCHAR](50) NOT null , 
	[EmailAddress] [VARCHAR](50) NOT null , 
	CONSTRAINT [PK_CustomerAW_CustomerID] PRIMARY KEY CLUSTERED 
(
	[CustomerID]asc
) WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

create table CustomerAddress(
	[CustomerID] [int] NOT null , 
	[AddressID] [int] NOT NULL,
	[AddressType][varchar](50) NOT NULL,
	CONSTRAINT [PK_CustomerAddress_CustomerID] PRIMARY KEY CLUSTERED 
(
	[CustomerID]asc
) WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

create table Address(
	[AddressID] [int] NOT null , 
	[AddressLine1] [varchar](150) NOT NULL,
	[AddressLine2] [varchar](150) NOT NULL,
	[City] [varchar](50) NOT NULL,
	[StateProvince][varchar](50) NOT NULL,
	[CountryRegion] [varchar](50) NOT NULL,
	[PostalCode] [varchar](50) NOT NULL,
	CONSTRAINT [PK_Address1_AddressID] PRIMARY KEY CLUSTERED 
(
	[AddressID]asc
) WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

create table SalesOrderHeader(
	[SalesOrderID] [int] NOT null , 
	[RevisionNumber] [int] NOT null , 
	[OrderDate] [date] NOT NULL,
	[CustomerID] [int] NOT null , 
	[BillToAddressID][int] NOT null , 
	[ShipToAddressID] [int] NOT null , 
	[ShipMethod] [varchar](50) NOT NULL,
	[SubTotal] [money] not null,
	[TaxAmt] [int] not null,
	[Freight] [varchar](50) not null,
	CONSTRAINT [PK_SalesOrderHeader_SalesOrderID] PRIMARY KEY CLUSTERED 
(
	[SalesOrderID]asc
) WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

create table SalesOrderDetail(
	[SalesOrderID] [int] NOT null , 
	[SalesOrderDetailID]  [int] NOT null , 
	[OrderQty]  [int] NOT null , 
	[ProductID] [int] NOT null , 
	[UnitPrice] [int] NOT NULL,
	[UnitPriceDiscount] [int] NOT NULL,
	CONSTRAINT [PK_SalesOrderDetail_SalesOrderDetailID] PRIMARY KEY CLUSTERED 
(
	[SalesOrderDetailID]asc
) WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

create table ProductAW(
	[ProductID]  [int] PRIMARY KEY not null,
	[Name] [Varchar](50) not null,
	[Color] [Varchar](50) not null,
	[ListPrice] [int] not null,
	[Size] [int] not null,
	[Weight] [int] not null,
	[ProductModelID] [int] not null,
	[ProductCategoryID] [int] not null,
	);
GO

create table ProductModel(
	[ProductModelID] [int] primary key not null,
	[Name] [varchar](50) not null,
);
GO

create table ProductCategory(
	[ProductCategoryID] [int] primary key not null,
	[ParentProductCategoryID][int] not null,
	[Name] [varchar](50) not null,
);
GO

create table ProductModelProductDescription(
	[ProductModelID] [int] primary key not null,
	[ProductDescriptionID][int] not null,
	[Culture] [varchar](50) not null,
);
GO

create table ProductDescription(
	[ProductDescriptionID][int] primary key not null,
	[Description] [varchar](50) not null,
);
GO

--1
select * from Address as a
where a.AddressID in
(select c2.AddressID 
from CustomerAW c1 inner join CustomerAddress c2 
on c1.CustomerID=c2.CustomerID 
where c1.CompanyName='Modular Cycle Systems');



--2
select c.CompanyName from CustomerAW as c
where c.CustomerID in 
(
select c1.CustomerID 
from CustomerAddress c1 inner join Address c2 
on c1.AddressID=c2.AddressID 
where c2.City='dallas');

--3
select c1.OrderQty, c2.Name, c2.ListPrice from SalesOrderDetail c1 inner join ProductAW c2 on c1.ProductID=c2.ProductID

--4
Select CustomerAW.customerid, CustomerAW.CompanyName
from CustomerAW
where CustomerAW.customerid IN(
    Select CustomerAW.customerid from CustomerAW inner join SalesOrderHeader
	on CustomerAW.customerid = SalesOrderHeader.CustomerID
	group by CustomerAW.customerid
	having 
	sum(SalesOrderHeader.Freight+SalesOrderHeader.SubTotal+SalesOrderHeader.TaxAmt) > 100000
	)

--5
Select SalesOrderDetail.SalesOrderId, SalesOrderDetail.UnitPrice 
from SalesOrderDetail inner join SalesOrderHeader
on SalesOrderDetail.SalesOrderID = SalesOrderHeader.SalesOrderID
where SalesOrderHeader.customerid IN(
    Select SalesOrderHeader.CustomerID from SalesOrderHeader
	group by SalesOrderHeader.CustomerID
	having count(*) = 1)

--6
Select Product.Name, CustomerAW.CompanyName from
CustomerAW inner join SalesOrderHeader on CustomerAW.customerid = SalesOrderHeader.CustomerID
    inner join SalesOrderDetail on SalesOrderHeader.SalesOrderID = SalesOrderDetail.SalesOrderID
	inner join Product on SalesOrderDetail.ProductID = Product.ProductID
	inner join ProductModel on Product.ProductModelID = ProductModel.ProductModelID
	where Product.Name = 'Racing Socks'

--7
Select count(*) from Address inner join CustomerAddress on Address.AddressId = CustomerAddress.AddressId
   inner join SalesOrderHeader on SalesOrderHeader.CustomerID = CustomerAddress.customerid
   inner join SalesOrderDetail on SalesOrderHeader.SalesOrderID = SalesOrderDetail.SalesOrderID
   inner join Product on Product.ProductID = SalesOrderDetail.ProductID
   inner join ProductCategory on Production.ProductCategory.Name = Production.Product.Name
   where ProductCategory.Name = 'Cranksets' AND Address.City = 'London'

--8
Select sum(SalesOrderHeader.SubTotal,SalesOrderHeader.Freight,SalesOrderHeader.TaxAmt) 
from Address inner join CustomerAddress on Address.AddressId = CustomerAddress.AddressId
inner join SalesOrderHeader on CustomerAddress.customerid = SalesOrderHeader.CustomerID
group by Address.Country
