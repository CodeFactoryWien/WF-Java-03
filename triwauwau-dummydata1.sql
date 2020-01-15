INSERT INTO `category` (`categoryID`, `categoryName`, `categoryPrice`) VALUES
(1, 'Basic', 30),
(2, 'Medium', 50),
(3, 'Deluxe', 100);

INSERT INTO `hotel` (`hotelID`, `hotelName`, `hotelAdress`, `hotelPhone`, `hotelEmail`) VALUES
(1, 'Dino Den', 'Jurassic Avenue 23, 1240, Edenview City', '+420 80085', 'roar.tyranno@extinct.org');

INSERT INTO `room` (`roomID`, `roomName`, `roomCapacity`, `roomSize`, `fk_categoryID`, `fk_hotelID`) VALUES
(1, 'Tricera Suit', 'Double', 'Large', 2, 1),
(2, 'Rex Mex', 'Herd', 'Large', 3, 1),
(3, 'Raptor Range', 'Pack', 'Large', 1, 1);

INSERT INTO `service` (`serviceID`, `serviceName`, `servicePrice`) VALUES
(1, 'Breakfast', 10),
(2, 'Human-Cage', 15),
(3, 'Wellness-Package', 35);

