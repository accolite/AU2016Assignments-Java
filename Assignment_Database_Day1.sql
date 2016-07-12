
use assignment6;
--[CustomerID], [NameStyle], [Title], [FirstName], [MiddleName], [LastName], [Suffix], [CompanyName], [SalesPerson], [EmailAddress], [Phone], [PasswordHash], [PasswordSalt], [rowguid], [ModifiedDate]) 
--VALUES (30040, 0, N'Ms.', N'Kayla', N'M.', N'Stotler', NULL, N'Major Sporting Goods', N'adventure-works\linda3', N'kayla0@adventure-works.com', N'315-555-0131', N'iqikbQl8bEZb+ulQMP5FNBSjXL1grUcz4NTUP9GBmAQ=', N'ZqTw9GM=', N'e6d036b6-1faa-44c9-8aec-6c9433bebab3', CAST(N'2003-02-01 00:00:00.000' AS DateTime))
create table Customer(
CustomerID int PRIMARY KEY IDENTITY(1,1) NOT NULL,
NameStyle INT,
Title varchar(125),
FirstName varchar(125) NOT NULL,
MiddleName varchar(125),
LastName varchar(125),
Suffix varchar(125),
CompanyName varchar(125) NOT NULL,
SalesPerson varchar(125),
EmailAddress varchar(125),
Phone varchar(125),
PasswordHash varchar(125),
PasswordSalt varchar(125),
rowguid varchar(125),
ModifiedDate date
);

--CustomerAddress (CustomerID, AddressID, AddressType)
create table CustomerAddress(
CustomerID int   NOT NULL,
AddressId INT  NOT NULL,
AddressType varchar(25),
rowguid varchar(125),
ModifiedDate date
Foreign Key(CustomerID) References Customer(CustomerID)
);
delete CustomerAddress
--Address (AddressID, AddressLine1, AddressLine2, City, StateProvince, CountyRegion,
--PostalCode)
create table Address(
AddressID int PRIMARY KEY  IDENTITY(1, 1) NOT NULL,
AddressLine1 varchar(125),
AddressLine2 varchar(125),
City varchar(25),
StateProvince varchar(125),
CountryRegion varchar(125),
PostalCode varchar(125),
rowguid varchar(125),
ModifiedDate date
);
--SalesOrderHeader (SalesOrderID, RevisionNumber, OrderDate, CustomerID, BillToAddressID,
--ShipToAddressID, ShipMethod, SubTotal, TaxAmt, Freight)
--INSERT [dbo].[SalesOrderHeader] ([SalesOrderID], [RevisionNumber], [OrderDate], [DueDate], [ShipDate], [Status], [OnlineOrderFlag], [PurchaseOrderNumber], [AccountNumber],
-- [CustomerID], [ShipToAddressID], [BillToAddressID], [ShipMethod], [CreditCardApprovalCode], [SubTotal], [TaxAmt], [Freight], [Comment], [rowguid], [ModifiedDate]) 
--VALUES (71774, 1, CAST(N'2004-06-01 00:00:00.000' AS DateTime), CAST(N'2004-06-13 00:00:00.000' AS DateTime), CAST(N'2004-06-08 00:00:00.000' AS DateTime), 5, 0, N'PO348186287', N'10-4020-000609', 29847, 1092, 1092, N'CARGO TRANSPORT 5', NULL, 880.3484, 70.4279, 22.0087, NULL, N'89e42cdc-8506-48a2-b89b-eb3e64e3554e', CAST(N'2004-06-08 00:00:00.000' AS DateTime))
create table SalesOrderHeader(
SalesOrderID int PRIMARY KEY IDENTITY(1,1)NOT NULL,
RevisionNumber int,
OrderDate date,
DueDate date,
ShipDate date,
Status int,
OnlineOrderFlag int,
PurchaseOrderNumber varchar(125),
AccountNumber varchar(125),
CustomerID int,
ShipToAddressID int,
BillToAddressID int,
ShipMethod varchar(25),
CreditCardApprovalCode varchar(25),
SubTotal float,
TaxAmt float,
Freight float,
Comment varchar(125),
rowguid varchar(125),
ModifiedDate date
);
--SalesOrderDetail (SalesOrderID, SalesOrderDetailID, OrderQty, ProductID, UnitPrice,
--UnitPriceDiscount)
---
--INSERT [dbo].[SalesOrderDetail] ([SalesOrderID], [SalesOrderDetailID], [OrderQty], [ProductID], [UnitPrice], [UnitPriceDiscount], [rowguid], [ModifiedDate])
-- VALUES (71783, 110734, 4, 797, 672.2940, 0.0000, N'8f859c8b-6996-4e2d-9f0f-0dd0f8fea8db', CAST(N'2004-06-01 00:00:00.000' AS DateTime))
create table SalesOrderDetail(
SalesOrderId int,
SalesOrderDetailId int primary key identity(1,1) NOT NULL,
OrderQty int,
ProductId int,
UnitPrice float,
UnitPriceDiscount float,
rowguid varchar(125),
ModifiedDate date
)
--ProductAW (ProductID, Name, Color, ListPrice, Size, Weight, ProductModelID,
--ProductCategoryID)
--INSERT [dbo].[Product] ([ProductID], [Name], [ProductNumber], [Color], [StandardCost], [ListPrice], [Size], [Weight], [ProductCategoryID], [ProductModelID], [SellStartDate], [SellEndDate], [DiscontinuedDate], [ThumbNailPhoto], [ThumbnailPhotoFileName], [rowguid], [ModifiedDate])
-- VALUES (680, N'HL Road Frame - Black, 58', N'FR-R92B-58', N'Black', 1059.3100, 1431.5000, N'58', CAST(1016.04 AS Decimal(8, 2)), 18, 6, CAST(N'1998-06-01 00:00:00.000' AS DateTime), NULL, NULL, 0x47494638396150003100F70000000000800000008000808000000080800080008080808080C0C0C0FF000000FF00FFFF000000FFFF00FF00FFFFFFFFFF0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000330000660000990000CC0000FF0033000033330033660033990033CC0033FF0066000066330066660066990066CC0066FF0099000099330099660099990099CC0099FF00CC0000CC3300CC6600CC9900CCCC00CCFF00FF0000FF3300FF6600FF9900FFCC00FFFF3300003300333300663300993300CC3300FF3333003333333333663333993333CC3333FF3366003366333366663366993366CC3366FF3399003399333399663399993399CC3399FF33CC0033CC3333CC6633CC9933CCCC33CCFF33FF0033FF3333FF6633FF9933FFCC33FFFF6600006600336600666600996600CC6600FF6633006633336633666633996633CC6633FF6666006666336666666666996666CC6666FF6699006699336699666699996699CC6699FF66CC0066CC3366CC6666CC9966CCCC66CCFF66FF0066FF3366FF6666FF9966FFCC66FFFF9900009900339900669900999900CC9900FF9933009933339933669933999933CC9933FF9966009966339966669966999966CC9966FF9999009999339999669999999999CC9999FF99CC0099CC3399CC6699CC9999CCCC99CCFF99FF0099FF3399FF6699FF9999FFCC99FFFFCC0000CC0033CC0066CC0099CC00CCCC00FFCC3300CC3333CC3366CC3399CC33CCCC33FFCC6600CC6633CC6666CC6699CC66CCCC66FFCC9900CC9933CC9966CC9999CC99CCCC99FFCCCC00CCCC33CCCC66CCCC99CCCCCCCCCCFFCCFF00CCFF33CCFF66CCFF99CCFFCCCCFFFFFF0000FF0033FF0066FF0099FF00CCFF00FFFF3300FF3333FF3366FF3399FF33CCFF33FFFF6600FF6633FF6666FF6699FF66CCFF66FFFF9900FF9933FF9966FF9999FF99CCFF99FFFFCC00FFCC33FFCC66FFCC99FFCCCCFFCCFFFFFF00FFFF33FFFF66FFFF99FFFFCCFFFFFF21F90401000010002C00000000500031000008FF00FF091C48B0A0C18308132A5CC8B0A1C38710234A9C48B1A2C58B18336ADCC8B1A3C78F20438A1C49B2A4C9932853AA5C9911058A812E17C664F9D0E5CB7F3313E6A4C9D0A6C099366FC27C19D367CEA04371DE44CA1169D1A542952A25FA1467D2A7547F46C558542AD0A855A58A9D9AD52BD4A654C3EE547BD6AC58AC3E377E2DBB96EED9AF6FCB7A9C9B97205BAD7DB1F6952B74EED6BF79E3B2DDC95362E1AD8D2F328D4CB9B2E5CB9831C77518D62063C6223743040DD82F6490558FA6BD0B152F5EB2A8B3AA7EEC96B651D96D3BFE9D8D7BE86EBB1F7F034ECD3AF06AD292831237EEB6F9F290AAB5B65DEE9A7A6EC249A7FA7EAEDC79EBD399C38B121F4FBEBCF9F3E8D3AB5FCFBEBDFBF7EF0302003B, N'no_image_available_small.gif', N'43dd68d6-14a4-461f-9069-55309d90ea7e', CAST(N'2004-03-11 10:01:36.827' AS DateTime))
create table Product(
ProductId int PRIMARY KEY identity(1,1)NOT NULL ,
Name varchar(max),
ProductNumber varchar(MAX),
Color varchar(max),
StandardCost float,
ListPrice float,
Size varchar(max),
Weight Decimal(8,2),
ProductModelId int,
ProductCategoryId int,
 SellStartDate date,
  SellEndDate date,
   DiscontinuedDate date,
    ThumbNailPhoto image, 
	ThumbnailPhotoFileName varchar(max) ,
	 rowguid varchar(MAX),
ModifiedDate date
) 
--ProductModel (ProductModelID, Name)
create table ProductModel(
ProductModelId int PRIMARY KEY identity(1,1) NOT NULL,
Name varchar(1250),
CatalogDescription varchar(MAX),
rowguid varchar(1250),
ModifiedDate date
)
--ProductCategory (ProductCategoryID, ParentProductCategoryID Name)
create table ProductCategory(
ProductCategoryID int primary key not null  identity(1,1),
ParentProductCategoryID int,
Name varchar(125),
rowguid varchar(125),
ModifiedDate date
)
--ProductModelProductDescription (ProductModelID, ProductDescriptionID, Culture)
create table ProductModelProductDescription (
ProductModelID int,
ProductDescriptionID int,
Culture varchar
)
--ProductDescription (ProductDescriptionID, Description)
create table ProductDescription (
ProductDescriptionID int,
 Description varchar
)
delete dbo.Address;
delete dbo.CustomerAddress;
delete dbo.CustomerAW;
delete dbo.ProductAW;
delete dbo.ProductCategory;
delete dbo.ProductDescription;
delete dbo.ProductModel;
delete dbo.ProductModelProductDescription;
delete dbo.SalesOrderDetail;
delete dbo.SalesOrderHeader;

--Query 1
SELECT *
FROM Address a1
INNER JOIN CustomerAddress a2
ON a1.AddressID=a2.AddressId
inner join Customer a3
on a3.CustomerID=a2.CustomerID
where a3.CompanyName='Modular Cycle Systems';

--Query2
SELECT s.OrderQty,p.Name,p.ListPrice
FROM Product p INNER JOIN SalesOrderDetail s
ON p.ProductId=s.ProductId
inner join SalesOrderHeader s2
on s2.SalesOrderID=s.SalesOrderId
where s2.CustomerID=635

select * from SalesOrderHeader where CustomerID = 635

--Query3
SELECT C1.CompanyName
FROM Address a INNER JOIN CustomerAddress c
ON a.AddressID=c.AddressId
inner join Customer c1
on c.CustomerID=c1.CustomerID
where a.City='Dallas'

--Query4
SELECT c.CompanyName
FROM SalesOrderHeader s INNER JOIN Customer c
on s.CustomerID=c.CustomerID
where s.SubTotal+s.TaxAmt+s.Freight>100000

--Query5
SELECT *
FROM SalesOrderDetail s
where s.OrderQty=1;

use assignment
--drop table SalesOrderDetail