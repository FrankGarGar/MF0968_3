-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyectomf0968
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Dumping data for table `almacenes`
--

LOCK TABLES `almacenes` WRITE;
/*!40000 ALTER TABLE `almacenes` DISABLE KEYS */;
INSERT INTO `almacenes` VALUES (1,'Bilbao','https://goo.gl/maps/DRs4LiVt78FnjQGZ6'),(2,'Barcelona','https://goo.gl/maps/ysMKaCr49ubbYDe77'),(3,'Madrid','https://goo.gl/maps/f5acZSUCS1r8tfLw6');
/*!40000 ALTER TABLE `almacenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `almacenes_almacen_items`
--

LOCK TABLES `almacenes_almacen_items` WRITE;
/*!40000 ALTER TABLE `almacenes_almacen_items` DISABLE KEYS */;
INSERT INTO `almacenes_almacen_items` VALUES (1,1),(1,2),(2,3);
/*!40000 ALTER TABLE `almacenes_almacen_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `almacenitems`
--

LOCK TABLES `almacenitems` WRITE;
/*!40000 ALTER TABLE `almacenitems` DISABLE KEYS */;
INSERT INTO `almacenitems` VALUES (1,10,1,NULL),(2,15,2,NULL),(3,3,1,NULL);
/*!40000 ALTER TABLE `almacenitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'resources/img/img1.png','Arroz muy bueno para el estomago. Arroz muy bueno para el estomago. Arroz muy bueno para el estomago. Arroz muy bueno para el estomago. Arroz muy bueno para el estomago.','Arroz Asado',3.00),(2,'resources/img/img2.jpg','Aceite Prueba ligero 0.4 con aroma agradable Aceite Prueba ligero 0.4 con aroma agradable Aceite Prueba ligero 0.4 con aroma agradable Aceite Prueba ligero 0.4 con aroma agradable','Aceite Prueba',5.21);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `productos_almacen_items`
--

LOCK TABLES `productos_almacen_items` WRITE;
/*!40000 ALTER TABLE `productos_almacen_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos_almacen_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Lete',40,_binary '\0','Javier','$2a$10$q77pb83IlnkKp329.9h3COj2K52CGLtwGsR9m7QlEcHkd3EYVqky6','ROLE_USER','M','user'),(2,'García García',26,_binary '\0','Francisco','$2a$10$IZ7MYxrJaUShwQN4JX3RDexatVLTLxK.WdXGb4U4wIBVLoxIL.KVq','ROLE_ADMIN','M','admin');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'proyectomf0968'
--

--
-- Dumping routines for database 'proyectomf0968'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-13 14:34:28
