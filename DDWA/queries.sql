USE HotelReservation1;

-- Available rooms and prices
SELECT r.RoomNumberID, r.RoomOccupancy, r.FloorNumberID, rt.RoomType, rr.RoomRate, a.Amenity, rr.RoomRateBeginDate, rr.RoomRateEndDate
FROM Room AS r 
	INNER JOIN RoomType AS rt ON r.RoomTypeID = rt.RoomTypeID
	INNER JOIN RoomRate AS rr ON rr.RoomTypeID = rt.RoomTypeID
	LEFT JOIN RoomAmenity AS ra ON ra.RoomNumberID = r.RoomNumberID
	LEFT JOIN Amenity AS a ON a.AmenityID = ra.AmenityID
ORDER BY r.RoomNumberID;

-- Customer reservations, guests and dates
SELECT rc1.ContactName AS CustomerName, r.ReservationID, r.ArriveDate, rc2.ContactName AS GuestName, rc2.ContactAge AS GuestAge
FROM Reservation AS r
	INNER JOIN Customer AS c ON r.CustomerID = c.CustomerID
	INNER JOIN RegisteredContact AS rc1 ON c.ContactID = rc1.ContactID
	INNER JOIN Guest AS g ON r.ReservationID = g.ReservationID
	INNER JOIN RegisteredContact AS rc2 ON g.ContactID = rc2.ContactID
ORDER BY r.ReservationID;

-- Customer's Room Bill
SELECT bd.BillID,  rres.RoomNumberID, bd.ItemType, bd.ItemPrice, bd.LengthOfStay,  rc.ContactName AS CustomerName, rc.ContactPhone AS Phone, rc.ContactEmail AS Email
FROM BillDetails AS bd
	INNER JOIN Reservation AS r ON r.BillID = bd.BillID
	INNER JOIN RoomReservation AS rres ON r.ReservationID = rres.ReservationID
    INNER JOIN Room ON room.RoomNumberID = rres.RoomNumberID
    INNER JOIN RoomType AS rt ON room.RoomTypeID = rt.RoomTypeID AND rt.RoomType = bd.ItemType
    INNER JOIN Customer AS c ON r.CustomerID = c.CustomerID
    INNER JOIN RegisteredContact AS rc ON c.ContactID = rc.ContactID
    
ORDER BY bd.BillID;


-- Reservation AddOn Charges
SELECT b.BillID, r.ReservationID, rc.ContactName AS Guest, rc.ContactAge AS GuestAge, ao.AddOnType, aop.AddOnPrice
 FROM Bill AS b
 INNER JOIN Reservation AS r ON b.BillID = r.BillID
 INNER JOIN Guest AS g ON g.ReservationID = r.ReservationID
 INNER JOIN GuestAddOn AS gao ON gao.GuestID = g.GuestID
 INNER JOIN AddOn AS ao ON gao.AddOnID = ao.AddOnID
 INNER JOIN RegisteredContact AS rc ON g.ContactID = rc.ContactID
INNER JOIN AddOnPrice AS aop ON aop.AddOnID = ao.AddOnID
WHERE r.ArriveDate BETWEEN aop.AddOnBeginDate AND aop.AddOnEndDate
ORDER BY b.BillID;

-- Customer Bill Summary
SELECT bh.BillID, r.ReservationID, rc.ContactName AS Customer, bh.BillTotal, bh.BillTax, bh.BillDiscount, bh.BillGrandTotal
FROM BillHeader AS bh
INNER JOIN Reservation AS r ON bh.BillID = r.BillID
INNER JOIN Customer AS c ON r.CustomerID = c.CustomerID
INNER JOIN RegisteredContact AS rc ON c.ContactID = rc.ContactID
ORDER BY BillID;

-- Bill Details Information
SELECT * FROM BillDetails
ORDER BY BillID;
