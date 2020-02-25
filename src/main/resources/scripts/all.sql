-- 权益表
CREATE TABLE `abs_equity` (
  `equity_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `equity_code` varchar(32) NOT NULL COMMENT '权益编码',
  `equity_name`  varchar(256) NOT NULL COMMENT '权益名称',
  `equity_desc`  varchar(1024) NOT NULL COMMENT '权益描述',
  `equity_type`  varchar(2) NOT NULL COMMENT '权益类型:国金ABS云平台服务，社群服务，咨询诊断服务，增值服务',
  `equity_prop`  varchar(2) NOT NULL COMMENT '权益属性:功能权限、消费类，咨询类',
  `counter`  tinyint NOT NULL COMMENT '默认次数',
  `perm_code`  varchar(32) NOT NULL COMMENT '权限控制标识',
  `spend_code`  varchar(32) NOT NULL COMMENT '消费标识',
  `state` char(1) DEFAULT 0 COMMENT '状态；0-正常 1-禁用',
  `create_user` time DEFAULT NULL COMMENT '创建人',
  `create_time` time DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`equity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7845 DEFAULT CHARSET=utf8 COMMENT='权益表';

-- 套餐(会员等级-权益)表
CREATE TABLE `abs_level_equity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `level_id` varchar(32) NOT NULL COMMENT '会员等级id',
  `equity_id`  int(11) NOT NULL COMMENT '权益id',
  `usage_counter`  tinyint NOT NULL COMMENT '消费次数',
  `order`  int(4) NOT NULL COMMENT '序号',
  `create_time` time DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4856 DEFAULT CHARSET=utf8 COMMENT='套餐(会员等级-权益)表';


-- 会员权益表
CREATE TABLE `abs_member_equity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` varchar(32) NOT NULL COMMENT '会员id',
  `equity_code` varchar(32) NOT NULL COMMENT '权益编码',
  `equity_name`  varchar(32) NOT NULL COMMENT '权益名称',
  `equity_desc`  varchar(512) NOT NULL COMMENT '权益描述',
  `equity_type`  varchar(2) NOT NULL COMMENT '权益类型:国金ABS云平台服务，社群服务，咨询诊断服务，增值服务',
  `equity_prop`  varchar(2) NOT NULL COMMENT '权益属性:功能权限、消费类，咨询类',
  `usage_counter`  tinyint NOT NULL COMMENT '使用次数',
  `balance_counter`  tinyint NOT NULL COMMENT '剩余使用次数',
  `perm_code`  varchar(32) NOT NULL COMMENT '权限控制标识',
  `spend_code`  varchar(32) NOT NULL COMMENT '消费标识',
  `order`  int(4) NOT NULL COMMENT '序号',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` time DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8472 DEFAULT CHARSET=utf8 COMMENT='会员权益表';


-- 权益活动表
CREATE TABLE `abs_event` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `event_name` varchar(128) NOT NULL COMMENT '活动主题',
  `event_date` varchar(32) NOT NULL COMMENT '活动时间',
  `event_address`  varchar(256) NOT NULL COMMENT '活动地点',
  `event_desc`  text NOT NULL COMMENT '活动介绍',
	`event_url`  varchar(256) NOT NULL COMMENT '活动链接',
  `num_limit`  int(4) NOT NULL COMMENT '人数限制',
  `num_used`  int(4) NOT NULL COMMENT '已预约人数',
  `reserve_end_date`  varchar(16) NOT NULL COMMENT '预约截止日',
  `cancel_end_date`  varchar(16) NOT NULL COMMENT '取消截止日',
  `need_equity`  char(1) DEFAULT 0 COMMENT '是否限定权益：0否，1是',
  `spend_code`  varchar(32) NOT NULL COMMENT '消费标识',
  `status` char(1) DEFAULT 0 COMMENT '状态；1已发布，0未发布，2已取消，4已完成',
  `create_user` time DEFAULT NULL COMMENT '创建人',
  `create_time` time DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1875 DEFAULT CHARSET=utf8 COMMENT='权益活动表';


-- 权益消费记录表
CREATE TABLE `abs_equity_spend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` varchar(32) NOT NULL COMMENT '会员id',
  `event_id` varchar(32) NOT NULL COMMENT '活动id',
  `equity_id`  varchar(32) NOT NULL COMMENT '权益id',
  `equity_name` varchar(128) NOT NULL COMMENT '权益名称',
  `status`  char(1) NOT NULL COMMENT '状态：已完成0，已取消1',
  `create_time` time DEFAULT NULL COMMENT '创建时间',
  `update_time` time DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2654 DEFAULT CHARSET=utf8 COMMENT='权益消费记录表';



-- 活动签到记录表
CREATE TABLE `abs_event_signin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` varchar(32) NOT NULL COMMENT '会员id',
  `event_id` varchar(32) NOT NULL COMMENT '活动id',
  `signin_time` time DEFAULT NULL COMMENT '签到时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1543 DEFAULT CHARSET=utf8 COMMENT='活动签到记录表';



