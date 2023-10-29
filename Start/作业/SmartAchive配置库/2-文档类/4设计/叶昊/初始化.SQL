/*初始化类目表
/*一级类目
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

/*二级类目
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
insert into Entry(Entry_ID,Father_Entry_ID,Entry_Level,Entry_Name,ISOPERATION) VALUES(48,8,'2','其他');

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

/*初始化档案密级表
insert into Archives_Sceret(SECRET_ID,SECRET_Code,SECRET_Name,) VALUES(1,'001','普通');
insert into Archives_Sceret(SECRET_ID,SECRET_Code,SECRET_Name,) VALUES(2,'002','秘密');
insert into Archives_Sceret(SECRET_ID,SECRET_Code,SECRET_Name,) VALUES(3,'003','机密');
insert into Archives_Sceret(SECRET_ID,SECRET_Code,SECRET_Name,) VALUES(4,'004','绝密');

/*初始化档案表
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','永久','F')
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','长期','L')
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','短期','S')
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','25','25')
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','10','10')
insert into SysParam(SysParam_ID,SysParam_type,SysParam_Name,SysParam_VALUE) VALUES((SELECT NVL(MAX(NVL(SysParam_ID,0))+1,1) FROM SysParam),'ArchiveStore','5','5')