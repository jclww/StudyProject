-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 10.9.34.172    Database: dzt_crm
-- ------------------------------------------------------
-- Server version	5.7.16-10-log


--
-- Table structure for table `business_gmv`
--

set mode MySQL;

DROP TABLE IF EXISTS `business_gmv`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `business_gmv` (
  `id`          INT(11) UNSIGNED    NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `business_id` INT(11) UNSIGNED    NOT NULL
  COMMENT '类目ID',
  `gmv`         INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '30天gmv',
  `is_valid`    TINYINT(3) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '是否有效',
  `created_at`  DATETIME            NOT NULL
  COMMENT '创建时间',
  `modified_at` DATETIME            NOT NULL
  COMMENT '修改时间',
  `deleted_at`  DATETIME            NOT NULL
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
);


--
-- Table structure for table `chance`
--

DROP TABLE IF EXISTS `chance`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chance` (
  `id`             INT(10) UNSIGNED      NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `name`           VARCHAR(128)          NOT NULL
  COMMENT '机会名称',
  `sales_level`    TINYINT(3) UNSIGNED   NOT NULL DEFAULT '0'
  COMMENT ' 销售阶段  0:0暂未定成熟度 1:1已付款 2:2即将付款 3:3有意向 4:3-意愿再次跟进 5:4KP未定 6:5关闭 7.6未跟进 8.已退款',
  `product_id`     INT(11)               NOT NULL DEFAULT '0'
  COMMENT '产品ID',
  `product_type`   VARCHAR(128)          NOT NULL DEFAULT ''
  COMMENT '产品类型',
  `kdt_id`         INT(10) UNSIGNED      NOT NULL DEFAULT '0'
  COMMENT '关联商户ID',
  `team_name`      VARCHAR(128)          NOT NULL DEFAULT ''
  COMMENT '店铺名称',
  `sso_id`         INT(10) UNSIGNED      NOT NULL DEFAULT '0'
  COMMENT '机会创建人(渠道时为渠道id)',
  `sso_name`       VARCHAR(56)           NOT NULL DEFAULT ''
  COMMENT '机会创建人名字',
  `role_attach_id` BIGINT(20) UNSIGNED   NOT NULL DEFAULT '0'
  COMMENT '角色附加ID 渠道用于子账号',
  `belong_id`      INT(10) UNSIGNED      NOT NULL DEFAULT '0'
  COMMENT '机会所属人',
  `belong_name`    VARCHAR(64)           NOT NULL
  COMMENT '机会所属人名字',
  `group`          SMALLINT(5) UNSIGNED  NOT NULL DEFAULT '0'
  COMMENT '机会所属组',
  `department`     SMALLINT(5) UNSIGNED  NOT NULL DEFAULT '0'
  COMMENT '机会所属部门',
  `is_renew`       TINYINT(3)            NOT NULL DEFAULT '0'
  COMMENT '是否为续签机会 0:不是 1:是',
  `paid_time`      INT(10) UNSIGNED      NOT NULL DEFAULT '0'
  COMMENT '机会付款时间',
  `destroy_type`   TINYINT(5) UNSIGNED   NOT NULL DEFAULT '0'
  COMMENT '毁单类型 :1=>毁单 2=>弃单',
  `destroy_reason` TINYINT(5) UNSIGNED   NOT NULL DEFAULT '0'
  COMMENT '毁单或者弃单的原因 : 1=>客户不需要, 2=>收费不合理, 3=>是测试店铺, 4=>服务不满意, 5=>已使用其他产品, 6=>其他, 弃单类型还有一个原因7=>解绑弃单',
  `county_code`    MEDIUMINT(6) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '区',
  `addr`           VARCHAR(128)          NOT NULL DEFAULT ''
  COMMENT '地址',
  `mobile`         VARCHAR(32)           NOT NULL DEFAULT ''
  COMMENT '手机号码',
  `chance_type`    TINYINT(3) UNSIGNED   NOT NULL DEFAULT '0'
  COMMENT '机会类型1机会2线索',
  `is_matched`     TINYINT(3) UNSIGNED   NOT NULL DEFAULT '0'
  COMMENT '是否被匹配0否1是',
  `source`         TINYINT(3) UNSIGNED   NOT NULL DEFAULT '1'
  COMMENT '来源1华尔街2苏伊士',
  `chance_source`  TINYINT(3) UNSIGNED   NOT NULL DEFAULT '0'
  COMMENT '商机来源: 1:系统分配 2:人工分配 3:自主认领 4:他人介绍 5:电话咨询 6:在线咨询',
  `status`         TINYINT(3)            NOT NULL DEFAULT '0'
  COMMENT '1待跟进2跟进中3已完成4已放弃5已收回',
  `next_at`        DATETIME              NOT NULL DEFAULT '1970-01-01 00:00:00'
  COMMENT '下次跟进时间',
  `stamp`          TINYINT(3) UNSIGNED   NOT NULL DEFAULT '0'
  COMMENT '机会标识',
  `team_type`      TINYINT(3) UNSIGNED   NOT NULL DEFAULT '0'
  COMMENT '0|微商城 1|微小店 2|爱学贷 3|批发 4|批发商城 5|餐饮 6|美业 7|超级门店(零售) 8|收银 9|收银+微商城 99|通用店 铺类型对应 枚举类型team表的team_type这里的注释只做观赏只用，用这里的枚举进行开发出错了自行背锅谢谢',
  `unbind_time`    DATETIME              NOT NULL DEFAULT '1970-01-01 00:00:00'
  COMMENT '解绑时间',
  `bind_time`      DATETIME              NOT NULL DEFAULT '1970-01-01 00:00:00'
  COMMENT '绑定时间',
  `follow_time`    DATETIME              NOT NULL DEFAULT '1970-01-01 00:00:00'
  COMMENT '上次跟进时间',
  `created_at`     INT(10) UNSIGNED      NOT NULL
  COMMENT '创建时间',
  `modified_at`    INT(10) UNSIGNED      NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`     INT(10) UNSIGNED      NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
);

/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chance_file`
--

DROP TABLE IF EXISTS `chance_file`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chance_file` (
  `id`          INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `chance_id`   INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '关联机会ID',
  `file_url`    VARCHAR(128)     NOT NULL DEFAULT ''
  COMMENT '附件URL',
  `file_name`   VARCHAR(128)     NOT NULL DEFAULT ''
  COMMENT '附件名',
  `created_at`  INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at` INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`  INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  PRIMARY KEY (`id`)

);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chance_mark`
--

DROP TABLE IF EXISTS `chance_mark`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chance_mark` (
  `id`          INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `chance_id`   INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '关联机会ID',
  `mark`        VARCHAR(1024)    NOT NULL DEFAULT ''
  COMMENT '机会备注',
  `created_at`  INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at` INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`  INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
);

/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dynamics`
--

DROP TABLE IF EXISTS `dynamics`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dynamics` (
  `id`             INT(10) UNSIGNED    NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `kdt_id`         INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '商铺ID',
  `operation`      VARCHAR(32)         NOT NULL DEFAULT ''''
  COMMENT '操作',
  `content`        VARCHAR(256)        NOT NULL DEFAULT ''
  COMMENT '动态内容',
  `chance_id`      INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '机会id',
  `source`         TINYINT(5) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '动态来源 : 2=>苏伊士, 1=>华尔街',
  `business_name`  VARCHAR(256)        NOT NULL DEFAULT ''
  COMMENT '关联业务的名字',
  `business_id`    INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '关联业务ID',
  `provider_id`    INT(10)             NOT NULL DEFAULT '0'
  COMMENT '代理商id',
  `kdt_dynamics`   TINYINT(4)          NOT NULL DEFAULT '0'
  COMMENT '是否属于客户类大动态(0否1是)',
  `dynamics_type`  TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '动态大类型1客户2机会3任务4渠道',
  `kdt_type`       TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '客户动态类型下子类型1销售2服务3系统',
  `provider_type`  TINYINT(3)          NOT NULL DEFAULT '0'
  COMMENT '渠道动态类型下子类型 0无  1渠道经理手动添加 2系统消息 3管理消息 4代理商自己补充的消息',
  `sso_id`         INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '动态添加人',
  `sso_name`       VARCHAR(64)         NOT NULL DEFAULT ''
  COMMENT '动态创建人名字real_name',
  `created_at`     INT(10) UNSIGNED    NOT NULL
  COMMENT '动态创建时间',
  `modified_at`    INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`     INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  `role_attach_id` BIGINT(20) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '角色附加ID 渠道用于附加id',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dynamics_file`
--

DROP TABLE IF EXISTS `dynamics_file`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dynamics_file` (
  `id`          INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `dynamics_id` INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '关联动态ID',
  `file_url`    VARCHAR(128)     NOT NULL
  COMMENT '文件地址',
  `file_name`   VARCHAR(128)     NOT NULL DEFAULT ''
  COMMENT '文件名',
  `created_at`  INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at` INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`  INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
)
;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id`            INT(11) UNSIGNED    NOT NULL AUTO_INCREMENT,
  `sso_id`        INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '消息所属人',
  `kdt_id`        INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '店铺ID',
  `msg_type`      TINYINT(3) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '消息类型1.弱提醒消息 2.强提醒消息 ',
  `notify_type`   TINYINT(3) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '消息产生来源 1:系统通知 ',
  `content`       VARCHAR(256)        NOT NULL DEFAULT ''
  COMMENT '消息内容',
  `attach`        VARCHAR(128)        NOT NULL DEFAULT ''
  COMMENT '消息根据参数跳转的额外参数',
  `link`          VARCHAR(256)        NOT NULL DEFAULT ''
  COMMENT '消息根据url跳转时链接地址的参数',
  `operator_id`   INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '操作人ID',
  `operator_name` VARCHAR(64)         NOT NULL DEFAULT ''
  COMMENT '操作人名字',
  `task_name`     VARCHAR(128)        NOT NULL DEFAULT ''
  COMMENT '任务名字',
  `task_id`       INT(11)             NOT NULL DEFAULT '0'
  COMMENT '任务id',
  `chance_id`     INT(11)             NOT NULL DEFAULT '0'
  COMMENT '机会id',
  `chance_name`   VARCHAR(128)        NOT NULL DEFAULT ''
  COMMENT '机会名字',
  `is_read`       TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '是否阅读0否1是',
  `created_at`    INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at`   INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`    INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `message_node`
--

DROP TABLE IF EXISTS `message_node`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_node` (
  `id`            INT(10) UNSIGNED    NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `name`          VARCHAR(64)         NOT NULL DEFAULT ''
  COMMENT '消息节点名称',
  `send_object`   VARCHAR(8)          NOT NULL DEFAULT ''
  COMMENT '发送消息对象配置 逗号分开 1:绑定的SOP经理 2:绑定的KA经理 3:绑定的销售经理',
  `object_value`  VARCHAR(8)          NOT NULL DEFAULT ''
  COMMENT '发送消息对象的值',
  `msg_type`      TINYINT(3) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '消息类型1.弱提醒消息 2.强提醒消息',
  `msg_content`   VARCHAR(256)        NOT NULL DEFAULT ''
  COMMENT '消息内容',
  `content_type`  TINYINT(3)          NOT NULL DEFAULT '1'
  COMMENT '消息内容的方式 1:系统默认 2:用户自定义',
  `is_valid`      TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '消息状态 0:停止 1:使用中',
  `operator_id`   INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '最后操作人id',
  `operator_name` VARCHAR(64)         NOT NULL DEFAULT ''
  COMMENT '最后操作人姓名',
  `created_at`    INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at`   INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`    INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '删除时间\n删除时间\n删除时间\n删除时间',
  PRIMARY KEY (`id`)
);

/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sales_department`
--

DROP TABLE IF EXISTS `sales_department`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales_department` (
  `id`            INT(10) UNSIGNED    NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `department_id` INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '部门id',
  `cas_id`        INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '统一登录id',
  `realname`      VARCHAR(32)         NOT NULL DEFAULT ''
  COMMENT '真实名',
  `nickname`      VARCHAR(32)         NOT NULL DEFAULT ''
  COMMENT '昵称',
  `position_str`  VARCHAR(32)         NOT NULL DEFAULT ''
  COMMENT '职位',
  `sex`           TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '性别',
  `username`      VARCHAR(32)         NOT NULL DEFAULT ''
  COMMENT '用户名',
  `youren_id`     INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT 'oa中自增id',
  `create_at`     DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  PRIMARY KEY (`id`)
);

/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `state_change`
--

DROP TABLE IF EXISTS `state_change`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state_change` (
  `id`              INT(10) UNSIGNED    NOT NULL AUTO_INCREMENT
  COMMENT '状态变更表主键',
  `kdt_id`          INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '店铺id',
  `business_type`   TINYINT(3)          NOT NULL DEFAULT '0'
  COMMENT '业务类型 1:机会的销售阶段 2:任务的跟进状态 3:店铺的service_level状态 4:店铺的grow_level状态 5:渠道跟进店铺的状态rt.provider_op_status 6:渠道线索 chance.status 7:华尔街机会线索chance.saleslevel 8:渠道线索chance.saleslevel',
  `business_id`     INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '业务id',
  `state_before`    TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '业务相关的状态 随business_type值看具体含义',
  `state_after`     TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '业务相关的状态',
  `role_id`         INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '绑定角色id',
  `created_at_last` DATETIME            NOT NULL DEFAULT '0000-00-00 00:00:00'
  COMMENT '该状态上次更改的时间',
  `created_at`      DATETIME            NOT NULL DEFAULT '0000-00-00 00:00:00'
  COMMENT '创建时间',
  PRIMARY KEY (`id`)

);

/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `target`
--

DROP TABLE IF EXISTS `target`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `target` (
  `id`              INT(10) UNSIGNED    NOT NULL AUTO_INCREMENT,
  `date_type`       TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '0:周，1:月度，2:季度,3:年度',
  `date`            INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '年度格式为：201500、201600……，月度格式为:201601-201612,季度格式为201613-201616',
  `level`           TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '目标层级:1:团队、2:个人',
  `object_id`       INT(11)             NOT NULL DEFAULT '0'
  COMMENT '目标对象:level为1时，记录为有人里的部门id，level为2时记录为sso_id',
  `object_name`     VARCHAR(128)        NOT NULL DEFAULT ' '
  COMMENT '对象名称:A组、B组、小花、SAM等',
  `department_id`   INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '所属部门id:取有人里的部门id',
  `department_name` VARCHAR(128)        NOT NULL DEFAULT ' '
  COMMENT '所属部门名称',
  `app_id`          INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT 'app_id',
  `item_id`         INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT 'item_id',
  `value`           INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '目标值',
  PRIMARY KEY (`id`)
)
  ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id`               INT(10) UNSIGNED    NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `name`             VARCHAR(64)         NOT NULL DEFAULT '‘’'
  COMMENT '任务名称',
  `kdt_id`           INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '店铺ID',
  `sso_id`           INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '任务创建人',
  `sso_name`         VARCHAR(64)         NOT NULL
  COMMENT '创建人名字',
  `task_type`        TINYINT(3) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '任务类型 1:普通任务 2:成长任务',
  `involvement_id`   INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '任务参与人',
  `involvement_name` VARCHAR(64)         NOT NULL
  COMMENT '任务参与人名字',
  `business_type`    TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '关联业务类型(1客户2机会)',
  `business_id`      INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '关联业务ID',
  `business_name`    VARCHAR(256)        NOT NULL
  COMMENT '关联业务名字',
  `end_time`         INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '任务截止时间',
  `tab`              TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '任务标记',
  `alert_mode`       TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '提醒方式1定时2日重复3周重复4时重复',
  `alert_time`       VARCHAR(256)        NOT NULL DEFAULT ''
  COMMENT '提醒时间 json字符串',
  `task_status`      TINYINT(3) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '任务状态1进行中2已过期3已完结',
  `last_follow_time` INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '最后跟进时间',
  `created_at`       INT(10) UNSIGNED    NOT NULL
  COMMENT '创建时间',
  `modified_at`      INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`       INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task_content`
--

DROP TABLE IF EXISTS `task_content`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_content` (
  `id`          INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `content`     VARCHAR(1024)    NOT NULL DEFAULT ''
  COMMENT '任务内容',
  `task_id`     INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '关联任务的ID',
  `created_at`  INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at` INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`  INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task_file`
--

DROP TABLE IF EXISTS `task_file`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_file` (
  `id`          INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `task_id`     INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '关联任务',
  `file_url`    VARCHAR(128)     NOT NULL
  COMMENT '文件地址',
  `file_name`   VARCHAR(128)     NOT NULL DEFAULT ''
  COMMENT '附件名',
  `created_at`  INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at` INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`  INT(10) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
);

/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_contact`
--

DROP TABLE IF EXISTS `team_contact`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_contact` (
  `id`            INT(10) UNSIGNED    NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `name`          VARCHAR(64)         NOT NULL
  COMMENT '联系人姓名',
  `source`        TINYINT(5) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '联系人来源 1=>华尔街 2=>渠道后台 默认1',
  `extra_phone`   VARCHAR(256)        NOT NULL DEFAULT ''
  COMMENT '渠道拉过来联系人的额外的电话',
  `position`      VARCHAR(128)        NOT NULL DEFAULT ''
  COMMENT '联系人职位',
  `phone`         VARCHAR(64)         NOT NULL DEFAULT ''
  COMMENT '联系人电话',
  `company`       VARCHAR(128)        NOT NULL DEFAULT ''
  COMMENT '公司',
  `kdt_id`        INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '关联商户ID',
  `business_type` TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '关联业务类型1客户2线索机会',
  `business_id`   INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '关联业务ID business_type=1时是kdt_id   2时是机会id',
  `qq`            VARCHAR(32)         NOT NULL DEFAULT ''
  COMMENT '联系人qq',
  `email`         VARCHAR(64)         NOT NULL DEFAULT ''
  COMMENT '联系人邮箱',
  `wechat`        VARCHAR(32)         NOT NULL DEFAULT ''
  COMMENT '联系人微信',
  `mark`          VARCHAR(256)        NOT NULL DEFAULT ''
  COMMENT '备注',
  `sso_id`        INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '创建人ID',
  `sso_name`      VARCHAR(32)         NOT NULL DEFAULT ''
  COMMENT '创建人姓名',
  `is_chief`      TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '是否为主要联系人 0:不是 1:是',
  `created_at`    INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at`   INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`    INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_filtered_rt`
--

DROP TABLE IF EXISTS `team_filtered_rt`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_filtered_rt` (
  `id`                    INT(11) UNSIGNED    NOT NULL AUTO_INCREMENT
  COMMENT 'id',
  `kdt_id`                INT(11)             NOT NULL DEFAULT '0'
  COMMENT '店铺ID',
  `provider_id`           INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '代理商ID',
  `rule`                  INT(11)             NOT NULL DEFAULT '1'
  COMMENT '规则',
  `level`                 INT(11)             NOT NULL DEFAULT '100'
  COMMENT '等级 1渠道 其他都不是渠道',
  `business`              INT(11)             NOT NULL DEFAULT '0'
  COMMENT '类别',
  `score`                 INT(11)             NOT NULL DEFAULT '0'
  COMMENT '分值(排序用)',
  `status`                TINYINT(3)          NOT NULL DEFAULT '0'
  COMMENT '跟进状态 0-未跟进，1-已跟进',
  `paid_status`           TINYINT(3)          NOT NULL DEFAULT '0'
  COMMENT '支付状态0未支付 1已支付',
  `source`                TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '渠道获取店铺的来源 1是有赞分配的 2是自己拓展的',
  `dead_time`             BIGINT(20) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '店铺收回时间',
  `provider_op_status`    TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '代理商跟进状态 0-暂未拜访，1-需求沟通，2-机会跟进，3-暂无意向，4-售后服务',
  `provider_op_firsttime` INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '代理商第一次跟进时间',
  `provider_op_lasttime`  INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '代理商最近一次变更跟进状态时间',
  `attach`                VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '调用方自定义字符串',
  `province_code`         INT(11)             NOT NULL DEFAULT '0'
  COMMENT '省',
  `city_code`             INT(11)             NOT NULL DEFAULT '0'
  COMMENT '市',
  `county_code`           INT(11)             NOT NULL DEFAULT '0'
  COMMENT '区县',
  `service_level`         TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '服务阶段 0:暂未定 1:待建联 2:成长服务 3:被动服务 4:KA服务',
  `grow_level`            TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '成长阶段 0:无 1:新手阶段 2:基础阶段 3:成长阶段 4:突破阶段 5:KA阶段',
  `team_created_at`       INT(11)             NOT NULL DEFAULT '0'
  COMMENT '店铺创建时间',
  `created_at`            INT(11)             NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at`           INT(11)             NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `kdt_op_status`         TINYINT(3) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '1待跟进 2跟进中 3已放弃 4已完成',
  `role_attach_id`        BIGINT(20) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '角色附加ID 渠道用于子账号',
  `team_type`             TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '店铺类型对应 枚举类型team表的team_type',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_gmv`
--

DROP TABLE IF EXISTS `team_gmv`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_gmv` (
  `id`         INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `kdt_id`     INT(11) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '店铺id',
  `gmv`        DECIMAL(20, 0)   NOT NULL DEFAULT '0'
  COMMENT 'gmv值',
  `date`       INT(11)          NOT NULL DEFAULT '0'
  COMMENT '日期',
  `created_at` INT(11)          NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_history`
--

DROP TABLE IF EXISTS `team_history`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_history` (
  `id`         INT(10) NOT NULL AUTO_INCREMENT,
  `kdt_id`     INT(11) NOT NULL
  COMMENT '店铺的kdtId',
  `rule`       INT(11) NOT NULL
  COMMENT 'rule',
  `level`      INT(11) NOT NULL
  COMMENT 'level',
  `business`   INT(11) NOT NULL
  COMMENT 'business',
  `score`      INT(11) NOT NULL
  COMMENT 'score',
  `created_at` INT(11) NOT NULL
  COMMENT '创建时间',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_import`
--

DROP TABLE IF EXISTS `team_import`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_import` (
  `id`          INT(11) UNSIGNED    NOT NULL AUTO_INCREMENT,
  `kdt_id`      INT(11) UNSIGNED    NOT NULL
  COMMENT '店铺的kdtId',
  `activity`    VARCHAR(64)         NOT NULL DEFAULT ''
  COMMENT '店铺参与的活动  多个活动用逗号隔开 1008 108 109(拓客-新客户) 888续签 444公池活跃3.8 316供货商分配 88805五月续签 777 到期客户转化 17613: 扫码收款商家转化',
  `created_at`  INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at` INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`  INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  `type`        TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '要分配给的团队    1:电销  2:客满',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_operation_info`
--

DROP TABLE IF EXISTS `team_operation_info`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_operation_info` (
  `id`                     INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `kdt_id`                 INT(11)          NOT NULL DEFAULT '0'
  COMMENT '店铺id',
  `contact_name`           VARCHAR(20)      NOT NULL DEFAULT ''
  COMMENT '主要对接人',
  `contact_title`          VARCHAR(20)      NOT NULL DEFAULT ''
  COMMENT '对接人职位',
  `contact_wechat`         VARCHAR(30)      NOT NULL DEFAULT ''
  COMMENT '对接人微信号',
  `kp_name`                VARCHAR(20)      NOT NULL DEFAULT ''
  COMMENT '关键人(店铺负责人) KP',
  `kp_title`               VARCHAR(20)      NOT NULL DEFAULT ''
  COMMENT '关键人职位 KP职位',
  `team_intro`             VARCHAR(255)     NOT NULL DEFAULT ''
  COMMENT '团队介绍（人数、岗位配置）',
  `company_nature_type`    TINYINT(3)       NOT NULL DEFAULT '0'
  COMMENT '主体性质 1 其他 2个人 3外企 4中外合资 5私企 6国企 7事业单位 8政府机关 9公益组织 10教育机构',
  `main_product`           VARCHAR(100)     NOT NULL DEFAULT ''
  COMMENT '主营产品/服务',
  `goods_source_types`     VARCHAR(50)      NOT NULL DEFAULT ''
  COMMENT '实物货品来源id  1 其他 2自行生产 3经销代理 4批发拿货 5海外采购',
  `goods_source_name`      VARCHAR(30)      NOT NULL DEFAULT ''
  COMMENT '货品来源名称',
  `logistics_model_types`  VARCHAR(50)      NOT NULL DEFAULT ''
  COMMENT '物流模式 id 1 其他 2 同城配送 3 全国快递 4 上门自提 5 货到付款',
  `logistics_model_name`   VARCHAR(30)      NOT NULL DEFAULT ''
  COMMENT '物流模式名称',
  `sell_channel_types`     VARCHAR(50)      NOT NULL DEFAULT ''
  COMMENT '销售渠道id 1 其他 2 其他微信渠道销售 3 电商平台销售 4 线下单一门店销售 5 线下直营连锁门店 6 加盟连锁门店 7 线下体验店 8 经销商渠道销售 9 app合作销售',
  `sell_channel_name`      VARCHAR(30)      NOT NULL DEFAULT ''
  COMMENT '销售渠道名称',
  `shop_scale`             INT(10)          NOT NULL DEFAULT '0'
  COMMENT '门店规模 文本框数字填写（0代表没门店）',
  `target_consumer_groups` VARCHAR(255)     NOT NULL DEFAULT ''
  COMMENT '目标消费人群',
  `target_consumer_scene`  VARCHAR(255)     NOT NULL DEFAULT ''
  COMMENT '消费场景',
  `service_address_ids`    VARCHAR(200)     NOT NULL DEFAULT ''
  COMMENT '服务销售范围',
  `team_source_type`       TINYINT(3)       NOT NULL DEFAULT '0'
  COMMENT '商户来源id 1其他 2 广告搜索 3 朋友推荐 4 同行参考',
  `team_source_name`       VARCHAR(20)      NOT NULL DEFAULT ''
  COMMENT '商户来源名称',
  `fans_source_types`      VARCHAR(50)      NOT NULL DEFAULT ''
  COMMENT '粉丝来源名称 1 其他 2 线下门店导流 3 电商平台引流',
  `fans_source_name`       VARCHAR(100)     NOT NULL DEFAULT ''
  COMMENT '粉丝来源名称',
  `operation_plan`         VARCHAR(255)     NOT NULL DEFAULT ''
  COMMENT '运营规划/目标',
  `created_at`             INT(11)          NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at`            INT(11)          NOT NULL DEFAULT '0'
  COMMENT '更新时间',
  `goods_types`            VARCHAR(50)      NOT NULL DEFAULT ''
  COMMENT '商品类型 0. 其他 1. 实物销售 2.虚拟商品销售 3.服务销售',
  `goods_type_name`        VARCHAR(30)      NOT NULL DEFAULT ''
  COMMENT '商品类型名称（其他）',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_operation_record`
--

DROP TABLE IF EXISTS `team_operation_record`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_operation_record` (
  `id`          INT(10) UNSIGNED    NOT NULL AUTO_INCREMENT
  COMMENT '自增id',
  `kdt_id`      INT(11)             NOT NULL DEFAULT '0'
  COMMENT '店铺ID',
  `sso_id`      INT(11)             NOT NULL DEFAULT '0'
  COMMENT '操作人 sso_id (cas id)',
  `record`      VARCHAR(3000)       NOT NULL DEFAULT ''
  COMMENT '运营记录',
  `created_at`  INT(11)             NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at` INT(11)             NOT NULL DEFAULT '0'
  COMMENT '更新时间',
  `sales_level` TINYINT(3) UNSIGNED NOT NULL DEFAULT '7'
  COMMENT '销售阶段  0:0暂未定成熟度 1:1已付款 2:2即将付款 3:3有意向 4:3-意愿再次跟进 5:4KP未定 6:5关闭 7.6未跟进',
  `record_type` TINYINT(3) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '业务记录类型  1:华尔街店铺   2:华尔街商机 3:渠道店铺  4:华尔街任务  5: 渠道线索',
  `business_id` INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '关联的业务id',
  `product_id`  INT(10) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '关联产品id',
  `follow_mode` TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '跟进方式 1:电话跟进 2:在线沟通 3:实地拜访',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_provider`
--

DROP TABLE IF EXISTS `team_provider`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_provider` (
  `id`          INT(10)             NOT NULL AUTO_INCREMENT,
  `kdt_id`      INT(11)             NOT NULL DEFAULT '0'
  COMMENT '店铺的kdtId',
  `provider_id` INT(11)             NOT NULL DEFAULT '0'
  COMMENT '渠道商id',
  `source`      TINYINT(5) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '渠道店铺的来源 1=>有赞分配 2=>通过线索转化自动绑定的',
  `reward_rule` TINYINT(5)          NOT NULL DEFAULT '0'
  COMMENT '在渠道自己拓展的池子但是奖励规则走有赞分配的逻辑 0:否 1:是',
  `created_at`  INT(10)             NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at` INT(10)             NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_wechat`
--

DROP TABLE IF EXISTS `team_wechat`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_wechat` (
  `id`          INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `sso_id`      INT(11) UNSIGNED NOT NULL
  COMMENT '内部客服ID',
  `wechat_id`   INT(11) UNSIGNED NOT NULL
  COMMENT '客户微信主键',
  `kdt_id`      INT(11) UNSIGNED NOT NULL
  COMMENT '店铺ID',
  `created_at`  INT(11) UNSIGNED NOT NULL
  COMMENT '创建时间',
  `modified_at` INT(11) UNSIGNED NOT NULL
  COMMENT '修改时间',
  `deleted_at`  INT(11) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id`         INT(11) NOT NULL,
  `username`   VARCHAR(255) DEFAULT NULL,
  `created_at` DATETIME     DEFAULT NULL,
  `updated_at` DATETIME     DEFAULT NULL,
  `password`   VARCHAR(255) DEFAULT NULL,
  `is_deleted` INT(11)      DEFAULT NULL,
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id`            INT(11)             NOT NULL AUTO_INCREMENT,
  `sso_id`        INT(11)             NOT NULL
  COMMENT '员工id',
  `name`          VARCHAR(20)         NOT NULL DEFAULT 'name'
  COMMENT '姓名',
  `real_name`     VARCHAR(20)         NOT NULL DEFAULT 'real_name'
  COMMENT '姓名',
  `alias_name`    VARCHAR(20)         NOT NULL DEFAULT 'alias_name'
  COMMENT '昵称',
  `phone`         CHAR(11)            NOT NULL DEFAULT 'phone'
  COMMENT '电话',
  `status`        INT(11)             NOT NULL DEFAULT '0'
  COMMENT '用户状态，默认0有效',
  `system_role`   TINYINT(5) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '系统角色  0:其他 1:销售 2:商服 3:KA 4:渠道',
  `higher_level`  VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '上级管理员',
  `manager`       VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '管理的人员',
  `team_level`    VARCHAR(32)         NOT NULL DEFAULT ''
  COMMENT '可被分配的店铺级别 1=>优质商家 2=>普通商家',
  `operator_name` VARCHAR(64)         NOT NULL DEFAULT ''
  COMMENT '最后操作人姓名',
  `last_login_at` INT(11)             NOT NULL DEFAULT '0'
  COMMENT '最后登陆时间',
  `created_at`    INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at`   INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`    INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  `wechat`        VARCHAR(30)         NOT NULL DEFAULT ''
  COMMENT '微信号',
  `wechat_qr`     VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '微信二维码',
  `bind_limit`    INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '用户销售经理绑定上限',
  `clue_limit`    INT(5) UNSIGNED     NOT NULL DEFAULT '0'
  COMMENT '线索商机上限',
  `follow_limit`  INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '首次跟进之后多长时间未跟进后系统自动解绑的时间',
  `is_assigned`   TINYINT(5) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '销售是否自动分配店铺 0:否 1:是',
  `wechat_avatar` VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '微信头像',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_business`
--

DROP TABLE IF EXISTS `user_business`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_business` (
  `id`          INT(11)             NOT NULL AUTO_INCREMENT,
  `business_id` INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '类目',
  `sso_id`      INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '内部人员id',
  `role`        TINYINT(3) UNSIGNED NOT NULL
  COMMENT '类目关联人角色 0-普通 1-商服负责人 2-KA负责人',
  `gmv`         INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '分配ka最低gmv',
  `created_at`  INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '创建时间',
  `modified_at` INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`  INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_clinch_order`
--

DROP TABLE IF EXISTS `user_clinch_order`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_clinch_order` (
  `id`               BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `kdt_id`           INT(10) UNSIGNED    NOT NULL
  COMMENT '店铺id',
  `order_id`         BIGINT(20) UNSIGNED NOT NULL
  COMMENT '订单号 open_applicaiton_order 主键',
  `pay_time`         DATETIME            NOT NULL
  COMMENT '支付时间',
  `state`            TINYINT(3) UNSIGNED NOT NULL
  COMMENT '待付款|0 已支付|1  退款|2 已升级|3 关闭|4',
  `app_name`         VARCHAR(255)        NOT NULL
  COMMENT '所购买的应用',
  `refund_time`      DATETIME            NOT NULL DEFAULT '0000-00-00 00:00:00'
  COMMENT '订单退款时间 为0则没有退款',
  `role_id`          INT(10) UNSIGNED    NOT NULL
  COMMENT '角色id ',
  `app_id`           INT(10) UNSIGNED    NOT NULL
  COMMENT '应用id',
  `item_id`          BIGINT(20) UNSIGNED NOT NULL
  COMMENT '应用 SKU ID',
  `role_type`        TINYINT(1) UNSIGNED NOT NULL
  COMMENT '角色类型 0|没有人绑定该店铺 1|渠道商 2|华尔街',
  `real_price`       INT(10) UNSIGNED    NOT NULL
  COMMENT '实付金额',
  `is_purchased`     TINYINT(1) UNSIGNED NOT NULL
  COMMENT '商家是否以前购买过相同的商品 0|没有 1|有',
  `return_price`     INT(10) UNSIGNED    NOT NULL
  COMMENT '退款金额',
  `transform_id`     INT(10) UNSIGNED    NOT NULL
  COMMENT '转化的id 根据role_id决定实际意义 华尔街为机会id 渠道为线索id',
  `transform_status` TINYINT(1) UNSIGNED NOT NULL
  COMMENT '转化的快照状态 根据role_id决定实际意义 华尔街为机会 渠道为线索名',
  `reward_level`     TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '奖励等级 根据具体的角色决定',
  `activate_price`   BIGINT(20) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '激活码价值',
  `activate_code`    VARCHAR(32)         NOT NULL DEFAULT ''
  COMMENT '激活码',
  `role_attach_id`   BIGINT(20) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '角色附加ID 渠道时为子账号user_id',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_follow_team`
--

DROP TABLE IF EXISTS `user_follow_team`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_follow_team` (
  `id`          BIGINT(20)          NOT NULL AUTO_INCREMENT,
  `sso_id`      INT(11)             NOT NULL
  COMMENT '员工id',
  `kdt_id`      INT(11)             NOT NULL
  COMMENT '店铺的kdtId',
  `type`        TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '0-后台绑定 1-临时生成',
  `role`        TINYINT(3) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '角色 0-无角色 1-客户经理 2-客户经理助理 3-销售经理 4-技术支持',
  `is_ka`       TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '是否是KA客服经理 0:不是 1:是',
  `created_at`  INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '新增时间',
  `modified_at` INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '修改时间',
  `deleted_at`  INT(11) UNSIGNED    NOT NULL DEFAULT '0'
  COMMENT '删除时间',
  `is_paid`     TINYINT(3)          NOT NULL DEFAULT '0'
  COMMENT '当前绑定人绑定的店铺是否付费:1为已付费(当前绑定信息有效) :0为未付费',
  `sales_level` TINYINT(3) UNSIGNED NOT NULL DEFAULT '7'
  COMMENT '销售阶段  0:0暂未定成熟度 1:1已付款 2:2即将付款 3:3有意向 4:3-意愿再次跟进 5:4KP未定 6:5关闭 7.6未跟进',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_provider`
--

DROP TABLE IF EXISTS `user_provider`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_provider` (
  `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sso_id`      INT(11) UNSIGNED    NOT NULL
  COMMENT '渠道经理id',
  `provider_id` INT(11) UNSIGNED    NOT NULL
  COMMENT '代理商id',
  `created_at`  DATETIME            NOT NULL
  COMMENT '新增时间',
  `updated_at`  DATETIME            NOT NULL
  COMMENT '修改时间',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_push_toole_binding`
--

DROP TABLE IF EXISTS `user_push_toole_binding`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_push_toole_binding` (
  `id`             BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_id`        BIGINT(20) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '绑定关系的用户id',
  `role_attach_id` BIGINT(20) UNSIGNED NOT NULL
  COMMENT '暂存子账号id',
  `shop_id`        BIGINT(20) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '店铺id',
  `user_no`        BIGINT(20) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '商户平台用户id',
  `kdt_id`         BIGINT(20)          NOT NULL DEFAULT '0'
  COMMENT '店铺kdtid',
  `source`         TINYINT(3) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '商户绑定关系来源 1自主开拓 2有赞分配 3大客',
  `state`          TINYINT(3) UNSIGNED NOT NULL
  COMMENT '绑定状态',
  `created_at`     DATETIME            NOT NULL DEFAULT '0000-00-00 00:00:00'
  COMMENT '新增时间',
  `updated_at`     DATETIME            NOT NULL DEFAULT '0000-00-00 00:00:00'
  COMMENT '修改时间',
  `deleted_at`     DATETIME            NOT NULL
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_team`
--

DROP TABLE IF EXISTS `user_team`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_team` (
  `id`         INT(11) UNSIGNED    NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `account_id` BIGINT(20) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '帐号id',
  `kdt_id`     TINYINT(3) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '店铺ID',
  `role`       TINYINT(3) UNSIGNED NOT NULL DEFAULT '1'
  COMMENT '超级管理员',
  `create_at`  DATETIME                     DEFAULT '1970-01-01 00:00:00'
  COMMENT '创建时间',
  `update_at`  DATETIME                     DEFAULT '1970-01-01 00:00:00'
  COMMENT '修改时间',
  `delete_at`  DATETIME                     DEFAULT '1970-01-01 00:00:00'
  COMMENT '删除时间',
  PRIMARY KEY (`id`)
)
  ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_train_coupon`
--

DROP TABLE IF EXISTS `user_train_coupon`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_train_coupon` (
  `id`               BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `group_id`         BIGINT(20) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '优惠码的组ID',
  `code`             VARCHAR(32)         NOT NULL
  COMMENT '优惠码',
  `assign_kdt_id`    BIGINT(20) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '优惠码分配给的店铺',
  `valid_end_time`   DATETIME            NOT NULL
  COMMENT '有效结束时间',
  `valid_start_time` DATETIME            NOT NULL
  COMMENT '有效开始时间',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '父节点ID',
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `alias_name` varchar(20) NOT NULL DEFAULT '' COMMENT '分组唯一别名，全局唯一，建议加上应用名前缀',
  `app` varchar(20) NOT NULL DEFAULT '' COMMENT '所属应用别名，例如：crm / provider / panama',
  `level` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '在树中所处层级，从0开始',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '分组名称',
  `leader_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'leader的sso id',
  `associated_dept_id` int(11) NOT NULL DEFAULT '0' COMMENT '关联有人的部门ID',
  `deleted_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间',
  `updated_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  `created_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用于区分用户体系，1：销售（内部员工），2：渠道',
  PRIMARY KEY (`id`),
  KEY `idx_app_alias` (`app`,`alias_name`),
  KEY `idx_alias` (`alias_name`)
);

DROP TABLE IF EXISTS `user_group_node_relation`;
CREATE TABLE `user_group_node_relation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `ancestor` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '祖先节点',
  `descendant` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '后代节点',
  `distance` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '相隔层级，>=1',
  `updated_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `created_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_anc_desc` (`ancestor`,`descendant`)
) ;

DROP TABLE IF EXISTS `user_group_tag_relation`;
CREATE TABLE `user_group_tag_relation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_group_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '组ID',
  `tag` varchar(20) NOT NULL DEFAULT '' COMMENT 'tag，例如:renew',
  `updated_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `created_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_group_tag` (`user_group_id`,`tag`),
  KEY `idx_tag` (`tag`)
  );

DROP TABLE IF EXISTS `user_group_user_relation`;
CREATE TABLE `user_group_user_relation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_group_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'user_group.id',
  `sso_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户的sso id',
  `updated_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `created_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_group_user` (`user_group_id`,`sso_id`)
);

-- Dump completed on 2017-08-02 16:19:16
DROP TABLE IF EXISTS `sales_target`;
CREATE TABLE `sales_target` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT ,
    `owner_type` tinyint(3) unsigned NOT NULL DEFAULT '0' ,
    `owner_id` int(11) unsigned NOT NULL DEFAULT '0',
    `year` int(11) unsigned NOT NULL DEFAULT '0',
    `period_type` tinyint(3) unsigned NOT NULL DEFAULT '0',
    `period` int(11) unsigned NOT NULL DEFAULT '0',
    `value` bigint(20) unsigned NOT NULL DEFAULT '0' ,
    `updated_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
    `created_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
    `deal_count` int(11) unsigned NOT NULL DEFAULT '1970-01-01 00:00:00',
      PRIMARY KEY (`id`)
  );


DROP TABLE IF EXISTS `sales_group_rule`;
CREATE TABLE `sales_group_rule` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT ,
  `group_id` int(10) unsigned NOT NULL DEFAULT '0' ,
  `rule_type` tinyint(4) NOT NULL DEFAULT '0' ,
  `rule_value` varchar(32) NOT NULL DEFAULT '' ,
  `updated_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `created_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_group_type_value` (`group_id`,`rule_type`,`rule_value`)
) ;

DROP TABLE IF EXISTS `clue_bind`;
CREATE TABLE  `clue_bind` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(100) NOT NULL COMMENT '线索名称',
  `mobile` VARCHAR(32) NOT NULL COMMENT '手机号码',
  `county_id` INT NOT NULL DEFAULT 0 COMMENT '区的id',
  `address` VARCHAR(128) NOT NULL DEFAULT '\"\"' COMMENT '详细地址',
  `group_id_operator` INT NOT NULL COMMENT '创建者在公私海的销售分组id',
  `belong_id_operator` INT NOT NULL COMMENT '创建者id',
  `assign_org_type_operator` TINYINT(4) NOT NULL COMMENT '组织类型(（有赞＝1，渠道＝2）',
  `group_id_binded` INT NOT NULL COMMENT '被分配者的销售分组id',
  `belong_id_binded` INT NOT NULL COMMENT '被分配者的用户id',
  `assign_org_type_binded` TINYINT(4) NOT NULL COMMENT '被绑定者公私hai(有赞＝1，渠道＝2）',
  `binding_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '绑定时间',
  `to_unbinding_time` DATETIME NOT NULL COMMENT '将要解绑时间',
  `status` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '1待跟进2跟进中3已结束 \n\n0: 未绑定到人',
  `kdt_id` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '店铺id',
  `is_matched` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '是否被匹配0否1是',
  `follow_level` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '跟进阶段 0:0暂未定成熟度 1:1已付款 2:2即将付款 3:3有意向 4:3-意愿再次跟进 5:4KP未定 6:5关闭 7.6未跟进 8.已退款',
  `follow_level_ext` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '在销售阶段（跟进阶段）为“毁单”时使用',
  `stamp` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '设置关注度 0 未设置关注',
  `follow_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '当前跟进时间',
  `next_follow_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下次跟进时间',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `assign_source` tinyint(4) DEFAULT '1',
  `info_source` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`));

DROP TABLE IF EXISTS `team_bind`;
CREATE TABLE  `team_bind` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '店铺绑定表',
  `kdt_id` BIGINT(20) NOT NULL COMMENT '店铺id',
  `role` INT NOT NULL COMMENT '角色 客户经理 客户经理助理 销售经理 技术支持;主要是店铺提供的是什么？',
  `group_id_operator` INT NOT NULL DEFAULT 0 COMMENT '操作人的分组id',
  `belong_id_operator` INT NOT NULL DEFAULT 0 COMMENT '操作人id',
  `assign_org_type_operator` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '操作人的org（有赞＝1，渠道＝2）',
  `follow_level` TINYINT(4) NOT NULL COMMENT '跟进阶段 \n0:0暂未定成熟度 \n1:1已付款 \n2:2即将付款 \n3:3有意向 \n4:3-意愿再次跟进 5:4KP未定 \n6:5关闭 \n7.6未跟进 \n8.已退款\n99:',
  `follow_level_ext` TINYINT(4) NOT NULL COMMENT '在毁单时试用',
  `follow_time` DATETIME NOT NULL COMMENT '本次跟进时间',
  `next_follow_time` DATETIME NOT NULL COMMENT '下次跟进时间',
  `status` TINYINT(4) NOT NULL COMMENT '0＝ 未跟进\n1 ＝ 待跟进\n2 ＝ 跟进中\n3 ＝ ',
  `stamp` TINYINT(4) NOT NULL COMMENT '设置关注',
  `group_id_binded` INT NOT NULL COMMENT '被绑定人的销售分组',
  `belong_id_binded` INT NOT NULL COMMENT '绑定人的id',
  `assign_org_type_binded` TINYINT(4) NOT NULL COMMENT '绑定的组织类型（有赞＝1，渠道＝2）',
  `binding_time` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '绑定时间',
  `to_unbinding_time` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '将要解绑时间',
  `created_at` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '修改时间',
  `assign_source` tinyint(4) DEFAULT '1',
  `info_source` tinyint(4) DEFAULT '0',
  `mobile` VARCHAR (64) DEFAULT '',
  `flag` INT DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idx_role_kdt_id` (`kdt_id` ASC, `role` ASC));

DROP TABLE IF EXISTS `user_group_provider_relation`;
CREATE TABLE `user_group_provider_relation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_group_id` int(10) NOT NULL DEFAULT '0' COMMENT 'user_group.id',
  `provider_id` int(10) NOT NULL DEFAULT '0' COMMENT '渠道商id',
  `provider_group_id` int(10) NOT NULL DEFAULT '0' COMMENT '渠道商分组id',
  `updated_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `created_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_provider_pgroup` (`provider_id`,`provider_group_id`),
  UNIQUE KEY `uniq_gid` (`user_group_id`)
);


DROP TABLE IF EXISTS `following_log`;
CREATE TABLE `following_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `group_id` int(11) NOT NULL COMMENT '跟进人组织',
  `belong_id` int(11) NOT NULL COMMENT '跟进人id',
  `assign_org_type` tinyint(4) NOT NULL COMMENT '销售分组分类',
  `resource_id` bigint(20) NOT NULL COMMENT '线索/店铺',
  `resource_type` tinyint(4) NOT NULL COMMENT '资源类型 1 ＝ clue_bind的id\n2 ＝ team_bind 的id',
  `binding_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `follow_manner` int(11) NOT NULL COMMENT '跟进方式',
  `follow_level` tinyint(4) NOT NULL DEFAULT '0' COMMENT '跟进阶段 0:0暂未定成熟度 1:1已付款 2:2即将付款 3:3有意向 4:3-意愿再次跟进 5:4KP未定 6:5关闭 7.6未跟进 8.已退',
  `follow_level_ext` tinyint(4) NOT NULL DEFAULT '0' COMMENT '销售阶段的级联值；0:表示没有设置',
  `follow_record` varchar(256) COMMENT '跟进内容',
  `follow_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `next_follow_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `created_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `updated_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `binding_log`;
CREATE TABLE `binding_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `group_id_operator` int(11) NOT NULL COMMENT '组操作者',
  `belong_id_operator` int(11) NOT NULL COMMENT '私操作者',
  `assign_org_type_operator` tinyint(4) NOT NULL COMMENT '操作者类型（有赞＝1，渠道＝2）',
  `binding_time` datetime NOT NULL COMMENT '绑定时间',
  `resource_id` bigint(20) NOT NULL COMMENT '目前是线索，店铺，店铺服务',
  `resource_type` tinyint(4) NOT NULL COMMENT '资源类型 1 ＝ clue_bind的id\n2 ＝ team_bind 的id',
  `assign_tag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '分配标签: 0无 1:新客户 2:续签 3:优质客户',
  `assign_source` tinyint(4) NOT NULL COMMENT '分配来源: 1:系统分配 2:人工分配 3:自主认领',
  `info_source` tinyint(4) NOT NULL DEFAULT '0' COMMENT '本次绑定关系信息来源:\n0=自己录入？\n1=系统分配\n2=人工分配\n3=自主认领\n4=他人介绍\n5=电话咨询\n6=在线咨询\n7=小程序问卷\n8=SEM投放\n9=官网拓客\n10=bd页面',
  `group_id_from` int(11) NOT NULL COMMENT '资源目前销售分组id 销售分组id，代表公海',
  `belong_id_from` int(11) NOT NULL COMMENT '资源目前binding人id',
  `assign_org_type_from` tinyint(4) NOT NULL COMMENT '组织类型（有赞＝1，渠道＝2）',
  `group_id_to` int(11) NOT NULL COMMENT '被绑人销售分组',
  `belong_id_to` int(11) NOT NULL COMMENT '被绑定id',
  `assign_org_type_to` tinyint(4) NOT NULL COMMENT '组织类型（有赞＝1，渠道＝2）',
   `created_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `updated_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `public_territory_rule`;
CREATE TABLE `public_territory_rule` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '公海名称',
  `user_group_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'user_group表的id',
  `max_team_stock` int(11) NOT NULL DEFAULT '-1' COMMENT '限制店铺库存，-1表示不限制',
  `used_team_stock` int(11) NOT NULL DEFAULT '0' COMMENT '已占用店铺库存数',
  `buy_status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '已购状态，0不限，1仅已购，2仅未购',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `used_clue_stock` int(11) NOT NULL DEFAULT '0' COMMENT '已占用线索库存数',
  `max_clue_stock` int(11) NOT NULL DEFAULT '-1' COMMENT '限制线索库存，-1表示不限制',
  `binary_rules` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '权限',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `chance_filter`;
CREATE TABLE `chance_filter` (
  `id` BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增id',
  `title` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '标题',
  `status` INT UNSIGNED NOT NULL DEFAULT '0' COMMENT '注册状态 1-已注册 2-未注册',
  `condition` VARCHAR(1024) NOT NULL DEFAULT '' COMMENT '筛选条件 由前端给出',
  `sort_condition` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '排序条件 ',
  `sort_way` VARCHAR(16) NOT NULL DEFAULT 'desc' COMMENT '排序方式',
  `cas_uid` INT UNSIGNED NOT NULL DEFAULT '0' COMMENT 'cas用户id',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '修改时间',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `public_territory_city_relation`;
CREATE TABLE `public_territory_city_relation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_group_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'user_group的id',
  `city_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '城市id，0表示不限城市',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_gid_cid` (`user_group_id`,`city_id`)
);

DROP TABLE IF EXISTS `dw_inner_team`;
CREATE TABLE `dw_inner_team` (
  `id`          INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '主键id',
  `kdt_id`      INT(11) UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '店铺id',
  `source_from` VARCHAR(32)      NOT NULL DEFAULT ''
  COMMENT '测试店铺id的来源',
  PRIMARY KEY (`id`),
  KEY `kdtx_id` (`kdt_id`)
);

DROP TABLE IF EXISTS `async_task_record`;
CREATE TABLE `async_task_record` (
  `id` BIGINT AUTO_INCREMENT NOT NULL
  COMMENT '自增id',
  `task_type` TINYINT NOT NULL
  COMMENT '任务类型，0代表TOC，1代表NSQ',
  `task_id` VARCHAR(300) NOT NULL
  COMMENT '任务唯一标识，对于TOC来说TocBizId是唯一标识，对于NSQ来说topic是唯一标识',
  `task_content` VARCHAR(2000) NOT NULL
  COMMENT '任务内容, json字符串',
  `procducer_result` TINYINT NOT NULL DEFAULT '0'
  COMMENT '消费结果，0代表未发送，1代表已发送',
  `consumer_result` TINYINT NOT NULL DEFAULT '0'
  COMMENT '发送结果，0代表未执行，1代表已执行',
  `expect_process_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '任务指定执行时间，NSQ为当前时间（立即执行），TOC为延时任务设定的执行时间',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '修改时间',
  `timeout` INT NOT NULL DEFAULT '10'
  COMMENT '允许超时，单位为分，当current > expect_process_time + timeout，即代表执行失败',
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `clue_bind_deleted`;
CREATE TABLE `clue_bind_deleted` (
  `id` BIGINT AUTO_INCREMENT NOT NULL COMMENT 'id',
  `name` VARCHAR(100) NOT NULL COMMENT '线索名称',
  `mobile` VARCHAR(32) NOT NULL COMMENT '手机号码',
  `county_id` INT NOT NULL DEFAULT '0' COMMENT '区的id',
  `address` VARCHAR(128) NOT NULL DEFAULT '``' COMMENT '详细地址',
  `group_id_operator` INT NOT NULL COMMENT '创建者在公私海的销售分组id',
  `belong_id_operator` INT NOT NULL COMMENT '创建者id',
  `assign_org_type_operator` TINYINT NOT NULL COMMENT '组织类型(（有赞＝1，渠道＝2）',
  `group_id_binded` INT NOT NULL COMMENT '被分配者的销售分组id',
  `belong_id_binded` INT NOT NULL COMMENT '被分配者的用户id',
  `assign_org_type_binded` TINYINT NOT NULL COMMENT '被绑定者公私hai(有赞＝1，渠道＝2）',
  `binding_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '绑定时间',
  `to_unbinding_time` DATETIME NOT NULL COMMENT '将要解绑时间',
  `status` TINYINT NOT NULL DEFAULT '0' COMMENT '1待跟进2跟进中3已结束 \n\n0: 未绑定到人',
  `kdt_id` BIGINT NOT NULL DEFAULT '0' COMMENT '店铺id',
  `is_matched` TINYINT NOT NULL DEFAULT '0' COMMENT '是否被匹配0否1是',
  `follow_level` TINYINT NOT NULL DEFAULT '0' COMMENT '跟进阶段 0:0暂未定成熟度 1:1已付款 2:2即将付款 3:3有意向 4:3-意愿再次跟进 5:4KP未定 6:5关闭 7.6未跟进 8.已退款',
  `follow_level_ext` TINYINT NOT NULL DEFAULT '0' COMMENT '在销售阶段（跟进阶段）为“毁单”时使用',
  `stamp` TINYINT NOT NULL DEFAULT '0' COMMENT '设置关注度 0 未设置关注',
  `follow_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '当前跟进时间',
  `next_follow_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下次跟进时间',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `info_source` TINYINT NOT NULL DEFAULT '0' COMMENT '本次绑定关系信息来源: 0=自己录入？ 1=系统分配 2=人工分配 3=自主认领 4=他人介绍 5=电话咨询 6=在线咨询 7=小程序问卷 8=SEM投放 9=官网拓客 10=bd页面',
  `assign_source` TINYINT NOT NULL DEFAULT '1' COMMENT '分配来源: 1:系统分配 2:人工分配 3:自主认领',
  PRIMARY KEY (`id`),
);

