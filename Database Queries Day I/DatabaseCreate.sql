USE [master]
GO

/****** Object:  Database [MyAdventureWorks]    Script Date: 7/12/2016 9:17:30 PM ******/
CREATE DATABASE [MyAdventureWorks]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MyAdventureWorks', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\MyAdventureWorks.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MyAdventureWorks_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\MyAdventureWorks_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

ALTER DATABASE [MyAdventureWorks] SET COMPATIBILITY_LEVEL = 120
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MyAdventureWorks].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [MyAdventureWorks] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET ARITHABORT OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [MyAdventureWorks] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [MyAdventureWorks] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET  DISABLE_BROKER 
GO

ALTER DATABASE [MyAdventureWorks] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [MyAdventureWorks] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET RECOVERY SIMPLE 
GO

ALTER DATABASE [MyAdventureWorks] SET  MULTI_USER 
GO

ALTER DATABASE [MyAdventureWorks] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [MyAdventureWorks] SET DB_CHAINING OFF 
GO

ALTER DATABASE [MyAdventureWorks] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [MyAdventureWorks] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO

ALTER DATABASE [MyAdventureWorks] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [MyAdventureWorks] SET  READ_WRITE 
GO

USE [MyAdventureWorks]
GO

/****** Object:  Table [dbo].[Address]    Script Date: 7/12/2016 9:18:02 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Address](
	[AddressID] [int] NOT NULL,
	[AddressLine1] [nvarchar](50) NULL,
	[AddressLine2] [nvarchar](50) NULL,
	[City] [nvarchar](50) NULL,
	[StateProvince] [nvarchar](50) NULL,
	[CountryRegion] [nvarchar](50) NULL,
	[PostalCode] [nvarchar](50) NULL,
	[rowguid] [nvarchar](50) NULL,
	[ModifiedDate] [date] NULL,
 CONSTRAINT [PK_Address] PRIMARY KEY CLUSTERED 
(
	[AddressID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


USE [MyAdventureWorks]
GO

/****** Object:  Table [dbo].[CustomerAddress]    Script Date: 7/12/2016 9:18:12 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[CustomerAddress](
	[CustomerID] [nvarchar](50) NOT NULL,
	[AddressID] [nvarchar](50) NULL,
	[AddressType] [nvarchar](50) NULL,
	[rowguid] [nvarchar](50) NULL,
	[ModifiedDate] [date] NULL
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[CustomerAddress]  WITH CHECK ADD  CONSTRAINT [FK_CustomerAddress_CustomerAW] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([CustomerID])
GO

ALTER TABLE [dbo].[CustomerAddress] CHECK CONSTRAINT [FK_CustomerAddress_CustomerAW]
GO


USE [MyAdventureWorks]
GO

/****** Object:  Table [dbo].[Customer]    Script Date: 7/12/2016 9:18:20 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Customer](
	[CustomerID] [nvarchar](50) NOT NULL,
	[FirstName] [nvarchar](50) NULL,
	[MiddleName] [nvarchar](50) NULL,
	[LastName] [nvarchar](50) NULL,
	[CompanyName] [nvarchar](50) NULL,
	[EmailAddress] [nvarchar](50) NULL,
	[Namestyle] [nvarchar](50) NULL,
	[Title] [nvarchar](50) NULL,
	[Suffix] [nvarchar](50) NULL,
	[SalesPerson] [nvarchar](50) NULL,
	[Phone] [nvarchar](50) NULL,
	[PasswordHash] [nvarchar](50) NULL,
	[PasswordSalt] [nvarchar](50) NULL,
	[rowguid] [nvarchar](50) NULL,
	[ModifiedDate] [date] NULL,
 CONSTRAINT [PK_CustomerAW] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


USE [MyAdventureWorks]
GO

/****** Object:  Table [dbo].[Product]    Script Date: 7/12/2016 9:18:29 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Product](
	[ProductID] [nvarchar](50) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Color] [nvarchar](50) NULL,
	[ListPrice] [int] NULL,
	[Size] [int] NULL,
	[Weight] [int] NULL,
	[ProductModelID] [nvarchar](50) NULL,
	[ProductCategoryID] [nvarchar](50) NULL,
	[StandardCost] [nvarchar](50) NULL,
	[ThumbNailPhoto] [varbinary](max) NULL,
	[ThumbnailPhotoFileName] [nvarchar](50) NULL,
	[rowguid] [nvarchar](50) NULL,
	[ModifiedDate] [date] NULL,
	[SellStartDate] [date] NULL,
	[SellEndDate] [date] NULL,
	[DiscontinuedDate] [date] NULL,
	[ProductNumber] [nvarchar](50) NULL,
 CONSTRAINT [PK_ProductAW] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


USE [MyAdventureWorks]
GO

/****** Object:  Table [dbo].[ProductCategory]    Script Date: 7/12/2016 9:18:55 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ProductCategory](
	[ProductCategoryID] [nvarchar](50) NOT NULL,
	[ParentProductCategoryID] [nvarchar](50) NULL,
	[Name] [nvarchar](50) NULL,
	[rowguid] [nvarchar](50) NULL,
	[ModifiedDate] [date] NULL,
 CONSTRAINT [PK_ProductCategory] PRIMARY KEY CLUSTERED 
(
	[ProductCategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


USE [MyAdventureWorks]
GO

/****** Object:  Table [dbo].[ProductDescription]    Script Date: 7/12/2016 9:19:04 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ProductDescription](
	[ProductDescriptionID] [nvarchar](50) NOT NULL,
	[Description] [nvarchar](50) NULL,
	[rowguid] [nvarchar](50) NULL,
	[ModifiedDate] [date] NULL,
 CONSTRAINT [PK_ProductDescription] PRIMARY KEY CLUSTERED 
(
	[ProductDescriptionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


USE [MyAdventureWorks]
GO

/****** Object:  Table [dbo].[ProductModel]    Script Date: 7/12/2016 9:19:20 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ProductModel](
	[ProductModelID] [nvarchar](50) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[CatalogDescription] [nvarchar](50) NULL,
	[rowguid] [nvarchar](50) NULL,
	[ModifiedDate] [date] NULL,
 CONSTRAINT [PK_ProductModel] PRIMARY KEY CLUSTERED 
(
	[ProductModelID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


USE [MyAdventureWorks]
GO

/****** Object:  Table [dbo].[ProductModelProductDescription]    Script Date: 7/12/2016 9:19:27 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ProductModelProductDescription](
	[ProductModelID] [nvarchar](50) NOT NULL,
	[ProductDescriptionID] [nvarchar](50) NOT NULL,
	[Culture] [nvarchar](50) NOT NULL
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[ProductModelProductDescription]  WITH CHECK ADD  CONSTRAINT [FK_ProductModelProductDescription_ProductModel] FOREIGN KEY([ProductModelID])
REFERENCES [dbo].[ProductModel] ([ProductModelID])
GO

ALTER TABLE [dbo].[ProductModelProductDescription] CHECK CONSTRAINT [FK_ProductModelProductDescription_ProductModel]
GO


USE [MyAdventureWorks]
GO

/****** Object:  Table [dbo].[SalesOrderDetail]    Script Date: 7/12/2016 9:19:34 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[SalesOrderDetail](
	[SalesOrderID] [nvarchar](50) NOT NULL,
	[SalesOrderDetailID] [nvarchar](50) NULL,
	[OrderQty] [int] NULL,
	[ProductID] [nvarchar](50) NULL,
	[UnitPrice] [int] NULL,
	[UnitPriceDiscount] [int] NULL,
	[rowguid] [nvarchar](50) NULL,
	[ModifiedDate] [date] NULL,
 CONSTRAINT [PK_SalesOrderDetail] PRIMARY KEY CLUSTERED 
(
	[SalesOrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


USE [MyAdventureWorks]
GO

/****** Object:  Table [dbo].[SalesOrderHeader]    Script Date: 7/12/2016 9:19:41 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[SalesOrderHeader](
	[SalesOrderID] [nvarchar](50) NOT NULL,
	[RevisionNumber] [nvarchar](50) NULL,
	[OrderDate] [date] NULL,
	[CustomerID] [nvarchar](50) NULL,
	[BillToAddressID] [nvarchar](50) NULL,
	[ShipToAddressID] [nvarchar](50) NULL,
	[ShipMethod] [nvarchar](50) NULL,
	[SubTotal] [int] NULL,
	[TaxAmt] [int] NULL,
	[Freight] [int] NULL,
	[DueDate] [nvarchar](50) NULL,
	[ShipDate] [nvarchar](50) NULL,
	[Status] [nvarchar](50) NULL,
	[OnlineOrderFlag] [nvarchar](50) NULL,
	[PurchaseOrderNumber] [nvarchar](50) NULL,
	[AccountNumber] [nvarchar](50) NULL,
	[CreditCardApprovalCode] [nvarchar](50) NULL,
	[Comment] [nvarchar](50) NULL,
	[rowguid] [nvarchar](50) NULL,
	[ModifiedDate] [date] NULL,
 CONSTRAINT [PK_SalesOrderHeader] PRIMARY KEY CLUSTERED 
(
	[SalesOrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO



