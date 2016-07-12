
USE assignmentFinal;
GO

CREATE TABLE Customer
( CustomerID INT IDENTITY(1,1) PRIMARY KEY,
  NameStyle INT,
  Title nvarchar(100),
  FirstName nvarchar(100) NOT NULL,
  MiddleName nvarchar(100),
  LastName nvarchar(100)  NOT NULL,
  Suffix nvarchar(100),
  CompanyName nvarchar(100), 
  SalesPerson nvarchar(100),
  EmailAddress nvarchar(100),
  Phone nvarchar(100),
  PasswordHash nvarchar(100),
  PasswordSalt nvarchar(100),
  rowguid nvarchar(100),
  ModifiedDate Date
);

CREATE TABLE Address
( AddressID INT IDENTITY(1,1) PRIMARY KEY,
  AddressLine1 nvarchar(100),
  AddressLine2 nvarchar(100),
  City nvarchar(100),
  StateProvince nvarchar(100),
  CountryRegion nvarchar(100),
  PostalCode nvarchar(100),
  rowguid nvarchar(100),
  ModifiedDate Date
);

CREATE TABLE CustomerAddress
( CustomerID INT NOT NULL,
  AddressID INT NOT NULL,
  AddressType nvarchar(100),
  rowguid nvarchar(100),
  ModifiedDate Date,
  FOREIGN KEY(CustomerID) REFERENCES Customer(CustomerID),
  FOREIGN KEY(AddressID) REFERENCES Address (AddressID),
  PRIMARY KEY(CustomerID, AddressID)
);

CREATE TABLE SalesOrderHeader
( SalesOrderID INT IDENTITY(1,1) PRIMARY KEY,
  RevisionNumber INT,
  OrderDate DATE,
  DueDate Date,
  ShipDate Date,
  Status INT,
  OnlineOrderFlag INT,
  PurchaseOrderNumber INT,
  AccountNumber INT,
  CustomerID INT NOT NULL,
  ShipToAddressID int NOT NULL,
  BillToAddressID int NOT NULL,
  ShipMethod nvarchar(100),
  CreditCardApproval nvarchar(100),
  SubTotal FLOAT NOT NULL,
  TaxAmt FLOAT NOT NULL,
  Freight FLOAT NOT NULL,
  Comment nvarchar(100),
  rowguid nvarchar(100),
  ModifiedDate Date,
  FOREIGN KEY(CustomerID) REFERENCES Customer(CustomerID),
  FOREIGN KEY(BillToAddressID ) REFERENCES Address (AddressID),
  FOREIGN KEY(ShipToAddressID ) REFERENCES Address (AddressID)
);

CREATE TABLE ProductCategory
( ProductCategoryID INT IDENTITY(1,1) PRIMARY KEY,
  ParentProductCategoryID INT,
  Name nvarchar(100) NOT NULL,
  rowguid nvarchar(100),
  ModifiedDate Date,
  FOREIGN KEY(ParentProductCategoryID) REFERENCES ProductCategory(ProductCategoryID),
);


CREATE TABLE ProductModel
( ProductModelID INT IDENTITY(1,1) PRIMARY KEY,
  Name nvarchar(100),
  CatalogDescription nvarchar(100), 
  rowguid nvarchar(100),
  ModifiedDate Date
);



CREATE TABLE Product
( ProductID INT IDENTITY(1,1) PRIMARY KEY,
  Name nvarchar(100),
  ProductNumber nvarchar(100),
  Color nvarchar(100),
  StandardCost FLOAT,
  ListPrice FLOAT NOT NULL,
  Size nvarchar(100),
  Weight FLOAT,
  ProductCategoryID INT,
  ProductModelID INT,
  SellStartDate Date,
  SellEndDate Date,
  DiscontinuedDate Date,
  ThumbNailPhoto varbinary(5000),
  ThumbNailPhotoFileName nvarchar(100), 
  rowguid nvarchar(100),
  ModifiedDate Date,
  FOREIGN KEY(ProductModelID) REFERENCES ProductModel(ProductModelID),
  FOREIGN KEY(ProductCategoryID) REFERENCES ProductCategory(ProductCategoryID)
);



CREATE TABLE SalesOrderDetail
( SalesOrderID INT NOT NULL,
  SalesOrderDetailID INT NOT NULL,
  OrderQty INT NOT NULL,
  ProductID INT NOT NULL,
  UnitPrice FLOAT NOT NULL,
  UnitPriceDiscount FLOAT NOT NULL, 
  rowguid nvarchar(100),
  ModifiedDate Date,
  FOREIGN KEY(SalesOrderID) REFERENCES SalesOrderHeader(SalesOrderID),
  FOREIGN KEY(ProductID ) REFERENCES Product (ProductID),
  PRIMARY KEY(SalesOrderID, SalesOrderDetailID)
);

ALTER TABLE Product ALTER COLUMN Size INTEGER NOT NULL

Drop table Product;

CREATE TABLE ProductDescription
( ProductDescriptionID INT IDENTITY(1,1) PRIMARY KEY,
  Description nvarchar(100), 
  rowguid nvarchar(100),
  ModifiedDate Date
);



CREATE TABLE ProductModelProductDescription
( 
  ProductModelID INT NOT NULL,
  ProductDescriptionID INT IDENTITY(1,1) PRIMARY KEY,
  Culture nvarchar(100), 
  rowguid nvarchar(100),
  ModifiedDate Date
);

SELECT name FROM SYS.OBJECTS WHERE type='U'

ALTER TABLE SalesOrderHeader
Alter COLUMN PurchaseOrderNumber nvarchar(100)

ALTER TABLE Product
Alter COLUMN ProductNumber nvarchar(100)

