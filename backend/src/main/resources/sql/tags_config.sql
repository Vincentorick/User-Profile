/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : label

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 26/06/2021 15:57:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tags_count
-- ----------------------------
DROP TABLE IF EXISTS `tags_count`;
CREATE TABLE `tags_count`  (
  `id` bigint(0) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `count` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tags_count
-- ----------------------------
INSERT INTO `tags_count` VALUES (50, '男', NULL);
INSERT INTO `tags_count` VALUES (51, '女', NULL);
INSERT INTO `tags_count` VALUES (52, '50后', NULL);
INSERT INTO `tags_count` VALUES (53, '60后', NULL);
INSERT INTO `tags_count` VALUES (54, '70后', NULL);
INSERT INTO `tags_count` VALUES (55, '80后', NULL);
INSERT INTO `tags_count` VALUES (56, '90后', NULL);
INSERT INTO `tags_count` VALUES (57, '00后', NULL);
INSERT INTO `tags_count` VALUES (58, '10后', NULL);
INSERT INTO `tags_count` VALUES (59, '20后', NULL);
INSERT INTO `tags_count` VALUES (60, '150-159', NULL);
INSERT INTO `tags_count` VALUES (61, '160-169', NULL);
INSERT INTO `tags_count` VALUES (62, '170-179', NULL);
INSERT INTO `tags_count` VALUES (63, '180-189', NULL);
INSERT INTO `tags_count` VALUES (64, '190-199', NULL);
INSERT INTO `tags_count` VALUES (65, '200-209', NULL);
INSERT INTO `tags_count` VALUES (66, '210-240', NULL);
INSERT INTO `tags_count` VALUES (67, '汉族', NULL);
INSERT INTO `tags_count` VALUES (68, '蒙古族', NULL);
INSERT INTO `tags_count` VALUES (69, '回族', NULL);
INSERT INTO `tags_count` VALUES (70, '藏族', NULL);
INSERT INTO `tags_count` VALUES (71, '维吾尔族', NULL);
INSERT INTO `tags_count` VALUES (72, '苗族', NULL);
INSERT INTO `tags_count` VALUES (73, '满族', NULL);
INSERT INTO `tags_count` VALUES (74, '北京', NULL);
INSERT INTO `tags_count` VALUES (75, '上海', NULL);
INSERT INTO `tags_count` VALUES (76, '广州', NULL);
INSERT INTO `tags_count` VALUES (77, '深圳', NULL);
INSERT INTO `tags_count` VALUES (78, '杭州', NULL);
INSERT INTO `tags_count` VALUES (79, '苏州', NULL);
INSERT INTO `tags_count` VALUES (80, '群众', NULL);
INSERT INTO `tags_count` VALUES (81, '党员', NULL);
INSERT INTO `tags_count` VALUES (82, '无党派人士', NULL);
INSERT INTO `tags_count` VALUES (83, '学生', NULL);
INSERT INTO `tags_count` VALUES (84, '公务员', NULL);
INSERT INTO `tags_count` VALUES (85, '军人', NULL);
INSERT INTO `tags_count` VALUES (86, '警察', NULL);
INSERT INTO `tags_count` VALUES (87, '教师', NULL);
INSERT INTO `tags_count` VALUES (88, '工人', NULL);
INSERT INTO `tags_count` VALUES (89, '未婚', NULL);
INSERT INTO `tags_count` VALUES (90, '已婚', NULL);
INSERT INTO `tags_count` VALUES (91, '离异', NULL);
INSERT INTO `tags_count` VALUES (92, '小学', NULL);
INSERT INTO `tags_count` VALUES (93, '初中', NULL);
INSERT INTO `tags_count` VALUES (94, '高中', NULL);
INSERT INTO `tags_count` VALUES (95, '大专', NULL);
INSERT INTO `tags_count` VALUES (96, '本科', NULL);
INSERT INTO `tags_count` VALUES (97, '硕士', NULL);
INSERT INTO `tags_count` VALUES (98, '博士', NULL);
INSERT INTO `tags_count` VALUES (99, '事业单位', NULL);
INSERT INTO `tags_count` VALUES (100, '在职', NULL);
INSERT INTO `tags_count` VALUES (101, '待业', NULL);
INSERT INTO `tags_count` VALUES (102, '自主创业', NULL);
INSERT INTO `tags_count` VALUES (103, '白羊座', NULL);
INSERT INTO `tags_count` VALUES (104, '金牛座', NULL);
INSERT INTO `tags_count` VALUES (105, '双子座', NULL);
INSERT INTO `tags_count` VALUES (106, '巨蟹座', NULL);
INSERT INTO `tags_count` VALUES (107, '狮子座', NULL);
INSERT INTO `tags_count` VALUES (108, '处女座', NULL);
INSERT INTO `tags_count` VALUES (109, '天秤座', NULL);
INSERT INTO `tags_count` VALUES (110, '天蝎座', NULL);
INSERT INTO `tags_count` VALUES (111, '射手座', NULL);
INSERT INTO `tags_count` VALUES (112, '摩羯座', NULL);
INSERT INTO `tags_count` VALUES (113, '水瓶座', NULL);
INSERT INTO `tags_count` VALUES (114, '双鱼座', NULL);
INSERT INTO `tags_count` VALUES (115, 'CBD', NULL);
INSERT INTO `tags_count` VALUES (116, '西单', NULL);
INSERT INTO `tags_count` VALUES (117, '王府井', NULL);
INSERT INTO `tags_count` VALUES (118, '朝外', NULL);
INSERT INTO `tags_count` VALUES (119, '三里屯', NULL);
INSERT INTO `tags_count` VALUES (120, '徐家汇', NULL);
INSERT INTO `tags_count` VALUES (121, '环球港', NULL);
INSERT INTO `tags_count` VALUES (122, '中国大陆', NULL);
INSERT INTO `tags_count` VALUES (123, '中国香港', NULL);
INSERT INTO `tags_count` VALUES (124, '中国澳门', NULL);
INSERT INTO `tags_count` VALUES (125, '中国台湾', NULL);
INSERT INTO `tags_count` VALUES (126, '其他', NULL);
INSERT INTO `tags_count` VALUES (127, '近7天', NULL);
INSERT INTO `tags_count` VALUES (128, '近14天', NULL);
INSERT INTO `tags_count` VALUES (129, '近30天', NULL);
INSERT INTO `tags_count` VALUES (130, '近60天', NULL);
INSERT INTO `tags_count` VALUES (131, '近90天', NULL);
INSERT INTO `tags_count` VALUES (132, '超高', NULL);
INSERT INTO `tags_count` VALUES (133, '高', NULL);
INSERT INTO `tags_count` VALUES (134, '中上', NULL);
INSERT INTO `tags_count` VALUES (135, '中', NULL);
INSERT INTO `tags_count` VALUES (136, '中下', NULL);
INSERT INTO `tags_count` VALUES (137, '低', NULL);
INSERT INTO `tags_count` VALUES (138, '很低', NULL);
INSERT INTO `tags_count` VALUES (139, '1-999', NULL);
INSERT INTO `tags_count` VALUES (140, '1000-2999', NULL);
INSERT INTO `tags_count` VALUES (141, '3000-4999', NULL);
INSERT INTO `tags_count` VALUES (142, '5000-9999', NULL);
INSERT INTO `tags_count` VALUES (143, '支付宝', NULL);
INSERT INTO `tags_count` VALUES (144, '微信', NULL);
INSERT INTO `tags_count` VALUES (145, '储蓄卡', NULL);
INSERT INTO `tags_count` VALUES (146, '信用卡', NULL);
INSERT INTO `tags_count` VALUES (147, '1-999', NULL);
INSERT INTO `tags_count` VALUES (148, '1000-2999', NULL);
INSERT INTO `tags_count` VALUES (149, '3000-4999', NULL);
INSERT INTO `tags_count` VALUES (150, '5000-9999', NULL);
INSERT INTO `tags_count` VALUES (151, '高', NULL);
INSERT INTO `tags_count` VALUES (152, '中', NULL);
INSERT INTO `tags_count` VALUES (153, '低', NULL);
INSERT INTO `tags_count` VALUES (154, '高', NULL);
INSERT INTO `tags_count` VALUES (155, '中', NULL);
INSERT INTO `tags_count` VALUES (156, '低', NULL);
INSERT INTO `tags_count` VALUES (157, '高', NULL);
INSERT INTO `tags_count` VALUES (158, '中', NULL);
INSERT INTO `tags_count` VALUES (159, '低', NULL);
INSERT INTO `tags_count` VALUES (160, '3折-4折', NULL);
INSERT INTO `tags_count` VALUES (161, '5折-7折', NULL);
INSERT INTO `tags_count` VALUES (162, '8折-9折', NULL);
INSERT INTO `tags_count` VALUES (163, '折扣券', NULL);
INSERT INTO `tags_count` VALUES (164, '活动券', NULL);
INSERT INTO `tags_count` VALUES (165, '积分换购', NULL);
INSERT INTO `tags_count` VALUES (166, '高', NULL);
INSERT INTO `tags_count` VALUES (167, '中', NULL);
INSERT INTO `tags_count` VALUES (168, '低', NULL);
INSERT INTO `tags_count` VALUES (169, '1天内', NULL);
INSERT INTO `tags_count` VALUES (170, '7天内', NULL);
INSERT INTO `tags_count` VALUES (171, '14天内', NULL);
INSERT INTO `tags_count` VALUES (172, '30天内', NULL);
INSERT INTO `tags_count` VALUES (173, '登录页', NULL);
INSERT INTO `tags_count` VALUES (174, '首页', NULL);
INSERT INTO `tags_count` VALUES (175, '分类页', NULL);
INSERT INTO `tags_count` VALUES (176, '商品页', NULL);
INSERT INTO `tags_count` VALUES (177, '我的订单页', NULL);
INSERT INTO `tags_count` VALUES (178, '订单物流页', NULL);
INSERT INTO `tags_count` VALUES (179, '1分钟内', NULL);
INSERT INTO `tags_count` VALUES (180, '1-5分钟内', NULL);
INSERT INTO `tags_count` VALUES (181, '5分钟以上', NULL);
INSERT INTO `tags_count` VALUES (182, '经常', NULL);
INSERT INTO `tags_count` VALUES (183, '偶尔', NULL);
INSERT INTO `tags_count` VALUES (184, '很少', NULL);
INSERT INTO `tags_count` VALUES (185, '从不', NULL);
INSERT INTO `tags_count` VALUES (186, 'Windows', NULL);
INSERT INTO `tags_count` VALUES (187, 'Mac', NULL);
INSERT INTO `tags_count` VALUES (188, 'Linux', NULL);
INSERT INTO `tags_count` VALUES (189, 'Android', NULL);
INSERT INTO `tags_count` VALUES (190, 'IOS', NULL);
INSERT INTO `tags_count` VALUES (191, '1点-7点', NULL);
INSERT INTO `tags_count` VALUES (192, '8点-12点', NULL);
INSERT INTO `tags_count` VALUES (193, '13点-17点', NULL);
INSERT INTO `tags_count` VALUES (194, '18点-21点', NULL);
INSERT INTO `tags_count` VALUES (195, '22点-24点', NULL);
INSERT INTO `tags_count` VALUES (196, '无', NULL);
INSERT INTO `tags_count` VALUES (197, '较少', NULL);
INSERT INTO `tags_count` VALUES (198, '一般', NULL);
INSERT INTO `tags_count` VALUES (199, '经常', NULL);
INSERT INTO `tags_count` VALUES (200, '彩电', NULL);
INSERT INTO `tags_count` VALUES (201, '厨房电器', NULL);
INSERT INTO `tags_count` VALUES (202, '热水器', NULL);
INSERT INTO `tags_count` VALUES (203, '冰箱', NULL);
INSERT INTO `tags_count` VALUES (204, '洗衣机', NULL);
INSERT INTO `tags_count` VALUES (205, '生活小电', NULL);
INSERT INTO `tags_count` VALUES (206, '水家电', NULL);
INSERT INTO `tags_count` VALUES (207, '空调', NULL);
INSERT INTO `tags_count` VALUES (208, '冷柜', NULL);
INSERT INTO `tags_count` VALUES (209, '海尔', NULL);
INSERT INTO `tags_count` VALUES (210, '卡萨帝', NULL);
INSERT INTO `tags_count` VALUES (211, '摩卡', NULL);
INSERT INTO `tags_count` VALUES (212, '小超人', NULL);
INSERT INTO `tags_count` VALUES (213, '统帅', NULL);
INSERT INTO `tags_count` VALUES (214, '有房无贷', NULL);
INSERT INTO `tags_count` VALUES (215, '公积金贷款', NULL);
INSERT INTO `tags_count` VALUES (216, '商业贷款', NULL);
INSERT INTO `tags_count` VALUES (217, '无房', NULL);
INSERT INTO `tags_count` VALUES (218, '50w以内', NULL);
INSERT INTO `tags_count` VALUES (219, '50-100w以内', NULL);
INSERT INTO `tags_count` VALUES (220, '100-200w以内', NULL);
INSERT INTO `tags_count` VALUES (221, '200-500w以内', NULL);
INSERT INTO `tags_count` VALUES (222, '500w及以上', NULL);
INSERT INTO `tags_count` VALUES (223, '有车无贷', NULL);
INSERT INTO `tags_count` VALUES (224, '有车有贷', NULL);
INSERT INTO `tags_count` VALUES (225, '无车', NULL);
INSERT INTO `tags_count` VALUES (226, '10w以内', NULL);
INSERT INTO `tags_count` VALUES (227, '10-20w以内', NULL);
INSERT INTO `tags_count` VALUES (228, '20-30w以内', NULL);
INSERT INTO `tags_count` VALUES (229, '30-50w以内', NULL);
INSERT INTO `tags_count` VALUES (230, '50-70w以内', NULL);
INSERT INTO `tags_count` VALUES (231, '70-100w以内', NULL);
INSERT INTO `tags_count` VALUES (232, '100w及以上', NULL);

-- ----------------------------
-- Table structure for tbl_basic_tag
-- ----------------------------
DROP TABLE IF EXISTS `tbl_basic_tag`;
CREATE TABLE `tbl_basic_tag`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名称',
  `industry` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行业、子行业、业务类型、标签、属性',
  `rule` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签规则',
  `business` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务描述',
  `level` int(0) NULL DEFAULT NULL COMMENT '标签等级',
  `pid` bigint(0) NULL DEFAULT NULL COMMENT '父标签ID',
  `ctime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `utime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `state` int(0) NULL DEFAULT NULL COMMENT '状态：1申请中、2开发中、3开发完成、4已上线、5已下线、6已禁用',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 232 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '基础标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_basic_tag
-- ----------------------------
INSERT INTO `tbl_basic_tag` VALUES (1, '电商', '电商', NULL, NULL, 1, -1, '2018-06-08 09:26:28', '2018-06-08 09:26:30', 2, NULL);
INSERT INTO `tbl_basic_tag` VALUES (2, '某商城', '子行业', NULL, NULL, 2, 1, '2018-06-08 09:27:59', '2018-06-08 09:28:01', 2, NULL);
INSERT INTO `tbl_basic_tag` VALUES (3, '人口属性', '用户特征', NULL, NULL, 3, 2, '2018-06-08 09:28:41', '2018-06-08 09:28:42', 2, NULL);
INSERT INTO `tbl_basic_tag` VALUES (4, '商业属性', '消费特征', NULL, NULL, 3, 2, '2018-06-08 09:41:02', '2018-06-08 09:41:04', 2, NULL);
INSERT INTO `tbl_basic_tag` VALUES (5, '行为属性', '兴趣特征', NULL, NULL, 3, 2, '2018-06-08 09:42:36', '2018-06-08 09:42:39', 2, NULL);
INSERT INTO `tbl_basic_tag` VALUES (6, '用户价值', NULL, NULL, NULL, 3, 2, '2019-07-04 00:08:24', '2019-07-04 00:08:24', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (8, '性别', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime', '注册会员的性别', 4, 3, '2019-07-03 23:14:23', '2019-11-20 23:46:58', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (9, '年龄段', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '注册用户的生日所属年龄段', 4, 3, '2019-07-03 23:16:27', '2019-07-03 23:16:27', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (10, '身高', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '注册用户的身高', 4, 3, '2019-07-03 23:18:00', '2019-07-03 23:18:00', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (11, '民族', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '注册用户的民族', 4, 3, '2019-07-03 23:19:45', '2019-07-03 23:19:45', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (12, '籍贯', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '注册用户的籍贯', 4, 3, '2019-07-03 23:21:03', '2019-07-03 23:21:03', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (13, '政治面貌', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '注册用户的政治面貌', 4, 3, '2019-07-03 23:22:29', '2019-07-03 23:22:29', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (14, '职业', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '注册用户的职业', 4, 3, '2019-07-03 23:24:09', '2019-07-03 23:24:09', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (15, '婚姻状况', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '注册用户的婚姻状况', 4, 3, '2019-07-03 23:25:55', '2019-07-03 23:25:55', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (16, '学历', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '注册用户的学历', 4, 3, '2019-07-03 23:27:06', '2019-07-03 23:27:06', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (17, '就业状况', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '注册用户的就业状况', 4, 3, '2019-07-03 23:29:08', '2019-07-03 23:29:08', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (18, '星座', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '注册用户的星座', 4, 3, '2019-07-03 23:35:41', '2019-07-03 23:35:41', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (19, '所在商圈', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '注册用户所属的商圈', 4, 3, '2019-07-03 23:44:59', '2019-07-03 23:44:59', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (20, '国籍', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_users\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '注册用户所属的国籍：中国大陆、中国香港、中国澳门、中国台湾、其他', 4, 3, '2019-07-03 23:46:15', '2019-07-03 23:46:15', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (21, '消费周期', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户的消费周期：7日、2周、1月、2月、3月、4月、5月、6月、1年', 4, 4, '2019-07-03 23:49:06', '2019-07-03 23:49:06', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (22, '消费能力', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户的消费能力：超高、高、中上、中、中下、低、很低', 4, 4, '2019-07-03 23:50:53', '2019-07-03 23:50:53', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (23, '客单价', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户订单数据的客单价：1~999、1000~2999、3000~4999、5000~9999', 4, 4, '2019-07-03 23:53:26', '2019-07-03 23:53:26', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (24, '支付方式', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户订单的支付方式：支付宝、微信、储蓄卡、信用卡', 4, 4, '2019-07-03 23:54:32', '2019-07-03 23:54:32', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (25, '单笔最高', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户订单数据中的金额最高的订单：1~999、1000~2999、3000~4999、5000~9999', 4, 4, '2019-07-03 23:56:19', '2019-07-03 23:56:19', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (26, '购买频率', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户订单数据中的购买频率：高、中、低', 4, 4, '2019-07-03 23:58:06', '2019-07-03 23:58:06', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (27, '退货率', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户订单中的退货率：高、中、低', 4, 4, '2019-07-03 23:59:39', '2019-07-03 23:59:39', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (28, '换货率', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户订单中的换货率：高、中、低', 4, 4, '2019-07-04 00:01:27', '2019-07-04 00:01:27', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (29, '省钱小能手', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '订单中的省钱能手（折扣）：3折~4折、5折~7折、8折~9折', 4, 4, '2019-07-04 00:04:09', '2019-07-04 00:04:09', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (30, '有券必买', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '订单中的有券必买：折扣券、活动券、积分换购', 4, 4, '2019-07-04 00:05:29', '2019-07-04 00:05:29', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (31, '客服咨询频率', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_ consult\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户的客服咨询频率：高、中、低', 4, 4, '2019-07-04 00:07:18', '2019-07-04 00:07:18', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (33, '最近登录', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户行为日志中的最近登录：1日内、7日内、14日内、1个月内', 4, 5, '2019-07-04 00:11:07', '2019-07-04 00:11:07', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (34, '浏览页面', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_logs\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户行为日志中的浏览页面：该商城所有页面', 4, 5, '2019-07-04 00:12:30', '2019-07-04 00:12:30', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (35, '浏览时长', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_logs\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '浏览时长：1分钟内、1~5分钟、5分钟以上', 4, 5, '2019-07-04 00:13:19', '2019-07-04 00:13:19', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (37, '访问频率', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_logs\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户行为数据中的访问频率：经常、从不、偶尔、很少', 4, 5, '2019-07-04 13:54:20', '2019-07-04 13:54:20', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (38, '设备类型', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_logs\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户行为数据中的设备类型：Window、Mac、Linux、Iphone、小米、华为', 4, 5, '2019-07-04 13:55:48', '2019-07-04 13:55:48', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (39, '浏览时段', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_logs\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户行为数据中的浏览时段：1点~7点、8点~12点、13点~17点、18点~21点、22点~24点', 4, 5, '2019-07-04 13:57:32', '2019-07-04 13:57:32', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (40, '近7日登录频率', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_logs\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户行为数据中的登录频率:无、较少、一般、经常', 4, 5, '2019-07-04 13:58:35', '2019-07-04 13:58:35', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (41, '浏览商品', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_logs\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户行为数据中的浏览商品：所有商品', 4, 5, '2019-07-04 13:59:45', '2019-07-04 13:59:45', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (42, '购买商品', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_logs\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户行为数据中的购买商品：所有商品', 4, 5, '2019-07-04 14:01:13', '2019-07-04 14:01:13', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (43, '商品偏好', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_logs\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户行为数据中的商品偏好：所有商品', 4, 5, '2019-07-04 14:03:15', '2019-07-04 14:03:15', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (44, '品类偏好', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_logs\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户行为数据中的品类偏好：所有的品类', 4, 5, '2019-07-04 14:06:12', '2019-07-04 14:06:12', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (45, '品牌偏好', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_logs\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '用户行为数据中的品类偏好', 4, 5, '2019-07-04 14:07:20', '2019-07-04 14:07:20', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (46, '房产', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '从订单数据中确定房产：有房无贷、公积金贷款、商业贷款、无房', 4, 6, '2019-07-04 14:10:38', '2019-07-04 14:10:38', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (47, '房产价值', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '房产价值：50w以内、50~100w以内、100~200w以内、200~500w以内、500w及以上', 4, 6, '2019-07-04 14:12:14', '2019-07-04 14:12:14', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (48, '车产', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '车产：有车无贷、有车有贷、无车', 4, 6, '2019-07-04 14:13:13', '2019-07-04 14:13:13', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (49, '车产价值', '标签', 'inType=hbase\nzkHosts=192.168.10.20\nzkPort=2181\nhbaseTable=tbl_orders\nfamily=info\nselectFieldNames=utime\nwhereFieldNames=utime\nwhereFieldValues=2019-05-10', '车产价值：1~99999、100000~199999、200000~299999、300000~699999、70w及以上', 4, 6, '2019-07-04 14:14:27', '2019-07-04 14:14:27', 4, NULL);
INSERT INTO `tbl_basic_tag` VALUES (50, '男', '属性', '0', '注册会员性别男', 5, 8, '2019-07-04 14:15:02', '2019-07-04 14:15:28', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (51, '女', '属性', '1', '注册会员性别女', 5, 8, '2019-07-04 14:15:19', '2019-07-04 14:15:19', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (52, '50后', '属性', '19500101-19591231', '注册会员出生日期为1950年-1959年区间的', 5, 9, '2019-07-04 14:16:51', '2019-07-04 14:17:31', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (53, '60后', '属性', '19600101-19691231', '注册会员出生日期为1960年-1969年区间的', 5, 9, '2019-07-04 14:17:53', '2019-07-04 14:17:53', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (54, '70后', '属性', '19700101-19791231', '注册会员出生日期为1970年-1979年区间的', 5, 9, '2019-07-04 14:18:21', '2019-07-04 14:18:21', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (55, '80后', '属性', '19800101-19891231', '注册会员出生日期为1980年-1989年区间的', 5, 9, '2019-07-04 14:19:05', '2019-07-04 14:19:05', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (56, '90后', '属性', '19900101-19991231', '注册会员出生日期为1990年-1999年区间的', 5, 9, '2019-07-04 14:19:46', '2019-07-04 14:19:46', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (57, '00后', '属性', '20000101-20091231', '注册会员出生日期为2000年-2009年区间的', 5, 9, '2019-07-04 14:20:32', '2019-07-04 14:20:32', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (58, '10后', '属性', '20100101-20191231', '注册会员出生日期为2010年-2019年区间的', 5, 9, '2019-07-04 14:21:13', '2019-07-04 14:21:13', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (59, '20后', '属性', '20200101-20291231', '注册会员出生日期为2020年-2029年区间的', 5, 9, '2019-07-04 14:22:00', '2019-07-04 14:22:00', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (60, '150-159', '属性', '150-159', '用户身高在150-159区间', 5, 10, '2019-07-04 14:23:12', '2019-07-04 14:23:12', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (61, '160-169', '属性', '160-169', '用户身高在160-169区间', 5, 10, '2019-07-04 14:23:49', '2019-07-04 14:23:49', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (62, '170-179', '属性', '170-179', '用户身高在170-179区间', 5, 10, '2019-07-04 14:24:29', '2019-07-04 14:24:29', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (63, '180-189', '属性', '180-189', '用户身高在180-189区间', 5, 10, '2019-07-04 14:24:44', '2019-07-04 14:24:44', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (64, '190-199', '属性', '190-199', '用户身高在190-199区间', 5, 10, '2019-07-04 14:32:33', '2019-07-04 14:32:33', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (65, '200-209', '属性', '200-209', '用户身高在200-209区间', 5, 10, '2019-07-04 14:33:04', '2019-07-04 14:33:04', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (66, '210-240', '属性', '210-240', '用户身高在210-240区间', 5, 10, '2019-07-04 14:33:23', '2019-07-04 14:33:23', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (67, '汉族', '属性', '0', '注册会员民族为汉族', 5, 11, '2019-07-04 14:35:23', '2019-07-04 14:35:23', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (68, '蒙古族', '属性', '1', '注册会员民族为蒙古族', 5, 11, '2019-07-04 14:38:57', '2019-07-04 14:38:57', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (69, '回族', '属性', '2', '注册会员民族为回族', 5, 11, '2019-07-04 14:39:26', '2019-07-04 14:39:26', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (70, '藏族', '属性', '3', '注册会员民族为藏族', 5, 11, '2019-07-04 14:39:58', '2019-07-04 14:39:58', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (71, '维吾尔族', '属性', '4', '注册会员民族为维吾尔族', 5, 11, '2019-07-04 14:42:01', '2019-07-04 14:42:01', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (72, '苗族', '属性', '5', '注册会员民族为苗族', 5, 11, '2019-07-04 14:42:22', '2019-07-04 14:42:22', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (73, '满族', '属性', '6', '注册会员民族为满族', 5, 11, '2019-07-04 14:42:44', '2019-07-04 14:42:44', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (74, '北京', '属性', 'beijing', '注册会员籍贯为北京', 5, 12, '2019-07-04 14:43:31', '2019-07-04 14:43:31', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (75, '上海', '属性', 'shanghai', '注册会员籍贯为上海', 5, 12, '2019-07-04 14:43:57', '2019-07-04 14:43:57', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (76, '广州', '属性', 'guangzhou', '注册会员籍贯为广州', 5, 12, '2019-07-04 14:44:25', '2019-07-04 14:44:25', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (77, '深圳', '属性', 'shenzhen', '注册会员籍贯为深圳', 5, 12, '2019-07-04 14:44:54', '2019-07-04 14:44:54', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (78, '杭州', '属性', 'hangzhou', '注册会员籍贯为杭州', 5, 12, '2019-07-04 14:45:16', '2019-07-04 14:45:16', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (79, '苏州', '属性', 'suzhou', '注册用户籍贯为苏州', 5, 12, '2019-07-04 14:45:36', '2019-07-04 14:45:36', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (80, '群众', '属性', '群众', '政治面貌为群众', 5, 13, '2019-07-04 14:46:07', '2019-07-04 14:46:07', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (81, '党员', '属性', '党员', '政治面貌为党员', 5, 13, '2019-07-04 14:46:36', '2019-07-04 14:46:36', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (82, '无党派人士', '属性', '无党派人士', '政治面貌为无党派人士', 5, 13, '2019-07-04 14:46:59', '2019-07-04 14:46:59', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (83, '学生', '属性', '学生', '职业是学生', 5, 14, '2019-07-04 14:49:43', '2019-07-04 14:49:43', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (84, '公务员', '属性', '公务员', '职业是公务员', 5, 14, '2019-07-04 14:50:03', '2019-07-04 14:50:03', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (85, '军人', '属性', '军人', '职业是军人', 5, 14, '2019-07-04 14:50:16', '2019-07-04 14:50:16', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (86, '警察', '属性', '警察', '职业是警察', 5, 14, '2019-07-04 14:50:33', '2019-07-04 14:50:33', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (87, '教师', '属性', '教师', '职业是教师', 5, 14, '2019-07-04 14:50:48', '2019-07-04 14:50:48', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (88, '工人', '属性', '工人', '职业是工人', 5, 14, '2019-07-04 14:51:04', '2019-07-04 14:51:04', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (89, '未婚', '属性', '未婚', '婚姻状况是未婚', 5, 15, '2019-07-04 14:51:31', '2019-07-04 14:51:31', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (90, '已婚', '属性', '已婚', '婚姻状况是已婚', 5, 15, '2019-07-04 14:51:52', '2019-07-04 14:51:52', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (91, '离异', '属性', '离异', '婚姻状况是离异', 5, 15, '2019-07-04 14:52:04', '2019-07-04 14:52:04', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (92, '小学', '属性', '小学', '学历是小学', 5, 16, '2019-07-04 14:52:22', '2019-07-04 14:52:22', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (93, '初中', '属性', '初中', '学历是初中', 5, 16, '2019-07-04 14:52:50', '2019-07-04 14:52:50', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (94, '高中', '属性', '高中', '学历是高中', 5, 16, '2019-07-04 14:53:05', '2019-07-04 14:53:05', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (95, '大专', '属性', '大专', '学历是大专', 5, 16, '2019-07-04 14:53:23', '2019-07-04 14:53:23', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (96, '本科', '属性', '本科', '学历是本科', 5, 16, '2019-07-04 14:53:35', '2019-07-04 14:53:35', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (97, '硕士', '属性', '硕士', '学历是硕士', 5, 16, '2019-07-04 14:55:07', '2019-07-04 14:55:07', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (98, '博士', '属性', '博士', '学历是博士', 5, 16, '2019-07-04 14:55:22', '2019-07-04 14:55:22', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (99, '事业单位', '属性', '事业单位', '在事业单位就业', 5, 17, '2019-07-04 14:56:00', '2019-07-04 14:56:00', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (100, '在职', '属性', '在职', '就业状况是在职', 5, 17, '2019-07-04 14:56:26', '2019-07-04 14:56:26', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (101, '待业', '属性', '待业', '就业状况是待业', 5, 17, '2019-07-04 14:57:06', '2019-07-04 14:57:06', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (102, '自主创业', '属性', '自主就业', '就业状况为自主就业', 5, 17, '2019-07-04 15:00:01', '2019-07-04 15:00:01', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (103, '白羊座', '属性', '0321-0420', '白羊座', 5, 18, '2019-07-04 15:02:05', '2019-07-04 15:02:05', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (104, '金牛座', '属性', '0421-0521', '金牛座', 5, 18, '2019-07-04 15:02:28', '2019-07-04 15:02:28', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (105, '双子座', '属性', '0522-0621', '双子座', 5, 18, '2019-07-04 15:03:08', '2019-07-04 15:03:08', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (106, '巨蟹座', '属性', '0622-0722', '巨蟹座', 5, 18, '2019-07-04 15:04:05', '2019-07-04 15:04:05', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (107, '狮子座', '属性', '0723-0922', '狮子座', 5, 18, '2019-07-04 15:05:28', '2019-07-04 15:05:28', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (108, '处女座', '属性', '0823-0923', '处女座', 5, 18, '2019-07-04 15:05:46', '2019-07-04 15:05:46', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (109, '天秤座', '属性', '0924-1023', '天秤座', 5, 18, '2019-07-04 15:06:12', '2019-07-04 15:06:12', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (110, '天蝎座', '属性', '1024-1122', '天蝎座', 5, 18, '2019-07-04 15:07:56', '2019-07-04 15:07:56', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (111, '射手座', '属性', '1123-1221', '射手座', 5, 18, '2019-07-04 15:09:03', '2019-07-04 15:09:03', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (112, '摩羯座', '属性', '1222-0120', '摩羯座', 5, 18, '2019-07-04 15:09:27', '2019-07-04 15:09:27', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (113, '水瓶座', '属性', '0121-0219', '水瓶座', 5, 18, '2019-07-04 15:09:53', '2019-07-04 15:09:53', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (114, '双鱼座', '属性', '0220-0320', '双鱼座', 5, 18, '2019-07-04 15:10:16', '2019-07-04 15:10:16', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (115, 'CBD', '属性', 'CBD', '在CBD', 5, 19, '2019-07-04 15:10:58', '2019-07-04 15:10:58', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (116, '西单', '属性', '西单', '在西单', 5, 19, '2019-07-04 15:11:19', '2019-07-04 15:11:19', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (117, '王府井', '属性', '王府井', '在王府井', 5, 19, '2019-07-04 15:11:34', '2019-07-04 15:11:34', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (118, '朝外', '属性', '朝外', '在朝外', 5, 19, '2019-07-04 15:11:46', '2019-07-04 15:11:46', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (119, '三里屯', '属性', '三里屯', '在三里屯', 5, 19, '2019-07-04 15:12:07', '2019-07-04 15:12:07', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (120, '徐家汇', '属性', '徐家汇', '在徐家汇', 5, 19, '2019-07-04 15:12:21', '2019-07-04 15:12:21', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (121, '环球港', '属性', '环球港', '在环球港', 5, 19, '2019-07-04 15:12:33', '2019-07-04 15:12:33', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (122, '中国大陆', '属性', '中国大陆', '国籍是中国大陆', 5, 20, '2019-07-04 15:13:05', '2019-07-04 15:13:05', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (123, '中国香港', '属性', '中国香港', '国籍是中国香港', 5, 20, '2019-07-04 15:13:20', '2019-07-04 15:13:20', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (124, '中国澳门', '属性', '中国澳门', '国籍是中国澳门', 5, 20, '2019-07-04 15:13:43', '2019-07-04 15:13:43', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (125, '中国台湾', '属性', '中国台湾', '国籍是中国台湾', 5, 20, '2019-07-04 15:13:57', '2019-07-04 15:13:57', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (126, '其他', '属性', '其他', '国籍是其他', 5, 20, '2019-07-04 15:14:14', '2019-07-04 15:14:14', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (127, '近7天', '属性', '7day', '消费周期是近7日', 5, 21, '2019-07-04 15:15:29', '2019-07-04 15:15:29', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (128, '近14天', '属性', '14day', '消费周期是近2周', 5, 21, '2019-07-04 15:15:59', '2019-07-04 15:15:59', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (129, '近30天', '属性', '30day', '消费周期是近1月', 5, 21, '2019-07-04 15:16:39', '2019-07-04 15:16:39', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (130, '近60天', '属性', '60day', '消费周期是近60天', 5, 21, '2019-07-04 15:17:29', '2019-07-04 15:17:29', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (131, '近90天', '属性', '90day', '消费周期是近90天', 5, 21, '2019-07-04 15:18:41', '2019-07-04 15:18:41', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (132, '超高', '属性', '50000-1000000', '超高的消费能力', 5, 22, '2019-07-04 15:19:40', '2019-07-04 15:19:40', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (133, '高', '属性', '40000-49999', '高消费能力', 5, 22, '2019-07-04 15:20:25', '2019-07-04 15:20:25', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (134, '中上', '属性', '30000-39999', '中等偏上的消费能力', 5, 22, '2019-07-04 15:21:15', '2019-07-04 15:21:15', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (135, '中', '属性', '20000-29999', '消费能力中等', 5, 22, '2019-07-04 15:21:57', '2019-07-04 15:21:57', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (136, '中下', '属性', '10000-19999', '消费能力中等偏下哦', 5, 22, '2019-07-04 15:22:43', '2019-07-04 15:22:43', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (137, '低', '属性', '1000-9999', '消费能力较低', 5, 22, '2019-07-04 15:24:17', '2019-07-04 15:24:17', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (138, '很低', '属性', '1-999', '消费能力很低哦', 5, 22, '2019-07-04 15:24:57', '2019-07-04 15:24:57', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (139, '1-999', '属性', '1-999', '客单价在1-999区间', 5, 23, '2019-07-04 15:26:39', '2019-07-04 15:26:39', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (140, '1000-2999', '属性', '1000-2999', '客单价在1000-2999区间', 5, 23, '2019-07-04 15:27:01', '2019-07-04 15:27:01', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (141, '3000-4999', '属性', '3000-4999', '客单价在3000-4999区间', 5, 23, '2019-07-04 15:27:36', '2019-07-04 15:27:36', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (142, '5000-9999', '属性', '5000-9999', '客单价在5000-9999区间', 5, 23, '2019-07-04 15:28:02', '2019-07-04 15:28:02', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (143, '支付宝', '属性', '支付宝', '喜欢用支付宝付款', 5, 24, '2019-07-04 15:28:36', '2019-07-04 15:28:36', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (144, '微信', '属性', '微信', '喜欢用微信支付', 5, 24, '2019-07-04 15:28:55', '2019-07-04 15:28:55', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (145, '储蓄卡', '属性', '储蓄卡', '经常用储蓄卡付款', 5, 24, '2019-07-04 15:29:21', '2019-07-04 15:29:21', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (146, '信用卡', '属性', '信用卡', '喜欢用信用卡支付', 5, 24, '2019-07-04 15:29:45', '2019-07-04 15:29:45', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (147, '1-999', '属性', '1-999', '单笔最高金额范围是1-999', 5, 25, '2019-07-04 16:43:57', '2019-07-04 16:43:57', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (148, '1000-2999', '属性', '1000-2999', '单笔最高支付金额的范围是1000-2999', 5, 25, '2019-07-04 16:44:29', '2019-07-04 16:44:29', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (149, '3000-4999', '属性', '3000-4999', '单笔最高的支付金额是3000-4999', 5, 25, '2019-07-04 16:44:55', '2019-07-04 16:44:55', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (150, '5000-9999', '属性', '5000-9999', '单笔最高支付金额为5000-9999', 5, 25, '2019-07-04 16:45:18', '2019-07-04 16:45:18', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (151, '高', '属性', '7day', '购买频率很高', 5, 26, '2019-07-04 16:46:52', '2019-07-04 16:46:52', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (152, '中', '属性', '中', '购买频率中等', 5, 26, '2019-07-04 17:03:37', '2019-07-04 17:03:37', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (153, '低', '属性', '低', '购买频率较低', 5, 26, '2019-07-04 17:04:02', '2019-07-04 17:04:02', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (154, '高', '属性', '高', '高退货率', 5, 27, '2019-07-04 17:04:23', '2019-07-04 17:04:23', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (155, '中', '属性', '中', '退货率中等', 5, 27, '2019-07-04 17:04:42', '2019-07-04 17:04:42', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (156, '低', '属性', '低', '退货率很低哦', 5, 27, '2019-07-04 17:05:13', '2019-07-04 17:05:13', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (157, '高', '属性', '高', '换货率很高', 5, 28, '2019-07-04 17:05:37', '2019-07-04 17:05:37', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (158, '中', '属性', '中', '换货率中等', 5, 28, '2019-07-04 17:05:52', '2019-07-04 17:05:52', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (159, '低', '属性', '低', '换货率较低', 5, 28, '2019-07-04 17:06:09', '2019-07-04 17:06:09', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (160, '3折-4折', '属性', '0.3-0.4', '3折~4折时必买', 5, 29, '2019-07-04 17:07:59', '2019-07-04 17:07:59', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (161, '5折-7折', '属性', '0.5-0.7', '5折~7折时必买', 5, 29, '2019-07-04 17:08:29', '2019-07-04 17:08:29', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (162, '8折-9折', '属性', '0.8-0.9', '8折-9折时必买', 5, 29, '2019-07-04 17:08:56', '2019-07-04 17:08:56', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (163, '折扣券', '属性', '折扣券', '有折扣券时必买', 5, 30, '2019-07-04 17:09:29', '2019-07-04 17:09:29', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (164, '活动券', '属性', '活动券', '有活动券时必买', 5, 30, '2019-07-04 17:09:49', '2019-07-04 17:09:49', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (165, '积分换购', '属性', '积分换购', '喜欢用积分换购商品', 5, 30, '2019-07-04 17:10:17', '2019-07-04 17:10:17', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (166, '高', '属性', '高', '经常下单前先咨询客服', 5, 31, '2019-07-04 17:10:52', '2019-07-04 17:10:52', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (167, '中', '属性', '中', '偶尔下单前会咨询客服', 5, 31, '2019-07-04 17:11:19', '2019-07-04 17:11:19', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (168, '低', '属性', '低', '很少下单前去咨询客服', 5, 31, '2019-07-04 17:11:47', '2019-07-04 17:11:47', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (169, '1天内', '属性', '1day', '最近1天内登录过', 5, 33, '2019-07-04 17:13:00', '2019-07-04 17:13:00', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (170, '7天内', '属性', '7day', '最近7天内登录过', 5, 33, '2019-07-04 17:13:19', '2019-07-04 17:13:19', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (171, '14天内', '属性', '14day', '最近14天内登录过', 5, 33, '2019-07-04 17:13:42', '2019-07-04 17:13:42', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (172, '30天内', '属性', '30day', '最近30天内登录过', 5, 33, '2019-07-04 17:13:58', '2019-07-04 17:13:58', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (173, '登录页', '属性', '登录页', '最近打开过登录页', 5, 34, '2019-07-04 17:14:45', '2019-07-04 17:14:45', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (174, '首页', '属性', '首页', '打开过首页', 5, 34, '2019-07-04 17:15:44', '2019-07-04 17:15:44', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (175, '分类页', '属性', '分类页', '最近打开过分类页', 5, 34, '2019-07-04 17:16:03', '2019-07-04 17:16:03', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (176, '商品页', '属性', '商品页', '最近打开过商品页', 5, 34, '2019-07-04 17:16:28', '2019-07-04 17:16:28', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (177, '我的订单页', '属性', '我的订单页', '最近打开过我的订单页', 5, 34, '2019-07-04 17:17:06', '2019-07-04 17:17:06', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (178, '订单物流页', '属性', '订单物流页', '最近查询过订单物流', 5, 34, '2019-07-04 17:17:32', '2019-07-04 17:17:32', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (179, '1分钟内', '属性', '<60second', '浏览页面时长平均在1分钟内', 5, 35, '2019-07-04 17:19:03', '2019-07-04 17:19:03', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (180, '1-5分钟内', '属性', '60second-299second', '浏览页面时长平均在1-5分钟内', 5, 35, '2019-07-04 17:20:01', '2019-07-04 17:20:01', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (181, '5分钟以上', '属性', '>300second', '浏览页面时长平均在5分钟以上', 5, 35, '2019-07-04 17:23:09', '2019-07-04 17:23:09', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (182, '经常', '属性', '经常', '经常访问商城', 5, 37, '2019-07-04 17:26:44', '2019-07-04 17:26:44', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (183, '偶尔', '属性', '偶尔', '偶尔访问商城', 5, 37, '2019-07-04 17:28:38', '2019-07-04 17:28:38', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (184, '很少', '属性', '很少', '很少访问商城', 5, 37, '2019-07-04 17:28:59', '2019-07-04 17:28:59', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (185, '从不', '属性', '从不', '注册后从不访问商城', 5, 37, '2019-07-04 17:29:40', '2019-07-04 17:29:40', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (186, 'Windows', '属性', 'Windows', '使用Windows设备访问', 5, 38, '2019-07-04 17:35:57', '2019-07-04 17:35:57', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (187, 'Mac', '属性', 'Mac', '使用Mac设备访问', 5, 38, '2019-07-04 17:36:15', '2019-07-04 17:36:15', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (188, 'Linux', '属性', 'Linux', '使用Linux设备访问', 5, 38, '2019-07-04 17:36:43', '2019-07-04 17:36:43', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (189, 'Android', '属性', 'Android', '使用Android设备访问', 5, 38, '2019-07-04 17:37:03', '2019-07-04 17:37:03', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (190, 'IOS', '属性', 'IOS', '使用IOS设备访问', 5, 38, '2019-07-04 17:37:17', '2019-07-04 17:37:17', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (191, '1点-7点', '属性', '1-7', '经常在1点-7点时访问', 5, 39, '2019-07-04 17:46:12', '2019-07-04 17:46:12', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (192, '8点-12点', '属性', '8-12', '经常在8点-12点时访问', 5, 39, '2019-07-04 17:46:40', '2019-07-04 17:46:40', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (193, '13点-17点', '属性', '13-17', '经常在13点-17点时访问', 5, 39, '2019-07-04 17:47:15', '2019-07-04 17:47:15', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (194, '18点-21点', '属性', '18-21', '经常在18点-21点时访问', 5, 39, '2019-07-04 17:47:48', '2019-07-04 17:47:48', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (195, '22点-24点', '属性', '22-24', '经常在22点-24点时访问', 5, 39, '2019-07-04 17:48:27', '2019-07-04 17:48:27', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (196, '无', '属性', '无', '近7日没登录', 5, 40, '2019-07-04 17:50:07', '2019-07-04 17:50:07', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (197, '较少', '属性', '较少', '近7日较少登录', 5, 40, '2019-07-04 17:51:30', '2019-07-04 17:51:30', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (198, '一般', '属性', '一般', '近7日登陆过', 5, 40, '2019-07-04 17:52:12', '2019-07-04 17:52:12', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (199, '经常', '属性', '经常', '近7日经常登录', 5, 40, '2019-07-04 17:52:29', '2019-07-04 17:52:29', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (200, '彩电', '属性', '彩电', '彩电', 5, 44, '2019-07-04 18:01:29', '2019-07-04 18:01:29', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (201, '厨房电器', '属性', '厨房电器', '厨房电器', 5, 44, '2019-07-04 18:01:49', '2019-07-04 18:01:49', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (202, '热水器', '属性', '热水器', '热水器', 5, 44, '2019-07-04 18:02:08', '2019-07-04 18:02:08', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (203, '冰箱', '属性', '冰箱', '冰箱', 5, 44, '2019-07-04 18:02:22', '2019-07-04 18:02:22', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (204, '洗衣机', '属性', '洗衣机', '洗衣机', 5, 44, '2019-07-04 18:02:34', '2019-07-04 18:02:34', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (205, '生活小电', '属性', '生活小电', '生活小电', 5, 44, '2019-07-04 18:02:47', '2019-07-04 18:02:47', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (206, '水家电', '属性', '水家电', '水家电', 5, 44, '2019-07-04 18:02:59', '2019-07-04 18:02:59', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (207, '空调', '属性', '空调', '空调', 5, 44, '2019-07-04 18:03:15', '2019-07-04 18:03:15', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (208, '冷柜', '属性', '冷柜', '冷柜', 5, 44, '2019-07-04 18:03:24', '2019-07-04 18:03:24', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (209, '海尔', '属性', '海尔', '喜欢海尔', 5, 45, '2019-07-04 18:05:09', '2019-07-04 18:05:09', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (210, '卡萨帝', '属性', '卡萨帝', '喜欢卡萨帝', 5, 45, '2019-07-04 18:05:54', '2019-07-04 18:05:54', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (211, '摩卡', '属性', '摩卡', '喜欢摩卡', 5, 45, '2019-07-04 18:06:10', '2019-07-04 18:06:10', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (212, '小超人', '属性', '小超人', '喜欢小超人', 5, 45, '2019-07-04 18:06:27', '2019-07-04 18:06:27', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (213, '统帅', '属性', '统帅', '喜欢统帅', 5, 45, '2019-07-04 18:06:38', '2019-07-04 18:06:38', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (214, '有房无贷', '属性', '有房无贷', '有房无贷', 5, 46, '2019-07-04 18:09:59', '2019-07-04 18:09:59', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (215, '公积金贷款', '属性', '公积金贷款', '公积金贷款买的房', 5, 46, '2019-07-04 18:10:27', '2019-07-04 18:10:27', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (216, '商业贷款', '属性', '商业贷款', '使用商业贷款买的房', 5, 46, '2019-07-04 18:10:44', '2019-07-04 18:10:44', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (217, '无房', '属性', '无房', '还没有买房', 5, 46, '2019-07-04 18:11:04', '2019-07-04 18:11:04', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (218, '50w以内', '属性', '0-499999', '房产价值在50w以内', 5, 47, '2019-07-04 18:12:03', '2019-07-04 18:12:03', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (219, '50-100w以内', '属性', '500000-999999', '房产价值在50-100w以内', 5, 47, '2019-07-04 18:12:39', '2019-07-04 18:12:39', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (220, '100-200w以内', '属性', '1000000-1999999', '房产价值在100-200w以内', 5, 47, '2019-07-04 18:13:06', '2019-07-04 18:13:06', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (221, '200-500w以内', '属性', '2000000-4999999', '房产价值在200-500w以内', 5, 47, '2019-07-04 18:13:32', '2019-07-04 18:13:32', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (222, '500w及以上', '属性', '>5000000', '房产价值在500w及以上', 5, 47, '2019-07-04 18:14:10', '2019-07-04 18:14:10', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (223, '有车无贷', '属性', '有车无贷', '有车', 5, 48, '2019-07-04 18:14:39', '2019-07-04 18:14:39', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (224, '有车有贷', '属性', '有车有贷', '贷款买的车', 5, 48, '2019-07-04 18:14:50', '2019-07-04 18:14:50', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (225, '无车', '属性', '无车', '还没有买车', 5, 48, '2019-07-04 18:15:08', '2019-07-04 18:15:08', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (226, '10w以内', '属性', '1-99999', '价值10w以内', 5, 49, '2019-07-04 18:18:32', '2019-07-04 18:18:32', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (227, '10-20w以内', '属性', '100000-199999', '价值10-20w以内', 5, 49, '2019-07-04 18:19:06', '2019-07-04 18:19:06', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (228, '20-30w以内', '属性', '200000-299999', '价值20-30w以内', 5, 49, '2019-07-04 18:19:32', '2019-07-04 18:19:32', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (229, '30-50w以内', '属性', '300000-499999', '价值30-50w以内', 5, 49, '2019-07-04 18:20:11', '2019-07-04 18:20:11', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (230, '50-70w以内', '属性', '500000-699999', '价值50-70w以内', 5, 49, '2019-07-04 18:20:54', '2019-07-04 18:20:54', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (231, '70-100w以内', '属性', '700000-999999', '价值70-100w以内', 5, 49, '2019-07-04 18:21:29', '2019-07-04 18:21:29', 3, NULL);
INSERT INTO `tbl_basic_tag` VALUES (232, '100w及以上', '属性', '>1000000', '价值100w及以上', 5, 49, '2019-07-04 18:21:53', '2019-07-04 18:21:53', 3, NULL);

-- ----------------------------
-- Table structure for tbl_merge_tag
-- ----------------------------
DROP TABLE IF EXISTS `tbl_merge_tag`;
CREATE TABLE `tbl_merge_tag`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组合标签名称',
  `condition` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组合标签条件',
  `intro` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组合标签含义',
  `purpose` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组合用途',
  `state` int(0) NULL DEFAULT NULL COMMENT '状态：1申请中、2开发中、3开发完成、4已上线、5已下线、6已禁用',
  `ctime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `utime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组合标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_merge_tag
-- ----------------------------
INSERT INTO `tbl_merge_tag` VALUES (1, '高净值用户', '学历(硕士博士)且消费能力(超高高)且房产(有房无贷)', '商城用户高学历、高消费、有房', '评估商城中的高价值用户', 4, '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag` VALUES (2, '上海女孩', '籍贯(上海)且消费能力(中上)且性别(女)', '商城用户中籍贯是上海、消费能力中上、有房的女孩', '查看商城中有多少上海的女性用户', 4, '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag` VALUES (3, '屌丝男', '性别(男)且消费能力(低)且消费周期(近60天)且房产(无房)且省钱小能手(3折-4折)', '商城中消费能力低、消费周期长、无房的用户', '查看商城中符合屌丝特质的用户', 4, '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag` VALUES (4, '80后', '年龄段(80后)', '查看商城中的80后用户', '查看商城中的80后用户', 4, '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);

-- ----------------------------
-- Table structure for tbl_merge_tag_tag_map
-- ----------------------------
DROP TABLE IF EXISTS `tbl_merge_tag_tag_map`;
CREATE TABLE `tbl_merge_tag_tag_map`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `merge_tag_id` bigint(0) NULL DEFAULT NULL COMMENT '组合标签ID',
  `basic_tag_id` bigint(0) NULL DEFAULT NULL COMMENT '基础标签ID（1级行业 or 5级属性）',
  `conditions` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ctime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `utime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组合标签与基础标签关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_merge_tag_tag_map
-- ----------------------------
INSERT INTO `tbl_merge_tag_tag_map` VALUES (1, 1, 97, 'or', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (2, 1, 98, 'and', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (3, 1, 132, 'or', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (4, 1, 133, 'and', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (5, 1, 214, 'and', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (6, 2, 75, 'and', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (7, 2, 134, 'and', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (8, 2, 51, 'and', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (9, 3, 50, 'and', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (10, 3, 137, 'and', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (11, 3, 130, 'and', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (12, 3, 217, 'and', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (13, 3, 160, 'and', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);
INSERT INTO `tbl_merge_tag_tag_map` VALUES (14, 4, 55, 'and', '2019-07-04 00:00:00', '2022-07-04 00:00:00', NULL);

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `role` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES (3, 'admin', 'admin', '13913913913', '123@qq.com', 1);
INSERT INTO `tbl_user` VALUES (5, 'user', '111', '15915915915', '456@qq.com', 2);

SET FOREIGN_KEY_CHECKS = 1;
