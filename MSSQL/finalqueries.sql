
 
select * from Address where AddressID in (select AddressID from customerAddress,CustomerAW where customerAddress.customerID=CustomerAW.customerID and CompanyName='Modular Cycle Systems');

select * from SalesOrderHeader JOIN SalesOrderDetail on SalesOrderHeader.SalesOrderID=SalesOrderDetail.SalesOrderID Join ProductAW on SalesOrderDetail.ProductID=ProductAW.ProductID where SalesOrderHeader.CustomerID=29660;

select  CompanyName from CustomerAW Join CustomerAddress on(CustomerAW.CustomerID=CustomerAddress.CustomerID) where AddressID in(select AddressID from Address where City='Dallas')

select CompanyName from CustomerAW where CustomerID in( select CustomerID from SalesOrderHeader Group By CustomerID Having (Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight)>100));


select * from SalesOrderHeader
