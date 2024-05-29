-- creating database
CREATE DATABASE LibrarySystem;

-- using the database
USE LibrarySystem;
-- creating Books table
CREATE TABLE Books(BookID INT PRIMARY KEY,Ttitle VARCHAR(255) NOT NULL,Author VARCHAR(255) NOT NULL,ISBN VARCHAR(13) UNIQUE NOT NULL,PublicationYear YEAR,Genre VARCHAR(100),CHECK(PublicationYear>1800 AND PublicationYear<=YEAR(CURRENT_TIMESTAMP)));

-- creating Members table
CREATE TABLE Members(MemberID INT PRIMARY KEY,FirstLastName VARCHAR(255) NOT NULL,Email VARCHAR(255) UNIQUE NOT NULL,JoinDate DATE NOT NULL,CHECK(JoinDate<=CURRENT_DATE));

-- creating Loans table
CREATE TABLE Loans(LoanID INT PRIMARY KEY,BookID INT,MemberID INT,LoanDate DATE NOT NULL,DueDate DATE NOT NULL,ReturnDate DATE,FOREIGN KEY(BookID) REFERENCES Books(BookID),FOREIGN KEY(MemberID) REFERENCES Members(MemberID),CHECK(LoanDate<DueDate));

-- creating Copies table
CREATE TABLE Copies(CopyID INT PRIMARY KEY,BookID INT,ShelfLocation VARCHAR(255),Status ENUM('Available','Loaned','Maintenance','Lost') NOT NULL,FOREIGN KEY (BookID) REFERENCES Books(BookID));

