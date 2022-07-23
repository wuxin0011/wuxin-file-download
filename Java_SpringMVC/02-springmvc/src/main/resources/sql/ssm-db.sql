/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 127.0.0.1:3306
 Source Schema         : ssm-db

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 23/07/2022 15:44:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `cid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '猫');
INSERT INTO `category` VALUES (2, '技术');
INSERT INTO `category` VALUES (3, '日记');
INSERT INTO `category` VALUES (4, '游戏');
INSERT INTO `category` VALUES (5, '科技');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `fid` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cid` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (1, '/resource/bg1.jpg', '1', 1, '美女', '2022-07-16 12:40:05');
INSERT INTO `file` VALUES (2, '/resource/bg2.jpg', '1', 1, 'bg2', '2022-07-16 12:40:05');
INSERT INTO `file` VALUES (3, '/resource/bg3.jpg', '1', 1, 'bg3', '2022-07-16 12:40:05');
INSERT INTO `file` VALUES (4, '/resource/bilibili.jpg', '1', 1, 'bilibili', '2022-07-16 12:40:05');
INSERT INTO `file` VALUES (6, '/resource/bg2.jpg', '1', 4, 'bg2', '2022-07-16 12:40:05');
INSERT INTO `file` VALUES (7, '/resource/bg3.jpg', '1', 2, 'bg3', '2022-07-16 12:40:05');
INSERT INTO `file` VALUES (8, '/resource/bilibili.jpg', '1', 3, 'bilibili', '2022-07-16 12:40:05');
INSERT INTO `file` VALUES (9, '//resource//2022/07//eda396e7e7c248279c99f4add2ba1e79.png', '1', 1, '服务器', '2022-07-23 11:02:16');
INSERT INTO `file` VALUES (10, '//resource//2022/07//cc209171cc9040efb37e76db1d29326c.png', '1', 1, '服务器', '2022-07-23 11:04:27');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `mid` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 'docker', '2022-07-20 18:28:39', '0', '2191377759@qq.com');
INSERT INTO `message` VALUES (2, 'docker', '2022-07-20 18:32:37', '0', '2191377759@qq.com');
INSERT INTO `message` VALUES (3, '有没有docker内容教程？', '2022-07-21 09:56:57', '0', '2191377759@qq.com');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `nid` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`nid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (8, '测试', '2022-07-22 20:18:31', '第一条通知');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int NOT NULL,
  `role` int NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `new_column` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_email_uindex`(`email`) USING BTREE,
  UNIQUE INDEX `user_username_uindex`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (23, 'admin', '123456', '2191377759@qq.com', 1, 1, '2022-07-20 22:09:10', NULL);

SET FOREIGN_KEY_CHECKS = 1;
