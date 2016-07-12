--Question1--
select * from Address where AddressID IN (SELECT AddressID from CustomerAddress join CustomerAW 
on CustomerAW.CustomerID = CustomerAddress.CustomerID 
where CompanyName = 'Modular Cycle Systems');

--Question2--
select * from SalesOrderHeader JOIN SalesOrderDetail 
on SalesOrderHeader.SalesOrderID=SalesOrderDetail.SalesOrderID Join ProductAW 
on SalesOrderDetail.ProductID=ProductAW.ProductID where SalesOrderHeader.CustomerID=29957;

--Question3--
select CompanyName from CustomerAW where CustomerID IN (SELECT CustomerID 
from CustomerAddress join Address on Address.AddressID = CustomerAddress.AddressID 
where City = 'Dallas');

--Question4--
select CompanyName from CustomerAW where CustomerID in( select CustomerID 
from SalesOrderHeader Group By CustomerID Having (Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight)>100000));

