# DB as JSON

Applikation für das erlernen von Spring Boot mit Gradle.

#### Voraussetzungen
* Java Version 1.8.0_151
* Gradle Version 4.6
* Spring Boot Version 1.5.3
* MySQL Server

#### Projekt Setup
##### DB Schema:
CREATE DATABASE IF NOT EXISTS carsdb;

use carsdb;

CREATE TABLE cars (
	id INT AUTO_INCREMENT PRIMARY KEY,
	marke VARCHAR(80),
	modell VARCHAR(80),
	aufbau VARCHAR(80),
	km INT,
	hubraum INT,
	ps INT,
	preis INT
);

INSERT INTO cars (marke, modell, aufbau, km, hubraum, ps, preis)
VALUES ("VW", "Polo GTI", "Kleinwagen", 1000, 1800, 192, 25000),
		("BMW", "120d", "Limousine", 60000, 2000, 184, 18500),
		("Lamborghini", "Aventador", "Sportwagen", 1, 6500, 700, 350000),
		("Porsche", "918 Spyder", "Sportwagen", 10, 4600, 886, 1500000)
		;

#### Useranleitung
Es geht darum eine Applikation zu schreiben, um Spring Boot kennen zu lernen. Die 
Datenbankn muss vorher schon vorhanden sein. Die Tabellen werden über Java gemacht 
und über den SetupDataLoader (Bonusaufgabe) werden Daten in die Tabelle schon im
voraus geladen, damit die Tabelle nicht jedes mal bei einem Neustart leer ist. 
Zusätzlich habe ich dannn noch eine zweite Tabelle gemacht und diese miteinander
verknüpft (Bonusaufgabe). Es gibt verschieden GET und POST Request für diese Aufgabe.
Auch über einen Aufruf im Web funktioniert dieses Programm (Bonusaufgabe).

#### Autor
* Noel Oliveira

#### Datum
* 8.3.18
