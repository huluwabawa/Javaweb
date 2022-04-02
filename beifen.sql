/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.25 : Database - day17
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`day17` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `day17`;

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `name` varchar(10) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `dept` */

insert  into `dept`(`name`,`password`) values ('admin','123');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb3;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`gender`,`age`,`address`,`qq`,`email`,`username`,`password`) values (1,'张三','男',23,'四川','2001','2001@qq.com','zhangsan','123'),(26,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(27,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(34,'麻子','男',25,'广东','2006','2006@qq.com',NULL,NULL),(40,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(41,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(42,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(43,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(44,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(45,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(46,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(47,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(49,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(50,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(51,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(52,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(53,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(54,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(55,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(56,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(57,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(58,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(59,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(60,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(61,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(62,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(63,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(64,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(65,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(66,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(67,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(68,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(69,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(71,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(72,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(73,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(74,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(75,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(76,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(77,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(78,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(79,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(80,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(81,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL),(82,'刘岩','女',20,'重庆','2005','2005@qq.com',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
