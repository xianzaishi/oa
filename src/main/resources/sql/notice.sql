/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-08-12 10:17:58
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `creator` varchar(100) DEFAULT NULL,
  `modifier` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', 'asd啊', '<p>\r\n	asd啊</p>\r\n', null, null, '2014-07-22 00:00:00', '2014-07-22 11:54:43');
INSERT INTO `notice` VALUES ('3', 'dsa', '<p>\r\n	das</p>\r\n', null, null, '2014-07-22 00:00:00', null);
INSERT INTO `notice` VALUES ('4', 'zxc', '<p>\r\n	zxc</p>\r\n', null, null, '2014-07-22 00:00:00', null);
INSERT INTO `notice` VALUES ('5', 'gaga哈哈', '<p>\r\n	哈哈</p>\r\n', null, null, '2014-07-22 00:00:00', null);
INSERT INTO `notice` VALUES ('6', 'z', '<p>\r\n	z</p>\r\n', null, null, '2014-07-22 11:54:59', null);
INSERT INTO `notice` VALUES ('7', 'asd', '<p>\r\n	asdasdasd</p>\r\n', null, null, '2014-09-22 15:54:45', null);
INSERT INTO `notice` VALUES ('8', '哈哈', '<p>\r\n	哈哈哈哈</p>\r\n', 'admin', 'admin', '2014-09-22 16:33:58', '2014-09-22 16:33:58');
INSERT INTO `notice` VALUES ('9', 'asd', '<p>\r\n	asd</p>\r\n', 'admin', 'admin', '2015-02-11 09:27:09', '2015-02-11 09:27:09');
INSERT INTO `notice` VALUES ('10', 'dsa', '<p>\r\n	dasaasd</p>\r\n', 'admin', 'admin', '2015-02-11 09:27:28', '2015-02-11 09:27:28');
