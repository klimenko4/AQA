-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Апр 16 2017 г., 18:28
-- Версия сервера: 10.1.21-MariaDB
-- Версия PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `db_user`
--

-- --------------------------------------------------------

--
-- Структура таблицы `new_user_data`
--

CREATE TABLE `new_user_data` (
  `id` smallint(5) UNSIGNED NOT NULL,
  `email` varchar(50) NOT NULL DEFAULT '',
  `nick` varchar(50) NOT NULL DEFAULT '',
  `pass` varchar(50) NOT NULL DEFAULT '',
  `email_err_message` varchar(50) NOT NULL DEFAULT '',
  `nick_err_message` varchar(50) NOT NULL DEFAULT '',
  `pass_err_message` varchar(100) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `new_user_data`
--

INSERT INTO `new_user_data` (`id`, `email`, `nick`, `pass`, `email_err_message`, `nick_err_message`, `pass_err_message`) VALUES
(3, 'erentchi@ukr.net', 'Deutsche', 'ere', '', '', 'Длина поля не может быть меньше 4 и больше 16 символов'),
(12, 'enretcophi@ukr.net', 'D34eutsche', '', '', '', 'Заполните это поле'),
(13, 'uipui@lo.re', 'лдролр', 'JKklpoi', '', 'Поле не соответствует формату', ''),
(14, '', 'gfhagfdhsfgjmhg', 'JKklpoklk', 'Заполните это поле', '', '');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `new_user_data`
--
ALTER TABLE `new_user_data`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `new_user_data`
--
ALTER TABLE `new_user_data`
  MODIFY `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
