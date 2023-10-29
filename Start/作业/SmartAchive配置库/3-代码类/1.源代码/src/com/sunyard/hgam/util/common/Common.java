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

  /**ҵ��������ļ�Ŀ¼
   * ����archives_id ���ص����ľ����ļ�Ŀ¼���Զ�������ķ�ʽ���أ�
   * @param archives_id      ����ID
   * @return Iterator        ����Ԫ�ػ���ΪArrayList
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

        //�õ��ü�����ʼҳ��  sStartPage
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
            sStartPage += "��" + sMaxPage;
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
    sStartPage += "��" + sMaxPage;*/

        alRow.add(Integer.toString(n + 1)); //���

        //�ĺ�
        String pieceNum = af.getFile_num() ;
        if (pieceNum == null) {
          pieceNum = "";
        }
        alRow.add(pieceNum);

        //������
        String dutyMan = af.getFile_duty() ;
        if (dutyMan == null) {
          dutyMan = "";
        }
        alRow.add(dutyMan);

        //������
        String pieceName = af.getFile_title() ;
        if (pieceName == null) {
          pieceName = "";
        }
        alRow.add(pieceName);

        //����
        String pieceDate = af.getFile_date();
        if (pieceDate == null) {
           pieceDate = "";
        }
        alRow.add(pieceDate);
        //ҳ��
        String pieceFromTo = af.getPage_num_from_to() ;
       if (pieceFromTo == null) {
         pieceFromTo = "";
       }
       alRow.add(pieceFromTo);

        //��ע
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
  /**ҵ���������Ҫ�޸�
     * ����archives_id ���ص����ľ����ļ�Ŀ¼���Զ�������ķ�ʽ���أ�
     * @param archives_id      ����ID
     * @return Iterator   ����Ԫ�ػ���ΪArrayList
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
     //�������֤��','�������֤��','�õر��
     String a = "    ";
     String b = "    ";
     String c = "    ";
     while(listIterator.hasNext()){
       EformFieldValue aValue = (EformFieldValue) listIterator.next();
       if(aValue.getField_cname().trim().equals("�������֤��")){
          a += aValue.getField_value();
       }
       if(aValue.getField_cname().trim().equals("�������֤��")){
          b += aValue.getField_value();
       }
       if(aValue.getField_cname().trim().equals("�õ����֤��")){
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

      //����

     String archivesNum = archives.getAARCHIVES_NUM();
      if (archivesNum == null)
      archivesNum = "";
      String archivesNum1="    ";
      archivesNum1 +=archivesNum;
     arrayListRow.add(0,"��    ��");
    arrayListRow.add(1, archivesNum1);
    arrayListRow.add(2, "");
    arrayListRow.add(3, "");
    //�������֤�ţ���Ҫ�޸ģ�
     arrayListRow.add(4, "�������֤��");
    arrayListRow.add(5, a);
    arrayListCol.add(0, arrayListRow);

    arrayListCol.add(1, new ArrayList());
    //�����ݺ�
    arrayListRow = new ArrayList();
    String roomCode =archives.getAARCHIVES_ROOM_CODE();
    if (roomCode == null)
      roomCode = "";
     String roomCode1="    ";
     roomCode1 +=roomCode;
    arrayListRow.add(0,"�����ݺ�");
    arrayListRow.add(1, roomCode1);
     arrayListRow.add(2, "");
    //�õ����֤�ţ���Ҫ�޸ģ�
     arrayListRow.add(3, "");
    arrayListRow.add(4,"�õ����֤��");
    arrayListRow.add(5,c);
    arrayListCol.add(2, arrayListRow);

    arrayListCol.add(3, new ArrayList());
    //��΢��
    arrayListRow = new ArrayList();
   String reduceNum = archives.getAREDUCE_NUM();
    if (reduceNum == null)
      reduceNum = "";
      String reduceNum1="    ";
      reduceNum1 +=reduceNum;
    arrayListRow.add(0,"�� ΢ ��");
    arrayListRow.add(1,reduceNum1);
    arrayListRow.add(2,"");
    arrayListCol.add(4, arrayListRow);
    arrayListCol.add(5, new ArrayList());
    //��������
    String archivesName1="        ";
    String archivesName2="";
    int archivesNamelen=0;
    arrayListRow = new ArrayList();
    String archivesName = archives.getAARCHIVES_NAME();
    if (archivesName == null){
      archivesName = "";
    archivesName1 = "";}
    arrayListRow.add(0,"��������");
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
    //���Ƶ�λ
    arrayListRow = new ArrayList();
    String archivesFoundUnit =archives.getAARCHIVES_FOUND_UNIT();
    if (archivesFoundUnit == null)
      archivesFoundUnit = "";
    String archivesFoundUnit1="    ";
    archivesFoundUnit1 +=archivesFoundUnit;
    arrayListRow.add(0,"���Ƶ�λ");
    arrayListRow.add(1,archivesFoundUnit1);
    arrayListCol.add(8, arrayListRow);
    //��������
    arrayListRow = new ArrayList();
    String archivesMakePeriod =archives.getAARCHIVES_MAKE_PERIOD();
    if (archivesMakePeriod == null) {
            archivesMakePeriod = "";
           }
    String archivesMakePeriod1="    ";
    archivesMakePeriod1 +=archivesMakePeriod;
    arrayListRow.add(0,"��������");
    arrayListRow.add(1,archivesMakePeriod1);
    arrayListCol.add(9, arrayListRow);
    //��������
    arrayListRow = new ArrayList();
    String storeTerm =archives.getASTORE_TERM();
    if (storeTerm == null)
      storeTerm = "";
    String storeTerm1="    ";
    storeTerm1 +=storeTerm;
    arrayListRow.add(0,"��������");
    arrayListRow.add(1,storeTerm1);
    arrayListCol.add(10, arrayListRow);

    //�ܼ�
    arrayListRow = new ArrayList();
    String secretId =archives.getASECRET_ID();
    if (secretId == null)
      secretId = "";
     String secretId1="    ";
     secretId1 +=secretId;
    arrayListRow.add(0,"��    ��");
    arrayListRow.add(1,secretId1);
    arrayListRow.add(2,"");
     arrayListCol.add(11, arrayListRow);
    return arrayListCol;
}
  /**�����ౡ�����
    * ����archives_id ���������൵���ķ��棬�Զ�������ķ�ʽ���أ�
    * @param archives_id      ����ID
    * @return Iterator        ����Ԫ�ػ���ΪArrayList
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


        //������λ
        String archivesFoundUnit = archives.getAARCHIVES_FOUND_UNIT();
        if (archivesFoundUnit == null)
        archivesFoundUnit = "";
       arrayListRow.add(0,archivesFoundUnit);
      arrayListCol.add(0, arrayListRow);
      //�����Ҫ�޸ģ�
       arrayListRow = new ArrayList();
       String entryId = archives.getAENTRY_ID();
       if (entryId == null)
        entryId = "";
      arrayListRow.add(0,entryId);
      arrayListCol.add(1, arrayListRow);
      //��������
      arrayListRow = new ArrayList();
      String archivesName=archives.getAARCHIVES_NAME();
      if (archivesName == null)
        archivesName = "";
      arrayListRow.add(0,archivesName);
      arrayListCol.add(2, arrayListRow);

       arrayListRow = new ArrayList(4);
      //������ֹ����
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

    String BbeginEndDate = "�� ";
    BbeginEndDate += YearbeginDate;
    BbeginEndDate += " �� ";
    BbeginEndDate += MonthbeginDate;
    BbeginEndDate += " ��";
    BbeginEndDate += " �� ";
    BbeginEndDate += YearendDate;
    BbeginEndDate += " �� ";
     BbeginEndDate += MonthendDate;
    BbeginEndDate += " ��";
    arrayListRow.add(0, BbeginEndDate);
    arrayListRow.add(1, "��������");
    arrayListRow.add(2, "");

      //��������
       String storeTerm= archives.getASTORE_TERM();
       if (storeTerm == null) {
      storeTerm = "";
    }
    arrayListRow.add(3, storeTerm);
    arrayListCol.add(3, arrayListRow);
      //��ҳ��
      arrayListRow = new ArrayList();
    String pageAmount = archives.getAPAGE_AMOUNT();
    if (pageAmount == null) {
      pageAmount = "";
    }

    arrayListRow.add(0, "���� " + "" + " �� " + pageAmount + " ҳ");
    arrayListRow.add(1, "�鵵��");
    arrayListRow.add(2, "");
    //�鵵��
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


    //ȫ�ں�
  String foundsNum = archives.getAFONDS_NUM();
  if (foundsNum == null) {
    foundsNum = "";
  }
   arrayListRow.add(1, "");
  arrayListRow.add(2, foundsNum);
  //Ŀ¼��
  String catalogNum = archives.getACATALOG_NUM();
  if (catalogNum == null) {
    catalogNum = "";
  }
  arrayListRow.add(3, catalogNum);
  //�����
  String rollNum = archives.getAROLL_NUM();
  if (rollNum == null) {
    rollNum = "";
  }
  arrayListRow.add(4, rollNum);
  arrayListCol.add(7, arrayListRow);

  return arrayListCol;

}

  /**�����������Ŀ¼
     * ����archives_id ���ص����ľ����ļ�Ŀ¼���Զ�������ķ�ʽ���أ�
     * @param archives_id      ����ID
     * @return Iterator        ����Ԫ�ػ���ΪArrayList
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

          //�õ��ü�����ʼҳ��  sStartPage
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
              sStartPage += "��" + sMaxPage;
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
      sStartPage += "��" + sMaxPage;*/
      String rollYear=af.getProj_id();
      if (rollYear == null) {
            rollYear = "";
          }

       alRow.add(0,"    ���:" + rollYear);
        alRow.add(1,"");
        alRow.add(2,"");
        alRow.add(3,"");
        alRow.add(4,"���:");
        alRow.add(5,"");
        alSQL.add(0,alRow);
       alSQL.add(1,new ArrayList());
       alRow = new ArrayList();
      String pieceNum = af.getMedia_type();
      if (pieceNum == null) {
      pieceNum = "";
      }
      alRow.add(pieceNum);

          //������
          String fileDute = af.getFile_duty();
          if (fileDute == null) {
            fileDute = "";
          }
          alRow.add(fileDute);

          //�ĺ�
          String fileNum = af.getFile_num();
          if (fileNum == null) {
            fileNum = "";
          }
          alRow.add(fileNum);

          //�ļ�����
          String fileTitle = af.getFile_title() ;
          if (fileTitle == null) {
            fileTitle = "";
          }
          alRow.add(fileTitle);

          //����
          String fileDate = af.getFile_date();
          if (fileDate == null) {
             fileDate="";
          }


          alRow.add(fileDate);
          //ҳ��
          String filePageAmount = af.getFile_page_amount();
         if (filePageAmount == null) {
           filePageAmount = "";
         }
         alRow.add(filePageAmount);

          //��ע
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


    /**����������ڱ�����
        * ����archives_id ��������������ڱ������Զ�������ķ�ʽ���أ�
        * @param archives_id      ����ID
        * @return Iterator        ����Ԫ�ػ���ΪArrayList
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
               //�������˵��
              arrayListRow = new ArrayList();
              arrayListRow.add(0,"");
              arrayListRow.add(1,"�������˵��");
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
             //������
             arrayListRow = new ArrayList();
              String archivesFoundMan= archives.getAARCHIVES_FOUND_MAN();
              if (archivesFoundMan == null) {
             archivesFoundMan = "";
           }
           arrayListRow.add(0, "");
        arrayListRow.add(1, "");
        arrayListRow.add(2, "");

           arrayListRow.add(3, "������" + "  " + archivesFoundMan);
           arrayListCol.add(5, arrayListRow);

           arrayListCol.add(6, new ArrayList());
             //�����
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
           arrayListRow.add(3,"�����  "+Checker);
           arrayListCol.add(7, arrayListRow);

           arrayListCol.add(8, new ArrayList());
           //����ʱ��
           arrayListRow = new ArrayList();
        String archivesFoundDate = archives.getAARCHIVES_FOUND_DATE();
        if (archivesFoundDate == null) {
          archivesFoundDate = "";
        }
        arrayListRow.add(0, "");
        arrayListRow.add(1, "");
        arrayListRow.add(2, "");
        arrayListRow.add(3,  "����ʱ��" +"  "+ archivesFoundDate);
        arrayListCol.add(9, arrayListRow);

        arrayListCol.add(10, new ArrayList());
         return arrayListCol;

       }
       /**��ǩ
       * ����archives_id ���ر�ǩ���Զ�������ķ�ʽ���أ�
       * @param archives_id      ����ID
       * @return Iterator        ����Ԫ�ػ���ΪArrayList
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
              //��ǩ
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


      /**�ļ�����
         * ���ݿ�ʼ�ұ���ź���ֹ�ұ���� ���ص������ļ��������Զ�������ķ�ʽ���أ�
         * author hukp
         * @param
         * @return Iterator        ����Ԫ�ػ���ΪArrayList
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
       if (list.size() <= 0) {//��ҵ������
         return alSQL;
       }
       {
         ArchivesFile af = (ArchivesFile)list.get(0);
         ArrayList alRow = new ArrayList();
         String rollYear=af.getFile_status();//����Ϊ��������
         alRow = new ArrayList();
         if (rollYear == null){
               rollYear = "    ";
         }
         String pieceNum = af.getFile_store_term();
         if (pieceNum == null) {
           pieceNum = "  ";
         }
         alRow.add(0,"���:" + rollYear+"                                                         ���:"+pieceNum);
         alSQL.add(alRow);
       }
//       alSQL.add(1,new ArrayList());
       alSQL.add(new ArrayList());
       for (int n = 0; n < list.size(); n++)
       {
         ArchivesFile af = (ArchivesFile)list.get(n);
         ArrayList alRow = new ArrayList();
         alRow.add(Integer.toString(n + 1)); //���

         String dutyMan = af.getFile_duty();        //������
         if (dutyMan == null) {
           dutyMan = "";
         }
         alRow.add(dutyMan);

         String pieceNum = af.getFile_num() ;       //�ĺ�
         if (pieceNum == null) {
           pieceNum = "";
         }
         alRow.add(pieceNum);

         String pieceName = af.getFile_title();         //������
         if (pieceName == null) {
           pieceName = "";
         }
         alRow.add(pieceName);

         String pieceDate = af.getFile_date();         //����
         if (pieceDate == null) {
            pieceDate = "";
         }
         alRow.add(pieceDate);

         String pieceFromTo = af.getFile_page_amount() ;         //ҳ��
         if (pieceFromTo == null) {
           pieceFromTo = "";
         }
         alRow.add(pieceFromTo);

         String remark = af.getRemark() ;         //��ע
         if (remark == null) {
           remark = "";
         }
         alRow.add(remark);
         alSQL.add(alRow);
       } //end for
     return alSQL;
    }

    /**ҵ��������ڱ�����
     * ����archives_id ����ҵ��������ڱ������Զ�������ķ�ʽ���أ�
     * @param archives_id      ����ID
     * @return Iterator        ����Ԫ�ػ���ΪArrayList
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
            //���鰸�����
        arrayListRow = new ArrayList();
        String rollAmount=archives.getAROLL_AMOUNT();
        if (rollAmount == null) {
          rollAmount = "";
        }
        String AllPage=archives.getAMEDIA_TYPE();
        if (AllPage == null) {
          AllPage = "";
        }
        String bzbkao="���鰸�� " + rollAmount + " ��,  " + AllPage + " ҳ";
        arrayListRow.add(0,"");
        arrayListRow.add(1,bzbkao);
        arrayListRow.add(2,"");
        arrayListCol.add(1, arrayListRow);
        //�������
        arrayListRow = new ArrayList();
        arrayListRow.add(0,"");
        String rollSeq=archives.getAROLL_SEQ();
        if (rollSeq == null) {
          rollSeq = "";
        }

        String bjbkao="����Ϊ�� " + rollSeq + " ��,��ֹҳ��Ϊ  ";
        bjbkao += "";
        String pageNumFromTO=archives.getAPAGE_NUM_FROM_TO();
        arrayListRow.add(1,bjbkao+pageNumFromTO);
        arrayListCol.add(2, arrayListRow);
        //�������˵��
        String FilePage=archives.getANEGATIVE_NUM();
        if (FilePage == null) {
          FilePage = "";
        }
        String PicPage=archives.getAARCHIVES_UNIT();
        if (PicPage == null) {
          PicPage = "";
        }
        arrayListRow = new ArrayList();
        arrayListRow.add(0,"����:");
        arrayListRow.add(1,"�ļ����� " + FilePage + " ҳ");
        arrayListRow.add(2,"");
        arrayListCol.add(3, arrayListRow);

        arrayListRow = new ArrayList();
        arrayListRow.add(0,"");
        arrayListRow.add(1,"ͼֽ����" + PicPage + "ҳ");
        arrayListRow.add(2,"");
        arrayListCol.add(4, arrayListRow);

        //˵��
        arrayListRow = new ArrayList();
        arrayListRow.add(0,"˵��:");
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
        String archivesFoundMan= archives.getAARCHIVES_FOUND_MAN();           //������
        if (archivesFoundMan == null) {
          archivesFoundMan = "";
        }
        arrayListRow.add(0, "");
        arrayListRow.add(1, "");
        arrayListRow.add(2, "������:");
        arrayListRow.add(3, archivesFoundMan);
        arrayListCol.add(7, arrayListRow);

        //����ʱ��
        arrayListRow = new ArrayList();
        String MontharchivesFoundDate="";
        String YeararchivesFoundDate="";
        String DatearchivesFoundDate="";
        String archivesFoundDate = archives.getAARCHIVES_FOUND_DATE();
        String BLarchivesFoundDate="";
        if (archivesFoundDate == null) {
          archivesFoundDate =  "    " + "��" + "  " + "��" + "  " + "��";;
        }

        arrayListRow.add(0, "");
        arrayListRow.add(1, "");
        arrayListRow.add(2,  archivesFoundDate);
        arrayListCol.add(8, arrayListRow);
        //�����
        arrayListRow = new ArrayList();
        arrayListRow.add(0, "");
        arrayListRow.add(1, "");
        arrayListRow.add(2, "�����:");
//        arrayListRow.add(3, "");
        String CheckMan=archives.getAMAKE_MAN();
        if (CheckMan == null) {
          CheckMan = "";
        }
        arrayListRow.add(3, CheckMan);
        arrayListCol.add(9, arrayListRow);

        //�������
        arrayListRow = new ArrayList();
        String sDate=archives.getAARC_DATE();
        if (sDate == null) {
          sDate = "00000000";
        }
        int nDate=Integer.parseInt(sDate);
        String shenHeDate="    "+nDate/10000 +"��";
        shenHeDate +=nDate%10000/100 +"��";
        shenHeDate +=nDate%100 +"��";
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