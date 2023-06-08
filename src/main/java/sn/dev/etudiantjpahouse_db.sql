-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 08 juin 2023 à 19:00
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `etudiantjpahouse_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `classe_tb`
--

CREATE TABLE `classe_tb` (
  `id` int(11) NOT NULL,
  `nbEtudiants` int(11) DEFAULT 0,
  `nom` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `classe_tb`
--

INSERT INTO `classe_tb` (`id`, `nbEtudiants`, `nom`) VALUES
(1, 3, 'L3GL'),
(2, 2, 'DITI3');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant_tb`
--

CREATE TABLE `etudiant_tb` (
  `id` int(11) NOT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `matricule` varchar(200) NOT NULL,
  `nom` varchar(200) DEFAULT NULL,
  `prenom` varchar(200) DEFAULT NULL,
  `classe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `etudiant_tb`
--

INSERT INTO `etudiant_tb` (`id`, `genre`, `matricule`, `nom`, `prenom`, `classe`) VALUES
(1, 'FEMININ', '0221ISI6', 'Diallo', 'Fatoumata', 1),
(3, 'MASCULIN', '00221ISI2', 'Bah', 'Alpha Souleymane', 1),
(4, 'FEMININ', '00221ISI3', 'Bah', 'Binta', 1),
(6, 'FEMININ', '00221ISI5', 'Diallo', 'Oury', 2),
(7, 'FEMININ', '00221ISI6', 'Balde', 'Bouba', 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `classe_tb`
--
ALTER TABLE `classe_tb`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_tnsbhh0odbccyoprqjg79pip1` (`nom`);

--
-- Index pour la table `etudiant_tb`
--
ALTER TABLE `etudiant_tb`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_5bu7xr0k8awxe6sw8sp8qwaba` (`matricule`),
  ADD KEY `FKgc0nybpivnntw39k9uexmwnuc` (`classe`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `classe_tb`
--
ALTER TABLE `classe_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `etudiant_tb`
--
ALTER TABLE `etudiant_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `etudiant_tb`
--
ALTER TABLE `etudiant_tb`
  ADD CONSTRAINT `FKgc0nybpivnntw39k9uexmwnuc` FOREIGN KEY (`classe`) REFERENCES `classe_tb` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
