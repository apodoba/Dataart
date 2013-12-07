-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Дек 07 2013 г., 14:42
-- Версия сервера: 5.5.24-log
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `bank`
--

-- --------------------------------------------------------

--
-- Структура таблицы `accounts`
--

CREATE TABLE IF NOT EXISTS `accounts` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `USER_ID` int(10) unsigned NOT NULL,
  `BALANCE` double DEFAULT NULL,
  `CURRENCY_TYPE_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_user` (`USER_ID`),
  KEY `FK_currency_type` (`CURRENCY_TYPE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=102 ;

--
-- Дамп данных таблицы `accounts`
--

INSERT INTO `accounts` (`ID`, `NAME`, `USER_ID`, `BALANCE`, `CURRENCY_TYPE_ID`) VALUES
(5, '111222333', 5, 40, 10),
(100, '233075776', 100, 203, 10),
(101, '999888', 101, 156, 10);

-- --------------------------------------------------------

--
-- Структура таблицы `currency_type`
--

CREATE TABLE IF NOT EXISTS `currency_type` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Дамп данных таблицы `currency_type`
--

INSERT INTO `currency_type` (`ID`, `NAME`) VALUES
(10, '$');

-- --------------------------------------------------------

--
-- Структура таблицы `scratch_cards`
--

CREATE TABLE IF NOT EXISTS `scratch_cards` (
  `ID` varchar(32) NOT NULL,
  `MONEY` int(10) NOT NULL,
  `ENABLE` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `scratch_cards`
--

INSERT INTO `scratch_cards` (`ID`, `MONEY`, `ENABLE`) VALUES
('5826swf', 20, 1),
('879asfrq', 10, 0),
('879qsg5', 50, 1),
('AFT561', 30, 1),
('sdfg3125g3', 100, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `services`
--

CREATE TABLE IF NOT EXISTS `services` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `services`
--

INSERT INTO `services` (`ID`, `NAME`) VALUES
(1, 'Phone'),
(2, 'TV');

-- --------------------------------------------------------

--
-- Структура таблицы `transactions`
--

CREATE TABLE IF NOT EXISTS `transactions` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ACCOUNT_ID` int(10) unsigned NOT NULL,
  `TRANSACTION_TYPE_ID` int(10) unsigned NOT NULL,
  `DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `AMOUNT` double DEFAULT NULL,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_account` (`ACCOUNT_ID`),
  KEY `FK_transacton_type` (`TRANSACTION_TYPE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=29 ;

--
-- Дамп данных таблицы `transactions`
--

INSERT INTO `transactions` (`ID`, `ACCOUNT_ID`, `TRANSACTION_TYPE_ID`, `DATE`, `AMOUNT`, `DESCRIPTION`) VALUES
(1, 100, 1, '2013-12-01 15:52:11', 10, NULL),
(2, 100, 1, '2013-12-01 15:52:57', 10, NULL),
(3, 100, 1, '2013-12-01 15:54:11', 10, NULL),
(4, 100, 1, '2013-12-01 15:57:15', 10, NULL),
(5, 100, 1, '2013-12-01 15:57:21', 10, NULL),
(6, 100, 1, '2013-12-01 16:06:09', 10, NULL),
(7, 100, 1, '2013-12-01 16:06:12', 10, NULL),
(8, 100, 1, '2013-12-05 19:28:04', 60, '157942'),
(9, 100, 2, '2013-12-05 20:47:12', 8, NULL),
(10, 100, 2, '2013-12-05 21:24:14', 1, NULL),
(11, 100, 2, '2013-12-05 21:57:50', 1, '999888'),
(12, 101, 1, '2013-12-06 18:59:31', 1, '123456'),
(13, 101, 2, '2013-12-06 19:11:04', 1, NULL),
(14, 101, 2, '2013-12-06 19:16:52', 1, NULL),
(15, 101, 2, '2013-12-06 19:19:02', 1, NULL),
(16, 101, 2, '2013-12-06 19:20:46', 10, NULL),
(17, 101, 1, '2013-12-06 22:47:23', 10, 'Phone 5879'),
(18, 101, 2, '2013-12-07 12:49:31', 10, NULL),
(19, 101, 2, '2013-12-07 12:50:00', 100, NULL),
(21, 101, 2, '2013-12-07 13:37:22', 10, '111222333'),
(22, 5, 4, '2013-12-07 13:37:22', 10, '999888'),
(23, 101, 3, '2013-12-07 13:50:23', 20, NULL),
(24, 101, 2, '2013-12-07 13:50:58', 50, '111222333'),
(25, 5, 4, '2013-12-07 13:50:58', 50, '999888'),
(26, 5, 1, '2013-12-07 14:00:49', 50, 'TV 586792'),
(27, 5, 3, '2013-12-07 14:23:10', 10, NULL),
(28, 5, 3, '2013-12-07 14:37:12', 10, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `transaction_type`
--

CREATE TABLE IF NOT EXISTS `transaction_type` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Дамп данных таблицы `transaction_type`
--

INSERT INTO `transaction_type` (`ID`, `NAME`) VALUES
(1, 'SERVICE_PAYMENT'),
(2, 'HUMAN_PAYMENT'),
(3, 'INCREASE_ACCOUNT_PAYMENT'),
(4, 'INCREASE_ACCOUNT_FROM');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `USER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `ENABLED` tinyint(1) NOT NULL,
  `PHONE` varchar(45) NOT NULL,
  `FULL_NAME` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=102 ;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`USER_ID`, `USERNAME`, `PASSWORD`, `ENABLED`, `PHONE`, `FULL_NAME`, `EMAIL`) VALUES
(5, 'user', '7c4a8d09ca3762af61e59520943dc26494f8941b', 1, '11122233', 'user', 'user@localhost'),
(100, 'admin', '7c4a8d09ca3762af61e59520943dc26494f8941b', 1, '09377854235', 'петров', 'petrov@mail.ru'),
(101, 'Ivanov', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', 1, '587936', 'Иванов', 'Ivanov@localhost');

-- --------------------------------------------------------

--
-- Структура таблицы `user_roles`
--

CREATE TABLE IF NOT EXISTS `user_roles` (
  `USER_ROLE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `USER_ID` int(10) unsigned NOT NULL,
  `ROLE` varchar(45) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  KEY `FK_user_roles` (`USER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Дамп данных таблицы `user_roles`
--

INSERT INTO `user_roles` (`USER_ROLE_ID`, `USER_ID`, `ROLE`) VALUES
(1, 100, 'ROLE_ADMIN'),
(2, 101, 'ROLE_USER'),
(3, 5, 'ROLE_USER');

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `accounts`
--
ALTER TABLE `accounts`
  ADD CONSTRAINT `FK_currency_type` FOREIGN KEY (`CURRENCY_TYPE_ID`) REFERENCES `currency_type` (`ID`),
  ADD CONSTRAINT `FK_user` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`);

--
-- Ограничения внешнего ключа таблицы `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `FK_account` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `accounts` (`ID`),
  ADD CONSTRAINT `FK_transacton_type` FOREIGN KEY (`TRANSACTION_TYPE_ID`) REFERENCES `transaction_type` (`ID`);

--
-- Ограничения внешнего ключа таблицы `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK_user_roles` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
