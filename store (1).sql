-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2022 at 11:49 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `store`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `contact` int(40) DEFAULT NULL,
  `product_type` varchar(50) DEFAULT NULL,
  `amoun` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `contact`, `product_type`, `amoun`) VALUES
(1, 'wilson', 98646372, 'rice', '3432.00'),
(2, 'wilsone', 20999871, 'kerosene', '34.00');

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `id` int(11) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `discount` decimal(30,2) DEFAULT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`id`, `price`, `quantity`, `discount`, `name`) VALUES
(1, '54.00', 34, '23.00', 'wilson'),
(2, '45.00', 23, '11.00', 'vgn');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `amount` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `payment_method`, `date`, `amount`) VALUES
(1, 'dis', '2022-02-04 00:00:00', '34'),
(2, 'ffgfg', '2011-04-03 00:00:00', '123');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `category` varchar(40) DEFAULT NULL,
  `product_in_stock` int(11) DEFAULT NULL,
  `product_type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `category`, `product_in_stock`, `product_type`) VALUES
(1, NULL, NULL, NULL, ''),
(2, 'RICE', 'CAT A', 5, 'GREAN'),
(3, 'rice', 'catE', 6, 'long grain'),
(4, 'rollon', 'catA', 56, 'cosmetics'),
(5, 'rice', 'cat3', 21, 'glow'),
(6, 'bread', 'catb', 56, 'wkiij'),
(7, 'rife', 'cat2', 85, 'mint');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(11) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `passsword` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `fullName`, `username`, `email`, `passsword`) VALUES
(1, 'bob', 'luke', 'deluke@', '111'),
(2, 'wilson', 'nkan', 'wil@p.com', '12345'),
(4, 'spartan', 'spar', 'spar@gmail.com', '11111'),
(5, 'seraphine', 'sera12', 'serat12', '12345'),
(6, 'desmond', 'demens', 'demens@', '12345'),
(7, 'wilfred', 'wilson', 'wil@', '1212'),
(8, 'wil', 'deser', 'wils@', '1234'),
(9, 'pas', 'pasdde', 'derf@', 'aaaa'),
(10, 'dew', 'ved', 'list', 'wilo'),
(11, 'Seraphine', 'sera@', 'seraphine@gmail.com', '12345'),
(12, 'dmv', 'jdf', 'sdnf', 'kjsd'),
(13, 'pablo', 'pablowilson', 'pablo@gmail.com', '12345'),
(14, 'wilson', 'pablower', 'wilson@', '12345'),
(15, ' williams', 'hazard', 'frederick', '112233'),
(16, 'wilo', 'padder', 'poasl@', '1122'),
(17, 'wiloggh', 'ssbsvxxcfkcs', 'sbhxcsfxjsx121', '23212'),
(18, 'niimako', 'make', 'william@', '11111');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `contact` varchar(40) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `payment_method` varchar(50) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `prefered_goods` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
