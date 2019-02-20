CREATE TABLE `event` 
(
	`id` int,
	`chas_kinec` datetime,
	`name` varchar(255),
	`chas_pochatok` datetime,
	`create` datetime,
	`delete` datetime,
	`modify` datetime
);

CREATE TABLE `event_zaprosheni` 
(
	`event_id` int,
	`zaprosheni_id` int
);

CREATE TABLE `mark` 
(
	`id` int,
	`coordx` double,
	`coordy` double,
	`name` varchar(255),
	`ownerid` int,
	`state` int,
	`create` datetime,
	`delete` datetime,
	`modify` datetime
);

CREATE TABLE `route` 
(
	`id` int,
	`name` varchar(255)
);

CREATE TABLE `route_marks` 
(
	`route_id` int,
	`marks_id` int
);

CREATE TABLE `type` 
(
	`id` int,
	`name` varchar(255)
);

CREATE TABLE `user` 
(
	`id` int,
	`password` varchar(255),
	`type` int,
	`username` varchar(255),
	`state` int,
	`create` datetime,
	`delete` datetime,
	`modify` datetime
);

CREATE TABLE `state` 
(
	`id` int,
	`name` varchar(255)
);

ALTER TABLE `user` ADD FOREIGN KEY (`type`) REFERENCES `type` (`id`);

ALTER TABLE `mark` ADD FOREIGN KEY (`id`) REFERENCES `route_marks` (`marks_id`);

ALTER TABLE `route` ADD FOREIGN KEY (`id`) REFERENCES `route_marks` (`route_id`);

ALTER TABLE `mark` ADD FOREIGN KEY (`ownerid`) REFERENCES `user` (`id`);

ALTER TABLE `event_zaprosheni` ADD FOREIGN KEY (`event_id`) REFERENCES `event` (`id`);

ALTER TABLE `event_zaprosheni` ADD FOREIGN KEY (`zaprosheni_id`) REFERENCES `user` (`id`);

ALTER TABLE `state` ADD FOREIGN KEY (`id`) REFERENCES `mark` (`state`);

ALTER TABLE `state` ADD FOREIGN KEY (`id`) REFERENCES `user` (`state`);
