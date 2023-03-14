DROP DATABASE IF EXISTS DvdLibrary;
CREATE DATABASE DvdLibrary;
USE DvdLibrary;

CREATE TABLE Dvd (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
title VARCHAR(50) NOT NULL,
director VARCHAR(30) NOT NULL,
rating VARCHAR(10) NOT NULL,
notes TEXT NOT NULL,
picture LONGBLOB
);

CREATE TABLE Customer (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
firstName VARCHAR(30) NOT NULL,
lastName VARCHAR(30) NOT NULL,
phone CHAR(10) NOT NULL,
email VARCHAR(75) NOT NULL,
picture LONGBLOB
);

CREATE TABLE Appointment (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
dvdToRentId INT NOT NULL,
isNewCustomer BOOL NOT NULL,
meetingDateTime DATETIME NOT NULL,
purpose VARCHAR(100) NOT NULL,
location VARCHAR(100) NOT NULL,
FOREIGN KEY (dvdToRentId) REFERENCES Dvd (id)
);

CREATE TABLE CustomerAppointment (
customerId INT NOT NULL,
appointmentId INT NOT NULL,
PRIMARY KEY (customerId, appointmentId),
FOREIGN KEY (customerId) REFERENCES Customer (id),
FOREIGN KEY (appointmentId) REFERENCES Appointment (id)
);
INSERT INTO Dvd(id, title, director, rating, notes) VALUES(1, "Super Bowl", "NFL", "10/10", "Would Recommend!!");
SELECT * FROM Dvd;



