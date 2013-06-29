-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.28-rc-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema mc31
--

CREATE DATABASE IF NOT EXISTS mc31;
USE mc31;

--
-- Definition of table `artigo`
--

DROP TABLE IF EXISTS `artigo`;
CREATE TABLE `artigo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `conteudo` varchar(255) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `categoria` int(10) unsigned NOT NULL,
  `dtPublicacao` datetime DEFAULT NULL,
  `dtCriacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artigo`
--

/*!40000 ALTER TABLE `artigo` DISABLE KEYS */;
INSERT INTO `artigo` (`id`,`titulo`,`conteudo`,`autor`,`categoria`,`dtPublicacao`,`dtCriacao`) VALUES 
 (29,'JSF 2 - O que vem de novo?','. Ajax Support\r\n. MegaListeners\r\n. Resources\r\n. Composite Components\r\n. Bookmarks\r\n. New scopes\r\n. etc','Ed Burns',1,NULL,NULL),
 (30,'EJB 3.1 - Devo usar?','Deve sim. Muitas melhorias interessantes ...','Reza Rahman',1,NULL,NULL),
 (31,'JBoss ESB Primer','http://www.jboss.org/events/javaone/javaoneVideo2.html','Burr Sutter',1,NULL,NULL);
/*!40000 ALTER TABLE `artigo` ENABLE KEYS */;


--
-- Definition of table `artigo_rotulo`
--

DROP TABLE IF EXISTS `artigo_rotulo`;
CREATE TABLE `artigo_rotulo` (
  `artigo` int(10) unsigned NOT NULL DEFAULT '0',
  `rotulo` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`artigo`,`rotulo`),
  KEY `FK_ROTULO` (`rotulo`),
  CONSTRAINT `FKARTIGO` FOREIGN KEY (`artigo`) REFERENCES `artigo` (`id`),
  CONSTRAINT `FK_ROTULO` FOREIGN KEY (`rotulo`) REFERENCES `rotulo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artigo_rotulo`
--

/*!40000 ALTER TABLE `artigo_rotulo` DISABLE KEYS */;
INSERT INTO `artigo_rotulo` (`artigo`,`rotulo`) VALUES 
 (29,24),
 (29,25),
 (30,26),
 (30,27),
 (31,28),
 (31,29);
/*!40000 ALTER TABLE `artigo_rotulo` ENABLE KEYS */;


--
-- Definition of table `autor`
--

DROP TABLE IF EXISTS `autor`;
CREATE TABLE `autor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(90) NOT NULL,
  `telefone` varchar(16) NOT NULL,
  `foto` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `autor`
--

/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;


--
-- Definition of table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categoria`
--

/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id`,`nome`) VALUES 
 (1,'java'),
 (2,'flex'),
 (3,'php'),
 (4,'python'),
 (5,'c++');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;


--
-- Definition of table `rotulo`
--

DROP TABLE IF EXISTS `rotulo`;
CREATE TABLE `rotulo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rotulo`
--

/*!40000 ALTER TABLE `rotulo` DISABLE KEYS */;
INSERT INTO `rotulo` (`id`,`nome`) VALUES 
 (27,'ejb'),
 (26,'ejb31'),
 (28,'esb'),
 (29,'jboss'),
 (25,'jsf'),
 (24,'jsf2');
/*!40000 ALTER TABLE `rotulo` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
