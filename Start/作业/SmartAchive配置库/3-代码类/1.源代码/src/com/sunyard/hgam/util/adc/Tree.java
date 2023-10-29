package com.sunyard.hgam.util.adc;

import com.sunyard.hgam.domain.logic.DomainLogic;
import com.sunyard.hgam.persistence.dao.iface.adc.EntryTreeListDao;
import java.util.*;
import com.sunyard.hgam.persistence.dao.beans.adc.EntryTreeList;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;

public class Tree {
  private static List projTreeList = new ArrayList();
  /**
   * �������ȡ�þ��в�ͬ���ӵ���Ŀ��
   * @param entryTreeListDao
   * @param entryType
   * 1��������¼
   * 2������¼
   * 3���ļ���¼
   * 4����������
   * @param strURL
   * @param strParam
   * @return
   * �޶���¼��
   * 1��������֣��ȫ��
   * 2���޶������ƣ�֣��ȫ,2003-12-19��
   */
  public static String getEntryTreeListByType(EntryTreeListDao entryTreeListDao,String entryType,String strURL,String strParam){
    //���JAVASCRIPT�ַ����б���ʽ���£�
    //firstLvlNode =root.add("��Ⱥ������")
    //secondLvlNode=n13.add("����")
    //secondLvlNode.onclick="doClick('../main/c_right_1_1_1_0.htm')"
    String strResult="";

    try {
      Iterator firstEntryIterator = null;
      if(entryType.equalsIgnoreCase("2")){
        firstEntryIterator = entryTreeListDao.getFirstLevelTreeForPiece().iterator();
      }else{
        firstEntryIterator = entryTreeListDao.getAllFirstLevelTree().iterator();
      }
      Iterator secondEntryIterator = null;
      EntryTreeList treeNode1, treeNode2 = null;
      while (firstEntryIterator.hasNext()) {
        treeNode1 = (EntryTreeList) firstEntryIterator.next();
        //��һ�ڵ�����
        strResult += "firstLvlNode = " + "root.add(\"" + treeNode1.getEntryName() + "\");\n";
        secondEntryIterator = entryTreeListDao.getSecondLevelTreeByFatherId(
            treeNode1.getEntryId()).iterator();

        while (secondEntryIterator.hasNext()) {
          treeNode2 = (EntryTreeList) secondEntryIterator.next();
          //�ڶ��ڵ�����
          strResult += "secondLvlNode = firstLvlNode.add(\"" + treeNode2.getEntryName() + "\");\n";
          //�ڶ��ڵ����¼�
          strResult += "secondLvlNode.onclick = \"doClick('" + strURL +
              "?ENTRY_ID=" + treeNode2.getEntryId() + "&ISOPERATION=" +
              treeNode2.getIsOperation();
          if (strParam.equalsIgnoreCase("")) {
            strResult += "')\";\n";
          }else {
            strResult += "&" + strParam + "')\";\n";
          }
        }
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }finally{
      return strResult;
    }
  }

  /**
   * �������ȡ�þ��в�ͬ���������ӵ�ҵ���൵���ļ���
   * @param archivesFileDao
   * @param treeType
   * 1-������¼ʱ����ʱ��
   *   1������״�ṹ�г���Ŀ���׶κ��ļ���
   *   2����Ŀ���Ե�������и��ڵ㼶���ļ�����¼��
   *   3�������׶ο��Ե����������ؽڵ��ļ�����¼��
   *   4���ļ����𲻿ɵ�������й���
   * 2-��������ʱ����ʱ��
   *   1������״�ṹ�г���Ŀ���׶κ��ļ���
   *   2����Ŀ���Ե�����г������ĸ�Ҫ��Ϣ��
   *   3�������׶ο��Ե�����г��ý׶εĸ�Ҫ��Ϣ�����ɽ��иý׶��ļ����б���
   *   4���ļ�������Ե�����Ծ����ļ����е�������Ĺ���   *
   * @return
   * �޶���¼��
   * 1��������֣��ȫ,2003-12-19��
   */
  public static String getArchivesProjPhaseTree(Archives archives,ArchivesFileDao archivesFileDao,String treeType){
    /*���JAVASCRIPT�ַ����б���ʽ���£�
    //����˵����
    //1����Ŀ���룻2���ϼ��׶α��룻3�����׶α���
    LvlNode1 = root.add("������������ž��庼��Ǯ����԰����");
    LvlNode1.onclick = "doClick('1001',0,0)";
    LvlNode2 = LvlNode1.add("ѡַ�׶�");
    LvlNode2.onclick = "doClick('1001',0,1)";
    LvlNode3 = LvlNode2.add("��Ʒ��������׶�");
    LvlNode3.onclick = "doClick('1001',1,2)";
    */
    String strResult="";

    try {
      //��Ŀ���ڵ�
      strResult += "\n//��̬�ű���ʼ";
      strResult += "\nvar LvlNode1;\n";
      strResult += "LvlNode1 = " + "root.add(\"" + archives.getAPROJ_NAME() + "\");\n";
      strResult += "LvlNode1.onclick = \"doClick('" + archives.getAPROJ_ID() + "',0,0)\";\n";
      //ȡ�ö�����Ŀ�׶μ����ļ��б�
      Iterator topPhase = archivesFileDao.queryTopArchivesProjPhaseList(archives).iterator();
      ArchivesFile treeNode = null;
      while (topPhase.hasNext()) {
        treeNode = (ArchivesFile) topPhase.next();
        strResult += "var LvlNode2;\n";
        //���춥���ڵ�
        strResult += "LvlNode2 = " + "LvlNode1.add(\"" + treeNode.getPhase_name() + "\");\n";
        strResult += "LvlNode2.onclick = \"doClick('" + archives.getAPROJ_ID() + "',0," + treeNode.getPhase_id() +")\";\n";
        //ѭ���ݹ鹹��Ƕ����������ڵ�
        strResult += getArchivesPhaseTreeUtil(archivesFileDao,treeNode,"1",2,1);
        strResult += "//��̬�ű�����\n";
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }finally{
      return strResult;
    }
  }

  /**
   * ȡ�õ������ڵ�ҵ������Ŀȫ���ļ���
   * @param archivesFileDao
   * @return
   * �޶���¼��
   * 1��������֣��ȫ,2003-12-22��
   * 2�����ӽ׶νڵ���������Ϣ��֣��ȫ,2004-03-02��
   * 3�������ش��������ԭ���ļٶ�����ͬARCHIVES_ID�������������ͬ�Ľ׶Σ��Ʒ����������⣬��ȡ����һ��VSS�汾����֣��ȫ,2004-03-03��
   */
  public static String getAllProjPhaseTree(Archives archives,ArchivesFileDao archivesFileDao){
    /*���JAVASCRIPT�ַ����б���ʽ���£�
    //����˵����
    //1����Ŀ���룻2���ϼ��׶α��룻3�����׶α���
    LvlNode1 = root.add("������������ž��庼��Ǯ����԰����");
    LvlNode1.onclick = "doClick('1001',0,0)";
    LvlNode2 = LvlNode1.add("ѡַ�׶�");
    LvlNode2.onclick = "doClick('1001',0,1)";
    LvlNode3 = LvlNode2.add("��Ʒ��������׶�");
    LvlNode3.onclick = "doClick('1001',1,2)";
    */
    String strResult="";

    try {
      //��Ŀ���ڵ�
      strResult += "var LvlNode1;\n";
      strResult += "LvlNode1 = " + "root.add(\"" + archives.getAPROJ_NAME() +
          "[��Ŀ��ţ�" + archives.getAPROJ_ID() + "]\");\n";
      strResult += "LvlNode1.onclick = \"doClick('" + archives.getAPROJ_ID() +
          "',0,0)\";\n";
      //ȡ�ö�����Ŀ�׶μ����ļ��б�
      Iterator topPhase = archivesFileDao.queryAllTopProjPhaseList(archives).iterator();
      ArchivesFile treeNode = null;
      while (topPhase.hasNext()) {
        treeNode = (ArchivesFile) topPhase.next();
        strResult += "var LvlNode2;\n";
        //���춥���ڵ�
        strResult += "LvlNode2 = " + "LvlNode1.add(\"" + treeNode.getPhase_name() + "[�����:" + treeNode.getAccept_id() + "]\");\n";
        strResult += "LvlNode2.onclick = \"doClick('" + archives.getAPROJ_ID() + "',0," + treeNode.getPhase_id() +")\";\n";
        //ѭ���ݹ鹹��Ƕ����������ڵ�
        strResult += getAllProjPhaseTreeUtil(archivesFileDao,treeNode,2,1);
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }finally{
      projTreeList.clear();
      return strResult;
    }
  }


  /**
   * �ݹ�ȡ�õ����ڸ����׶μ����ļ��б�
   * @param archivesFileDao
   * @param treeType
   * @param phaseId
   * @return
   */
  private static String getArchivesPhaseTreeUtil(ArchivesFileDao archivesFileDao,ArchivesFile archivesFile,String treeType,int iCurLvl,int iMaxLvl){
    String strResult="";
    Iterator otherPhase = null;
    ArchivesFile treeNode = null;

    try {
      otherPhase = archivesFileDao.queryOtherArchivesProjPhaseList(archivesFile).
          iterator();

      while (otherPhase.hasNext()) {
        treeNode = (ArchivesFile) otherPhase.next();
        //����ڵ�
        if (iCurLvl > iMaxLvl) {
          iMaxLvl = iCurLvl;
          strResult += "var LvlNode" + (iCurLvl + 1) + ";\n";
        }
        strResult += "LvlNode" + (iCurLvl + 1) + " = " + "LvlNode" + iCurLvl +
            ".add(\"" + treeNode.getPhase_name() + "\");\n";
        strResult += "LvlNode" + (iCurLvl + 1) + ".onclick = \"doClick('" +
            treeNode.getProj_id() + "'," + treeNode.getUp_phase_id() + "," +
            treeNode.getPhase_id() + ")\";\n";

        //�ݹ����
        strResult +=
            getArchivesPhaseTreeUtil(archivesFileDao, treeNode, treeType,
                                     iCurLvl + 1, iMaxLvl);
        //System.out.println(strResult);

        //System.out.println(strResult);
        //��ʱû��Ҫ������������Ժ���չ�������Ҫ�г��ļ��Ļ���
        //if(treeType.equalsIgnoreCase("2")){
        //  strResult += "LvlNode" + (i + 1) + ".doClick('" + treeNode.getProj_id() +
        //      "'," + treeNode.getUp_phase_id() + "," + treeNode.getPhase_id() + ")\";\n";
        //}
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }finally{
      return strResult;
    }

  }

  /**
   * �ݹ�ȡ��������Ŀ�����׶μ����ļ��б�
   * @param archivesFileDao
   * @param treeType
   * @param phaseId
   * @return
   * �޶���¼��
   * 1������
   * 2���޶�����ڵ���̣�ȷ���ڲ�ͬ�������ļ��ṹ������ȷ�ݹ飨֣��ȫ��2003��12��29��
   * 3�������ش��������ԭ���ļٶ�����ͬARCHIVES_ID�������������ͬ�Ľ׶Σ��Ʒ����������⣬��ȡ����һ��VSS�汾����֣��ȫ,2004-03-03��
   */
  private static String getAllProjPhaseTreeUtil(ArchivesFileDao archivesFileDao,ArchivesFile archivesFile,int iCurLvl,int iMaxLvl){
    String strResult="";
    Iterator otherPhase = null;
    ArchivesFile treeNode = null;
    String toCompare = "";

    try {
      otherPhase = archivesFileDao.queryAllOtherProjPhaseList(archivesFile).
          iterator();

      while (otherPhase.hasNext()) {
        treeNode = (ArchivesFile) otherPhase.next();
        //����ڵ�
        //EDIT AT 12-29
        synchronized(projTreeList){
          //toCompare = treeNode.getArchives_id() + "-" + treeNode.getUp_phase_id() + "-" + treeNode.getPhase_id();
          toCompare = treeNode.getUp_phase_id() + "-" + treeNode.getPhase_id();

          if(!projTreeList.contains(toCompare)){
            if (iCurLvl > iMaxLvl) {
              iMaxLvl = iCurLvl;
              strResult += "var LvlNode" + (iCurLvl + 1) + ";\n";
            }
            strResult += "LvlNode" + (iCurLvl + 1) + " = " + "LvlNode" +
                iCurLvl + ".add(\"" + treeNode.getPhase_name() + "[�����:" + treeNode.getAccept_id() + "]\");\n";
            strResult += "LvlNode" + (iCurLvl + 1) + ".onclick = \"doClick('" +
                treeNode.getProj_id() + "'," + treeNode.getUp_phase_id() + "," +
                treeNode.getPhase_id() + ")\";\n";
            projTreeList.add(toCompare);
          }
        }

        //�ݹ����
        strResult +=
            getAllProjPhaseTreeUtil(archivesFileDao, treeNode,iCurLvl + 1, iMaxLvl);
        //System.out.println(strResult);

        //System.out.println(strResult);
        //��ʱû��Ҫ������������Ժ���չ�������Ҫ�г��ļ��Ļ���
        //if(treeType.equalsIgnoreCase("2")){
        //  strResult += "LvlNode" + (i + 1) + ".doClick('" + treeNode.getProj_id() +
        //      "'," + treeNode.getUp_phase_id() + "," + treeNode.getPhase_id() + ")\";\n";
        //}
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }finally{
      return strResult;
    }

  }

}