package com.sunyard.hgam.presentation.action.adc;

import java.util.*;
import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.*;
import com.sunyard.hgam.persistence.dao.iface.adc.*;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesPageDao;
import com.sunyard.hgam.presentation.base.IDGenerator;
import com.sunyard.hgam.util.adc.AdcUtil;
import com.sunyard.hgam.util.adc.FileInfoTrans;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.util.common.FtpClient;
import com.sunyard.hgam.util.adc.PropertiesInfo;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class ArchivesPageAction
    extends BaseAction {
  private String ftpRoot = "";
  private String fileRoot = "";

  public ArchivesPageAction() {
  }

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {
    String forwardJSP = "ARCHIVESPAGE";
    ArchivesPageForm archivesPageForm = (ArchivesPageForm) form;

    String functionName = archivesPageForm.getFunctionName();
    archivesPageForm.setFunctionName("");

    //����ɨ���Ӱ��
    if ("SaveScanPage".equalsIgnoreCase(functionName)) {
      ftpRoot = archivesPageForm.getProperiesInfo().getFtproot() ;
      fileRoot = archivesPageForm.getProperiesInfo().getFileroot() ;

      //���������ݿ�
      boolean bRet = addPage(archivesPageForm.getArchives_id(),
                             archivesPageForm.getFile_id(),
                             archivesPageForm.getFolderName(),
                             "1", 0);
      if (bRet){
        //1. ����ɹ������سɹ���Ϣ��JSPҳ�棬��JSPҳ�渺��ɾ��������ʱ�ļ���
        archivesPageForm.setFunctionName("SaveOK");
      }else{
        //1. ����ʧ�ܣ�����ʧ����Ϣ��JSPҳ��
        archivesPageForm.setFunctionName("SaveFail");
      }

      forwardJSP = "SaveScanPage";
      return (mapping.findForward(forwardJSP));
    }else if ("SaveOK".equalsIgnoreCase(functionName)) {
      //2. ����ɹ���JSPҳ��ɹ�ɾ��������ʱ�ļ�����ת��һҳ��
      forwardJSP = "success";
      return (mapping.findForward(forwardJSP));
    }

    //��ȡ����ID���ļ�ID����
    String archives_id = request.getParameter("archives_id");
    archivesPageForm.setArchives_id(archives_id) ;
    String file_id = request.getParameter("file_id");
    archivesPageForm.setFile_id(file_id) ;

    //�Ӳ������ȡ ��ʾ�������������š��ļ�����
    archivesPageForm.setFile_title(request.getParameter("file_title")) ;
    archivesPageForm.setArchives_name(request.getParameter("archives_name")) ;
    archivesPageForm.setArchives_num(request.getParameter("archives_num")) ;

    //���ÿͻ����ϴ�Ӱ��FTP��������Ŀ¼
    String folderName = IDGenerator.getTimeString();
    archivesPageForm.setFolderName(folderName);

    return (mapping.findForward(forwardJSP));
  }

  /**
   * ����file_id �����ļ�����
   * @param dao
   * @param file_id
   * @return
   * @throws java.lang.Exception
   */
  public String getFile_title(ArchivesFileDao dao, int file_id) throws Exception {
    String sRet = "";
    if (dao==null){
       dao = (ArchivesFileDao) domainLogic.getDAO("ArchivesFile");
    }
    ArchivesFile af= dao.getArchivesFileByFileID(Integer.toString(file_id));
    sRet = af.getFile_title() ;
    return sRet;
  }

  /**
   * ��ɨ��¼�롢��ɨ��
   *   ����ɨ�����ݣ���ɨ���ļ��ϴ���cm���������õ���Ӧ��ID��Ȼ���rollID, pieceID ��Ӧ���
   *
   * @param archives_id ��ǰɨ��ҳ���ڵĵ���
   * @param file_id ��ǰɨ��ҳ���ڵ��ļ�ID
   * @param directoryName �����ϴ��ļ���Ŀ¼�������fileInfo.XML��û���ļ���Ϣ���򷵻�false
   * @param pageType   =1 ��������   =2���϶���
   * @param page_id   <>0�Ҵ��ڣ����ʾ��ɨʱ������á����Ϊ�ջ򲻴��ڣ���Ϊ"ɨ��¼��"
   * @return  boolean  ��������Ƿ�ɹ� true �ɹ�   false ʧ��
   */
  private boolean addPage(String archives_id, String file_id,
                          String directoryName, String pageType, int page_id) throws
      Exception {
    boolean bRet = false;
    String fileSeparator = System.getProperty("file.separator");
    String myRoot = "";
    String exceptionMsg = "save fail";

    ArchivesPageDao dao = (ArchivesPageDao) domainLogic.getDAO("ArchivesPage");
    ArchivesPage apInsert = new ArchivesPage();

    try {
      boolean bExistObject = false;
      String sPageNum;
      String sIsPicture;
      String zipPath = "ScanImage" + fileSeparator + "00001" + fileSeparator;
      String sSrcFile = "";
      String sDesFile = "";
      String sFileName;
      String sFileType;
      int nMaxPage;

      //�⿪�ͻ��˴��������� zip ���ļ���
      //��ѹ�����·��
      myRoot = AdcUtil.AttachString(ftpRoot, fileSeparator) + directoryName +
          fileSeparator;
      String zipFilePath = myRoot + "SubmitTemp.zip";
      AdcUtil.UnzipFile(zipFilePath);

      //���� fileInfo.xml
      FileInfoTrans filInfoTrans = new FileInfoTrans();
      Hashtable htFile;
      String xmlFilePath = myRoot + zipPath + "FileInfo.xml";
      filInfoTrans.setResourceXmlFileName(xmlFilePath);
      filInfoTrans.TransToHashtable();
      htFile = filInfoTrans.getFileInfo();
      if (htFile.size() < 1) {
        return false;
      }

      //��������� fileInfo.Xml�ļ���Ϣ
      //System.out.println(htFile);

      //���ҳ��
      nMaxPage = dao.getMaxPageNum(new Integer(archives_id)) ;

      //
      //��ɨ��ɨʱ���ж������ page_id �Ƿ����( bExistObject = true ,  nMaxPage= objectIDҳ��)
      if (page_id != 0) {
        ArchivesPage ap = dao.getArchivesPageByPageID(new Integer(page_id));
        if (ap!=null){
          bExistObject = true;
          nMaxPage = Integer.parseInt(ap.getPage_num());
        }
      }

      //ѭ��ÿһ���ļ�Ӱ��ҳ��,���浽���ݿ�
      Enumeration eKeys;
      Enumeration eField;
      try {
        eKeys = htFile.keys();
        eField = htFile.elements();

        for (int i = 0; i < htFile.size(); i++) {
          Vector vFile = (Vector) htFile.get(Integer.toString(i));
          sSrcFile = myRoot + zipPath + (String) vFile.elementAt(0);
          sPageNum = (String) vFile.elementAt(1);
          sIsPicture = (String) vFile.elementAt(3);

          //���ɵ�ǰҳ��
          if (bExistObject == false) { //ɨ��¼�룬ҳ�����ҳ��ʼ���
            sPageNum = Integer.toString(nMaxPage
                                        + Integer.parseInt(sPageNum));
          }
          else { //��ɨ�����뵽ԭҳ��֮ǰ
            sPageNum = Integer.toString(nMaxPage - htFile.size() +
                                        i);
          }

          //���ɵ�ǰĿ���ļ�����չ�����ļ������ļ�·��
          sFileType = AdcUtil.getFileExtentName(sSrcFile);
          sFileName = AdcUtil.getTimeString() ;
          AdcUtil.createFolder(fileRoot, sFileName.substring(0, 6)) ;//����Ŀ��Ŀ¼
          sDesFile = AdcUtil.AttachString(fileRoot, fileSeparator) +
              sFileName.substring(0, 6) + fileSeparator +
              sFileName.substring(6, sFileName.length()) + "." + sFileType;
          String page_pathName = fileSeparator +
              sFileName.substring(0, 6) + fileSeparator +
              sFileName.substring(6, sFileName.length()) + "." + sFileType;

          //1. �Ƚ�Ӱ�񿽱���Ŀ�ꡰ�ļ�ϵͳ����
          if (!AdcUtil.fileCopy(sSrcFile, sDesFile))
            return false;

          //2. �����������ݵ���Ӱ��ҳ����
          java.sql.Timestamp ts = new java.sql.Timestamp(System.
              currentTimeMillis());
          apInsert.setPage_date(ts.toString().substring(0, 10));
          apInsert.setPage_pathName(page_pathName.replace('\\', '/')) ;//Ӱ���ļ�·����
          apInsert.setArchives_id(archives_id);
          apInsert.setFile_id(file_id);
          apInsert.setPage_operate("1") ;
          apInsert.setPage_status("NOPASS");
          apInsert.setPage_id(Integer.toString(dao.getMaxPageID() +
                                               1));
          apInsert.setPage_num(sPageNum);
          apInsert.setPage_size("1"); //Ӱ��ҳ��С
          apInsert.setPage_type(sFileType);
          apInsert.setData_file_id(null) ;
          apInsert.setRemark(" ");
          apInsert.setPage_area("");
          if (dao.addArchivesPage(apInsert) < 1){
            //����ʧ��
            return false;
          }
        }//next for

        //��ɨ���ܣ������page_id״̬Ϊ "δͨ��"
        if (bExistObject == true) {
          ArchivesPage apUpdate = new ArchivesPage();
          apUpdate.setPage_id(Integer.toString(page_id)) ;
          apUpdate.setPage_status("NOPASS") ;
          dao.updateArchivesPageStatus(apUpdate);
        }
      }
      catch (Exception e) {
        e.printStackTrace() ;
      }
      bRet = true;
    }
    catch (Exception e) {
      e.printStackTrace();
      bRet = false;
      throw e;
    }
    finally {
      //ɾ����ʱĿ¼���ļ�����zip�ļ�
      if (myRoot != "") {
        AdcUtil.deletePath(myRoot);
      }
    }
    return bRet;
  }

  public static void main(String[] argv) {
    try{
      AdcUtil.deletePath("f:\\bb\\");

    }catch(Exception e){
      e.printStackTrace() ;
    }
  }

}