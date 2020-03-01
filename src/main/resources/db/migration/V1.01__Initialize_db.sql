CREATE TABLE publisher (
	id INT unsigned NOT NULL AUTO_INCREMENT,
	name VARCHAR(65) NOT NULL,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	date TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
);

CREATE TABLE book (
	id INT unsigned NOT NULL AUTO_INCREMENT,
	publisher_id INT NOT NULL,
	code INT,
	title VARCHAR (256) NOT NULL,
	author VARCHAR(180) NOT NULL,
	year INT(4) NOT NULL,
	price DECIMAL,
	discount DOUBLE,
	stock INT NOT NULL DEFAULT '1',
	status ENUM ('AVAILABLE', 'NOT_AVAILABLE', 'PREORDER', 'OUT_OF_SALE'),
	PRIMARY KEY (id),
	FOREIGN KEY (publisher_id) REFERENCES publisher(id)
);

CREATE TABLE member (
   id INT unsigned NOT NULL AUTO_INCREMENT,
   username VARCHAR(50) NOT NULL,
   password VARCHAR(50) NOT NULL,
   email VARCHAR(180),
   firstname VARCHAR(50) NOT NULL,
   lastname VARCHAR (50) NOT NULL,
   address VARCHAR (180),
   phone VARCHAR (50),
   PRIMARY KEY (id)
);

CREATE TABLE member_order (
   id INT unsigned NOT NULL AUTO_INCREMENT,
   member_id INT NOT NULL,
   price DECIMAL,
   date TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (id),
   FOREIGN KEY (member_id) REFERENCES member(id)
);

CREATE TABLE member_order_detail (
    id INT unsigned NOT NULL AUTO_INCREMENT,
    member_order_id INT NOT NULL,
    book_id INT NOT NULL,
    quantity INT NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (member_order_id) REFERENCES member_order(id),
	FOREIGN KEY (book_id) REFERENCES book (id)

);