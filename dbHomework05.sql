DROP DATABASE IF EXISTS store;
CREATE DATABASE store CHAR SET UTF8MB4;
USE store;

CREATE TABLE prod (
	prod_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    prod_name VARCHAR(255) NOT NULL UNIQUE,
    description varchar(255),
    price DECIMAL(9,2)
);

CREATE TABLE role(
	role_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO role(role_name)
VALUES('Administrator'),
	('Customer');

CREATE TABLE user(
	user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL UNIQUE,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);

INSERT INTO user(email, first_name, last_name, role_id, password)
VALUES('admin@magazines.ua', 'Admin', 'Admin', 1, '12345');

CREATE TABLE cart(
	cart_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    prod_id INT NOT NULL,
    price DECIMAL(9,2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (prod_id) REFERENCES prod(prod_id)
);

CREATE TABLE order_head(
	order_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    order_date TIMESTAMP NOT NULL,
    order_status VARCHAR(255),
    order_note VARCHAR(255),
    user_id INT NOT NULL,
    total_quantity DECIMAL(9,2) NOT NULL,
    total_sum DECIMAL(9,2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE order_details(
	order_det_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    prod_id INT NOT NULL,
    quantity DECIMAL(9,2) NOT NULL,
    price DECIMAL(9,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES order_head(order_id),
    FOREIGN KEY (prod_id) REFERENCES prod(prod_id)
);
