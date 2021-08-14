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
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `film` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `actors` varchar(255) DEFAULT NULL,
  `age` longtext,
  `category` varchar(255) DEFAULT NULL,
  `description` longtext,
  `directors` varchar(255) DEFAULT NULL,
  `duration` int NOT NULL,
  `end_date` date DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double NOT NULL DEFAULT '0',
  `start_date` date DEFAULT NULL,
  `studio` varchar(255) DEFAULT NULL,
  `trailer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,'Kiều Minh Tuấn, Thu Trang, Jun Vũ, Anh Tú, Puka, NSUT Kim Xuân, La Thành','https://firebasestorage.googleapis.com/v0/b/a0720i1.appspot.com/o/dat-home%2Fc-16.png?alt=media&token=3ed7b6ef-9e9a-4f03-bece-3c0f281c1b63','Hành động - Chiến tranh - Kiếm hiệp - Hài hước - Võ thuật - Kinh điển','Chìa Khoá Trăm Tỷ bắt đầu khi một sát thủ khét tiếng vô tình bị mất trí vì một tai nạn bất ngờ, rồi bắt đầu một cuộc sống mới bằng nghề diễn viên quần chúng. Chuyện gì sẽ xảy ra nếu chàng diễn viên quần chúng này quên hẳn cuộc đời sát thủ để trở thành một ngôi sao hành động? Liệu sự nghiệp diễn viên và cô quản lý bất đắc dĩ có giúp hắn thay đổi quá khứ mãi mãi và sống trọn vẹn một cuộc đời mới? Một bộ phim hài-hành động nhưng cũng đầy sự ấm áp về hành trình \"đổi đời\" của một kẻ giết thuê để mưu sinh','Võ Thanh Hoà',101,'2021-09-02','https://files.betacorp.vn/files/media%2fimages%2f2021%2f03%2f31%2funtitled%2D1%2D153906%2D310321%2D77.jpg','Chìa Khóa Trăm Tỷ',5,'2021-07-21','Saigon Film','https://www.youtube.com/embed/pLSfGaYZPw8'),(2,'Margot Robbie, Idris Elba, John Cena','https://firebasestorage.googleapis.com/v0/b/a0720i1.appspot.com/o/dat-home%2Fc-18.png?alt=media&token=17900829-a490-475b-b8c7-96cd1bbf2c62','Hành động - Hài hước','Các phạm nhân tại nhà tù Belle Reve được tuyển vào biệt đội Task Force X để đến hòn đảo Corto Maltese tại Nam Mỹ để phá hủy Jotunheim - một nhà tù thời Nazi và cũng là phòng nghiên cứu, lưu giữ tù nhân chính trị cũng như thực hiện nhiều thí nghiệm bí ẩn.','James Gunn',130,'2021-09-04','https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/m/a/main_poster_mtb_1__1.jpg','The Suicide Squad',4,'2021-07-26','HBOTEX','https://www.youtube.com/embed/pLSfGaYZPw8'),(3,'Minh Quang Nguyễn, Thanh Thảo, H\'Hen Niê','https://firebasestorage.googleapis.com/v0/b/a0720i1.appspot.com/o/dat-home%2Fc-16.png?alt=media&token=3ed7b6ef-9e9a-4f03-bece-3c0f281c1b63','Hành động - Hài hước','Bộ phim là câu chuyện của một người lái xe container và cô con gái nhỏ của mình. Cuộc sống của 2 cha con trên chiếc xe vàng cứ êm đềm diễn ra cho đến ngày cô bé xa cha đi học. Mọi thứ bỗng đảo lộn khi người cha nhận được tin cô con gái của mình bị trầm cảm nặng. Anh càng đau đớn hơn khi biết con mình bị xâm hại. Hành trình đi tìm công lý cho con là những màn đấu trí căng thẳng, những cuộc rượt đuổi khốc liệt và rồi người cha chợt nhận ra rằng anh không chỉ đối đầu với một kẻ xâm hại…','Lương Đình Dũng',100,'2021-09-30','https://files.betacorp.vn/files/media%2fimages%2f2021%2f04%2f26%2f578%2D100404%2D260421%2D60.jpg','578: Phát Đạn Của Kẻ Điên',0,'2021-07-24','Tran An CoLtd','https://www.youtube.com/embed/pLSfGaYZPw8'),(4,'Yahya Abdul-Mateen II, Teyonah Parris, Nathan Stewart-Jarrett, Colman Domingo','https://firebasestorage.googleapis.com/v0/b/a0720i1.appspot.com/o/dat-home%2Fc-16.png?alt=media&token=3ed7b6ef-9e9a-4f03-bece-3c0f281c1b63','Hành động - Hài hước','Một \"phần tiếp theo tinh thần\" của bộ phim kinh dị năm 1992 \'Candyman\' quay trở lại khu phố Chicago hiện đại, nơi huyền thoại bắt đầu.','Nia DaCosta',100,'2021-09-01','https://files.betacorp.vn/files/media%2fimages%2f2021%2f05%2f19%2fsat%2Dnhan%2Dtrong%2Dguong%2D175419%2D190521%2D50.jpg','Sát Nhân Trong Gương',4.5,'2021-07-25','Wanner Bros','https://www.youtube.com/embed/pLSfGaYZPw8'),(5,'Simu Liu, Awkwafina, Tony Chiu-Wai Leung','https://firebasestorage.googleapis.com/v0/b/a0720i1.appspot.com/o/dat-home%2Fc-16.png?alt=media&token=3ed7b6ef-9e9a-4f03-bece-3c0f281c1b63','Hành động - Hài hước','Shang-Chi và Huyền Thoại Thập Nhẫn là bộ phim thuộc giai đoạn 4 của Vũ trụ điện ảnh Marvel. Nhân vật này được biết đến như một bậc thầy Kung Fu, tinh thông võ thuật. Sức mạnh của Shang-Chi đến từ hàng ngàn giờ luyện tập miệt mài và sự kỷ luật cao độ với bản thân. Siêu anh hùng võ thuật này được chính bố dạy dỗ để trở thành một sát thủ chuyên nghiệp và kế thừa tập đoàn tội ác của ông.','Destin Daniel Cretton',130,'2021-10-03','https://files.betacorp.vn/files/media%2fimages%2f2021%2f05%2f19%2fshang-chi-180439-190521-28.jpg','Shang-Chi Và Huyền Thoại Thập Nhẫn',5,'2021-08-01','HMavel','https://www.youtube.com/embed/pLSfGaYZPw8'),(6,'Ryan Reynolds, Jacksepticeye, Jodie Comer, Joe Keery','https://firebasestorage.googleapis.com/v0/b/a0720i1.appspot.com/o/dat-home%2Fc-16.png?alt=media&token=3ed7b6ef-9e9a-4f03-bece-3c0f281c1b63','Hành động - Hài hước','Guy - Nhân viên giao dịch ngân hàng, phát hiện anh ấy thực chất là người chơi nền trong trò chơi điện tử thế giới mở. Guy quyết định trở thành người anh hùng và viết lại câu chuyện của chính mình. Giờ đây, trong một thế giới không còn giới hạn, anh ấy quyết định trở thành người giải cứu thế giới, theo cách của chính mình.','Shawn Levy',100,'2021-12-05','https://files.betacorp.vn/files/media%2fimages%2f2021%2f05%2f19%2ffree-guy-175032-190521-69.jpg','Giải Cứu Guy',0,'2021-09-03','Holywood','https://www.youtube.com/embed/pLSfGaYZPw8'),(7,'Yahya Abdul-Mateen II, Teyonah Parris, Nathan Stewart-Jarrett, Colman Domingo','https://firebasestorage.googleapis.com/v0/b/a0720i1.appspot.com/o/dat-home%2Fc-16.png?alt=media&token=3ed7b6ef-9e9a-4f03-bece-3c0f281c1b63','Hành động - Hài hước','Một \"phần tiếp theo tinh thần\" của bộ phim kinh dị năm 1992 \'Candyman\' quay trở lại khu phố Chicago hiện đại, nơi huyền thoại bắt đầu.','Nia DaCosta',100,'2021-09-01','https://files.betacorp.vn/files/media%2fimages%2f2021%2f05%2f19%2fsat%2Dnhan%2Dtrong%2Dguong%2D175419%2D190521%2D50.jpg','Sát Nhân Trong Gương (Phần 2)',4.5,'2021-08-25','Wanner Bros','https://www.youtube.com/embed/pLSfGaYZPw8'),(8,'Simu Liu, Awkwafina, Tony Chiu-Wai Leung','https://firebasestorage.googleapis.com/v0/b/a0720i1.appspot.com/o/dat-home%2Fc-16.png?alt=media&token=3ed7b6ef-9e9a-4f03-bece-3c0f281c1b63','Hành động - Hài hước','Shang-Chi và Huyền Thoại Thập Nhẫn là bộ phim thuộc giai đoạn 4 của Vũ trụ điện ảnh Marvel. Nhân vật này được biết đến như một bậc thầy Kung Fu, tinh thông võ thuật. Sức mạnh của Shang-Chi đến từ hàng ngàn giờ luyện tập miệt mài và sự kỷ luật cao độ với bản thân. Siêu anh hùng võ thuật này được chính bố dạy dỗ để trở thành một sát thủ chuyên nghiệp và kế thừa tập đoàn tội ác của ông.','Destin Daniel Cretton',130,'2021-10-03','https://files.betacorp.vn/files/media%2fimages%2f2021%2f05%2f19%2fshang-chi-180439-190521-28.jpg','Shang-Chi (Phần 2)',5,'2021-08-25','HMavel','https://www.youtube.com/embed/pLSfGaYZPw8'),(9,'Ryan Reynolds, Jacksepticeye, Jodie Comer, Joe Keery','https://firebasestorage.googleapis.com/v0/b/a0720i1.appspot.com/o/dat-home%2Fc-16.png?alt=media&token=3ed7b6ef-9e9a-4f03-bece-3c0f281c1b63','Hành động - Hài hước','Guy - Nhân viên giao dịch ngân hàng, phát hiện anh ấy thực chất là người chơi nền trong trò chơi điện tử thế giới mở. Guy quyết định trở thành người anh hùng và viết lại câu chuyện của chính mình. Giờ đây, trong một thế giới không còn giới hạn, anh ấy quyết định trở thành người giải cứu thế giới, theo cách của chính mình.','Shawn Levy',100,'2021-12-05','https://files.betacorp.vn/files/media%2fimages%2f2021%2f05%2f19%2ffree-guy-175032-190521-69.jpg','Giải Cứu Guy(Phần 2)',0,'2021-08-25','Holywood','https://www.youtube.com/embed/pLSfGaYZPw8'),(13,'James,Hoang','https://firebasestorage.googleapis.com/v0/b/a0720i1.appspot.com/o/dat-home%2Fc-18.png?alt=media&token=17900829-a490-475b-b8c7-96cd1bbf2c62','Hành động - Tình cảm - Lạng mạn - Hài hước','Đây là bộ phimmmmmmmmmmmmmmmmmmmm','Phát',180,'2021-10-12','https://firebasestorage.googleapis.com/v0/b/a0720i1-cinema.appspot.com/o/09-08-2021075729PMgodizla.jpg?alt=media&token=cc453a01-71fc-48b2-8f8a-defaac8a9246','Godzilla',0,'2021-08-10','ABC','https://www.youtube.com/embed/yFpuUGFS1Kg');
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-14 10:37:28
