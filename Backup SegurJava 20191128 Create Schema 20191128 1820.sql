-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema segurjava
--

CREATE DATABASE IF NOT EXISTS segurjava;
USE segurjava;

--
-- Definition of table `alarmas`
--

DROP TABLE IF EXISTS `alarmas`;
CREATE TABLE `alarmas` (
  `idAlarma` int(10) unsigned NOT NULL auto_increment COMMENT 'Identificador del salto de la alarma',
  `idSensor` int(10) unsigned NOT NULL COMMENT 'Identificador del sensor que provocó el salto de la alarma',
  `fechaHora` datetime NOT NULL COMMENT 'Fecha y hora de cuando se produce el salto de la alarma',
  PRIMARY KEY  (`idAlarma`),
  KEY `FK_alarmas_1` (`idSensor`),
  CONSTRAINT `FK_alarmas_1` FOREIGN KEY (`idSensor`) REFERENCES `sensores` (`idSensor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `alarmas`
--

/*!40000 ALTER TABLE `alarmas` DISABLE KEYS */;
/*!40000 ALTER TABLE `alarmas` ENABLE KEYS */;


--
-- Definition of table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `dni` varchar(9) NOT NULL COMMENT 'D.N.I./NIF Personas Fisicas y Judiricas\nMás Información en: http://www.juntadeandalucia.es/servicios/madeja/contenido/recurso/677',
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(75) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `poblacion` varchar(60) NOT NULL,
  `provincia` varchar(50) NOT NULL,
  `codpostal` varchar(5) default NULL,
  `iban` varchar(24) NOT NULL COMMENT 'Cuenta Corriente Bancaria formato IBAN',
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clientes`
--

/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`dni`,`nombre`,`apellidos`,`direccion`,`poblacion`,`provincia`,`codpostal`,`iban`) VALUES 
 ('01234567A','Juan Francisco','Alonso','Rue Dos Mondeigas, 3','Badajoz','Badajoz','06005','ES2114650100722030876293'),
 ('12345678B','Teodoro','Quintana','Adarve Del Obispo Alvarez De Castro','Caceres','Caceres','10003','ES2120380001536457546593');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;


--
-- Definition of table `contratos`
--

DROP TABLE IF EXISTS `contratos`;
CREATE TABLE `contratos` (
  `idContrato` int(10) unsigned NOT NULL auto_increment COMMENT 'Identificador del contrato',
  `direccion` varchar(100) NOT NULL COMMENT 'Dirección del contrato',
  `poblacion` varchar(60) NOT NULL COMMENT 'Población del contrato',
  `provincia` varchar(50) NOT NULL COMMENT 'Provincia del contrato',
  `codpostal` varchar(5) default NULL COMMENT 'Código Postal del contrato',
  `estado` bit(1) NOT NULL default '' COMMENT 'Estado de situación del contrato ALTA/BAJA (1/0)',
  `avisoPolicia` bit(1) NOT NULL default '\0' COMMENT 'Servicio de aviso a la policia contratado SI/NO (1/0)',
  `idCliente` varchar(9) NOT NULL COMMENT 'Identificador del cliente al que pertenece el contrato',
  PRIMARY KEY  (`idContrato`),
  KEY `FK_contratos_1` (`idCliente`),
  CONSTRAINT `FK_contratos_1` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contratos`
--

/*!40000 ALTER TABLE `contratos` DISABLE KEYS */;
/*!40000 ALTER TABLE `contratos` ENABLE KEYS */;


--
-- Definition of table `log_policia`
--

DROP TABLE IF EXISTS `log_policia`;
CREATE TABLE `log_policia` (
  `idLogPolicia` int(10) unsigned NOT NULL auto_increment COMMENT 'Identificador log de aviso a la policía',
  `direccion` varchar(100) NOT NULL,
  `poblacion` varchar(60) NOT NULL,
  `provincia` varchar(50) NOT NULL,
  `codpostal` varchar(5) default NULL COMMENT 'Codigo Postal',
  `fechahora` datetime NOT NULL COMMENT 'Fecha y hora de cuando se produce el salto de la alarma',
  PRIMARY KEY  (`idLogPolicia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `log_policia`
--

/*!40000 ALTER TABLE `log_policia` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_policia` ENABLE KEYS */;


--
-- Definition of table `sensores`
--

DROP TABLE IF EXISTS `sensores`;
CREATE TABLE `sensores` (
  `idSensor` int(10) unsigned NOT NULL auto_increment COMMENT 'Identificador del sensor',
  `ubicacion` varchar(45) NOT NULL COMMENT 'Zona de la casa/oficina donde se encuentra ubicado el sensor',
  `estado` bit(1) NOT NULL default '' COMMENT 'Estado del sensor OFF/ON (0/1)',
  `modo` bit(1) NOT NULL default '\0' COMMENT 'Modo de Salto de alarma NORMAL/DETECCION (0/1)',
  `idContrato` int(10) unsigned NOT NULL COMMENT 'Identificador del contrato al que pertenece el sensor',
  PRIMARY KEY  (`idSensor`),
  KEY `FK_sensores_1` USING BTREE (`idContrato`),
  CONSTRAINT `FK_sensores_1` FOREIGN KEY (`idContrato`) REFERENCES `contratos` (`idContrato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sensores`
--

/*!40000 ALTER TABLE `sensores` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensores` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
