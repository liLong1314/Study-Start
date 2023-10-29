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
   * 根据类别取得具有不同链接的类目树
   * @param entryTreeListDao
   * @param entryType
   * 1－案卷著录
   * 2－件著录
   * 3－文件著录
   * 4－档案管理
   * @param strURL
   * @param strParam
   * @return
   * 修订记录：
   * 1、创建（郑先全）
   * 2、修订并完善（郑先全,2003-12-19）
   */
  public static String getEntryTreeListByType(EntryTreeListDao entryTreeListDao,String entryType,String strURL,String strParam){
    //结果JAVASCRIPT字符串列表，格式如下：
    //firstLvlNode =root.add("党群工作类")
    //secondLvlNode=n13.add("党务")
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
        //第一节点名称
        strResult += "firstLvlNode = " + "root.add(\"" + treeNode1.getEntryName() + "\");\n";
        secondEntryIterator = entryTreeListDao.getSecondLevelTreeByFatherId(
            treeNode1.getEntryId()).iterator();

        while (secondEntryIterator.hasNext()) {
          treeNode2 = (EntryTreeList) secondEntryIterator.next();
          //第二节点名称
          strResult += "secondLvlNode = firstLvlNode.add(\"" + treeNode2.getEntryName() + "\");\n";
          //第二节点点击事件
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
   * 根据类别取得具有不同操作和链接的业务类档案文件树
   * @param archivesFileDao
   * @param treeType
   * 1-档案著录时，此时：
   *   1）以树状结构列出项目、阶段和文件；
   *   2）项目可以点击，进行根节点级别文件的著录；
   *   3）各个阶段可以点击，进行相关节点文件的著录；
   *   4）文件级别不可点击（进行管理）
   * 2-档案管理时，此时：
   *   1）以树状结构列出项目、阶段和文件；
   *   2）项目可以点击，列出档案的概要信息；
   *   3）各个阶段可以点击，列出该阶段的概要信息（并可进行该阶段文件的列表）；
   *   4）文件级别可以点击，对具体文件进行档案级别的管理   *
   * @return
   * 修订记录：
   * 1、创建（郑先全,2003-12-19）
   */
  public static String getArchivesProjPhaseTree(Archives archives,ArchivesFileDao archivesFileDao,String treeType){
    /*结果JAVASCRIPT字符串列表，格式如下：
    //参数说明：
    //1、项目编码；2、上级阶段编码；3、本阶段编码
    LvlNode1 = root.add("西湖区周浦乡杜井村杭州钱江陵园征地");
    LvlNode1.onclick = "doClick('1001',0,0)";
    LvlNode2 = LvlNode1.add("选址阶段");
    LvlNode2.onclick = "doClick('1001',0,1)";
    LvlNode3 = LvlNode2.add("设计方案审批阶段");
    LvlNode3.onclick = "doClick('1001',1,2)";
    */
    String strResult="";

    try {
      //项目根节点
      strResult += "\n//动态脚本开始";
      strResult += "\nvar LvlNode1;\n";
      strResult += "LvlNode1 = " + "root.add(\"" + archives.getAPROJ_NAME() + "\");\n";
      strResult += "LvlNode1.onclick = \"doClick('" + archives.getAPROJ_ID() + "',0,0)\";\n";
      //取得顶级项目阶段及其文件列表
      Iterator topPhase = archivesFileDao.queryTopArchivesProjPhaseList(archives).iterator();
      ArchivesFile treeNode = null;
      while (topPhase.hasNext()) {
        treeNode = (ArchivesFile) topPhase.next();
        strResult += "var LvlNode2;\n";
        //构造顶级节点
        strResult += "LvlNode2 = " + "LvlNode1.add(\"" + treeNode.getPhase_name() + "\");\n";
        strResult += "LvlNode2.onclick = \"doClick('" + archives.getAPROJ_ID() + "',0," + treeNode.getPhase_id() +")\";\n";
        //循环递归构造非顶级的其他节点
        strResult += getArchivesPhaseTreeUtil(archivesFileDao,treeNode,"1",2,1);
        strResult += "//动态脚本结束\n";
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }finally{
      return strResult;
    }
  }

  /**
   * 取得档案所在的业务类项目全部文件树
   * @param archivesFileDao
   * @return
   * 修订记录：
   * 1、创建（郑先全,2003-12-22）
   * 2、增加阶段节点的受理号信息（郑先全,2004-03-02）
   * 3、树的重大调整：把原来的假定（相同ARCHIVES_ID不会出现两个相同的阶段）推翻（如有问题，请取回上一个VSS版本）（郑先全,2004-03-03）
   */
  public static String getAllProjPhaseTree(Archives archives,ArchivesFileDao archivesFileDao){
    /*结果JAVASCRIPT字符串列表，格式如下：
    //参数说明：
    //1、项目编码；2、上级阶段编码；3、本阶段编码
    LvlNode1 = root.add("西湖区周浦乡杜井村杭州钱江陵园征地");
    LvlNode1.onclick = "doClick('1001',0,0)";
    LvlNode2 = LvlNode1.add("选址阶段");
    LvlNode2.onclick = "doClick('1001',0,1)";
    LvlNode3 = LvlNode2.add("设计方案审批阶段");
    LvlNode3.onclick = "doClick('1001',1,2)";
    */
    String strResult="";

    try {
      //项目根节点
      strResult += "var LvlNode1;\n";
      strResult += "LvlNode1 = " + "root.add(\"" + archives.getAPROJ_NAME() +
          "[项目编号：" + archives.getAPROJ_ID() + "]\");\n";
      strResult += "LvlNode1.onclick = \"doClick('" + archives.getAPROJ_ID() +
          "',0,0)\";\n";
      //取得顶级项目阶段及其文件列表
      Iterator topPhase = archivesFileDao.queryAllTopProjPhaseList(archives).iterator();
      ArchivesFile treeNode = null;
      while (topPhase.hasNext()) {
        treeNode = (ArchivesFile) topPhase.next();
        strResult += "var LvlNode2;\n";
        //构造顶级节点
        strResult += "LvlNode2 = " + "LvlNode1.add(\"" + treeNode.getPhase_name() + "[受理号:" + treeNode.getAccept_id() + "]\");\n";
        strResult += "LvlNode2.onclick = \"doClick('" + archives.getAPROJ_ID() + "',0," + treeNode.getPhase_id() +")\";\n";
        //循环递归构造非顶级的其他节点
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
   * 递归取得档案内各个阶段及其文件列表
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
        //构造节点
        if (iCurLvl > iMaxLvl) {
          iMaxLvl = iCurLvl;
          strResult += "var LvlNode" + (iCurLvl + 1) + ";\n";
        }
        strResult += "LvlNode" + (iCurLvl + 1) + " = " + "LvlNode" + iCurLvl +
            ".add(\"" + treeNode.getPhase_name() + "\");\n";
        strResult += "LvlNode" + (iCurLvl + 1) + ".onclick = \"doClick('" +
            treeNode.getProj_id() + "'," + treeNode.getUp_phase_id() + "," +
            treeNode.getPhase_id() + ")\";\n";

        //递归调用
        strResult +=
            getArchivesPhaseTreeUtil(archivesFileDao, treeNode, treeType,
                                     iCurLvl + 1, iMaxLvl);
        //System.out.println(strResult);

        //System.out.println(strResult);
        //暂时没必要区分类别，留着以后扩展（如果需要列出文件的话）
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
   * 递归取得整个项目各个阶段及其文件列表
   * @param archivesFileDao
   * @param treeType
   * @param phaseId
   * @return
   * 修订记录：
   * 1、创建
   * 2、修订构造节点过程，确保在不同档案间文件结构树的正确递归（郑先全，2003－12－29）
   * 3、树的重大调整：把原来的假定（相同ARCHIVES_ID不会出现两个相同的阶段）推翻（如有问题，请取回上一个VSS版本）（郑先全,2004-03-03）
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
        //构造节点
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
                iCurLvl + ".add(\"" + treeNode.getPhase_name() + "[受理号:" + treeNode.getAccept_id() + "]\");\n";
            strResult += "LvlNode" + (iCurLvl + 1) + ".onclick = \"doClick('" +
                treeNode.getProj_id() + "'," + treeNode.getUp_phase_id() + "," +
                treeNode.getPhase_id() + ")\";\n";
            projTreeList.add(toCompare);
          }
        }

        //递归调用
        strResult +=
            getAllProjPhaseTreeUtil(archivesFileDao, treeNode,iCurLvl + 1, iMaxLvl);
        //System.out.println(strResult);

        //System.out.println(strResult);
        //暂时没必要区分类别，留着以后扩展（如果需要列出文件的话）
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