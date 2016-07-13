USE SalesLT;
GO

create table Customer(
	[CustomerID] [int] , 
	[NameStyle] [int],
	[Title] nvarchar(max),
	[FirstName] nvarchar(max) ,  
	[MiddleName] nvarchar(max) ,   
	[LastName] nvarchar(max) , 
	[Suffix]  nvarchar(max) , 
	[CompanyName] nvarchar(max) , 
	[SalesPerson] nvarchar(max) , 
	[EmailAddress] nvarchar(max) , 
	[Phone] nvarchar(max) , 
	[PasswordHash] nvarchar(max) , 
	[PasswordSalt] nvarchar(max) , 
	[rowguid] nvarchar(max) , 
	[ModifiedDate] [datetime],
	);
GO

create table CustomerAddress(
	[CustomerID] int,
	[AddressID] int, 
	[AddressType] nvarchar(max), 
	[rowguid] nvarchar(max), 
	[ModifiedDate] Date,
);
GO

create table Address(
	[AddressID] int, 
	[AddressLine1] nvarchar(max),
	[AddressLine2] nvarchar(max),
	[City] nvarchar(max),
	[StateProvince] nvarchar(max),
	[CountryRegion] nvarchar(max),
	[PostalCode] nvarchar(max),
	[rowguid] nvarchar(max),
	[ModifiedDate] Date,
	);
GO

create table SalesOrderHeader(
	[SalesOrderID] int, 
	[RevisionNumber] int, 
	[OrderDate] Date, 
	[DueDate] Date, 
	[ShipDate] Date, 
	[Status] int, 
	[OnlineOrderFlag] int, 
	[PurchaseOrderNumber] nvarchar(max),
	[AccountNumber] nvarchar(max), 
	[CustomerID] int, 
	[ShipToAddressID] int, 
	[BillToAddressID] int, 
	[ShipMethod] nvarchar(max),
	[CreditCardApprovalCode] int,
	[SubTotal] float, 
	[TaxAmt] float, 
	[Freight] float, 
	[Comment] nvarchar(max),
	[rowguid] nvarchar(max), 
	[ModifiedDate] Date,
	);
GO

create table SalesOrderDetail(
	[SalesOrderID] int, 
	[SalesOrderDetailID] int, 
	[OrderQty] int, 
	[ProductID] int, 
	[UnitPrice] float, 
	[UnitPriceDiscount] float, 
	[rowguid] nvarchar(max),
	[ModifiedDate] Date,
	);
GO

create table Product(
	[ProductID] int , 
	[Name] nvarchar(max),
	[ProductNumber] nvarchar(max),
	[Color] nvarchar(max),
	[StandardCost] float,
	[ListPrice] float, 
	[Size] nvarchar(max),
	[Weight] Decimal(8, 2),
	[ProductCategoryID] int ,
	[ProductModelID] int ,
	[SellStartDate] Date, 
	[SellEndDate] Date, 
	[DiscontinuedDate] Date, 
	[ThumbNailPhoto] nvarchar(max),
	[ThumbnailPhotoFileName] nvarchar(max),
	[rowguid] nvarchar(max),
	[ModifiedDate] Date,
	
	);
GO

create table ProductModel(
	[ProductModelID] int, 
	[Name] nvarchar(max) , 
	[CatalogDescription] nvarchar(max) , 
	[rowguid] nvarchar(max) , 
	[ModifiedDate] Date,
);
GO

create table ProductCategory(
	[ProductCategoryID] int, 
	[ParentProductCategoryID] int, 
	[Name] nvarchar(max) , 
	[rowguid] nvarchar(max) , 
	[ModifiedDate] Date,
);
GO

create table ProductModelProductDescription(
	[ProductModelID] int , 
	[ProductDescriptionID] int, 
	[Culture] nvarchar(max) , 
	[rowguid] nvarchar(max) , 
	[ModifiedDate] Date,
);
GO

create table ProductDescription(
	[ProductDescriptionID] int, 
	[Description] nvarchar(max) ,  
	[rowguid] nvarchar(max) ,  
	[ModifiedDate] Date,
);
GO

/*
--first
select AddressID,AddressLine1,AddressLine2,City,StateProvince,CountryRegion,PostalCode from Address 
where AddressID in
(select c2.AddressID 
from Customer c1 inner join CustomerAddress c2 
on c1.CustomerID=c2.CustomerID 
where c1.CompanyName='Modular Cycle Systems');



--second
select * from SalesOrderHeader JOIN SalesOrderDetail on SalesOrderHeader.SalesOrderID=SalesOrderDetail.SalesOrderID Join
 Product on SalesOrderDetail.ProductID=Product.ProductID 
where SalesOrderHeader.CustomerID=29929;


--third

select c.CompanyName from Customer as c
where c.CustomerID in 
(
select c1.CustomerID 
from CustomerAddress c1 inner join Address c2 
on c1.AddressID=c2.AddressID 
where c2.City='Dallas');


--fourth
select CompanyName 
from Customer 
where CustomerID in
( select CustomerID 
from SalesOrderHeader 
Group By CustomerID 
Having ((Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight))>100000));
*/


--fifth

--Select * from SalesOrderHeader
Select sd.SalesOrderID,sum(sd.UnitPrice) from SalesOrderDetail as sd inner join
SalesOrderHeader as sh on sd.SalesOrderID=sh.SalesOrderID group by sd.SalesOrderID having
count(sd.SalesOrderID)=1;


--sixth
Select distinct  p.Name,c.CompanyName from Customer as c inner join SalesOrderHeader as sh
on c.CustomerID=sh.CustomerID inner join SalesOrderDetail as sd on 
sd.SalesOrderID = sh.SalesOrderID inner join Product as p on p.ProductID=sd.ProductID 
inner join ProductModel as pm on pm.ProductModelID=p.ProductModelID where pm.Name = N'Racing Socks'; 

--seventh

Select count(distinct(sd.ProductID)) from ProductCategory as pc inner join Product  as p on
pc.ProductCategoryID=p.ProductCategoryID inner join SalesOrderDetail as sd on p.ProductID= sd.ProductID
inner join SalesOrderHeader as sh on sd.SalesOrderID=sh.SalesOrderID inner join CustomerAddress as ca
on ca.CustomerID=sh.CustomerID inner join Address as a on a.AddressID=ca.AddressID 
where pc.Name='Cranksets' and a.City='London' 


--eight
Select a.CountryRegion,sum(sh.SubTotal) as subTotal
from SalesOrderHeader as sh inner join CustomerAddress as ca on sh.CustomerID=ca.CustomerID
right join Address as a on a.AddressID=ca.AddressID group by a.CountryRegion order by subTotal desc


