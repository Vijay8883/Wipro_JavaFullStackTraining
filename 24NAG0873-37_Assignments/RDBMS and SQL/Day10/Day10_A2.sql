
/*1. *Begin the transaction:*/

   BEGIN TRANSACTION;
   

/*2. *Perform a series of INSERTs into 'orders'* (you can replace the placeholders with actual data):*/
   
   -- Insert order 1
   INSERT INTO orders (OrderID, CustomerID, OrderDate)
   VALUES (1, 101, '2024-05-20');

   -- Insert order 2
   INSERT INTO orders (OrderID, CustomerID, OrderDate)
   VALUES (2, 102, '2024-05-21');

   -- Insert order 3
   INSERT INTO orders (OrderID, CustomerID, OrderDate)
   VALUES (3, 103, '2024-05-22');
   
/*3. *Set a SAVEPOINT after each INSERT:*/
   
   SAVEPOINT savepoint1;
   SAVEPOINT savepoint2;
   

/*4. *Rollback to the second SAVEPOINT* (undoing the third INSERT):*/
   
   ROLLBACK TO savepoint2;
   

/*5. *Commit the overall transaction* (if everything is correct):*/

   COMMIT;
   