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
-- Table structure for table `cinema_room`
--

DROP TABLE IF EXISTS `cinema_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinema_room` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `column_seat` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `row_seat` int NOT NULL,
  `seat_layout` varchar(255) DEFAULT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema_room`
--

LOCK TABLES `cinema_room` WRITE;
/*!40000 ALTER TABLE `cinema_room` DISABLE KEYS */;
INSERT INTO `cinema_room` VALUES (1,12,'PC01',6,'ssnssssssnssssnssssssnssssnssssssnssssnssssssnssvvnvvvvvvnvvvvvvvvvvvvvv',1),(2,12,'PC02',9,'ssnssssssnssssnssssssnssssnssssssnssssnssssssnssssnssssssnssvvnvvvvvvnvvvvnvvvvvvnvvnnnnnnnnnnnnvvvvvvvvvvvv',1),(3,13,'PC03',10,'ssnsssssssnssssnsssssssnssssnsssssssnssssnsssssssnssvvvvvvvvvvnvvvvvvvvvvvvnvvvvvvvvvvvvnvvvvvvvvvvvvnvvvvvvvvvvvvnvvvvvvvvvvvvnvvvvvvvvvvvvdvv',1),(4,11,'PC04',8,'sssssnssssssssssnssssssssssnssssssssssnsssssvvvvvnvvvvvvvvvvnvvvvvvvvvvnvvvvvvvvvvnvvvvv',1),(5,8,'PC05',8,'ssssssssssssssssssssssssvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv',1),(6,9,'PC06',9,'vvvvnvvvvvvvvnvvvvvvvvnvvvvvvvvnvvvvvvvvnvvvvvvvvnvvvvvvvvnvvvvvvvvnvvvvvvvvnvvvv',1),(7,10,'PC07',10,'ssnssnssnsssnssnssnsssnssnssnsssnssnssnsvvnvvnvvnvvvnvvnvvnvvvnvvnvvnvvvnvvnvvnvvvnvvnvvnvvvnvvnvvnv',1),(8,2,'PC08',2,'ssvd',1),(9,3,'PC09',2,'sssvvd',1),(10,4,'PC10',2,'ssssvvvv',0),(11,5,'PC11',2,'sssssvvvvv',0),(12,2,'PC12',2,'ssvv',1),(13,2,'PC13',2,'vvss',1),(14,2,'PC14',2,'vvss',1),(15,2,'PC15',2,'ssvv',0),(16,3,'PC16',3,'vvssss',1),(17,2,'PC17',2,'vvss',1);
/*!40000 ALTER TABLE `cinema_room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-14 10:37:29
