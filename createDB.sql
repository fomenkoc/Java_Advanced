DROP DATABASE IF EXISTS Store;
CREATE DATABASE Store CHAR SET UTF8MB4;
USE Store;

CREATE TABLE r_Prods (
	ProdID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ProdName VARCHAR(255) NOT NULL UNIQUE,
    UM VARCHAR(255) NOT NULL
);

CREATE TABLE r_ProdBarCodes(
	ProdID INT NOT NULL,
    BarCode VARCHAR(50)  NOT NULL PRIMARY KEY,
    FOREIGN KEY (ProdID) REFERENCES r_Prods(ProdID)
);

CREATE TABLE r_PriceLists(
	PLID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    PLName VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE r_ProdPrice(
	ProdID INT NOT NULL,
    PLID INT NOT NULL,
    Price DECIMAL(21,9),
    PRIMARY KEY (ProdID, PLID),
    FOREIGN KEY (ProdID) REFERENCES r_Prods(ProdID),
    FOREIGN KEY (PLID) REFERENCES r_PriceLists(PLID)
);

CREATE TABLE r_Users(
	UserID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UserName VARCHAR(255) NOT NULL UNIQUE, 
    Email VARCHAR(255) NOT NULL UNIQUE,
    IsAdmin BIT NOT NULL DEFAULT(FALSE),
    Password VARCHAR(255) NOT NULL
);

INSERT INTO r_Users(UserName, Email, IsAdmin, Password)
VALUES('Admin', 'admin@magazines.ua', true, '12345');