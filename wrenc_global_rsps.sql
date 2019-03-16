/*
 Navicat Premium Data Transfer

 Source Server         : mysql.arcanium.xyz
 Source Server Type    : MySQL
 Source Server Version : 50634
 Source Host           : mysql.wrenc.com:3306
 Source Schema         : wrenc_global_rsps

 Target Server Type    : MySQL
 Target Server Version : 50634
 File Encoding         : 65001

 Date: 19/02/2019 09:48:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dev_log
-- ----------------------------
DROP TABLE IF EXISTS `dev_log`;
CREATE TABLE `dev_log`  (
  `id` int(11) UNSIGNED NOT NULL,
  `username` varchar(15) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `date` timestamp(0) NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dev_log
-- ----------------------------
INSERT INTO `dev_log` VALUES (1, 'logan', 'Added RuinsPS voting bonds as a reward', '2015-12-04 06:03:28');
INSERT INTO `dev_log` VALUES (3, 'logan', 'Added profile viewing (forums)', '2015-12-06 02:07:11');
INSERT INTO `dev_log` VALUES (4, 'logan', 'Added herb boxes', '2015-12-06 02:07:23');
INSERT INTO `dev_log` VALUES (5, 'logan', 'Added an NPC to buy low-level skilling items for high price!', '2015-12-06 20:05:16');
INSERT INTO `dev_log` VALUES (6, 'logan', 'Adjusted home shops & prices', '2015-12-06 23:35:31');
INSERT INTO `dev_log` VALUES (7, 'logan', 'Fixed inventory disappearing when using deposit box.', '2015-12-13 20:51:16');
INSERT INTO `dev_log` VALUES (8, 'logan', 'Fixed player safety test completion interface.', '2015-12-13 20:51:43');
INSERT INTO `dev_log` VALUES (9, 'logan', 'Fixed falador agility shortcut.', '2015-12-13 20:58:04');
INSERT INTO `dev_log` VALUES (10, 'logan', 'Fixed Goldsmith gauntlets experience reward.', '2015-12-13 20:59:41');
INSERT INTO `dev_log` VALUES (11, 'logan', 'Zamorakian hasta is now a godwars protection item.', '2015-12-13 21:04:15');
INSERT INTO `dev_log` VALUES (12, 'logan', 'Fixed slayer helmet effect.', '2015-12-13 21:11:37');
INSERT INTO `dev_log` VALUES (13, 'logan', 'Duel arena veng bug has been fixed.', '2015-12-13 21:20:05');
INSERT INTO `dev_log` VALUES (14, 'logan', 'Changed steel bolts from 8gp to 150 gp', '2015-12-15 05:52:43');
INSERT INTO `dev_log` VALUES (15, 'logan', 'Removed astral runes from magic shop', '2015-12-15 05:54:13');
INSERT INTO `dev_log` VALUES (16, 'logan', 'Recent activity for profiles now includes when users create threads', '2015-12-15 06:05:03');
INSERT INTO `dev_log` VALUES (17, 'logan', 'Added beginner level tasks for Lumbridge/Draynor diary.', '2015-12-15 08:23:00');
INSERT INTO `dev_log` VALUES (18, 'logan', 'Added medium level tasks for lumbridge/draynor achievement diary.', '2015-12-16 09:46:23');
INSERT INTO `dev_log` VALUES (19, 'logan', 'Finished the Lumbridge Achievement Diary.', '2015-12-17 07:57:38');
INSERT INTO `dev_log` VALUES (20, 'logan', 'Added the explorer rings mechanics.', '2015-12-17 09:15:54');
INSERT INTO `dev_log` VALUES (21, 'logan', 'Added broad arrow making - must unlock via slayer rewards', '2015-12-17 09:19:54');
INSERT INTO `dev_log` VALUES (22, 'logan', 'Added broad bolt making - must unlock via slayer rewards ', '2015-12-17 09:20:54');
INSERT INTO `dev_log` VALUES (23, 'logan', 'Added middle mouse rotation for the client', '2015-12-17 09:22:54');
INSERT INTO `dev_log` VALUES (24, 'logan', 'Added Dagannoth Kings under dagganoth tasks', '2015-12-17 09:29:54');
INSERT INTO `dev_log` VALUES (25, 'logan', 'Added the gilded altar.', '2015-12-18 20:32:52');
INSERT INTO `dev_log` VALUES (26, 'logan', 'Fixed shooting star mining requirements.', '2015-12-18 20:45:10');
INSERT INTO `dev_log` VALUES (27, 'logan', 'Fixed an iron titan bug.', '2015-12-18 20:45:16');
INSERT INTO `dev_log` VALUES (28, 'logan', 'Changed RuinsPS teleporter to 5 seconds.', '2015-12-18 21:06:53');

-- ----------------------------
-- Table structure for highscores
-- ----------------------------
DROP TABLE IF EXISTS `highscores`;
CREATE TABLE `highscores`  (
  `id` int(11) UNSIGNED NOT NULL,
  `username` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `overall_xp` int(11) NOT NULL DEFAULT 0,
  `total_level` int(11) NOT NULL DEFAULT 0,
  `ironManMode` varchar(15) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT 'NONE',
  `xp_0` int(11) NOT NULL DEFAULT 0,
  `xp_1` int(11) NOT NULL DEFAULT 0,
  `xp_2` int(11) NOT NULL DEFAULT 0,
  `xp_3` int(11) NOT NULL DEFAULT 0,
  `xp_4` int(11) NOT NULL DEFAULT 0,
  `xp_5` int(11) NOT NULL DEFAULT 0,
  `xp_6` int(11) NOT NULL DEFAULT 0,
  `xp_7` int(11) NOT NULL DEFAULT 0,
  `xp_8` int(11) NOT NULL DEFAULT 0,
  `xp_9` int(11) NOT NULL DEFAULT 0,
  `xp_10` int(11) NOT NULL DEFAULT 0,
  `xp_11` int(11) NOT NULL DEFAULT 0,
  `xp_12` int(11) NOT NULL DEFAULT 0,
  `xp_13` int(11) NOT NULL DEFAULT 0,
  `xp_14` int(11) NOT NULL DEFAULT 0,
  `xp_15` int(11) NOT NULL DEFAULT 0,
  `xp_16` int(11) NOT NULL DEFAULT 0,
  `xp_17` int(11) NOT NULL DEFAULT 0,
  `xp_18` int(11) NOT NULL DEFAULT 0,
  `xp_19` int(11) NOT NULL DEFAULT 0,
  `xp_20` int(11) NOT NULL DEFAULT 0,
  `xp_21` int(11) NOT NULL DEFAULT 0,
  `xp_22` int(11) NOT NULL DEFAULT 0,
  `xp_23` int(11) NOT NULL DEFAULT 0
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of highscores
-- ----------------------------
INSERT INTO `highscores` VALUES (1, 'elena', 312826344, 2376, 'NONE', 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431);
INSERT INTO `highscores` VALUES (2, 'danny', 312826344, 2376, 'NONE', 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431, 13034431);
INSERT INTO `highscores` VALUES (3, 'community', 1154, 33, 'NONE', 0, 0, 0, 1154, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- ----------------------------
-- Table structure for members
-- ----------------------------
DROP TABLE IF EXISTS `members`;
CREATE TABLE `members`  (
  `username` varchar(12) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `last_login` bigint(20) NOT NULL,
  `rights` int(11) NOT NULL,
  `disconnectTime` float NOT NULL,
  `lastWorld` int(11) NOT NULL,
  `banTime` float NOT NULL,
  `contacts` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `blocked` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `clanName` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `currentClan` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `clanReqs` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `chatSettings` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `ip` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `computerName` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `mac` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `serial` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `online` tinyint(1) NOT NULL,
  `muteTime` float NOT NULL,
  `email` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of members
-- ----------------------------
INSERT INTO `members` VALUES ('Vashmeed', 0, 2, 1543210000000, 1, 0, '{chris,7}~{jesse,1}', '', 'Vashmeed', 'vashmeed', '1,0,8,9', '0,0,0', '', '', '', '', 0, 0, '');
INSERT INTO `members` VALUES ('Rahim', 0, 2, 1543210000000, 1, 0, '{chris,7}~{jesse,1}', '', 'Rahim', 'vashmeed', '1,0,8,9', '0,0,0', '', '', '', '', 0, 0, '');
INSERT INTO `members` VALUES ('1', 0, 2, 1543210000000, 1, 0, '{chris,7}~{jesse,1}', '', 'Vashmeed', 'vashmeed', '1,0,8,9', '0,0,0', '', '', '', '', 0, 0, '');
INSERT INTO `members` VALUES ('test', 0, 2, 1543210000000, 1, 0, '{chris,7}~{jesse,1}', '', 'Vashmeed', 'vashmeed', '1,0,8,9', '0,0,0', '', '', '', '', 0, 0, '');

-- ----------------------------
-- Table structure for punishments
-- ----------------------------
DROP TABLE IF EXISTS `punishments`;
CREATE TABLE `punishments`  (
  `address` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `type` int(11) NOT NULL
) ENGINE = MyISAM CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for security
-- ----------------------------
DROP TABLE IF EXISTS `security`;
CREATE TABLE `security`  (
  `id` int(11) UNSIGNED NOT NULL,
  `ip` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `type` int(11) NOT NULL,
  `timestamp` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0)
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of security
-- ----------------------------
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:7d1b:403e:d412:3162', 2, '2019-01-22 21:09:37');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:7d1b:403e:d412:3162', 6, '2019-01-22 21:09:37');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 10:35:53');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 13:56:47');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 13:57:03');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 13:57:47');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 2, '2019-01-23 13:57:54');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 4, '2019-01-23 13:57:54');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:07:13');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:07:18');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 2, '2019-01-23 14:07:23');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 5, '2019-01-23 14:07:23');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:07:26');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:07:29');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:07:31');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:07:32');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:07:36');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:07:41');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:19:54');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:26:20');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 2, '2019-01-23 14:26:27');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 5, '2019-01-23 14:26:27');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:26:30');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:26:32');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:26:35');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:32:20');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:32:25');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:32:27');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:32:28');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:33:46');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:33:49');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:33:52');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:42:23');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:42:25');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 14:42:34');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:06:28');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:06:39');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:07:51');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:14:15');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:14:32');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:14:34');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:20:10');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:20:11');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:26:27');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:26:29');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:26:38');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:26:58');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:27:02');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:27:04');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:27:12');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:31:01');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:32:25');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:32:29');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:32:32');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:32:40');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:32:43');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:33:10');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:34:22');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:34:24');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:34:30');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:38:16');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:38:20');
INSERT INTO `security` VALUES (0, '172.68.211.132', 1, '2019-01-23 15:38:23');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:41:17');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:41:33');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:41:35');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:43:35');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:43:37');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:43:41');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:43:58');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:44:00');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:44:09');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:44:29');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:44:34');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:44:36');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:44:39');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:44:41');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:44:58');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:46:04');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:46:05');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:48:26');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:48:48');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:49:08');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:50:58');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:51:12');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 15:53:16');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:06:43');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:12:27');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:16:54');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:17:19');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:17:21');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:19:18');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:19:42');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:19:54');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:20:00');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:20:02');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:20:09');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:21:42');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:22:06');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:22:22');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:23:26');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:23:28');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:23:30');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:24:50');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:24:50');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:24:54');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:24:55');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:24:57');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:24:57');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 2, '2019-01-23 16:25:01');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 3, '2019-01-23 16:25:01');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:25:05');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 2, '2019-01-23 16:25:27');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 6, '2019-01-23 16:25:27');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 2, '2019-01-23 16:25:33');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 6, '2019-01-23 16:25:33');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 2, '2019-01-23 16:25:45');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 6, '2019-01-23 16:25:45');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:31:32');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:d63:23cf:92fe:ed13', 1, '2019-01-23 16:31:50');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 16:47:42');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 16:47:52');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 16:48:25');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 16:49:52');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 16:49:54');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 16:49:54');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 16:51:22');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 16:51:22');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 16:51:25');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:51:40');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:51:40');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:52:43');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:52:43');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:53:00');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:53:00');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:53:10');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:53:10');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:53:33');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:53:33');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:54:09');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:54:09');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:54:45');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:54:45');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:55:00');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:55:00');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:55:25');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:55:25');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:55:30');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:55:30');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:56:00');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:56:00');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:57:30');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:57:30');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 16:58:23');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 16:58:23');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 17:00:28');
INSERT INTO `security` VALUES (0, '172.68.47.26', 3, '2019-01-23 17:00:28');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 17:00:32');
INSERT INTO `security` VALUES (0, '172.68.47.26', 3, '2019-01-23 17:00:32');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 17:01:00');
INSERT INTO `security` VALUES (0, '172.68.47.26', 2, '2019-01-23 17:01:15');
INSERT INTO `security` VALUES (0, '172.68.47.26', 6, '2019-01-23 17:01:15');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 17:01:21');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 17:01:28');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 17:02:16');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 17:02:21');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 17:02:22');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 17:02:31');
INSERT INTO `security` VALUES (0, '172.68.47.26', 1, '2019-01-23 17:02:31');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:60eb:ea9a:c80c:c54', 1, '2019-01-23 17:04:06');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:60eb:ea9a:c80c:c54', 1, '2019-01-23 17:04:15');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:60eb:ea9a:c80c:c54', 2, '2019-01-23 17:04:44');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:60eb:ea9a:c80c:c54', 6, '2019-01-23 17:04:44');
INSERT INTO `security` VALUES (0, '172.68.143.62', 1, '2019-01-24 12:43:01');
INSERT INTO `security` VALUES (0, '172.69.62.174', 1, '2019-01-24 12:43:02');
INSERT INTO `security` VALUES (0, '172.68.132.121', 1, '2019-01-24 12:43:02');
INSERT INTO `security` VALUES (0, '172.68.65.80', 1, '2019-01-24 12:43:02');
INSERT INTO `security` VALUES (0, '162.158.67.69', 1, '2019-01-24 12:43:04');
INSERT INTO `security` VALUES (0, '162.158.64.112', 1, '2019-01-24 12:43:06');
INSERT INTO `security` VALUES (0, '162.158.67.69', 1, '2019-01-24 12:43:06');
INSERT INTO `security` VALUES (0, '162.158.67.69', 1, '2019-01-24 12:43:07');
INSERT INTO `security` VALUES (0, '172.68.65.146', 1, '2019-01-24 12:43:08');
INSERT INTO `security` VALUES (0, '172.68.65.62', 1, '2019-01-24 12:43:08');
INSERT INTO `security` VALUES (0, '172.69.62.90', 1, '2019-01-24 12:43:09');
INSERT INTO `security` VALUES (0, '172.68.65.248', 1, '2019-01-24 12:43:09');
INSERT INTO `security` VALUES (0, '172.69.62.204', 1, '2019-01-24 12:43:09');
INSERT INTO `security` VALUES (0, '162.158.67.69', 1, '2019-01-24 12:43:09');
INSERT INTO `security` VALUES (0, '172.69.62.150', 1, '2019-01-24 12:43:10');
INSERT INTO `security` VALUES (0, '162.158.64.112', 1, '2019-01-24 12:43:11');
INSERT INTO `security` VALUES (0, '162.158.67.69', 1, '2019-01-24 12:43:11');
INSERT INTO `security` VALUES (0, '172.68.65.212', 1, '2019-01-24 12:43:11');
INSERT INTO `security` VALUES (0, '172.68.65.248', 1, '2019-01-24 12:43:12');
INSERT INTO `security` VALUES (0, '172.68.65.146', 1, '2019-01-24 12:43:12');
INSERT INTO `security` VALUES (0, '162.158.67.69', 1, '2019-01-24 12:43:13');
INSERT INTO `security` VALUES (0, '162.158.64.112', 1, '2019-01-24 12:43:14');
INSERT INTO `security` VALUES (0, '172.68.65.212', 1, '2019-01-24 12:43:18');
INSERT INTO `security` VALUES (0, '172.68.65.146', 1, '2019-01-24 12:43:19');
INSERT INTO `security` VALUES (0, '162.158.67.69', 1, '2019-01-24 12:43:19');
INSERT INTO `security` VALUES (0, '172.68.65.146', 1, '2019-01-24 12:43:21');
INSERT INTO `security` VALUES (0, '162.158.64.112', 1, '2019-01-24 12:43:21');
INSERT INTO `security` VALUES (0, '172.68.65.248', 1, '2019-01-24 12:43:22');
INSERT INTO `security` VALUES (0, '192.99.100.93', 1, '2019-01-24 15:32:58');
INSERT INTO `security` VALUES (0, '192.99.100.93', 1, '2019-01-24 15:35:53');
INSERT INTO `security` VALUES (0, '54.175.165.81', 1, '2019-01-24 22:05:38');
INSERT INTO `security` VALUES (0, '54.175.165.81', 1, '2019-01-24 22:05:38');
INSERT INTO `security` VALUES (0, '172.68.211.174', 1, '2019-01-24 23:44:10');
INSERT INTO `security` VALUES (0, '172.69.226.109', 1, '2019-01-25 07:57:42');
INSERT INTO `security` VALUES (0, '104.192.74.26', 1, '2019-01-25 10:21:04');
INSERT INTO `security` VALUES (0, '172.68.58.115', 1, '2019-01-25 10:21:04');
INSERT INTO `security` VALUES (0, '18.215.68.164', 1, '2019-01-25 12:32:13');
INSERT INTO `security` VALUES (0, '104.192.74.46', 1, '2019-01-25 13:14:09');
INSERT INTO `security` VALUES (0, '104.192.74.46', 1, '2019-01-25 13:14:10');
INSERT INTO `security` VALUES (0, '54.39.100.61', 1, '2019-01-25 23:25:08');
INSERT INTO `security` VALUES (0, '103.123.84.226', 1, '2019-01-26 02:08:39');
INSERT INTO `security` VALUES (0, '66.102.8.56', 1, '2019-01-26 02:08:39');
INSERT INTO `security` VALUES (0, '172.68.38.30', 1, '2019-01-26 14:27:47');
INSERT INTO `security` VALUES (0, '172.68.38.12', 1, '2019-01-26 14:30:20');
INSERT INTO `security` VALUES (0, '66.249.75.27', 1, '2019-01-26 14:36:17');
INSERT INTO `security` VALUES (0, '165.227.33.92', 1, '2019-01-26 15:24:24');
INSERT INTO `security` VALUES (0, '206.180.165.147', 1, '2019-01-26 23:54:30');
INSERT INTO `security` VALUES (0, '2604:4500:6:34d:ae1f:6bff:fe1a:ea96', 1, '2019-01-27 06:54:42');
INSERT INTO `security` VALUES (0, '66.102.8.37', 1, '2019-01-27 06:54:43');
INSERT INTO `security` VALUES (0, '66.249.93.19', 1, '2019-01-27 07:45:12');
INSERT INTO `security` VALUES (0, '66.249.75.21', 1, '2019-01-27 09:50:22');
INSERT INTO `security` VALUES (0, '54.242.26.232', 1, '2019-01-27 12:06:40');
INSERT INTO `security` VALUES (0, '54.242.26.232', 1, '2019-01-27 12:06:50');
INSERT INTO `security` VALUES (0, '54.242.26.232', 1, '2019-01-27 12:06:54');
INSERT INTO `security` VALUES (0, '54.242.26.232', 1, '2019-01-27 12:07:04');
INSERT INTO `security` VALUES (0, '34.248.207.114', 1, '2019-01-27 15:04:49');
INSERT INTO `security` VALUES (0, '104.227.246.106', 1, '2019-01-27 17:17:35');
INSERT INTO `security` VALUES (0, '172.68.211.192', 1, '2019-01-27 23:41:07');
INSERT INTO `security` VALUES (0, '172.68.211.192', 1, '2019-01-27 23:41:14');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:2583:bb97:860e:a7d0', 1, '2019-01-27 23:43:06');
INSERT INTO `security` VALUES (0, '194.153.113.13', 1, '2019-01-28 03:11:30');
INSERT INTO `security` VALUES (0, '66.249.75.21', 1, '2019-01-28 04:11:31');
INSERT INTO `security` VALUES (0, '66.249.64.144', 1, '2019-01-28 09:33:46');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:34:20');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:34:21');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:34:36');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:34:36');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:34:47');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:34:47');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:34:58');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:35:14');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:35:20');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:35:20');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:35:26');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:35:42');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:35:42');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:35:47');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:35:48');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:35:56');
INSERT INTO `security` VALUES (0, '66.249.64.142', 1, '2019-01-28 09:36:00');
INSERT INTO `security` VALUES (0, '66.249.64.144', 1, '2019-01-28 09:36:04');
INSERT INTO `security` VALUES (0, '69.58.178.57', 1, '2019-01-28 11:26:24');
INSERT INTO `security` VALUES (0, '54.39.100.61', 1, '2019-01-28 20:23:18');
INSERT INTO `security` VALUES (0, '66.249.64.145', 1, '2019-01-29 00:22:11');
INSERT INTO `security` VALUES (0, '66.102.6.148', 1, '2019-01-29 06:37:55');
INSERT INTO `security` VALUES (0, '167.114.65.240', 1, '2019-01-29 16:25:48');
INSERT INTO `security` VALUES (0, '167.114.65.240', 1, '2019-01-29 16:25:50');
INSERT INTO `security` VALUES (0, '167.114.65.240', 1, '2019-01-29 16:25:55');
INSERT INTO `security` VALUES (0, '167.114.65.240', 1, '2019-01-29 16:25:59');
INSERT INTO `security` VALUES (0, '167.114.65.240', 1, '2019-01-29 16:26:03');
INSERT INTO `security` VALUES (0, '167.114.65.240', 1, '2019-01-29 16:26:05');
INSERT INTO `security` VALUES (0, '167.114.65.240', 1, '2019-01-29 16:26:07');
INSERT INTO `security` VALUES (0, '167.114.65.240', 1, '2019-01-29 16:26:08');
INSERT INTO `security` VALUES (0, '167.114.65.240', 1, '2019-01-29 16:26:14');
INSERT INTO `security` VALUES (0, '66.249.93.19', 1, '2019-01-29 23:21:47');
INSERT INTO `security` VALUES (0, '52.19.50.94', 1, '2019-01-29 23:35:43');
INSERT INTO `security` VALUES (0, '66.102.6.86', 1, '2019-01-30 01:25:09');
INSERT INTO `security` VALUES (0, '54.246.235.144', 1, '2019-01-30 04:21:31');
INSERT INTO `security` VALUES (0, '66.249.83.64', 1, '2019-01-30 04:55:59');
INSERT INTO `security` VALUES (0, '138.246.253.5', 1, '2019-01-30 09:01:59');
INSERT INTO `security` VALUES (0, '66.249.93.18', 1, '2019-01-30 11:29:28');
INSERT INTO `security` VALUES (0, '54.246.235.144', 1, '2019-01-30 12:32:02');
INSERT INTO `security` VALUES (0, '52.51.131.69', 1, '2019-01-30 13:21:30');
INSERT INTO `security` VALUES (0, '172.69.68.131', 1, '2019-01-30 14:04:52');
INSERT INTO `security` VALUES (0, '172.69.68.113', 1, '2019-01-30 21:05:44');
INSERT INTO `security` VALUES (0, '66.249.83.90', 1, '2019-01-30 23:59:36');
INSERT INTO `security` VALUES (0, '66.249.93.28', 1, '2019-01-31 10:28:24');
INSERT INTO `security` VALUES (0, '138.246.253.5', 1, '2019-01-31 10:37:17');
INSERT INTO `security` VALUES (0, '66.102.9.152', 1, '2019-01-31 11:27:46');
INSERT INTO `security` VALUES (0, '66.249.83.64', 1, '2019-01-31 14:41:14');
INSERT INTO `security` VALUES (0, '195.166.158.35', 1, '2019-01-31 21:32:04');
INSERT INTO `security` VALUES (0, '195.166.158.35', 1, '2019-01-31 21:32:17');
INSERT INTO `security` VALUES (0, '172.68.141.198', 1, '2019-01-31 23:46:49');
INSERT INTO `security` VALUES (0, '66.249.66.89', 1, '2019-02-01 00:22:12');
INSERT INTO `security` VALUES (0, '208.80.194.30', 1, '2019-02-01 00:58:13');
INSERT INTO `security` VALUES (0, '66.102.6.85', 1, '2019-02-01 02:32:44');
INSERT INTO `security` VALUES (0, '2001:4ca0:108:42::5', 1, '2019-02-01 07:00:42');
INSERT INTO `security` VALUES (0, '2001:4ca0:108:42::5', 1, '2019-02-01 11:11:54');
INSERT INTO `security` VALUES (0, '54.246.235.144', 1, '2019-02-01 12:27:55');
INSERT INTO `security` VALUES (0, '2400:cb00:36:1028::a29e:4358', 1, '2019-02-01 14:26:27');
INSERT INTO `security` VALUES (0, '172.69.62.174', 1, '2019-02-01 14:26:27');
INSERT INTO `security` VALUES (0, '172.68.189.153', 1, '2019-02-01 14:26:28');
INSERT INTO `security` VALUES (0, '172.68.65.80', 1, '2019-02-01 14:26:28');
INSERT INTO `security` VALUES (0, '162.158.67.88', 1, '2019-02-01 14:26:32');
INSERT INTO `security` VALUES (0, '162.158.67.88', 1, '2019-02-01 14:26:33');
INSERT INTO `security` VALUES (0, '162.158.64.69', 1, '2019-02-01 14:26:33');
INSERT INTO `security` VALUES (0, '162.158.67.88', 1, '2019-02-01 14:26:34');
INSERT INTO `security` VALUES (0, '172.68.65.62', 1, '2019-02-01 14:26:34');
INSERT INTO `security` VALUES (0, '172.68.65.146', 1, '2019-02-01 14:26:34');
INSERT INTO `security` VALUES (0, '172.69.62.90', 1, '2019-02-01 14:26:35');
INSERT INTO `security` VALUES (0, '172.68.65.248', 1, '2019-02-01 14:26:35');
INSERT INTO `security` VALUES (0, '172.69.62.204', 1, '2019-02-01 14:26:36');
INSERT INTO `security` VALUES (0, '162.158.67.88', 1, '2019-02-01 14:26:36');
INSERT INTO `security` VALUES (0, '172.69.62.150', 1, '2019-02-01 14:26:37');
INSERT INTO `security` VALUES (0, '162.158.64.69', 1, '2019-02-01 14:26:37');
INSERT INTO `security` VALUES (0, '162.158.67.88', 1, '2019-02-01 14:26:38');
INSERT INTO `security` VALUES (0, '172.68.65.212', 1, '2019-02-01 14:26:38');
INSERT INTO `security` VALUES (0, '172.68.65.248', 1, '2019-02-01 14:26:38');
INSERT INTO `security` VALUES (0, '172.68.65.146', 1, '2019-02-01 14:26:39');
INSERT INTO `security` VALUES (0, '162.158.67.88', 1, '2019-02-01 14:26:39');
INSERT INTO `security` VALUES (0, '162.158.64.69', 1, '2019-02-01 14:26:41');
INSERT INTO `security` VALUES (0, '172.68.65.212', 1, '2019-02-01 14:26:45');
INSERT INTO `security` VALUES (0, '162.158.67.88', 1, '2019-02-01 14:26:46');
INSERT INTO `security` VALUES (0, '172.68.65.146', 1, '2019-02-01 14:26:46');
INSERT INTO `security` VALUES (0, '172.68.65.146', 1, '2019-02-01 14:26:47');
INSERT INTO `security` VALUES (0, '162.158.64.69', 1, '2019-02-01 14:26:47');
INSERT INTO `security` VALUES (0, '172.68.65.248', 1, '2019-02-01 14:26:49');
INSERT INTO `security` VALUES (0, '66.102.6.148', 1, '2019-02-01 16:13:44');
INSERT INTO `security` VALUES (0, '171.67.70.41', 1, '2019-02-01 18:56:13');
INSERT INTO `security` VALUES (0, '54.39.100.61', 1, '2019-02-01 21:22:07');
INSERT INTO `security` VALUES (0, '66.249.65.74', 1, '2019-02-02 02:06:28');
INSERT INTO `security` VALUES (0, '172.69.70.253', 1, '2019-02-02 02:06:29');
INSERT INTO `security` VALUES (0, '172.69.70.37', 1, '2019-02-02 02:07:24');
INSERT INTO `security` VALUES (0, '172.69.68.245', 1, '2019-02-02 02:07:24');
INSERT INTO `security` VALUES (0, '66.249.65.76', 1, '2019-02-02 02:07:48');
INSERT INTO `security` VALUES (0, '172.69.68.131', 1, '2019-02-02 02:07:48');
INSERT INTO `security` VALUES (0, '172.69.70.175', 1, '2019-02-02 02:08:13');
INSERT INTO `security` VALUES (0, '66.249.65.74', 1, '2019-02-02 02:08:44');
INSERT INTO `security` VALUES (0, '172.69.68.131', 1, '2019-02-02 02:08:44');
INSERT INTO `security` VALUES (0, '172.69.70.163', 1, '2019-02-02 02:09:00');
INSERT INTO `security` VALUES (0, '172.69.69.144', 1, '2019-02-02 02:09:17');
INSERT INTO `security` VALUES (0, '66.249.65.74', 1, '2019-02-02 02:09:33');
INSERT INTO `security` VALUES (0, '172.69.70.253', 1, '2019-02-02 02:09:33');
INSERT INTO `security` VALUES (0, '172.69.70.37', 1, '2019-02-02 02:09:50');
INSERT INTO `security` VALUES (0, '172.69.68.245', 1, '2019-02-02 02:09:50');
INSERT INTO `security` VALUES (0, '172.69.70.253', 1, '2019-02-02 02:25:51');
INSERT INTO `security` VALUES (0, '66.249.83.95', 1, '2019-02-02 05:55:12');
INSERT INTO `security` VALUES (0, '66.249.93.28', 1, '2019-02-02 07:25:34');
INSERT INTO `security` VALUES (0, '172.69.68.131', 1, '2019-02-02 09:03:17');
INSERT INTO `security` VALUES (0, '66.102.6.149', 1, '2019-02-02 09:36:56');
INSERT INTO `security` VALUES (0, '66.249.79.130', 1, '2019-02-02 10:05:00');
INSERT INTO `security` VALUES (0, '2600:8802:5700:33d:8063:116e:1d70:359a', 1, '2019-02-02 16:44:04');
INSERT INTO `security` VALUES (0, '172.68.58.37', 1, '2019-02-02 16:44:35');
INSERT INTO `security` VALUES (0, '80.229.171.135', 1, '2019-02-02 16:44:38');
INSERT INTO `security` VALUES (0, '80.229.171.135', 1, '2019-02-02 16:44:46');
INSERT INTO `security` VALUES (0, '80.229.171.135', 1, '2019-02-02 16:45:33');
INSERT INTO `security` VALUES (0, '80.229.171.135', 2, '2019-02-02 16:45:45');
INSERT INTO `security` VALUES (0, '80.229.171.135', 6, '2019-02-02 16:45:45');
INSERT INTO `security` VALUES (0, '172.68.59.32', 1, '2019-02-02 16:45:47');
INSERT INTO `security` VALUES (0, '80.229.171.135', 2, '2019-02-02 16:45:50');
INSERT INTO `security` VALUES (0, '80.229.171.135', 3, '2019-02-02 16:45:50');
INSERT INTO `security` VALUES (0, '80.229.171.135', 1, '2019-02-02 16:46:10');
INSERT INTO `security` VALUES (0, '80.229.171.135', 1, '2019-02-02 16:46:10');
INSERT INTO `security` VALUES (0, '80.229.171.135', 2, '2019-02-02 16:46:13');
INSERT INTO `security` VALUES (0, '80.229.171.135', 3, '2019-02-02 16:46:13');
INSERT INTO `security` VALUES (0, '80.229.171.135', 1, '2019-02-02 16:46:41');
INSERT INTO `security` VALUES (0, '80.229.171.135', 1, '2019-02-02 17:19:42');
INSERT INTO `security` VALUES (0, '66.249.79.153', 1, '2019-02-02 19:24:52');
INSERT INTO `security` VALUES (0, '66.249.93.28', 1, '2019-02-02 20:10:28');
INSERT INTO `security` VALUES (0, '66.102.6.85', 1, '2019-02-03 02:59:51');
INSERT INTO `security` VALUES (0, '66.102.9.134', 1, '2019-02-03 04:04:25');
INSERT INTO `security` VALUES (0, '66.249.79.128', 1, '2019-02-03 05:28:22');
INSERT INTO `security` VALUES (0, '66.249.83.90', 1, '2019-02-03 06:56:30');
INSERT INTO `security` VALUES (0, '172.69.68.83', 1, '2019-02-03 12:37:57');
INSERT INTO `security` VALUES (0, '172.69.68.113', 1, '2019-02-03 16:59:03');
INSERT INTO `security` VALUES (0, '172.69.68.83', 1, '2019-02-03 23:59:17');
INSERT INTO `security` VALUES (0, '66.102.6.90', 1, '2019-02-04 00:14:14');
INSERT INTO `security` VALUES (0, '172.69.68.113', 1, '2019-02-04 02:52:22');
INSERT INTO `security` VALUES (0, '172.69.71.8', 1, '2019-02-04 10:03:44');
INSERT INTO `security` VALUES (0, '66.249.79.45', 1, '2019-02-04 10:14:14');
INSERT INTO `security` VALUES (0, '172.69.68.113', 1, '2019-02-04 11:57:31');

-- ----------------------------
-- Table structure for sys_logs
-- ----------------------------
DROP TABLE IF EXISTS `sys_logs`;
CREATE TABLE `sys_logs`  (
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `log_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IP_ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_logs
-- ----------------------------
INSERT INTO `sys_logs` VALUES ('Testusername registered.', '4', '172.68.47.26');
INSERT INTO `sys_logs` VALUES ('Testusername registered.', '4', '172.68.47.26');
INSERT INTO `sys_logs` VALUES ('Testusername registered.', '4', '172.68.47.26');
INSERT INTO `sys_logs` VALUES ('Delicioso registered.', '4', '2600:8802:5700:33d:60eb:ea9a:c80c:c54');
INSERT INTO `sys_logs` VALUES ('Harry registered.', '4', '80.229.171.135');

-- ----------------------------
-- Table structure for validations
-- ----------------------------
DROP TABLE IF EXISTS `validations`;
CREATE TABLE `validations`  (
  `id` int(11) UNSIGNED NOT NULL,
  `username` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `code` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `type` int(2) NOT NULL DEFAULT 0,
  `timestamp` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `value` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of validations
-- ----------------------------
INSERT INTO `validations` VALUES (4, 'community', 'gxEjUdPoT!Qyl8DbWXGeqZL6VcwivY', 1, '2016-03-22 19:02:23', 'wildscapepk@gmail.com');

-- ----------------------------
-- Table structure for votes
-- ----------------------------
DROP TABLE IF EXISTS `votes`;
CREATE TABLE `votes`  (
  `id` int(11) NOT NULL,
  `username` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `site` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `timestamp` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0)
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for voting_sites
-- ----------------------------
DROP TABLE IF EXISTS `voting_sites`;
CREATE TABLE `voting_sites`  (
  `name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT 'Null',
  `wait` int(5) NOT NULL DEFAULT 12,
  `credits` int(2) NOT NULL DEFAULT 1,
  `link` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT 'http://RuinsPSrsps.com',
  `get_command` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `host_name` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT ''
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of voting_sites
-- ----------------------------
INSERT INTO `voting_sites` VALUES ('rune-server', 24, 1, 'http://RuinsPSrsps.com', 'data', '');
INSERT INTO `voting_sites` VALUES ('runelocus', 12, 1, 'http://RuinsPSrsps.com', 'usr', '');
INSERT INTO `voting_sites` VALUES ('top-100-arena', 12, 1, 'http://RuinsPSrsps.com', 'postback', '');
INSERT INTO `voting_sites` VALUES ('topg', 12, 1, 'http://RuinsPSrsps.com', 'p_resp', 'monitor.topg.org');

-- ----------------------------
-- Table structure for worlds
-- ----------------------------
DROP TABLE IF EXISTS `worlds`;
CREATE TABLE `worlds`  (
  `world` int(11) NOT NULL,
  `ip` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `players` int(11) NOT NULL,
  `country` int(11) NOT NULL,
  `member` int(11) NOT NULL,
  `revision` int(11) NOT NULL COMMENT '498',
  PRIMARY KEY (`world`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worlds
-- ----------------------------
INSERT INTO `worlds` VALUES (2, '127.0.0.1', 1, 38, 1, 498);

SET FOREIGN_KEY_CHECKS = 1;
