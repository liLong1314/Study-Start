/*==============================================================*/
/* Database name:  HGAM DB V1.00                                */
/* DBMS name:      ORACLE Version 9i                            */
/* Created on:     2003-12-3 16:25:53                           */
/* Created by:     zhengxq@sunyard.com                          */
/* Edit  log :                                                  */
/*1、把二级类目“许可证存根”的ISOPERATION修订为2，确保这类的正确著录(郑先全，20040317)    */
/*==============================================================*/

--叶昊初始化部分
--初始化类目表
--一级类目
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(1,'1','规划审批档案','1');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(2,'1','规划监察档案','2');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(3,'1','测绘档案','2');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(4,'1','规划设计成果','2');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(5,'1','党群工作类','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(6,'1','行政管理类','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(7,'1','规划业务管理档案','0');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(8,'1','会计档案','2');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(9,'1','特种载体','2');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(10,'1','科研项目','2');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(11,'1','设备档案','2');
insert into Entry(Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(12,'1','基建档案','2');

--二级类目
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(13,1,'2','许可证存根','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(14,1,'2','规划用地审批','1');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(15,1,'2','建筑工程审批','1');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(16,1,'2','杂项工程审批','1');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(17,1,'2','市政工程审批','1');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(18,1,'2','临时工程审批','1');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(19,1,'2','竣工验收审批','1');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(20,2,'2','案件查处','2');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(21,3,'2','测绘综合成果','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(22,3,'2','地形图原图、二底图','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(23,3,'2','测量标志','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(24,3,'2','像控片(调绘片)','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(25,3,'2','航摄底片','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(26,3,'2','涤纶片','2');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(27,4,'2','分区规划','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(28,4,'2','详细规划','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(29,4,'2','控制性规划','2');

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

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(45,8,'2','会计凭证','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(46,8,'2','会计帐簿','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(47,8,'2','财务报告','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(48,8,'2','其他','2');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(49,9,'2','照片','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(50,9,'2','录像','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(51,9,'2','光盘软盘','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(52,9,'2','实物','2');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(53,10,'2','项目招标','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(54,10,'2','项目计划','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(55,10,'2','项目实施','2');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(56,11,'2','设备文件材料','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(57,11,'2','图纸','2');

insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(58,12,'2','审批文件','2');
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(59,12,'2','基建图纸','2');

--初始化档案密级表
insert into SECRET(SECRET_ID,SECRET_Code,SECRET_Name) VALUES(1,'001','普通');
insert into SECRET(SECRET_ID,SECRET_Code,SECRET_Name) VALUES(2,'002','秘密');
insert into SECRET(SECRET_ID,SECRET_Code,SECRET_Name) VALUES(3,'003','机密');
insert into SECRET(SECRET_ID,SECRET_Code,SECRET_Name) VALUES(4,'004','绝密');

--初始化档案表-保管期限
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','永久','F');
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','长期','L');
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','短期','S');
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','25年','25');
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','10年','10');
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','5年','5');
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','3年','3');


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
INSERT INTO PROJECT_PHASE(PHASE_ID,PHASE_NAME) VALUES(99,'其他');

--1.23.字段类型表
INSERT INTO FIELD_TYPE(FIELD_TYPE_ID,FIELD_TYPE_ENAME,FIELD_TYPE_CNAME) VALUES(1,'VARCHAR2','字符型');
INSERT INTO FIELD_TYPE(FIELD_TYPE_ID,FIELD_TYPE_ENAME,FIELD_TYPE_CNAME) VALUES(2,'NUMBER','数字型');
INSERT INTO FIELD_TYPE(FIELD_TYPE_ID,FIELD_TYPE_ENAME,FIELD_TYPE_CNAME) VALUES(3,'DATE','日期型');

--2.05.收费方式表
--INSERT INTO CHARGE_MODE(CHARGE_MODE_ID,CHARGE_UNIT,CHARGE_MODE_NAME) VALUES(1,'页','A0');
--INSERT INTO CHARGE_MODE(CHARGE_MODE_ID,CHARGE_UNIT,CHARGE_MODE_NAME) VALUES(2,'页','A1');
--INSERT INTO CHARGE_MODE(CHARGE_MODE_ID,CHARGE_UNIT,CHARGE_MODE_NAME) VALUES(3,'页','A2');
--INSERT INTO CHARGE_MODE(CHARGE_MODE_ID,CHARGE_UNIT,CHARGE_MODE_NAME) VALUES(4,'页','A3');
--INSERT INTO CHARGE_MODE(CHARGE_MODE_ID,CHARGE_UNIT,CHARGE_MODE_NAME) VALUES(5,'页','A4');
--INSERT INTO CHARGE_MODE(CHARGE_MODE_ID,CHARGE_UNIT,CHARGE_MODE_NAME) VALUES(6,'页','超大');

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
--INSERT INTO CERTIFICATE_TYPE(TYPE_ID,TYPE_NAME) VALUES(1,'身份证');
--INSERT INTO CERTIFICATE_TYPE(TYPE_ID,TYPE_NAME) VALUES(2,'军人证');
--华良东初始化部分
--初始分局名称
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'SubCode','上城规划分局','Sub_sc');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'SubCode','下城规划分局','Sub_xc');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'SubCode','西湖规划分局','Sub_xh');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'SubCode','江干规划分局','Sub_jg');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'SubCode','拱墅规划分局','Sub_gs');
--初始化编研类别
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchStudy','组织机构改革','ArchStudy_org');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchStudy','基础数字汇编','ArchStudy_jc');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchStudy','会议简介','ArchStudy_hy');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchStudy','大事记','ArchStudy_ds');
--初始化系统参数表
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'UTILIZE','已申请','APPLIED');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'UTILIZE','已审核','CONFIRMED');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'UTILIZE','审核未通过','UNCONFIRMED');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'UTILIZE','已登记','REGISTED');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'UTILIZE','已超期','EXPR');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'UTILIZE','已归还','RETURNED');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'UTILIZE','已反馈','REBACKED');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'UTILIZE','已收费','CHARGED');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'UTILIZE','档案科已审核','AR_CONFIRMED');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'UTILIZE','综合处已审核','CO_CONFIRMED');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'UTILIZE','档案科审核未通过','AR_UNCONFIRMED');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'UTILIZE','综合处审核未通过','CO_UNCONFIRMED');

INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PAGE_SIZE','A4','1');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PAGE_SIZE','A3','2');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PAGE_SIZE','A2','3');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PAGE_SIZE','A1','4');

INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PAGE_OPERATOR','修改','1');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PAGE_OPERATOR','查询','2');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PAGE_OPERATOR','下载','3');


INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'CHARGE_MODE','页/A4','A4');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'CHARGE_MODE','页/A3','A3');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'CHARGE_MODE','页/A2','A2');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'CHARGE_MODE','页/A1','A1');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'CHARGE_MODE','页/AX','AX');

--郑先全
--档案单位
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ARCHIVES_UNIT','千克','1');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ARCHIVES_UNIT','克','2');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ARCHIVES_UNIT','米','3');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ARCHIVES_UNIT','个','4');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ARCHIVES_UNIT','只','5');
--载体类型
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'MEDIA_TYPE','纸质','1');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'MEDIA_TYPE','电子文件','2');
--规格
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'SPEC','A4','A4');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'SPEC','A3','A3');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'SPEC','A2','A2');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'SPEC','A1','A1');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'SPEC','A0','A0');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'SPEC','超大','AX');
--稿本类型
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FILE_TYPE','正本','1');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FILE_TYPE','副本','2');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FILE_TYPE','草稿','3');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FILE_TYPE','定稿','4');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FILE_TYPE','手稿','5');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FILE_TYPE','草图','6');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FILE_TYPE','原图','7');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FILE_TYPE','底图','8');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FILE_TYPE','兰图','9');
INSERT INTO SYSPARAM(SYSPARAM_ID,SYSPARAM_TYPE,SYSPARAM_NAME,SYSPARAM_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FILE_TYPE','复印件','10');
--立档单位
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ARCHIVES_FOUND_UNIT','杭州市规划局','1');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ARCHIVES_FOUND_UNIT','上城规划分局','2');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ARCHIVES_FOUND_UNIT','下城规划分局','3');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ARCHIVES_FOUND_UNIT','西湖规划分局','4');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ARCHIVES_FOUND_UNIT','江干规划分局','5');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ARCHIVES_FOUND_UNIT','拱墅规划分局','6');
--类目类型
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ENTRY_TYPE','文书类','0');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ENTRY_TYPE','业务类','1');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ENTRY_TYPE','其他','2');
--字段类型
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FIELD_TYPE','字符型','1');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FIELD_TYPE','数字型','2');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'FIELD_TYPE','日期型','3');
--信息发布类型
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PUBLISH_INFO_TYPE','用户反馈','BUG');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PUBLISH_INFO_TYPE','系统公告','SYS');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PUBLISH_INFO_TYPE','规划动态','TY1');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PUBLISH_INFO_TYPE','本局新闻','TY2');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PUBLISH_INFO_TYPE','其他要闻','TY3');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'PUBLISH_INFO_TYPE','图片新闻','TY4');
--证件类型
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'CERTIFICATE_TYPE','身份证','1');
INSERT INTO SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'CERTIFICATE_TYPE','军人证','2');
