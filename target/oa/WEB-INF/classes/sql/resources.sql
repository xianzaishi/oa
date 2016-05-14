/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-08-12 10:18:05
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `resources`
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enable` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO `resources` VALUES ('4', '1', 'url', '/cms/notice/add', '公告通知');
INSERT INTO `resources` VALUES ('6', '1', 'url', '/cms/notice/delete/ids/*', '公告通知');
INSERT INTO `resources` VALUES ('7', '1', 'url', '/cms/notice/edit/id/*', '公告通知');
INSERT INTO `resources` VALUES ('11', '1', 'url', '/cms/official/dept/add', '单位文件');
INSERT INTO `resources` VALUES ('13', '1', 'url', '/cms/official/dept/edit/id/*', '单位文件');
INSERT INTO `resources` VALUES ('14', '1', 'url', '/cms/official/dept/edit', '单位文件');
INSERT INTO `resources` VALUES ('15', '1', 'url', '/cms/official/dept/delete/ids/*', '单位文件');
INSERT INTO `resources` VALUES ('17', '1', 'url', '/cms/official/dept/file/add/*', '单位文件');
INSERT INTO `resources` VALUES ('18', '1', 'url', '/cms/official/document/delete/folderId/*/ids/*', '单位文件');
INSERT INTO `resources` VALUES ('19', '1', 'url', '/user/management', '用户管理');
INSERT INTO `resources` VALUES ('20', '1', 'url', '/role/management', '用户管理');
