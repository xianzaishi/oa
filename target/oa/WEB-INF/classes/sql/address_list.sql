/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-08-12 10:17:27
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `address_list`
-- ----------------------------
DROP TABLE IF EXISTS `address_list`;
CREATE TABLE `address_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address_list
-- ----------------------------
INSERT INTO `address_list` VALUES ('6', 'asd', 'asd', '1');
INSERT INTO `address_list` VALUES ('7', 'dsa', 'dsa', '6');
INSERT INTO `address_list` VALUES ('8', '张三', '132132132132', '5');
INSERT INTO `address_list` VALUES ('9', '李四', '123123123123', '5');
INSERT INTO `address_list` VALUES ('10', 'aaa', 'aaa', '1');
INSERT INTO `address_list` VALUES ('11', '姓名:', '123123123', '4');
INSERT INTO `address_list` VALUES ('12', 'asd', 'asd', '5');
