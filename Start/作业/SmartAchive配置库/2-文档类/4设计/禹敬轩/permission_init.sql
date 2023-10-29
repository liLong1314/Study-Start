/* 权限定义表初始化 */
delete from permission cascade constraints
/

insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (01,null,'FUN01','电子文件','1','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (02,01,'FUN0101','电子文件-接收','2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (03,02,'FUN010101','电子文件-接收-电子文件接收','3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (04,01,'FUN0102','电子文件-整理','2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (05,04,'FUN010201','电子文件-整理-电子文件整理','3','1')
/

insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (06, null, 'FUN02',     '档案采集',                         '1','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (07, 06,   'FUN0201',   '档案采集-著录',                    '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (08, 07,   'FUN020101', '档案采集-著录-案卷著录',           '3','1')
/    
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (09, 07,   'FUN020102', '档案采集-著录-件著录',             '3','1')
/      
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (10, 07,   'FUN020103', '档案采集-著录-文件著录',           '3','1')
/    
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (11, 06,   'FUN0202',   '档案采集-录入',                    '2','1')
/               
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (12, 11,   'FUN020201', '档案采集-录入-档案扫描录入',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (13, 06,   'FUN0203',   '档案采集-检查',                    '2','1')
/               
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (14, 12,   'FUN020301', '档案采集-检查-检查',               '3','1')
/        
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (15, 06,   'FUN0204',   '档案采集-归档',                    '2','1')
/               
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (16, 14,   'FUN020401', '档案采集-归档-归档',               '3','1')
/        

insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (17, null, 'FUN03',     '档案管理',                         '1','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (18, 17,   'FUN0301',   '档案管理-全宗管理',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (19, 18,   'FUN030101', '档案管理-全宗管理-全宗卷信息管理', '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (20, 18,   'FUN030102', '档案管理-全宗管理-档案类目管理',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (21, 18,   'FUN030103', '档案管理-全宗管理-密级管理',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (22, 18,   'FUN030104', '档案管理-全宗管理-历史目录册管理', '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (23, 17,   'FUN0302',   '档案管理-档案信息管理',            '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (24, 23,   'FUN030201', '档案管理-档案信息管理-档案校验',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (25, 23,   'FUN030202', '档案管理-档案信息管理-鉴定管理',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (26, 23,   'FUN030203', '档案管理-档案信息管理-销毁管理',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (27, 23,   'FUN030204', '档案管理-档案信息管理-变更管理',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (28, 23,   'FUN030205', '档案管理-档案信息管理-编研管理',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (29, 23,   'FUN030206', '档案管理-档案信息管理-年检管理',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (30, 23,   'FUN030207', '档案管理-档案信息管理-监督检查管理','3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (31, 17,   'FUN0303',   '档案管理-库房管理',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (32, 31,   'FUN030301', '档案管理-库房管理-温湿度管理',     '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (33, 31,   'FUN030302', '档案管理-库房管理-安全管理',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (34, 31,   'FUN030303', '档案管理-库房管理-密集架管理',     '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (35, 17,   'FUN0304',   '档案管理-规范化管理',              '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (36, 35,   'FUN030401', '档案管理-规范化管理-法律法规管理', '3','1')
/

insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (37, null, 'FUN04',     '档案利用','1','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (38, 37,   'FUN0401',   '档案利用-查阅管理',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (39, 38,   'FUN040101', '档案利用-查阅管理-查阅申请',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (40, 38,   'FUN040102', '档案利用-查阅管理-查阅审核',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (41, 38,   'FUN040103', '档案利用-查阅管理-查阅登记',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (42, 38,   'FUN040104', '档案利用-查阅管理-查阅归还',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (43, 38,   'FUN040105', '档案利用-查阅管理-查阅反馈',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (44, 38,   'FUN040106', '档案利用-查阅管理-查阅收费',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (45, 37,   'FUN0402',   '档案利用-借阅管理',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (46, 45,   'FUN040201', '档案利用-借阅管理-借阅申请',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (47, 45,   'FUN040202', '档案利用-借阅管理-借阅审核',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (48, 45,   'FUN040203', '档案利用-借阅管理-借阅登记',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (49, 45,   'FUN040204', '档案利用-借阅管理-续借登记',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (50, 45,   'FUN040205', '档案利用-借阅管理-借阅催收',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (51, 45,   'FUN040206', '档案利用-借阅管理-借阅归还',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (52, 45,   'FUN040207', '档案利用-借阅管理-借阅反馈',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (53, 45,   'FUN040208', '档案利用-借阅管理-借阅收费',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (54, 37,   'FUN0403',   '档案利用-查证管理',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (55, 54,   'FUN040301', '档案利用-查证管理-查证申请',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (56, 54,   'FUN040302', '档案利用-查证管理-查证登记',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (57, 54,   'FUN040303', '档案利用-查证管理-档案科审核',     '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (58, 54,   'FUN040304', '档案利用-查证管理-综合科审核',     '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (59, 54,   'FUN040305', '档案利用-查证管理-查证收费',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (60, 37,   'FUN0404',   '档案利用-收费管理',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (61, 60,   'FUN040401', '档案利用-收费管理-收费项目定义',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (62, 60,   'FUN040402', '档案利用-收费管理-收费标准定义',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (63, 37,   'FUN0403',   '档案利用-综合查询',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (64, 63,   'FUN040301', '档案利用-综合查询-档案全文检索',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (65, 63,   'FUN040302', '档案利用-综合查询-档案查询',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (66, 63,   'FUN040303', '档案利用-综合查询-统计报表',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (67, 63,   'FUN040304', '档案利用-综合查询-组合查询',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (68, 37,   'FUN0404',   '档案利用-发布管理',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (69, 68,   'FUN040401', '档案利用-发布管理-信息发布',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (70, 68,   'FUN040402', '档案利用-发布管理-取消发布',       '3','1')
/

insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (71, null, 'FUN05',     '资料导入与查询',                   '1','1')
/

insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (72, null, 'FUN06',     '系统管理',                         '1','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (73, 72,   'FUN0601',   '系统管理-日志管理',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (74, 73,   'FUN060101', '系统管理-日志管理-系统运行日志管理','3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (75, 73,   'FUN060102', '系统管理-日志管理-用户操作日志管理','3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (76, 72,   'FUN0602',   '系统管理-用户权限管理',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (77, 76,   'FUN060201', '系统管理-用户权限管理-用户管理',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (78, 76,   'FUN060202', '系统管理-权限管理-用户组管理',     '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (79, 72,   'FUN0603',   '系统管理-数据字典管理',            '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (80, 79,   'FUN060301', '系统管理-数据字典管理-数据字典',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (81, 79,   'FUN060302', '系统管理-数据字典管理-主题词',     '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (82, 72,   'FUN0604','系统管理-数据库备份与恢复',           '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (83, 82,   'FUN060401','系统管理-数据库备份与恢复-备份',    '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (84, 82,   'FUN060402','系统管理-数据库备份与恢复-恢复',    '3','1')
/
--华良东新增菜单项－档案管理-档案信息管理-分局工作汇报
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (85, 23,   'FUN030208', '档案管理-档案信息管理-分局工作汇报','3','1')
/
--禹敬轩新增菜单项－系统管理-用户权限管理-组织管理
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (86, 76,   'FUN060203', '系统管理-用户权限管理-组织管理',    '3','1')
/
--数据（操作）权限
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (100,NULL,'OPER01','增加条目数据','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (101,NULL,'OPER02','修改条目数据','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (102,NULL,'OPER03','查询条目数据','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (103,NULL,'OPER04','删除条目数据','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (104,NULL,'OPER05','下载条目数据','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (105,NULL,'OPER06','增加文件数据','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (106,NULL,'OPER07','修改文件数据','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (107,NULL,'OPER08','查询文件数据','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (108,NULL,'OPER09','删除文件数据','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (109,NULL,'OPER10','下载文件数据','0','2')
/