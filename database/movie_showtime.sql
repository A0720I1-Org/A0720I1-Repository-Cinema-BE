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
-- Table structure for table `showtime`
--

DROP TABLE IF EXISTS `showtime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showtime` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `day` date DEFAULT NULL,
  `film_technology` varchar(255) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL,
  `time` time DEFAULT NULL,
  `cinema_room_id` bigint DEFAULT NULL,
  `film_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi29w0cmukvrwcfy0rs23p7b7e` (`cinema_room_id`),
  KEY `FK3jhct0oemx9ys5u2e729e10kv` (`film_id`),
  CONSTRAINT `FK3jhct0oemx9ys5u2e729e10kv` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`),
  CONSTRAINT `FKi29w0cmukvrwcfy0rs23p7b7e` FOREIGN KEY (`cinema_room_id`) REFERENCES `cinema_room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showtime`
--

LOCK TABLES `showtime` WRITE;
/*!40000 ALTER TABLE `showtime` DISABLE KEYS */;
INSERT INTO `showtime` VALUES (1,'2021-08-10','2D','Phụ đề','09:05:00',1,1),(16,'2021-08-10','2D','Phụ đề','11:00:00',2,1),(17,'2021-08-10','2D','Phụ đề','16:00:00',2,1),(18,NULL,NULL,NULL,'11:00:00',NULL,NULL),(19,NULL,NULL,NULL,'16:00:00',NULL,NULL),(20,'2021-08-10','3D','Lồng tiếng','13:30:00',3,1),(21,'2021-08-11','2D','Phụ đề','11:00:00',4,1),(22,'2021-08-10','2D','Phụ đề','21:00:00',1,2),(23,'2021-08-10','2D','Phụ đề','23:30:00',1,2),(24,'2021-08-10','2D','Phụ đề','21:00:00',6,3),(25,'2021-08-10','2D','Phụ đề','23:30:00',6,3),(26,'2021-08-12','2D','Phụ đề','11:00:00',3,1),(27,'2021-08-11','2D','Phụ đề','23:30:00',3,1),(28,'2021-08-10','3D','Phụ đề','11:00:00',4,4),(29,'2021-08-10','3D','Phụ đề','23:30:00',4,4),(30,'2021-08-10','2D','Phụ đề','21:00:00',6,5),(31,'2021-08-10','2D','Phụ đề','23:30:00',6,5),(32,'2021-08-10','2D','Phụ đề','11:00:00',1,6),(33,'2021-08-10','2D','Phụ đề','13:30:00',1,6),(34,'2021-08-11','2D','Phụ đề','23:30:00',1,6),(35,'2021-08-12','2D','Phụ đề','23:30:00',1,6),(36,'2021-08-13','2D','Phụ đề','11:00:00',1,6),(37,'2021-08-10','2D','Phụ đề','11:00:00',4,1),(38,'2021-08-10','2D','Phụ đề','16:00:00',4,1);
/*!40000 ALTER TABLE `showtime` ENABLE KEYS */;
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
