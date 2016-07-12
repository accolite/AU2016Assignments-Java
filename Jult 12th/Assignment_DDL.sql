use [AdventureWorks2014]

select * from sales.SalesOrderHeader;

select * from sales.SalesOrderDetail;

select * from Production.Product;

select * from Production.ProductModel;

select * from Production.ProductCategory;

select * from Production.ProductModelProductDescriptionCulture;

select * from Production.ProductDescription;


--select count(*) from SalesLT.SalesOrderHeader


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
create schema SalesLT









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

select * from SalesLT.Address
delete from SalesLT.Address

INSERT [SalesLT].[Address] ([AddressID], [AddressLine1], [AddressLine2], [City], [StateProvince], [CountryRegion], [PostalCode], [rowguid], [ModifiedDate]) VALUES (9, N'8713 Yosemite Ct.', NULL, N'Bothell', N'Washington', N'United States', N'98011', N'268af621-76d7-4c78-9441-144fd139821a', CAST(N'2002-07-01 00:00:00.000' AS DateTime))




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

select * from SalesLT.Customer
delete from SalesLT.Customer


INSERT [SalesLT].[Customer] ([CustomerID], [NameStyle], [Title], [FirstName], [MiddleName], [LastName], [Suffix], [CompanyName], [SalesPerson], [EmailAddress], [Phone], [PasswordHash], [PasswordSalt], [rowguid], [ModifiedDate]) VALUES (1, 0, N'Mr.', N'Orlando', N'N.', N'Gee', NULL, N'A Bike Store', N'adventure-works\pamela0', N'orlando0@adventure-works.com', N'245-555-0173', N'L/Rlwxzp4w7RWmEgXX+/A7cXaePEPcp+KwQhl2fJL7w=', N'1KjXYs4=', N'3f5ae95e-b87d-4aed-95b4-c3797afcb74f', CAST(N'2001-08-01 00:00:00.000' AS DateTime))


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
ALTER TABLE [SalesLT].[CustomerAddress] CHECK CONSTRAINT [FK_CustomerAddress_Address_AddressID]
GO
ALTER TABLE [SalesLT].[CustomerAddress]  WITH CHECK ADD  CONSTRAINT [FK_CustomerAddress_Customer_CustomerID] FOREIGN KEY([CustomerID])
REFERENCES [SalesLT].[Customer] ([CustomerID])
GO
ALTER TABLE [SalesLT].[CustomerAddress] CHECK CONSTRAINT [FK_CustomerAddress_Customer_CustomerID]
GO




INSERT [SalesLT].[CustomerAddress] ([CustomerID], [AddressID], [AddressType], [rowguid], [ModifiedDate]) VALUES (29485, 1086, N'Main Office', N'16765338-dbe4-4421-b5e9-3836b9278e63', CAST(N'2003-09-01 00:00:00.000' AS DateTime))



drop table SalesLT.SalesOrderDetail

drop table SalesLT.SalesOrderHeader

INSERT [SalesLT].[SalesOrderHeader] ([SalesOrderID], [RevisionNumber], [OrderDate], [DueDate], [ShipDate], [Status], [OnlineOrderFlag], [PurchaseOrderNumber], [AccountNumber], [CustomerID], [ShipToAddressID], [BillToAddressID], [ShipMethod], [CreditCardApprovalCode], [SubTotal], [TaxAmt], [Freight], [Comment], [rowguid], [ModifiedDate]) VALUES (71776, 2, CAST(N'2004-06-01 00:00:00.000' AS DateTime), CAST(N'2004-06-13 00:00:00.000' AS DateTime), CAST(N'2004-06-08 00:00:00.000' AS DateTime), 5, 0, N'PO19952192051', N'10-4020-000106', 30072, 640, 640, N'CARGO TRANSPORT 5', NULL, 78.8100, 6.3048, 1.9703, NULL, N'8a3448c5-e677-4158-a29b-dd33069be0b0', CAST(N'2004-06-08 00:00:00.000' AS DateTime))

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
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO


--ALTER TABLE [SalesLT].[SalesOrderHeader]  WITH CHECK ADD  CONSTRAINT [FK_SalesOrderHeader_Address_BillTo_AddressID] FOREIGN KEY([BillToAddressID])
--REFERENCES [SalesLT].[Address] ([AddressID])
--GO
--ALTER TABLE [SalesLT].[SalesOrderHeader] CHECK CONSTRAINT [FK_SalesOrderHeader_Address_BillTo_AddressID]
--GO
--ALTER TABLE [SalesLT].[SalesOrderHeader]  WITH CHECK ADD  CONSTRAINT [FK_SalesOrderHeader_Address_ShipTo_AddressID] FOREIGN KEY([ShipToAddressID])
--REFERENCES [SalesLT].[Address] ([AddressID])
--GO
--ALTER TABLE [SalesLT].[SalesOrderHeader] CHECK CONSTRAINT [FK_SalesOrderHeader_Address_ShipTo_AddressID]
--GO
ALTER TABLE [SalesLT].[SalesOrderHeader]  WITH CHECK ADD  CONSTRAINT [FK_SalesOrderHeader_Customer_CustomerID] FOREIGN KEY([CustomerID])
REFERENCES [SalesLT].[Customer] ([CustomerID])
GO

INSERT [SalesLT].[SalesOrderHeader] ([SalesOrderID], [RevisionNumber], [OrderDate], [DueDate], [ShipDate], [Status], [OnlineOrderFlag], [PurchaseOrderNumber], [AccountNumber], [CustomerID], [ShipToAddressID], [BillToAddressID], [ShipMethod], [CreditCardApprovalCode], [SubTotal], [TaxAmt], [Freight], [Comment], [rowguid], [ModifiedDate]) VALUES (71774, 1, CAST(N'2004-06-01 00:00:00.000' AS DateTime), CAST(N'2004-06-13 00:00:00.000' AS DateTime), CAST(N'2004-06-08 00:00:00.000' AS DateTime), 5, 0, N'PO348186287', N'10-4020-000609', 29847, 1092, 1092, N'CARGO TRANSPORT 5', NULL, 880.3484, 70.4279, 22.0087, NULL, N'89e42cdc-8506-48a2-b89b-eb3e64e3554e', CAST(N'2004-06-08 00:00:00.000' AS DateTime))




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
ALTER TABLE [SalesLT].[ProductCategory] CHECK CONSTRAINT [FK_ProductCategory_ProductCategory_ParentProductCategoryID_ProductCategoryID]
GO

INSERT [SalesLT].[ProductCategory] ([ProductCategoryID], [ParentProductCategoryID], [Name], [rowguid], [ModifiedDate]) VALUES (1, NULL, N'Bikes', N'cfbda25c-df71-47a7-b81b-64ee161aa37c', CAST(N'1998-06-01 00:00:00.000' AS DateTime))
	


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


INSERT [SalesLT].[ProductModel] ([ProductModelID], [Name], [CatalogDescription], [rowguid], [ModifiedDate]) VALUES (1, N'Classic Vest', NULL, N'29321d47-1e4c-4aac-887c-19634328c25e', CAST(N'2003-06-01 00:00:00.000' AS DateTime))


drop table SalesLT.Product

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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [AK_Product_Name] UNIQUE NONCLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [AK_Product_ProductNumber] UNIQUE NONCLUSTERED 
(
	[ProductNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [SalesLT].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_ProductCategory_ProductCategoryID] FOREIGN KEY([ProductCategoryID])
REFERENCES [SalesLT].[ProductCategory] ([ProductCategoryID])
GO
ALTER TABLE [SalesLT].[Product] CHECK CONSTRAINT [FK_Product_ProductCategory_ProductCategoryID]
GO
ALTER TABLE [SalesLT].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_ProductModel_ProductModelID] FOREIGN KEY([ProductModelID])
REFERENCES [SalesLT].[ProductModel] ([ProductModelID])
ALTER TABLE [SalesLT].[Product] CHECK CONSTRAINT [FK_Product_ProductModel_ProductModelID]
GO

select * from SalesLT.Product;

INSERT [SalesLT].[Product] ([ProductID], [Name], [ProductNumber], [Color], [StandardCost], [ListPrice], [Size], [Weight], [ProductCategoryID], [ProductModelID], [SellStartDate], [SellEndDate], [DiscontinuedDate], [ThumbNailPhoto], [ThumbnailPhotoFileName], [rowguid], [ModifiedDate]) VALUES (680, N'HL Road Frame - Black, 58', N'FR-R92B-58', N'Black', 1059.3100, 1431.5000, N'58', CAST(1016.04 AS Decimal(8, 2)), 18, 6, CAST(N'1998-06-01 00:00:00.000' AS DateTime), NULL, NULL, 0x47494638396150003100F70000000000800000008000808000000080800080008080808080C0C0C0FF000000FF00FFFF000000FFFF00FF00FFFFFFFFFF0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000330000660000990000CC0000FF0033000033330033660033990033CC0033FF0066000066330066660066990066CC0066FF0099000099330099660099990099CC0099FF00CC0000CC3300CC6600CC9900CCCC00CCFF00FF0000FF3300FF6600FF9900FFCC00FFFF3300003300333300663300993300CC3300FF3333003333333333663333993333CC3333FF3366003366333366663366993366CC3366FF3399003399333399663399993399CC3399FF33CC0033CC3333CC6633CC9933CCCC33CCFF33FF0033FF3333FF6633FF9933FFCC33FFFF6600006600336600666600996600CC6600FF6633006633336633666633996633CC6633FF6666006666336666666666996666CC6666FF6699006699336699666699996699CC6699FF66CC0066CC3366CC6666CC9966CCCC66CCFF66FF0066FF3366FF6666FF9966FFCC66FFFF9900009900339900669900999900CC9900FF9933009933339933669933999933CC9933FF9966009966339966669966999966CC9966FF9999009999339999669999999999CC9999FF99CC0099CC3399CC6699CC9999CCCC99CCFF99FF0099FF3399FF6699FF9999FFCC99FFFFCC0000CC0033CC0066CC0099CC00CCCC00FFCC3300CC3333CC3366CC3399CC33CCCC33FFCC6600CC6633CC6666CC6699CC66CCCC66FFCC9900CC9933CC9966CC9999CC99CCCC99FFCCCC00CCCC33CCCC66CCCC99CCCCCCCCCCFFCCFF00CCFF33CCFF66CCFF99CCFFCCCCFFFFFF0000FF0033FF0066FF0099FF00CCFF00FFFF3300FF3333FF3366FF3399FF33CCFF33FFFF6600FF6633FF6666FF6699FF66CCFF66FFFF9900FF9933FF9966FF9999FF99CCFF99FFFFCC00FFCC33FFCC66FFCC99FFCCCCFFCCFFFFFF00FFFF33FFFF66FFFF99FFFFCCFFFFFF21F90401000010002C00000000500031000008FF00FF091C48B0A0C18308132A5CC8B0A1C38710234A9C48B1A2C58B18336ADCC8B1A3C78F20438A1C49B2A4C9932853AA5C9911058A812E17C664F9D0E5CB7F3313E6A4C9D0A6C099366FC27C19D367CEA04371DE44CA1169D1A542952A25FA1467D2A7547F46C558542AD0A855A58A9D9AD52BD4A654C3EE547BD6AC58AC3E377E2DBB96EED9AF6FCB7A9C9B97205BAD7DB1F6952B74EED6BF79E3B2DDC95362E1AD8D2F328D4CB9B2E5CB9831C77518D62063C6223743040DD82F6490558FA6BD0B152F5EB2A8B3AA7EEC96B651D96D3BFE9D8D7BE86EBB1F7F034ECD3AF06AD292831237EEB6F9F290AAB5B65DEE9A7A6EC249A7FA7EAEDC79EBD399C38B121F4FBEBCF9F3E8D3AB5FCFBEBDFBF7EF0302003B, N'no_image_available_small.gif', N'43dd68d6-14a4-461f-9069-55309d90ea7e', CAST(N'2004-03-11 10:01:36.827' AS DateTime))



--drop table SalesLt.SalesOrderDetail

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
ALTER TABLE [SalesLT].[SalesOrderDetail] CHECK CONSTRAINT [FK_SalesOrderDetail_Product_ProductID]
GO
ALTER TABLE [SalesLT].[SalesOrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_SalesOrderDetail_SalesOrderHeader_SalesOrderID] FOREIGN KEY([SalesOrderID])
REFERENCES [SalesLT].[SalesOrderHeader] ([SalesOrderID])
ON DELETE CASCADE
GO
ALTER TABLE [SalesLT].[SalesOrderDetail] CHECK CONSTRAINT [FK_SalesOrderDetail_SalesOrderHeader_SalesOrderID]
GO

INSERT [SalesLT].[SalesOrderDetail] ([SalesOrderID], [SalesOrderDetailID], [OrderQty], [ProductID], [UnitPrice], [UnitPriceDiscount], [rowguid], [ModifiedDate]) VALUES (71774, 110562, 1, 836, 356.8980, 0.0000, N'e3a1994c-7a68-4ce8-96a3-77fdd3bbd730', CAST(N'2004-06-01 00:00:00.000' AS DateTime))

select * from SalesLT.SalesOrderHeader;

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


INSERT [SalesLT].[ProductDescription] ([ProductDescriptionID], [Description], [rowguid], [ModifiedDate]) VALUES (3, N'Chromoly steel.', N'301eed3a-1a82-4855-99cb-2afe8290d641', CAST(N'2003-06-01 00:00:00.000' AS DateTime))


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
ALTER TABLE [SalesLT].[ProductModelProductDescription] CHECK CONSTRAINT [FK_ProductModelProductDescription_ProductDescription_ProductDescriptionID]
GO
ALTER TABLE [SalesLT].[ProductModelProductDescription]  WITH CHECK ADD  CONSTRAINT [FK_ProductModelProductDescription_ProductModel_ProductModelID] FOREIGN KEY([ProductModelID])
REFERENCES [SalesLT].[ProductModel] ([ProductModelID])
GO
ALTER TABLE [SalesLT].[ProductModelProductDescription] CHECK CONSTRAINT [FK_ProductModelProductDescription_ProductModel_ProductModelID]
GO
INSERT [SalesLT].[ProductModelProductDescription] ([ProductModelID], [ProductDescriptionID], [Culture], [rowguid], [ModifiedDate]) VALUES (1, 1199, N'en    ', N'9fcbccbf-56cc-48e5-9bf9-42fc99af0968', CAST(N'2003-06-01 00:00:00.000' AS DateTime))









