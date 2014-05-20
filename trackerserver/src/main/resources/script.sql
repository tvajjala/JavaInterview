CREATE DATABASE  IF NOT EXISTS `hazel_db`;
USE `hazel_db`;

CREATE TABLE `tbl_hazelmap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map_key` varchar(45) DEFAULT NULL,
  `map_value` blob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `map_key_UNIQUE` (`map_key`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET='utf8'