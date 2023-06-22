# Projet Parc d'Attractions

Ce projet est un système de gestion pour un parc d'attractions. Il permet de gérer les billets, les attractions, les visiteurs et les différentes fonctionnalités liées à la gestion du parc.

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés :

- Java JDK 8 ou supérieur
- Maven
- Base de données MySQL (sur Docker)

## Installation de la Base de données

1. Installer Docker
2. Lancer la commande suivante : `docker run --name miageland_bdd -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=miageland_bdd -p 3306:3306 -d mysql`
3. La base de données est maintenant accessible sur le port 3306

## Exécution du projet
1. Démarrer la base de données MySQL
2. Démarer le projet avec la commande suivante : `mvn spring-boot:run` (ou via l'IDE)
3. Le projet est maintenant accessible sur le port 8080
4. Vous pouvez exécuter les requêtes HTTP via Postman par exemple

## Fonctionnalités

- Gestion des billets : création, annulation, modification de l'état, etc.
- Gestion des attractions : ajout, suppression, recherche, etc.
- Gestion des visiteurs : ajout, suppression, recherche, etc.
- Statistiques : recette totale, nombre de billets réservés par date, etc.

## Auteur

ANTON Franklin
BUAND Liam
MARCELLOT Camille

Pour toute question ou demande d'assistance, veuillez contacter l'auteur du projet ou l'adresse mail suivante : [camillemarcellot@gmail.com](mailto:camillemarcellot@gmail.com).
