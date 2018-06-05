DROP DATABASE IF EXISTS HotelReservation1;
CREATE DATABASE HotelReservation1;

USE HotelReservation1;

CREATE TABLE Floor
(
FloorNumberID INT NOT NULL auto_increment,
PRIMARY KEY(FloorNumberID)
);

CREATE TABLE RoomType
(
RoomTypeID INT NOT NULL auto_increment,
RoomType VARCHAR(15) NOT NULL,
PRIMARY KEY(RoomTypeID)
);

CREATE TABLE RoomRate
(
RoomRateID INT NOT NULL auto_increment,
RoomTypeID INT NOT NULL,
RoomRateBeginDate DATE NOT NULL,
RoomRateEndDate DATE,
RoomRate DECIMAL NOT NULL,
PRIMARY KEY(RoomRateID),
CONSTRAINT fk_RoomRate_RoomType
FOREIGN KEY(RoomTypeID) REFERENCES RoomType(RoomTypeID)
);


CREATE TABLE Amenity
(
AmenityID INT NOT NULL auto_increment,
Amenity VARCHAR(45) NOT NULL,
PRIMARY KEY(AmenityID)
);

CREATE TABLE Room
(
RoomNumberID INT NOT NULL,
RoomOccupancy INT NOT NULL,
FloorNumberID INT NOT NULL,
RoomTypeID INT NOT NULL,
PRIMARY KEY(RoomNumberID),
CONSTRAINT fk_Room_Floor 
FOREIGN KEY(FloorNumberID) REFERENCES `Floor` (FloorNumberID),
CONSTRAINT fk_Room_RoomType
fOREIGN KEY(RoomTypeID) REFERENCES RoomType(RoomTypeID)
);

 

CREATE TABLE RoomAmenity
(
RoomNumberID INT NOT NULL,
AmenityID INT NOT NULL,
PRIMARY KEY(RoomNumberID, AmenityID),
CONSTRAINT fk_RoomAmenity_Room
FOREIGN KEY(RoomNumberID) REFERENCES Room(RoomNumberID),
CONSTRAINT fk_RoomAmenity_Amenity
FOREIGN KEY(AmenityID) REFERENCES Amenity(AmenityID)
);

CREATE TABLE RegisteredContact
(
ContactID INT NOT NULL auto_increment,
ContactName VARCHAR(45) NOT NULL,
ContactAge INT NULL,
ContactPhone CHAR(12) NULL,
ContactEmail VARCHAR(45) NULL,
PRIMARY KEY(ContactID)
);


CREATE TABLE Guest
(
GuestID INT NOT NULL auto_increment,
ContactID INT NOT NULL,
PRIMARY KEY(GuestID),
CONSTRAINT fk_Guest_RegisteredContact
FOREIGN KEY(ContactID) REFERENCES RegisteredContact(ContactID)
);

CREATE TABLE Customer
(
CustomerID INT NOT NULL auto_increment,
ContactID INT NOT NULL,
PRIMARY KEY(CustomerID),
CONSTRAINT fk_Customer_RegisteredContact
FOREIGN KEY(ContactID) REFERENCES RegisteredContact(ContactID)
);




CREATE TABLE AddOn
(
AddOnID INT NOT NULL auto_increment,
AddOnType VARCHAR(45),
PRIMARY KEY(AddOnID)
);

CREATE TABLE AddOnPrice
(
AddOnPriceID INT NOT NULL auto_increment,
AddOnID INT NOT NULL,
AddOnBeginDate DATE NOT NULL,
AddOnEndDate DATE NOT NULL,
AddOnPrice DECIMAL NOT NULL,
PRIMARY KEY(AddOnPriceID),
CONSTRAINT fk_AddOnPrice_AddO
FOREIGN KEY(AddOnID) REFERENCES AddOn(AddOnID)
);

CREATE TABLE GuestAddOn
(
GuestID INT NOT NULL,
AddOnID INT NOT NULL,
PRIMARY KEY(GuestID, AddOnID),
CONSTRAINT fk_CustomerAddOn_Guest
FOREIGN KEY(GuestID) REFERENCES Guest(GuestID),
CONSTRAINT fk_GuestAddOn_AddOn
FOREIGN KEY(AddOnID) REFERENCES AddOn(AddOnID)
);

CREATE TABLE PromotionCode
(
PromotionCodeID INT NOT NULL auto_increment,
PromotionBeginDate DATE NOT NULL,
PromotionEndDate DATE NOT NULL,
PromotionDiscount DECIMAL NOT NULL,
PRIMARY KEY(PromotionCodeID)
);

CREATE TABLE Bill
(
BillID INT NOT NULL auto_increment,
PRIMARY KEY(BillID)
);

CREATE TABLE BillHeader
(
BillHeaderID INT NOT NULL auto_increment,
BillID INT NOT NULL,
BillTotal DECIMAL NOT NULL,
BillTax DECIMAL NOT NULL,
BillDiscount INT NULL,
BillGrandTotal DECIMAL NOT NULL,
PRIMARY KEY(BillHeaderID),
CONSTRAINT fk_BillHeader_Bill
FOREIGN KEY(BillID) REFERENCES Bill(BillID)
);

CREATE TABLE BillDetails
(
BillDetailsID INT NOT NULL auto_increment,
BillID INT NOT NULL,
ItemType VARCHAR(45) NOT NULL,
ItemPrice DECIMAL NOT NULL,
TotalItemPrice DECIMAL NOT NULL,
LengthOfStay INT NULL,
RoomNumber INT NULL,
PRIMARY KEY(BillDetailsID),
CONSTRAINT fk_BillDetails_Bill
FOREIGN KEY(BillID) REFERENCES Bill(BillID)
);




CREATE TABLE Reservation
(
ReservationID INT NOT NULL auto_increment,
CustomerID INT NOT NULL,
ArriveDate DATE NOT NULL,
DepartDate DATE NOT NULL,
PromotionCodeID INT NULL,
BillID INT NOT NULL,
PRIMARY KEY(ReservationID),
CONSTRAINT fk_Reservation_Customer
FOREIGN KEY(CustomerID) REFERENCES Customer(CustomerID),
CONSTRAINT fk_Reservation_PromotionCode
FOREIGN KEY(PromotionCodeID) REFERENCES PromotionCode(PromotionCodeID),
CONSTRAINT fk_Reservation_Bill
FOREIGN KEY(BillID) REFERENCES Bill(BillID)
);


CREATE TABLE RoomReservation
(
RoomNumberID INT NOT NULL,
ReservationID INT NOT NULL,
PRIMARY KEY(RoomNumberID, ReservationID),
CONSTRAINT fk_RoomReservation_Room
FOREIGN KEY(RoomNumberID) REFERENCES Room(RoomNumberID),
CONSTRAINT fk_RoomReservation_Reservation
FOREIGN KEY (ReservationID) REFERENCES Reservation(ReservationID)
);

ALTER TABLE Guest
Add ReservationID INT NOT NULL,
ADD CONSTRAINT fk_Guest_Reservation 
FOREIGN KEY(ReservationID) REFERENCES Reservation(ReservationID);


INSERT INTO Bill (BillID)
VALUES (1), (2), (3), (4), (5), (6);

INSERT INTO AddOn (AddOnType)
VALUES ('Movie Rental'), ('Pizza'), ('3D-Printer Usage');

INSERT INTO AddOnPrice(AddOnId, AddOnBeginDate, AddOnEndDate, AddOnPrice)
VALUES (1, '2017-01-01', '2019-01-01', 3.00), (2, '2017-01-01', '2019-01-01', 3.00), (3, '2018-01-01', '2020-12-31', 15.00), (3, '2021-01-01', '2022-12-31', 8.00);

INSERT INTO Amenity (Amenity)
VALUES ('Fridge'), ('Jacuzzi'), ('Fresh Flowers');

INSERT INTO RegisteredContact(ContactAge, ContactName, ContactPhone, ContactEmail)
VALUES  (12, 'Bill Thomas', '612-555-1234', null), (32, 'Sandra Louis', '952-555-4789', 'Sandra@ListeningHaus.com'), (19, 'Sarah Smith', '763-555-6325', 'SarahS@WritersBlock.com'),
 (48, 'Josh Jackua', '320-555-7896', 'jj@pi.com'), (67, 'Julie Jackson', '763-555-2345', null), (68, 'Brad Jackson', '312-222-4568', null), (80, 'Jackie Flynn', '612-555-5462', 'jf@smnmn.com');

-- Customer is the person purchasing on the reservation
INSERT INTO Customer (ContactID)
VALUES (2), (3), (4), (6), (7);

INSERT INTO Floor (FloorNumberID)
VALUES (1), (2), (3);

INSERT INTO PromotionCode (PromotionBeginDate, PromotionEndDate, PromotionDiscount)
VALUES ('2018-01-01', '2018-03-01', 25.00), ('2018-03-02', '2018-05-31', 15.00), ('2018-10-01', '2019-01-01', 20.00);

INSERT INTO Reservation (CustomerID, ArriveDate, DepartDate, PromotionCodeID, BillID)
VALUES (3, '2018-05-01', '2018-05-03', 2, 1), (1, '2018-06-21', '2018-06-24', null , 2), (2, '2018-06-21', '2018-06-24', null , 3), (4, '2018-10-28', '2018-11-01', 3, 4), (5, '2022-02-14', '2022-02-18', null, 5), (1, '2022-05-05', '2022-05-06', null, 6);

-- All customers are also guests
INSERT INTO Guest(ContactID, ReservationID)
VALUES (1, 1), (2, 2), (3, 3), (4, 1), (5, 4), (6, 4), (7, 5), (2, 6);

INSERT INTO GuestAddOn (GuestID, AddOnID)
VALUES (1, 2), (2, 3), (1, 1), (4, 3), (7, 3);


INSERT INTO RoomType (RoomType)
VALUES ('Single'), ('Double Queen'), ('Deluxe King'), ('Suite'), ('Extended Stay');

INSERT INTO Room (RoomNumberID, RoomOccupancy, FloorNumberID, RoomTypeID)
VALUES (101, 4, 1, 2), (106, 2, 1, 1), (221, 4, 2, 4), (307, 6, 3, 5), (313, 6, 3, 4), (102, 1, 1, 1), (389, 2, 3, 3);

INSERT INTO RoomReservation(RoomNumberID, ReservationID)
VALUES (101, 1), (106, 2), (221, 3), (307, 4), (313, 5), (101, 6), (102, 1);

INSERT INTO RoomAmenity (RoomNumberID, AmenityID)
VALUES (101, 3), (106, 2), (221, 3), (307, 3), (313, 1), (307, 1), (307, 2);

INSERT INTO RoomRate (RoomTypeID, RoomRateBeginDate, RoomRateEndDate, RoomRate)
VALUES (1,  '2018-01-01', '2019-12-31', 87.00), (1, '2020-01-01', null, 95.00), (2, '2018-01-01', '2019-12-31', 101.00), (3, '2018-01-01', '2019-12-31', 150.00), 
 (4, '2018-01-01', '2019-12-31', 1000.00),  (4, '2020-01-01', '2024-12-31', 2500.00), (5, '2018-01-01', '2019-12-31', 3000.00), (2, '2022-01-01', '2022-12-31', 135.00);



CREATE VIEW AddOnTotals
AS
SELECT b.BillID, ao.AddOnType, aop.AddOnPrice
FROM Bill AS b 
	INNER JOIN Reservation AS r ON b.BillID = r.BillID
	inner JOIN Guest AS g ON g.ReservationID = r.ReservationID
	INNER JOIN RegisteredContact AS rc ON g.ContactID = rc.ContactID
	INNER JOIN GuestAddOn AS gao ON gao.GuestID = g.GuestID
	INNER JOIN AddOn AS ao ON gao.AddOnID = ao.AddOnID
	INNER JOIN AddOnPrice AS aop ON aop.AddOnID = ao.AddOnID
WHERE r.arrivedate BETWEEN aop.addonbegindate AND aop.addonenddate;

CREATE VIEW RoomTotals
AS
SELECT b.BillID, room.RoomNumberID, rt.RoomType, rr.RoomRate, DATEDIFF(r.departdate, r.arrivedate) AS LengthOfStay
FROM Bill AS b 
	INNER JOIN Reservation AS r ON b.BillID = r.BillID
	INNER JOIN RoomReservation AS rres ON rres.ReservationID = r.ReservationID
	INNER JOIN Room ON rres.RoomNumberID = room.RoomNumberID
	INNER JOIN RoomType as rt ON rt.RoomTypeID = room.RoomTypeID
	INNER JOIN RoomRate as rr ON rt.RoomTypeID = rr.RoomTypeID
WHERE r.ArriveDate BETWEEN rr.RoomRateBeginDate AND rr.RoomRateEndDate ; 

CREATE VIEW HeaderTotals
AS
SELECT bd.BillID, SUM(bd.TotalItemPrice) AS ChargeTotal, SUM(bd.TotalItemPrice * .06) as Tax, SUM(IFNULL(pc.promotiondiscount,0)) AS Discount
From BillDetails as bd
	INNER JOIN Reservation as r ON bd.BillID = r.BillId
LEFT JOIN PromotionCode as pc ON pc.PromotionCodeID = r.PromotionCodeID
GROUP BY bd.BillID;



INSERT INTO BillDetails (BillID, ItemType, ItemPrice, TotalItemPrice)
SELECT BillID, AddOnType, AddOnPrice, AddOnPrice
FROM AddOnTotals ;

INSERT INTO BillDetails (BillID, RoomNumber, ItemType, ItemPrice, TotalItemPrice, LengthOfStay)
SELECT BillID, RoomNumberID, RoomType, RoomRate, SUM(RoomRate * LengthOfStay), LengthOfStay
FROM RoomTotals
GROUP BY RoomNumberID;

INSERT INTO BillHeader(BillID, BillTotal, BillTax, BillDiscount, BillGrandTotal)
SELECT BillID, ChargeTotal, Tax, Discount, SUM(ChargeTotal + Tax - Discount)
FROM HeaderTotals AS ht
GROUP BY BillID;


