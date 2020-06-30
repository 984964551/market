/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - smbms
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`smbms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `smbms`;

/*Table structure for table `smbms_bill` */

DROP TABLE IF EXISTS `smbms_bill`;

CREATE TABLE `smbms_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `billCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '账单编码',
  `productName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `productDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品描述',
  `productUnit` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '单位',
  `productCount` decimal(20,2) DEFAULT NULL COMMENT '商品数量',
  `totalPrice` decimal(20,2) DEFAULT NULL COMMENT '账单总金额',
  `isPayment` int(10) DEFAULT NULL COMMENT '是否付款（1 未支付 2 已支付）',
  `providerId` bigint(20) DEFAULT NULL COMMENT '供应商ID',
  `proName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商名称',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `smbms_bill` */

insert  into `smbms_bill`(`id`,`billCode`,`productName`,`productDesc`,`productUnit`,`productCount`,`totalPrice`,`isPayment`,`providerId`,`creationDate`,`createdBy`,`modifyDate`,`modifyBy`) values (2,'111','112','2222','112','11.20','111.20',2,2,'2016-10-28 20:28:30',6,'2016-10-28 23:04:04',6),(3,'1','1','11','1','111.00','1.00',1,1,'2016-10-28 20:33:43',6,NULL,NULL),(4,' 12312','31231','3123123','2321','3123.00','12312.00',2,1,'2016-10-28 20:38:31',6,NULL,NULL),(9,'23','321',NULL,NULL,NULL,NULL,1,1,NULL,NULL,NULL,NULL),(10,'231','231',NULL,NULL,NULL,NULL,2,2,NULL,NULL,NULL,NULL),(11,'231','213',NULL,NULL,NULL,NULL,1,1,NULL,NULL,NULL,NULL),(12,'231','32',NULL,NULL,NULL,NULL,1,2,NULL,NULL,NULL,NULL),(13,'231','123',NULL,NULL,NULL,NULL,2,1,NULL,NULL,NULL,NULL),(14,'321','231',NULL,NULL,NULL,NULL,1,2,NULL,NULL,NULL,NULL),(15,'1323','132',NULL,NULL,NULL,NULL,2,1,NULL,NULL,NULL,NULL),(16,'123','213',NULL,NULL,NULL,NULL,2,2,NULL,NULL,NULL,NULL),(17,'312','312',NULL,NULL,NULL,NULL,2,1,NULL,NULL,NULL,NULL),(18,'12','23',NULL,NULL,NULL,NULL,1,1,NULL,NULL,NULL,NULL),(19,'12','123',NULL,NULL,NULL,NULL,2,2,NULL,NULL,NULL,NULL),(20,'15','132',NULL,NULL,NULL,NULL,2,2,NULL,NULL,NULL,NULL),(21,'21','132',NULL,NULL,NULL,NULL,1,2,NULL,NULL,NULL,NULL),(22,'34',NULL,NULL,NULL,NULL,NULL,2,1,NULL,NULL,NULL,NULL);

/*Table structure for table `smbms_provider` */

DROP TABLE IF EXISTS `smbms_provider`;

CREATE TABLE `smbms_provider` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `proCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商编码',
  `proName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商名称',
  `proDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商描述信息',
  `proContact` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商联系人',
  `proPhone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `proAddress` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `proFax` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '传真',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `smbms_provider` */

insert  into `smbms_provider`(`id`,`proCode`,`proName`,`proDesc`,`proContact`,`proPhone`,`proAddress`,`proFax`,`createdBy`,`creationDate`,`modifyBy`,`modifyDate`) values (1,'111','北京','222','HAOha','13212345611','23a','2222',1,'2014-02-12 00:00:00',6,'2016-10-28 22:54:36'),(2,'22','是的','23','萨达','1212312','123123','213',3,'2014-02-12 00:00:00',NULL,NULL);

/*Table structure for table `smbms_user` */

DROP TABLE IF EXISTS `smbms_user`;

CREATE TABLE `smbms_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `userPassword` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `gender` int(10) DEFAULT NULL COMMENT '性别（1 男 2 女）',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `userType` int(10) DEFAULT NULL COMMENT '用户类型（1 系统管理员 2 经理 3 普通员工 ）',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者（userId）',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `smbms_user` */

insert  into `smbms_user`(`id`,`userCode`,`userName`,`userPassword`,`gender`,`birthday`,`phone`,`address`,`userType`,`createdBy`,`creationDate`,`modifyBy`,`modifyDate`) values (2,'2','测试2','2',1,'1974-10-07','13523456789','那是的是第三代卡',1,1,'2016-10-17 19:33:02',NULL,NULL),(6,'1','人生大事','1',1,'2016-10-04','13523456789','',2,2,'2016-10-17 20:39:15',NULL,NULL),(9,'4','123','123456',2,'2013-10-15','13123456789','3216549887',2,6,'2016-10-18 23:06:25',6,'2016-10-18 23:08:38'),(10,'22','121212','323213',2,'2013-10-15','13123456789',NULL,1,2,'2016-10-18 23:06:25',NULL,NULL),(11,'2345','2231',NULL,2,'2013-10-15','13123456789',NULL,2,6,'2016-10-18 23:06:25',NULL,NULL),(12,'213','3213',NULL,1,'2013-10-15',NULL,NULL,2,6,'2016-10-18 23:06:25',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
