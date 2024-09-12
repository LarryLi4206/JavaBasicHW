CREATE DATABASE  IF NOT EXISTS `full_stack01` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `full_stack01`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: full_stack01
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `memberdata`
--

DROP TABLE IF EXISTS `memberdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `memberdata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_id` varchar(100) DEFAULT NULL,
  `position` varchar(100) DEFAULT NULL,
  `member_name` varchar(100) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `mail_address` varchar(100) DEFAULT NULL,
  `telephone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberdata`
--

LOCK TABLES `memberdata` WRITE;
/*!40000 ALTER TABLE `memberdata` DISABLE KEYS */;
INSERT INTO `memberdata` VALUES (1,'Test','test','test',NULL,NULL,NULL,NULL,NULL),(2,'BO000002','老闆','Jack','BO000002','BO000002','新北','yahoo','132465'),(3,'PE000003','人事部','Mary','PE000003','PE000003','台北','gmail','132463'),(4,'PE000004','人事部','Cathy','PE000004','PE000004','新北','gmail','2635463'),(5,'CA000005','會計部','John','CA000005','CA000005','新竹','gmail','152463'),(6,'NO000006','普通員工','man01','NO000006','NO000006','台北','yahoo','3216354'),(7,'NO000007','普通員工','man02','NO000007','NO000007','新竹','gmail','646132'),(8,'PI000008','資訊部','Mike','PI000008','PI000008','桃園','gmail','23310324'),(9,'CA000009','會計部','Jack','CA000009','CA000009','新竹','gmail','132462316'),(10,'OW000010','外勤人員','man03','OW000010','OW000010','新竹','yahoo','1444361'),(11,'SP000011','行銷部','man04','SP000011','SP000011','新北','gmail','241636'),(12,'BO000012','老闆','rabbit','BO000012','BO000012','新北','yahoo','132456');
/*!40000 ALTER TABLE `memberdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-13  0:43:26
