DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chas_kinec` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `chas_pochatok` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `event_zaprosheni`;
CREATE TABLE `event_zaprosheni` (
  `event_id` int(11) NOT NULL,
  `zaprosheni_id` int(11) NOT NULL,
  KEY `FK1ogru0488e75xvqs7mxlg2dpb` (`zaprosheni_id`),
  KEY `FKaarctkrq36bqeq3vs3pbqq0i2` (`event_id`),
  CONSTRAINT `FKaarctkrq36bqeq3vs3pbqq0i2` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`),
  CONSTRAINT `FK1ogru0488e75xvqs7mxlg2dpb` FOREIGN KEY (`zaprosheni_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
LOCK TABLES `hibernate_sequence` WRITE;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1),(1),(1);
UNLOCK TABLES;

DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coordx` double NOT NULL,
  `coordy` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ownerid` int(11) DEFAULT NULL,
  `typeid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `route_marks`;
CREATE TABLE `route_marks` (
  `route_id` int(11) NOT NULL,
  `marks_id` int(11) NOT NULL,
  UNIQUE KEY `UK_fcbj7eowimbrmfm8we2etjkr4` (`marks_id`),
  KEY `FKl4y65527fiucf940f8v8mpg7c` (`route_id`),
  CONSTRAINT `FKl4y65527fiucf940f8v8mpg7c` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`),
  CONSTRAINT `FKhvmaqolulr4y7j8ghblevuba7` FOREIGN KEY (`marks_id`) REFERENCES `mark` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parentid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into type (name) VALUES ('USER');
insert into type (name, parentid) VALUES ('GUEST', 0);
insert into type (name, parentid) VALUES ('REGISTERED', 0);
insert into type (name, parentid) VALUES ('MODERATOR', 0);
insert into type (name, parentid) VALUES ('ADMINISTRATOR', 0);
insert into type (name, parentid) VALUES ('OWNER', 0);

insert into user (type, username, password) VALUES (1, 'GUEST', '');
insert into user (type, username, password) VALUES (2, 'JOHNDOE', 'JOHNDOE');
insert into user (type, username, password) VALUES (2, 'JANEDOE', 'JANEDOE');
insert into user (type, username, password) VALUES (2, 'USER', 'USER');
insert into user (type, username, password) VALUES (3, 'MODER', 'MODER');
insert into user (type, username, password) VALUES (4, 'ADMIN', 'ADMIN');
insert into user (type, username, password) VALUES (5, 'PyThon4g', 'PyThon4g');
insert into user (type, username, password) VALUES (5, 'RoiMan', '164352');
insert into user (type, username, password) VALUES (2, '..USER..NOT..EXISTS..', '?');
insert into user (type, username, password) VALUES (2, '?', '?');
insert into user (type, username, password) VALUES (2, '', '');
insert into user (type, username, password) VALUES (2, '+-*/', 'math');
