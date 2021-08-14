-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: movie
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `membership`
--

DROP TABLE IF EXISTS `membership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `membership` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birthday` date DEFAULT NULL,
  `card` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `member_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  `ward_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd1yliqdvipm4yvq2tulbktpg6` (`account_id`),
  KEY `FKfr5yy2khvg0ilrum70qbyc7l3` (`ward_id`),
  CONSTRAINT `FKd1yliqdvipm4yvq2tulbktpg6` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKfr5yy2khvg0ilrum70qbyc7l3` FOREIGN KEY (`ward_id`) REFERENCES `ward` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membership`
--

LOCK TABLES `membership` WRITE;
/*!40000 ALTER TABLE `membership` DISABLE KEYS */;
INSERT INTO `membership` VALUES (1,'2002-12-03','201753457','phat.thanh.113@gmail.com','Nam','https://firebasestorage.googleapis.com/v0/b/a0720i1-cinema.appspot.com/o/09-08-2021011456AMScreenshot%20(3).png?alt=media&token=e2c35276-15b8-42bf-b6c5-9383753c1b1b','4986-4197-2440-3110','Thành Phát Đỗ','0702767842',4,9829),(2,'2002-12-03','201853457','phat.thanh@gmail.com','Nam','https://firebasestorage.googleapis.com/v0/b/a0720i1-cinema.appspot.com/o/09-08-2021011456AMScreenshot%20(3).png?alt=media&token=e2c35276-15b8-42bf-b6c5-9383753c1b1b','4986-4197-2440-3111','Thành Phát Đỗ','0702767843',5,1),(3,'2001-03-11','2012121212','thanhphat110398@gmail.com','Nam',NULL,'8384-7450-4429-2814','Hoàng Long','0702761242',6,20194),(4,'2001-03-11','2012121213','dop070619@gmail.com','Nam',NULL,'4822-8064-1216-8469','Minh Hoàng','0702761252',7,1),(5,'1998-03-11','201953457','dophat110398@gmail.com','Nam',NULL,'9892-1598-9684-7208','Thành Phát','0702767847',8,20332);
/*!40000 ALTER TABLE `membership` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-14 10:37:30
