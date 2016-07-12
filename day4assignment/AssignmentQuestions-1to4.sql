--Q1
select * from Address where AddressID IN (SELECT AddressID from CustomerAddress join CustomerAW on CustomerAW.CustomerID = CustomerAddress.CustomerID where CompanyName = 'Modular Cycle Systems');

select * from CustomerAW where CompanyName='Modular Cycle Systems';
--Q2
select SalesOrderDetail.OrderQty, ProductAW.Name,ProductAW.ListPrice from
SalesOrderDetail inner join ProductAW ON SalesOrderDetail.ProductID = ProductAW.ProductID
inner join SalesOrderHeader ON SalesOrderDetail.SalesOrderID = SalesOrderHeader.SalesOrderID
where SalesOrderHeader.CustomerID = 635;

--Q3
select  CompanyName from CustomerAW Join CustomerAddress on(CustomerAW.CustomerID=CustomerAddress.CustomerID) where 
AddressID in(select AddressID from Address where City='Dallas')
--Q4
select CompanyName from CustomerAW where CustomerID in( select CustomerID from SalesOrderHeader Group By CustomerID Having 
(Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight)>100000));