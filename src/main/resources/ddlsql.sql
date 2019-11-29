CREATE TABLE `df`.`t_account_info`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(20) NULL COMMENT '账号',
  `password` varchar(50) NULL COMMENT '密码',
  `user_name` varchar(50) NULL COMMENT '用户昵称',
  `create_time` datetime NULL COMMENT '创建时间',
  `lastlogin_time` datetime NULL COMMENT '最后一次登录时间',
  `status` int(2) NULL COMMENT '账户状态',
  PRIMARY KEY (`id`)
);