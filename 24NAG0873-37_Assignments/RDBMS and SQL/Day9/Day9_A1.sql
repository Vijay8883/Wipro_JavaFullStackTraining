-- Retrieve all columns for all customers
SELECT *
FROM customers;

-- Modify to return only customer name and email address for customers in a specific city (e.g., 'New York')
SELECT CustomerName, Email
FROM customers
WHERE City = 'New York';

