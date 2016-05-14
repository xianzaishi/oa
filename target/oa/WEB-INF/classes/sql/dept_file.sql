/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-08-12 10:17:43
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `dept_file`
-- ----------------------------
DROP TABLE IF EXISTS `dept_file`;
CREATE TABLE `dept_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `folder_id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `file_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `creator` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept_file
-- ----------------------------
INSERT INTO `dept_file` VALUES ('14', '1', 'csstable.zip', '18', '2014-07-30 17:39:23', null);
INSERT INTO `dept_file` VALUES ('15', '1', '电话表新.xls', '19', '2014-07-30 17:39:35', null);
INSERT INTO `dept_file` VALUES ('28', '1', 'debug.log', '32', '2014-07-31 12:02:32', null);
INSERT INTO `dept_file` VALUES ('29', '1', 'master_preferences', '33', '2014-09-15 16:20:44', null);
INSERT INTO `dept_file` VALUES ('30', '1', 'IMG_0862.JPG', '34', '2014-09-22 16:40:26', 'admin');
INSERT INTO `dept_file` VALUES ('31', '4', 'Spring-Security-3.0.1-中文官方文档.pdf', '35', '2014-09-22 16:40:58', 'admin');
