/*==============================================================*/
/* Database name:  HGAM DB V1.00                                */
/* DBMS name:      ORACLE Version 9i                            */
/* Created on:     2004-4-2 11:05:59                            */
/* Created by:	   zhengxq@sunyard.com                          */
/*==============================================================*/


drop table METADATA cascade constraints
/


drop table DESTORY cascade constraints
/


drop table UTILIZE_DETAIL cascade constraints
/


drop table FILE_ASSOCIATE cascade constraints
/


drop table EXP_IMP_ARCHIVES cascade constraints
/


drop table FIELD_VALUE cascade constraints
/


drop table ARCHIVES_PAGE cascade constraints
/


drop table CHECKUP cascade constraints
/


drop table ARCHIVES_FILE cascade constraints
/


drop table EXP_IMP_REGISTER cascade constraints
/


drop table YEARFORM cascade constraints
/


drop table EFORM_FIELD cascade constraints
/


drop table WATCHEXAMINE_DENOTE cascade constraints
/


drop table ARCHIVES_BEIKAO cascade constraints
/


drop table HGAM.ORGROLEUSER cascade constraints
/


drop table UTILIZE_CONFIRM cascade constraints
/


drop table UTILIZE_APPLY cascade constraints
/


drop table DATA_FILE cascade constraints
/


drop table HGAM.OPERATION_LOG cascade constraints
/


drop table ARCHIVES cascade constraints
/


drop table HGAM.GROUP_PERMISSION cascade constraints
/


drop table SUBFILECATALOG cascade constraints
/


drop table FIELD_DEFINE cascade constraints
/


drop table YEARREPORT cascade constraints
/


drop table YEARREG cascade constraints
/


drop table Watch_Examine cascade constraints
/


drop table WHOLEDOSSIER cascade constraints
/


drop table UTILIZE_TYPE cascade constraints
/


drop table UTILIZE_PERSON cascade constraints
/


drop table UTILIZE_MODE cascade constraints
/


drop table HGAM.USER_PERMISSION cascade constraints
/


drop table HGAM.USERS cascade constraints
/


drop table HGAM.THEME cascade constraints
/


drop table TEMPERATURE cascade constraints
/


drop table SysParam cascade constraints
/


drop table SUBROLLCATALOG cascade constraints
/


drop table SECRET cascade constraints
/


drop table SAFETY cascade constraints
/


drop table RUNTIME_LOG cascade constraints
/


drop table PUBLISH_INFO_ACCESSORY cascade constraints
/


drop table PUBLISH_INFO cascade constraints
/


drop table PROJECT_PHASE cascade constraints
/


drop table HGAM.PERMISSION cascade constraints
/


drop table OperationUrl cascade constraints
/


drop table OTHER_CATALOG cascade constraints
/


drop table HGAM.ORGORG cascade constraints
/


drop table HGAM.ORGANIZATION cascade constraints
/


drop table LAW cascade constraints
/


drop table HGAM."GROUP" cascade constraints
/


drop table FIELD_TYPE cascade constraints
/


drop table Entry cascade constraints
/


drop table EFORM_DEFINE cascade constraints
/


drop table HGAM.DATABASE cascade constraints
/


drop table CONTAINER cascade constraints
/


drop table CHARGE_STANDARD cascade constraints
/


drop table BUILDING_CATALOG cascade constraints
/


drop table ARCHSTUDY cascade constraints
/


/*==============================================================*/
/* Table: ARCHSTUDY                                             */
/*==============================================================*/


create table ARCHSTUDY  (
   STUDY_ID             NUMBER(10),
   STUDY_TYPE           VARCHAR2(20),
   STUDY_TITLE          VARCHAR2(50),
   STUDY_PRE            VARCHAR2(1000),
   STUDY_CONTENT        VARCHAR2(2000),
   STUDY_AUTHOR         VARCHAR2(20),
   STUDY_DATE           DATE,
   REMARK               VARCHAR2(200)
)
/


/*==============================================================*/
/* Table: BUILDING_CATALOG                                      */
/*==============================================================*/


create table BUILDING_CATALOG  (
   CATA_ID              NUMBER(10)                       not null,
   CATA_BEGINDATE       DATE,
   CATA_ORDER           VARCHAR2(20),
   CATA_CARDNUM         VARCHAR2(20),
   CATA_ADDRESS         VARCHAR2(100),
   CATA_AREA            VARCHAR2(20),
   CATA_ARKNUM          VARCHAR2(20),
   CATA_UNIT            VARCHAR2(100),
   CATA_ITEM            VARCHAR2(50),
   CATA_MAPNUM          VARCHAR2(20),
   CATA_LEVEL           VARCHAR2(20),
   CATA_STRUTS          VARCHAR2(20),
   CATA_ENDDATE         DATE,
   REMARK               VARCHAR2(200),
   constraint PK_BUILDING_CATALOG primary key (CATA_ID)
)
/


/*==============================================================*/
/* Table: CHARGE_STANDARD                                       */
/*==============================================================*/


create table CHARGE_STANDARD  (
   CHARGE_ID            NUMBER(10)                       not null,
   SENTRYID             NUMBER(10)                       not null,
   CHARGE_MODE          VARCHAR2(20)                     not null,
   CHARGE_VERSION       NUMBER(4)                        not null,
   CHARGE_BEGIN_DATE    DATE                             not null,
   CHARGE_END_DATE      DATE,
   CHARGE_MONEY         NUMBER(10,2)                     not null,
   CHARGE_BASE          VARCHAR2(200),
   REMARK               VARCHAR2(500),
   constraint PK_CHARGE_STANDARD primary key (CHARGE_ID)
)
/


/*==============================================================*/
/* Table: CONTAINER                                             */
/*==============================================================*/


create table CONTAINER  (
   CONTAINER_ID         NUMBER(10)                       not null,
   CONTAINER_CODE       VARCHAR2(5)                      not null,
   CONTAINER_TYPE       VARCHAR2(20)                     not null,
   ROOM_CODE            VARCHAR2(20),
   CONTAINER_ROW        VARCHAR2(5),
   CONTAINER_SIDE       VARCHAR2(5),
   CONTAINER_COLUMN     VARCHAR2(5),
   REMARK               VARCHAR2(200),
   constraint PK_CONTAINER primary key (CONTAINER_ID)
)
/


/*==============================================================*/
/* Table: DATABASE                                              */
/*==============================================================*/


create table HGAM.DATABASE  (
   ID                   NUMBER(10)                       not null,
   DataName             VARCHAR2(50),
   TargetFileName       VARCHAR2(50),
   TargetFileAddress    VARCHAR2(200),
   OperationType        CHARACTER                        not null,
   OperationTime        TIMESTAMP,
   BackupType           CHARACTER,
   BackupValue          NUMBER(4),
   DatabaseID           NUMBER(10),
   Remark               VARCHAR2(100),
   constraint PK_DATABASE primary key (ID)
)
/


/*==============================================================*/
/* Table: EFORM_DEFINE                                          */
/*==============================================================*/


create table EFORM_DEFINE  (
   EFORM_ID             NUMBER(10)                       not null,
   EFORM_NAME           VARCHAR2(100),
   EFORM_VERSION        NUMBER(4),
   EFORM_BEGIN_DATE     DATE,
   EFORM_END_DATE       DATE,
   ENTRY_ID             VARCHAR2(200),
   REMARK               VARCHAR2(500),
   constraint PK_EFORM_DEFINE primary key (EFORM_ID)
)
/


/*==============================================================*/
/* Table: Entry                                                 */
/*==============================================================*/


create table Entry  (
   Entry_ID             NUMBER(10)                       not null,
   Father_Entry_ID      NUMBER(10),
   Entry_Level          VARCHAR2(1)                      not null,
   Entry_Name           VARCHAR2(40)                     not null,
   ISOPERATION          VARCHAR2(1)                      not null,
   IS_CHARGE            CHAR(1),
   Remark               VARCHAR2(200),
   constraint PK_ENTRY primary key (Entry_ID),
   constraint FK_ENTRY_REFERENCE_ENTRY foreign key (Father_Entry_ID)
         references Entry (Entry_ID)
)
/


/*==============================================================*/
/* Table: FIELD_TYPE                                            */
/*==============================================================*/


create table FIELD_TYPE  (
   FIELD_TYPE_ID        NUMBER(4)                        not null,
   FIELD_TYPE_ENAME     VARCHAR2(40),
   FIELD_TYPE_CNAME     VARCHAR2(40),
   constraint PK_FIELD_TYPE primary key (FIELD_TYPE_ID)
)
/


comment on table FIELD_TYPE is
'字符型－VARCHAR2
数字型－NUMBER
日期型－DATE'
/


/*==============================================================*/
/* Table: "GROUP"                                               */
/*==============================================================*/


create table HGAM."GROUP"  (
   ID                   NUMBER(10)                       not null,
   NAME                 VARCHAR2(100)                    not null,
   DESCRIPTION          VARCHAR2(400),
   GROUP_CREATE_DATE    DATE                             not null,
   GROUP_MODIFIED_DATE  DATE,
   TYPE                 NUMBER(4),
   REMARK               VARCHAR2(200),
   ISDELETE             NUMBER(4),
   constraint A_GROUPID primary key (ID)
)
/


/*==============================================================*/
/* Table: LAW                                                   */
/*==============================================================*/


create table LAW  (
   LAW_ID               NUMBER(10)                       not null,
   LAW_Type             VARCHAR2(20)                     not null,
   LAW_Code             VARCHAR2(50),
   LAW_Dept             VARCHAR2(100),
   LAW_Title            VARCHAR2(100),
   LAW_Date             DATE,
   LAW_Content          VARCHAR2(2000),
   Remark               VARCHAR2(200),
   constraint PK_LAW primary key (LAW_ID)
)
/


/*==============================================================*/
/* Table: ORGANIZATION                                          */
/*==============================================================*/


create table HGAM.ORGANIZATION  (
   ID                   NUMBER(10)                       not null,
   NAME                 VARCHAR2(127),
   TYPE                 NUMBER(4)                      default 1,
   SYSPRIVILEGE         VARCHAR2(128),
   ISDELETE             Number(4)                      default 0  not null,
   DESCRIPTION          VARCHAR2(200),
   constraint PK_ORGANIZATION primary key (ID)
)
/


/*==============================================================*/
/* Table: ORGORG                                                */
/*==============================================================*/


create table HGAM.ORGORG  (
   ORGID                NUMBER(10)                       not null,
   SUBORGID             NUMBER(10)                       not null,
   constraint PK_ORGORG primary key (ORGID, SUBORGID),
   constraint FK_ORGORG_REFERENCE_ORGANIZA2 foreign key (ORGID)
         references HGAM.ORGANIZATION (ID),
   constraint FK_ORGORG_REFERENCE_ORGANIZA foreign key (SUBORGID)
         references HGAM.ORGANIZATION (ID)
)
/


/*==============================================================*/
/* Table: OTHER_CATALOG                                         */
/*==============================================================*/


create table OTHER_CATALOG  (
   CATALOG_ID           NUMBER(10)                       not null,
   CATA_DATE            DATE,
   CATA_NUM             VARCHAR2(20),
   CATA_UNIT            VARCHAR2(50),
   CATA_ADDRESS         VARCHAR2(100),
   CATA_ITEM            VARCHAR2(50),
   CATA_BUILD           VARCHAR2(100),
   CATA_SEC             VARCHAR2(20),
   CATA_VALUE           VARCHAR2(20),
   CATA_CARDDATE        DATE,
   CATA_CARDNUM         VARCHAR2(20),
   CATA_MAN             VARCHAR2(20),
   CATA_AREA            VARCHAR2(20),
   REMARK               VARCHAR2(200),
   constraint PK_OTHER_CATALOG primary key (CATALOG_ID)
)
/


/*==============================================================*/
/* Table: OperationUrl                                          */
/*==============================================================*/


create table hgam.OperationUrl  (
   operID               NUMBER(10)                       not null,
   operCode             VARCHAR2(20),
   url                  VARCHAR2(255)                    not null,
   operDesc             VARCHAR2(500),
   isLog                CHAR(1)                          not null,
   remark               VARCHAR2(200),
   constraint PK_OPERATIONURL primary key (operID)
)
/


/*==============================================================*/
/* Table: PERMISSION                                            */
/*==============================================================*/


create table HGAM.PERMISSION  (
   PERMISSION_ID        NUMBER(10)                       not null,
   FATHER_PERMISSION_ID NUMBER(10),
   PERMISSION_CODE      VARCHAR2(20)                     not null,
   PERMISSION_NAME      VARCHAR2(100)                    not null,
   PERMISSION_LEVEL     VARCHAR2(5)                      not null,
   PERMISSION_TYPE      CHAR(1)                          not null,
   constraint A_PERMID primary key (PERMISSION_ID),
   constraint FK_PERMISSI_REFERENCE_PERMISSI foreign key (FATHER_PERMISSION_ID)
         references HGAM.PERMISSION (PERMISSION_ID)
)
/


/*==============================================================*/
/* Table: PROJECT_PHASE                                         */
/*==============================================================*/


create table PROJECT_PHASE  (
   PHASE_ID             NUMBER(4)                        not null,
   PHASE_NAME           VARCHAR2(100)                    not null,
   REMARK               VARCHAR2(200),
   constraint PK_PROJECT_PHASE primary key (PHASE_ID)
)
/


/*==============================================================*/
/* Table: PUBLISH_INFO                                          */
/*==============================================================*/


create table PUBLISH_INFO  (
   INFO_ID              NUMBER(10)                       not null,
   INFO_TYPE            VARCHAR2(20),
   INFO_TITLE           VARCHAR2(200),
   INFO_CONTENT         VARCHAR2(3000),
   INFO_IS_OUT          CHAR(1),
   INFO_PUBLISH_PERSON  VARCHAR2(100),
   INFO_PUBLISH_DATETIME DATE,
   INFO_FEEDBACK_CONTENT VARCHAR2(3000),
   INFO_FEEDBACK_PERSON VARCHAR2(100),
   INFO_FEEDBACK_DATETIME DATE,
   INFO_IS_CONFIRM      CHAR(1),
   INFO_CONFIRM_IDEA    VARCHAR2(200),
   INFO_CONFIRM_PERSON  VARCHAR2(100),
   INFO_CONFIRM_DATETIME DATE,
   INFO_STATUS          CHAR(1),
   REMARK               VARCHAR2(200),
   constraint PK_PUBLISH_INFO primary key (INFO_ID)
)
/


/*==============================================================*/
/* Table: PUBLISH_INFO_ACCESSORY                                */
/*==============================================================*/


create table PUBLISH_INFO_ACCESSORY  (
   ACCESSORY_ID         NUMBER(10)                       not null,
   INFO_ID              NUMBER(10)                       not null,
   ACCESSORY_TITLE      VARCHAR2(200),
   ACCESSORY_FILENAME   VARCHAR2(200),
   REMARK               VARCHAR2(200),
   constraint PK_PUBLISH_INFO_ACCESSORY primary key (ACCESSORY_ID),
   constraint FK_PUBLISH__REFERENCE_PUBLISH_ foreign key (INFO_ID)
         references PUBLISH_INFO (INFO_ID)
)
/


/*==============================================================*/
/* Table: RUNTIME_LOG                                           */
/*==============================================================*/


create table RUNTIME_LOG  (
   LOG_ID               NUMBER(10)                       not null,
   OPERATION_ID         NUMBER(10)                       not null,
   OPERATION_RESULT     VARCHAR2(30)                     not null,
   LOG_MESSAGE          VARCHAR2(500),
   LOG_TIME             DATE                             not null,
   REMARK               VARCHAR2(100),
   constraint PK_RUNTIME_LOG primary key (LOG_ID)
)
/


/*==============================================================*/
/* Table: SAFETY                                                */
/*==============================================================*/


create table SAFETY  (
   SAFETY_ID            NUMBER(10)                       not null,
   ROOM_CODE            VARCHAR2(20),
   SAFETY_TYPE          VARCHAR2(20)                     not null,
   SAFETY_SITUATION     VARCHAR2(200),
   SAFETY_CHECKER       VARCHAR2(20),
   SAFETY_CHECKDATE     DATE,
   SAFETY_DEALWITHPERSON VARCHAR2(20),
   SAFETY_DEALEDDATE    DATE,
   SAFETY_RESULT        VARCHAR2(50),
   REMARK               VARCHAR2(200),
   constraint PK_SAFETY primary key (SAFETY_ID)
)
/


/*==============================================================*/
/* Table: SECRET                                                */
/*==============================================================*/


create table SECRET  (
   SECRET_ID            NUMBER(10)                       not null,
   SECRET_Code          VARCHAR2(20),
   SECRET_Name          VARCHAR2(20)                     not null,
   Remark               VARCHAR2(200),
   constraint PK_SECRET primary key (SECRET_ID)
)
/


/*==============================================================*/
/* Table: SUBROLLCATALOG                                        */
/*==============================================================*/


create table SUBROLLCATALOG  (
   ROLLCATA_ID          NUMBER(10)                       not null,
   Sub_Code             VARCHAR2(5),
   ROLLCATA_TITLE       VARCHAR2(50)                     not null,
   ROLLCATA_MEGNUM      VARCHAR2(50),
   ROLLCATA_DATE        VARCHAR2(50),
   ROLLCATA_STORETIME   VARCHAR2(20),
   REMARK               VARCHAR2(200),
   constraint PK_SUBROLLCATALOG primary key (ROLLCATA_ID)
)
/


/*==============================================================*/
/* Table: SysParam                                              */
/*==============================================================*/


create table hgam.SysParam  (
   SysParam_ID          NUMBER(10)                       not null,
   SysParam_type        VARCHAR2(20)                     not null,
   SysParam_Name        VARCHAR2(50)                     not null,
   SysParam_VALUE       VARCHAR2(100)                    not null,
   remark               VARCHAR2(200),
   constraint PK_SYSPARAM primary key (SysParam_ID)
)
/


/*==============================================================*/
/* Table: TEMPERATURE                                           */
/*==============================================================*/


create table TEMPERATURE  (
   TEMPERATURE_ID       NUMBER(10)                       not null,
   ROOM_CODE            VARCHAR2(20),
   TEMPERATURE_DEGREE   NUMBER(10,2),
   TEMPERATURE_WET      VARCHAR2(5),
   TEMPERATURE_DATE     DATE,
   TEMPERATURE_MAN      VARCHAR2(20),
   REMARK               VARCHAR2(200),
   constraint PK_TEMPERATURE primary key (TEMPERATURE_ID)
)
/


/*==============================================================*/
/* Table: THEME                                                 */
/*==============================================================*/


create table HGAM.THEME  (
   THEME_ID             NUMBER(10)                       not null,
   THEME_NAME           VARCHAR2(40)                     not null,
   THEME_MESSAGE        VARCHAR2(500),
   THEME_CODE           VARCHAR2(20),
   REMARK               VARCHAR2(100),
   constraint A_THEMEID primary key (THEME_ID)
)
/


/*==============================================================*/
/* Table: USERS                                                 */
/*==============================================================*/


create table HGAM.USERS  (
   ID                   NUMBER(10)                       not null,
   LOGINNAME            VARCHAR2(30)                     not null,
   PASSWORD             VARCHAR2(50)                     not null,
   NAME                 VARCHAR2(20),
   department           VARCHAR2(100),
   EMAIL                VARCHAR2(50),
   USER_ACCESS_TIMES    NUMBER(10),
   USER_LAST_ACCESS_DATE DATE,
   USER_CREATE_DATE     DATE,
   USER_LAST_MODIFIED_DATE DATE,
   DESCRIPTION          VARCHAR2(200),
   TYPE                 NUMBER(4)                      default 1,
   ISDELETE             NUMBER(4)                      default 0  not null,
   ISONLINE             NUMBER(4)                      default 0  not null,
   SYSPRIVILEGE         VARCHAR2(128),
   ROLEID               NUMBER(10),
   constraint PK_USERS primary key (ID),
   constraint FK_USERS_REFERENCE_GROUP foreign key (ROLEID)
         references HGAM."GROUP" (ID)
)
/


/*==============================================================*/
/* Table: USER_PERMISSION                                       */
/*==============================================================*/


create table HGAM.USER_PERMISSION  (
   USER_ID              NUMBER(10)                       not null,
   PERMISSION_ID        NUMBER(10)                       not null,
   PERMISSION_TYPE      CHAR(1)                          not null,
   constraint A_USERPERMPK primary key (USER_ID, PERMISSION_ID),
   constraint F_REFERENCE_USERID foreign key (USER_ID)
         references HGAM.USERS (ID),
   constraint F_REFERENCE_USERPE foreign key (PERMISSION_ID)
         references HGAM.PERMISSION (PERMISSION_ID)
)
/


/*==============================================================*/
/* Table: UTILIZE_MODE                                          */
/*==============================================================*/


create table UTILIZE_MODE  (
   MODE_ID              NUMBER(4)                        not null,
   MODE_NAME            VARCHAR2(20),
   REMARK               VARCHAR2(200),
   constraint PK_UTILIZE_MODE primary key (MODE_ID)
)
/


comment on table UTILIZE_MODE is
'原件、二次信息、出具证明、复制、电子文档'
/


/*==============================================================*/
/* Table: UTILIZE_PERSON                                        */
/*==============================================================*/


create table UTILIZE_PERSON  (
   PERSON_ID            NUMBER(10)                       not null,
   PERSON_NAME          VARCHAR2(40)                     not null,
   PERSON_CORP          VARCHAR2(128),
   PERSON_TEL           VARCHAR2(40),
   PERSON_ADDRESS       VARCHAR2(200),
   CERTIFICATE_TYPE     VARCHAR2(10),
   CERTIFICATE_NUM      VARCHAR2(30),
   REMARK               VARCHAR2(128),
   constraint PK_UTILIZE_PERSON primary key (PERSON_ID)
)
/


/*==============================================================*/
/* Table: UTILIZE_TYPE                                          */
/*==============================================================*/


create table UTILIZE_TYPE  (
   TYPE_ID              NUMBER(4)                        not null,
   TYPE_NAME            VARCHAR2(20),
   REMARK               VARCHAR2(200),
   constraint PK_UTILIZE_TYPE primary key (TYPE_ID)
)
/


comment on table UTILIZE_TYPE is
'查阅、借阅、补证'
/


/*==============================================================*/
/* Table: WHOLEDOSSIER                                          */
/*==============================================================*/


create table WHOLEDOSSIER  (
   WHOLEDOSSIER_ID      NUMBER(10)                       not null,
   WHOLEDOSSIER_TYPE    VARCHAR2(2)                      not null,
   WHOLEDOSSIER_YEAR    VARCHAR2(4)                      not null,
   WHOLEDOSSIER_Name    VARCHAR2(200)                    not null,
   WHOLEDOSSIER_MakeMan VARCHAR2(20),
   WHOLEDOSSIER_MakeDate DATE,
   WHOLEDOSSIER_Content VARCHAR2(4000),
   REMARK               VARCHAR2(200),
   constraint PK_WHOLEDOSSIER primary key (WHOLEDOSSIER_ID)
)
/


/*==============================================================*/
/* Table: Watch_Examine                                         */
/*==============================================================*/


create table Watch_Examine  (
   Watch_ID             NUMBER(10)                       not null,
   Sub_Code             VARCHAR2(5),
   Watch_TITLE          VARCHAR2(100)                    not null,
   Watch_CONTENT        VARCHAR2(2000),
   Watch_TIME           DATE,
   Watch_AUTHOR         VARCHAR2(20),
   Remark               VARCHAR2(200),
   constraint PK_WATCH_EXAMINE primary key (Watch_ID)
)
/


/*==============================================================*/
/* Table: YEARREG                                               */
/*==============================================================*/


create table YEARREG  (
   REGYEARID            NUMBER(10)                       not null,
   REGYEAR              VARCHAR2(5)                      not null,
   REGDATE              DATE,
   REGMAN               VARCHAR2(20),
   OFFICEAREA           VARCHAR2(20),
   ROOMAREA             VARCHAR2(20),
   REMARK               VARCHAR2(200),
   constraint PK_YEARREG primary key (REGYEARID)
)
/


/*==============================================================*/
/* Table: YEARREPORT                                            */
/*==============================================================*/


create table YEARREPORT  (
   YEARREPORTID         NUMBER(10)                       not null,
   REGYEARID            NUMBER(10)                       not null,
   UNITINTRO            VARCHAR2(1000),
   WORKINTRO            VARCHAR2(1000),
   LAWINTRO             VARCHAR2(1000),
   WORKEXP              VARCHAR2(1000),
   REMARK               VARCHAR2(200),
   constraint PK_YEARREPORT primary key (YEARREPORTID),
   constraint FK_YEARREPO_REFERENCE_YEARREG foreign key (REGYEARID)
         references YEARREG (REGYEARID)
)
/


/*==============================================================*/
/* Table: FIELD_DEFINE                                          */
/*==============================================================*/


create table FIELD_DEFINE  (
   FIELD_ID             NUMBER(10)                       not null,
   FIELD_TYPE_ID        NUMBER(4),
   FIELD_CNAME          VARCHAR2(200),
   FIELD_ENAME          VARCHAR2(100),
   FIELD_LEN            NUMBER(4),
   FIELD_ISNULL         CHAR(1),
   FIELD_ISBRIEF        CHAR(1),
   constraint PK_FIELD_DEFINE primary key (FIELD_ID),
   constraint FK_FIELD_DE_REFERENCE_FIELD_TY foreign key (FIELD_TYPE_ID)
         references FIELD_TYPE (FIELD_TYPE_ID)
)
/


/*==============================================================*/
/* Table: SUBFILECATALOG                                        */
/*==============================================================*/


create table SUBFILECATALOG  (
   FILECATA_ID          NUMBER(10)                       not null,
   ROLLCATA_ID          NUMBER(10)                       not null,
   FILECATA_NAME        VARCHAR2(50),
   FILECATA_MAN         VARCHAR2(20),
   FILECATA_TITLE       VARCHAR2(100)                    not null,
   FILECATA_DATE        DATE,
   FILECATA_PAGE        VARCHAR2(10),
   REMARK               VARCHAR2(200),
   constraint PK_SUBFILECATALOG primary key (FILECATA_ID),
   constraint FK_SUBFILEC_REFERENCE_SUBROLLC foreign key (ROLLCATA_ID)
         references SUBROLLCATALOG (ROLLCATA_ID)
)
/


/*==============================================================*/
/* Table: GROUP_PERMISSION                                      */
/*==============================================================*/


create table HGAM.GROUP_PERMISSION  (
   GROUP_ID             NUMBER(10)                       not null,
   PERMISSION_ID        NUMBER(10)                       not null,
   PERMISSION_TYPE      CHAR(1)                          not null,
   constraint A_GROUPPERMPK primary key (GROUP_ID, PERMISSION_ID),
   constraint F_GROUPID foreign key (GROUP_ID)
         references HGAM."GROUP" (ID),
   constraint F_PERMID foreign key (PERMISSION_ID)
         references HGAM.PERMISSION (PERMISSION_ID)
)
/


/*==============================================================*/
/* Table: ARCHIVES                                              */
/*==============================================================*/


create table ARCHIVES  (
   ARCHIVES_ID          NUMBER(10)                       not null,
   REF_ARCHIVES_ID      NUMBER(10),
   ENTRY_ID             NUMBER(10)                       not null,
   CONTAINER_ID         NUMBER(10),
   SECRET_ID            NUMBER(10),
   FONDS_NUM            VARCHAR2(4),
   CATALOG_NUM          VARCHAR2(6),
   ROLL_NUM             NUMBER(10),
   PIECE_NUM            NUMBER(10),
   ARC_PIECE_NUM        NUMBER(10),
   ARCHIVES_NUM         VARCHAR2(20),
   ARC_NUM              VARCHAR2(20),
   ARC_DATE             VARCHAR2(20),
   ARCHIVES_ROOM_CODE   VARCHAR2(20),
   ROLL_MODE            VARCHAR2(20)                     not null,
   MAKE_DATE            DATE,
   MAKE_MAN             VARCHAR2(20),
   REDUCE_NUM           VARCHAR2(20),
   ITEM_NUM             VARCHAR2(20),
   REG_NUM              VARCHAR2(20),
   ARCHIVES_STATUS      VARCHAR2(20)                     not null,
   ARCHIVES_TYPE        VARCHAR2(20),
   ARCHIVES_CONTENT     VARCHAR2(150),
   ARCHIVES_YEAR        VARCHAR2(4),
   ARCHIVES_NAME        VARCHAR2(150),
   PROJ_ID              VARCHAR2(100),
   PROJ_NAME            VARCHAR2(400),
   BEGIN_DATE           VARCHAR2(20),
   END_DATE             VARCHAR2(20),
   ORGAN                VARCHAR2(40),
   STORE_TERM           VARCHAR2(4),
   ARCHIVES_FOUND_DATE  VARCHAR2(20),
   ARCHIVES_FOUND_UNIT  VARCHAR2(100),
   ARCHIVES_FOUND_MAN   VARCHAR2(10),
   ARCHIVES_MAKE_UNIT   VARCHAR2(100),
   ARCHIVES_MAKE_PERIOD VARCHAR2(30),
   ARCHIVES_UNIT        VARCHAR2(20),
   ARCHIVES_AMOUNT      VARCHAR2(20),
   SPECIFICATION        VARCHAR2(20),
   PAGE_AMOUNT          VARCHAR2(20),
   PAGE_NUM_FROM_TO     VARCHAR2(20),
   ROLL_AMOUNT          NUMBER(4),
   ROLL_SEQ             NUMBER(4),
   MEDIA_TYPE           VARCHAR2(20),
   PHOTO_NUM            VARCHAR2(10),
   NEGATIVE_NUM         VARCHAR2(10),
   IS_BORROW            CHAR(1),
   IS_CHANGE            CHAR(1),
   IS_PRIVATE           CHAR(1),
   IS_OPERATION         CHAR(1),
   OPER_ID              VARCHAR2(20),
   REMARK               VARCHAR2(500),
   constraint PK_ARCHIVES primary key (ARCHIVES_ID),
   constraint FK_ARCHIVES_REFERENCE_ENTRY foreign key (ENTRY_ID)
         references Entry (Entry_ID),
   constraint FK_ARCHIVES_REFERENCE_CONTAINE foreign key (CONTAINER_ID)
         references CONTAINER (CONTAINER_ID),
   constraint FK_ARCHIVES_REFERENCE_ARCHIVE2 foreign key (REF_ARCHIVES_ID)
         references ARCHIVES (ARCHIVES_ID),
   constraint FK_ARCHIVES_REFERENCE_SECRET2 foreign key (SECRET_ID)
         references SECRET (SECRET_ID)
)
/


/*==============================================================*/
/* Table: OPERATION_LOG                                         */
/*==============================================================*/


create table HGAM.OPERATION_LOG  (
   LogID                NUMBER(10)                       not null,
   UserID               NUMBER(10),
   operID               NUMBER(10),
   UserName             VARCHAR2(30)                     not null,
   IP                   VARCHAR2(30)                     not null,
   ResultCode           VARCHAR2(100),
   LogMsg               VARCHAR2(500),
   Type                 CHAR(1)                          not null,
   OccurTime            DATE                             not null,
   REMARK               VARCHAR2(200),
   constraint PK_OPERATION_LOG primary key (LogID),
   constraint FK_OPERATIO_REFERENCE_USERS foreign key (UserID)
         references HGAM.USERS (ID),
   constraint FK_OPERATIO_REFERENCE_OPERATIO foreign key (operID)
         references OperationUrl (operID)
)
/


comment on column HGAM.OPERATION_LOG.Type is
'1：用户操作；2：系统日志'
/


/*==============================================================*/
/* Table: DATA_FILE                                             */
/*==============================================================*/


create table DATA_FILE  (
   DATA_FILE_ID         NUMBER(10)                       not null,
   Entry_ID             NUMBER(10),
   DATA_FILE_NUM        VARCHAR2(30),
   DATA_FILE_MAKE_DATE  DATE,
   DATA_FILE_NAME       VARCHAR2(500),
   DATA_FILE_AUTHOR     VARCHAR2(100),
   DATA_FILE_PRESS      VARCHAR2(200),
   DATA_FILE_PUBLISH_DATE DATE,
   REMARK               VARCHAR2(200),
   constraint PK_DATA_FILE primary key (DATA_FILE_ID),
   constraint FK_DATA_FIL_REFERENCE_ENTRY foreign key (Entry_ID)
         references Entry (Entry_ID)
)
/


/*==============================================================*/
/* Table: UTILIZE_APPLY                                         */
/*==============================================================*/


create table UTILIZE_APPLY  (
   APPLY_ID             NUMBER(10)                       not null,
   PERSON_ID            NUMBER(10),
   USER_ID              NUMBER(10),
   TYPE_ID              NUMBER(4),
   MODE_ID              NUMBER(4),
   FLOW_ID              NUMBER(10),
   AIM                  VARCHAR2(500),
   IS_SELFORG           CHAR(1),
   IS_RENEW             CHAR(1),
   BEGIN_DATE           DATE,
   UTILIZE_TERM         NUMBER(8),
   REAL_RETURN_DATE     DATE,
   APPLY_DATE           DATE,
   REAL_GET_MONEY       NUMBER(10,2),
   HANDLE_MAN           NUMBER(10),
   HANDLE_IDEA          VARCHAR2(20),
   HANDLE_DATE          DATE,
   LATEST_RENEW_DATE    DATE,
   LATEST_DUN_DATE      DATE,
   UTILIZE_STATUS       VARCHAR2(20)                     not null,
   REMARK               VARCHAR2(500),
   constraint PK_UTILIZE_APPLY primary key (APPLY_ID),
   constraint FK_UTILIZE__REFERENCE_UTILIZE3 foreign key (TYPE_ID)
         references UTILIZE_TYPE (TYPE_ID),
   constraint FK_UTILIZE__REFERENCE_UTILIZE4 foreign key (MODE_ID)
         references UTILIZE_MODE (MODE_ID),
   constraint FK_UTILIZE__REFERENCE_UTILIZE5 foreign key (PERSON_ID)
         references UTILIZE_PERSON (PERSON_ID),
   constraint FK_UTILIZE__REFERENCE_USERS2 foreign key (HANDLE_MAN)
         references HGAM.USERS (ID),
   constraint FK_UTILIZE__REFERENCE_USERS3 foreign key (USER_ID)
         references HGAM.USERS (ID)
)
/


/*==============================================================*/
/* Table: UTILIZE_CONFIRM                                       */
/*==============================================================*/


create table UTILIZE_CONFIRM  (
   CONFIRM_ID           NUMBER(10)                       not null,
   APPLY_ID             NUMBER(10),
   IS_AGREE             CHAR(1),
   STATUS               VARCHAR2(20),
   CONFIRM_USER_ID      NUMBER(10),
   CONFIRM_DATE         DATE,
   CONFIRM_IDEA         VARCHAR2(500),
   TASK_ID              NUMBER(10),
   REMARK               VARCHAR2(200),
   constraint PK_UTILIZE_CONFIRM primary key (CONFIRM_ID),
   constraint FK_UTILIZE__REFERENCE_UTILIZE_ foreign key (APPLY_ID)
         references UTILIZE_APPLY (APPLY_ID),
   constraint FK_UTILIZE__REFERENCE_USERS foreign key (CONFIRM_USER_ID)
         references HGAM.USERS (ID)
)
/


/*==============================================================*/
/* Table: ORGROLEUSER                                           */
/*==============================================================*/


create table HGAM.ORGROLEUSER  (
   USERID               NUMBER(10),
   ORGID                NUMBER(10),
   ROLEID               NUMBER(10),
   constraint FK_ORGROLEU_REFERENCE_USERS foreign key (USERID)
         references HGAM.USERS (ID),
   constraint FK_ORGROLEU_REFERENCE_ORGANIZA foreign key (ORGID)
         references HGAM.ORGANIZATION (ID),
   constraint FK_ORGROLEU_REFERENCE_GROUP foreign key (ROLEID)
         references HGAM."GROUP" (ID)
)
/


/*==============================================================*/
/* Table: ARCHIVES_BEIKAO                                       */
/*==============================================================*/


create table ARCHIVES_BEIKAO  (
   BEIKAO_ID            NUMBER(10)                       not null,
   ARCHIVES_ID          NUMBER(10),
   ALL_PAGE_COUNT       VARCHAR2(20),
   FILE_PAGE_COUNT      VARCHAR2(20),
   PIC_PAGE_COUNT       VARCHAR2(20),
   MAKE_MAN             VARCHAR2(20),
   MAKE_DATE            DATE,
   constraint PK_ARCHIVES_BEIKAO primary key (BEIKAO_ID),
   constraint FK_ARCHIVES_REFERENCE_ARCHIVES foreign key (ARCHIVES_ID)
         references ARCHIVES (ARCHIVES_ID)
)
/


/*==============================================================*/
/* Table: WATCHEXAMINE_DENOTE                                   */
/*==============================================================*/


create table WATCHEXAMINE_DENOTE  (
   DENOTE_ID            NUMBER(10)                       not null,
   Watch_ID             NUMBER(10),
   DENOTE_TITLE         VARCHAR2(50),
   DENOTE_CONTENT       VARCHAR2(200),
   DENOTE_SUPERINRTENDENT VARCHAR2(20),
   LEADSHIPER_SIGNATURE VARCHAR2(20),
   DENOTE_DATE          DATE,
   constraint PK_WATCHEXAMINE_DENOTE primary key (DENOTE_ID),
   constraint FK_WATCHEXA_REFERENCE_WATCH_EX foreign key (Watch_ID)
         references Watch_Examine (Watch_ID)
)
/


/*==============================================================*/
/* Table: EFORM_FIELD                                           */
/*==============================================================*/


create table EFORM_FIELD  (
   EFORM_ID             NUMBER(10),
   FIELD_ID             NUMBER(10),
   FIELD_SEQ            NUMBER(4),
   FIELD_ISEDIT         CHAR(1),
   constraint FK_EFORM_FI_REFERENCE_EFORM_DE foreign key (EFORM_ID)
         references EFORM_DEFINE (EFORM_ID),
   constraint FK_EFORM_FI_REFERENCE_FIELD_DE foreign key (FIELD_ID)
         references FIELD_DEFINE (FIELD_ID)
)
/


/*==============================================================*/
/* Table: YEARFORM                                              */
/*==============================================================*/


create table YEARFORM  (
   YEARFORMID           NUMBER(10)                       not null,
   REGYEARID            NUMBER(10)                       not null,
   ARCHTYPE             VARCHAR2(20)                     not null,
   ROLL                 VARCHAR2(10),
   PHOTO                VARCHAR2(20),
   MAP                  VARCHAR2(20),
   RECORD               VARCHAR2(20),
   FOREVER              VARCHAR2(20),
   "LONG"               VARCHAR2(20),
   SHORT                VARCHAR2(20),
   COPYARCH             VARCHAR2(20),
   USEMAN               VARCHAR2(20),
   USENUM               VARCHAR2(20),
   SENDARCH             VARCHAR2(20),
   RECEIVEARCH          VARCHAR2(20),
   REMARK               VARCHAR2(200),
   constraint PK_YEARFORM primary key (YEARFORMID),
   constraint FK_YEARFORM_REFERENCE_YEARREG foreign key (REGYEARID)
         references YEARREG (REGYEARID)
)
/


/*==============================================================*/
/* Table: EXP_IMP_REGISTER                                      */
/*==============================================================*/


create table EXP_IMP_REGISTER  (
   REGISTER_ID          NUMBER(10)                       not null,
   APPLY_ID             NUMBER(10),
   REGISTER_MAN         NUMBER(10),
   REGISTER_DATE        DATE,
   REGISTER_FLAG        CHAR(1),
   REMARK               VARCHAR2(200),
   constraint PK_EXP_IMP_REGISTER primary key (REGISTER_ID),
   constraint FK_EXP_IMP__REFERENCE_UTILIZE_ foreign key (APPLY_ID)
         references UTILIZE_APPLY (APPLY_ID),
   constraint FK_EXP_IMP__REFERENCE_USERS foreign key (REGISTER_MAN)
         references HGAM.USERS (ID)
)
/


/*==============================================================*/
/* Table: ARCHIVES_FILE                                         */
/*==============================================================*/


create table ARCHIVES_FILE  (
   FILE_ID              NUMBER(10)                       not null,
   EFORM_ID             NUMBER(10),
   PHASE_ID             NUMBER(4),
   UP_PHASE_ID          NUMBER(4),
   ACCEPT_ID            VARCHAR2(30),
   PARENT_FILE_ID       NUMBER(10),
   ARCHIVES_ID          NUMBER(10),
   SECRET_ID            NUMBER(10),
   PROJ_ID              VARCHAR2(100),
   PROJ_NAME            VARCHAR2(400),
   FILE_NUM             VARCHAR2(100),
   FILE_TITLE           VARCHAR2(400),
   FILE_DUTY            VARCHAR2(200),
   FILE_DATE            VARCHAR2(20),
   FILE_PAGE_AMOUNT     NUMBER(4),
   PAGE_NUM_FROM_TO     VARCHAR2(20),
   FILE_PAGE_SEQ        NUMBER(4),
   FILE_TYPE            VARCHAR2(10),
   FILE_KEYWORDS        VARCHAR2(100),
   FILE_SEQ             NUMBER(4),
   FILE_STORE_TERM      VARCHAR2(8),
   FILE_SPEC            VARCHAR2(20),
   MEDIA_TYPE           VARCHAR2(20),
   FILE_COUNT           NUMBER(4),
   FILE_GET_DATE        DATE,
   FILE_GET_FORWARD     VARCHAR2(200),
   FILE_GET_PERSON      VARCHAR2(20),
   FILE_TO_UNIT         VARCHAR2(200),
   FILE_TO_FORWARD      VARCHAR2(200),
   FILE_TO_CREATEBY     VARCHAR2(20),
   FILE_TO_SIGNBY       VARCHAR2(20),
   IS_PRIVATE           CHAR(1),
   IS_IDENTIFY          CHAR(1),
   IDENTIFY_RESULT      VARCHAR2(10),
   IS_BORROW            CHAR(1),
   IS_DESTROY           CHAR(1),
   FILE_STATUS          VARCHAR2(20),
   FILE_PATHNAME        VARCHAR2(200),
   REMARK               VARCHAR2(1000),
   constraint PK_ARCHIVES_FILE primary key (FILE_ID),
   constraint FK_ARCHIVES_REFERENCE_EFORM_DE foreign key (EFORM_ID)
         references EFORM_DEFINE (EFORM_ID),
   constraint FK_ARCHIVES_REFERENCE_PROJECT2 foreign key (PHASE_ID)
         references PROJECT_PHASE (PHASE_ID),
   constraint FK_ARCHIVES_REFERENCE_ARCHIVE4 foreign key (PARENT_FILE_ID)
         references ARCHIVES_FILE (FILE_ID),
   constraint FK_ARCHIVES_REFERENCE_ARCHIVE5 foreign key (ARCHIVES_ID)
         references ARCHIVES (ARCHIVES_ID),
   constraint FK_ARCHIVES_REFERENCE_SECRET foreign key (SECRET_ID)
         references SECRET (SECRET_ID),
   constraint FK_ARCHIVES_REFERENCE_PROJECT_ foreign key (UP_PHASE_ID)
         references PROJECT_PHASE (PHASE_ID)
)
/


/*==============================================================*/
/* Table: CHECKUP                                               */
/*==============================================================*/


create table CHECKUP  (
   CHECKUP_ID           NUMBER(10)                       not null,
   FILE_ID              NUMBER(10),
   CHECKUP_OPERATOR     VARCHAR2(20),
   CHECKUP_SITUATION    VARCHAR2(200),
   CHECKUP_DATE         DATE,
   REMARK               VARCHAR2(200),
   constraint PK_CHECKUP primary key (CHECKUP_ID),
   constraint FK_CHECKUP_REFERENCE_ARCHIVES foreign key (FILE_ID)
         references ARCHIVES_FILE (FILE_ID)
)
/


/*==============================================================*/
/* Table: ARCHIVES_PAGE                                         */
/*==============================================================*/


create table ARCHIVES_PAGE  (
   PAGE_ID              NUMBER(10)                       not null,
   FILE_ID              NUMBER(10),
   DATA_FILE_ID         NUMBER(10),
   PAGE_TYPE            VARCHAR2(20),
   PAGE_SIZE            VARCHAR2(5),
   PAGE_NUM             NUMBER(10),
   PAGE_DATE            DATE                             not null,
   PAGE_OPERATE         VARCHAR2(2),
   PAGE_AREA            VARCHAR2(30),
   PAGE_STATUS          VARCHAR2(6)                      not null,
   PAGE_PATHNAME        VARCHAR2(200)                    not null,
   REMARK               VARCHAR2(200),
   constraint PK_ARCHIVES_PAGE primary key (PAGE_ID),
   constraint FK_ARCHIVES_REFERENCE_ARCHIVE3 foreign key (FILE_ID)
         references ARCHIVES_FILE (FILE_ID),
   constraint FK_ARCHIVES_REFERENCE_DATA_FIL foreign key (DATA_FILE_ID)
         references DATA_FILE (DATA_FILE_ID)
)
/


/*==============================================================*/
/* Table: FIELD_VALUE                                           */
/*==============================================================*/


create table FIELD_VALUE  (
   VALUE_ID             NUMBER(10)                       not null,
   FILE_ID              NUMBER(10),
   FIELD_ID             NUMBER(10),
   FIELD_VALUE          VARCHAR2(1000),
   constraint PK_FIELD_VALUE primary key (VALUE_ID),
   constraint FK_FIELD_VA_REFERENCE_FIELD_DE foreign key (FIELD_ID)
         references FIELD_DEFINE (FIELD_ID),
   constraint FK_FIELD_VA_REFERENCE_ARCHIVES foreign key (FILE_ID)
         references ARCHIVES_FILE (FILE_ID)
)
/


/*==============================================================*/
/* Table: EXP_IMP_ARCHIVES                                      */
/*==============================================================*/


create table EXP_IMP_ARCHIVES  (
   REGISTER_ID          NUMBER(10)                       not null,
   ARCHIVES_ID          NUMBER(10),
   IS_FULL              CHAR(1),
   constraint PK_EXP_IMP_ARCHIVES primary key (REGISTER_ID),
   constraint FK_EXP_IMP__REFERENCE_ARCHIVES foreign key (ARCHIVES_ID)
         references ARCHIVES (ARCHIVES_ID),
   constraint FK_EXP_IMP__REFERENCE_EXP_IMP_ foreign key (REGISTER_ID)
         references EXP_IMP_REGISTER (REGISTER_ID)
)
/


/*==============================================================*/
/* Table: FILE_ASSOCIATE                                        */
/*==============================================================*/


create table FILE_ASSOCIATE  (
   FILE_ID              NUMBER(10)                       not null,
   REF_FILE_ID          NUMBER(10)                       not null,
   constraint PK_FILE_ASSOCIATE primary key (FILE_ID, REF_FILE_ID),
   constraint FK_FILE_ASS_REFERENCE_ARCHIVE2 foreign key (FILE_ID)
         references ARCHIVES_FILE (FILE_ID),
   constraint FK_FILE_ASS_REFERENCE_ARCHIVES foreign key (REF_FILE_ID)
         references ARCHIVES_FILE (FILE_ID)
)
/


/*==============================================================*/
/* Table: UTILIZE_DETAIL                                        */
/*==============================================================*/


create table UTILIZE_DETAIL  (
   APPLY_ID             NUMBER(10)                       not null,
   CHARGE_ID            NUMBER(10),
   FILE_ID              NUMBER(10),
   PAGE_ID              NUMBER(10),
   REMARK               VARCHAR2(200),
   constraint FK_UTILIZE__REFERENCE_UTILIZE2 foreign key (APPLY_ID)
         references UTILIZE_APPLY (APPLY_ID),
   constraint FK_UTILIZE__REFERENCE_CHARGE_S foreign key (CHARGE_ID)
         references CHARGE_STANDARD (CHARGE_ID),
   constraint FK_UTILIZE__REFERENCE_ARCHIVE2 foreign key (PAGE_ID)
         references ARCHIVES_PAGE (PAGE_ID),
   constraint FK_UTILIZE__REFERENCE_ARCHIVES foreign key (FILE_ID)
         references ARCHIVES_FILE (FILE_ID)
)
/


/*==============================================================*/
/* Table: DESTORY                                               */
/*==============================================================*/


create table DESTORY  (
   DESTORY_ID           NUMBER(10)                       not null,
   FILE_ID              NUMBER(10),
   DESTORY_OPERATOR     VARCHAR2(20),
   DESTORY_SUPERVISOR   VARCHAR2(20),
   DESTORY_SITUATION    VARCHAR2(200),
   DESTORY_DATE         DATE,
   DESTORY_PLACE        VARCHAR2(100),
   REMARK               VARCHAR2(200),
   constraint PK_DESTORY primary key (DESTORY_ID),
   constraint FK_DESTORY_REFERENCE_ARCHIVES foreign key (FILE_ID)
         references ARCHIVES_FILE (FILE_ID)
)
/


/*==============================================================*/
/* Table: METADATA                                              */
/*==============================================================*/


create table METADATA  (
   METADATA_ID          NUMBER(10)                       not null,
   ARCHIVES_ID          NUMBER(10),
   FILE_ID              NUMBER(10),
   PAGE_ID              NUMBER(10),
   METADATA_DATE        DATE                             not null,
   METADATA_PERSON      VARCHAR2(20),
   METADATA_CONTENT     VARCHAR2(2000)                   not null,
   REMARK               VARCHAR2(200),
   constraint PK_METADATA primary key (METADATA_ID),
   constraint FK_METADATA_REFERENCE_ARCHIVE2 foreign key (PAGE_ID)
         references ARCHIVES_PAGE (PAGE_ID),
   constraint FK_METADATA_REFERENCE_ARCHIVE3 foreign key (ARCHIVES_ID)
         references ARCHIVES (ARCHIVES_ID),
   constraint FK_METADATA_REFERENCE_ARCHIVES foreign key (FILE_ID)
         references ARCHIVES_FILE (FILE_ID)
)
/


