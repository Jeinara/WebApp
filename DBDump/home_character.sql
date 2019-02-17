CREATE DATABASE  IF NOT EXISTS `home` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `home`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: home
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `character`
--

DROP TABLE IF EXISTS `character`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `character` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `img` text,
  `floor` int(11) DEFAULT NULL,
  `membership` varchar(30) DEFAULT NULL,
  `sin` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `character`
--

LOCK TABLES `character` WRITE;
/*!40000 ALTER TABLE `character` DISABLE KEYS */;
INSERT INTO `character` VALUES (1,'Мэрилу Фоллей','\\img\\Photo\\Marylou_Folley.png',0,'свободна','безгрешна'),(2,'Вервиер Ласк','\\img\\Photo\\Vervier_Lask.png',0,'свободен','безгрешен'),(3,'Эспри Аньель Сен-Дени','\\img\\Photo\\Esprit_Agnel_Saint-Denis.png',0,'Стая','безгрешен'),(4,'Ирвин Риверсайд','\\img\\Photo\\Irvin_Riverside.png',0,'Стая','безгрешен'),(5,'Нон Флэтли','\\img\\Photo\\Non_Flatley.png',8,'Труппа','Травля невинных'),(6,'Лионелло Марчези','\\img\\Photo\\Lionello_Marchesi.png',8,'Стая','Лицемерие'),(7,'Валентин Вишневский','\\img\\Photo\\Valentin_Vishnevsky.png',8,'свободен','Вероломное убийство'),(8,'Фертимия Мортем','\\img\\Photo\\Fertimia_Mortem.png',8,'свободен','Ренегатство'),(9,'Габриель Ньюман','\\img\\Photo\\Gabriel_Newman.png',7,'свободен','Нападение с летальным исходом'),(10,'Криспин Харпер','\\img\\Photo\\Crispin_Harper.png',7,'Стая','Попытка суицида'),(11,'Михаил Князев','\\img\\Photo\\Mikhail_Knyazev.png',7,'свободен','Непреднамеренное убийство'),(12,'Аксель Райт','\\img\\Photo\\Axel_Wright.png',6,'свободен','Небылицы'),(13,'Аделина Вальтер','\\img\\Photo\\Adeline_Walther.png',5,'свободна','Бунтарство и месть'),(14,'Вайт Соркер','\\img\\Photo\\White_Sorcer.png',5,'свободна','Безрассудство'),(15,'Виктория Оверлук','\\img\\Photo\\Victoria_Overlook.png',5,'Стая','Конфликтность'),(16,'Виола Вероника Праймор','\\img\\Photo\\Viola_Veronica_Primer.png',4,'свободна','Тщеславие'),(17,'Джоселин Фрей','\\img\\Photo\\Jocelyn_Frey.png',5,'Стая','Вспыльчивость'),(18,'Уолли Диккей','\\img\\Photo\\Whalley_Dekay.png',3,'свободна','Пьянство и наркотики'),(19,'Аполлин Ларивьер','\\img\\Photo\\Apolline_Lariviere.png',4,'Стая','Чрезмерная душевная щедрость');
/*!40000 ALTER TABLE `character` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-17 14:31:07
