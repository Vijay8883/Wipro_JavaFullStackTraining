 /*BEGIN Transaction:*/
 BEGIN;
 /*INSERT New Record into 'orders' Table:*/
 INSERT INTO orders (OrderID, CustomerID, OrderDate)
   VALUES (12345, 'CustomerXYZ', '2024-05-21');

/*COMMIT the Transaction:*/
COMMIT;
/*UPDATE the 'products' Table:*/
 UPDATE products
   SET Price = 49.99
   WHERE ProductID = 1001;
   
/*ROLLBACK the Transaction (if needed):*/
   ROLLBACK;