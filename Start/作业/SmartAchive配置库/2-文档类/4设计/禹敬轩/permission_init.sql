/* Ȩ�޶�����ʼ�� */
delete from permission cascade constraints
/

insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (01,null,'FUN01','�����ļ�','1','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (02,01,'FUN0101','�����ļ�-����','2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (03,02,'FUN010101','�����ļ�-����-�����ļ�����','3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (04,01,'FUN0102','�����ļ�-����','2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (05,04,'FUN010201','�����ļ�-����-�����ļ�����','3','1')
/

insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (06, null, 'FUN02',     '�����ɼ�',                         '1','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (07, 06,   'FUN0201',   '�����ɼ�-��¼',                    '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (08, 07,   'FUN020101', '�����ɼ�-��¼-������¼',           '3','1')
/    
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (09, 07,   'FUN020102', '�����ɼ�-��¼-����¼',             '3','1')
/      
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (10, 07,   'FUN020103', '�����ɼ�-��¼-�ļ���¼',           '3','1')
/    
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (11, 06,   'FUN0202',   '�����ɼ�-¼��',                    '2','1')
/               
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (12, 11,   'FUN020201', '�����ɼ�-¼��-����ɨ��¼��',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (13, 06,   'FUN0203',   '�����ɼ�-���',                    '2','1')
/               
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (14, 12,   'FUN020301', '�����ɼ�-���-���',               '3','1')
/        
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (15, 06,   'FUN0204',   '�����ɼ�-�鵵',                    '2','1')
/               
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (16, 14,   'FUN020401', '�����ɼ�-�鵵-�鵵',               '3','1')
/        

insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (17, null, 'FUN03',     '��������',                         '1','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (18, 17,   'FUN0301',   '��������-ȫ�ڹ���',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (19, 18,   'FUN030101', '��������-ȫ�ڹ���-ȫ�ھ���Ϣ����', '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (20, 18,   'FUN030102', '��������-ȫ�ڹ���-������Ŀ����',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (21, 18,   'FUN030103', '��������-ȫ�ڹ���-�ܼ�����',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (22, 18,   'FUN030104', '��������-ȫ�ڹ���-��ʷĿ¼�����', '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (23, 17,   'FUN0302',   '��������-������Ϣ����',            '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (24, 23,   'FUN030201', '��������-������Ϣ����-����У��',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (25, 23,   'FUN030202', '��������-������Ϣ����-��������',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (26, 23,   'FUN030203', '��������-������Ϣ����-���ٹ���',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (27, 23,   'FUN030204', '��������-������Ϣ����-�������',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (28, 23,   'FUN030205', '��������-������Ϣ����-���й���',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (29, 23,   'FUN030206', '��������-������Ϣ����-������',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (30, 23,   'FUN030207', '��������-������Ϣ����-�ල������','3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (31, 17,   'FUN0303',   '��������-�ⷿ����',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (32, 31,   'FUN030301', '��������-�ⷿ����-��ʪ�ȹ���',     '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (33, 31,   'FUN030302', '��������-�ⷿ����-��ȫ����',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (34, 31,   'FUN030303', '��������-�ⷿ����-�ܼ��ܹ���',     '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (35, 17,   'FUN0304',   '��������-�淶������',              '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (36, 35,   'FUN030401', '��������-�淶������-���ɷ������', '3','1')
/

insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (37, null, 'FUN04',     '��������','1','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (38, 37,   'FUN0401',   '��������-���Ĺ���',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (39, 38,   'FUN040101', '��������-���Ĺ���-��������',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (40, 38,   'FUN040102', '��������-���Ĺ���-�������',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (41, 38,   'FUN040103', '��������-���Ĺ���-���ĵǼ�',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (42, 38,   'FUN040104', '��������-���Ĺ���-���Ĺ黹',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (43, 38,   'FUN040105', '��������-���Ĺ���-���ķ���',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (44, 38,   'FUN040106', '��������-���Ĺ���-�����շ�',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (45, 37,   'FUN0402',   '��������-���Ĺ���',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (46, 45,   'FUN040201', '��������-���Ĺ���-��������',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (47, 45,   'FUN040202', '��������-���Ĺ���-�������',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (48, 45,   'FUN040203', '��������-���Ĺ���-���ĵǼ�',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (49, 45,   'FUN040204', '��������-���Ĺ���-����Ǽ�',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (50, 45,   'FUN040205', '��������-���Ĺ���-���Ĵ���',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (51, 45,   'FUN040206', '��������-���Ĺ���-���Ĺ黹',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (52, 45,   'FUN040207', '��������-���Ĺ���-���ķ���',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (53, 45,   'FUN040208', '��������-���Ĺ���-�����շ�',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (54, 37,   'FUN0403',   '��������-��֤����',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (55, 54,   'FUN040301', '��������-��֤����-��֤����',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (56, 54,   'FUN040302', '��������-��֤����-��֤�Ǽ�',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (57, 54,   'FUN040303', '��������-��֤����-���������',     '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (58, 54,   'FUN040304', '��������-��֤����-�ۺϿ����',     '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (59, 54,   'FUN040305', '��������-��֤����-��֤�շ�',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (60, 37,   'FUN0404',   '��������-�շѹ���',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (61, 60,   'FUN040401', '��������-�շѹ���-�շ���Ŀ����',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (62, 60,   'FUN040402', '��������-�շѹ���-�շѱ�׼����',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (63, 37,   'FUN0403',   '��������-�ۺϲ�ѯ',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (64, 63,   'FUN040301', '��������-�ۺϲ�ѯ-����ȫ�ļ���',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (65, 63,   'FUN040302', '��������-�ۺϲ�ѯ-������ѯ',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (66, 63,   'FUN040303', '��������-�ۺϲ�ѯ-ͳ�Ʊ���',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (67, 63,   'FUN040304', '��������-�ۺϲ�ѯ-��ϲ�ѯ',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (68, 37,   'FUN0404',   '��������-��������',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (69, 68,   'FUN040401', '��������-��������-��Ϣ����',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (70, 68,   'FUN040402', '��������-��������-ȡ������',       '3','1')
/

insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (71, null, 'FUN05',     '���ϵ������ѯ',                   '1','1')
/

insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (72, null, 'FUN06',     'ϵͳ����',                         '1','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (73, 72,   'FUN0601',   'ϵͳ����-��־����',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (74, 73,   'FUN060101', 'ϵͳ����-��־����-ϵͳ������־����','3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (75, 73,   'FUN060102', 'ϵͳ����-��־����-�û�������־����','3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (76, 72,   'FUN0602',   'ϵͳ����-�û�Ȩ�޹���',                '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (77, 76,   'FUN060201', 'ϵͳ����-�û�Ȩ�޹���-�û�����',       '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (78, 76,   'FUN060202', 'ϵͳ����-Ȩ�޹���-�û������',     '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (79, 72,   'FUN0603',   'ϵͳ����-�����ֵ����',            '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (80, 79,   'FUN060301', 'ϵͳ����-�����ֵ����-�����ֵ�',   '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (81, 79,   'FUN060302', 'ϵͳ����-�����ֵ����-�����',     '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (82, 72,   'FUN0604','ϵͳ����-���ݿⱸ����ָ�',           '2','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (83, 82,   'FUN060401','ϵͳ����-���ݿⱸ����ָ�-����',    '3','1')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (84, 82,   'FUN060402','ϵͳ����-���ݿⱸ����ָ�-�ָ�',    '3','1')
/
--�����������˵����������-������Ϣ����-�־ֹ����㱨
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (85, 23,   'FUN030208', '��������-������Ϣ����-�־ֹ����㱨','3','1')
/
--���������˵��ϵͳ����-�û�Ȩ�޹���-��֯����
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (86, 76,   'FUN060203', 'ϵͳ����-�û�Ȩ�޹���-��֯����',    '3','1')
/
--���ݣ�������Ȩ��
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (100,NULL,'OPER01','������Ŀ����','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (101,NULL,'OPER02','�޸���Ŀ����','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (102,NULL,'OPER03','��ѯ��Ŀ����','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (103,NULL,'OPER04','ɾ����Ŀ����','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (104,NULL,'OPER05','������Ŀ����','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (105,NULL,'OPER06','�����ļ�����','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (106,NULL,'OPER07','�޸��ļ�����','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (107,NULL,'OPER08','��ѯ�ļ�����','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (108,NULL,'OPER09','ɾ���ļ�����','0','2')
/
insert into permission(permission_id,father_permission_id,permission_code,permission_name,permission_level,permission_type) values (109,NULL,'OPER10','�����ļ�����','0','2')
/