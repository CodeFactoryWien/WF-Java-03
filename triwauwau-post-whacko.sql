-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 17, 2020 at 01:45 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `triwauwau`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
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
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categoryID` int(11) NOT NULL,
  `categoryName` varchar(55) NOT NULL,
  `categorySize` double NOT NULL,
  `categoryPrice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryID`, `categoryName`, `categorySize`, `categoryPrice`) VALUES
(1, 'Single Basic', 30, 30),
(2, 'Single Medium ', 50, 50),
(3, 'Single Deluxe', 80, 100),
(4, 'Double Basic', 50, 60),
(5, 'Double Medium', 60, 100),
(6, 'Double Deluxe', 100, 200),
(7, 'Family Basic', 60, 100),
(8, 'Family Medium', 80, 150),
(9, 'Family Deluxe', 120, 300);

-- --------------------------------------------------------

--
-- Table structure for table `date`
--

CREATE TABLE `date` (
  `dateID` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `fk_roomID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `hotelID` int(11) NOT NULL,
  `hotelName` varchar(55) NOT NULL,
  `hotelAdress` varchar(100) NOT NULL,
  `hotelPhone` varchar(55) NOT NULL,
  `hotelEmail` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`hotelID`, `hotelName`, `hotelAdress`, `hotelPhone`, `hotelEmail`) VALUES
(1, 'Dino Den', 'Jurassic Avenue 23, 1240, Edenview City', '+420 80085', 'roar.tyranno@extinct.org'),
(2, 'Fluffy Fluff', 'Furry Road 1, 2412, Furball Ville', '+666 333333', 'meow.peep@scratchy.net');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `loginID` int(11) NOT NULL,
  `loginName` varchar(55) NOT NULL,
  `loginPassword` varchar(55) NOT NULL,
  `fk_userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`loginID`, `loginName`, `loginPassword`, `fk_userID`) VALUES
(3, 'admin', 'admin', 1),
(4, 'user', 'user', 2);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `roomID` int(11) NOT NULL,
  `roomName` varchar(55) NOT NULL,
  `fk_categoryID` int(11) NOT NULL,
  `fk_hotelID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`roomID`, `roomName`, `fk_categoryID`, `fk_hotelID`) VALUES
(1, 'Tricera Suit', 1, 1),
(2, 'Rex Mex', 5, 1),
(3, 'Raptor Range', 9, 1),
(4, 'Hamster Home', 7, 2);

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `serviceID` int(11) NOT NULL,
  `serviceName` varchar(55) NOT NULL,
  `servicePrice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`serviceID`, `serviceName`, `servicePrice`) VALUES
(1, 'Breakfast', 10),
(2, 'Human-Cage', 15),
(3, 'Wellness-Package', 35);

-- --------------------------------------------------------

--
-- Table structure for table `user`
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
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `firstName`, `lastName`, `phone`, `email`, `payment`) VALUES
(1, 'Admin', 'Admin', '89289249824', 'admin@gmail.com', 'paypal'),
(2, 'Test', 'Hans', '0664 343424323', 'hans@gmail.com', 'visa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bookingID`),
  ADD KEY `fk_dateID` (`fk_dateID`),
  ADD KEY `fk_hotelID` (`fk_hotelID`),
  ADD KEY `fk_roomID` (`fk_roomID`),
  ADD KEY `fk_userID` (`fk_userID`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryID`);

--
-- Indexes for table `date`
--
ALTER TABLE `date`
  ADD PRIMARY KEY (`dateID`),
  ADD KEY `fk_roomID` (`fk_roomID`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`hotelID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`loginID`),
  ADD KEY `fk_userID` (`fk_userID`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`roomID`),
  ADD KEY `fk_hotelID` (`fk_hotelID`),
  ADD KEY `fk_categoryID` (`fk_categoryID`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`serviceID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `bookingID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `categoryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `date`
--
ALTER TABLE `date`
  MODIFY `dateID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `hotelID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `loginID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `roomID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `serviceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`fk_dateID`) REFERENCES `date` (`dateID`),
  ADD CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`fk_hotelID`) REFERENCES `hotel` (`hotelID`),
  ADD CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`fk_roomID`) REFERENCES `room` (`roomID`),
  ADD CONSTRAINT `booking_ibfk_4` FOREIGN KEY (`fk_userID`) REFERENCES `user` (`userID`);

--
-- Constraints for table `date`
--
ALTER TABLE `date`
  ADD CONSTRAINT `date_ibfk_1` FOREIGN KEY (`fk_roomID`) REFERENCES `room` (`roomID`);

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`fk_userID`) REFERENCES `user` (`userID`);

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`fk_hotelID`) REFERENCES `hotel` (`hotelID`),
  ADD CONSTRAINT `room_ibfk_2` FOREIGN KEY (`fk_categoryID`) REFERENCES `category` (`categoryID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
