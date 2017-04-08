-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 08, 2017 at 02:32 PM
-- Server version: 5.5.42
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `cm_android_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `Compradas`
--

CREATE TABLE `Compradas` (
  `id_senha` int(11) NOT NULL,
  `id_utilizador` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Ementa`
--

CREATE TABLE `Ementa` (
  `id_senha` int(11) NOT NULL,
  `nome_refeicao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Utilizador`
--

CREATE TABLE `Utilizador` (
  `id_utilizador` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Compradas`
--
ALTER TABLE `Compradas`
  ADD PRIMARY KEY (`id_senha`,`id_utilizador`),
  ADD KEY `id_senha` (`id_senha`),
  ADD KEY `id_utilizador` (`id_utilizador`);

--
-- Indexes for table `Ementa`
--
ALTER TABLE `Ementa`
  ADD PRIMARY KEY (`id_senha`);

--
-- Indexes for table `Utilizador`
--
ALTER TABLE `Utilizador`
  ADD PRIMARY KEY (`id_utilizador`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Ementa`
--
ALTER TABLE `Ementa`
  MODIFY `id_senha` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Compradas`
--
ALTER TABLE `Compradas`
  ADD CONSTRAINT `compradas_ibfk_1` FOREIGN KEY (`id_senha`) REFERENCES `Ementa` (`id_senha`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `compradas_ibfk_2` FOREIGN KEY (`id_utilizador`) REFERENCES `Utilizador` (`id_utilizador`) ON DELETE CASCADE ON UPDATE CASCADE;
