USE [master]
GO
/****** Object:  Database [temp]    Script Date: 12 Jul 2016 7:02:28 PM ******/
CREATE DATABASE [Assignment]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'AdventureWorksLT2008_Data', FILENAME = N'D:\Training\July12th\Assignment\Assignment.mdf' , SIZE = 8512KB , MAXSIZE = UNLIMITED, FILEGROWTH = 16384KB )
 LOG ON 
( NAME = N'AdventureWorksLT2008_Log', FILENAME = N'D:\Training\July12th\Assignment\Assignment_log.ldf' , SIZE = 3456KB , MAXSIZE = UNLIMITED, FILEGROWTH = 10%)
GO


use[Assignment]
create schema SalesLT  --Created Schema

--Address Table

CREATE TABLE [SalesLT].[Address](
	[AddressID] [int] NOT NULL,
	[AddressLine1] [nvarchar](60),
	[AddressLine2] [nvarchar](60),
	[City] [nvarchar](30),
	[StateProvince] [nvarchar](60),
	[CountryRegion] [nvarchar](60),
	[PostalCode] [nvarchar](15),
	[rowguid] [uniqueidentifier] ROWGUIDCOL,
	[ModifiedDate] [datetime],
 CONSTRAINT [PK_Address_AddressID] PRIMARY KEY CLUSTERED 
(
	[AddressID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


--Customer Table

CREATE TABLE [SalesLT].[Customer](
	[CustomerID] [int] NOT NULL,
	[NameStyle] [nvarchar](10),
	[Title] [nvarchar](8),
	[FirstName] [nvarchar](10),
	[MiddleName] [nvarchar](10),
	[LastName] [nvarchar](10),
	[Suffix] [nvarchar](10),
	[CompanyName] [nvarchar](100),
	[SalesPerson] [nvarchar](200),
	[EmailAddress] [nvarchar](50),
	[Phone] [nvarchar](20),
	[PasswordHash] [varchar](128),
	[PasswordSalt] [varchar](10),
	[rowguid] [uniqueidentifier] ROWGUIDCOL,
	[ModifiedDate] [datetime],
 CONSTRAINT [PK_Customer_CustomerID] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
go


--CustomerAddress Table

CREATE TABLE [SalesLT].[CustomerAddress](
	[CustomerID] [int] NOT NULL,
	[AddressID] [int] NOT NULL,
	[AddressType] [nvarchar](60) NOT NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL,
	[ModifiedDate] [datetime],
 CONSTRAINT [PK_CustomerAddress_CustomerID_AddressID] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC,
	[AddressID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


ALTER TABLE [SalesLT].[CustomerAddress]  WITH CHECK ADD  CONSTRAINT [FK_CustomerAddress_Address_AddressID] FOREIGN KEY([AddressID])
REFERENCES [SalesLT].[Address] ([AddressID])
GO
ALTER TABLE [SalesLT].[CustomerAddress]  WITH CHECK ADD  CONSTRAINT [FK_CustomerAddress_Customer_CustomerID] FOREIGN KEY([CustomerID])
REFERENCES [SalesLT].[Customer] ([CustomerID])
GO


--SalesOrderHeader Table

CREATE TABLE [SalesLT].[SalesOrderHeader](
	[SalesOrderID] [int] NOT NULL,
	[RevisionNumber] [tinyint] default(1),
	[OrderDate] [datetime],
	[DueDate] [datetime],
	[ShipDate] [datetime],
	[Status] [tinyint],
	[OnlineOrderFlag] [int],
	[SalesOrderNumber]  [nvarchar](60) null,
	[PurchaseOrderNumber] [nvarchar](60),
	[AccountNumber] [nvarchar](60),
	[CustomerID] [int] NOT NULL,
	[ShipToAddressID] [int],
	[BillToAddressID] [int],
	[ShipMethod] [nvarchar](50),
	[CreditCardApprovalCode] [varchar](15),
	[SubTotal] [money],
	[TaxAmt] [money],
	[Freight] [money],
	[TotalDue]  [money],
	[Comment] [nvarchar](max) null,
	[rowguid] [uniqueidentifier] ROWGUIDCOL,
	[ModifiedDate] [datetime],
 CONSTRAINT [PK_SalesOrderHeader_SalesOrderID] PRIMARY KEY CLUSTERED 
(
	[SalesOrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [SalesLT].[SalesOrderHeader]  WITH CHECK ADD  CONSTRAINT [FK_SalesOrderHeader_Customer_CustomerID] FOREIGN KEY([CustomerID])
REFERENCES [SalesLT].[Customer] ([CustomerID])
GO


--ProductCategory Table

CREATE TABLE [SalesLT].[ProductCategory](
	[ProductCategoryID] [int] NOT NULL,
	[ParentProductCategoryID] [int],
	[Name] [nvarchar](60) NOT NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL,
	[ModifiedDate] [datetime],
 CONSTRAINT [PK_ProductCategory_ProductCategoryID] PRIMARY KEY CLUSTERED 
(
	[ProductCategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [AK_ProductCategory_Name] UNIQUE NONCLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [SalesLT].[ProductCategory]  WITH CHECK ADD  CONSTRAINT [FK_ProductCategory_ProductCategory_ParentProductCategoryID_ProductCategoryID] FOREIGN KEY([ParentProductCategoryID])
REFERENCES [SalesLT].[ProductCategory] ([ProductCategoryID])
GO
	

--ProductModel Table

CREATE TABLE [SalesLT].[ProductModel](
	[ProductModelID] [int] NOT NULL,
	[Name] [nvarchar](60) NOT NULL,
	[CatalogDescription] [nvarchar](60),
	[rowguid] [uniqueidentifier] ROWGUIDCOL,
	[ModifiedDate] [datetime],
 CONSTRAINT [PK_ProductModel_ProductModelID] PRIMARY KEY CLUSTERED 
(
	[ProductModelID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [AK_ProductModel_Name] UNIQUE NONCLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] 
GO


--Product Table

CREATE TABLE [SalesLT].[Product](
	[ProductID] [int] NOT NULL,
	[Name] [nvarchar](60),
	[ProductNumber] [nvarchar](25),
	[Color] [nvarchar](15),
	[StandardCost] [money],
	[ListPrice] [money],
	[Size] [nvarchar](5),
	[Weight] [decimal](8, 5),
	[ProductCategoryID] [int],
	[ProductModelID] [int],
	[SellStartDate] [datetime],
	[SellEndDate] [datetime],
	[DiscontinuedDate] [datetime],
	[ThumbNailPhoto] [varbinary](max) null,
	[ThumbnailPhotoFileName] [nvarchar](60) null,
	[rowguid] [uniqueidentifier] ROWGUIDCOL,
	[ModifiedDate] [datetime],
 CONSTRAINT [PK_Product_ProductID] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [SalesLT].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_ProductCategory_ProductCategoryID] FOREIGN KEY([ProductCategoryID])
REFERENCES [SalesLT].[ProductCategory] ([ProductCategoryID])
GO
ALTER TABLE [SalesLT].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_ProductModel_ProductModelID] FOREIGN KEY([ProductModelID])
REFERENCES [SalesLT].[ProductModel] ([ProductModelID])


--SalesOrderDetail Table

CREATE TABLE [SalesLT].[SalesOrderDetail](
	[SalesOrderID] [int] NOT NULL,
	[SalesOrderDetailID] [int] NOT NULL,
	[OrderQty] [smallint],
	[ProductID] [int] not null,
	[UnitPrice] [money],
	[UnitPriceDiscount] [money],
	[rowguid] [uniqueidentifier] ROWGUIDCOL,
	[ModifiedDate] [datetime],
 CONSTRAINT [PK_SalesOrderDetail_SalesOrderID_SalesOrderDetailID] PRIMARY KEY CLUSTERED 
(
	[SalesOrderID] ASC,
	[SalesOrderDetailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [SalesLT].[SalesOrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_SalesOrderDetail_Product_ProductID] FOREIGN KEY([ProductID])
REFERENCES [SalesLT].[Product] ([ProductID])
GO
ALTER TABLE [SalesLT].[SalesOrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_SalesOrderDetail_SalesOrderHeader_SalesOrderID] FOREIGN KEY([SalesOrderID])
REFERENCES [SalesLT].[SalesOrderHeader] ([SalesOrderID])
ON DELETE CASCADE
GO

--ProductDescription Table
CREATE TABLE [SalesLT].[ProductDescription](
	[ProductDescriptionID] [int] NOT NULL,
	[Description] [nvarchar](max),
	[rowguid] [uniqueidentifier] ROWGUIDCOL,
	[ModifiedDate] [datetime],
 CONSTRAINT [PK_ProductDescription_ProductDescriptionID] PRIMARY KEY CLUSTERED 
(
	[ProductDescriptionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


--ProductModelProductDescription

CREATE TABLE [SalesLT].[ProductModelProductDescription](
	[ProductModelID] [int] NOT NULL,
	[ProductDescriptionID] [int] NOT NULL,
	[Culture] [nvarchar](60) NOT NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL,
	[ModifiedDate] [datetime],
 CONSTRAINT [PK_ProductModelProductDescription_ProductModelID_ProductDescriptionID_Culture] PRIMARY KEY CLUSTERED 
(
	[ProductModelID] ASC,
	[ProductDescriptionID] ASC,
	[Culture] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [SalesLT].[ProductModelProductDescription]  WITH CHECK ADD  CONSTRAINT [FK_ProductModelProductDescription_ProductDescription_ProductDescriptionID] FOREIGN KEY([ProductDescriptionID])
REFERENCES [SalesLT].[ProductDescription] ([ProductDescriptionID])
GO
ALTER TABLE [SalesLT].[ProductModelProductDescription]  WITH CHECK ADD  CONSTRAINT [FK_ProductModelProductDescription_ProductModel_ProductModelID] FOREIGN KEY([ProductModelID])
REFERENCES [SalesLT].[ProductModel] ([ProductModelID])
GO









