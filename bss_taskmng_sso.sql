-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: soetest
-- ------------------------------------------------------
-- Server version	5.5.59

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
-- Table structure for table `table_list`
--

DROP TABLE IF EXISTS `table_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_list` (
  `list_id` int(11) NOT NULL AUTO_INCREMENT,
  `list_name` varchar(45) DEFAULT NULL,
  `board_list_id` int(11) NOT NULL,
  PRIMARY KEY (`list_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_list`
--

LOCK TABLES `table_list` WRITE;
/*!40000 ALTER TABLE `table_list` DISABLE KEYS */;
INSERT INTO `table_list` VALUES (1,'New List',5),(2,'CRM to ERP',3),(3,'Hello',3),(4,'CRM',6),(5,'MyTest',6),(6,'Python',6);
/*!40000 ALTER TABLE `table_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_team`
--

DROP TABLE IF EXISTS `table_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_team` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(150) DEFAULT NULL,
  `team_description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_team`
--

LOCK TABLES `table_team` WRITE;
/*!40000 ALTER TABLE `table_team` DISABLE KEYS */;
INSERT INTO `table_team` VALUES (1,'Team Update','Team Description'),(2,'CRM','Android'),(5,'Python','PT'),(6,'Odoo','Git'),(7,'Odoo','Team 7 Description'),(9,'MyTest','Hello');
/*!40000 ALTER TABLE `table_team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-21 18:16:55
