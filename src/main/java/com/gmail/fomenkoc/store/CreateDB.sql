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
    IsAdmin BIT NOT NULL DEFAULT(FALSE)
);

INSERT INTO r_PriceLists(PLName)
VALUES
	('Роздрібний прайс'),
	('Річна підписка');

INSERT INTO r_Prods(ProdName, UM)
VALUES 
	('Цигарки Winston Blue', 'шт'),
	('Цигарки Winston Blue Super Slims', 'шт'),
	('Цигарки Winston Caster+', 'шт'),
	('Цигарки Winston Classic', 'шт'),
	('Цигарки Winston Expand Duo', 'шт'),
	('Цигарки Winston Fresh Menthol Super Slims', 'шт'),
	('Цигарки Winston Silver', 'шт'),
	('Цигарки Winston Silver Super Slims', 'шт'),
	('Цигарки Winston White', 'шт'),
	('Цигарки Winston White Super Slims', 'шт'),
	('Цигарки Winston XS Blue', 'шт'),
	('Цигарки Winston XS Impulse', 'шт'),
	('Цигарки Winston XS Silver', 'шт'),
	('Цигарки Winston XSpression Fresh', 'шт'),
	('Цигарки Winston XSpression Shiny Mix', 'шт'),
	('Цигарки Winston XSpression Sparkling Mix', 'шт'),
	('Цигарки Winston XSpression Summer Mix', 'шт'),
	('Цигарки Winston XStyle Caster', 'шт'),
	('Цигарки Winston XStyle DUO Green', 'шт');

INSERT INTO r_ProdBarCodes(ProdID, BarCode)
VALUES
	(1, '1111111111111'),
    (2, '2222222222222'),
    (3, '3333333333333');
    
    
