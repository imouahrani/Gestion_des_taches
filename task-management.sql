-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : Dim 09 jan. 2022 à 23:51
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `task-management`
--

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(42);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `code`, `description`) VALUES
(1, 'ADMIN', 'admin'),
(2, 'USER', 'User');

-- --------------------------------------------------------

--
-- Structure de la table `state`
--

DROP TABLE IF EXISTS `state`;
CREATE TABLE IF NOT EXISTS `state` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `state`
--

INSERT INTO `state` (`id`, `code`, `description`) VALUES
(1, 'NEW', 'NEW TASK'),
(2, 'TODO', 'TO DO TASK'),
(3, 'DONE', 'TASK DONE');

-- --------------------------------------------------------

--
-- Structure de la table `task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE IF NOT EXISTS `task` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpk5d4or4nk6sijctxt0edufrk` (`state_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `task`
--

INSERT INTO `task` (`id`, `created_date`, `description`, `name`, `state_id`) VALUES
(22, '2021-11-22 01:14:48', ' des lorem lepsum  des lorem lepsum des lorem lepsum des lorem lepsum des lorem lepsum des lorem lepsum ', 'test', 1),
(30, '2021-11-30 15:41:56', 'desc  new', 'other task new ', 3),
(31, '2021-11-06 11:43:40', 'todo', 'todo', 2),
(32, '2022-01-01 18:28:49', 'done', 'done', 2),
(2, '2021-11-06 11:43:42', 'todo', 'todo', 3),
(1, '2022-01-09 19:05:47', 'desc other task to affect to new user', 'other task', 3),
(40, '2021-11-06 11:43:52', 'desc', 'new task', 3),
(10, '2022-01-09 17:48:05', 'Spring boot, Spring data, Spring core, Sring MVC, Sprin security, Thymleaf', 'TP Techno-web ', 2);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `active`, `email`, `full_name`, `password`, `role_id`) VALUES
(1, b'1', 'test@gmail.com', 'fullnametest', '$2a$10$WsJjHwXGCpaBvUIC5fbnrOQnnHvONg4w4bGqk4Yb/N0jOJo6xO1BO', 1),
(2, b'1', 'b@b.com', 'abc', '$2a$09$HuPbbea4HcvH0BB0xZPvsOCYvXXSGsvIryR5iel/3UBFHRHBEe7u6', 1),
(24, b'1', 'alex@gmail.com', 'alex', '123', 1),
(25, b'1', 'test@test.com', 'test', '123', 2),
(26, b'1', 'new@new.com', 'new', '$2a$09$HuPbbea4HcvH0BB0xZPvsOCYvXXSGsvIryR5iel/3UBFHRHBEe7u6', 2),
(27, b'1', 'jhon@doe.com', 'jhon doe', '$2a$10$z/Mf2t/S2piBn.dxNWbEteeJw.eK9X.br5bMPw4KBrJNdgrKruOfy', 2),
(28, b'1', 's@s.com', 'silvister', '$2a$10$yrnWwljWmlYx6MgSsOyDX.zvKkEJ6xi/QFqWvDp7ZwO7qC4vd4NEi', 1),
(29, b'1', 'w@w.com', 'Jhon claud', '$2a$10$WsJjHwXGCpaBvUIC5fbnrOQnnHvONg4w4bGqk4Yb/N0jOJo6xO1BO', 1);

-- --------------------------------------------------------

--
-- Structure de la table `user_task`
--

DROP TABLE IF EXISTS `user_task`;
CREATE TABLE IF NOT EXISTS `user_task` (
  `id` bigint(20) NOT NULL,
  `assignement_date` datetime DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKvs34bjkmpbk2e54qlrol3ilt` (`task_id`),
  KEY `FKr2jik008e3jx6r1fal5e9aq1n` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user_task`
--

INSERT INTO `user_task` (`id`, `assignement_date`, `task_id`, `user_id`) VALUES
(37, '2021-11-22 01:14:48', 30, 1),
(38, '2021-11-30 15:41:56', 30, 26),
(39, '2022-01-01 18:28:49', 1, 26),
(2, '2022-01-03 18:28:49', 2, 26),
(41, '2022-01-09 19:05:47', 30, 26),
(10, '2022-01-09 17:44:01', 10, 26);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
