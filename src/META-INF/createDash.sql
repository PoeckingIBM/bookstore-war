CREATE TABLE USERS (ID INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL, EMAIL VARCHAR(255) NOT NULL, PASSWORD VARCHAR(255) NOT NULL, PRIMARY KEY (ID)) ORGANIZE BY ROW
CREATE TABLE BOOKS (ID INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL, TITLE VARCHAR(255) NOT NULL, OWNER_ID INTEGER, PRIMARY KEY (ID)) ORGANIZE BY ROW
ALTER TABLE BOOKS ADD CONSTRAINT FK_BOOKS_OWNER_ID FOREIGN KEY (OWNER_ID) REFERENCES USERS (ID)
