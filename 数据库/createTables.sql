-- SCRUM.`USER`
CREATE TABLE `USER` (
  `USER_ID` varchar(20) NOT NULL COMMENT '用户编号',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户名',
  `GROUP_ID` varchar(20) DEFAULT NULL COMMENT '小组编号',
  `USER_PASSWORD` varchar(20) DEFAULT NULL COMMENT '密码',
  `USER_PHONE` varchar(20) CHARACTER SET
utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号码',
  `USER_EMAIL` varchar(30) CHARACTER SET
utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户邮箱',
  `USER_ROLE` char(1) DEFAULT NULL COMMENT '用户角色（0-admin、1-general）',
  `LAST_LOGIN_TIME` timestamp NULL DEFAULT NULL COMMENT '最后登录时间',
  `EXT1` varchar(60) DEFAULT NULL COMMENT '备用字段',
  `EXT2` varchar(60) DEFAULT NULL COMMENT '备用字段',
  `EXT3` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `CREATION_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`USER_ID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表';

-- SCRUM.`GROUP`
CREATE TABLE `GROUP` (
  `GROUP_ID` varchar(20) NOT NULL COMMENT '小组编号',
  `GROUP_NAME` varchar(20) DEFAULT NULL COMMENT '小组名称',
  `EXT1` varchar(60) DEFAULT NULL COMMENT '备用字段',
  `EXT2` varchar(60) DEFAULT NULL COMMENT '备用字段',
  `EXT3` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `CREATION_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`GROUP_ID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '小组表';

-- SCRUM.`LOTTERY_LOG`
CREATE TABLE `LOTTERY_LOG` (
  `ID` varchar(20) NOT NULL COMMENT '无意义主键',
  `LOTTERY_STYLE` char(1) DEFAULT NULL COMMENT '抽奖方式(0-turntable)',
  `LOTTERY_USER_ID` varchar(20) DEFAULT NULL COMMENT '抽奖人编号',
  `WINNER_USER_ID` varchar(20) DEFAULT NULL COMMENT '中奖人编号',
  `EXT1` varchar(60) DEFAULT NULL COMMENT '备用字段',
  `EXT2` varchar(60) DEFAULT NULL COMMENT '备用字段',
  `EXT3` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `CREATION_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '抽奖日志';

-- SCRUM.`STAND_UP_ITEM_RECORD`
CREATE TABLE `STAND_UP_ITEM_RECORD` (
  `ID` varchar(20) NOT NULL COMMENT '无意义主键',
  `PROPOSER_USER_ID` varchar(20) DEFAULT NULL COMMENT '提出人编号',
  `PRINCIPAL_USER_ID` varchar(20) DEFAULT NULL COMMENT '负责人编号',
  `ITEM_STYLE` char(1) DEFAULT NULL COMMENT '项目类型(0-风险项、1-待改进项、2-跟进项)',
  `ITEM_DESCRIPTION` varchar(255) DEFAULT NULL COMMENT '项目说明',
  `MEASURE` varchar(255) DEFAULT NULL COMMENT '措施',
  `STATE` char(1) DEFAULT NULL COMMENT '状态(0-待处理、1-活动中、2-已关闭)',
  `PRIORITY` char(1) DEFAULT NULL COMMENT '优先级(0-低、1-中、2-高)',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `EXT1` varchar(60) DEFAULT NULL COMMENT '备用字段',
  `EXT2` varchar(60) DEFAULT NULL COMMENT '备用字段',
  `EXT3` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `CREATION_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '站会项目记录表';

-- 初始化数据
INSERT INTO SCRUM.`USER`
(USER_ID, USER_NAME, GROUP_ID, USER_PASSWORD, USER_PHONE, USER_EMAIL, USER_ROLE, LAST_LOGIN_TIME, EXT1, EXT2, EXT3, CREATION_TIME, UPDATE_TIME)
VALUES('20211220000000000', 'admin', NULL, 'admin', NULL, 'songyunxiang1997@163.com', '0', '2021-12-20 00:00:00', NULL, NULL, NULL, '2021-12-20 00:00:00', NULL);
INSERT INTO SCRUM.`USER`
(USER_ID, USER_NAME, GROUP_ID, USER_PASSWORD, USER_PHONE, USER_EMAIL, USER_ROLE, LAST_LOGIN_TIME, EXT1, EXT2, EXT3, CREATION_TIME, UPDATE_TIME)
VALUES('20211220000000001', 'songyx', NULL, '19970825', NULL, '1048461309@qq.com', '1', '2021-12-20 00:00:00', NULL, NULL, NULL, '2021-12-20 00:00:00', NULL);
