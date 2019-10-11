/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : student

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 11/10/2019 21:33:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT 20,
  `cardid` int(11) NULL DEFAULT NULL,
  `classid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_student_studentclass_cardid`(`cardid`) USING BTREE,
  CONSTRAINT `fk_student_studentclass_cardid` FOREIGN KEY (`cardid`) REFERENCES `studentcard` (`cardid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'zs', 23, 1, 1);
INSERT INTO `student` VALUES (2, 'ls', 24, 1, 1);

-- ----------------------------
-- Table structure for studentcard
-- ----------------------------
DROP TABLE IF EXISTS `studentcard`;
CREATE TABLE `studentcard`  (
  `cardid` int(11) NOT NULL AUTO_INCREMENT,
  `cardInfo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cardid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of studentcard
-- ----------------------------
INSERT INTO `studentcard` VALUES (1, 'zs info ...');
INSERT INTO `studentcard` VALUES (2, 'ls info...');

-- ----------------------------
-- Table structure for studentclass
-- ----------------------------
DROP TABLE IF EXISTS `studentclass`;
CREATE TABLE `studentclass`  (
  `classid` int(11) NOT NULL,
  `classname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`classid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of studentclass
-- ----------------------------
INSERT INTO `studentclass` VALUES (1, 'g1班');
INSERT INTO `studentclass` VALUES (2, 'g2班');

-- ----------------------------
-- Procedure structure for findAll
-- ----------------------------
DROP PROCEDURE IF EXISTS `findAll`;
delimiter ;;
CREATE PROCEDURE `findAll`()
begin
select * from student;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for findById
-- ----------------------------
DROP PROCEDURE IF EXISTS `findById`;
delimiter ;;
CREATE PROCEDURE `findById`(IN in_id INT)
begin 
select * from student where id = in_id;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
