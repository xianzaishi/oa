/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-08-12 10:17:36
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `content`
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `channel_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` text,
  `creator` varchar(20) DEFAULT NULL,
  `modifier` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `file_upload` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES ('4', '1', '测试2222211', '<p>\r\n	211</p>\r\n', null, null, null, '2014-07-16 11:39:35', '');
INSERT INTO `content` VALUES ('5', '1', '测试222222', '<p>\r\n	2</p>\r\n', null, null, null, null, null);
INSERT INTO `content` VALUES ('6', '1', '测试2222222', '<p>\r\n	2</p>\r\n', null, null, null, null, null);
INSERT INTO `content` VALUES ('7', '1', '测试22222222', '<p>\r\n	2</p>\r\n', null, null, null, null, null);
INSERT INTO `content` VALUES ('8', '1', '测试22222222', '<p>\r\n	2</p>\r\n', null, null, null, null, null);
INSERT INTO `content` VALUES ('9', '1', '测试222222222', '<p>\r\n	2</p>\r\n', null, null, null, null, null);
INSERT INTO `content` VALUES ('10', '1', '测试222222222', '<p>\r\n	2</p>\r\n', null, null, null, null, null);
INSERT INTO `content` VALUES ('11', '1', '123', '<p>\r\n	123</p>\r\n', null, null, null, null, null);
INSERT INTO `content` VALUES ('12', '1', '123', '<p>\r\n	123</p>\r\n', null, null, null, null, null);
INSERT INTO `content` VALUES ('13', '1', 'asd哈哈', '<p>\r\n	asd哈哈</p>\r\n', null, null, '2014-07-15 16:36:57', '2014-07-16 11:40:02', '');
INSERT INTO `content` VALUES ('14', '1', '啊谁谁谁谁谁谁', '<p>\r\n	asd</p>\r\n', null, null, '2014-07-16 09:15:48', null, null);
INSERT INTO `content` VALUES ('16', '1', 'aa', '<p>\r\n	aa</p>\r\n', null, null, '2014-07-16 11:40:44', null, null);
INSERT INTO `content` VALUES ('17', '1', 'ss', '<p>\r\n	ss</p>\r\n', null, null, '2014-07-16 11:40:48', null, null);
INSERT INTO `content` VALUES ('18', '1', 'dd', '<p>\r\n	dd</p>\r\n', null, null, '2014-07-16 11:40:52', null, null);
INSERT INTO `content` VALUES ('19', '1', 'ff', '<p>\r\n	ff</p>\r\n', null, null, '2014-07-16 11:40:57', null, null);
INSERT INTO `content` VALUES ('20', '1', 'xx', '<p>\r\n	xx</p>\r\n', null, null, '2014-07-16 11:41:05', null, null);
INSERT INTO `content` VALUES ('21', '1', 'qweqwe', '<p>\r\n	qweqwe</p>\r\n', null, null, '2014-07-16 11:41:11', null, null);
INSERT INTO `content` VALUES ('22', '1', 'ewqe', '<p>\r\n	wq</p>\r\n', null, null, '2014-07-16 11:41:16', null, null);
INSERT INTO `content` VALUES ('23', '1', 'asdewq', '<p>\r\n	asd</p>\r\n', null, null, '2014-07-16 11:41:22', null, null);
INSERT INTO `content` VALUES ('24', '1', 'dasdasd', '<p>\r\n	asdasd</p>\r\n', null, null, '2014-07-16 11:41:28', null, null);
