-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.5.9-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para gespro
CREATE DATABASE IF NOT EXISTS `gespro` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gespro`;

-- Volcando estructura para tabla gespro.asignacion_entregables
CREATE TABLE IF NOT EXISTS `asignacion_entregables` (
  `idasignacion_entregables` int(11) NOT NULL AUTO_INCREMENT,
  `idfase_proyecto` int(11) DEFAULT NULL,
  `identregable` int(11) DEFAULT NULL,
  `porcentaje` int(11) NOT NULL,
  PRIMARY KEY (`idasignacion_entregables`),
  KEY `FK_Entregable_idx` (`identregable`),
  KEY `FK_FaseProyecto_idx` (`idfase_proyecto`),
  CONSTRAINT `FK_Entregable` FOREIGN KEY (`identregable`) REFERENCES `entregable` (`identregable`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_FaseProyecto` FOREIGN KEY (`idfase_proyecto`) REFERENCES `fase_proyecto` (`idfase_proyecto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gespro.asignar_adscrito
CREATE TABLE IF NOT EXISTS `asignar_adscrito` (
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gespro.avance
CREATE TABLE IF NOT EXISTS `avance` (
  `idavance` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `idproyecto` int(11) DEFAULT NULL,
  `archivo` mediumblob NOT NULL,
  `terminado` tinyint(1) DEFAULT NULL,
  `idasignacion_entregables` int(11) DEFAULT NULL,
  PRIMARY KEY (`idavance`),
  KEY `ID_PROYECTO_idx` (`idproyecto`),
  KEY `IDASIGNACION_idx` (`idasignacion_entregables`),
  CONSTRAINT `IDASIGNACION` FOREIGN KEY (`idasignacion_entregables`) REFERENCES `asignacion_entregables` (`idasignacion_entregables`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ID_PROYECTO` FOREIGN KEY (`idproyecto`) REFERENCES `proyecto` (`idproyecto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gespro.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `idempleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gespro.entregable
CREATE TABLE IF NOT EXISTS `entregable` (
  `identregable` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `archivo` mediumblob NOT NULL,
  PRIMARY KEY (`identregable`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gespro.fase
CREATE TABLE IF NOT EXISTS `fase` (
  `idfase` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idfase`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gespro.fase_proyecto
CREATE TABLE IF NOT EXISTS `fase_proyecto` (
  `idfase_proyecto` int(11) NOT NULL AUTO_INCREMENT,
  `idproyecto` int(11) DEFAULT NULL,
  `idfase` int(11) DEFAULT NULL,
  `porcentaje` int(11) NOT NULL,
  PRIMARY KEY (`idfase_proyecto`),
  KEY `FK_FASE_idx` (`idfase`) USING BTREE,
  KEY `FK_PROYECTO_idx` (`idproyecto`) USING BTREE,
  CONSTRAINT `FK_FASE` FOREIGN KEY (`idfase`) REFERENCES `fase` (`idfase`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_PROYECTO` FOREIGN KEY (`idproyecto`) REFERENCES `proyecto` (`idproyecto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gespro.proyecto
CREATE TABLE IF NOT EXISTS `proyecto` (
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gespro.puesto
CREATE TABLE IF NOT EXISTS `puesto` (
  `idpuesto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idpuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gespro.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `idrol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idrol`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gespro.tipo
CREATE TABLE IF NOT EXISTS `tipo` (
  `idtipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idtipo`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
