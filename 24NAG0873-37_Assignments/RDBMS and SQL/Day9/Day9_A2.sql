-- INNER JOIN for Customers in a Specified Region:
 SELECT
       customers.CustomerID,
       customers.CustomerName,
       orders.OrderID,
       orders.OrderDate
   FROM
       customers
   INNER JOIN
       orders ON customers.CustomerID = orders.CustomerID
   WHERE
       customers.Region = 'YourSpecifiedRegion';
     
     
     -- LEFT JOIN to Display All Customers (Including Those Without Orders):
     
        SELECT
       customers.CustomerID,
       customers.CustomerName,
       orders.OrderID,
       orders.OrderDate
   FROM
       customers
   LEFT JOIN
       orders ON customers.CustomerID = orders.CustomerID;
       
       