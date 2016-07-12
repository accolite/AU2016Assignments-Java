USE [assignment4]
GO

/****** Object:  Table [dbo].[ProductAW]    Script Date: 7/12/2016 8:51:15 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

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

GO

SET ANSI_PADDING OFF
GO

