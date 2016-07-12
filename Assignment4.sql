USE [Assignment4]

create table CustomerAW (CustomerID int NOT NULL, 
FirstName nvarchar(50) NOT NULL, MiddleName nvarchar(50), LastName nvarchar(50) NOT NULL, CompanyName nvarchar(50),EmailAddress nvarchar(50), PRIMARY KEY	(CustomerID));

create table CustomerAddress(CustomerID int NOT NULL, AddressID int NOT NULL, AddressType nvarchar(50),primary key(CustomerID,AddressID));

alter table CustomerAddress
ADD FOREIGN KEY(CustomerID)
REFERENCES CustomerAW(CustomerID);

create table Address (AddressID int NOT NULL, AddressLine1 nvarchar(50), AddressLine2 nvarchar(50), City nvarchar(10), StateProvince nvarchar(50), CountyRegion nvarchar(50),
PostalCode nvarchar(50), PRIMARY KEY(AddressID));

ALTER TABLE CustomerAddress
ADD FOREIGN KEY (AddressID)
REFERENCES Address(AddressID);


create table SalesOrderHeader (SalesOrderID int NOT NULL, RevisionNumber int, OrderDate datetime not null , CustomerID int not null, BillToAddressID int NOT NULL,
ShipToAddressID int NOT NULL, ShipMethod nvarchar(10), SubTotal money not null, TaxAmt money not null, Freight money not null, primary key(SalesOrderID));

ALTER TABLE SalesOrderHeader
ADD FOREIGN KEY (CustomerID)
REFERENCES CustomerAW(CustomerID);

create table SalesOrderDetail (SalesOrderID int NOT NULL, SalesOrderDetailID int not null, OrderQty int NOT NULL, ProductID int NOT NULL, UnitPrice int NOT NULL,
UnitPriceDiscount int, primary key(SalesOrderID,SalesOrderDetailID));

ALTER TABLE SalesOrderDetail
ADD FOREIGN KEY (SalesOrderID)
REFERENCES SalesOrderHeader(SalesOrderID);

create table ProductAW (ProductID int not null, Name nvarchar(50), Color nvarchar(50), ListPrice money not null, Size int , Weight int , ProductModelID int not null ,
ProductCategoryID int not null, primary key(ProductID));

create table ProductModel (ProductModelID int not null, Name nvarchar(50), primary key(ProductModelID));

alter table ProductAW
add foreign key(ProductModelID)
references ProductModel(ProductModelID);

create table ProductCategory (ProductCategoryID int not null, ParentProductCategoryID int not null, Name nvarchar(50), primary key(ProductCategoryID));

create table ProductModelProductDescription (ProductModelID int not null, ProductDescriptionID int not null, Culture int not null, primary key(ProductModelID,ProductDescriptionID,Culture));

create table ProductDescription (ProductDescriptionID int not null, Description nvarchar(50), primary key(ProductDescriptionID));

alter table ProductModelProductDescription
add foreign key(ProductDescriptionID)
references ProductDescription(ProductDescriptionID);

alter table ProductModelProductDescription
add foreign key(ProductModelID)
references ProductModel(ProductModelID);

alter table ProductAW
add foreign key(ProductModelID)
references ProductModel(ProductModelID);

--alter table ProductCategory
--add foreign key(ParentProductCategoryID)
--references ProductCategory(ProductCategoryID);



insert into CustomerAW(CustomerID, FirstName, MiddleName, LastName, CompanyName,
EmailAddress) values(1,'Lowkya',null,'Vuppu','Modular Cycle Systems',null);

insert into CustomerAW(CustomerID, FirstName, MiddleName, LastName, CompanyName,
EmailAddress) values(2,'Lowkya',null,'Vuppu','Modular Cycle',null);

insert into CustomerAW(CustomerID, FirstName, MiddleName, LastName, CompanyName,
EmailAddress) values(3,'Lowkya',null,'Vuppu','Accolite',null);

insert into CustomerAW(CustomerID, FirstName, MiddleName, LastName, CompanyName,
EmailAddress) values(4,'Lowkya',null,'Vuppu','Apple',null);

insert into CustomerAW(CustomerID, FirstName, MiddleName, LastName, CompanyName,
EmailAddress) values(5,'Lowkya',null,'Vuppu','Microsoft',null);

insert into CustomerAW(CustomerID, FirstName, MiddleName, LastName, CompanyName,
EmailAddress) values(635,'Lowkya',null,'Vuppu','Google',null);

select * from Assignment4.dbo.CustomerAW;

insert into Address (AddressID, AddressLine1, AddressLine2, City, StateProvince, CountryRegion,
PostalCode) values(1,'some where',null,null,'telangana','india','500007');

insert into Address (AddressID, AddressLine1, AddressLine2, City, StateProvince, CountryRegion,
PostalCode) values(2,'some where',null,null,'telangana','india','500007');

insert into Address (AddressID, AddressLine1, AddressLine2, City, StateProvince, CountryRegion,
PostalCode) values(3,'some where',null,null,'telangana','india','500007');

insert into Address (AddressID, AddressLine1, AddressLine2, City, StateProvince, CountryRegion,
PostalCode) values(4,'some where',null,null,'telangana','india','500007');

insert into Address (AddressID, AddressLine1, AddressLine2, City, StateProvince, CountryRegion,
PostalCode) values(5,'some where',null,'Dallas','telangana','india','500007');

insert into Address (AddressID, AddressLine1, AddressLine2, City, StateProvince, CountryRegion,
PostalCode) values(6,'some where',null,'Dallas','telangana','india','500007');


insert into CustomerAddress (CustomerID, AddressID, AddressType) values(1,1,'earth');

insert into CustomerAddress (CustomerID, AddressID, AddressType) values(2,2,'earth');

insert into CustomerAddress (CustomerID, AddressID, AddressType) values(3,3,'earth');

insert into CustomerAddress (CustomerID, AddressID, AddressType) values(4,4,'earth');

insert into CustomerAddress (CustomerID, AddressID, AddressType) values(5,5,'earth');

insert into CustomerAddress (CustomerID, AddressID, AddressType) values(635,6,'earth');

--first query using sub queries

select * from Assignment4.dbo.Address address where address.AddressID IN (select customerAddress.AddressID from Assignment4.dbo.CustomerAddress customerAddress where  customerAddress.CustomerID IN (select customer.CustomerID from Assignment4.dbo.CustomerAW customer where customer.CompanyName = 'Modular Cycle Systems'));

select * from Assignment4.dbo.Address address,Assignment4.dbo.CustomerAddress customerAddress,Assignment4.dbo.CustomerAW customer where customerAddress.CustomerID = customer.CustomerID and customerAddress.AddressID=address.AddressID and customer.CompanyName = 'Modular Cycle Systems';

 select * from dbo.CustomerAW;

--truncate table Assignment4.dbo.CustomerAddress;
--truncate table Assignment4.dbo.Address;
--truncate table Assignment4.dbo.CustomerAW;


--third query
select customer.CompanyName from  Assignment4.dbo.CustomerAW customer, Assignment4.dbo.CustomerAddress customerAddress, Assignment4.dbo.Address address where customerAddress.CustomerID = customer.CustomerID and customerAddress.AddressID=address.AddressID and address.City='Dallas';

insert into ProductModel(ProductModelID, Name) values(1,'Pen');

insert into ProductAW (ProductID, Name, Color, ListPrice, Size, Weight, ProductModelID,
ProductCategoryID) values(1,'Pen','black',$10,null,null,1,1);

insert into ProductCategory (ProductCategoryID, ParentProductCategoryID,Name) values(1,1,'Pen');

insert into ProductDescription (ProductDescriptionID, Description) values(1,'This is a parker pen');

insert into ProductModelProductDescription (ProductModelID, ProductDescriptionID, Culture) values(1,1,1);

insert into SalesOrderHeader (SalesOrderID, RevisionNumber, OrderDate, CustomerID, BillToAddressID,
ShipToAddressID, ShipMethod, SubTotal, TaxAmt, Freight) values(1,null, CAST(N'2004-03-11 10:01:36.827' AS DateTime),1,1,1,null,$10,$5,$1);

insert into SalesOrderDetail (SalesOrderID, SalesOrderDetailID, OrderQty, ProductID, UnitPrice,
UnitPriceDiscount) values(1,1,5,1,$10,$0);

insert into ProductModel(ProductModelID, Name) values(2,'Pen');

insert into ProductAW (ProductID, Name, Color, ListPrice, Size, Weight, ProductModelID,
ProductCategoryID) values(2,'Pen','black',$10,null,null,2,2);

insert into ProductCategory (ProductCategoryID, ParentProductCategoryID,Name) values(2,2,'Pen');

insert into ProductDescription (ProductDescriptionID, Description) values(2,'This is a parker pen');

insert into ProductModelProductDescription (ProductModelID, ProductDescriptionID, Culture) values(2,2,2);

insert into SalesOrderHeader (SalesOrderID, RevisionNumber, OrderDate, CustomerID, BillToAddressID,
ShipToAddressID, ShipMethod, SubTotal, TaxAmt, Freight) values(2,null, CAST(N'2004-03-11 10:01:36.827' AS DateTime),635,2,2,null,$10,$5,$1);

insert into SalesOrderDetail (SalesOrderID, SalesOrderDetailID, OrderQty, ProductID, UnitPrice,
UnitPriceDiscount) values(2,2,2,2,$10,$0);

--second query
select  salesOrderDetail.OrderQty,productAW.Name, productAW.ListPrice from dbo.SalesOrderHeader salesOrderHeader, dbo.SalesOrderDetail salesOrderDetail, dbo.ProductAW productAW where salesOrderDetail.ProductID = productAW.ProductID and salesOrderDetail.SalesOrderID = salesOrderHeader.SalesOrderID and salesOrderHeader.CustomerID = 635;

insert into ProductModel(ProductModelID, Name) values(5,'Diamond');

insert into ProductAW (ProductID, Name, Color, ListPrice, Size, Weight, ProductModelID,
ProductCategoryID) values(5,'Diamond','black',$100000,null,null,5,5);

insert into ProductCategory (ProductCategoryID, ParentProductCategoryID,Name) values(5,5,'Diamond');

insert into ProductDescription (ProductDescriptionID, Description) values(5,'This is a Diamond');

insert into ProductModelProductDescription (ProductModelID, ProductDescriptionID, Culture) values(5,5,5);

insert into SalesOrderHeader (SalesOrderID, RevisionNumber, OrderDate, CustomerID, BillToAddressID,
ShipToAddressID, ShipMethod, SubTotal, TaxAmt, Freight) values(5,null, CAST(N'2004-03-11 10:01:36.827' AS DateTime),635,5,5,null,$100000,$5,$1);

insert into SalesOrderDetail (SalesOrderID, SalesOrderDetailID, OrderQty, ProductID, UnitPrice,
UnitPriceDiscount) values(5,5,5,5,$100000,$0);

--fourth query

select customer.CompanyName from dbo.CustomerAW customer, dbo.SalesOrderHeader salesOrderHeader where customer.CustomerID=salesOrderHeader.CustomerID and salesOrderHeader.Freight + salesOrderHeader.SubTotal + salesOrderHeader.TaxAmt >= $100000;



--fifth query
/*
select salesOrderDetail.SalesOrderID,salesOrderDetail.UnitPrice from dbo.SalesOrderDetail salesOrderDetail,dbo.SalesOrderHeader salesOrderHeader,
dbo.CustomerAW customer where customer.CustomerID=salesOrderHeader.CustomerID and salesOrderHeader.SalesOrderID= SalesOrderDetail.SalesOrderID group by SalesOrderDetail.SalesOrderID, salesOrderDetail.UnitPrice having  count(SalesOrderDetail.SalesOrderID)= 1;

select salesOrderDetail.SalesOrderID,salesOrderDetail.UnitPrice from dbo.SalesOrderDetail salesOrderDetail where salesOrderDetail.SalesOrderID  IN (select salesOrderDetail.SalesOrderID from dbo.SalesOrderHeader salesOrderHeader where salesOrderDetail.SalesOrderID=salesOrderDetail.SalesOrderID and salesOrderDetail.OrderQty=1 group by salesOrderDetail.SalesOrderID having COUNT(salesOrderDetail.SalesOrderID) =1);*/
