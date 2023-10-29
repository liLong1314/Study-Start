--synonym FOR OA
--Create & Edit By ZhengXianquan(zhengxq@sunyard.com)
--Create At 2003年12月29日
--Edit   At 2004年2月18日:
	1).增加DBLink，确保中间库在不同实例间的正却引用关系

--DBLink
--Drop existing database link 
drop public database link OADbLink;
-- Create database link 
create public database link OADbLink
  connect to OA2AM identified by CCIRCCIR
  using 'DBOA2AM';

--文件表
-- Drop the existing synonym 
drop synonym OA_ARCHIVES_FILE;
-- Create the new synonym 
create synonym OA_ARCHIVES_FILE
  for OA2AM.ARCHIVES_FILE@OADbLink;

--业务类电子表单字段值表
-- Drop the existing synonym 
drop synonym OA_FIELD_VALUE;
-- Create the new synonym 
create synonym OA_FIELD_VALUE
  for OA2AM.FIELD_VALUE@OADbLink;

--(影像)页对象表
-- Drop the existing synonym 
drop synonym OA_ARCHIVES_PAGE;
-- Create the new synonym 
create synonym OA_ARCHIVES_PAGE
  for OA2AM.ARCHIVES_PAGE@OADbLink;

--元数据表
-- Drop the existing synonym 
drop synonym OA_METADATA;
-- Create the new synonym 
create synonym OA_METADATA
  for OA2AM.METADATA@OADbLink;

--文件关联表
-- Drop the existing synonym 
drop synonym OA_FILE_ASSOCIATE;
-- Create the new synonym 
create synonym OA_FILE_ASSOCIATE
  for OA2AM.FILE_ASSOCIATE@OADbLink;

--业务类电子表单定义表
-- Drop the existing synonym 
drop synonym OA_EFORM_DEFINE;
-- Create the new synonym 
create synonym OA_EFORM_DEFINE
  for OA2AM.EFORM_DEFINE@OADbLink;

--电子表单－字段对应表
-- Drop the existing synonym 
drop synonym OA_EFORM_FIELD;
-- Create the new synonym 
create synonym OA_EFORM_FIELD
  for OA2AM.EFORM_FIELD@OADbLink;

--电子表单字段定义表
-- Drop the existing synonym 
drop synonym OA_FIELD_DEFINE;
-- Create the new synonym 
create synonym OA_FIELD_DEFINE
  for OA2AM.FIELD_DEFINE@OADbLink;

--工程阶段定义表
-- Drop the existing synonym 
drop synonym OA_PROJECT_PHASE;
-- Create the new synonym 
create synonym OA_PROJECT_PHASE
  for OA2AM.PROJECT_PHASE@OADbLink;

--字段类型表
-- Drop the existing synonym 
drop synonym OA_FIELD_TYPE;
-- Create the new synonym 
create synonym OA_FIELD_TYPE
  for OA2AM.FIELD_TYPE@OADbLink;