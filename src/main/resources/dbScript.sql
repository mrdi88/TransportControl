-- phpMyAdmin SQL Dump
-- version 4.2.8
-- http://www.phpmyadmin.net
--
-- Хост: localhost:3306
-- Время создания: Авг 19 2016 г., 07:46
-- Версия сервера: 5.5.39
-- Версия PHP: 5.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `tcs`
--

-- --------------------------------------------------------

--
-- Структура таблицы `cards`
--

CREATE TABLE IF NOT EXISTS `cards` (
`cardId` bigint(20) NOT NULL,
  `carId` bigint(20) DEFAULT NULL,
  `cardNumber` char(20) NOT NULL,
  `state` int(11) NOT NULL,
  `accessLevel` int(11) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `cargos`
--

CREATE TABLE IF NOT EXISTS `cargos` (
`cargoId` bigint(20) NOT NULL,
  `carId` bigint(20) DEFAULT NULL,
  `quality` int(11) DEFAULT NULL,
  `weightIn` int(11) DEFAULT NULL,
  `weightOut` int(11) DEFAULT NULL,
  `dischargingPlace` char(20) DEFAULT NULL,
  `dischargeDate` timestamp NULL DEFAULT NULL,
  `loadingPlace` char(20) DEFAULT NULL,
  `loadingDate` timestamp NULL DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `cars`
--

CREATE TABLE IF NOT EXISTS `cars` (
`carId` bigint(20) NOT NULL,
  `destination` char(10) DEFAULT NULL,
  `firstNumber` char(10) NOT NULL,
  `secondNumber` char(10) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `leaveDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `drivers`
--

CREATE TABLE IF NOT EXISTS `drivers` (
`driverId` bigint(20) NOT NULL,
  `carId` bigint(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `mobileNumber` char(13) DEFAULT NULL,
  `organization` char(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `queueelements`
--

CREATE TABLE IF NOT EXISTS `queueelements` (
`qElementId` bigint(20) NOT NULL,
  `orderNumber` int(11) NOT NULL,
  `cardId` bigint(20) DEFAULT NULL,
  `queueId` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `queues`
--

CREATE TABLE IF NOT EXISTS `queues` (
`queueId` bigint(20) NOT NULL,
  `name` char(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `cards`
--
ALTER TABLE `cards`
 ADD PRIMARY KEY (`cardId`), ADD KEY `Refcars71` (`carId`);

--
-- Индексы таблицы `cargos`
--
ALTER TABLE `cargos`
 ADD PRIMARY KEY (`cargoId`), ADD KEY `FK002p` (`carId`);

--
-- Индексы таблицы `cars`
--
ALTER TABLE `cars`
 ADD PRIMARY KEY (`carId`);

--
-- Индексы таблицы `drivers`
--
ALTER TABLE `drivers`
 ADD PRIMARY KEY (`driverId`), ADD KEY `FK001` (`carId`);

--
-- Индексы таблицы `queueelements`
--
ALTER TABLE `queueelements`
 ADD PRIMARY KEY (`qElementId`), ADD KEY `Refcards91` (`cardId`), ADD KEY `Refqueues191` (`queueId`);

--
-- Индексы таблицы `queues`
--
ALTER TABLE `queues`
 ADD PRIMARY KEY (`queueId`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `cards`
--
ALTER TABLE `cards`
MODIFY `cardId` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `cargos`
--
ALTER TABLE `cargos`
MODIFY `cargoId` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `cars`
--
ALTER TABLE `cars`
MODIFY `carId` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `drivers`
--
ALTER TABLE `drivers`
MODIFY `driverId` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `queueelements`
--
ALTER TABLE `queueelements`
MODIFY `qElementId` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `queues`
--
ALTER TABLE `queues`
MODIFY `queueId` bigint(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
