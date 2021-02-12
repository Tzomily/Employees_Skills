CREATE DATABASE IF NOT EXISTS `web_employees_tracker` /*!40100 DEFAULT CHARACTER SET utf8course_student */;
USE `web_employees_tracker`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`(
`id` int NOT NULL auto_increment,
`first_name` varchar(50) DEFAULT NULL,
`last_name` varchar(50) DEFAULT NULL,
`email` varchar(50) DEFAULT NULL,
`phone` varchar(20) DEFAULT NULL,
`address` varchar(100) DEFAULT NULL,
`hiring_date`datetime DEFAULT NULL,
`birth_date`datetime DEFAULT NULL,
`availability` boolean DEFAULT NULL,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `skill`;

CREATE TABLE `skill`(
`skill_id` int NOT NULL auto_increment,
`name` varchar(50) DEFAULT NULL,
`description` varchar(500) DEFAULT NULL,
`creation_date`datetime DEFAULT NULL,
`required` boolean DEFAULT NULL,
PRIMARY KEY (`skill_id`)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `employee_skill`;

CREATE TABLE `employee_skill`(
`employee_id` int NOT NULL,
`skill_id` int NOT NULL,
PRIMARY KEY (`employee_id`,`skill_id`),
CONSTRAINT FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ,
CONSTRAINT FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)

ON DELETE NO ACTION ON UPDATE NO ACTION
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Data for table `employee`
--
LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;

INSERT INTO `employee` VALUES 
	(1,'David','Adams','david@luv2code.com','(30)6978283728','Agiou Pavlou 10','2020-02-15','1965-03-15',TRUE),
	(2,'John','Doe','john@luv2code.com','(30)6965481615','Karaiskaki 64','2020-02-15','1965-03-15',FALSE),
	(3,'Ajay','Rao','ajay@luv2code.com','(30)6954786523','Eleftheriou Venizelou 5','2017-02-15','1942-03-15',TRUE),
	(4,'Mary','Public','mary@luv2code.com','(30)6923154898','Smolenski 32','2018-07-15','2001-03-15',TRUE),
	(5,'Maxwell','Dixon','max@luv2code.com','(30)6923659856','Gounari 55','2019-05-15','1965-03-15',FALSE);
    
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;

INSERT INTO `skill` VALUES 
	(1,'Ethics','moral principles that govern a person\'s behaviour or the conducting of an activity','2017-01-20',TRUE),
	(2,'Time management','the ability to use one\'s time effectively or productively, especially at work','2018-01-20',TRUE),
	(3,'Communication','the imparting or exchanging of information by speaking, writing, or using some other medium','2018-01-20',FALSE),
	(4,'Collaboration','the action of working with someone to produce something','2017-01-20',TRUE),
	(5,'Problem solving','The process of finding solutions to difficult or complex issues','2017-01-20',FALSE);
    
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `employee_skill` WRITE;
/*!40000 ALTER TABLE `employee_skill` DISABLE KEYS */;

INSERT INTO `employee_skill` VALUES 
	(5,1),
	(5,2),
	(5,4),
	(3,1),
    (3,5),
    (2,2);
    
/*!40000 ALTER TABLE `employee_skill` ENABLE KEYS */;
UNLOCK TABLES;

SET FOREIGN_KEY_CHECKS = 1;

