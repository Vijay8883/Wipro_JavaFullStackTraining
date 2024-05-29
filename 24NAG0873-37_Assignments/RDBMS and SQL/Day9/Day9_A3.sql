-- Subquery to Find Customers Above Average Order Value:
SELECT
       CustomerID,
       OrderID,
       OrderAmount
   FROM
       Orders
   WHERE
       OrderAmount > (
           SELECT AVG(OrderAmount)
           FROM Orders
       );
       
       -- UNION Query with Same Number of Columns:
       
    SELECT
       'Customer' AS Type,
       ContactName,
       City,
       Country
   FROM
       Customers
   UNION
   SELECT
       'Supplier',
       ContactName,
       City,
       Country
   FROM
       Suppliers;