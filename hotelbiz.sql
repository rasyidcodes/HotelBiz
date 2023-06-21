-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2023 at 06:43 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotelbiz`
--

-- --------------------------------------------------------

--
-- Table structure for table `deluxeroom`
--

CREATE TABLE `deluxeroom` (
  `id` int(11) NOT NULL,
  `roomtype_id` int(11) NOT NULL,
  `roomNumber` int(11) NOT NULL,
  `availability` tinyint(1) NOT NULL,
  `freeSnack` tinyint(1) NOT NULL,
  `wifi` tinyint(1) NOT NULL,
  `television` tinyint(1) NOT NULL,
  `fitnessCenter` tinyint(1) NOT NULL,
  `minibar` tinyint(1) NOT NULL,
  `inRoomBreakfastService` tinyint(1) NOT NULL,
  `laundry` tinyint(1) NOT NULL,
  `dailyHouseKeeping` tinyint(1) NOT NULL,
  `privateSwimming` tinyint(1) NOT NULL,
  `luxuryBathub` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `deluxeroom`
--

INSERT INTO `deluxeroom` (`id`, `roomtype_id`, `roomNumber`, `availability`, `freeSnack`, `wifi`, `television`, `fitnessCenter`, `minibar`, `inRoomBreakfastService`, `laundry`, `dailyHouseKeeping`, `privateSwimming`, `luxuryBathub`) VALUES
(1, 3, 301, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(2, 3, 302, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(3, 3, 303, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(4, 3, 307, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(5, 3, 308, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(6, 3, 309, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(7, 3, 310, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(8, 3, 311, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(9, 3, 312, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(10, 3, 313, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(11, 3, 314, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(12, 3, 315, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(13, 3, 316, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(14, 3, 317, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(15, 3, 318, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(16, 3, 319, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullName` varchar(255) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `accessLevel` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `username`, `password`, `email`, `fullName`, `dateOfBirth`, `gender`, `salary`, `accessLevel`) VALUES
(1, 'admin', '123', 'admin@gmail.com', 'adminku', '2023-05-31', 'L', '99999999.99', 1),
(2, 'amaam', '899', 'ras@gmail.com', 'rass', '2023-06-07', 'L', '99999999.99', 1),
(3, 'jajajja', 'jaja', 'ahaha@gmail.com', 'ksksk', '2021-01-01', 'L', '9000000.00', 1),
(4, 'rasyid', '123', 'rasyid@gmail.com', 'ras', '2021-01-01', 'P', '9000.00', 1),
(5, 'rassx', 'aaa', 'aja@gmail.com', 'rkid', '2021-01-01', 'L', '9000.00', 1),
(6, 'adminkeos', '123', 'adminkeos@gmail.com', 'adddm', '2021-01-01', 'L', '90000.00', 1),
(7, 'admin2', 'admin2', 'admin2@gmail.com', 'adminadmin', '2021-01-01', 'L', '9000.00', 1),
(8, 'admin10', 'admin10', 'admin10@gmail.com', 'admin10', '2002-01-01', 'L', '1000.00', 1),
(9, 'admin8', 'admin8', 'admin8@gmail.com', 'admin8', '2001-01-01', 'L', '8000.00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE `guest` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullName` varchar(255) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `NIK` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `guestType` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `guest`
--

INSERT INTO `guest` (`id`, `username`, `password`, `email`, `fullName`, `dateOfBirth`, `gender`, `NIK`, `address`, `age`, `phoneNumber`, `country`, `city`, `guestType`) VALUES
(1, 'rasyid', '123', 'rasyid@gmail.com', 'Rasyid Kusnady', '2023-05-31', 'L', '8271938721321838', 'kalirase', 18, '213213', 'Indonesia', 'sleman', 'Pelancong'),
(2, 'hehe', '123', 'hehe@gmail.com', 'jahahah', '2023-05-24', 'L', '8324799832', 'asdkjhkjasdh', 8976, '918811', 'asdnbasdjn', 'asndbbasd', 'sadbjkasd'),
(3, 'test', 'test', 'ts', 'sad', '0000-00-00', 'asdas', 'asfd', 'dsfsd22', 2, '333', 'ads', 'asdads', 'ads'),
(4, 'username', 'pass', 'email', 'fullName', '2023-05-24', 'gender', 'NIK', 'address', 12, 'phoneNumber', 'country', 'city', 'guestType'),
(5, 'username', 'pass', 'email', 'fullName', '2023-05-24', 'gender', 'NIK', 'address', 12, 'phoneNumber', 'country', 'city', 'guestType'),
(6, 'username', 'pass', 'email', 'fullName', '2023-05-24', 'gender', 'NIK', 'address', 12, 'phoneNumber', 'country', 'city', 'guestType'),
(7, 'username', 'pass', 'email', 'fullName', '2023-05-24', 'gender', 'NIK', 'address', 12, 'phoneNumber', 'country', 'city', 'guestType'),
(8, 'username', 'pass', 'email', 'fullName', '2023-05-24', 'gender', 'NIK', 'address', 12, 'phoneNumber', 'country', 'city', 'guestType'),
(9, 'username', 'pass', 'email', 'fullName', '2023-05-24', 'gender', 'NIK', 'address', 12, 'phoneNumber', 'country', 'city', 'guestType'),
(10, 'username', 'pass', 'email', 'fullName', '2023-05-24', 'gender', 'NIK', 'address', 12, 'phoneNumber', 'country', 'city', 'guestType'),
(11, 'haha', '123', 'haha@gmail.com', 'cac', '2023-05-24', 'L', '91901', 'kalirase', 12, '1323', '32', '23', '2'),
(12, 'raaa', '123', 'raa@h.com', 'asiop', '2023-05-01', 'L', '90', 'kakak', 12, '191919991', 'INDO', 'nid', 'pelacong'),
(13, 'rrrra', '1212', 'a@gmail.com', 'ras', '2023-06-01', 'L', 'ksmldsm', 'sleman', 12, '9892398', 'INDO', '22', 'Pelancong'),
(14, 'samlnsa', 'kansddkj', 'kjasnk@a.com', 'kjn', '2021-08-01', 'jk', 'n', 'lkn', 12, 'l', 'nlk', 'nlk', 'knm'),
(15, 'coba1', 'coba1', 'coba1@gmail.com', 'coba1hehhe', '2021-01-01', 'L', '97979797', 'sleman', 12, '9888999', 'Indonesia', 'Sleman', 'Pelancong'),
(16, 'coba88', 'coba88', 'coba88@gmail.com', 'coba88xxx', '2021-01-01', 'L', '98999', 'sleman', 12, '9888889', 'indo', 'sleman', 'pelancong'),
(17, 'rasyid2', 'rasyid2', 'rasyidmail@gmail.com', 'rasyid', '2021-01-01', 'L', '88998', 'Sleman', 12, '9789888', 'Indonesia', 'Sleman', 'Pengunjung'),
(18, 'user10', 'user10', 'user10@gmail.com', 'user10', '2004-01-01', 'L', '9393839989', 'sleman', 12, '030339', 'indonesia', 'sleman', 'pengunjung'),
(19, 'user88', 'user88', 'user88@gmail.com', 'user88', '2008-01-01', 'L', '9393899', 'sleman', 12, '81191919', 'indonesia', 'sleman', 'pengunjung');

-- --------------------------------------------------------

--
-- Table structure for table `premiumroom`
--

CREATE TABLE `premiumroom` (
  `id` int(11) NOT NULL,
  `roomtype_id` int(11) NOT NULL,
  `roomNumber` int(11) NOT NULL,
  `availability` tinyint(1) NOT NULL,
  `freeSnack` tinyint(1) NOT NULL,
  `wifi` tinyint(1) NOT NULL,
  `television` tinyint(1) NOT NULL,
  `fitnessCenter` tinyint(1) NOT NULL,
  `minibar` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `premiumroom`
--

INSERT INTO `premiumroom` (`id`, `roomtype_id`, `roomNumber`, `availability`, `freeSnack`, `wifi`, `television`, `fitnessCenter`, `minibar`) VALUES
(1, 2, 201, 0, 1, 1, 1, 1, 1),
(2, 2, 202, 1, 1, 1, 1, 1, 1),
(3, 2, 203, 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reservationmenu`
--

CREATE TABLE `reservationmenu` (
  `custName` varchar(20) NOT NULL,
  `custAddr` varchar(20) NOT NULL,
  `Phone` bigint(10) NOT NULL,
  `Meal` varchar(20) NOT NULL,
  `Drink` varchar(20) NOT NULL,
  `Price` int(7) NOT NULL,
  `description` varchar(500) NOT NULL,
  `status` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservationmenu`
--

INSERT INTO `reservationmenu` (`custName`, `custAddr`, `Phone`, `Meal`, `Drink`, `Price`, `description`, `status`) VALUES
('rasyid', 'addd', 9887777, 'makanan', 'minum', 98881, '', 1),
('rasyid', 'kalirase', 98889999, 'BAKSO', 'ARIZONA TEA', 650, '', 1),
('rasyid', 'kalirase', 98889999, 'BAKSO', 'ARIZONA TEA', 650, '', 1),
('rasyid', 'kalirase', 98889999, 'BAKSO', 'CAPPUCCINO', 680, '', 1),
('rasyid', 'kalirase', 98889999, 'BAKSO', 'MELON JUICE', 600, '', 1),
('rasyid', 'kalirase', 98889999, 'BAKSO', 'ARIZONA TEA', 650, 'topping : Tidak ada harga :0 ice : Normal  sugar : Normal ', 1),
('rasyid', 'kalirase', 98889999, 'CHOCOLATE FONDUE', 'ARIZONA TEA', 2700, 'topping :Krupuk harga :2000 ice : Normal  sugar : No ', 1),
('rasyid', 'kalirase', 98889999, 'MANCHOW SOUP', 'ESPRESSO', 5050, 'topping :Krupuk harga :2000 ice : No  sugar : Extra ', 1),
('rasyid', 'kalirase', 98889999, 'MANCHOW SOUP', 'ESPRESSO', 5050, 'topping :Krupuk harga :2000 ice : No  sugar : Extra ', 1),
('rasyid', 'kalirase', 98889999, 'BAKSOs', 'ARIZONA TEA', 12450, 'topping :Udang harga :10000 ice : Normal  sugar : No ', 1),
('rasyid', 'kalirase', 98889999, 'BAKSOs', 'ARIZONA TEA', 12450, 'topping :Udang harga :10000 ice : Normal  sugar : No ', 1),
('rasyid', 'kalirase', 98889999, 'BAKSOs', 'ARIZONA TEA', 12600, 'topping :Udang harga :10000 ice : Normal  sugar : No ', 1),
('jahahah', 'asdkjhkjasdh', 1982, 'BAKSOs', 'ARIZONA TEA', 650, 'topping : Tidak ada harga :0 ice : Normal  sugar : Normal ', 1),
('jahahah', 'asdkjhkjasdh', 1982, 'BAKSOs', 'CAPPUCCINO', 1580, 'topping : Tidak ada harga :0 ice : Normal  sugar : Normal ', 1),
('coba1hehhe', 'sleman', 1982, 'BAKSOs', 'ARIZONA TEA', 650, 'topping : Tidak ada harga :0 ice : Normal  sugar : Normal ', 1),
('Rasyid Kusnady', 'kalirase', 1982, 'BAKSOs', 'ARIZONA TEA', 650, 'topping : Tidak ada harga :0 ice : Normal  sugar : Normal ', 1),
('Rasyid Kusnady', 'kalirase', 1982, 'BAKSOs', 'ARIZONA TEA', 650, 'topping : Tidak ada harga :0 ice : Normal  sugar : Normal ', 1),
('Rasyid Kusnady', 'kalirase', 1982, 'BAKSOs', 'ARIZONA TEA', 650, 'topping : Tidak ada harga :0 ice : Normal  sugar : Normal ', 1),
('rasyid', 'Sleman', 1982, 'BAKSOs', 'ESPRESSO', 12000, 'topping :Udang harga :10000 ice : Extra  sugar : Less ', 1),
('Rasyid Kusnady', 'kalirase', 1982, 'BAKSOs', 'CAPPUCCINO', 12040, 'topping :Udang harga :10000 ice : Extra  sugar : No ', 1),
('Rasyid Kusnady', 'kalirase', 1982, 'BAKSOs', 'ARIZONA TEA', 11300, 'topping :Udang harga :10000 ice : No  sugar : Less ', 1);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant`
--

CREATE TABLE `restaurant` (
  `itemNo` int(3) NOT NULL,
  `itemName` varchar(20) NOT NULL,
  `Price` int(4) NOT NULL,
  `Type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurant`
--

INSERT INTO `restaurant` (`itemNo`, `itemName`, `Price`, `Type`) VALUES
(2, 'coklatsss', 2000, 'MEAL'),
(3, 'MANCHOW SOUP', 400, 'MEAL'),
(4, 'PANEER MANCHURIAN', 350, 'MEAL'),
(5, 'PIRI-PIRI CHICKEN', 600, 'MEAL'),
(6, 'PINA-COLADA', 250, 'DRINK'),
(7, 'ARIZONA TEA', 150, 'DRINK'),
(8, 'CAPPUCCINO', 180, 'DRINK'),
(9, 'ESPRESSO', 250, 'DRINK'),
(10, 'MELON JUICE', 100, 'DRINK'),
(11, 'BAKSOs', 500, 'MEAL');

-- --------------------------------------------------------

--
-- Table structure for table `roomorders`
--

CREATE TABLE `roomorders` (
  `orderID` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `roomtypeID` int(11) DEFAULT NULL,
  `roomNumber` int(11) DEFAULT NULL,
  `days` int(11) DEFAULT NULL,
  `orderDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roomorders`
--

INSERT INTO `roomorders` (`orderID`, `userID`, `roomtypeID`, `roomNumber`, `days`, `orderDate`) VALUES
(1, 3, 3, 301, 4, '2023-06-19'),
(2, 5, 3, 302, 5, '2023-06-19'),
(3, 2, 3, 303, 2, '2023-06-19'),
(4, 1, 1, 101, 2, '2023-06-20'),
(5, 17, 3, 307, 2, '2023-06-20');

-- --------------------------------------------------------

--
-- Table structure for table `roomtype`
--

CREATE TABLE `roomtype` (
  `roomtype_id` int(11) NOT NULL,
  `roomName` varchar(255) DEFAULT NULL,
  `bedType` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roomtype`
--

INSERT INTO `roomtype` (`roomtype_id`, `roomName`, `bedType`, `price`) VALUES
(1, 'Standard Room', 'Single Bed', '200.00'),
(2, 'Premium Room', 'Double Bed', '450.00'),
(3, 'Deluxe Room', 'King Bed', '500.00');

-- --------------------------------------------------------

--
-- Table structure for table `standardroom`
--

CREATE TABLE `standardroom` (
  `id` int(11) NOT NULL,
  `roomtype_id` int(11) NOT NULL,
  `roomNumber` int(11) NOT NULL,
  `availability` tinyint(1) NOT NULL,
  `freeSnack` tinyint(1) NOT NULL,
  `wifi` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `standardroom`
--

INSERT INTO `standardroom` (`id`, `roomtype_id`, `roomNumber`, `availability`, `freeSnack`, `wifi`) VALUES
(1, 1, 101, 0, 1, 1),
(2, 1, 102, 1, 1, 1),
(3, 1, 103, 1, 1, 1),
(5, 1, 104, 1, 1, 1),
(6, 1, 105, 1, 1, 1),
(7, 1, 106, 1, 1, 1),
(8, 1, 107, 1, 1, 1),
(10, 1, 108, 0, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `deluxeroom`
--
ALTER TABLE `deluxeroom`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `roomNumber` (`roomNumber`),
  ADD KEY `roomtype_id` (`roomtype_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `guest`
--
ALTER TABLE `guest`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `premiumroom`
--
ALTER TABLE `premiumroom`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `roomNumber` (`roomNumber`),
  ADD KEY `roomtype_id` (`roomtype_id`);

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`itemNo`);

--
-- Indexes for table `roomorders`
--
ALTER TABLE `roomorders`
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `fk1` (`userID`),
  ADD KEY `fk2` (`roomtypeID`);

--
-- Indexes for table `roomtype`
--
ALTER TABLE `roomtype`
  ADD PRIMARY KEY (`roomtype_id`);

--
-- Indexes for table `standardroom`
--
ALTER TABLE `standardroom`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `roomNumber` (`roomNumber`),
  ADD KEY `roomtype_id` (`roomtype_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `deluxeroom`
--
ALTER TABLE `deluxeroom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `guest`
--
ALTER TABLE `guest`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `premiumroom`
--
ALTER TABLE `premiumroom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `itemNo` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `roomorders`
--
ALTER TABLE `roomorders`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `roomtype`
--
ALTER TABLE `roomtype`
  MODIFY `roomtype_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=202;

--
-- AUTO_INCREMENT for table `standardroom`
--
ALTER TABLE `standardroom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `deluxeroom`
--
ALTER TABLE `deluxeroom`
  ADD CONSTRAINT `deluxeroom_ibfk_1` FOREIGN KEY (`roomtype_id`) REFERENCES `roomtype` (`roomtype_id`);

--
-- Constraints for table `premiumroom`
--
ALTER TABLE `premiumroom`
  ADD CONSTRAINT `premiumroom_ibfk_1` FOREIGN KEY (`roomtype_id`) REFERENCES `roomtype` (`roomtype_id`);

--
-- Constraints for table `roomorders`
--
ALTER TABLE `roomorders`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`userID`) REFERENCES `guest` (`id`),
  ADD CONSTRAINT `fk2` FOREIGN KEY (`roomtypeID`) REFERENCES `roomtype` (`roomtype_id`);

--
-- Constraints for table `standardroom`
--
ALTER TABLE `standardroom`
  ADD CONSTRAINT `standardroom_ibfk_1` FOREIGN KEY (`roomtype_id`) REFERENCES `roomtype` (`roomtype_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
