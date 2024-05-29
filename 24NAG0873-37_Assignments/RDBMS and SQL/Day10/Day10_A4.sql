/* create a new database user with specific privileges using the CREATE USER and GRANT .
Then,write a script to REVOKE certain previleges and DROP the user.*/
SELECT USER,HOST FROM MYSQL.USER;
-- creating user
CREATE USER 'jayvi'@'localhost' IDENTIFIED BY "vijay@000";
-- granting privileges to user
GRANT select,insert,update ON mywiproproject.* TO 'jayvi'@'localhost';
-- revoking privileges from user
revoke select ON mywiproproject.* from 'jayvi'@'localhost';
-- dropping the user from user list
DROP USER 'jayvi'@'localhost';
