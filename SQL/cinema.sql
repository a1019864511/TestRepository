/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : cinema

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-04-18 18:22:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss` (
  `user_id` int(11) NOT NULL,
  `movie_id` int(11) DEFAULT NULL,
  `discusss` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `discuss_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of discuss
-- ----------------------------
INSERT INTO `discuss` VALUES ('123', '2', '这部电影讲道理有点丑陋不是太好看', '2020-04-14 10:53:31');
INSERT INTO `discuss` VALUES ('456', '2', '这部电影很出', '2020-04-07 10:53:34');

-- ----------------------------
-- Table structure for middle
-- ----------------------------
DROP TABLE IF EXISTS `middle`;
CREATE TABLE `middle` (
  `movie_id` int(11) DEFAULT NULL,
  `site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of middle
-- ----------------------------
INSERT INTO `middle` VALUES ('2', '3排3座3排4座', '123');
INSERT INTO `middle` VALUES ('2', '2排3座2排4座3排3座3排4座', '123');
INSERT INTO `middle` VALUES ('2', '4排3座4排4座', '123');
INSERT INTO `middle` VALUES ('2', '2排5座3排5座4排5座5排5座', '123');
INSERT INTO `middle` VALUES ('2', '4排6座5排3座5排4座5排6座', '123');
INSERT INTO `middle` VALUES ('2', '4排6座5排3座5排4座5排6座', '123');
INSERT INTO `middle` VALUES ('2', '1排4座1排5座', '123');
INSERT INTO `middle` VALUES ('2', '2排2座3排2座', '123');
INSERT INTO `middle` VALUES ('2', '2排6座3排6座', '123');
INSERT INTO `middle` VALUES ('2', '4排7座5排7座', '123');
INSERT INTO `middle` VALUES ('2', '2排8座3排8座4排8座', '123');
INSERT INTO `middle` VALUES ('2', '1排7座2排7座', '123');
INSERT INTO `middle` VALUES ('2', '4排2座5排2座', '123');
INSERT INTO `middle` VALUES ('2', '1排2座1排3座', '123');
INSERT INTO `middle` VALUES ('2', '1排6座3排7座', '123');
INSERT INTO `middle` VALUES ('2', '1排2座2排2座', '123');
INSERT INTO `middle` VALUES ('2', '1排3座2排3座', '123');
INSERT INTO `middle` VALUES ('2', '1排4座2排4座', '123');
INSERT INTO `middle` VALUES ('2', '3排4座4排4座5排4座', '123');
INSERT INTO `middle` VALUES ('2', '4排5座4排6座', '123');
INSERT INTO `middle` VALUES ('2', '3排4座4排4座', '123');
INSERT INTO `middle` VALUES ('2', '2排3座3排3座', '123');
INSERT INTO `middle` VALUES ('2', '3排4座4排4座', '123');
INSERT INTO `middle` VALUES ('2', '2排2座2排3座', '123');
INSERT INTO `middle` VALUES ('2', '3排5座4排5座', '123');
INSERT INTO `middle` VALUES ('2', '2排4座2排5座', '123');
INSERT INTO `middle` VALUES ('2', '1排4座1排5座', '123');
INSERT INTO `middle` VALUES ('2', '3排6座4排6座', '123');
INSERT INTO `middle` VALUES ('2', '3排4座4排4座', '123');
INSERT INTO `middle` VALUES ('2', '1排3座3排3座', '123');
INSERT INTO `middle` VALUES ('2', '1排2座3排2座', '123');
INSERT INTO `middle` VALUES ('2', '2排7座3排7座', '123');
INSERT INTO `middle` VALUES ('2', '4排3座5排3座', '123');
INSERT INTO `middle` VALUES ('2', '2排8座3排8座4排7座4排8座5排5座5排6座5排7座5排8座', '123');
INSERT INTO `middle` VALUES ('2', '1排1座2排1座', '123');
INSERT INTO `middle` VALUES ('2', '4排2座5排4座', '123');
INSERT INTO `middle` VALUES ('2', '1排6座1排7座2排6座5排2座', '123');
INSERT INTO `middle` VALUES ('3', '1排5座2排5座', '123');
INSERT INTO `middle` VALUES ('3', '3排6座5排5座', '123');
INSERT INTO `middle` VALUES ('2', '3排4座4排4座', '123');
INSERT INTO `middle` VALUES ('4', '3排5座4排5座', '123');
INSERT INTO `middle` VALUES ('6', '2排4座3排4座', '123');
INSERT INTO `middle` VALUES ('5', '2排4座3排4座', '123');

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `movie_name` varchar(255) DEFAULT NULL,
  `movie_id` int(11) DEFAULT NULL,
  `movie_actor` varchar(255) DEFAULT NULL,
  `movie_introduce` varchar(255) DEFAULT NULL,
  `movie_direct` varchar(255) DEFAULT NULL,
  `site_id` int(11) DEFAULT NULL,
  `movie_area` varchar(255) DEFAULT NULL,
  `movie_time` varchar(11) DEFAULT NULL,
  `movie_imgsrc` varchar(255) DEFAULT NULL,
  `movie_site` varchar(1028) DEFAULT NULL,
  `movie_price` decimal(10,0) DEFAULT NULL,
  `movie_kind` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('死王凝视', '2', '史密斯', '这是一部比那个更恐怖的电影', '史密斯', '102', 'A102', '7月18日 19:00', 'Priest.jpg', '3排4座4排4座3', '56', '爱情片');
INSERT INTO `movie` VALUES ('阿库达', '3', '刘幸', '这是一部刘幸导演的奇幻电影超级好看', '刘幸，佘飘', '103', 'A103', '7月29日 20:00', 'avatar_movie.jpg', '3排6座5排5座1排5座2排5座1', '78', '动作片');
INSERT INTO `movie` VALUES ('WARII', '4', '死球球', '这是一部超级好看的电影', '刘幸', '104', 'A104', '7月29日 20:00', 'Eclipse.jpg', '3排5座4排5座2', '96', '科幻片');
INSERT INTO `movie` VALUES ('迪迦奥特曼', '5', '刘幸', '这是一部刘幸导演的奇幻电影超级好看', '刘幸，佘飘', '103', 'A103', '7月29日 20:00', 'black-swan.jpg', '2排4座3排4座1', '78', '悬疑片');
INSERT INTO `movie` VALUES ('阿库达', '6', '刘幸', '这是一部刘幸导演的奇幻电影超级好看', '刘幸，佘飘', '103', 'A103', '7月29日 20:00', 'Coraline.jpg', '2排4座3排4座1', '78', '喜剧片');
INSERT INTO `movie` VALUES ('阿库达', '8', '刘幸', '这是一部刘幸导演的奇幻电影超级好看', '刘幸，佘飘', '103', 'A103', '7月29日 20:00', 'New-Moon-The-Score-cover-twilight.jpg', '1', '78', '战争片');
INSERT INTO `movie` VALUES ('阿库达', '9', '刘幸', '这是一部刘幸导演的奇幻电影超级好看', '刘幸，佘飘', '103', 'A103', '7月29日 20:00', 'avatar_movie.jpg', '1', '78', '恐怖片');
INSERT INTO `movie` VALUES ('阿库达', '10', '刘幸', '这是一部刘幸导演的奇幻电影超级好看', '刘幸，佘飘', '103', 'A103', '7月29日 20:00', 'avatar_movie.jpg', '1', '78', '恐怖片');
INSERT INTO `movie` VALUES ('阿库达', '11', '刘幸', '这是一部刘幸导演的奇幻电影超级好看', '刘幸，佘飘', '103', 'A103', '7月29日 20:00', 'avatar_movie.jpg', '1', '78', '恐怖片');
INSERT INTO `movie` VALUES ('阿库达', '12', '刘幸', '这是一部刘幸导演的奇幻电影超级好看', '刘幸，佘飘', '103', 'A103', '7月29日 20:00', 'avatar_movie.jpg', '1', '78', '恐怖片');
INSERT INTO `movie` VALUES ('阿库达', '7', '刘幸', '这是一部刘幸导演的奇幻电影超级好看', '刘幸，佘飘', '103', 'A103', '7月29日 20:00', 'avatar_movie.jpg', '1', '78', '恐怖片');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` varchar(20) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `order_createTime` datetime DEFAULT NULL,
  `movie_id` int(11) DEFAULT NULL,
  `user_price` varchar(20) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `order_site` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('200401090224', '123', '2020-04-01 01:02:24', '2', '112', '1', '1排3座3排3座');
INSERT INTO `order` VALUES ('200415204505', '123', '2020-04-15 12:45:05', '6', '156', '0', '2排4座3排4座');
INSERT INTO `order` VALUES ('200415204511', '123', '2020-04-15 12:45:12', '5', '156', '0', '2排4座3排4座');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_pwd` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_phone` varchar(255) NOT NULL,
  `user_money` double(255,0) NOT NULL,
  `user_gender` varchar(255) NOT NULL,
  `user_imgsrc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_phone` (`user_phone`) USING BTREE,
  UNIQUE KEY `user_email` (`user_email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123', '1816398177@qq.com', '123', '123', '18163981786', '456', '女', '2001e2e0.png');
INSERT INTO `user` VALUES ('123456', '10198645121@qq.com', '123456', '23', '17752870412', '0', '男', 'http://t.cn/RCzsdCq');
INSERT INTO `user` VALUES ('456', '1019864511@qq.com', '123465', '456', '18163981776', '789', '男', 'http://t.cn/RCzsdCq');
