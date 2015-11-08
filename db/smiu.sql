CREATE DATABASE  IF NOT EXISTS `smiu` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `smiu`;
-- MySQL dump 10.13  Distrib 5.6.27, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: smiu
-- ------------------------------------------------------
-- Server version	5.6.27-0ubuntu0.15.04.1

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
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_settings` text NOT NULL,
  `device_blank_id` int(11) NOT NULL,
  `protocol_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idDevice_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_device_device_blank1_idx` (`device_blank_id`),
  KEY `fk_device_protocol1_idx` (`protocol_id`),
  CONSTRAINT `FKa6wvto19vfqe2ogbk3dlj9vbv` FOREIGN KEY (`protocol_id`) REFERENCES `protocol` (`id`),
  CONSTRAINT `FKhr9xjygfo30uinsyruf48jqpn` FOREIGN KEY (`device_blank_id`) REFERENCES `device_blank` (`id`),
  CONSTRAINT `fk_device_device_blank1` FOREIGN KEY (`device_blank_id`) REFERENCES `device_blank` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_device_protocol1` FOREIGN KEY (`protocol_id`) REFERENCES `protocol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'{\"unitId\":1}',1,1,'Плата №1'),(2,'{\"unitId\":1}',1,1,'Плата №2'),(3,'{\"unitId\":1}',1,1,'Плата №3');
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_blank`
--

DROP TABLE IF EXISTS `device_blank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device_blank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_type` varchar(45) NOT NULL,
  `protocol_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `deviceType_UNIQUE` (`device_type`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_blank`
--

LOCK TABLES `device_blank` WRITE;
/*!40000 ALTER TABLE `device_blank` DISABLE KEYS */;
INSERT INTO `device_blank` VALUES (1,'MODEL_BOARD','MODBUS_MASTER');
/*!40000 ALTER TABLE `device_blank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `protocol`
--

DROP TABLE IF EXISTS `protocol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `protocol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `protocol_settings` text NOT NULL,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `protocol`
--

LOCK TABLES `protocol` WRITE;
/*!40000 ALTER TABLE `protocol` DISABLE KEYS */;
INSERT INTO `protocol` VALUES (1,'{\"portName\":\"/dev/ttyUSB0\",\"baudRate\":19200,\"databits\":8,\"stopbits\":1,\"parity\":\"none\",\"encoding\":\"rtu\",\"echo\":false,\"timePause\":10}','MODBUS_IN','MODBUS_RTU_MASTER');
/*!40000 ALTER TABLE `protocol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(45) DEFAULT NULL,
  `tag_time` timestamp NULL DEFAULT NULL,
  `tag_blank_id` int(11) NOT NULL,
  `device_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idTag_UNIQUE` (`id`),
  KEY `fk_tag_tag_blank1_idx` (`tag_blank_id`),
  KEY `fk_tag_device1_idx` (`device_id`),
  CONSTRAINT `fk_tag_device1` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tag_tag_blank1` FOREIGN KEY (`tag_blank_id`) REFERENCES `tag_blank` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_blank`
--

DROP TABLE IF EXISTS `tag_blank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag_blank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_descr` varchar(45) DEFAULT NULL,
  `tag_name` varchar(100) NOT NULL,
  `tag_id` varchar(45) NOT NULL,
  `delay` int(11) NOT NULL,
  `device_blank_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idTagBlank_UNIQUE` (`id`),
  KEY `fk_tag_blank_device_blank1_idx` (`device_blank_id`),
  CONSTRAINT `FKo7hiulmgyhsuy8ddygydnt49c` FOREIGN KEY (`device_blank_id`) REFERENCES `device_blank` (`id`),
  CONSTRAINT `fk_tag_blank_device_blank1` FOREIGN KEY (`device_blank_id`) REFERENCES `device_blank` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_blank`
--

LOCK TABLES `tag_blank` WRITE;
/*!40000 ALTER TABLE `tag_blank` DISABLE KEYS */;
INSERT INTO `tag_blank` VALUES (1,'Входное напряжение L1','in_v1','READ_HOLDING_REGS_3:INT16:1',50,1),(2,'Входное напряжение L2','in_v2','READ_HOLDING_REGS_3:INT16:2',50,1),(3,'Входное напряжение L3','in_v3','READ_HOLDING_REGS_3:INT16:3',50,1);
/*!40000 ALTER TABLE `tag_blank` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-08 21:32:58
