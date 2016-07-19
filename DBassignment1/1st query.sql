--1
SELECT myg.CompanyName,yg.AddressType,g.AddressLine1
  FROM dbo.Customer as myg JOIN dbo.CustomerAddress as yg
    ON (myg.CustomerID=yg.CustomerID)
                  JOIN Person.Address as g
    ON (yg.AddressID=g.AddressID)
 WHERE myg.CompanyName='Modular Cycle Systems';

select * from dbo.Customer where CompanyName='Modular Cycle Systems'
select * from dbo.CustomerAddress where CustomerID IN ('4','29772')
