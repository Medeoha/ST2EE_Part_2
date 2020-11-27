-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 22 nov. 2020 à 15:13
-- Version du serveur :  5.7.28
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS ST2EEDB;
CREATE DATABASE ST2EEDB;
USE ST2EEDB;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `st2eedb`
--

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `affichage`
-- (Voir ci-dessous la vue réelle)
--
DROP VIEW IF EXISTS `affichage`;
CREATE TABLE IF NOT EXISTS `affichage` (
`lastname` varchar(255)
,`address` varchar(255)
,`intern_group` varchar(255)
,`eval_sheet` int(11)
,`visit_sheet` int(11)
,`report_title` varchar(255)
,`soutenance` tinyint(1)
,`start_mission` date
,`end_mission` date
,`grade_tech` int(11)
,`grade_com` int(11)
,`visit_planned` tinyint(1)
,`visit_done` tinyint(1)
);

-- --------------------------------------------------------

--
-- Structure de la table `eval_sheet`
--

DROP TABLE IF EXISTS `eval_sheet`;
CREATE TABLE IF NOT EXISTS `eval_sheet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comments_of_supervisor` text,
  `grade_tech` int(11) DEFAULT NULL,
  `grade_com` int(11) DEFAULT NULL,
  `eval_sheet_done` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `eval_sheet`
--

INSERT INTO `eval_sheet` (`id`, `comments_of_supervisor`, `grade_tech`, `grade_com`, `eval_sheet_done`) VALUES
(1, 'AMZZING', 20, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `info_intern`
--

DROP TABLE IF EXISTS `info_intern`;
CREATE TABLE IF NOT EXISTS `info_intern` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `skills` text,
  `linkedin` text,
  `intern_group` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `info_intern`
--

INSERT INTO `info_intern` (`id`, `firstname`, `lastname`, `address`, `skills`, `linkedin`, `intern_group`, `birthday`) VALUES
(1, 'Murielle', 'Bagneux', '37 rue Victor Hugo', 'VBA, excel', 'aucun', 'm1', '1995-10-10');

-- --------------------------------------------------------

--
-- Structure de la table `intern`
--

DROP TABLE IF EXISTS `intern`;
CREATE TABLE IF NOT EXISTS `intern` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mission_id` int(11) DEFAULT NULL,
  `info_intern_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mission_id` (`mission_id`),
  KEY `info_intern_id` (`info_intern_id`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `intern`
--

INSERT INTO `intern` (`id`, `mission_id`, `info_intern_id`, `teacher_id`) VALUES
(1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

DROP TABLE IF EXISTS `mission`;
CREATE TABLE IF NOT EXISTS `mission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) DEFAULT NULL,
  `start_mission` date DEFAULT NULL,
  `end_mission` date DEFAULT NULL,
  `report_title` varchar(255) DEFAULT NULL,
  `comments_of_the_intern` text,
  `mid_internship_meeting_info` text,
  `soutenance` tinyint(1) DEFAULT NULL,
  `key_word` text,
  `eval_sheet_id` int(11) DEFAULT NULL,
  `visit_sheet_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `eval_sheet_id` (`eval_sheet_id`),
  KEY `visit_sheet_id` (`visit_sheet_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `mission`
--

INSERT INTO `mission` (`id`, `year`, `start_mission`, `end_mission`, `report_title`, `comments_of_the_intern`, `mid_internship_meeting_info`, `soutenance`, `key_word`, `eval_sheet_id`, `visit_sheet_id`) VALUES
(1, 2018, '2018-12-12', '2019-10-10', 'REPORT_TEST', 'Boring stage', 'yes', 0, 'VBA, EXCEL', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `teacher`
--

INSERT INTO `teacher` (`id`, `firstname`, `lastname`, `login`, `password`) VALUES
(1, 'Jean', 'Petit', 'adm', 'adm'),
(2, 'Nicolas', 'Thomas', '123', '123'),
(3, 'Nicolas', 'Huge', 'azerty', 'azerty');

-- --------------------------------------------------------

--
-- Structure de la table `visit_sheet`
--

DROP TABLE IF EXISTS `visit_sheet`;
CREATE TABLE IF NOT EXISTS `visit_sheet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visit_planned` tinyint(1) DEFAULT NULL,
  `visit_done` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `visit_sheet`
--

INSERT INTO `visit_sheet` (`id`, `visit_planned`, `visit_done`) VALUES
(1, 1, 1);

-- --------------------------------------------------------
CREATE USER 'adm'@'localhost' IDENTIFIED BY 'adm';
GRANT ALL PRIVILEGES ON * . * TO 'adm'@'localhost';
SET GLOBAL time_zone = '+1:00';
--
-- Structure de la vue `affichage`
--

