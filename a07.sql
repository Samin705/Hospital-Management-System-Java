-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2019 at 06:41 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `a07`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `aid` varchar(8) NOT NULL,
  `name` varchar(10) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`aid`, `name`, `salary`) VALUES
('a01', 'Rahim', 70000.00),
('a02', 'Kareem', 75000.00),
('a03', 'Salek', 60000.00),
('a04', 'Malek', 65000.00),
('a05', 'Salam', 72000.00);

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `did` varchar(8) NOT NULL,
  `name` varchar(10) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `fee` double(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`did`, `name`, `designation`, `fee`) VALUES
('d01', 'Dr.Asif', 'Arthopedic', 800.00),
('d02', 'Dr.Ali', 'Arthopedic', 800.00),
('d03', 'Dr.Ashraaf', 'Cardiologist', 700.00),
('d04', 'Dr.Kasheem', 'Allergist', 600.00),
('d05', 'Dr.Maneek', 'Cardiologist', 700.00),
('d07', 'Sharif', 'Allergist', 600.00),
('d10', 'mujib', 'Arthopedic', 600.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(8) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('a01', '123', 4),
('a02', '124', 4),
('a03', '125', 4),
('a04', '126', 4),
('a05', '127', 4),
('d01', '234', 0),
('d02', '235', 0),
('d03', '236', 1),
('d04', '237', 1),
('d05', '238', 1),
('d07', '18540021', 0),
('d10', '18498830', 0),
('p04', '10162819', 0),
('p05', '12799984', 0),
('r01', '345', 3),
('r02', '346', 2),
('r03', '347', 3),
('r04', '348', 3),
('r05', '349', 3),
('r06', '15356878', 0),
('r09', '16077887', 0);

-- --------------------------------------------------------

--
-- Table structure for table `paitent`
--

CREATE TABLE `paitent` (
  `pid` varchar(8) NOT NULL,
  `name` varchar(10) NOT NULL,
  `appointment` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paitent`
--

INSERT INTO `paitent` (`pid`, `name`, `appointment`) VALUES
('p01', 'Abrar', 'Dr.Ali'),
('p02', 'Rasel', 'Dr.Malek'),
('p03', 'Mahin', 'Dr.Ashraaf'),
('p04', 'Tusher', 'Dr.Manik'),
('p05', 'Himel', 'Dr.Kashem'),
('p06', 'Nishat', 'Dr.Manik');

-- --------------------------------------------------------

--
-- Table structure for table `receptionist`
--

CREATE TABLE `receptionist` (
  `rid` varchar(7) NOT NULL,
  `name` varchar(12) NOT NULL,
  `salary` double(7,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receptionist`
--

INSERT INTO `receptionist` (`rid`, `name`, `salary`) VALUES
('r01', 'Mahin', 25000.00),
('r02', 'Raheen', 25000.00),
('r03', 'Karim', 25000.00),
('r04', 'Apoon', 25000.00),
('r05', 'Malek', 25000.00),
('r06', 'swan', 20000.00),
('r09', 'Shahid', 20000.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`did`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `paitent`
--
ALTER TABLE `paitent`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `receptionist`
--
ALTER TABLE `receptionist`
  ADD PRIMARY KEY (`rid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
