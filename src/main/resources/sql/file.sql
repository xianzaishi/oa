/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-08-12 10:17:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) NOT NULL,
  `path` varchar(1000) NOT NULL,
  `enable` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('18', 'csstable.zip', 'D:\\workspace_source\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\oa/files/2014/07/30173923csstable.zip', '1');
INSERT INTO `file` VALUES ('19', '电话表新.xls', 'D:\\workspace_source\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\oa/files/2014/07/30173935电话表新.xls', '1');
INSERT INTO `file` VALUES ('20', 'cms20140710BAK.psc', 'D:\\workspace_source\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\oa/files/2014/07/31101141cms20140710BAK.psc', '0');
INSERT INTO `file` VALUES ('21', 'Spring_Live中文版完整版.pdf', 'D:\\workspace_source\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\oa/files/2014/07/31101149Spring_Live中文版完整版.pdf', '0');
INSERT INTO `file` VALUES ('32', 'debug.log', 'D:\\workspace_source\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\oa/files/2014/07/31120232debug.log', '1');
INSERT INTO `file` VALUES ('33', 'master_preferences', 'D:\\workspace_source\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\oa/files/2014/09/15162044master_preferences', '1');
INSERT INTO `file` VALUES ('34', 'IMG_0862.JPG', 'D:\\workspace_source\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\oa/files/2014/09/22164025IMG_0862.JPG', '1');
INSERT INTO `file` VALUES ('35', 'Spring-Security-3.0.1-中文官方文档.pdf', 'D:\\workspace_source\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\oa/files/2014/09/22164058Spring-Security-3.0.1-中文官方文档.pdf', '1');
