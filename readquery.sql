use First1Database;
SELECT CompanyName,AddressType,AddressLine1,AddressLine2,StateProvince, CountryRegion,PostalCode
  FROM CustomerAW JOIN CustomerAddress
    ON (CustomerAW.CustomerID=CustomerAddress.CustomerID)
                  JOIN Address
    ON (CustomerAddress.AddressID=Address.AddressID)
 WHERE CompanyName='Modular Cycle Systems'


SELECT ProductAW.ListPrice,ProductAW.Name, SalesOrderDetail.OrderQty
FROM ProductAW INNER JOIN SalesOrderDetail 
  ON (ProductAW.ProductID=SalesOrderDetail.ProductID) 
              INNER JOIN  SalesOrderHeader 
  ON (SalesOrderHeader.​SalesOrderID=SalesOrderDetail​.SalesOrderID)
WHERE SalesOrderHeader.CustomerID=635;

SELECT CompanyName 
FROM CustomerAW INNER JOIN CustomerAddress 
  ON (CustomerAW.CustomerID=CustomerAddress.CustomerID) 
              INNER JOIN  Address 
  ON (Address.AddressID=CustomerAddress​.AddressID)
WHERE Address.City='Dallas';

select CompanyName
from CustomerAW 
where CustomerID in(   select CustomerID
                        from SalesOrderHeader 
						Group By CustomerID 
						Having (Sum(SubTotal)+Sum(TaxAmt)+Sum(Freight)>100000)
					);   
     