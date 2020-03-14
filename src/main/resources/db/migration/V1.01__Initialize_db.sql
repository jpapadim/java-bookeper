CREATE TABLE `publisher` (
	`id` INT unsigned NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(65) NOT NULL,
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	`date` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
);

CREATE TABLE `book` (
	`id` INT unsigned NOT NULL AUTO_INCREMENT,
	`publisher_id` INT unsigned NOT NULL,
	`code` INT unsigned,
	`title` VARCHAR (256) NOT NULL,
	`author` VARCHAR(180) NOT NULL,
	`year` INT(4) unsigned NOT NULL,
	`price` DECIMAL unsigned,
	`discount` DOUBLE,
	`stock` INT unsigned NOT NULL DEFAULT '1',
	`status` ENUM ('AVAILABLE', 'NOT_AVAILABLE', 'PREORDER', 'OUT_OF_SALE'),
	PRIMARY KEY (id),
	FOREIGN KEY (publisher_id) REFERENCES publisher(id)
);

CREATE TABLE `member` (
   `id` INT unsigned NOT NULL AUTO_INCREMENT,
   `username` VARCHAR(50) NOT NULL,
   `password` VARCHAR(50) NOT NULL,
   `email` VARCHAR(180),
   `firstname` VARCHAR(50) NOT NULL,
   `lastname` VARCHAR (50) NOT NULL,
   `address` VARCHAR (180),
   `phone` VARCHAR (50),
   PRIMARY KEY (id)
);

CREATE TABLE `member_order` (
   `id` INT unsigned NOT NULL AUTO_INCREMENT,
   `member_id` INT unsigned NOT NULL,
   `price` DECIMAL,
   `date` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (id),
   FOREIGN KEY (member_id) REFERENCES `member`(id)
);

CREATE TABLE `member_order_detail` (
    `id` INT unsigned NOT NULL AUTO_INCREMENT,
    `member_order_id` INT unsigned NOT NULL,
    `book_id` INT unsigned NOT NULL,
    `quantity` INT NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (member_order_id) REFERENCES `member_order`(id),
	FOREIGN KEY (book_id) REFERENCES `book` (id)

);