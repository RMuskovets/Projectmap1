DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chas_kinec` datetime NOT NULL COMMENT 'The finish time of the event',
  `name` varchar(255) NOT NULL,
  `chas_pochatok` datetime NOT NULL COMMENT 'The start time of the event',
  `state` int(11) NOT NULL,
  FOREIGN KEY (`state`) REFERENCES `state` (`state_id`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `event_zaprosheni`;
CREATE TABLE `event_zaprosheni` (
  `event_id` int(11) NOT NULL,
  `zaprosheni_id` int(11) NOT NULL COMMENT 'The ID of a user (binding to the "event_id" event)',
  KEY `FK1ogru0488e75xvqs7mxlg2dpb` (`zaprosheni_id`),
  KEY `FKaarctkrq36bqeq3vs3pbqq0i2` (`event_id`),
  CONSTRAINT `FKaarctkrq36bqeq3vs3pbqq0i2` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`),
  CONSTRAINT `FK1ogru0488e75xvqs7mxlg2dpb` FOREIGN KEY (`zaprosheni_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coordx` double NOT NULL COMMENT 'The X coordinate',
  `coordy` double NOT NULL COMMENT 'The Y coordinate',
  `name` varchar(255) NOT NULL,
  `ownerid` int(11) NOT NULL,
  --`typeid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  `state` int(11) NOT NULL,
  FOREIGN KEY (`state`) REFERENCES `state` (`state_id`),
  KEY `FKl4y65527fiucf940f8v8mpg7d` (`ownerid`),
  --KEy `FKl4y65527fiucf940f8v8mpg7e` (`typeid`),
  CONSTRAINT `FKl4y65527fiucf940f8v8mpg7d` FOREIGN KEY (`ownerid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` int(11) NOT NULL,
  FOREIGN KEY (`state`) REFERENCES `state` (`state_id`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `route_marks`;
CREATE TABLE `route_marks` (
  `route_id` int(11) NOT NULL COMMENT 'Route ID',
  `marks_id` int(11) NOT NULL COMMENT 'Current mark ID',
  UNIQUE KEY `UK_fcbj7eowimbrmfm8we2etjkr4` (`marks_id`),
  KEY `FKl4y65527fiucf940f8v8mpg7c` (`route_id`),
  CONSTRAINT `FKl4y65527fiucf940f8v8mpg7c` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`),
  CONSTRAINT `FKhvmaqolulr4y7j8ghblevuba7` FOREIGN KEY (`marks_id`) REFERENCES `mark` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `state` int(11) NOT NULL,
  FOREIGN KEY (`state`) REFERENCES `state` (`state_id`),
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `state` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL DEFAULT systime(),
  `date_deleted` datetime NOT NULL DEFAULT systime(),
  `deleted` bool NOT NULL default false,
  PRIMARY KEY (`state_id`)
);
