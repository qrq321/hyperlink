/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : df

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 06/01/2020 11:36:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_account_info
-- ----------------------------
DROP TABLE IF EXISTS `t_account_info`;
CREATE TABLE `t_account_info`  (
                                   `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                   `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
                                   `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
                                   `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
                                   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                   `lastlogin_time` datetime NULL DEFAULT NULL COMMENT '最后一次登录时间',
                                   `status` int(2) NULL DEFAULT NULL COMMENT '账户状态',
                                   `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
                                   `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
                                   `slat` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_account_info
-- ----------------------------
INSERT INTO `t_account_info` VALUES (1, 'wang', 'fd791b77cd3ac7050b5f680076e98623', '王二', '2019-12-31 17:47:37', '2020-01-06 03:34:29', 1, '13637753636', 'qrqkl123@163.com', '32');
INSERT INTO `t_account_info` VALUES (2, 'admin', '827f148f3906e434e9508fbdf1a38107', '管理员', '2020-01-03 11:49:35', '2020-01-06 02:34:35', 1, '13360478123', 'qrqlsy@163com', '6');
INSERT INTO `t_account_info` VALUES (8, 'sdsad', '58df2754d13d4ef0073024ffde9c0a9b', 'asdasd', '2020-01-03 07:47:46', '2020-01-06 03:29:42', 1, '13213423432', NULL, '27');
INSERT INTO `t_account_info` VALUES (10, '12334333', '3333333', '333333', '2020-01-03 07:51:48', NULL, 1, '13212012654', NULL, '1');
INSERT INTO `t_account_info` VALUES (12, 'e23423', 'cb025b4173ae8e36772eadf6c42bedf2', '123', '2020-01-03 09:06:19', '2020-01-06 03:29:55', 1, '13521021031', NULL, '36');
INSERT INTO `t_account_info` VALUES (13, 'test', '90c75b705a6931c66d9e8660062bb625', '张三', '2020-01-04 09:36:30', '2020-01-06 03:30:06', 1, '13637753639', NULL, '4');

-- ----------------------------
-- Table structure for t_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_info`;
CREATE TABLE `t_menu_info`  (
                                `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '菜单主键',
                                `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
                                `parent_id` int(20) NULL DEFAULT NULL COMMENT '上级菜单id',
                                `type` int(1) NULL DEFAULT NULL COMMENT '菜单类别',
                                `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单链接',
                                `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                                `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
                                `orders` int(5) NULL DEFAULT NULL COMMENT '排序值越小越靠前',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_menu_info
-- ----------------------------
INSERT INTO `t_menu_info` VALUES (1, '首页', 0, 1, 'pages', '2019-12-02 11:09:12', NULL, NULL, 1);
INSERT INTO `t_menu_info` VALUES (2, '用户管理', 0, 1, '', '2019-12-02 11:12:21', '2019-12-02 11:12:23', NULL, 2);
INSERT INTO `t_menu_info` VALUES (3, '勾魂管理', 0, 1, NULL, '2019-12-02 11:12:38', NULL, NULL, 3);
INSERT INTO `t_menu_info` VALUES (4, '阎王殿审判记录', 0, 1, NULL, '2019-12-02 14:08:33', NULL, NULL, 4);
INSERT INTO `t_menu_info` VALUES (5, '十八层地狱', 0, 1, NULL, '2019-12-02 14:08:52', NULL, NULL, 5);
INSERT INTO `t_menu_info` VALUES (6, '六道轮回', 0, 1, NULL, '2019-12-02 14:10:21', NULL, NULL, 6);
INSERT INTO `t_menu_info` VALUES (7, '冥币管理', 0, 1, NULL, '2019-12-02 14:10:38', NULL, NULL, 7);
INSERT INTO `t_menu_info` VALUES (8, '日志管理', 0, 1, NULL, '2019-12-02 14:10:59', NULL, NULL, 8);
INSERT INTO `t_menu_info` VALUES (9, '系统管理', 0, 1, NULL, '2019-12-02 14:11:12', NULL, NULL, 9);
INSERT INTO `t_menu_info` VALUES (21, '用户列表', 2, 2, 'users', '2019-12-02 14:13:42', NULL, NULL, 1);
INSERT INTO `t_menu_info` VALUES (22, '数据同步', 2, 2, NULL, '2019-12-02 14:17:16', NULL, NULL, 2);
INSERT INTO `t_menu_info` VALUES (23, '设备管理', 5, 2, NULL, '2019-12-02 14:17:41', NULL, NULL, 1);
INSERT INTO `t_menu_info` VALUES (24, '作业流程', 5, 2, NULL, '2019-12-02 14:25:13', NULL, NULL, 2);
INSERT INTO `t_menu_info` VALUES (25, '用户列表', 5, 2, NULL, '2019-12-02 14:25:30', NULL, NULL, 3);
INSERT INTO `t_menu_info` VALUES (26, '管理员', 9, 2, NULL, '2019-12-02 14:25:54', NULL, NULL, 1);
INSERT INTO `t_menu_info` VALUES (27, '角色权限', 9, 2, 'roles', '2019-12-02 14:26:15', NULL, NULL, 2);

-- ----------------------------
-- Table structure for t_test
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
CREATE TABLE `t_test`  (
                           `id` int(10) NOT NULL COMMENT 'zhujian',
                           `nums` int(10) NULL DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_test
-- ----------------------------
INSERT INTO `t_test` VALUES (1, 20562);
INSERT INTO `t_test` VALUES (2, 230);
INSERT INTO `t_test` VALUES (3, 2154);
INSERT INTO `t_test` VALUES (4, 125463);
INSERT INTO `t_test` VALUES (5, 10000);
INSERT INTO `t_test` VALUES (1236542, 1235452);

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info`  (
                                `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `account_id` int(20) NULL DEFAULT NULL COMMENT '账号id',
                                `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
                                `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
                                `birthday` datetime NULL DEFAULT NULL COMMENT '出生日期',
                                `life_limit` int(10) NULL DEFAULT NULL COMMENT '寿命',
                                `type` int(2) NULL DEFAULT NULL COMMENT '类别',
                                `death_type` int(2) NULL DEFAULT NULL COMMENT '死亡方式',
                                `last_id` int(20) NULL DEFAULT NULL COMMENT '上一世id',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
