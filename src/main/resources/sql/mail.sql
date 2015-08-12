/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-08-12 10:17:54
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `mail`
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL COMMENT '件邮标题',
  `content` text COMMENT '容内',
  `file_id` bigint(20) DEFAULT NULL COMMENT '附件id',
  `to` bigint(20) NOT NULL COMMENT '收件人id',
  `from` bigint(20) NOT NULL COMMENT '发件人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mail
-- ----------------------------
