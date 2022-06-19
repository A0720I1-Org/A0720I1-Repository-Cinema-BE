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
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `district` (
  `id` int NOT NULL AUTO_INCREMENT,
  `province_id` int DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK276utu38g5lgqeth6pwfm3rw2` (`province_id`),
  CONSTRAINT `FK276utu38g5lgqeth6pwfm3rw2` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=974 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,1,'Quận Ba Đình'),(2,1,'Quận Hoàn Kiếm'),(3,1,'Quận Tây Hồ'),(4,1,'Quận Long Biên'),(5,1,'Quận Cầu Giấy'),(6,1,'Quận Đống Đa'),(7,1,'Quận Hai Bà Trưng'),(8,1,'Quận Hoàng Mai'),(9,1,'Quận Thanh Xuân'),(16,1,'Huyện Sóc Sơn'),(17,1,'Huyện Đông Anh'),(18,1,'Huyện Gia Lâm'),(19,1,'Huyện Từ Liêm'),(20,1,'Huyện Thanh Trì'),(24,2,'Thị Xã Hà Giang'),(26,2,'Huyện Đồng Văn'),(27,2,'Huyện Mèo Vạc'),(28,2,'Huyện Yên Minh'),(29,2,'Huyện Quản Bạ'),(30,2,'Huyện Vị Xuyên'),(31,2,'Huyện Bắc Mê'),(32,2,'Huyện Hoàng Su Phì'),(33,2,'Huyện Xín Mần'),(34,2,'Huyện Bắc Quang'),(35,2,'Huyện Quang Bình'),(40,4,'Thị Xã Cao Bằng'),(42,4,'Huyện Bảo Lâm'),(43,4,'Huyện Bảo Lạc'),(44,4,'Huyện Thông Nông'),(45,4,'Huyện Hà Quảng'),(46,4,'Huyện Trà Lĩnh'),(47,4,'Huyện Trùng Khánh'),(48,4,'Huyện Hạ Lang'),(49,4,'Huyện Quảng Uyên'),(50,4,'Huyện Phục Hoà'),(51,4,'Huyện Hoà An'),(52,4,'Huyện Nguyên Bình'),(53,4,'Huyện Thạch An'),(58,6,'Thị Xã Bắc Kạn'),(60,6,'Huyện Pác Nặm'),(61,6,'Huyện Ba Bể'),(62,6,'Huyện Ngân Sơn'),(63,6,'Huyện Bạch Thông'),(64,6,'Huyện Chợ Đồn'),(65,6,'Huyện Chợ Mới'),(66,6,'Huyện Na Rì'),(70,8,'Thị Xã Tuyên Quang'),(72,8,'Huyện Nà Hang'),(73,8,'Huyện Chiêm Hóa'),(74,8,'Huyện Hàm Yên'),(75,8,'Huyện Yên Sơn'),(76,8,'Huyện Sơn Dương'),(80,10,'Thành Phố Lào Cai'),(82,10,'Huyện Bát Xát'),(83,10,'Huyện Mường Khương'),(84,10,'Huyện Si Ma Cai'),(85,10,'Huyện Bắc Hà'),(86,10,'Huyện Bảo Thắng'),(87,10,'Huyện Bảo Yên'),(88,10,'Huyện Sa Pa'),(89,10,'Huyện Văn Bàn'),(94,11,'Thành Phố Điện Biên Phủ'),(95,11,'Thị Xã Mường Lay'),(96,11,'Huyện Mường Nhé'),(97,11,'Huyện Mường Chà'),(98,11,'Huyện Tủa Chùa'),(99,11,'Huyện Tuần Giáo'),(100,11,'Huyện Điện Biên'),(101,11,'Huyện Điện Biên Đông'),(102,11,'Huyện Mường Ảng'),(104,12,'Thị Xã Lai Châu'),(106,12,'Huyện Tam Đường'),(107,12,'Huyện Mường Tè'),(108,12,'Huyện Sìn Hồ'),(109,12,'Huyện Phong Thổ'),(110,12,'Huyện Than Uyên'),(111,12,'Huyện Tân Uyên'),(116,14,'Thành Phố Sơn La'),(118,14,'Huyện Quỳnh Nhai'),(119,14,'Huyện Thuận Châu'),(120,14,'Huyện Mường La'),(121,14,'Huyện Bắc Yên'),(122,14,'Huyện Phù Yên'),(123,14,'Huyện Mộc Châu'),(124,14,'Huyện Yên Châu'),(125,14,'Huyện Mai Sơn'),(126,14,'Huyện Sông Mã'),(127,14,'Huyện Sốp Cộp'),(132,15,'Thành Phố Yên Bái'),(133,15,'Thị Xã Nghĩa Lộ'),(135,15,'Huyện Lục Yên'),(136,15,'Huyện Văn Yên'),(137,15,'Huyện Mù Cang Chải'),(138,15,'Huyện Trấn Yên'),(139,15,'Huyện Trạm Tấu'),(140,15,'Huyện Văn Chấn'),(141,15,'Huyện Yên Bình'),(148,17,'Thành Phố Hòa Bình'),(150,17,'Huyện Đà Bắc'),(151,17,'Huyện Kỳ Sơn'),(152,17,'Huyện Lương Sơn'),(153,17,'Huyện Kim Bôi'),(154,17,'Huyện Cao Phong'),(155,17,'Huyện Tân Lạc'),(156,17,'Huyện Mai Châu'),(157,17,'Huyện Lạc Sơn'),(158,17,'Huyện Yên Thủy'),(159,17,'Huyện Lạc Thủy'),(164,19,'Thành Phố Thái Nguyên'),(165,19,'Thị Xã Sông Công'),(167,19,'Huyện Định Hóa'),(168,19,'Huyện Phú Lương'),(169,19,'Huyện Đồng Hỷ'),(170,19,'Huyện Võ Nhai'),(171,19,'Huyện Đại Từ'),(172,19,'Huyện Phổ Yên'),(173,19,'Huyện Phú Bình'),(178,20,'Thành Phố Lạng Sơn'),(180,20,'Huyện Tràng Định'),(181,20,'Huyện Bình Gia'),(182,20,'Huyện Văn Lãng'),(183,20,'Huyện Cao Lộc'),(184,20,'Huyện Văn Quan'),(185,20,'Huyện Bắc Sơn'),(186,20,'Huyện Hữu Lũng'),(187,20,'Huyện Chi Lăng'),(188,20,'Huyện Lộc Bình'),(189,20,'Huyện Đình Lập'),(193,22,'Thành Phố Hạ Long'),(194,22,'Thành Phố Móng Cái'),(195,22,'Thị Xã Cẩm Phả'),(196,22,'Thị Xã Uông Bí'),(198,22,'Huyện Bình Liêu'),(199,22,'Huyện Tiên Yên'),(200,22,'Huyện Đầm Hà'),(201,22,'Huyện Hải Hà'),(202,22,'Huyện Ba Chẽ'),(203,22,'Huyện Vân Đồn'),(204,22,'Huyện Hoành Bồ'),(205,22,'Huyện Đông Triều'),(206,22,'Huyện Yên Hưng'),(207,22,'Huyện Cô Tô'),(213,24,'Thành Phố Bắc Giang'),(215,24,'Huyện Yên Thế'),(216,24,'Huyện Tân Yên'),(217,24,'Huyện Lạng Giang'),(218,24,'Huyện Lục Nam'),(219,24,'Huyện Lục Ngạn'),(220,24,'Huyện Sơn Động'),(221,24,'Huyện Yên Dũng'),(222,24,'Huyện Việt Yên'),(223,24,'Huyện Hiệp Hòa'),(227,25,'Thành Phố Việt Trì'),(228,25,'Thị Xã Phú Thọ'),(230,25,'Huyện Đoan Hùng'),(231,25,'Huyện Hạ Hoà'),(232,25,'Huyện Thanh Ba'),(233,25,'Huyện Phù Ninh'),(234,25,'Huyện Yên Lập'),(235,25,'Huyện Cẩm Khê'),(236,25,'Huyện Tam Nông'),(237,25,'Huyện Lâm Thao'),(238,25,'Huyện Thanh Sơn'),(239,25,'Huyện Thanh Thuỷ'),(240,25,'Huyện Tân Sơn'),(243,26,'Thành Phố Vĩnh Yên'),(244,26,'Thị Xã Phúc Yên'),(246,26,'Huyện Lập Thạch'),(247,26,'Huyện Tam Dương'),(248,26,'Huyện Tam Đảo'),(249,26,'Huyện Bình Xuyên'),(250,1,'Huyện Mê Linh'),(251,26,'Huyện Yên Lạc'),(252,26,'Huyện Vĩnh Tường'),(253,26,'Huyện Sông Lô'),(256,27,'Thành Phố Bắc Ninh'),(258,27,'Huyện Yên Phong'),(259,27,'Huyện Quế Võ'),(260,27,'Huyện Tiên Du'),(261,27,'Thị Xã Từ Sơn'),(262,27,'Huyện Thuận Thành'),(263,27,'Huyện Gia Bình'),(264,27,'Huyện Lương Tài'),(268,1,'Quận Hà Đông'),(269,1,'Thị Xã Sơn Tây'),(271,1,'Huyện Ba Vì'),(272,1,'Huyện Phúc Thọ'),(273,1,'Huyện Đan Phượng'),(274,1,'Huyện Hoài Đức'),(275,1,'Huyện Quốc Oai'),(276,1,'Huyện Thạch Thất'),(277,1,'Huyện Chương Mỹ'),(278,1,'Huyện Thanh Oai'),(279,1,'Huyện Thường Tín'),(280,1,'Huyện Phú Xuyên'),(281,1,'Huyện Ứng Hòa'),(282,1,'Huyện Mỹ Đức'),(288,30,'Thành Phố Hải Dương'),(290,30,'Huyện Chí Linh'),(291,30,'Huyện Nam Sách'),(292,30,'Huyện Kinh Môn'),(293,30,'Huyện Kim Thành'),(294,30,'Huyện Thanh Hà'),(295,30,'Huyện Cẩm Giàng'),(296,30,'Huyện Bình Giang'),(297,30,'Huyện Gia Lộc'),(298,30,'Huyện Tứ Kỳ'),(299,30,'Huyện Ninh Giang'),(300,30,'Huyện Thanh Miện'),(303,31,'Quận Hồng Bàng'),(304,31,'Quận Ngô Quyền'),(305,31,'Quận Lê Chân'),(306,31,'Quận Hải An'),(307,31,'Quận Kiến An'),(308,31,'Quận Đồ Sơn'),(309,31,'Quận Kinh Dương'),(311,31,'Huyện Thuỷ Nguyên'),(312,31,'Huyện An Dương'),(313,31,'Huyện An Lão'),(314,31,'Huyện Kiến Thụy'),(315,31,'Huyện Tiên Lãng'),(316,31,'Huyện Vĩnh Bảo'),(317,31,'Huyện Cát Hải'),(318,31,'Huyện Bạch Long Vĩ'),(323,33,'Thành Phố Hưng Yên'),(325,33,'Huyện Văn Lâm'),(326,33,'Huyện Văn Giang'),(327,33,'Huyện Yên Mỹ'),(328,33,'Huyện Mỹ Hào'),(329,33,'Huyện Ân Thi'),(330,33,'Huyện Khoái Châu'),(331,33,'Huyện Kim Động'),(332,33,'Huyện Tiên Lữ'),(333,33,'Huyện Phù Cừ'),(336,34,'Thành Phố Thái Bình'),(338,34,'Huyện Quỳnh Phụ'),(339,34,'Huyện Hưng Hà'),(340,34,'Huyện Đông Hưng'),(341,34,'Huyện Thái Thụy'),(342,34,'Huyện Tiền Hải'),(343,34,'Huyện Kiến Xương'),(344,34,'Huyện Vũ Thư'),(347,35,'Thành Phố Phủ Lý'),(349,35,'Huyện Duy Tiên'),(350,35,'Huyện Kim Bảng'),(351,35,'Huyện Thanh Liêm'),(352,35,'Huyện Bình Lục'),(353,35,'Huyện Lý Nhân'),(356,36,'Thành Phố Nam Định'),(358,36,'Huyện Mỹ Lộc'),(359,36,'Huyện Vụ Bản'),(360,36,'Huyện Ý Yên'),(361,36,'Huyện Nghĩa Hưng'),(362,36,'Huyện Nam Trực'),(363,36,'Huyện Trực Ninh'),(364,36,'Huyện Xuân Trường'),(365,36,'Huyện Giao Thủy'),(366,36,'Huyện Hải Hậu'),(369,37,'Thành Phố Ninh Bình'),(370,37,'Thị Xã Tam Điệp'),(372,37,'Huyện Nho Quan'),(373,37,'Huyện Gia Viễn'),(374,37,'Huyện Hoa Lư'),(375,37,'Huyện Yên Khánh'),(376,37,'Huyện Kim Sơn'),(377,37,'Huyện Yên Mô'),(380,38,'Thành Phố Thanh Hóa'),(381,38,'Thị Xã Bỉm Sơn'),(382,38,'Thị Xã Sầm Sơn'),(384,38,'Huyện Mường Lát'),(385,38,'Huyện Quan Hóa'),(386,38,'Huyện Bá Thước'),(387,38,'Huyện Quan Sơn'),(388,38,'Huyện Lang Chánh'),(389,38,'Huyện Ngọc Lặc'),(390,38,'Huyện Cẩm Thủy'),(391,38,'Huyện Thạch Thành'),(392,38,'Huyện Hà Trung'),(393,38,'Huyện Vĩnh Lộc'),(394,38,'Huyện Yên Định'),(395,38,'Huyện Thọ Xuân'),(396,38,'Huyện Thường Xuân'),(397,38,'Huyện Triệu Sơn'),(398,38,'Huyện Thiệu Hoá'),(399,38,'Huyện Hoằng Hóa'),(400,38,'Huyện Hậu Lộc'),(401,38,'Huyện Nga Sơn'),(402,38,'Huyện Như Xuân'),(403,38,'Huyện Như Thanh'),(404,38,'Huyện Nông Cống'),(405,38,'Huyện Đông Sơn'),(406,38,'Huyện Quảng Xương'),(407,38,'Huyện Tĩnh Gia'),(412,40,'Thành Phố Vinh'),(413,40,'Thị Xã Cửa Lò'),(414,40,'Thị Xã Thái Hoà'),(415,40,'Huyện Quế Phong'),(416,40,'Huyện Quỳ Châu'),(417,40,'Huyện Kỳ Sơn'),(418,40,'Huyện Tương Dương'),(419,40,'Huyện Nghĩa Đàn'),(420,40,'Huyện Quỳ Hợp'),(421,40,'Huyện Quỳnh Lưu'),(422,40,'Huyện Con Cuông'),(423,40,'Huyện Tân Kỳ'),(424,40,'Huyện Anh Sơn'),(425,40,'Huyện Diễn Châu'),(426,40,'Huyện Yên Thành'),(427,40,'Huyện Đô Lương'),(428,40,'Huyện Thanh Chương'),(429,40,'Huyện Nghi Lộc'),(430,40,'Huyện Nam Đàn'),(431,40,'Huyện Hưng Nguyên'),(436,42,'Thành Phố Hà Tĩnh'),(437,42,'Thị Xã Hồng Lĩnh'),(439,42,'Huyện Hương Sơn'),(440,42,'Huyện Đức Thọ'),(441,42,'Huyện Vũ Quang'),(442,42,'Huyện Nghi Xuân'),(443,42,'Huyện Can Lộc'),(444,42,'Huyện Hương Khê'),(445,42,'Huyện Thạch Hà'),(446,42,'Huyện Cẩm Xuyên'),(447,42,'Huyện Kỳ Anh'),(448,42,'Huyện Lộc Hà'),(450,44,'Thành Phố Đồng Hới'),(452,44,'Huyện Minh Hóa'),(453,44,'Huyện Tuyên Hóa'),(454,44,'Huyện Quảng Trạch'),(455,44,'Huyện Bố Trạch'),(456,44,'Huyện Quảng Ninh'),(457,44,'Huyện Lệ Thủy'),(461,45,'Thành Phố Đông Hà'),(462,45,'Thị Xã Quảng Trị'),(464,45,'Huyện Vĩnh Linh'),(465,45,'Huyện Hướng Hóa'),(466,45,'Huyện Gio Linh'),(467,45,'Huyện Đa Krông'),(468,45,'Huyện Cam Lộ'),(469,45,'Huyện Triệu Phong'),(470,45,'Huyện Hải Lăng'),(471,45,'Huyện Cồn Cỏ'),(474,46,'Thành Phố Huế'),(476,46,'Huyện Phong Điền'),(477,46,'Huyện Quảng Điền'),(478,46,'Huyện Phú Vang'),(479,46,'Huyện Hương Thủy'),(480,46,'Huyện Hương Trà'),(481,46,'Huyện A Lưới'),(482,46,'Huyện Phú Lộc'),(483,46,'Huyện Nam Đông'),(490,48,'Quận Liên Chiểu'),(491,48,'Quận Thanh Khê'),(492,48,'Quận Hải Châu'),(493,48,'Quận Sơn Trà'),(494,48,'Quận Ngũ Hành Sơn'),(495,48,'Quận Cẩm Lệ'),(497,48,'Huyện Hoà Vang'),(498,48,'Huyện Hoàng Sa'),(502,49,'Thành Phố Tam Kỳ'),(503,49,'Thành Phố Hội An'),(504,49,'Huyện Tây Giang'),(505,49,'Huyện Đông Giang'),(506,49,'Huyện Đại Lộc'),(507,49,'Huyện Điện Bàn'),(508,49,'Huyện Duy Xuyên'),(509,49,'Huyện Quế Sơn'),(510,49,'Huyện Nam Giang'),(511,49,'Huyện Phước Sơn'),(512,49,'Huyện Hiệp Đức'),(513,49,'Huyện Thăng Bình'),(514,49,'Huyện Tiên Phước'),(515,49,'Huyện Bắc Trà My'),(516,49,'Huyện Nam Trà My'),(517,49,'Huyện Núi Thành'),(518,49,'Huyện Phú Ninh'),(519,49,'Huyện Nông Sơn'),(522,51,'Thành Phố Quảng Ngãi'),(524,51,'Huyện Bình Sơn'),(525,51,'Huyện Trà Bồng'),(526,51,'Huyện Tây Trà'),(527,51,'Huyện Sơn Tịnh'),(528,51,'Huyện Tư Nghĩa'),(529,51,'Huyện Sơn Hà'),(530,51,'Huyện Sơn Tây'),(531,51,'Huyện Minh Long'),(532,51,'Huyện Nghĩa Hành'),(533,51,'Huyện Mộ Đức'),(534,51,'Huyện Đức Phổ'),(535,51,'Huyện Ba Tơ'),(536,51,'Huyện Lý Sơn'),(540,52,'Thành Phố Qui Nhơn'),(542,52,'Huyện An Lão'),(543,52,'Huyện Hoài Nhơn'),(544,52,'Huyện Hoài Ân'),(545,52,'Huyện Phù Mỹ'),(546,52,'Huyện Vĩnh Thạnh'),(547,52,'Huyện Tây Sơn'),(548,52,'Huyện Phù Cát'),(549,52,'Huyện An Nhơn'),(550,52,'Huyện Tuy Phước'),(551,52,'Huyện Vân Canh'),(555,54,'Thành Phố Tuy Hòa'),(557,54,'Thị Xã Sông Cầu'),(558,54,'Huyện Đồng Xuân'),(559,54,'Huyện Tuy An'),(560,54,'Huyện Sơn Hòa'),(561,54,'Huyện Sông Hinh'),(562,54,'Huyện Tây Hoà'),(563,54,'Huyện Phú Hoà'),(564,54,'Huyện Đông Hoà'),(568,56,'Thành Phố Nha Trang'),(569,56,'Thị Xã Cam Ranh'),(570,56,'Huyện Cam Lâm'),(571,56,'Huyện Vạn Ninh'),(572,56,'Huyện Ninh Hòa'),(573,56,'Huyện Khánh Vĩnh'),(574,56,'Huyện Diên Khánh'),(575,56,'Huyện Khánh Sơn'),(576,56,'Huyện Trường Sa'),(582,58,'Thành Phố Phan Rang-Tháp Chàm'),(584,58,'Huyện Bác Ái'),(585,58,'Huyện Ninh Sơn'),(586,58,'Huyện Ninh Hải'),(587,58,'Huyện Ninh Phước'),(588,58,'Huyện Thuận Bắc'),(589,58,'Huyện Thuận Nam'),(593,60,'Thành Phố Phan Thiết'),(594,60,'Thị Xã La Gi'),(595,60,'Huyện Tuy Phong'),(596,60,'Huyện Bắc Bình'),(597,60,'Huyện Hàm Thuận Bắc'),(598,60,'Huyện Hàm Thuận Nam'),(599,60,'Huyện Tánh Linh'),(600,60,'Huyện Đức Linh'),(601,60,'Huyện Hàm Tân'),(602,60,'Huyện Phú Quí'),(608,62,'Thành Phố Kon Tum'),(610,62,'Huyện Đắk Glei'),(611,62,'Huyện Ngọc Hồi'),(612,62,'Huyện Đắk Tô'),(613,62,'Huyện Kon Plông'),(614,62,'Huyện Kon Rẫy'),(615,62,'Huyện Đắk Hà'),(616,62,'Huyện Sa Thầy'),(617,62,'Huyện Tu Mơ Rông'),(622,64,'Thành Phố Pleiku'),(623,64,'Thị Xã An Khê'),(624,64,'Thị Xã Ayun Pa'),(625,64,'Huyện Kbang'),(626,64,'Huyện Đăk Đoa'),(627,64,'Huyện Chư Păh'),(628,64,'Huyện Ia Grai'),(629,64,'Huyện Mang Yang'),(630,64,'Huyện Kông Chro'),(631,64,'Huyện Đức Cơ'),(632,64,'Huyện Chư Prông'),(633,64,'Huyện Chư Sê'),(634,64,'Huyện Đăk Pơ'),(635,64,'Huyện Ia Pa'),(637,64,'Huyện Krông Pa'),(638,64,'Huyện Phú Thiện'),(639,64,'Huyện Chư Pưh'),(643,66,'Thành Phố Buôn Ma Thuột'),(644,66,'Thị Xã Buôn Hồ'),(645,66,'Huyện Ea H\'leo'),(646,66,'Huyện Ea Súp'),(647,66,'Huyện Buôn Đôn'),(648,66,'Huyện Cư M\'gar'),(649,66,'Huyện Krông Búk'),(650,66,'Huyện Krông Năng'),(651,66,'Huyện Ea Kar'),(652,66,'Huyện M\'đrắk'),(653,66,'Huyện Krông Bông'),(654,66,'Huyện Krông Pắc'),(655,66,'Huyện Krông A Na'),(656,66,'Huyện Lắk'),(657,66,'Huyện Cư Kuin'),(660,67,'Thị Xã Gia Nghĩa'),(661,67,'Huyện Đắk Glong'),(662,67,'Huyện Cư Jút'),(663,67,'Huyện Đắk Mil'),(664,67,'Huyện Krông Nô'),(665,67,'Huyện Đắk Song'),(666,67,'Huyện Đắk R\'lấp'),(667,67,'Huyện Tuy Đức'),(672,68,'Thành Phố Đà Lạt'),(673,68,'Thị Xã Bảo Lộc'),(674,68,'Huyện Đam Rông'),(675,68,'Huyện Lạc Dương'),(676,68,'Huyện Lâm Hà'),(677,68,'Huyện Đơn Dương'),(678,68,'Huyện Đức Trọng'),(679,68,'Huyện Di Linh'),(680,68,'Huyện Bảo Lâm'),(681,68,'Huyện Đạ Huoai'),(682,68,'Huyện Đạ Tẻh'),(683,68,'Huyện Cát Tiên'),(688,70,'Thị Xã Phước Long'),(689,70,'Thị Xã Đồng Xoài'),(690,70,'Thị Xã Bình Long'),(691,70,'Huyện Bù Gia Mập'),(692,70,'Huyện Lộc Ninh'),(693,70,'Huyện Bù Đốp'),(694,70,'Huyện Hớn Quản'),(695,70,'Huyện Đồng Phù'),(696,70,'Huyện Bù Đăng'),(697,70,'Huyện Chơn Thành'),(703,72,'Thị Xã Tây Ninh'),(705,72,'Huyện Tân Biên'),(706,72,'Huyện Tân Châu'),(707,72,'Huyện Dương Minh Châu'),(708,72,'Huyện Châu Thành'),(709,72,'Huyện Hòa Thành'),(710,72,'Huyện Gò Dầu'),(711,72,'Huyện Bến Cầu'),(712,72,'Huyện Trảng Bàng'),(718,74,'Thị Xã Thủ Dầu Một'),(720,74,'Huyện Dầu Tiếng'),(721,74,'Huyện Bến Cát'),(722,74,'Huyện Phú Giáo'),(723,74,'Huyện Tân Uyên'),(724,74,'Huyện Dĩ An'),(725,74,'Huyện Thuận An'),(731,75,'Thành Phố Biên Hòa'),(732,75,'Thị Xã Long Khánh'),(734,75,'Huyện Tân Phú'),(735,75,'Huyện Vĩnh Cửu'),(736,75,'Huyện Định Quán'),(737,75,'Huyện Trảng Bom'),(738,75,'Huyện Thống Nhất'),(739,75,'Huyện Cẩm Mỹ'),(740,75,'Huyện Long Thành'),(741,75,'Huyện Xuân Lộc'),(742,75,'Huyện Nhơn Trạch'),(747,77,'Thành Phố Vũng Tầu'),(748,77,'Thị Xã Bà Rịa'),(750,77,'Huyện Châu Đức'),(751,77,'Huyện Xuyên Mộc'),(752,77,'Huyện Long Điền'),(753,77,'Huyện Đất Đỏ'),(754,77,'Huyện Tân Thành'),(755,77,'Huyện Côn Đảo'),(760,79,'Quận 1'),(761,79,'Quận 12'),(762,79,'Quận Thủ Đức'),(763,79,'Quận 9'),(764,79,'Quận Gò Vấp'),(765,79,'Quận Bình Thạnh'),(766,79,'Quận Tân Bình'),(767,79,'Quận Tân Phú'),(768,79,'Quận Phú Nhuận'),(769,79,'Quận 2'),(770,79,'Quận 3'),(771,79,'Quận 10'),(772,79,'Quận 11'),(773,79,'Quận 4'),(774,79,'Quận 5'),(775,79,'Quận 6'),(776,79,'Quận 8'),(777,79,'Quận Bình Tân'),(778,79,'Quận 7'),(783,79,'Huyện Củ Chi'),(784,79,'Huyện Hóc Môn'),(785,79,'Huyện Bình Chánh'),(786,79,'Huyện Nhà Bè'),(787,79,'Huyện Cần Giờ'),(794,80,'Thành Phố Tân An'),(796,80,'Huyện Tân Hưng'),(797,80,'Huyện Vĩnh Hưng'),(798,80,'Huyện Mộc Hóa'),(799,80,'Huyện Tân Thạnh'),(800,80,'Huyện Thạnh Hóa'),(801,80,'Huyện Đức Huệ'),(802,80,'Huyện Đức Hòa'),(803,80,'Huyện Bến Lức'),(804,80,'Huyện Thủ Thừa'),(805,80,'Huyện Tân Trụ'),(806,80,'Huyện Cần Đước'),(807,80,'Huyện Cần Giuộc'),(808,80,'Huyện Châu Thành'),(815,82,'Thành Phố Mỹ Tho'),(816,82,'Thị Xã Gò Công'),(818,82,'Huyện Tân Phước'),(819,82,'Huyện Cái Bè'),(820,82,'Huyện Cai Lậy'),(821,82,'Huyện Châu Thành'),(822,82,'Huyện Chợ Gạo'),(823,82,'Huyện Gò Công Tây'),(824,82,'Huyện Gò Công Đông'),(825,82,'Huyện Tân Phú Đông'),(829,83,'Thành Phố Bến Tre'),(831,83,'Huyện Châu Thành'),(832,83,'Huyện Chợ Lách'),(833,83,'Huyện Mỏ Cày Nam'),(834,83,'Huyện Giồng Trôm'),(835,83,'Huyện Bình Đại'),(836,83,'Huyện Ba Tri'),(837,83,'Huyện Thạnh Phú'),(838,83,'Huyện Mỏ Cày Bắc'),(842,84,'Thị Xã Trà Vinh'),(844,84,'Huyện Càng Long'),(845,84,'Huyện Cầu Kè'),(846,84,'Huyện Tiểu Cần'),(847,84,'Huyện Châu Thành'),(848,84,'Huyện Cầu Ngang'),(849,84,'Huyện Trà Cú'),(850,84,'Huyện Duyên Hải'),(855,86,'Thành Phố Vĩnh Long'),(857,86,'Huyện Long Hồ'),(858,86,'Huyện Mang Thít'),(859,86,'Huyện Vũng Liêm'),(860,86,'Huyện Tam Bình'),(861,86,'Huyện Bình Minh'),(862,86,'Huyện Trà Ôn'),(863,86,'Huyện Bình Tân'),(866,87,'Thành Phố Cao Lãnh'),(867,87,'Thị Xã Sa Đéc'),(868,87,'Thị Xã Hồng Ngự'),(869,87,'Huyện Tân Hồng'),(870,87,'Huyện Hồng Ngự'),(871,87,'Huyện Tam Nông'),(872,87,'Huyện Tháp Mười'),(873,87,'Huyện Cao Lãnh'),(874,87,'Huyện Thanh Bình'),(875,87,'Huyện Lấp Vò'),(876,87,'Huyện Lai Vung'),(877,87,'Huyện Châu Thành'),(883,89,'Thành Phố Long Xuyên'),(884,89,'Thị Xã Châu Đốc'),(886,89,'Huyện An Phú'),(887,89,'Thị Xã Tân Châu'),(888,89,'Huyện Phú Tân'),(889,89,'Huyện Châu Phú'),(890,89,'Huyện Tịnh Biên'),(891,89,'Huyện Tri Tôn'),(892,89,'Huyện Châu Thành'),(893,89,'Huyện Chợ Mới'),(894,89,'Huyện Thoại Sơn'),(899,91,'Thành Phố Rạch Giá'),(900,91,'Thị Xã Hà Tiên'),(902,91,'Huyện Kiên Lương'),(903,91,'Huyện Hòn Đất'),(904,91,'Huyện Tân Hiệp'),(905,91,'Huyện Châu Thành'),(906,91,'Huyện Giồng Giềng'),(907,91,'Huyện Gò Quao'),(908,91,'Huyện An Biên'),(909,91,'Huyện An Minh'),(910,91,'Huyện Vĩnh Thuận'),(911,91,'Huyện Phú Quốc'),(912,91,'Huyện Kiên Hải'),(913,91,'Huyện U Minh Thượng'),(914,91,'Huyện Giang Thành'),(916,92,'Quận Ninh Kiều'),(917,92,'Quận Ô Môn'),(918,92,'Quận Bình Thuỷ'),(919,92,'Quận Cái Răng'),(923,92,'Quận Thốt Nốt'),(924,92,'Huyện Vĩnh Thạnh'),(925,92,'Huyện Cờ Đỏ'),(926,92,'Huyện Phong Điền'),(927,92,'Huyện Thới Lai'),(930,93,'Thị Xã Vị Thanh'),(931,93,'Thị Xã Ngã Bảy'),(932,93,'Huyện Châu Thành A'),(933,93,'Huyện Châu Thành'),(934,93,'Huyện Phụng Hiệp'),(935,93,'Huyện Vị Thuỷ'),(936,93,'Huyện Long Mỹ'),(941,94,'Thành Phố Sóc Trăng'),(942,94,'Huyện Châu Thành'),(943,94,'Huyện Kế Sách'),(944,94,'Huyện Mỹ Tú'),(945,94,'Huyện Cù Lao Dung'),(946,94,'Huyện Long Phú'),(947,94,'Huyện Mỹ Xuyên'),(948,94,'Huyện Ngã Năm'),(949,94,'Huyện Thạnh Trị'),(950,94,'Huyện Vĩnh Châu'),(951,94,'Huyện Trần Đề'),(954,95,'Thị Xã Bạc Liêu'),(956,95,'Huyện Hồng Dân'),(957,95,'Huyện Phước Long'),(958,95,'Huyện Vĩnh Lợi'),(959,95,'Huyện Giá Rai'),(960,95,'Huyện Đông Hải'),(961,95,'Huyện Hoà Bình'),(964,96,'Thành Phố Cà Mau'),(966,96,'Huyện U Minh'),(967,96,'Huyện Thới Bình'),(968,96,'Huyện Trần Văn Thời'),(969,96,'Huyện Cái Nước'),(970,96,'Huyện Đầm Dơi'),(971,96,'Huyện Năm Căn'),(972,96,'Huyện Phú Tân'),(973,96,'Huyện Ngọc Hiển');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
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