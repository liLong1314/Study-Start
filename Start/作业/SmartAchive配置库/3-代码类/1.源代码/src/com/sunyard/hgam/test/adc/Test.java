package com.sunyard.hgam.test.adc;

import java.util.*;


import java.sql.*;
import java.sql.SQLException;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.domain.logic.DomainLogic;
import com.sunyard.hgam.persistence.dao.iface.adc.EntryTreeListDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EntryTreeList;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.util.adc.*;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldDefine;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldValue;

public class Test {

  public static void main(String[] args){
    Test test = new Test();
    //����1��������Ŀ��
    /*
    test.testEntryTreeList();
     */

    //����2��������Ŀ��
    //test.testProjPhaseTree();

    //����3�����Եݹ�
    //System.out.println(test.testCount(5));

    //���Ե��ӱ��ֶζ�������
    //test.testEformFieldDefine();

    //����5����Ŀ��Ҫ��Ϣ
    test.testProjBrief();
  }

  private void testProjBrief(){
    DomainLogic domainLogic = DomainLogic.getInstance();
    EformDao eformDao = (EformDao)domainLogic.getDAO("Eform");
    Map projIdMap = new HashMap();
    projIdMap.put("projId","20030771");
    List list = eformDao.getProjBriefByProjId(projIdMap);
    Iterator it=list.iterator();
    EformFieldValue item = new EformFieldValue();
    while(it.hasNext()){
      item = (EformFieldValue) it.next();
      System.out.println(item.getField_cname() + ":" + item.getField_value());
    }
  }


  private void testEformFieldDefine(){
    DomainLogic domainLogic = DomainLogic.getInstance();
    EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
    Iterator it = eformDao.getEformFieldDefineByEformId("700000001").iterator();
    EformFieldDefine fieldDefine = null;
    while(it.hasNext()){
      fieldDefine = (EformFieldDefine) it.next();
      System.out.print(fieldDefine.getEform_id() + "        ");
      System.out.print(fieldDefine.getField_cname() + "        ");
      System.out.print(fieldDefine.getField_ename() + "        ");
      System.out.print(fieldDefine.getField_id() + "        ");
      System.out.print(fieldDefine.getField_isBrief() + "        ");
      System.out.print(fieldDefine.getField_isEdit() + "        ");
      System.out.print(fieldDefine.getField_isNull() + "        ");
      System.out.print(fieldDefine.getField_len() + "        ");
      System.out.print(fieldDefine.getField_seq() + "        ");
      System.out.print(fieldDefine.getField_type_id() + "        ");
      System.out.println();
    }
  }

  private int testCount(int i){
        if(i<=1){
                return 1;
        }else{
                return i*testCount(i-1);
        }
  }

  private void testProjPhaseTree(){
    DomainLogic domainLogic = DomainLogic.getInstance();
    Archives archives = new Archives();
    archives.setAARCHIVES_ID(new Integer(10184));
    archives.setAPROJ_ID("20030771");
    archives.setAPROJ_NAME("�ڶ�����Ŀ");
    ArchivesFileDao archivesFileDao = (ArchivesFileDao) domainLogic.getDAO(
        "ArchivesFile");
    //String strResult = Tree.getArchivesProjPhaseTree(archives, archivesFileDao, "1");
    String strResult = Tree.getAllProjPhaseTree(archives, archivesFileDao);
    System.out.println(strResult);
  }


  private void testEntryTreeList(){

    EntryTreeListDao entryTreeListDao = (EntryTreeListDao) DomainLogic.getInstance().getDAO(
        "EntryTreeList");

    List entryTreeList = entryTreeListDao.getAllFirstLevelTree();
    Iterator it = entryTreeList.iterator();
    while (it.hasNext()) {
      EntryTreeList entryTree = (EntryTreeList) it.next();
      System.out.println(entryTree.getEntryId() + "\t" + entryTree.getEntryLevel()+ "\t" +
                         entryTree.getEntryName()+ "\t" + entryTree.getIsOperation());
    }
  }

  }
