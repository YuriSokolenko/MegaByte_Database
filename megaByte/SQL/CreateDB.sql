drop database if exists Megabyte;
create database Megabyte;
use Megabyte;
CREATE TABLE `Participant`(
	`Id` bigint not null unique,
    `First_Name` varchar(64) not null,
    `Last_Name` varchar(64) not null,
    `Tel_number` numeric,
    `Adress` varchar(255),
    `City` varchar(32),
    `District` varchar(32),
    `Birthdate` date,
    `Repatriation_year` date,
    `Interests` varchar(512),
    `Last_active date` date,
    `Gender` varchar(32),
    primary key (`Id`)
)ENGINE=InnoDB;
CREATE TABLE `Organizer`(
	`Id` bigint not null unique,
    `First_Name` varchar(64) not null,
    `Last_Name` varchar(64) not null,
    `Tel_number` numeric not null,
    `Events_quantity` int,
    primary key (`Id`)
)ENGINE=InnoDB;
CREATE TABLE `Event`(
	`Id` bigint NOT NULL UNIQUE,
	`Name` varchar(255) not null,
    `Date` date not null,
	`Status` varchar(255),
	`Type` varchar(255),
	`Place` varchar(255),
	`Price` double,
	`Participants_quantity` int,
	`Organizer` bigint not null,
    constraint `PK_event` primary key (`Id`),
    constraint `FK_event` foreign key (`Organizer`) references `Organizer` (`Id`)
    on delete no action
)ENGINE=InnoDB;
CREATE TABLE `Participant_event`(
	`Participant_id` bigint not null,
    `Event_id` bigint not null,
    primary key (`Participant_id`, `Event_id`)
)ENGINE=InnoDB;
CREATE TABLE `Organizer_event`(
	`Organizer_id` bigint not null,
    `Event_id` bigint not null,
    primary key (`Organizer_id`, `Event_id`)
)ENGINE=InnoDB;

