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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `token` varchar(200) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `loggedin` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logged_in`
--

LOCK TABLES `logged_in` WRITE;
/*!40000 ALTER TABLE `logged_in` DISABLE KEYS */;
INSERT INTO `logged_in` VALUES (38,'2b4ecb1682254682a63f4d9499c24489',25,1),(39,'4029ab50d3c1470fb66ae789442b6806',25,1),(40,'ae0ca90a98d0446f87c5697400dd0dd3',25,1),(41,'c2ebf590312844e4a0784347a79cc30d',25,1),(42,'ed2dabfc94124a148f9bab808ca8d9b3',25,1),(43,'fbe3637642914beaa7792b3da3d691dd',25,1),(44,'9108981768d94f4ab6a7d5e381020e39',25,1),(45,'071dfdf1c1e443139aa96e649f808df7',25,1),(46,'32040e12f9d34050ad408b1e2736d719',25,1),(47,'7b517f3811644fc9b6a05657e8154d2d',25,1),(48,'21a7d69573e74b2ba5c2fbe77eab4811',25,1),(49,'4e8ec0988d8043529bab3bb3b2c2f246',25,1),(50,'354f0d7e1b6547019bcd148a6328ea61',25,1),(51,'f37d217e5eb64645aa18abeecab9cd97',25,1),(52,'f7d6239061aa4831b01900483cde42d9',25,1),(53,'7cf4109155df4d5dba1eee31488ced1e',32,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'James Mackle',21,'2013-02-10 00:00:00',1,'guinness',4.2,NULL,NULL,NULL,NULL,NULL),(3,'James Mackle',21,'2013-02-10 00:00:00',1,'guinness',4.2,NULL,NULL,NULL,NULL,NULL),(4,'James Mackle',21,'2013-02-10 00:00:00',1,'guinness',4.2,NULL,NULL,NULL,NULL,NULL),(5,'James Mackler dudette',21,'2013-02-10 00:00:00',0,NULL,0,NULL,NULL,NULL,NULL,NULL),(6,'James Mackle',21,'2013-02-10 00:00:00',1,'guinness',4.2,NULL,NULL,NULL,NULL,NULL),(7,'James Mackle',21,'2013-02-10 00:00:00',1,'guinness',4.2,NULL,NULL,NULL,NULL,NULL),(8,'ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL,NULL,NULL,NULL,'[B@2b0f28d5','[B@2b0f28d5','ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL),(9,'ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL,NULL,NULL,NULL,'[B@62f639b0','[B@62f639b0','ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL),(10,'ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL,NULL,NULL,NULL,'[B@5edcfe8c','[B@5edcfe8c','ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL),(11,',„E×LLìÊÕB.ò‚ÔÔ/!‡mMÉÐm™ÒS¨Å',NULL,NULL,NULL,NULL,NULL,'[B@70de5ac0','[B@70de5ac0',',„E×LLìÊÕB.ò‚ÔÔ/!‡mMÉÐm™ÒS¨Å',NULL,NULL),(12,'LIR¥Ü\0Ö¼¯ÂuÌ	�¨Šgxö*µG†�#@[Ï',NULL,NULL,NULL,NULL,NULL,'[B@2add56d4','[B@2add56d4','LIR¥Ü\0Ö¼¯ÂuÌ	�¨Šgxö*µG†�#@[Ï',NULL,NULL),(13,'LIR¥Ü\0Ö¼¯ÂuÌ	�¨Šgxö*µG†�#@[Ï',NULL,NULL,NULL,NULL,NULL,'[B@1ca888b8','[B@1ca888b8','LIR¥Ü\0Ö¼¯ÂuÌ	�¨Šgxö*µG†�#@[Ï',NULL,NULL),(14,'ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL,NULL,NULL,NULL,'[B@528c4777','[B@528c4777','ã°ÄB˜üšûôÈ™o¹$\'®Aäd›“L¤•™xR¸U',NULL,NULL),(15,'ú”ºePrq|ìa’�<~ &»>rDÿfž¬t¦SL\'¶Åe',NULL,NULL,NULL,NULL,NULL,'[B@3e397b68','[B@3e397b68','ú”ºePrq|ìa’�<~ &»>rDÿfž¬t¦SL\'¶Åe',NULL,NULL),(16,'ú”ºePrq|ìa’�<~ &»>rDÿfž¬t¦SL\'¶Åe',NULL,NULL,NULL,NULL,NULL,'[B@4b4a7020','[B@4b4a7020','ú”ºePrq|ìa’�<~ &»>rDÿfž¬t¦SL\'¶Åe',NULL,NULL),(17,'úi‚ßÒ…&)®ºŠ‰wµ~@ü·}\Zz(²lºbY',NULL,NULL,NULL,NULL,NULL,'[B@12cb85a','[B@12cb85a','úi‚ßÒ…&)®ºŠ‰wµ~@ü·}\Zz(²lºbY',NULL,NULL),(18,'hey',NULL,NULL,NULL,NULL,NULL,'hey','hey','hey',NULL,NULL),(19,'boi',NULL,NULL,NULL,NULL,NULL,'boi','boi','boi',NULL,NULL),(20,'bi',NULL,NULL,NULL,NULL,NULL,'bi','bi','bi',NULL,NULL),(21,'ta',NULL,NULL,NULL,NULL,NULL,'ta','ta','ta',NULL,NULL),(22,'so',NULL,NULL,NULL,NULL,NULL,'so','so','so',NULL,NULL),(23,'po',NULL,NULL,NULL,NULL,NULL,'po','po','po',NULL,NULL),(24,'pee',NULL,NULL,NULL,NULL,NULL,'pee','pee','pee',NULL,NULL),(25,'pa',NULL,NULL,NULL,NULL,NULL,'pa','pa','pa',NULL,NULL),(26,'[B@16b6e651',NULL,NULL,NULL,NULL,NULL,'[B@57cb44fa','ConorT38','blizzardofozz1',NULL,NULL),(27,'[B@e707a58',NULL,NULL,NULL,NULL,NULL,'[B@73f782ca','cothompson16','password',NULL,NULL),(28,'[B@21624eb5',NULL,NULL,NULL,NULL,NULL,'[B@57eeab61','[B@ae0bed2','ç¤G~ÉEi|ägì{�ÂÄ…ÙSˆ* <•m7}Œ½',NULL,NULL),(29,'[B@523fe37f',NULL,NULL,NULL,NULL,NULL,'[B@682aad63','[B@4c498e06','ìÝ—@\\y´îw‘�Òµx“Ù°j‚S\r÷)ÚïÎõ',NULL,NULL),(30,'plp',NULL,NULL,NULL,NULL,NULL,'plp@plp.xom','plp','plp',NULL,NULL),(31,'[B@425ba800',NULL,NULL,NULL,NULL,NULL,'[B@73c9fdc1','[B@77869304','×CÈÔ	&D˜¦É�K•ä¢KmV1_ç÷ 7¡²',NULL,NULL),(32,'Conor Thompson',NULL,NULL,NULL,NULL,NULL,'sho@la.nci','sho','sho',NULL,NULL);
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

-- Dump completed on 2018-04-27 16:08:11
