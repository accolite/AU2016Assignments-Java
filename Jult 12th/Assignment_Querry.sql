use[Assignment]

SELECT CompanyName,AddressType,AddressLine1
  FROM SalesLT.Customer caw JOIN SalesLT.CustomerAddress ca
     ON (caw.CustomerID=ca.CustomerID)
    JOIN SalesLT.Address ad
    ON (ca.AddressID=ad.AddressID)
 WHERE CompanyName='Modular Cycle Systems';


SELECT OrderQty,Name,ListPrice
  FROM SalesLT.SalesOrderHeader soh join SalesLT.SalesOrderDetail sod
  on soh.SalesOrderID=sod.SalesOrderID 
  JOIN SalesLT.Product p
  on p.ProductID = sod.ProductID
WHERE soh.CustomerID=635;


SELECT CompanyName 
FROM SalesLT.Customer caw join SalesLT.CustomerAddress ca 
ON  caw.CustomerID=ca.CustomerID
JOIN SalesLT.Address ad
    ON (ca.AddressID=ad.AddressID)
	where ad.city like 'Dallas';



select CompanyName from SalesLT.Customer
where CustomerID in (select caw.CustomerID
	FROM SalesLT.Customer caw join SalesLT.SalesOrderHeader soh
 ON  caw.CustomerID=soh.CustomerID where (soh.SubTotal+soh.TaxAmt+soh.Freight) >10000)




