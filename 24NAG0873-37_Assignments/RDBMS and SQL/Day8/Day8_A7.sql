
-- INSERT statements for each table
-- Inserting a new book
INSERT INTO Books (BookID, Title, Author, ISBN, PublicationYear, Genre)
VALUES (1, 'The Great Gatsby', 'F. Scott Fitzgerald', '1234567890123', 1925, 'Classic');

-- Inserting a new member
INSERT INTO Members (MemberID, FirstName, LastName, Email, JoinDate)
VALUES (1, 'Jane', 'Doe', 'jane.doe@example.com', '2024-05-20');

-- Inserting a new loan
INSERT INTO Loans (LoanID, BookID, MemberID, LoanDate, DueDate)
VALUES (1, 1, 1, '2024-05-20', '2024-06-20');

-- Inserting a new copy
INSERT INTO Copies (CopyID, BookID, ShelfLocation, Status)
VALUES (1, 1, 'A1', 'Available');

-- UPDATE statements
-- Updating a member's email
UPDATE Members
SET Email = 'jane.d.newemail@example.com'
WHERE MemberID = 1;

-- Updating a book's genre
UPDATE Books
SET Genre = 'Classic Fiction'
WHERE BookID = 1;

-- DELETE statements
-- Deleting a loan record
DELETE FROM Loans
WHERE LoanID = 1;

-- BULK INSERT operation (syntax can vary depending on the SQL server being used)
-- Assuming we have a CSV file named 'books.csv' with the appropriate structure

BULK INSERT Books
FROM 'path_to_csv/books.csv'
WITH (
    FIELDTERMINATOR = ',',  -- CSV field delimiter
    ROWTERMINATOR = '\n',   -- CSV row delimiter
    FIRSTROW = 2            -- If the first row contains column headers
);