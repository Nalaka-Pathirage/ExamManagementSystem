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
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registration` (
  `registration_id` int(11) NOT NULL AUTO_INCREMENT,
  `requested_date_time` datetime NOT NULL,
  `admin_approved` bit(1) DEFAULT b'0',
  `approved_date_time` datetime DEFAULT NULL,
  `payment_amount` double DEFAULT NULL,
  `payment_date_time` datetime DEFAULT NULL,
  `payment_status` bit(1) DEFAULT b'0',
  `mail_sent` bit(1) DEFAULT b'0',
  `registration_status` bit(1) DEFAULT b'0',
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`registration_id`),
  KEY `FK_STUDENT_REG_ID_idx` (`student_id`),
  CONSTRAINT `FK_STUDENT_REG_ID` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES (1,'2022-03-30 03:22:56',_binary '\0','2022-03-30 03:22:56',600000,'2022-03-30 03:22:56',_binary '\0',_binary '\0',_binary '\0',1),(2,'2022-03-30 03:22:56',_binary '','2022-03-30 03:22:56',1000000,'2022-03-30 03:22:56',_binary '\0',_binary '',_binary '\0',2),(3,'2022-03-30 03:22:56',_binary '','2022-03-30 03:22:56',1200000,'2022-03-30 03:22:56',_binary '',_binary '',_binary '',3),(4,'2022-03-30 18:12:47',_binary '\0',NULL,12000,NULL,_binary '\0',_binary '\0',_binary '\0',8);
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
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
