/*==============================================================*/
/* Database name:  HGAM DB V1.00                                */
/* DBMS name:      ORACLE Version 9i                            */
/* Created on:     2003-12-3 16:25:53                           */
/* Created by:     zhengxq@sunyard.com                          */
/*==============================================================*/

--叶昊初始化部分
--初始化类目表
--一级类目
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(1,'1','规划审批档案','1');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(2,'1','规划监察档案','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(3,'1','测绘档案','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(4,'1','规划设计成果','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(5,'1','党群工作类','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(6,'1','行政管理类','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(7,'1','规划业务管理档案','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(8,'1','会计档案','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(9,'1','特种载体','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(10,'1','科研项目','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(11,'1','设备档案','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(12,'1','基建档案','0');

--二级类目
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(13,1,'2','许可证存根','1');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(14,1,'2','规划用地审批','1');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(15,1,'2','建筑工程审批','1');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(16,1,'2','杂项工程审批','1');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(17,1,'2','市政工程审批','1');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(18,1,'2','临时工程审批','1');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(19,1,'2','竣工验收审批','1');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(20,2,'2','案件查处','0');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(21,3,'2','测绘综合成果','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(22,3,'2','地形图原图、二底图','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(23,3,'2','测量标志','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(24,3,'2','像控片(调绘片)','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(25,3,'2','航摄底片','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(26,3,'2','涤纶片','0');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(27,4,'2','分区规划','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(28,4,'2','详细规划','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(29,4,'2','控制性规划','0');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(30,5,'2','党务','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(31,5,'2','工会','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(32,5,'2','共青团','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(33,5,'2','学会协会','0');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(34,6,'2','政务','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(35,6,'2','事务','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(36,6,'2','人事','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(37,6,'2','财务','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(38,6,'2','提案信访','0');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(39,7,'2','规划编审设计','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(40,7,'2','建筑、用地','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(41,7,'2','工程管线','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(42,7,'2','法规监察','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(43,7,'2','测绘管理','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(44,7,'2','信息系统','0');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(45,8,'2','会计凭证','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(46,8,'2','会计帐簿','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(47,8,'2','财务报告','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(48,8,'2','其他','0');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(49,9,'2','照片','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(50,9,'2','录像','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(51,9,'2','光盘软盘','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(52,9,'2','实物','0');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(53,10,'2','项目招标','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(54,10,'2','项目计划','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(55,10,'2','项目实施','0');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(56,11,'2','设备文件材料','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(57,11,'2','图纸','0');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(58,12,'2','审批文件','0');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(59,12,'2','基建图纸','0');

--初始化档案密级表
insert into SECRET(SECRET_ID,SECRET_Code,SECRET_Name) VALUES(1,'001','普通');
insert into SECRET(SECRET_ID,SECRET_Code,SECRET_Name) VALUES(2,'002','秘密');
insert into SECRET(SECRET_ID,SECRET_Code,SECRET_Name) VALUES(3,'003','机密');
insert into SECRET(SECRET_ID,SECRET_Code,SECRET_Name) VALUES(4,'004','绝密');

--初始化分局表
insert into Substation(Substation_ID,Substation_Code,Substation_Name) VALUES(1,'001','杭州市城市规划监察大队');
insert into Substation(Substation_ID,Substation_Code,Substation_Name) VALUES(2,'002','杭州市规划局上城规划处');
insert into Substation(Substation_ID,Substation_Code,Substation_Name) VALUES(3,'003','杭州市规划局下城规划处');
insert into Substation(Substation_ID,Substation_Code,Substation_Name) VALUES(4,'004','杭州市规划局西湖规划处');
insert into Substation(Substation_ID,Substation_Code,Substation_Name) VALUES(5,'005','杭州市规划局江干规划处');
insert into Substation(Substation_ID,Substation_Code,Substation_Name) VALUES(6,'006','杭州市规划局拱墅规划处');
insert into Substation(Substation_ID,Substation_Code,Substation_Name) VALUES(7,'007','杭州市规划局滨江规划处');


--郑先全初始化部分
--1.22.工程阶段定义表
INSERT INTO PROJECT_PHASE(PHASE_ID,PHASE_NAME) VALUES(1,'选址');
INSERT INTO PROJECT_PHASE(PHASE_ID,PHASE_NAME) VALUES(2,'方案');
INSERT INTO PROJECT_PHASE(PHASE_ID,PHASE_NAME) VALUES(3,'用地');
INSERT INTO PROJECT_PHASE(PHASE_ID,PHASE_NAME) VALUES(4,'桩基');
INSERT INTO PROJECT_PHASE(PHASE_ID,PHASE_NAME) VALUES(5,'工程');
INSERT INTO PROJECT_PHASE(PHASE_ID,PHASE_NAME) VALUES(6,'灰线');
INSERT INTO PROJECT_PHASE(PHASE_ID,PHASE_NAME) VALUES(7,'竣工');
INSERT INTO PROJECT_PHASE(PHASE_ID,PHASE_NAME) VALUES(8,'违章');
INSERT INTO PROJECT_PHASE(PHASE_ID,PHASE_NAME) VALUES(9,'补办');
INSERT INTO PROJECT_PHASE(PHASE_ID,PHASE_NAME) VALUES(10,'批后');
INSERT INTO PROJECT_PHASE(PHASE_ID,PHASE_NAME) VALUES(11,'其他');

--1.23.字段类型表
INSERT INTO FIELD_TYPE(FIELD_TYPE_ID,FIELD_TYPE_ENAME,FIELD_TYPE_CNAME) VALUES(1,'VARCHAR2','字符型');
INSERT INTO FIELD_TYPE(FIELD_TYPE_ID,FIELD_TYPE_ENAME,FIELD_TYPE_CNAME) VALUES(2,'NUMBER','数字型');
INSERT INTO FIELD_TYPE(FIELD_TYPE_ID,FIELD_TYPE_ENAME,FIELD_TYPE_CNAME) VALUES(3,'DATE','日期型');

--2.05.收费方式表
INSERT INTO CHARGE_MODE(CHARGE_MODE_ID,CHARGE_UNIT,CHARGE_MODE_NAME) VALUES(1,'页','A0');
INSERT INTO CHARGE_MODE(CHARGE_MODE_ID,CHARGE_UNIT,CHARGE_MODE_NAME) VALUES(2,'页','A1');
INSERT INTO CHARGE_MODE(CHARGE_MODE_ID,CHARGE_UNIT,CHARGE_MODE_NAME) VALUES(3,'页','A2');
INSERT INTO CHARGE_MODE(CHARGE_MODE_ID,CHARGE_UNIT,CHARGE_MODE_NAME) VALUES(4,'页','A3');
INSERT INTO CHARGE_MODE(CHARGE_MODE_ID,CHARGE_UNIT,CHARGE_MODE_NAME) VALUES(5,'页','A4');
INSERT INTO CHARGE_MODE(CHARGE_MODE_ID,CHARGE_UNIT,CHARGE_MODE_NAME) VALUES(6,'页','超大');

--2.06.档案利用方式
INSERT INTO UTILIZE_MODE(MODE_ID,MODE_NAME) VALUES(1,'原件');
INSERT INTO UTILIZE_MODE(MODE_ID,MODE_NAME) VALUES(2,'电子文档');
INSERT INTO UTILIZE_MODE(MODE_ID,MODE_NAME) VALUES(3,'二次信息');
INSERT INTO UTILIZE_MODE(MODE_ID,MODE_NAME) VALUES(4,'出具证明');
INSERT INTO UTILIZE_MODE(MODE_ID,MODE_NAME) VALUES(5,'复制');

--2.07.档案利用类型表
INSERT INTO UTILIZE_TYPE(TYPE_ID,TYPE_NAME) VALUES(1,'查阅');
INSERT INTO UTILIZE_TYPE(TYPE_ID,TYPE_NAME) VALUES(2,'借阅');
INSERT INTO UTILIZE_TYPE(TYPE_ID,TYPE_NAME) VALUES(3,'查档出证明');

--2.08.证件类型表
INSERT INTO CERTIFICATE_TYPE(TYPE_ID,TYPE_NAME) VALUES(1,'身份证');
INSERT INTO CERTIFICATE_TYPE(TYPE_ID,TYPE_NAME) VALUES(2,'军人证');
--华良东初始化部分
--初始化系统参数表
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES(1,'UTILIZE','APPLIED','已申请')
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES(2,'UTILIZE','CONFIRMED','已审核')
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES(3,'UTILIZE','UNCONFIRMED','审核未通过')
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES(4,'UTILIZE','REGISTED','已登记')
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES(5,'UTILIZE','EXPR','已超期')
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES(6,'UTILIZE','RETURNED','已归还')
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES(7,'UTILIZE','REBACKED','已反馈')
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES(8,'UTILIZE','CHARGED','已收费')
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES(9,'UTILIZE','AR_CONFIRMED','档案科已审核')
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES(10,'UTILIZE','CO_CONFIRMED','综合处已审核')
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES(11,'UTILIZE','AR_UNCONFIRMED','档案科审核未通过')
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES(12,'UTILIZE','CO_UNCONFIRMED','综合处审核未通过')

