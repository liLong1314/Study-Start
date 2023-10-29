/*==============================================================*/
/* Database name:  PhysicalDataModel_1                          */
/* DBMS name:      ORACLE Version 9i                            */
/* Created on:     2004-03-02 16:47:04                          */
/* Created by:	   Zhengxq@sunyard.com                          */      
/* CopyRight:      Hangzhou Sunyard                             */
/*==============================================================*/


drop table EFORM_FIELD cascade constraints
/


drop table METADATA cascade constraints
/


drop table FILE_ASSOCIATE cascade constraints
/


drop table FIELD_VALUE cascade constraints
/


drop table ARCHIVES_PAGE cascade constraints
/


drop table ARCHIVES_FILE cascade constraints
/


drop table FIELD_DEFINE cascade constraints
/


drop table PROJECT_PHASE cascade constraints
/


drop table FIELD_TYPE cascade constraints
/


drop table EFORM_DEFINE cascade constraints
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
   REMARK               VARCHAR2(500),
   constraint PK_EFORM_DEFINE primary key (EFORM_ID)
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
/* Table: ARCHIVES_FILE                                         */
/*==============================================================*/


create table ARCHIVES_FILE  (
   FILE_ID              NUMBER(18)                       not null,
   PARENT_FILE_ID       NUMBER(18),
   EFORM_ID             NUMBER(10),
   PHASE_ID             NUMBER(4),
   UP_PHASE_ID          NUMBER(4),
   PROJ_ID              VARCHAR2(100),
   PROJ_NAME            VARCHAR2(400),
   ACCEPT_ID            VARCHAR2(20),
   FILE_NUM             VARCHAR2(40),
   FILE_TITLE           VARCHAR2(400),
   FILE_DUTY            VARCHAR2(200),
   FILE_DATE            DATE,
   FILE_PAGE_AMOUNT     NUMBER(4),
   FILE_TYPE            VARCHAR2(10),
   FILE_KEYWORDS        VARCHAR2(100),
   FILE_STATUS          CHAR(1),
   FILE_PATHNAME        VARCHAR2(200),
   REMARK               VARCHAR2(1000),
   constraint PK_ARCHIVES_FILE primary key (FILE_ID),
   constraint FK_ARCHIVES_REFERENCE_PROJECT2 foreign key (PHASE_ID)
         references PROJECT_PHASE (PHASE_ID),
   constraint FK_ARCHIVES_REFERENCE_EFORM_DE foreign key (EFORM_ID)
         references EFORM_DEFINE (EFORM_ID),
   constraint FK_ARCHIVES_REFERENCE_PROJECT_ foreign key (UP_PHASE_ID)
         references PROJECT_PHASE (PHASE_ID)
)
/


/*==============================================================*/
/* Table: ARCHIVES_PAGE                                         */
/*==============================================================*/


create table ARCHIVES_PAGE  (
   PAGE_ID              NUMBER(10)                       not null,
   FILE_ID              NUMBER(18),
   PAGE_TYPE            VARCHAR2(20),
   PAGE_NUM             NUMBER(10),
   PAGE_SIZE            VARCHAR2(5),
   PAGE_DATE            DATE,
   PAGE_PATHNAME        VARCHAR2(200),
   constraint PK_ARCHIVES_PAGE primary key (PAGE_ID),
   constraint FK_ARCHIVES_REFERENCE_ARCHIVE2 foreign key (FILE_ID)
         references ARCHIVES_FILE (FILE_ID)
)
/


/*==============================================================*/
/* Table: FIELD_VALUE                                           */
/*==============================================================*/


create table FIELD_VALUE  (
   VALUE_ID             NUMBER(10)                       not null,
   FILE_ID              NUMBER(18),
   FIELD_ID             NUMBER(10),
   FIELD_VALUE          VARCHAR2(3000),
   constraint PK_FIELD_VALUE primary key (VALUE_ID),
   constraint FK_FIELD_VA_REFERENCE_FIELD_DE foreign key (FIELD_ID)
         references FIELD_DEFINE (FIELD_ID),
   constraint FK_FIELD_VA_REFERENCE_ARCHIVES foreign key (FILE_ID)
         references ARCHIVES_FILE (FILE_ID)
)
/


/*==============================================================*/
/* Table: FILE_ASSOCIATE                                        */
/*==============================================================*/


create table FILE_ASSOCIATE  (
   FILE_ID              NUMBER(18)                       not null,
   REF_FILE_ID          NUMBER(18)                       not null,
   constraint PK_FILE_ASSOCIATE primary key (FILE_ID, REF_FILE_ID),
   constraint FK_FILE_ASS_REFERENCE_ARCHIVE2 foreign key (FILE_ID)
         references ARCHIVES_FILE (FILE_ID),
   constraint FK_FILE_ASS_REFERENCE_ARCHIVES foreign key (REF_FILE_ID)
         references ARCHIVES_FILE (FILE_ID)
)
/


/*==============================================================*/
/* Table: METADATA                                              */
/*==============================================================*/


create table METADATA  (
   METADATA_ID          NUMBER(10)                       not null,
   PAGE_ID              NUMBER(10),
   FILE_ID              NUMBER(18),
   METADATA_DATE        DATE                             not null,
   METADATA_PERSON      VARCHAR2(20),
   METADATA_CONTENT     VARCHAR2(2000)                   not null,
   REMARK               VARCHAR2(2000),
   constraint PK_METADATA primary key (METADATA_ID),
   constraint FK_METADATA_REFERENCE_ARCHIVE2 foreign key (PAGE_ID)
         references ARCHIVES_PAGE (PAGE_ID),
   constraint FK_METADATA_REFERENCE_ARCHIVES foreign key (FILE_ID)
         references ARCHIVES_FILE (FILE_ID)
)
/


/*==============================================================*/
/* Table: EFORM_FIELD                                           */
/*==============================================================*/


create table EFORM_FIELD  (
   EFORM_ID             NUMBER(10),
   FIELD_SEQ            NUMBER(4),
   FIELD_ISEDIT         CHAR(1),
   FIELD_ID             NUMBER(10),
   constraint FK_EFORM_FI_REFERENCE_EFORM_DE foreign key (EFORM_ID)
         references EFORM_DEFINE (EFORM_ID),
   constraint FK_EFORM_FI_REFERENCE_FIELD_DE foreign key (FIELD_ID)
         references FIELD_DEFINE (FIELD_ID)
)
/


