/* 增加管理员用户 */
delete from "GROUP" cascade constraints
/
insert into
     "GROUP" (ID,NAME,DESCRIPTION,GROUP_CREATE_DATE)
     values (0,'admin','管理员组',TO_DATE('2004-1-12 12:48:00','YYYY-MM-DD HH24:MI:SS'))
/

--管理员权限初始化
delete from group_permission
/

insert into group_permission (group_id,permission_id,permission_type) values (0,3,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,5,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,8,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,9,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,10,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,12,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,14,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,16,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,19,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,20,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,21,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,22,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,24,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,25,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,26,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,27,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,28,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,29,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,30,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,32,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,33,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,34,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,36,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,39,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,40,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,41,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,42,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,43,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,44,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,46,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,47,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,48,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,49,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,50,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,51,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,52,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,53,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,55,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,56,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,57,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,58,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,59,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,61,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,62,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,64,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,65,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,66,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,67,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,69,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,70,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,74,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,75,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,77,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,78,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,80,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,81,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,83,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,84,'1')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,100,'2')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,101,'2')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,102,'2')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,103,'2')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,104,'2')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,105,'2')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,106,'2')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,107,'2')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,108,'2')
/
insert into group_permission (group_id,permission_id,permission_type) values (0,109,'2')
/