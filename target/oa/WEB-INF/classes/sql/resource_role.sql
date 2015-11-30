/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-08-12 10:18:01
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `resource_role`
-- ----------------------------
DROP TABLE IF EXISTS `resource_role`;
CREATE TABLE `resource_role` (
  `resource_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`resource_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_role
-- ----------------------------
INSERT INTO `resource_role` VALUES ('4', '2');
INSERT INTO `resource_role` VALUES ('6', '2');
INSERT INTO `resource_role` VALUES ('7', '2');
INSERT INTO `resource_role` VALUES ('11', '3');
INSERT INTO `resource_role` VALUES ('13', '3');
INSERT INTO `resource_role` VALUES ('14', '3');
INSERT INTO `resource_role` VALUES ('15', '3');
INSERT INTO `resource_role` VALUES ('16', '3');
INSERT INTO `resource_role` VALUES ('17', '3');
INSERT INTO `resource_role` VALUES ('18', '3');
INSERT INTO `resource_role` VALUES ('19', '4');
INSERT INTO `resource_role` VALUES ('20', '4');
