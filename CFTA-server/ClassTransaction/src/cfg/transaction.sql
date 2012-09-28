

DROP DATABASE IF EXISTS `CLASSTRANSACTION`;
CREATE DATABASE `CLASSTRANSACTION`;
USE `CLASSTRANSACTION`;


--
-- table `t_role`权限管理
--

DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (

  `SID` varchar(12) NOT NULL ,
  `COURSE_AUTHORITY` smallint NOT NULL default FALSE,
  `HEALTH_AUTHORITY` smallint NOT NULL default FALSE,
  `FINANCE_AUTHORITY` smallint NOT NULL default FALSE,
  `USER_IMFO_AUTHORITY` smallint NOT NULL default FALSE,
  `ACTIVITY_AUTHORITY` smallint NOT NULL default FALSE,
  `KAOQING_AUTHORITY` smallint NOT NULL default FALSE,
  `SUPER_AUTHORITY` smallint NOT NULL default FALSE,
  PRIMARY KEY  (`SID`),
  FOREIGN KEY  ('SID') REFERENCES FROM t_user
) ENGINE=InnoDB DEFAULT CHARSET=GBK;

--
-- table `t_role`
--
LOCK TABLES `t_role` WRITE;
INSERT INTO `t_role` VALUES ('1','0','0','0','0','0','0','1');
UNLOCK TABLES;


	      
--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `SID` varchar(12) NOT NULL,
  `USER_NAME` varchar(255) NOT NULL,
  `SNUMBER` varchar(255) default NULL,
  `PASS_WORD` varchar(255)default NULL,
  `GENDER` varchar(255) default NULL,
  `BIRTHDAY` varchar(255) default NULL,
  `ADDRESS` varchar(255) default NULL,
  `NATIVE_PLACE` varchar(255) default NULL,
  `PHONE` varchar(255)default NULL,
  `SHORTPHONE` varchar(255) default NULL,
  `EMAIL` varchar(255) default NULL,	
  `IS_DELETE` varchar(255) NOT NULL default '0',
  PRIMARY KEY  (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=GBK;

--
-- table `t_user`
--



LOCK TABLES `t_user` WRITE;
INSERT INTO `t_user` VALUES (1,'crt','201030630032','123456','男','19910618','c10705','广东汕头','15889933539','623539','ruitaocc@gmail.com','0'           );
UNLOCK TABLES;

