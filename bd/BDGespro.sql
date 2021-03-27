-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: gespro
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.18-MariaDB

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
-- Table structure for table `asignacion_entregables`
--

DROP TABLE IF EXISTS `asignacion_entregables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asignacion_entregables` (
  `idasignacion_entregables` int(11) NOT NULL AUTO_INCREMENT,
  `idfase_proyecto` int(11) DEFAULT NULL,
  `identregable` int(11) DEFAULT NULL,
  `porcentaje` int(11) NOT NULL,
  PRIMARY KEY (`idasignacion_entregables`),
  KEY `FK_Entregable_idx` (`identregable`),
  KEY `FK_FaseProyecto_idx` (`idfase_proyecto`) USING BTREE,
  CONSTRAINT `FK_Entregable` FOREIGN KEY (`identregable`) REFERENCES `entregable` (`identregable`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_FaseTipoAsignacion` FOREIGN KEY (`idfase_proyecto`) REFERENCES `fase_tipo` (`idfase_proyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignacion_entregables`
--

LOCK TABLES `asignacion_entregables` WRITE;
/*!40000 ALTER TABLE `asignacion_entregables` DISABLE KEYS */;
INSERT INTO `asignacion_entregables` VALUES (1,1,1,10);
INSERT INTO `asignacion_entregables` VALUES (2,2,2,10);
/*!40000 ALTER TABLE `asignacion_entregables` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignar_adscrito`
--

DROP TABLE IF EXISTS `asignar_adscrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asignar_adscrito` (
  `idasignar_adscrito` int(11) NOT NULL AUTO_INCREMENT,
  `idempleado` int(11) DEFAULT NULL,
  `idproyecto` int(11) DEFAULT NULL,
  `idpuesto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idasignar_adscrito`),
  KEY `ID_PROYECTO_idx` (`idproyecto`),
  KEY `ID_EMPLEADOINTER_idx` (`idempleado`),
  KEY `ID_PUESTOINTER_idx` (`idpuesto`),
  CONSTRAINT `ID_EMPLEADOINTER` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ID_PROYECTOINTER` FOREIGN KEY (`idproyecto`) REFERENCES `proyecto` (`idproyecto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ID_PUESTOINTER` FOREIGN KEY (`idpuesto`) REFERENCES `puesto` (`idpuesto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignar_adscrito`
--

LOCK TABLES `asignar_adscrito` WRITE;
/*!40000 ALTER TABLE `asignar_adscrito` DISABLE KEYS */;
INSERT INTO `asignar_adscrito` VALUES (6,1,1,1);
INSERT INTO `asignar_adscrito` VALUES (8,3,1,2);
/*!40000 ALTER TABLE `asignar_adscrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avance`
--

DROP TABLE IF EXISTS `avance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avance` (
  `idavance` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(256) NOT NULL,
  `idproyecto` int(11) DEFAULT NULL,
  `archivo` mediumblob NOT NULL,
  `terminado` tinyint(1) DEFAULT NULL,
  `idasignacion_entregables` int(11) DEFAULT NULL,
  `nombreoriginal` varchar(50) DEFAULT NULL,
  `mime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idavance`),
  KEY `ID_PROYECTO_idx` (`idproyecto`),
  KEY `IDASIGNACION_idx` (`idasignacion_entregables`),
  CONSTRAINT `IDASIGNACION` FOREIGN KEY (`idasignacion_entregables`) REFERENCES `asignacion_entregables` (`idasignacion_entregables`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ID_PROYECTO` FOREIGN KEY (`idproyecto`) REFERENCES `proyecto` (`idproyecto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avance`
--

LOCK TABLES `avance` WRITE;
/*!40000 ALTER TABLE `avance` DISABLE KEYS */;
INSERT INTO `avance` VALUES (40,'Aun no se termina',1,'public static final String ANSI_BLACK = \"\\u001B[30m\";\r\npublic static final String ANSI_RED = \"\\u001B[31m\";\r\npublic static final String ANSI_GREEN = \"\\u001B[32m\";\r\npublic static final String ANSI_YELLOW = \"\\u001B[33m\";\r\npublic static final String ANSI_BLUE = \"\\u001B[34m\";\r\npublic static final String ANSI_PURPLE = \"\\u001B[35m\";\r\npublic static final String ANSI_CYAN = \"\\u001B[36m\";\r\npublic static final String ANSI_WHITE = \"\\u001B[37m\";',0,1,NULL,NULL);
INSERT INTO `avance` VALUES (41,'Ya se termino este entregable.',1,'public static final String ANSI_BLACK = \"\\u001B[30m\";\r\npublic static final String ANSI_RED = \"\\u001B[31m\";\r\npublic static final String ANSI_GREEN = \"\\u001B[32m\";\r\npublic static final String ANSI_YELLOW = \"\\u001B[33m\";\r\npublic static final String ANSI_BLUE = \"\\u001B[34m\";\r\npublic static final String ANSI_PURPLE = \"\\u001B[35m\";\r\npublic static final String ANSI_CYAN = \"\\u001B[36m\";\r\npublic static final String ANSI_WHITE = \"\\u001B[37m\";',1,1,NULL,NULL);
INSERT INTO `avance` VALUES (42,'Ya se termino este entregable.',1,'DDYL-39W2-4NKV-ASE5-X79Y\r\n\r\n',1,1,NULL,NULL);
/*!40000 ALTER TABLE `avance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `idempleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombrecompleto` varchar(128) NOT NULL,
  `fechaN` varchar(45) NOT NULL DEFAULT '',
  `telefono` varchar(45) NOT NULL,
  `curp` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `domicilio` varchar(45) NOT NULL,
  `gradoestudio` varchar(45) NOT NULL,
  `idrol` int(11) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `estatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`idempleado`),
  UNIQUE KEY `curp_UNIQUE` (`curp`),
  KEY `IDROL_idx` (`idrol`),
  CONSTRAINT `IDROL` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Raúl Genaro','02/04/2000','771309865','AAHMS2000','sterplay2010@gmail.com','Temixco, Morelos','TSU',5,'123',1);
INSERT INTO `empleado` VALUES (2,'Felipe','15/11/1995','77712345689','FMHMS1998','felipe@gmail.com','Cuernavaca, Morelos','Ingeniería',4,'123',1);
INSERT INTO `empleado` VALUES (3,'Luis','23/09/1998','7771309524','LQCHMS1998','luis@gmail.com','Jiutepec, Morelos','Doctorado',5,'123',1);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entregable`
--

DROP TABLE IF EXISTS `entregable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entregable` (
  `identregable` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `archivo` mediumblob NOT NULL,
  `nombreoriginal` varchar(50) DEFAULT NULL,
  `mime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`identregable`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entregable`
--

LOCK TABLES `entregable` WRITE;
/*!40000 ALTER TABLE `entregable` DISABLE KEYS */;
INSERT INTO `entregable` VALUES (1,'DFR','DDYL-39W2-4NKV-ASE5-X79Y\r\n\r\n','dfr.txt','text/plain');
INSERT INTO `entregable` VALUES (2,'Consultas','﻿sample_airbnb\r\nlistingsAndReviews\r\n\r\n5 puntos al primeor en resolver todas las consultas.\r\n1. ¿Cuántas propiedades cuentan con una última review en 2019?\r\ndb.listingsAndReviews.aggregate(\r\n	{$match: {last_review: {$gte: ISODate(\'2019-01-01\'), $lte: ISODate(\'2019-12-31\')}}},\r\n	{$project: { name: 1, _id: 0}},\r\n	{$count: \"total\"}\r\n)\r\n\r\n2. ¿Cuántos reviews contienen la palabra \"good\" en el texto del comentario?\r\ndb.listingsAndReviews.aggregate(\r\n	{$match: {\"reviews.comments\": {$regex: \'good\'}}},\r\n	{$project: { name: 1, _id: 0}},\r\n	{$count: \"total\"}\r\n)\r\n\r\n3. Fecha y nombre de la primer review de la propiedad con _id: 10059244\r\ndb.listingsAndReviews.aggregate(\r\n	{$match: {_id: \"10059244\"}},\r\n	{$project: {date: {$first: \'$reviews.date\'}, reviewer_name: {$first: \'$reviews.reviewer_name\'}, _id: 0}}\r\n)\r\n\r\ndb.listingsAndReviews.aggregate(\r\n	{$match: {_id: \"1001265\"}},\r\n	{$project: { date: {$arrayElemAt: [\'$reviews.date\',1]}, \r\n	             reviewer_name: {$arrayElemAt: [\'$reviews.reviewer_name\',1]},\r\n	             _id: 0 }\r\n	}\r\n)\r\n\r\n4. Nombre de propiedades cuyo número mínimo de noches sea igual al número máximo de noches.\r\ndb.listingsAndReviews.aggregate(\r\n	{$match: { $expr: { $eq: [\'$minimum_nights\', \'$maximum_nights\']}}},\r\n	{$project: { name:1, _id: 0 }}\r\n)\r\n\r\ndb.listingsAndReviews.find(\r\n	{ $expr: { $eq: [\'$minimum_nights\', \'$maximum_nights\']}},\r\n	{ name:1, _id:0}\r\n).count()\r\n\r\n5. Promedio de valoraciones de las propiedades que no ofrecen wifi.\r\nvar r = db.listingsAndReviews.aggregate(\r\n	{$match: { ammenities: { $ne: \"Wifi\"}}},\r\n	{$project: { _id:0, ammenities: 1, scores: {$objectToArray: \'$review_scores\'}}},\r\n	{$match: { scores: { $exists: 1, $not: []}}}\r\n)\r\n\r\nvar avg = 0;\r\nvar sum = 0;\r\nvar count = 0;\r\nr.forEach(elem => {\r\n	elem.scores.forEach(e => {\r\n		if(e.k != \"review_scores_rating\"){\r\n			count++;\r\n			sum += e.v\r\n		}\r\n	})\r\n	avg = sum/count;\r\n})\r\nprint(avg)\r\n\r\n6. ¿Cuáles son los distintos tipos de camas con los que cuentan las propiedades?\r\ndb.listingsAndReviews.aggregate(\r\n	{$group: { _id: \"$bed_type\"}}\r\n)\r\n\r\n7. ¿Cuántas propiedades existen por tipo de propiedad?\r\ndb.listingsAndReviews.aggregate(\r\n	{$group: { _id: \"$property_type\", cantidad: { $sum: 1}}}\r\n)\r\n\r\n8. ¿Cuántas propiedades existen por país?\r\ndb.listingsAndReviews.aggregate(\r\n	{$group: { _id: \"$address.country\", cantidad: { $sum: 1}}}\r\n)\r\n\r\n9. Imagina que tienes un API Rest que recibe como entrada un listado de nombres de propiedad y las coordenadas donde se ubican. Como respuesta, el API te devuelve un mapa con un marcador colocado en las ubicaciones proporcionadas. ¿Qué consulta deberías preparar para alimentar tu API?\r\ndb.listingsAndReviews.aggregate(\r\n	{$project: { _id: 0, name: 1, \"address.location.coordinates\": 1}}\r\n)\r\n\r\n10. ¿En qué paises existen propiedades donde no se admite fumar?\r\ndb.listingsAndReviews.aggregate(\r\n	{$match: { ammenities: { $ne: \"Smoking allowed\"}}},\r\n	{$group: { _id: \"$address.country\"}}\r\n)\r\n\r\nsample_analytics\r\naccounts\r\ntransactions\r\ncustomers\r\n\r\n5 puntos al primero en resolver ambas consultas.\r\nInvestiga el funcionamiento del stage lookup. Usando el aggregation framework, realiza consultas para devolver los resultados solicitados por los siguientes enunciados:\r\n\r\n1. Nombre, correo y productos de inversión de las cuentas que posee un cliente. (accounts/customers)\r\ndb.customers.aggregate(\r\n	{$unwind: \"$accounts\"},\r\n	{$lookup: {\r\n		from: \"accounts\",\r\n		localField: \"accounts\",\r\n		foreignField: \"account_id\",\r\n		as: \"join\"\r\n	}},\r\n	{$project: {name: 1, email: 1, _id:0, \"join.products\": 1}}\r\n).pretty()\r\n\r\n2. Cantidad de transacciones realizadas por los clientes que nacieron en 1977.\r\ndb.customers.aggregate(\r\n{$unwind:\'$accounts\'},\r\n    {$match:{\"birthdate\":{$gte:ISODate(\'1977-01-01\'), $lte:ISODate(\'1977-12-31\')}}},\r\n	{$lookup: {\r\n		from: \"transactions\",\r\n		localField: \"accounts\",\r\n		foreignField: \"account_id\",\r\n		as: \"join\"\r\n	}},\r\n	{$project: {name: 1, email: 1, _id: 0, \"join.transaction_count\": 1}}\r\n).pretty()\r\n\r\nsample_restaurants\r\nrestaurants\r\n\r\n1. ¿Cuál es el promedio de los scores obtenidos por cada restaurante? Considera que el arreglo grades contine múltiples evaluaciones en distintas fechas.\r\ndb.restaurants.aggregate(\r\n	{$unwind: \"$grades\"},\r\n	{$group: {_id: \"$name\", promedio: {$avg: \"$grades.score\"}}}\r\n)\r\n\r\n2. ¿Cuántos restaurantes tienen al menos un score superior a 8 y de grado A?\r\ndb.restaurants.aggregate(\r\n	{$unwind: \"$grades\"},\r\n	{$match: {\"grades.score\": {$gt: 8}, \"grades.grade\": {$eq: \"A\"}}},\r\n	{$group: { _id: \"$name\"}},\r\n	{$count: \"total\"}\r\n)\r\n\r\n3. Nombre del tercer tipo de cocina con mayor cantidad de restaurantes.\r\ndb.restaurants.aggregate(\r\n	{$group: { _id: \"$cuisine\", cantidad: {$sum: 1}}},\r\n	{$sort: {cantidad: -1, _id: 1}},\r\n	{$skip: 2},\r\n	{$limit: 1}\r\n)\r\n\r\n4. Nombre del antepenúltimo restaurante con mayor score promedio.\r\ndb.restaurants.aggregate(\r\n	{$unwind: \"$grades\"},\r\n	{$group: {_id: \"$name\", promedio: {$avg: \"$grades.score\"}}},\r\n	{$match: {promedio: {$gte: 0}}},\r\n	{$sort: {promedio: 1, _id: 1}},\r\n	{$skip: 2},\r\n	{$limit: 1}\r\n)\r\n\r\n5. ¿Cuántos restaurantes tiene al menos una valoración con grado B?\r\ndb.restaurants.find({\"grades.grade\": {$eq:\"B\"}}).count()\r\n\r\n6. ¿Cuántos restaurantes sirven ensaladas?\r\ndb.restaurants.find({$or: [{cuisine: {$regex: \"Salad\"}}, {cuisine: {$regex: \"salad\"}}]}).count()\r\n\r\n7. Nombre y tipo de cocina de los restaurantes que se encuentran en Manhattan.\r\ndb.restaurants.find({borough: {$eq: \"Manhattan\"}}, {name: 1, cuisine: 1, _id: 0})\r\n\r\n8. Nombre del restaurante que haya obtenido el máximo score.\r\ndb.restaurants.aggregate(\r\n	{$unwind: \"$grades\"},\r\n	{$group: {_id: \"$name\", promedio: {$avg: \"$grades.score\"}}},\r\n	{$match: {promedio: {$gte: 0}}},\r\n	{$sort: {promedio: -1, _id: 1}},\r\n	{$limit: 1},\r\n	{$project: { nombre: \"$_id\", _id: 0}}\r\n)\r\n\r\n9. Promedio de valoraciones por tipo de cocina.\r\ndb.restaurants.aggregate(\r\n	{$unwind: \"$grades\"},\r\n	{$group: {_id: \"$cuisine\", promedio: {$avg: \"$grades.score\"}}},\r\n	{$match: {promedio: {$gte: 0}}},\r\n	{$sort: {promedio: -1, _id: 1}}\r\n)\r\n\r\n10. Nombre de los restaurantes con solo 2 valoraciones.\r\ndb.restaurants.find({grades: {$size: 2}})\r\n\r\nsample_supplies\r\nsales\r\n\r\nInvestiga los operadores de agregación necesarios para devolver los resultados de los siguientes enunciados:\r\n\r\n1. _id, fecha y total de las ventas realizadas.\r\ndb.sales.aggregate(\r\n	{$unwind: \"$items\"},\r\n	{$group: {_id: \"$saleDate\",  cantidad: {$sum: {$multiply: [\"$items.price\",\"$items.quantity\"]}}}},\r\n)\r\n\r\n2. Correo electrónico y género del cliente que realizó la mayor compra.\r\ndb.sales.aggregate(\r\n	{$unwind: \"$items\"},\r\n	{$group: {_id: {email: \"$customer.email\", gender: \"$customer.gender\"},  cantidad: {$sum: {$multiply: [\"$items.price\",\"$items.quantity\"]}}}},\r\n	{$sort: {cantidad: -1}},\r\n	{$limit: 1}\r\n)\r\n\r\n\r\n','consultas.txt','text/plain');
INSERT INTO `entregable` VALUES (3,'JPA Instrucciones','JPA RELACIONES\r\n@JsonBackReference //Es para las colecciones como list o set, van en @OneToMany.\r\n@JsonManagedReference //Son para los objetos que hacen la relacione @ManyToOne','jpa.txt','text/plain');
/*!40000 ALTER TABLE `entregable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fase`
--

DROP TABLE IF EXISTS `fase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fase` (
  `idfase` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idfase`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fase`
--

LOCK TABLES `fase` WRITE;
/*!40000 ALTER TABLE `fase` DISABLE KEYS */;
INSERT INTO `fase` VALUES (3,'Diseño');
INSERT INTO `fase` VALUES (2,'Mantenimiento');
INSERT INTO `fase` VALUES (1,'Planeación');
/*!40000 ALTER TABLE `fase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fase_tipo`
--

DROP TABLE IF EXISTS `fase_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fase_tipo` (
  `idfase_proyecto` int(11) NOT NULL AUTO_INCREMENT,
  `idtipo` int(11) DEFAULT NULL,
  `idfase` int(11) DEFAULT NULL,
  `porcentaje` int(11) NOT NULL,
  PRIMARY KEY (`idfase_proyecto`),
  KEY `FK_FASE_idx` (`idfase`) USING BTREE,
  KEY `FK_PROYECTO_idx` (`idtipo`) USING BTREE,
  CONSTRAINT `FK_FASE` FOREIGN KEY (`idfase`) REFERENCES `fase` (`idfase`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TIPO` FOREIGN KEY (`idtipo`) REFERENCES `tipo` (`idtipo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fase_tipo`
--

LOCK TABLES `fase_tipo` WRITE;
/*!40000 ALTER TABLE `fase_tipo` DISABLE KEYS */;
INSERT INTO `fase_tipo` VALUES (1,1,1,10);
INSERT INTO `fase_tipo` VALUES (2,1,3,10);
/*!40000 ALTER TABLE `fase_tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyecto` (
  `idproyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `duracion` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `nombrecliente` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL DEFAULT '',
  `costo` float NOT NULL,
  `idempleado` int(11) DEFAULT NULL,
  `idtipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproyecto`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `IDRESPONSABLE_idx` (`idempleado`) USING BTREE,
  KEY `IDTIPO_idx` (`idtipo`) USING BTREE,
  CONSTRAINT `IDRESPONSABLE` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `IDTIPO` FOREIGN KEY (`idtipo`) REFERENCES `tipo` (`idtipo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (1,'Stadia',365,'Cloud Gaming','Google Inc.','19/03/2021',1000000,3,1);
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puesto` (
  `idpuesto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idpuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` VALUES (1,'Diseñador');
INSERT INTO `puesto` VALUES (2,'Programador');
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idrol`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (4,'Administrador de Proyectos');
INSERT INTO `rol` VALUES (2,'Controlador');
INSERT INTO `rol` VALUES (1,'Coordinador');
INSERT INTO `rol` VALUES (5,'Empleado');
INSERT INTO `rol` VALUES (3,'Recursos Humanos');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `idtipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idtipo`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (2,'Arquitectura');
INSERT INTO `tipo` VALUES (1,'Software');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gespro'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-26 19:20:35
