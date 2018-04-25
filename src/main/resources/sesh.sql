-- MySQL dump 10.13  Distrib 5.7.21, for Win32 (AMD64)
--
-- Host: localhost    Database: sesh
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `geolocation` text,
  `has_promotion` tinyint(4) DEFAULT '0',
  `rating` float DEFAULT NULL,
  `visitors` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Sesh pub','sesh st, seshland','https://sesh.ie',NULL,0,2.1,21);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_review`
--

DROP TABLE IF EXISTS `location_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_review` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `location_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `review` text,
  `rating` float DEFAULT NULL,
  `uploaded` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `location_id` (`location_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `location_review_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `location_review_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_review`
--

LOCK TABLES `location_review` WRITE;
/*!40000 ALTER TABLE `location_review` DISABLE KEYS */;
INSERT INTO `location_review` VALUES (1,1,4,'This place is shit craic.',2.1,'2013-02-10 00:00:00');
/*!40000 ALTER TABLE `location_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logged_in`
--

DROP TABLE IF EXISTS `logged_in`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logged_in` (
  `id` bigint(20) DEFAULT NULL,
  `token` varchar(200) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `loggedin` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logged_in`
--

LOCK TABLES `logged_in` WRITE;
/*!40000 ALTER TABLE `logged_in` DISABLE KEYS */;
INSERT INTO `logged_in` VALUES (NULL,'5bcbfb7bd70849278e990a6fe0670a89',20,1),(NULL,'2e369561876446efa65382752baa3edc',20,1),(NULL,'eba55e75da5d4039871f2a6605485199',20,1),(NULL,'05421fc1245a4b72a5071d9285699824',20,1),(NULL,'cbd96986417b402f998e6ab169f5ca93',20,1),(NULL,'d5f7c90c88d7406bbb98a2b7a2d1ca01',20,1),(NULL,'ed824760ff134aa58666601f672c4736',20,1),(NULL,'a37c7dadad944a28809c4f3fbec9fb25',20,1),(NULL,'cdf192f8fe594c3c87e2cbf4ac3946fc',21,1),(NULL,'98d34c4f358b4077a8f7b8c9ab686dd6',21,1),(NULL,'bcd0625ea90143fdb9d553164fd8c9db',20,1),(NULL,'0a1bf2e1e20747ee9b787fef282b458f',20,1),(NULL,'2cf48a94df3740b3b297bcddfc48c8ce',22,1),(NULL,'7c462a9574c445cd822f28b1caa90849',22,1),(NULL,'17d99127d6bb4fdabe48230e4bf47dbe',23,1),(NULL,'5db28b732570474dafaeff6a21b0c902',23,1),(NULL,'5e0e7bd9f6f241d8bda0fca9908b9dae',24,1),(NULL,'d1ddef9a56b94f2c91176794d402b916',24,1);
/*!40000 ALTER TABLE `logged_in` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `message` text,
  `location` int(11) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  `uploaded` datetime DEFAULT NULL,
  `going` text,
  `maybe` text,
  `not_going` text,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `status_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,5,'This is the very first status',1,21,NULL,'[0,4]','[3]','[3]'),(2,5,'This is the very first status',1,21,'2013-02-10 00:00:00','[0,4]','[3]','[3]');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_comment`
--

DROP TABLE IF EXISTS `status_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `message` text,
  `likes` int(11) DEFAULT NULL,
  `uploaded` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `status_comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `status_comment_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_comment`
--

LOCK TABLES `status_comment` WRITE;
/*!40000 ALTER TABLE `status_comment` DISABLE KEYS */;
INSERT INTO `status_comment` VALUES (1,1,5,'This is the very first comment',21,'2013-02-10 00:00:00');
/*!40000 ALTER TABLE `status_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_review`
--

DROP TABLE IF EXISTS `user_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_review` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `location_id` bigint(20) DEFAULT NULL,
  `reviewer_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `message` text,
  `rating` float DEFAULT NULL,
  `uploaded` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `location_id` (`location_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_review_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `user_review_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_review`
--

LOCK TABLES `user_review` WRITE;
/*!40000 ALTER TABLE `user_review` DISABLE KEYS */;
INSERT INTO `user_review` VALUES (1,1,4,5,'This lad is shit craic.',2.1,'2013-02-10 00:00:00');
/*!40000 ALTER TABLE `user_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `location` int(11) DEFAULT NULL,
  `favourite_drink` varchar(200) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `gender` varchar(200) DEFAULT NULL,
  `local_spot` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'James Mackle',21,'2013-02-10 00:00:00',1,'guinness',4.2,NULL,NULL,NULL,NULL,NULL),(3,'James Mackle',21,'2013-02-10 00:00:00',1,'guinness',4.2,NULL,NULL,NULL,NULL,NULL),(4,'James Mackle',21,'2013-02-10 00:00:00',1,'guinness',4.2,NULL,NULL,NULL,NULL,NULL),(5,'James Mackler dudette',21,'2013-02-10 00:00:00',0,NULL,0,NULL,NULL,NULL,NULL,NULL),(6,'James Mackle',21,'2013-02-10 00:00:00',1,'guinness',4.2,NULL,NULL,NULL,NULL,NULL),(7,'James Mackle',21,'2013-02-10 00:00:00',1,'guinness',4.2,NULL,NULL,NULL,NULL,NULL),(8,'ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL,NULL,NULL,NULL,'[B@2b0f28d5','[B@2b0f28d5','ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL),(9,'ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL,NULL,NULL,NULL,'[B@62f639b0','[B@62f639b0','ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL),(10,'ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL,NULL,NULL,NULL,'[B@5edcfe8c','[B@5edcfe8c','ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL),(11,',„E×LLìÊÕB.ò‚ÔÔ/!‡mMÉÐm™ÒS¨Å',NULL,NULL,NULL,NULL,NULL,'[B@70de5ac0','[B@70de5ac0',',„E×LLìÊÕB.ò‚ÔÔ/!‡mMÉÐm™ÒS¨Å',NULL,NULL),(12,'LIR¥Ü\0Ö¼¯ÂuÌ	�¨Šgxö*µG†�#@[Ï',NULL,NULL,NULL,NULL,NULL,'[B@2add56d4','[B@2add56d4','LIR¥Ü\0Ö¼¯ÂuÌ	�¨Šgxö*µG†�#@[Ï',NULL,NULL),(13,'LIR¥Ü\0Ö¼¯ÂuÌ	�¨Šgxö*µG†�#@[Ï',NULL,NULL,NULL,NULL,NULL,'[B@1ca888b8','[B@1ca888b8','LIR¥Ü\0Ö¼¯ÂuÌ	�¨Šgxö*µG†�#@[Ï',NULL,NULL),(14,'ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL,NULL,NULL,NULL,'[B@528c4777','[B@528c4777','ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL),(15,'ú”ºePrq|ìa’�<~ &»>rDÿfž¬t¦SL\'¶Åe',NULL,NULL,NULL,NULL,NULL,'[B@3e397b68','[B@3e397b68','ú”ºePrq|ìa’�<~ &»>rDÿfž¬t¦SL\'¶Åe',NULL,NULL),(16,'ú”ºePrq|ìa’�<~ &»>rDÿfž¬t¦SL\'¶Åe',NULL,NULL,NULL,NULL,NULL,'[B@4b4a7020','[B@4b4a7020','ú”ºePrq|ìa’�<~ &»>rDÿfž¬t¦SL\'¶Åe',NULL,NULL),(17,'úi‚ßÒ…&)®ºŠ‰wµ~@ü·}\Zz(²lºbY',NULL,NULL,NULL,NULL,NULL,'[B@12cb85a','[B@12cb85a','úi‚ßÒ…&)®ºŠ‰wµ~@ü·}\Zz(²lºbY',NULL,NULL),(18,'hey',NULL,NULL,NULL,NULL,NULL,'hey','hey','hey',NULL,NULL),(19,'boi',NULL,NULL,NULL,NULL,NULL,'boi','boi','boi',NULL,NULL),(20,'bi',NULL,NULL,NULL,NULL,NULL,'bi','bi','bi',NULL,NULL),(21,'ta',NULL,NULL,NULL,NULL,NULL,'ta','ta','ta',NULL,NULL),(22,'so',NULL,NULL,NULL,NULL,NULL,'so','so','so',NULL,NULL),(23,'po',NULL,NULL,NULL,NULL,NULL,'po','po','po',NULL,NULL),(24,'pee',NULL,NULL,NULL,NULL,NULL,'pee','pee','pee',NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-25 17:34:48
