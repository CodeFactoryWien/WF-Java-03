-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 17. Jan 2020 um 11:29
-- Server-Version: 10.4.10-MariaDB
-- PHP-Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `triwauwau`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `booking`
--

CREATE TABLE `booking` (
  `bookingID` int(11) NOT NULL,
  `fk_userID` int(11) NOT NULL,
  `fk_roomID` int(11) NOT NULL,
  `fk_dateID` int(11) NOT NULL,
  `fk_hotelID` int(11) NOT NULL,
  `humanCage` tinyint(1) NOT NULL,
  `breakfast` tinyint(1) NOT NULL,
  `wellness` tinyint(1) NOT NULL,
  `priceSum` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `category`
--

CREATE TABLE `category` (
  `categoryID` int(11) NOT NULL,
  `categoryName` varchar(55) NOT NULL,
  `categorySize` double NOT NULL,
  `categoryPrice` double NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `category_price` double DEFAULT NULL,
  `room_size` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `category`
--

INSERT INTO `category` (`categoryID`, `categoryName`, `categorySize`, `categoryPrice`, `category_name`, `category_price`, `room_size`) VALUES
(1, 'Single Basic', 30, 30, NULL, NULL, NULL),
(2, 'Single Medium ', 50, 50, NULL, NULL, NULL),
(3, 'Single Deluxe', 80, 100, NULL, NULL, NULL),
(4, 'Double Basic', 50, 60, NULL, NULL, NULL),
(5, 'Double Medium', 60, 100, NULL, NULL, NULL),
(6, 'Double Deluxe', 100, 200, NULL, NULL, NULL),
(7, 'Family Basic', 60, 100, NULL, NULL, NULL),
(8, 'Family Medium', 80, 150, NULL, NULL, NULL),
(9, 'Family Deluxe', 120, 300, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `date`
--

CREATE TABLE `date` (
  `dateID` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `fk_roomID` int(11) NOT NULL,
  `datelid` int(11) NOT NULL,
  `fk_room_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `hotel`
--

CREATE TABLE `hotel` (
  `hotelID` int(11) NOT NULL,
  `hotelName` varchar(55) NOT NULL,
  `hotelAdress` varchar(100) NOT NULL,
  `hotelPhone` varchar(55) NOT NULL,
  `hotelEmail` varchar(55) NOT NULL,
  `hoteladdress` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `hotel`
--

INSERT INTO `hotel` (`hotelID`, `hotelName`, `hotelAdress`, `hotelPhone`, `hotelEmail`, `hoteladdress`) VALUES
(1, 'Dino Den', 'Jurassic Avenue 23, 1240, Edenview City', '+420 80085', 'roar.tyranno@extinct.org', NULL),
(2, 'Fluffy Fluff', 'Furry Road 1, 2412, Furball Ville', '+666 333333', 'meow.peep@scratchy.net', NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `login`
--

CREATE TABLE `login` (
  `loginID` int(11) NOT NULL,
  `loginName` varchar(55) NOT NULL,
  `loginPassword` varchar(55) NOT NULL,
  `fk_userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `login`
--

INSERT INTO `login` (`loginID`, `loginName`, `loginPassword`, `fk_userID`) VALUES
(3, 'admin', 'admin', 1),
(4, 'user', 'user', 2);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `room`
--

CREATE TABLE `room` (
  `roomID` int(11) NOT NULL,
  `roomName` varchar(55) NOT NULL,
  `fk_categoryID` int(11) NOT NULL,
  `fk_hotelID` int(11) NOT NULL,
  `room_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `room`
--

INSERT INTO `room` (`roomID`, `roomName`, `fk_categoryID`, `fk_hotelID`, `room_name`) VALUES
(1, 'Tricera Suit', 1, 1, NULL),
(2, 'Rex Mex', 5, 1, NULL),
(3, 'Raptor Range', 9, 1, NULL),
(4, 'Hamster Home', 7, 2, NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `service`
--

CREATE TABLE `service` (
  `serviceID` int(11) NOT NULL,
  `serviceName` varchar(55) NOT NULL,
  `servicePrice` double NOT NULL,
  `service_price` double DEFAULT NULL,
  `service_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `service`
--

INSERT INTO `service` (`serviceID`, `serviceName`, `servicePrice`, `service_price`, `service_name`) VALUES
(1, 'Breakfast', 10, NULL, NULL),
(2, 'Human-Cage', 15, NULL, NULL),
(3, 'Wellness-Package', 35, NULL, NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `userID` int(11) NOT NULL,
  `firstName` varchar(55) NOT NULL,
  `lastName` varchar(55) NOT NULL,
  `phone` varchar(55) NOT NULL,
  `email` varchar(55) NOT NULL,
  `payment` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`userID`, `firstName`, `lastName`, `phone`, `email`, `payment`) VALUES
(1, 'Admin', 'Admin', '89289249824', 'admin@gmail.com', 'paypal'),
(2, 'Test', 'Hans', '0664 343424323', 'hans@gmail.com', 'visa');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bookingID`),
  ADD KEY `fk_dateID` (`fk_dateID`),
  ADD KEY `fk_hotelID` (`fk_hotelID`),
  ADD KEY `fk_roomID` (`fk_roomID`),
  ADD KEY `fk_userID` (`fk_userID`);

--
-- Indizes für die Tabelle `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryID`);

--
-- Indizes für die Tabelle `date`
--
ALTER TABLE `date`
  ADD PRIMARY KEY (`dateID`),
  ADD KEY `fk_roomID` (`fk_roomID`);

--
-- Indizes für die Tabelle `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`hotelID`);

--
-- Indizes für die Tabelle `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`loginID`),
  ADD KEY `fk_userID` (`fk_userID`);

--
-- Indizes für die Tabelle `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`roomID`),
  ADD KEY `fk_hotelID` (`fk_hotelID`),
  ADD KEY `fk_categoryID` (`fk_categoryID`);

--
-- Indizes für die Tabelle `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`serviceID`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `booking`
--
ALTER TABLE `booking`
  MODIFY `bookingID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `category`
--
ALTER TABLE `category`
  MODIFY `categoryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT für Tabelle `date`
--
ALTER TABLE `date`
  MODIFY `dateID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `hotel`
--
ALTER TABLE `hotel`
  MODIFY `hotelID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `login`
--
ALTER TABLE `login`
  MODIFY `loginID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT für Tabelle `room`
--
ALTER TABLE `room`
  MODIFY `roomID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT für Tabelle `service`
--
ALTER TABLE `service`
  MODIFY `serviceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`fk_dateID`) REFERENCES `date` (`dateID`),
  ADD CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`fk_hotelID`) REFERENCES `hotel` (`hotelID`),
  ADD CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`fk_roomID`) REFERENCES `room` (`roomID`),
  ADD CONSTRAINT `booking_ibfk_4` FOREIGN KEY (`fk_userID`) REFERENCES `user` (`userID`);

--
-- Constraints der Tabelle `date`
--
ALTER TABLE `date`
  ADD CONSTRAINT `date_ibfk_1` FOREIGN KEY (`fk_roomID`) REFERENCES `room` (`roomID`);

--
-- Constraints der Tabelle `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`fk_userID`) REFERENCES `user` (`userID`);

--
-- Constraints der Tabelle `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`fk_hotelID`) REFERENCES `hotel` (`hotelID`),
  ADD CONSTRAINT `room_ibfk_2` FOREIGN KEY (`fk_categoryID`) REFERENCES `category` (`categoryID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
