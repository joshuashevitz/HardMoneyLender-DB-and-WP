CREATE DATABASE  IF NOT EXISTS `COSC457` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `COSC457`;
-- MySQL dump 10.13  Distrib 5.7.29-ndb-7.6.13, for Linux (x86_64)
--
-- Host: localhost    Database: COSC457
-- ------------------------------------------------------
-- Server version	5.7.29-ndb-7.6.13

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
-- Table structure for table `View`
--

DROP TABLE IF EXISTS `View`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `View` (
  `employeeSsn` int(9) NOT NULL,
  `applicantId` int(5) unsigned zerofill NOT NULL,
  PRIMARY KEY (`employeeSsn`,`applicantId`),
  KEY `View_Experience_idx` (`applicantId`),
  CONSTRAINT `View_Experience` FOREIGN KEY (`applicantId`) REFERENCES `Experience` (`applicantId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `View_Finances` FOREIGN KEY (`applicantId`) REFERENCES `Finances` (`applicantId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `View_Property` FOREIGN KEY (`applicantId`) REFERENCES `Property` (`applicantId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Who_Viewed` FOREIGN KEY (`employeeSsn`) REFERENCES `Employee` (`ssn`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `View`
--

LOCK TABLES `View` WRITE;
/*!40000 ALTER TABLE `View` DISABLE KEYS */;
INSERT INTO `View` VALUES (111223333,00001);
/*!40000 ALTER TABLE `View` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-29  0:21:26
