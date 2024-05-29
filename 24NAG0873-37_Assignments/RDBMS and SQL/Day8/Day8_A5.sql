USE LibrarySystem;

-- Create an index on the 'Email' column of the 'Members' table
CREATE INDEX idx_email ON Members(Email);

-- Drop the index 'idx_email' from the 'Members' table
DROP INDEX idx_email ON Members;