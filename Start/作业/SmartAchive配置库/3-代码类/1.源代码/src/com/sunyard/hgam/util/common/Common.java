package com.sunyard.hgam.util.common;

import java.util.ArrayList;
import java.util.Vector;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao; //hukp add
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.domain.logic.DomainLogic;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import java.util.Iterator;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.presentation.base.SysParamOper;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Secret;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldValue;
import java.util.List;
import com.sunyard.hgam.persistence.dao.iface.arm.EntryDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Entry;
import java.util.Map;
import java.util.HashMap;

public class Common {
  public final static String FTPROOT = "C:\\Inetpub\\ftproot\\";
  public final static String XMLFILENAME = "FileInfo.xml";

  private static int minPageNum;
  private static int maxPageNum;
  public Common() {
  }

  /**业务类卷内文件目录
   * 根据archives_id 返回档案的卷内文件目录，以二层数组的方式返回，
   * @param archives_id      档案ID
   * @return Iterator        数组元素还是为ArrayList
   * @throws java.lang.Exception
   */
  public static ArrayList getRollContent(String archives_id) throws Exception {
    String sSQL = "";
    Vector vSQL = null;
    ArrayList alSQL = new ArrayList();

    ArchivesFileDao dao = (ArchivesFileDao) DomainLogic.getInstance().
        getDAO("ArchivesFile");
    PaginatedList list = dao.queryArchivesFileByArchivesID(archives_id, 10000) ;
/*    Iterator fileIterator = list.iterator();
    ArchivesFile archivesFile = new ArchivesFile();
    while (fileIterator.hasNext()){
      archivesFile = (ArchivesFile) fileIterator.next();
      int minPageNum=dao.getMINPageNumArchivesFiles(archivesFile);
      int maxPageNum=dao.getMAXPageNumArchivesFiles(archivesFile);
    }*/

    if (list.size() > 0) {
      for (int n = 0; n < list.size(); n++) {
        ArchivesFile af = (ArchivesFile)list.get(n);
        ArrayList alRow = new ArrayList();

        //得到该件的起始页码  sStartPage
/*
        String sStartPage = "";
        String pieceID = (String) htRow.get("PIECEID");
        sSQL =
            "select Min(PageNum) MinPageNum, Max(PageNum) MaxPageNum from ArchivesPage " +
            " where rollID= '" + rollID + "' and PieceID= '" + pieceID +
            "'";
        Vector vMinPage = AdcUtil.openSQL(sSQL);
        if (vMinPage.size() > 0) {
          Hashtable ht = (Hashtable) vMinPage.get(0);
          sStartPage = (String) ht.get("MINPAGENUM");
          String sMaxPage = (String) ht.get("MAXPAGENUM");
          if (sMaxPage == null)
            sMaxPage = "";
          if (sStartPage == null)
            sStartPage = "";
          else
            sStartPage += "至" + sMaxPage;
        }
*/
/*   String sStartPage = "";
   sStartPage=Integer.toString(minPageNum);
   String sMaxPage=Integer.toString(maxPageNum);
   if (sMaxPage == null)
    sMaxPage = "";
   if (sStartPage == null)
    sStartPage = "";
   else
    sStartPage += "至" + sMaxPage;*/

        alRow.add(Integer.toString(n + 1)); //序号

        //文号
        String pieceNum = af.getFile_num() ;
        if (pieceNum == null) {
          pieceNum = "";
        }
        alRow.add(pieceNum);

        //责任者
        String dutyMan = af.getFile_duty() ;
        if (dutyMan == null) {
          dutyMan = "";
        }
        alRow.add(dutyMan);

        //件题名
        String pieceName = af.getFile_title() ;
        if (pieceName == null) {
          pieceName = "";
        }
        alRow.add(pieceName);

        //日期
        String pieceDate = af.getFile_date();
        if (pieceDate == null) {
           pieceDate = "";
        }
        alRow.add(pieceDate);
        //页号
        String pieceFromTo = af.getPage_num_from_to() ;
       if (pieceFromTo == null) {
         pieceFromTo = "";
       }
       alRow.add(pieceFromTo);

        //附注
        String remark = af.getRemark() ;
        if (remark == null) {
          remark = "";
        }
        alRow.add(remark);

        alSQL.add(alRow);
      }
    }
    return alSQL;
  }
  /**业务类封面需要修改
     * 根据archives_id 返回档案的卷内文件目录，以二层数组的方式返回，
     * @param archives_id      档案ID
     * @return Iterator   数组元素还是为ArrayList
     * @throws java.lang.Exception
     */

    public static ArrayList getRollFace(String archives_id) throws Exception{
      ArchivesDao dao = (ArchivesDao) DomainLogic.getInstance().
          getDAO("Archives");
      Archives archives = dao.getArchivesByArchivesID( (new Integer(archives_id)).
          intValue());
      EformDao daoo=(EformDao)DomainLogic.getInstance().getDAO("Eform");
     List list = (List) daoo.getPrintFieldValue(archives_id) ;
     Iterator listIterator = list.iterator();
     //建筑许可证号','征地许可证号','用地编号
     String a = "    ";
     String b = "    ";
     String c = "    ";
     while(listIterator.hasNext()){
       EformFieldValue aValue = (EformFieldValue) listIterator.next();
       if(aValue.getField_cname().trim().equals("建筑许可证号")){
          a += aValue.getField_value();
       }
       if(aValue.getField_cname().trim().equals("征地许可证号")){
          b += aValue.getField_value();
       }
       if(aValue.getField_cname().trim().equals("用地许可证号")){
          c += aValue.getField_value();
       }

     }

      ArrayList arrayListCol = new ArrayList();
      ArrayList arrayListRow = null;
      arrayListRow = new ArrayList();
      SysParamOper sysParamOper = SysParamOper.getInstance();
     archives.setAARCHIVES_FOUND_UNIT(sysParamOper.getSysParamName("ARCHIVES_FOUND_UNIT",archives.getAARCHIVES_FOUND_UNIT()));
     archives.setASTORE_TERM(sysParamOper.getSysParamName("ArchiveStore",archives.getASTORE_TERM()));
     SecretDao secretDao = (SecretDao)DomainLogic.getInstance().getDAO("Secret");
     if (archives.getASECRET_ID()!=null){
       Secret secret = secretDao.getSecret(archives.getASECRET_ID());
       if (secret != null)
         archives.setASECRET_ID(secret.getSecretName());
     }

      //档号

     String archivesNum = archives.getAARCHIVES_NUM();
      if (archivesNum == null)
      archivesNum = "";
      String archivesNum1="    ";
      archivesNum1 +=archivesNum;
     arrayListRow.add(0,"档    号");
    arrayListRow.add(1, archivesNum1);
    arrayListRow.add(2, "");
    arrayListRow.add(3, "");
    //建筑许可证号（需要修改）
     arrayListRow.add(4, "建筑许可证号");
    arrayListRow.add(5, a);
    arrayListCol.add(0, arrayListRow);

    arrayListCol.add(1, new ArrayList());
    //档案馆号
    arrayListRow = new ArrayList();
    String roomCode =archives.getAARCHIVES_ROOM_CODE();
    if (roomCode == null)
      roomCode = "";
     String roomCode1="    ";
     roomCode1 +=roomCode;
    arrayListRow.add(0,"档案馆号");
    arrayListRow.add(1, roomCode1);
     arrayListRow.add(2, "");
    //用地许可证号（需要修改）
     arrayListRow.add(3, "");
    arrayListRow.add(4,"用地许可证号");
    arrayListRow.add(5,c);
    arrayListCol.add(2, arrayListRow);

    arrayListCol.add(3, new ArrayList());
    //缩微号
    arrayListRow = new ArrayList();
   String reduceNum = archives.getAREDUCE_NUM();
    if (reduceNum == null)
      reduceNum = "";
      String reduceNum1="    ";
      reduceNum1 +=reduceNum;
    arrayListRow.add(0,"缩 微 号");
    arrayListRow.add(1,reduceNum1);
    arrayListRow.add(2,"");
    arrayListCol.add(4, arrayListRow);
    arrayListCol.add(5, new ArrayList());
    //案卷题名
    String archivesName1="        ";
    String archivesName2="";
    int archivesNamelen=0;
    arrayListRow = new ArrayList();
    String archivesName = archives.getAARCHIVES_NAME();
    if (archivesName == null){
      archivesName = "";
    archivesName1 = "";}
    arrayListRow.add(0,"案卷题名");
    if (archivesName != null) {
            if (archivesName.length() > 26) {
              archivesName1 += archivesName.substring(0, 26);
              archivesNamelen=archivesName.length();
              archivesName2 = archivesName.substring(27,archivesNamelen);
            }
            else {
            archivesName1 += archivesName;
            archivesName2 ="";
          }
    }
    arrayListRow.add(1,archivesName1);
    arrayListCol.add(6, arrayListRow);
    arrayListRow = new ArrayList();
    arrayListRow.add(0,"");
    arrayListRow.add(1,archivesName2);
    arrayListCol.add(7, arrayListRow);
    //编制单位
    arrayListRow = new ArrayList();
    String archivesFoundUnit =archives.getAARCHIVES_FOUND_UNIT();
    if (archivesFoundUnit == null)
      archivesFoundUnit = "";
    String archivesFoundUnit1="    ";
    archivesFoundUnit1 +=archivesFoundUnit;
    arrayListRow.add(0,"编制单位");
    arrayListRow.add(1,archivesFoundUnit1);
    arrayListCol.add(8, arrayListRow);
    //编制日期
    arrayListRow = new ArrayList();
    String archivesMakePeriod =archives.getAARCHIVES_MAKE_PERIOD();
    if (archivesMakePeriod == null) {
            archivesMakePeriod = "";
           }
    String archivesMakePeriod1="    ";
    archivesMakePeriod1 +=archivesMakePeriod;
    arrayListRow.add(0,"编制日期");
    arrayListRow.add(1,archivesMakePeriod1);
    arrayListCol.add(9, arrayListRow);
    //保管期限
    arrayListRow = new ArrayList();
    String storeTerm =archives.getASTORE_TERM();
    if (storeTerm == null)
      storeTerm = "";
    String storeTerm1="    ";
    storeTerm1 +=storeTerm;
    arrayListRow.add(0,"保管期限");
    arrayListRow.add(1,storeTerm1);
    arrayListCol.add(10, arrayListRow);

    //密级
    arrayListRow = new ArrayList();
    String secretId =archives.getASECRET_ID();
    if (secretId == null)
      secretId = "";
     String secretId1="    ";
     secretId1 +=secretId;
    arrayListRow.add(0,"密    级");
    arrayListRow.add(1,secretId1);
    arrayListRow.add(2,"");
     arrayListCol.add(11, arrayListRow);
    return arrayListCol;
}
  /**文书类薄卷封面
    * 根据archives_id 返回文书类档案的封面，以二层数组的方式返回，
    * @param archives_id      档案ID
    * @return Iterator        数组元素还是为ArrayList
    * @throws java.lang.Exception
    */
   public static ArrayList getWenshuJuanRollFace(String archives_id) throws Exception{
        ArchivesDao dao = (ArchivesDao) DomainLogic.getInstance().
            getDAO("Archives");
        Archives archives = dao.getArchivesByArchivesID( (new Integer(archives_id)).
            intValue());
        ArrayList arrayListCol = new ArrayList();
        ArrayList arrayListRow = null;
        arrayListRow = new ArrayList();
        SysParamOper sysParamOper = SysParamOper.getInstance();
       archives.setAARCHIVES_FOUND_UNIT(sysParamOper.getSysParamName("ARCHIVES_FOUND_UNIT",archives.getAARCHIVES_FOUND_UNIT()));
       archives.setASTORE_TERM(sysParamOper.getSysParamName("ArchiveStore",archives.getASTORE_TERM()));
       SecretDao secretDao = (SecretDao)DomainLogic.getInstance().getDAO("Secret");
       if (archives.getASECRET_ID()!=null){
         Secret secret = secretDao.getSecret(archives.getASECRET_ID());
         if (secret != null)
           archives.setASECRET_ID(secret.getSecretName());
       }
       EntryDao entryDao = (EntryDao)DomainLogic.getInstance().getDAO("Entry");
       if (archives.getAENTRY_ID()!=null){
         Entry entry = entryDao.getEntry(archives.getAENTRY_ID());
         if (entry != null)
           archives.setAENTRY_ID(entry.getEntryName());
       }


        //立档单位
        String archivesFoundUnit = archives.getAARCHIVES_FOUND_UNIT();
        if (archivesFoundUnit == null)
        archivesFoundUnit = "";
       arrayListRow.add(0,archivesFoundUnit);
      arrayListCol.add(0, arrayListRow);
      //类别（需要修改）
       arrayListRow = new ArrayList();
       String entryId = archives.getAENTRY_ID();
       if (entryId == null)
        entryId = "";
      arrayListRow.add(0,entryId);
      arrayListCol.add(1, arrayListRow);
      //案卷题名
      arrayListRow = new ArrayList();
      String archivesName=archives.getAARCHIVES_NAME();
      if (archivesName == null)
        archivesName = "";
      arrayListRow.add(0,archivesName);
      arrayListCol.add(2, arrayListRow);

       arrayListRow = new ArrayList(4);
      //案卷起止日期
      String YearbeginDate="";
      String MonthbeginDate="";
      String YearendDate="";
      String MonthendDate="";
      arrayListRow = new ArrayList();
      String beginDate = archives.getABEGIN_DATE();
    String endDate = archives.getAEND_DATE();
    if (beginDate == null) {
      beginDate = "";
    }
    else {
      if (beginDate.length() > 5) {
        beginDate = beginDate.substring(0, 6);
        YearbeginDate = beginDate.substring(0,4);
        MonthbeginDate =beginDate.substring(4,6);
      }
    }

    if (endDate == null) {
      endDate = "";
    }
    else {
      if (endDate.length() > 5) {
        endDate = endDate.substring(0, 6);
        YearendDate = endDate.substring(0,4);
        MonthendDate=endDate.substring(4,6);
      }
    }

    String BbeginEndDate = "自 ";
    BbeginEndDate += YearbeginDate;
    BbeginEndDate += " 年 ";
    BbeginEndDate += MonthbeginDate;
    BbeginEndDate += " 月";
    BbeginEndDate += " 至 ";
    BbeginEndDate += YearendDate;
    BbeginEndDate += " 年 ";
     BbeginEndDate += MonthendDate;
    BbeginEndDate += " 月";
    arrayListRow.add(0, BbeginEndDate);
    arrayListRow.add(1, "保管期限");
    arrayListRow.add(2, "");

      //保管期限
       String storeTerm= archives.getASTORE_TERM();
       if (storeTerm == null) {
      storeTerm = "";
    }
    arrayListRow.add(3, storeTerm);
    arrayListCol.add(3, arrayListRow);
      //件页数
      arrayListRow = new ArrayList();
    String pageAmount = archives.getAPAGE_AMOUNT();
    if (pageAmount == null) {
      pageAmount = "";
    }

    arrayListRow.add(0, "本卷共 " + "" + " 件 " + pageAmount + " 页");
    arrayListRow.add(1, "归档号");
    arrayListRow.add(2, "");
    //归档号
    String arcNum =  archives.getAARC_NUM();
    if (arcNum == null) {
      arcNum = "";
    }
    arrayListRow.add(3, arcNum);
    arrayListCol.add(4, arrayListRow);

    arrayListCol.add(5, new ArrayList());
    arrayListCol.add(6, new ArrayList());

    arrayListRow = new ArrayList();
    arrayListRow.add(0, "");


    //全宗号
  String foundsNum = archives.getAFONDS_NUM();
  if (foundsNum == null) {
    foundsNum = "";
  }
   arrayListRow.add(1, "");
  arrayListRow.add(2, foundsNum);
  //目录号
  String catalogNum = archives.getACATALOG_NUM();
  if (catalogNum == null) {
    catalogNum = "";
  }
  arrayListRow.add(3, catalogNum);
  //案卷号
  String rollNum = archives.getAROLL_NUM();
  if (rollNum == null) {
    rollNum = "";
  }
  arrayListRow.add(4, rollNum);
  arrayListCol.add(7, arrayListRow);

  return arrayListCol;

}

  /**文书类件卷内目录
     * 根据archives_id 返回档案的卷内文件目录，以二层数组的方式返回，
     * @param archives_id      档案ID
     * @return Iterator        数组元素还是为ArrayList
     * @throws java.lang.Exception
     */
    public static ArrayList getWenshuJianRollContent(String archives_id) throws Exception {
      String sSQL = "";
      Vector vSQL = null;
      ArrayList alSQL = new ArrayList();

      ArchivesFileDao dao = (ArchivesFileDao) DomainLogic.getInstance().
          getDAO("ArchivesFile");
      PaginatedList list = dao.queryArchivesFileJianByArchivesID(archives_id);
  /*    Iterator fileIterator = list.iterator();
      ArchivesFile archivesFile = new ArchivesFile();
      while (fileIterator.hasNext()){
        archivesFile = (ArchivesFile) fileIterator.next();
        int minPageNum=dao.getMINPageNumArchivesFiles(archivesFile);
        int maxPageNum=dao.getMAXPageNumArchivesFiles(archivesFile);
      }*/

      if (list.size() > 0) {
        for (int n = 0; n < list.size(); n++) {
          ArchivesFile af = (ArchivesFile)list.get(n);
          ArrayList alRow = new ArrayList();

          //得到该件的起始页码  sStartPage
  /*
          String sStartPage = "";
          String pieceID = (String) htRow.get("PIECEID");
          sSQL =
              "select Min(PageNum) MinPageNum, Max(PageNum) MaxPageNum from ArchivesPage " +
              " where rollID= '" + rollID + "' and PieceID= '" + pieceID +
              "'";
          Vector vMinPage = AdcUtil.openSQL(sSQL);
          if (vMinPage.size() > 0) {
            Hashtable ht = (Hashtable) vMinPage.get(0);
            sStartPage = (String) ht.get("MINPAGENUM");
            String sMaxPage = (String) ht.get("MAXPAGENUM");
            if (sMaxPage == null)
              sMaxPage = "";
            if (sStartPage == null)
              sStartPage = "";
            else
              sStartPage += "至" + sMaxPage;
          }
  */
  /*   String sStartPage = "";
     sStartPage=Integer.toString(minPageNum);
     String sMaxPage=Integer.toString(maxPageNum);
     if (sMaxPage == null)
      sMaxPage = "";
     if (sStartPage == null)
      sStartPage = "";
     else
      sStartPage += "至" + sMaxPage;*/
      String rollYear=af.getProj_id();
      if (rollYear == null) {
            rollYear = "";
          }

       alRow.add(0,"    年度:" + rollYear);
        alRow.add(1,"");
        alRow.add(2,"");
        alRow.add(3,"");
        alRow.add(4,"类号:");
        alRow.add(5,"");
        alSQL.add(0,alRow);
       alSQL.add(1,new ArrayList());
       alRow = new ArrayList();
      String pieceNum = af.getMedia_type();
      if (pieceNum == null) {
      pieceNum = "";
      }
      alRow.add(pieceNum);

          //责任者
          String fileDute = af.getFile_duty();
          if (fileDute == null) {
            fileDute = "";
          }
          alRow.add(fileDute);

          //文号
          String fileNum = af.getFile_num();
          if (fileNum == null) {
            fileNum = "";
          }
          alRow.add(fileNum);

          //文件题名
          String fileTitle = af.getFile_title() ;
          if (fileTitle == null) {
            fileTitle = "";
          }
          alRow.add(fileTitle);

          //日期
          String fileDate = af.getFile_date();
          if (fileDate == null) {
             fileDate="";
          }


          alRow.add(fileDate);
          //页数
          String filePageAmount = af.getFile_page_amount();
         if (filePageAmount == null) {
           filePageAmount = "";
         }
         alRow.add(filePageAmount);

          //备注
          String remark = af.getRemark() ;
          if (remark == null) {
            remark = "";
          }
          alRow.add(remark);

          alSQL.add(2,alRow);
        }
      }
      return alSQL;
    }


    /**文书类件卷内备考表
        * 根据archives_id 返回文书类件卷内备考表，以二层数组的方式返回，
        * @param archives_id      档案ID
        * @return Iterator        数组元素还是为ArrayList
        * @throws java.lang.Exception
        */

       public static ArrayList getWenshuBeiKao(String archives_id) throws Exception{
               ArchivesDao dao = (ArchivesDao) DomainLogic.getInstance().
                   getDAO("Archives");
               Archives archives = dao.getArchivesByArchivesID_BK( (new Integer(archives_id)).
                   intValue());
               ArrayList arrayListCol = new ArrayList();
               ArrayList arrayListRow = null;
               arrayListRow = new ArrayList();
               SysParamOper sysParamOper = SysParamOper.getInstance();
              archives.setAARCHIVES_FOUND_UNIT(sysParamOper.getSysParamName("ARCHIVES_FOUND_UNIT",archives.getAARCHIVES_FOUND_UNIT()));
              archives.setASTORE_TERM(sysParamOper.getSysParamName("ArchiveStore",archives.getASTORE_TERM()));
              SecretDao secretDao = (SecretDao)DomainLogic.getInstance().getDAO("Secret");
              if (archives.getASECRET_ID()!=null){
                Secret secret = secretDao.getSecret(archives.getASECRET_ID());
                if (secret != null)
                  archives.setASECRET_ID(secret.getSecretName());
              }
              EntryDao entryDao = (EntryDao)DomainLogic.getInstance().getDAO("Entry");
              if (archives.getAENTRY_ID()!=null){
                Entry entry = entryDao.getEntry(archives.getAENTRY_ID());
                if (entry != null)
                  archives.setAENTRY_ID(entry.getEntryName());
              }

              arrayListRow.add(0,"");
             arrayListCol.add(0, arrayListRow);
               //本卷情况说明
              arrayListRow = new ArrayList();
              arrayListRow.add(0,"");
              arrayListRow.add(1,"本卷情况说明");
              arrayListCol.add(1, arrayListRow);

              String Remark= archives.getAREMARK();
              if (Remark == null) {
                  Remark = "";
              }
              arrayListRow = new ArrayList();
              arrayListRow.add(0,Remark);

              arrayListCol.add(2, arrayListRow);
              arrayListCol.add(3, new ArrayList());
              arrayListCol.add(4, new ArrayList());
             //立卷人
             arrayListRow = new ArrayList();
              String archivesFoundMan= archives.getAARCHIVES_FOUND_MAN();
              if (archivesFoundMan == null) {
             archivesFoundMan = "";
           }
           arrayListRow.add(0, "");
        arrayListRow.add(1, "");
        arrayListRow.add(2, "");

           arrayListRow.add(3, "立卷人" + "  " + archivesFoundMan);
           arrayListCol.add(5, arrayListRow);

           arrayListCol.add(6, new ArrayList());
             //检查人
             arrayListRow = new ArrayList();
             arrayListRow.add(0, "");
          arrayListRow.add(1, "");
          arrayListRow.add(2, "");
////////hukp add
          String Checker= archives.getAMAKE_MAN();
          if (Checker == null) {
            Checker = "";
          }
/////////
           arrayListRow.add(3,"检查人  "+Checker);
           arrayListCol.add(7, arrayListRow);

           arrayListCol.add(8, new ArrayList());
           //立卷时间
           arrayListRow = new ArrayList();
        String archivesFoundDate = archives.getAARCHIVES_FOUND_DATE();
        if (archivesFoundDate == null) {
          archivesFoundDate = "";
        }
        arrayListRow.add(0, "");
        arrayListRow.add(1, "");
        arrayListRow.add(2, "");
        arrayListRow.add(3,  "立卷时间" +"  "+ archivesFoundDate);
        arrayListCol.add(9, arrayListRow);

        arrayListCol.add(10, new ArrayList());
         return arrayListCol;

       }
       /**标签
       * 根据archives_id 返回标签，以二层数组的方式返回，
       * @param archives_id      档案ID
       * @return Iterator        数组元素还是为ArrayList
       * @throws java.lang.Exception
       */

      public static ArrayList getRollBiaoqian(String archives_id) throws Exception{
              ArchivesDao dao = (ArchivesDao) DomainLogic.getInstance().
                  getDAO("Archives");
              Archives archives = dao.getArchivesByArchivesID( (new Integer(archives_id)).
                  intValue());
              SysParamOper sysParamOper = SysParamOper.getInstance();
              archives.setAARCHIVES_FOUND_UNIT(sysParamOper.getSysParamName("ARCHIVES_FOUND_UNIT",archives.getAARCHIVES_FOUND_UNIT()));
              ArrayList arrayListCol = new ArrayList();
              ArrayList arrayListRow = null;
              arrayListRow = new ArrayList();
              arrayListRow.add(0,"");
              arrayListCol.add(0, arrayListRow);
              //标签
             arrayListRow = new ArrayList();
             String archivesName=archives.getAARCHIVES_NAME();
             String archivesName1="";
             String archivesName2="";
             String archivesName3="";
        if (archivesName != null) {
         if (archivesName.length() >13) {
           int archivesNameLen=archivesName.length();
          archivesName1 = archivesName.substring(0, 14);
           if(archivesName.length() >13 && archivesName.length() <31){
           archivesName2 = archivesName.substring(14,archivesNameLen) ;
           archivesName3 ="";}
            if(archivesName.length() >30){
              archivesName2 = archivesName.substring(14,30) ;
             archivesName3 = archivesName.substring(30,archivesNameLen) ; }
         }
         else {
         archivesName1 = archivesName;
         archivesName2 = "";
         archivesName3 = "";}
       }
       else {
         archivesName1 = "";
         archivesName2 = "";
         archivesName3 = "";
       }
             arrayListRow.add(0,"");
             arrayListRow.add(1,archivesName3);
             arrayListRow.add(2,archivesName2);
             arrayListRow.add(3,"");
             String archivesFoundUnit=archives.getAARCHIVES_FOUND_UNIT();
             if (archivesFoundUnit == null) {
           archivesFoundUnit = "";
         }

             arrayListRow.add(4, archivesFoundUnit);
             arrayListRow.add(5,"");
             arrayListCol.add(1, arrayListRow);
             arrayListRow = new ArrayList();
             arrayListRow.add(0,"");
             arrayListRow.add(1,"");
             arrayListRow.add(2,"");
             arrayListRow.add(3,archivesName1);
             arrayListRow.add(4,"");
             arrayListRow.add(5,"");
             arrayListCol.add(2, arrayListRow);

             arrayListRow = new ArrayList();
             arrayListRow.add(0,"");
             arrayListCol.add(3, arrayListRow);

        return arrayListCol;

      }


      /**文件题名
         * 根据开始室编件号和终止室编件号 返回档案的文件题名，以二层数组的方式返回，
         * author hukp
         * @param
         * @return Iterator        数组元素还是为ArrayList
         * @throws java.lang.Exception
         */
    public static ArrayList getRoll_JianName_Content(String begin_id, String end_id) throws Exception
    {
       String sSQL = "";
       String archives_id="1";
       Vector vSQL = null;
       ArrayList alSQL = new ArrayList();
       Map projIdMap = new HashMap();

       projIdMap.put("begin_id", begin_id);
       projIdMap.put("end_id", end_id);

       ArchivesFileDao dao = (ArchivesFileDao) DomainLogic.getInstance().getDAO("ArchivesFile");
       List list = dao.queryArchivesJianByID(projIdMap);
       if (list.size() <= 0) {//无业务数据
         return alSQL;
       }
       {
         ArchivesFile af = (ArchivesFile)list.get(0);
         ArrayList alRow = new ArrayList();
         String rollYear=af.getFile_status();//别名为案卷的年度
         alRow = new ArrayList();
         if (rollYear == null){
               rollYear = "    ";
         }
         String pieceNum = af.getFile_store_term();
         if (pieceNum == null) {
           pieceNum = "  ";
         }
         alRow.add(0,"年度:" + rollYear+"                                                         类号:"+pieceNum);
         alSQL.add(alRow);
       }
//       alSQL.add(1,new ArrayList());
       alSQL.add(new ArrayList());
       for (int n = 0; n < list.size(); n++)
       {
         ArchivesFile af = (ArchivesFile)list.get(n);
         ArrayList alRow = new ArrayList();
         alRow.add(Integer.toString(n + 1)); //序号

         String dutyMan = af.getFile_duty();        //责任者
         if (dutyMan == null) {
           dutyMan = "";
         }
         alRow.add(dutyMan);

         String pieceNum = af.getFile_num() ;       //文号
         if (pieceNum == null) {
           pieceNum = "";
         }
         alRow.add(pieceNum);

         String pieceName = af.getFile_title();         //件题名
         if (pieceName == null) {
           pieceName = "";
         }
         alRow.add(pieceName);

         String pieceDate = af.getFile_date();         //日期
         if (pieceDate == null) {
            pieceDate = "";
         }
         alRow.add(pieceDate);

         String pieceFromTo = af.getFile_page_amount() ;         //页数
         if (pieceFromTo == null) {
           pieceFromTo = "";
         }
         alRow.add(pieceFromTo);

         String remark = af.getRemark() ;         //附注
         if (remark == null) {
           remark = "";
         }
         alRow.add(remark);
         alSQL.add(alRow);
       } //end for
     return alSQL;
    }

    /**业务类件卷内备考表
     * 根据archives_id 返回业务类件卷内备考表，以二层数组的方式返回，
     * @param archives_id      档案ID
     * @return Iterator        数组元素还是为ArrayList
     * @throws java.lang.Exception
     * hukp mody
     */
    public static ArrayList getYewuBeiKao(String archives_id) throws Exception{
        ArchivesDao dao = (ArchivesDao) DomainLogic.getInstance().getDAO("Archives");
        Archives archives = dao.getArchivesByArchivesID_BK( (new Integer(archives_id)).intValue());

        ArrayList arrayListCol = new ArrayList();
        ArrayList arrayListRow = null;
        arrayListRow = new ArrayList();
        SysParamOper sysParamOper = SysParamOper.getInstance();
        archives.setAARCHIVES_FOUND_UNIT(sysParamOper.getSysParamName("ARCHIVES_FOUND_UNIT",archives.getAARCHIVES_FOUND_UNIT()));
        archives.setASTORE_TERM(sysParamOper.getSysParamName("ArchiveStore",archives.getASTORE_TERM()));
        SecretDao secretDao = (SecretDao)DomainLogic.getInstance().getDAO("Secret");

        if (archives.getASECRET_ID()!=null)
        {
           Secret secret = secretDao.getSecret(archives.getASECRET_ID());
           if (secret != null)
             archives.setASECRET_ID(secret.getSecretName());
        }
        EntryDao entryDao = (EntryDao)DomainLogic.getInstance().getDAO("Entry");
        if (archives.getAENTRY_ID()!=null)
        {
           Entry entry = entryDao.getEntry(archives.getAENTRY_ID());
           if (entry != null)
             archives.setAENTRY_ID(entry.getEntryName());
        }

        arrayListRow.add(0,"");
        arrayListCol.add(0, arrayListRow);
            //本组案卷情况
        arrayListRow = new ArrayList();
        String rollAmount=archives.getAROLL_AMOUNT();
        if (rollAmount == null) {
          rollAmount = "";
        }
        String AllPage=archives.getAMEDIA_TYPE();
        if (AllPage == null) {
          AllPage = "";
        }
        String bzbkao="本组案卷共 " + rollAmount + " 卷,  " + AllPage + " 页";
        arrayListRow.add(0,"");
        arrayListRow.add(1,bzbkao);
        arrayListRow.add(2,"");
        arrayListCol.add(1, arrayListRow);
        //本卷情况
        arrayListRow = new ArrayList();
        arrayListRow.add(0,"");
        String rollSeq=archives.getAROLL_SEQ();
        if (rollSeq == null) {
          rollSeq = "";
        }

        String bjbkao="本卷为第 " + rollSeq + " 卷,起止页码为  ";
        bjbkao += "";
        String pageNumFromTO=archives.getAPAGE_NUM_FROM_TO();
        arrayListRow.add(1,bjbkao+pageNumFromTO);
        arrayListCol.add(2, arrayListRow);
        //案卷情况说明
        String FilePage=archives.getANEGATIVE_NUM();
        if (FilePage == null) {
          FilePage = "";
        }
        String PicPage=archives.getAARCHIVES_UNIT();
        if (PicPage == null) {
          PicPage = "";
        }
        arrayListRow = new ArrayList();
        arrayListRow.add(0,"其中:");
        arrayListRow.add(1,"文件材料 " + FilePage + " 页");
        arrayListRow.add(2,"");
        arrayListCol.add(3, arrayListRow);

        arrayListRow = new ArrayList();
        arrayListRow.add(0,"");
        arrayListRow.add(1,"图纸材料" + PicPage + "页");
        arrayListRow.add(2,"");
        arrayListCol.add(4, arrayListRow);

        //说明
        arrayListRow = new ArrayList();
        arrayListRow.add(0,"说明:");
        arrayListRow.add(1,"");
        arrayListCol.add(5, arrayListRow);

        arrayListRow = new ArrayList();
        String Remark=archives.getAREMARK();
        if (Remark == null) {
          Remark = "";
        }
        arrayListRow.add(0,Remark);

        arrayListCol.add(6, arrayListRow);
        arrayListRow = new ArrayList();
        String archivesFoundMan= archives.getAARCHIVES_FOUND_MAN();           //立卷人
        if (archivesFoundMan == null) {
          archivesFoundMan = "";
        }
        arrayListRow.add(0, "");
        arrayListRow.add(1, "");
        arrayListRow.add(2, "立卷人:");
        arrayListRow.add(3, archivesFoundMan);
        arrayListCol.add(7, arrayListRow);

        //立卷时间
        arrayListRow = new ArrayList();
        String MontharchivesFoundDate="";
        String YeararchivesFoundDate="";
        String DatearchivesFoundDate="";
        String archivesFoundDate = archives.getAARCHIVES_FOUND_DATE();
        String BLarchivesFoundDate="";
        if (archivesFoundDate == null) {
          archivesFoundDate =  "    " + "年" + "  " + "月" + "  " + "日";;
        }

        arrayListRow.add(0, "");
        arrayListRow.add(1, "");
        arrayListRow.add(2,  archivesFoundDate);
        arrayListCol.add(8, arrayListRow);
        //审核人
        arrayListRow = new ArrayList();
        arrayListRow.add(0, "");
        arrayListRow.add(1, "");
        arrayListRow.add(2, "审核人:");
//        arrayListRow.add(3, "");
        String CheckMan=archives.getAMAKE_MAN();
        if (CheckMan == null) {
          CheckMan = "";
        }
        arrayListRow.add(3, CheckMan);
        arrayListCol.add(9, arrayListRow);

        //审核日期
        arrayListRow = new ArrayList();
        String sDate=archives.getAARC_DATE();
        if (sDate == null) {
          sDate = "00000000";
        }
        int nDate=Integer.parseInt(sDate);
        String shenHeDate="    "+nDate/10000 +"年";
        shenHeDate +=nDate%10000/100 +"月";
        shenHeDate +=nDate%100 +"日";
        arrayListRow.add(0, "");
        arrayListRow.add(1, "");
        arrayListRow.add(2, shenHeDate);
        arrayListCol.add(10, arrayListRow);

        arrayListRow = new ArrayList();
        String archivesNum = archives.getAARCHIVES_NUM();
        if (archivesNum == null) {
          archivesNum = "";
        }
        arrayListRow.add(0, "");
        arrayListRow.add(1, "");
        arrayListRow.add(2, "");
        arrayListRow.add(3, archivesNum);
        arrayListCol.add(11, arrayListRow);
        return arrayListCol;
    }
////////////////////
}