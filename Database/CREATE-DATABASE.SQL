CREATE TABLE `event` 
(
	`id` int not null auto_increment,
	`chas_kinec` datetime not null,
	`name` varchar(255) not null,
	`chas_pochatok` datetime not null,
	`create` datetime not null,
	`delete` datetime not null,
	`modify` datetime not null
);

CREATE TABLE `event_zaprosheni` 
(
	`event_id` int,
	`zaprosheni_id` int
);

CREATE TABLE `mark` 
(
	`id` int not null auto_increment,
	`coordx` double not null,
	`coordy` double not null,
	`name` varchar(255) not null,
	`owner_id` int not null,
	`state` int not null,
	`create` datetime not null,
	`delete` datetime not null,
	`modify` datetime not null
);

CREATE TABLE `route` 
(
	`id` int not null,
	`name` varchar(255) not null
);

CREATE TABLE `route_marks` 
(
	`route_id` int not null,
	`marks_id` int not null
);

CREATE TABLE `type` 
(
	`id` int,
	`name` varchar(255)
);

CREATE TABLE `user` 
(
	`id` int not null auto_increment,
	`password` varchar(255) not null,
	`type` int not null,
	`username` varchar(255) not null,
	`state` int not null,
	`create` datetime not null,
	`delete` datetime not null,
	`modify` datetime not null,
	`email` varchar(255) NOT NULL,
	`firstName` varchar(255) NOT NULL,
	`lastName` varchar(255) NOT NULL,
	`birthDate` datetime not null,
	`phoneNumber` varchar(255) not null
);


ALTER TABLE `user` ADD CONSTRAINT `FK_type` FOREIGN KEY (`type`) REFERENCES `type` (`id`);

ALTER TABLE `mark` ADD CONSRTAINT `FK_id` FOREIGN KEY (`id`) REFERENCES `route_marks` (`marks_id`);

ALTER TABLE `route` ADD CONSTRAINT `FK_id` FOREIGN KEY (`id`) REFERENCES `route_marks` (`route_id`);

ALTER TABLE `mark` ADD CONSTRAINT `FK_owner` FOREIGN KEY (`ownerid`) REFERENCES `user` (`id`);

ALTER TABLE `event_zaprosheni` ADD CONSTRAINT `FK_event` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`);

ALTER TABLE `event_zaprosheni` ADD CONSTRAINT `FK_user` FOREIGN KEY (`zaprosheni_id`) REFERENCES `user` (`id`);

ALTER TABLE `state` ADD CONSTRAINT `FK_id` FOREIGN KEY (`id`) REFERENCES `mark` (`state`);

ALTER TABLE `state` ADD CONSTRAINT `FK_id` FOREIGN KEY (`id`) REFERENCES `user` (`state`);