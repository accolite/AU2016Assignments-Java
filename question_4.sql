
select CompanyName from CustomerAW where CustomerID in( select CustomerID from SalesOrderHeader Group By CustomerID Having (Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight)>100000));