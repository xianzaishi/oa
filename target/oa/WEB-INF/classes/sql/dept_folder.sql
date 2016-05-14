/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-08-12 10:17:47
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `dept_folder`
-- ----------------------------
DROP TABLE IF EXISTS `dept_folder`;
CREATE TABLE `dept_folder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept_folder
-- ----------------------------
INSERT INTO `dept_folder` VALUES ('1', '院办');
INSERT INTO `dept_folder` VALUES ('4', '信息科');
INSERT INTO `dept_folder` VALUES ('5', '党办');
