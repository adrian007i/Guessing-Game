-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 18, 2017 at 08:16 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `guess`
--

-- --------------------------------------------------------

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
CREATE TABLE IF NOT EXISTS `players` (
  `USERNAME` varchar(30) NOT NULL,
  `CORRECTLY_ANSWERED` int(11) DEFAULT NULL,
  `TIME_REMAINING` int(11) DEFAULT NULL,
  `STRIKES` int(11) DEFAULT NULL,
  `DATE_OF_SCORE` date DEFAULT NULL,
  `TIME_OF_PLAY` time DEFAULT NULL,
  PRIMARY KEY (`USERNAME`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `players`
--

INSERT INTO `players` (`USERNAME`, `CORRECTLY_ANSWERED`, `TIME_REMAINING`, `STRIKES`, `DATE_OF_SCORE`, `TIME_OF_PLAY`) VALUES
('MR Bond', 2, 130, 1, '2017-12-18', '14:05:04'),
('kingsman', 1, 100, 2, '2017-12-18', '14:05:13'),
('ultimate noob', 1, 91, 4, '2017-12-18', '14:05:21'),
('Anonymous 1', 2, 0, 1, '2017-12-18', '14:56:51'),
('adrian007i', 1, 125, 3, '2017-12-18', '14:59:51'),
('Anonymous 2', 3, 59, 5, '2017-12-18', '15:03:45');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
