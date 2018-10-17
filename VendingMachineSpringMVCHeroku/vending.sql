DROP DATABASE IF EXISTS vending;

CREATE DATABASE vending;

USE vending;

CREATE TABLE item (
itemid INT NOT NULL auto_increment,
itemname VARCHAR(15) NOT NULL,
amount int not null,
price decimal(5, 2) not null,
primary key(itemid)
);

INSERT INTO item (itemname, amount, price)
VALUES ('Shoelaces', 14, 3.00), ('Bobblehead', 4, 2.50), ('Sparkle Sticker', 11, .49),
('Pony', 2, 1.75), ('Movie Stub', 0, 1.85), ('Nightmare Foxy', 3, 1.95),
('Lint Roller', 9, 1.25), ('Virtual Apple', 9, 2.10), ('Portal Gun', 5, 1.25);