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
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `province` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (1,'Thành Phố Hà Nội'),(2,'Tỉnh Hà Giang'),(4,'Tỉnh Cao Bằng'),(6,'Tỉnh Bắc Kạn'),(8,'Tỉnh Tuyên Quang'),(10,'Tỉnh Lào Cai'),(11,'Tỉnh Điện Biên'),(12,'Tỉnh Lai Châu'),(14,'Tỉnh Sơn La'),(15,'Tỉnh Yên Bái'),(17,'Tỉnh Hòa Bình'),(19,'Tỉnh Thái Nguyên'),(20,'Tỉnh Lạng Sơn'),(22,'Tỉnh Quảng Ninh'),(24,'Tỉnh Bắc Giang'),(25,'Tỉnh Phú Thọ'),(26,'Tỉnh Vĩnh Phúc'),(27,'Tỉnh Bắc Ninh'),(30,'Tỉnh Hải Dương'),(31,'Thành Phố Hải Phòng'),(33,'Tỉnh Hưng Yên'),(34,'Tỉnh Thái Bình'),(35,'Tỉnh Hà Nam'),(36,'Tỉnh Nam Định'),(37,'Tỉnh Ninh Bình'),(38,'Tỉnh Thanh Hóa'),(40,'Tỉnh Nghệ An'),(42,'Tỉnh Hà Tĩnh'),(44,'Tỉnh Quảng Bình'),(45,'Tỉnh Quảng Trị'),(46,'Tỉnh Thừa Thiên Huế'),(48,'Thành Phố Đà Nẵng'),(49,'Tỉnh Quảng Nam'),(51,'Tỉnh Quảng Ngãi'),(52,'Tỉnh Bình Định'),(54,'Tỉnh Phú Yên'),(56,'Tỉnh Khánh Hòa'),(58,'Tỉnh Ninh Thuận'),(60,'Tỉnh Bình Thuận'),(62,'Tỉnh Kon Tum'),(64,'Tỉnh Gia Lai'),(66,'Tỉnh Đắk Lắk'),(67,'Tỉnh Đắk Nông'),(68,'Tỉnh Lâm Đồng'),(70,'Tỉnh Bình Phước'),(72,'Tỉnh Tây Ninh'),(74,'Tỉnh Bình Dương'),(75,'Tỉnh Đồng Nai'),(77,'Tỉnh Bà Rịa - Vũng Tàu'),(79,'Thành Phố Hồ Chí Minh'),(80,'Tỉnh Long An'),(82,'Tỉnh Tiền Giang'),(83,'Tỉnh Bến Tre'),(84,'Tỉnh Trà Vinh'),(86,'Tỉnh Vĩnh Long'),(87,'Tỉnh Đồng Tháp'),(89,'Tỉnh An Giang'),(91,'Tỉnh Kiên Giang'),(92,'Thành Phố Cần Thơ'),(93,'Tỉnh Hậu Giang'),(94,'Tỉnh Sóc Trăng'),(95,'Tỉnh Bạc Liêu'),(96,'Tỉnh Cà Mau');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
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
