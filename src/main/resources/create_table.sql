#微信token信息
create table user_token(
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`access_token` VARCHAR(64) not null,
	`expires_in` bigint(20) not null,
	`refresh_token` VARCHAR(64) not null,
	`openid` VARCHAR(64) not null,
	`scope` VARCHAR(64) not null,
	`create_time` timestamp  not null DEFAULT CURRENT_TIMESTAMP,
	`update_time` timestamp ,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
#微信用户信息
create table wx_user_info(
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`openid` VARCHAR(64) not null,
	`nickname` VARCHAR(32) not null,
	`sex` tinyint(2) DEFAULT 0,
	`province` VARCHAR(64) not null,
	`city` VARCHAR(64) not null,
	`country` VARCHAR(64) not null,
	`headimgurl` VARCHAR(255) not null,
	`privilege` VARCHAR(64) not null,
	`unionid` VARCHAR(64) ,
	`create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP,
	`update_time` timestamp ,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
#广告
CREATE TABLE `ad` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `ad_url` varchar(255) DEFAULT NULL,
  `validity` tinyint(3) NOT NULL,
  `type` tinyint(3) NOT NULL,
  `priority` bigint(20) NOT NULL,
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
#app版本
CREATE TABLE `app_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `app_desc` varchar(255) DEFAULT NULL,
  `app_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `is_must_update` varchar(255) DEFAULT NULL,
  `kefu_char` varchar(255) DEFAULT NULL,
  `kefu_phone` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_url` varchar(255) DEFAULT NULL,
  `version_num` varchar(255) DEFAULT NULL,
  `version_ser_num` varchar(255) DEFAULT NULL,
  `vsersion_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
#vip信息
CREATE TABLE `openvip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) DEFAULT NULL,
  `svip` tinyint(3) DEFAULT 0,
  `shenmi` tinyint(3) DEFAULT 0,
  `niuniu` tinyint(3) DEFAULT 0,
  `bikaizuixiaobao` tinyint(3) DEFAULT 0,
  `jiasuqiang` tinyint(3) DEFAULT 0,
  `vip` tinyint(3) DEFAULT 0,
  `guanbiguagngao` tinyint(3) DEFAULT 0,
  `qiangdabao` tinyint(3) DEFAULT 0,
  `shouqizuijia` tinyint(3) DEFAULT 0,
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp,
  `expire_time` timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
#账单
CREATE TABLE `statement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` varchar(255) DEFAULT NULL COMMENT '备注',
  `amount` bigint(20) NOT NULL COMMENT '金额',
  `product_type` tinyint(3) NOT NULL DEFAULT '1' COMMENT '产品类型',
  `type` tinyint(3) NOT NULL COMMENT '类型:0-支出,1-收入',
  `openid` varchar(64) NOT NULL COMMENT '用户唯一标示',
  `nike_name` varchar(32) NOT NULL COMMENT '用户名昵称',
  `red_name` varchar(32) NOT NULL COMMENT '发红包者昵称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;