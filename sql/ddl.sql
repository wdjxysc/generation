drop table if exists automation_test_module;
/*==============================================================*/
/* Table: automation_test_module                                           */
/*==============================================================*/
create table automation_test_module
(
	 module_name varchar(50) not null comment '模块名称',
	 module_code varchar(50) not null comment '模块编号'
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='测试接口模块表';

drop table if exists automation_test_api;
/*==============================================================*/
/* Table: automation_test_api                                           */
/*==============================================================*/
create table automation_test_api
(
	 module_code varchar(50) not null comment '模块编号',
	 api_code varchar(50) not null comment '接口编号',
	 api_name varchar(50) not null comment '接口名称',
	 api_url varchar(500) not null comment '接口请求路径',
	 api_method varchar(50) not null comment '接口请求方式',
	 api_header varchar(500) not null comment '请求头',
	 api_application varchar(50) not null comment '请求参数类型：form, json, xml, text',
	 api_status varchar(2) not null comment '接口状态：1启用，2禁用',
	 api_succeed_code varchar(32) not null comment '接口请求成功返回编码',
	 api_discern_result_attr varchar(32) not null comment '判断接口结果的属性名'
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='测试接口表';

drop table if exists automation_test_api_params;
/*==============================================================*/
/* Table: automation_test_api_params                                           */
/*==============================================================*/
create table automation_test_api_params
(
	 api_code varchar(50) not null comment '接口编号',
	 api_param_key varchar(50) not null comment '参数key',
	 api_param_value varchar(50) not null comment '参数value',
	 api_param_type varchar(50) not null comment '参数类型',
	 api_param_prefix varchar(50) comment '参数前缀',
	 api_param_random_value int(1) not null default 0 comment '是否随机生成参数',
	 api_param_required int(1) not null default 0 comment '参数是否必填，默认否',
	 api_param_max_length int(2) not null default 99 comment '参数最大长度'
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='测试接口参数表';

drop table if exists automation_test_api_runlog;
/*==============================================================*/
/* Table: automation_test_api_runlog                                           */
/*==============================================================*/
create table automation_test_api_runlog
(
	 api_code varchar(50) not null comment '接口编号',
	 api_run_status varchar(50) not null comment '接口返回结果',
	 api_run_status_code varchar(50) not null comment '接口返回结果编码',
	 api_run_result_content text not null comment '返回结果内容',
	 api_run_date datetime not null comment '日志写入时间'
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='测试接口运行日志表';


-- 聊天室，简陋的聊天室的ip映射数据
drop table if exists chat_room_ip_us;
create table chat_room_ip_us(
	ip varchar(50) not null comment '主机IP',
	name varchar(50) not null comment '昵称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='聊天室，简陋的聊天室的ip映射数据';