USE [Assignment5]
SELECT ddd.CompanyName,dd.AddressType,d.AddressLine1
  FROM Person.Customer as ddd JOIN dbo.CustomerAddress as dd
    ON (ddd.CustomerID=dd.CustomerID)
                  JOIN Person.Address as d
    ON (dd.AddressID=d.AddressID)
 WHERE ddd.CompanyName='Modular Cycle Systems';

