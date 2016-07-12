USE [assignment4]
GO

/****** Object:  Table [dbo].[SalesOrderHeader]    Script Date: 7/12/2016 8:27:00 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

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

GO

SET ANSI_PADDING OFF
GO

