-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: coiffeur
-- ------------------------------------------------------
-- Server version	5.6.38-log

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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(50) NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `adress` varchar(100) DEFAULT NULL,
  `postal` varchar(5) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Millemaci','Mikis','Rue des minières 141','59600','Maubeuge','0496/20.40.06'),(2,'Lupant','Morgane','Rue fouquet','7050','Jurbise','0472/27.26.32'),(4,'Crombez','Nathalie',NULL,NULL,NULL,'0000/00.00.00'),(5,'Wautier','Luc',NULL,NULL,NULL,'0000/00.00.00'),(6,'Henry','Thierry',NULL,NULL,NULL,'0000/00.00.00'),(7,'Messi','Lionel',NULL,NULL,NULL,'0000/00.00.00'),(10,'Buffon','Gianluigi',NULL,NULL,NULL,'0000/00.00.00'),(11,'Robert','Pires',NULL,NULL,NULL,'0000/00.00.00'),(13,'Pablo','Escobar',NULL,NULL,NULL,'0000/00.00.00'),(14,'Hernandez','Escobar',NULL,NULL,NULL,'0000/00.00.00'),(15,'Louis','Fernandez',NULL,NULL,NULL,'0000/00.00.00'),(16,'Demeter','Grec',NULL,NULL,NULL,'0000/00.00.00'),(17,'Marie','McFlury',NULL,NULL,NULL,'0000/00.00.00'),(18,'Bonny','Tayler',NULL,NULL,NULL,'0000/00.00.00'),(19,'Ricardo','Delagirouette',NULL,NULL,NULL,'0000/00.00.00'),(20,'Millemaci','Mikis','Rue des minières 141','59600','Maubeuge','0496/20.40.06'),(21,'Lupant','Morgane','Rue fouquet','7050','Jurbise','0472/27.26.32'),(23,'Crombez','Nathalie',NULL,NULL,NULL,'0000/00.00.00'),(24,'Wautier','Luc',NULL,NULL,NULL,'0000/00.00.00'),(25,'Henry','Thierry',NULL,NULL,NULL,'0000/00.00.00'),(26,'Messi','Lionel',NULL,NULL,NULL,'0000/00.00.00'),(29,'Buffon','Gianluigi',NULL,NULL,NULL,'0000/00.00.00'),(30,'Robert','Pires',NULL,NULL,NULL,'0000/00.00.00'),(31,'Karim','Benzema',NULL,NULL,NULL,'0000/00.00.00'),(32,'Pablo','Escobar',NULL,NULL,NULL,'0000/00.00.00'),(33,'Hernandez','Escobar',NULL,NULL,NULL,'0000/00.00.00'),(34,'Louis','Fernandez',NULL,NULL,NULL,'0000/00.00.00'),(35,'Demeter','Grec',NULL,NULL,NULL,'0000/00.00.00'),(36,'Marie','McFlury',NULL,NULL,NULL,'0000/00.00.00'),(37,'Bonny','Tayler',NULL,NULL,NULL,'0000/00.00.00'),(38,'Ricardo','Delagirouette',NULL,NULL,NULL,'0000/00.00.00'),(39,'Millemaci','Mikis','Rue des minières 141','59600','Maubeuge','0496/20.40.06'),(40,'Lupant','Morgane','Rue fouquet','7050','Jurbise','0472/27.26.32'),(42,'Crombez','Nathalie',NULL,NULL,NULL,'0000/00.00.00'),(43,'Wautier','Luc',NULL,NULL,NULL,'0000/00.00.00'),(44,'Henry','Thierry',NULL,NULL,NULL,'0000/00.00.00'),(45,'Messi','Lionel',NULL,NULL,NULL,'0000/00.00.00'),(48,'Buffon','Gianluigi',NULL,NULL,NULL,'0000/00.00.00'),(49,'Robert','Pires',NULL,NULL,NULL,'0000/00.00.00'),(50,'Karim','Benzema',NULL,NULL,NULL,'0000/00.00.00'),(51,'Pablo','Escobar',NULL,NULL,NULL,'0000/00.00.00'),(52,'Hernandez','Escobar',NULL,NULL,NULL,'0000/00.00.00'),(53,'Louis','Fernandez',NULL,NULL,NULL,'0000/00.00.00'),(54,'Demeter','Grec',NULL,NULL,NULL,'0000/00.00.00'),(55,'Marie','McFlury',NULL,NULL,NULL,'0000/00.00.00'),(56,'Bonny','Tayler',NULL,NULL,NULL,'0000/00.00.00'),(57,'Ricardo','Delagirouette',NULL,NULL,NULL,'0000/00.00.00'),(58,'Millemaci','Mikis','Rue des minières 141','59600','Maubeuge','0496/20.40.06'),(59,'Lupant','Morgane','Rue fouquet','7050','Jurbise','0472/27.26.32'),(61,'Crombez','Nathalie',NULL,NULL,NULL,'0000/00.00.00'),(62,'Wautier','Luc',NULL,NULL,NULL,'0000/00.00.00'),(63,'Henry','Thierry',NULL,NULL,NULL,'0000/00.00.00'),(64,'Messi','Lionel',NULL,NULL,NULL,'0000/00.00.00'),(67,'Buffon','Gianluigi',NULL,NULL,NULL,'0000/00.00.00'),(68,'Robert','Pires',NULL,NULL,NULL,'0000/00.00.00'),(69,'Karim','Benzema',NULL,NULL,NULL,'0000/00.00.00'),(70,'Pablo','Escobar',NULL,NULL,NULL,'0000/00.00.00'),(71,'Hernandez','Escobar',NULL,NULL,NULL,'0000/00.00.00'),(72,'Louis','Fernandez',NULL,NULL,NULL,'0000/00.00.00'),(73,'Demeter','Grec',NULL,NULL,NULL,'0000/00.00.00'),(74,'Marie','McFlury',NULL,NULL,NULL,'0000/00.00.00'),(75,'Bonny','Tayler',NULL,NULL,NULL,'0000/00.00.00'),(76,'Ricardo','Delagirouette',NULL,NULL,NULL,'0000/00.00.00'),(77,'Millemaci','Mikis','Rue des minières 141','59600','Maubeuge','0496/20.40.06'),(78,'Lupant','Morgane','Rue fouquet','7050','Jurbise','0472/27.26.32'),(80,'Crombez','Nathalie',NULL,NULL,NULL,'0000/00.00.00'),(81,'Wautier','Luc',NULL,NULL,NULL,'0000/00.00.00'),(82,'Henry','Thierry',NULL,NULL,NULL,'0000/00.00.00'),(83,'Messi','Lionel',NULL,NULL,NULL,'0000/00.00.00'),(86,'Buffon','Gianluigi',NULL,NULL,NULL,'0000/00.00.00'),(87,'Robert','Pires',NULL,NULL,NULL,'0000/00.00.00'),(88,'Karim','Benzema',NULL,NULL,NULL,'0000/00.00.00'),(89,'Pablo','Escobar',NULL,NULL,NULL,'0000/00.00.00'),(90,'Hernandez','Escobar',NULL,NULL,NULL,'0000/00.00.00'),(91,'Louis','Fernandez',NULL,NULL,NULL,'0000/00.00.00'),(92,'Demeter','Grec',NULL,NULL,NULL,'0000/00.00.00'),(93,'Marie','McFlury',NULL,NULL,NULL,'0000/00.00.00'),(94,'Bonny','Tayler',NULL,NULL,NULL,'0000/00.00.00'),(95,'Ricardo','Delagirouette',NULL,NULL,NULL,'0000/00.00.00'),(96,'Millemaci','Mikis','Rue des minières 141','59600','Maubeuge','0496/20.40.06'),(97,'Lupant','Morgane','Rue fouquet','7050','Jurbise','0472/27.26.32'),(99,'Crombez','Nathalie',NULL,NULL,NULL,'0000/00.00.00'),(101,'Wautier','Luc',NULL,NULL,NULL,'0000/00.00.00'),(102,'Henry','Thierry',NULL,NULL,NULL,'0000/00.00.00'),(103,'Messi','Lionel',NULL,NULL,NULL,'0000/00.00.00'),(106,'Buffon','Gianluigi',NULL,NULL,NULL,'0000/00.00.00'),(107,'Robert','Pires',NULL,NULL,NULL,'0000/00.00.00'),(108,'Karim','Benzema',NULL,NULL,NULL,'0000/00.00.00'),(109,'Pablo','Escobar',NULL,NULL,NULL,'0000/00.00.00'),(110,'Hernandez','Escobar',NULL,NULL,NULL,'0000/00.00.00'),(111,'Louis','Fernandez',NULL,NULL,NULL,'0000/00.00.00'),(112,'Demeter','Grec',NULL,NULL,NULL,'0000/00.00.00'),(113,'Marie','McFlury',NULL,NULL,NULL,'0000/00.00.00'),(114,'Bonny','Tayler',NULL,NULL,NULL,'0000/00.00.00'),(115,'Ricardo','Delagirouette',NULL,NULL,NULL,'0000/00.00.00'),(116,'Milano','LeCurde','Rue des champs 15','7000','Mons','0498/20.00.00'),(117,'Mijako','Yuko','','','',''),(120,'Mikis','Millllll','','    ','','8448/41. 1.11'),(121,'Milan','Milan','','    ','','0498/88.88.88'),(122,'Milan','Milanooooooo','','    ','','    /  .  .  '),(123,'Thierry','Armand','Rue des','7111','Mons','0458/55.21.00'),(124,'Jean','Gabin','Rue de','    ','','    /  .  .  '),(125,'Michel','Bertger','Rue de','7000','Mons','0000/00.00.00'),(126,'Thierry','Armand','Rue de','7000','Mons','0000/00.00.00');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-03 21:14:03
