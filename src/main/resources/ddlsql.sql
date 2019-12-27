CREATE TABLE `t_account_info`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(20) NULL COMMENT '账号',
  `phone` varchar(20) NULL COMMENT '手机号',
  `email` varchar(100) NULL COMMENT '邮箱',
  `password` varchar(50) NULL COMMENT '密码',
  `user_name` varchar(50) NULL COMMENT '用户昵称',
  `create_time` datetime NULL COMMENT '创建时间',
  `lastlogin_time` datetime NULL COMMENT '最后一次登录时间',
  `status` int(2) NULL COMMENT '账户状态',
  PRIMARY KEY (`id`)
);
##账号表

CREATE TABLE `t_user_info`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id` int(20) NULL COMMENT '账号id',
  `real_name` varchar(50) NULL COMMENT '真实姓名',
  `phone` varchar(20) NULL COMMENT '手机号',
  `birthday` datetime NULL COMMENT '出生日期',
  `life_limit` int(10) NULL COMMENT '--',
  `type` int(2) NULL COMMENT '类别',
  `death_type` int(2) NULL COMMENT '--',
  PRIMARY KEY (`id`)
);
##用户表

CREATE TABLE `t_menu_info`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '菜单主键',
  `parent_id` int(20) NULL COMMENT '上级菜单id',
  `type` int(1) NULL COMMENT '菜单类别',
  `url` varchar(100) NULL COMMENT '菜单链接',
  `create_time` datetime NULL COMMENT '创建时间',
  `update_time` datetime NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
);
#菜单表

create table t_works_typeinfo(
    `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '作品主键',
    `works_`
    PRIMARY KEY (`id`)
);
#作品类型表

create table t_works_info(
                             `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '菜单主键',
                             PRIMARY KEY (`id`)
)
#作品类型表