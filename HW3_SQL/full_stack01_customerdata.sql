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
-- Table structure for table `customerdata`
--

DROP TABLE IF EXISTS `customerdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customerdata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `mail_address` varchar(100) DEFAULT NULL,
  `telephone` varchar(100) DEFAULT NULL,
  `vip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerdata`
--

LOCK TABLES `customerdata` WRITE;
/*!40000 ALTER TABLE `customerdata` DISABLE KEYS */;
INSERT INTO `customerdata` VALUES (1,NULL,'Mary','wo123','1234',NULL,NULL,NULL,NULL),(2,NULL,'Mary01','wo123_01','1234',NULL,NULL,NULL,NULL),(3,NULL,'John','John123','1234','123456','Taipei','12378',NULL),(4,NULL,'Cat','Cat001','123456',NULL,NULL,NULL,NULL),(5,NULL,'Dog','Dog001','123456',NULL,NULL,NULL,NULL),(6,'M-000006','CPU','CPU1234','123456','新北','yahoo','1234665','銀牌會員'),(8,NULL,'Mary','Mart1234','123465',NULL,NULL,NULL,'普通會員'),(9,NULL,'foxy','foxy123','123456',NULL,NULL,NULL,'普通會員'),(10,NULL,'Test','test123','13456',NULL,NULL,NULL,'普通會員'),(11,NULL,'Wu','wu123','123456',NULL,NULL,NULL,'普通會員'),(12,'M-0000012','Wang','Wang1234','123456','新北','gmail','132456','銀牌會員'),(13,'M-0000013','horse','horse123','1234','新北','gmail','132546','銀牌會員'),(14,'M-0000014','fish','fish123','123456','台北','gmail','15616','銀牌會員');
/*!40000 ALTER TABLE `customerdata` ENABLE KEYS */;
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
