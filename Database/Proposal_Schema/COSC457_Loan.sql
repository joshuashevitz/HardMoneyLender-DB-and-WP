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
-- Table structure for table `Loan`
--

DROP TABLE IF EXISTS `Loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Loan` (
  `loanId` int(11) NOT NULL,
  `applicantSsn` int(9) NOT NULL,
  `reviewerSsn` int(9) NOT NULL,
  `percentForConstruction` int(2) NOT NULL,
  `percentForPurchase` int(2) NOT NULL,
  `purchasePrice` int(10) NOT NULL,
  `timeTable` blob NOT NULL,
  `constructionBudget` blob NOT NULL,
  PRIMARY KEY (`loanId`,`applicantSsn`),
  KEY `Whose_Loan_idx` (`applicantSsn`),
  KEY `Who_Reviews_idx` (`reviewerSsn`),
  CONSTRAINT `Who_Reviews` FOREIGN KEY (`reviewerSsn`) REFERENCES `Employee` (`ssn`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Whose_Loan` FOREIGN KEY (`applicantSsn`) REFERENCES `Applicant` (`ssn`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Loan`
--

LOCK TABLES `Loan` WRITE;
/*!40000 ALTER TABLE `Loan` DISABLE KEYS */;
/*!40000 ALTER TABLE `Loan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-19 20:49:26
