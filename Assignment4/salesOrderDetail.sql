USE [assignment_day4]
GO

/****** Object:  Table [dbo].[SalesOrderDetail]    Script Date: 7/12/2016 8:56:33 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

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

GO

SET ANSI_PADDING OFF
GO

