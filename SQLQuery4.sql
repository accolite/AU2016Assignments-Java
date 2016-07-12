create database assignnewdb;
use assignnewdb;
CREATE TABLE [dbo].[Address](
	[AddressID] [int] NOT NULL,
	[AddressLine1] [varchar](100) NULL,
	[AddressLine2] [varchar](100) NULL,
	[City] [varchar](100) NULL,
	[StateProvince] [varchar](100) NULL,
	[CountryRegion] [varchar](100) NULL,
	[PostalCode] [varchar](50) NULL,
	[rowguid] [varchar](100) NULL,
	[ModifiedDate] [datetime] NULL,
 CONSTRAINT [PK_Address] PRIMARY KEY CLUSTERED 
(
	[AddressID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[CustomerAW](
	[CustomerID] [int] NOT NULL,
	[FirstName] [varchar](50) NOT NULL,
	[MiddleName] [varchar](50) NULL,
	[LastName] [varchar](50) NULL,
	[CompanyName] [varchar](50) NULL,
	[EmailAddress] [varchar](100) NULL,
	[NameStyle] [int] NULL,
	[Title] [varchar](50) NULL,
	[Suffix] [varchar](100) NULL,
	[SalesPerson] [varchar](100) NULL,
	[Phone] [varchar](50) NULL,
	[PasswordHash] [varchar](100) NULL,
	[PasswordSalt] [varchar](100) NULL,
	[rowguid] [varchar](100) NULL,
	[ModifiedDate] [datetime] NULL,
 CONSTRAINT [PK_CustomerAW] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[CustomerAddress](
	[CustomerID] [int] NOT NULL,
	[AddressID] [int] NULL,
	[AddressType] [varchar](50) NULL,
	[rowguid] [varchar](100) NULL,
	[ModifiedDate] [datetime] NULL,
 CONSTRAINT [PK_CustomerAddress] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[SalesOrderHeader](
	[SalesOrderID] [int] NOT NULL,
	[RevisionNumber] [int] NULL,
	[OrderDate] [datetime] NULL,
	[CustomerID] [int] NULL,
	[BillToAddressID] [int] NULL,
	[ShipToAddressID] [int] NULL,
	[ShipMethod] [varchar](50) NULL,
	[SubTotal] [int] NULL,
	[TaxAmt] [int] NULL,
	[Freight] [int] NULL,
	[DueDate] [datetime] NULL,
	[ShipDate] [datetime] NULL,
	[Status] [int] NULL,
	[OnlineOrderFlag] [int] NULL,
	[PurchaseOrderNumber] [varchar](100) NULL,
	[AccountNumber] [varchar](100) NULL,
	[CreditCardApprovalCode] [varchar](100) NULL,
	[Comment] [varchar](200) NULL,
	[rowguid] [varchar](100) NULL,
	[ModifiedDate] [datetime] NULL,
 CONSTRAINT [PK_SalesOrderHeader] PRIMARY KEY CLUSTERED 
(
	[SalesOrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]






CREATE TABLE [dbo].[ProductModel](
	[ProductModelID] [int] NOT NULL,
	[Name] [varchar](max) NULL,
	[CatalogDescription] [varchar](max) NULL,
	[rowguid] [varchar](100) NULL,
	[ModifiedDate] [datetime] NULL,
 CONSTRAINT [PK_ProductModel] PRIMARY KEY CLUSTERED 
(
	[ProductModelID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]


CREATE TABLE [dbo].[ProductAW](
	[ProductID] [int] NOT NULL,
	[Name] [varchar](max) NULL,
	[Color] [varchar](max) NULL,
	[ListPrice] [int] NULL,
	[Size] [int] NULL,
	[Weight] [int] NULL,
	[ProductModelID] [int] NULL,
	[ProductCategoryID] [int] NULL,
	[StandardCost] [int] NULL,
	[SellStartDate] [datetime] NULL,
	[SellEndDate] [datetime] NULL,
	[DiscontinuedDate] [datetime] NULL,
	[rowguid] [varchar](100) NULL,
	[ModifiedDate] [datetime] NULL,
	[ThumbNailPhoto] [image] NULL,
	[ThumbnailPhotoFileName] [varchar](max) NULL,
	[ProductNumber] [varchar](max) NULL,
 CONSTRAINT [PK_ProductAW] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]


CREATE TABLE [dbo].[SalesOrderDetail](
	[SalesOrderID] [int] NOT NULL,
	[SalesOrderDetailID] [int] NOT NULL,
	[OrderQty] [int] NULL,
	[ProductID] [int] NULL,
	[UnitPrice] [int] NULL,
	[UnitPriceDiscount] [int] NULL,
	[rowguid] [varchar](100) NULL,
	[ModifiedDate] [datetime] NULL,
 CONSTRAINT [PK_SalesOrderDetail_1] PRIMARY KEY CLUSTERED 
(
	[SalesOrderDetailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]












select * from Address where AddressID in (select AddressID from customerAddress,CustomerAW where customerAddress.customerID=CustomerAW.customerID and CompanyName='Modular Cycle Systems');
select * from SalesOrderHeader JOIN SalesOrderDetail on SalesOrderHeader.SalesOrderID=SalesOrderDetail.SalesOrderID Join ProductAW on SalesOrderDetail.ProductID=ProductAW.ProductID where SalesOrderHeader.CustomerID=29957;

select  CompanyName from CustomerAW Join CustomerAddress on(CustomerAW.CustomerID=CustomerAddress.CustomerID) where AddressID in(select AddressID from Address where City='Dallas')
select CompanyName from CustomerAW where CustomerID in( select CustomerID from SalesOrderHeader Group By CustomerID Having (Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight)>100000));

--select CustomerID,sum(subTotal),sum(TaxAmt),sum(Freight) from SalesOrderHeader Group By CustomerID Having (Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight)>100000));
--
select * from CustomerAW Join CustomerAddress on(CustomerAddress.CustomerID=CustomerAddress.CustomerID);
select * from Address where City='Dallas';