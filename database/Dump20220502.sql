CREATE DATABASE  IF NOT EXISTS `exam_management_schema` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `exam_management_schema`;
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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(45) NOT NULL,
  `admin_nic` varchar(45) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Helan','894567333v');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attempt`
--

DROP TABLE IF EXISTS `attempt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attempt` (
  `student_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `attempted_on` datetime NOT NULL,
  `marks` varchar(45) NOT NULL,
  `pass_fail` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`student_id`,`exam_id`),
  KEY `FK_EXAM_QUIZ_ATTEMPT_ID` (`exam_id`),
  CONSTRAINT `FK_EXAM_QUIZ_ATTEMPT_ID` FOREIGN KEY (`exam_id`) REFERENCES `exam_quiz` (`exam_quiz_id`),
  CONSTRAINT `FK_STUDENT_ATTEMPT_ID` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attempt`
--

LOCK TABLES `attempt` WRITE;
/*!40000 ALTER TABLE `attempt` DISABLE KEYS */;
INSERT INTO `attempt` VALUES (2,4,'2022-04-28 13:40:54','33.33',_binary '\0'),(2,7,'2022-04-28 14:17:12','100.0',_binary '');
/*!40000 ALTER TABLE `attempt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `batch`
--

DROP TABLE IF EXISTS `batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `batch` (
  `batch_id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_name` varchar(45) NOT NULL,
  `batch_code` varchar(45) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`batch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch`
--

LOCK TABLES `batch` WRITE;
/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
INSERT INTO `batch` VALUES (1,'MS-CS-WD-B01','MSCSWDB2022',1),(2,'BS-CS-WD-B01','BSCSWDB2022',2);
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coodinator`
--

DROP TABLE IF EXISTS `coodinator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coodinator` (
  `coordinator_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `nic` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  PRIMARY KEY (`coordinator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coodinator`
--

LOCK TABLES `coodinator` WRITE;
/*!40000 ALTER TABLE `coodinator` DISABLE KEYS */;
INSERT INTO `coodinator` VALUES (2,'wefwef','wefwefwe','wefwefwe','wefwefwe'),(3,'eqweq','eqweq','eqwedq','deqwdqw'),(4,'dqwdqw','dwdqwd','wdqw','dwqdq'),(9,'Dilshan','Weerasinghe','893232007v','+94774354654');
/*!40000 ALTER TABLE `coodinator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `duration` double NOT NULL,
  `start` date NOT NULL,
  `description` varchar(220) NOT NULL,
  `fee` double NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'COMPM001','Msc. Computer Science',2,'2022-03-30','Offered by university of Curtin.',600000),(2,'COMPB001','Bsc. Computer Science',4,'2022-03-30','Offered by university of Curtin.',1200000),(3,'SEB000019','Bsc. Software Engineering',3,'2022-03-30','Offered by university of Curtin.',1000000);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_quiz`
--

DROP TABLE IF EXISTS `exam_quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_quiz` (
  `exam_quiz_id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_quiz_name` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `added_on` datetime NOT NULL,
  `added_by` int(11) DEFAULT NULL,
  `questions` text NOT NULL,
  `subject_id` int(11) NOT NULL,
  PRIMARY KEY (`exam_quiz_id`),
  KEY `fk_exam_quiz_1_idx` (`subject_id`),
  KEY `FK_EXAM_QUIZ_ADDED_BY_idx` (`added_by`),
  CONSTRAINT `FK_EXAM_QUIZ_ADDED_BY` FOREIGN KEY (`added_by`) REFERENCES `coodinator` (`coordinator_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_EXAM_QUIZ_SUBJECT_ID` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_quiz`
--

LOCK TABLES `exam_quiz` WRITE;
/*!40000 ALTER TABLE `exam_quiz` DISABLE KEYS */;
INSERT INTO `exam_quiz` VALUES (4,'MockQuiz1','Q','2022-04-27 15:55:31',9,'{\"questions\":[{\"questionNumber\":1,\"question\":\"Is this first question ?\",\"answers\":{\"1\":\"first answer\",\"2\":\"second answer\",\"3\":\"third answer\",\"4\":\"fourth answer\",\"5\":\" fifth answer\"},\"correctAnswer\":1},{\"questionNumber\":2,\"question\":\"Is this second question ?\",\"answers\":{\"1\":\"first answer\",\"2\":\"second answer\",\"3\":\"third answer\",\"4\":\"fourth answer\",\"5\":\" fifth answer\"},\"correctAnswer\":2},{\"questionNumber\":3,\"question\":\"Is this third question ?\",\"answers\":{\"1\":\"first answer\",\"2\":\"second answer\",\"3\":\"third answer\",\"4\":\"fourth answer\",\"5\":\" fifth answer\"},\"correctAnswer\":3}]}',1),(7,'MockExam01','E','2022-04-27 18:14:28',9,'{\"questions\":[{\"questionNumber\":1,\"question\":\"Is this first question ?\",\"answers\":{\"1\":\"first answer\",\"2\":\"second answer\",\"3\":\"third answer\",\"4\":\"fourth answer\",\"5\":\"fifth answer\"},\"correctAnswer\":1},{\"questionNumber\":2,\"question\":\"Is this second question ?\",\"answers\":{\"1\":\"first answer\",\"2\":\"second answer\",\"3\":\"third answer\",\"4\":\"fourth answer\",\"5\":\"fifth answer\"},\"correctAnswer\":2},{\"questionNumber\":3,\"question\":\"Is this third question ?\",\"answers\":{\"1\":\"first answer\",\"2\":\"second answer\",\"3\":\"third answer\",\"4\":\"fourth answer\",\"5\":\"fifth answer\"},\"correctAnswer\":3}]}',1);
/*!40000 ALTER TABLE `exam_quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lecturer` (
  `lecturer_id` int(11) NOT NULL AUTO_INCREMENT,
  `lecturer_name` varchar(45) NOT NULL,
  `subject_stream` varchar(45) NOT NULL,
  `highest_qualification` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `subject_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`lecturer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecturer`
--

LOCK TABLES `lecturer` WRITE;
/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` VALUES (1,'Nuwan Kodagoda','Computer Science','PhD, Computer Science','+94703225679',1);
/*!40000 ALTER TABLE `lecturer` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `FK_LOGIN_ADMIN` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_LOGIN_COORDINATOR` FOREIGN KEY (`coodinator_id`) REFERENCES `coodinator` (`coordinator_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_LOGIN_STUDENT` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('ashok@gmail.com','secret',NULL,NULL,1),('dilshan@gmail.com','secret',NULL,9,NULL),('helan@gmail.com','secret',1,NULL,NULL),('nirmal@gmail.com','secret',NULL,NULL,2),('tehan@gmail.com','secret',NULL,NULL,3);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

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
  `payment_receipt` longblob,
  PRIMARY KEY (`registration_id`),
  KEY `FK_STUDENT_REG_ID_idx` (`student_id`),
  CONSTRAINT `FK_STUDENT_REG_ID` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES (1,'2022-03-30 03:22:56',_binary '\0',NULL,600000,NULL,_binary '\0',_binary '\0',_binary '\0',1,NULL),(2,'2022-03-30 03:22:56',_binary '','2022-03-30 03:22:56',1000000,'2022-03-30 03:22:56',_binary '',_binary '',_binary '',2,NULL),(3,'2022-03-30 03:22:56',_binary '','2022-03-30 03:22:56',1200000,NULL,_binary '\0',_binary '',_binary '\0',3,NULL);
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `nic` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `course_id` int(11) NOT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK_STUDENT_COURSE_ID_idx` (`course_id`),
  CONSTRAINT `FK_STUDENT_COURSE_ID` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Ashoka','Silva','967583445v','+94070985674',1,'No 56, Deans rd, Colombo 03'),(2,'Nirmal','Rajapaksha','995436780v','+94708965748',2,'No 78, Patrick rd, Colombo 07'),(3,'Tehan','Perara','973453496v','+94708943521',3,'No 88, Lavinia rd, Colombo 05');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(45) NOT NULL,
  `subject_code` varchar(45) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `FK_SUBJECT_COURSE_ID_idx` (`course_id`),
  CONSTRAINT `FK_SUBJECT_COURSE_ID` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'MockSubject1','MOCK001',NULL),(2,'MockSubject02','MOCK002',3);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-02 14:10:03
