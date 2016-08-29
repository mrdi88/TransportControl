-- phpMyAdmin SQL Dump
-- version 4.6.3
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Авг 29 2016 г., 10:33
-- Версия сервера: 5.6.32
-- Версия PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `tcs`
--

-- --------------------------------------------------------

--
-- Структура таблицы `cards`
--

CREATE TABLE `cards` (
  `id` bigint(20) NOT NULL,
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

CREATE TABLE `cargos` (
  `id` bigint(20) NOT NULL,
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

CREATE TABLE `cars` (
  `id` bigint(20) NOT NULL,
  `cargoId` bigint(20) NOT NULL,
  `driverId` bigint(20) NOT NULL,
  `destination` char(10) DEFAULT NULL,
  `firstNumber` char(10) NOT NULL,
  `secondNumber` char(10) NOT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  `leaveDate` timestamp NULL DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `drivers`
--

CREATE TABLE `drivers` (
  `Id` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `mobileNumber` char(13) DEFAULT NULL,
  `organization` char(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `queues`
--

CREATE TABLE `queues` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `queues_elements`
--

CREATE TABLE `queues_elements` (
  `id` bigint(20) NOT NULL,
  `cardId` bigint(20) DEFAULT NULL,
  `queueId` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `queues_queues_elements`
--

CREATE TABLE `queues_queues_elements` (
  `Queue_id` bigint(20) NOT NULL,
  `queueElements_id` bigint(20) NOT NULL,
  `order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `cards`
--
ALTER TABLE `cards`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Refcars71` (`carId`);

--
-- Индексы таблицы `cargos`
--
ALTER TABLE `cargos`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcarToCargo` (`cargoId`),
  ADD KEY `FKcarToDriver` (`driverId`);

--
-- Индексы таблицы `drivers`
--
ALTER TABLE `drivers`
  ADD PRIMARY KEY (`Id`);

--
-- Индексы таблицы `queues`
--
ALTER TABLE `queues`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `queues_elements`
--
ALTER TABLE `queues_elements`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `queues_queues_elements`
--
ALTER TABLE `queues_queues_elements`
  ADD KEY `FKr38us2n8g5p9494sd3392` (`queueElements_id`),
  ADD KEY `TransportQueue_queueId` (`Queue_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `cards`
--
ALTER TABLE `cards`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT для таблицы `cargos`
--
ALTER TABLE `cargos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT для таблицы `cars`
--
ALTER TABLE `cars`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT для таблицы `drivers`
--
ALTER TABLE `drivers`
  MODIFY `Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `queues_queues_elements`
--
ALTER TABLE `queues_queues_elements`
  ADD CONSTRAINT `FKr38us2n8g5p9494sd3391` FOREIGN KEY (`Queue_id`) REFERENCES `queues` (`id`),
  ADD CONSTRAINT `FKr38us2n8g5p9494sd3392` FOREIGN KEY (`queueElements_id`) REFERENCES `queues_elements` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
