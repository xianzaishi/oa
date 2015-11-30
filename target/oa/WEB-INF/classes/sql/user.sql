/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-08-12 10:18:17
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `enable` int(11) DEFAULT NULL COMMENT '账号是否有限 1. 是 0.否',
  `desc` varchar(200) DEFAULT NULL,
  `dept` varchar(1000) DEFAULT NULL COMMENT '部门',
  `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `real_name` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `person_id` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `address_birth` varchar(1000) DEFAULT NULL COMMENT '出生地',
  `address_now` varchar(1000) DEFAULT NULL COMMENT '现住址',
  `company` varchar(100) DEFAULT NULL COMMENT '公司',
  `mailing_address` varchar(1000) DEFAULT NULL COMMENT '邮寄地址',
  `zip_code` varchar(20) DEFAULT NULL COMMENT '邮编',
  `career` varchar(100) DEFAULT NULL COMMENT '职业',
  `personal_homepage` varchar(500) DEFAULT NULL COMMENT '个人主页',
  `personal_signature` varchar(1000) DEFAULT NULL COMMENT '个人签名',
  `create_date` date DEFAULT NULL COMMENT '建创时间',
  `qq` varchar(50) DEFAULT NULL COMMENT 'QQ',
  `msn` varchar(50) DEFAULT NULL COMMENT 'MSN',
  `wangwang` varchar(50) DEFAULT NULL COMMENT '阿里旺旺',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1', '管理员', '1', 'xianzaishi@gmail.com', null, null, 'admin', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('2', 'user', 'user', '1', '用户', '1', '工会主页', null, null, 'user', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('6', 'asdasd', 'asd', null, null, '1', null, null, null, 'asd', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
