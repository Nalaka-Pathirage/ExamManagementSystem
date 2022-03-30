-- MySQL dump 10.13  Distrib 5.7.37, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: exam_management_schema
-- ------------------------------------------------------
-- Server version	5.7.37-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `coodinator_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_name`),
  KEY `FK_ADMIN_ID_idx` (`admin_id`),
  KEY `FK_LOGIN_COORDINATOR_idx` (`coodinator_id`),
  KEY `FK_LOGIN_STUDENT_idx` (`student_id`),
  CONSTRAINT `FK_LOGIN_ADMIN` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_LOGIN_COORDINATOR` FOREIGN KEY (`coodinator_id`) REFERENCES `coodinator` (`coordinator_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_LOGIN_STUDENT` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('ashok@gmail.com','secret',NULL,NULL,1),('difsfsfan@gmail.com','secret',NULL,NULL,8),('dilshan@gmail.com','secret',NULL,1,NULL),('helan@gmail.com','secret',1,NULL,NULL),('nirmal@gmail.com','secret',NULL,NULL,2),('tehan@gmail.com','secret',NULL,NULL,3);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-30 19:40:15
