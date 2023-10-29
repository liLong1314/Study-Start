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
 * <p>Description: 杭州市规划档案综合管理系统</p>
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

    //保存扫描的影像
    if ("SaveScanPage".equalsIgnoreCase(functionName)) {
      ftpRoot = archivesPageForm.getProperiesInfo().getFtproot() ;
      fileRoot = archivesPageForm.getProperiesInfo().getFileroot() ;

      //保存至数据库
      boolean bRet = addPage(archivesPageForm.getArchives_id(),
                             archivesPageForm.getFile_id(),
                             archivesPageForm.getFolderName(),
                             "1", 0);
      if (bRet){
        //1. 保存成功，返回成功信息给JSP页面，（JSP页面负责删除本地临时文件）
        archivesPageForm.setFunctionName("SaveOK");
      }else{
        //1. 保存失败，返回失败信息给JSP页面
        archivesPageForm.setFunctionName("SaveFail");
      }

      forwardJSP = "SaveScanPage";
      return (mapping.findForward(forwardJSP));
    }else if ("SaveOK".equalsIgnoreCase(functionName)) {
      //2. 保存成功，JSP页面成功删除本地临时文件，跳转下一页面
      forwardJSP = "success";
      return (mapping.findForward(forwardJSP));
    }

    //获取档案ID、文件ID参数
    String archives_id = request.getParameter("archives_id");
    archivesPageForm.setArchives_id(archives_id) ;
    String file_id = request.getParameter("file_id");
    archivesPageForm.setFile_id(file_id) ;

    //从参数表读取 显示档案题名、档号、文件标题
    archivesPageForm.setFile_title(request.getParameter("file_title")) ;
    archivesPageForm.setArchives_name(request.getParameter("archives_name")) ;
    archivesPageForm.setArchives_num(request.getParameter("archives_num")) ;

    //设置客户端上传影像到FTP服务器的目录
    String folderName = IDGenerator.getTimeString();
    archivesPageForm.setFolderName(folderName);

    return (mapping.findForward(forwardJSP));
  }

  /**
   * 根据file_id 返回文件标题
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
   * 【扫描录入、补扫】
   *   保存扫描数据，把扫描文件上传到cm服务器，得到相应的ID，然后跟rollID, pieceID 对应填表。
   *
   * @param archives_id 当前扫描页属于的档号
   * @param file_id 当前扫描页属于的文件ID
   * @param directoryName 保存上传文件的目录名，如果fileInfo.XML中没有文件信息，则返回false
   * @param pageType   =1 档案对象   =2资料对象
   * @param page_id   <>0且存在，则表示补扫时保存调用。如果为空或不存在，则为"扫描录入"
   * @return  boolean  保存操作是否成功 true 成功   false 失败
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

      //解开客户端传输上来的 zip 包文件，
      //解压缩后的路径
      myRoot = AdcUtil.AttachString(ftpRoot, fileSeparator) + directoryName +
          fileSeparator;
      String zipFilePath = myRoot + "SubmitTemp.zip";
      AdcUtil.UnzipFile(zipFilePath);

      //解析 fileInfo.xml
      FileInfoTrans filInfoTrans = new FileInfoTrans();
      Hashtable htFile;
      String xmlFilePath = myRoot + zipPath + "FileInfo.xml";
      filInfoTrans.setResourceXmlFileName(xmlFilePath);
      filInfoTrans.TransToHashtable();
      htFile = filInfoTrans.getFileInfo();
      if (htFile.size() < 1) {
        return false;
      }

      //经过处理的 fileInfo.Xml文件信息
      //System.out.println(htFile);

      //最大页码
      nMaxPage = dao.getMaxPageNum(new Integer(archives_id)) ;

      //
      //重扫补扫时，判断输入的 page_id 是否存在( bExistObject = true ,  nMaxPage= objectID页码)
      if (page_id != 0) {
        ArchivesPage ap = dao.getArchivesPageByPageID(new Integer(page_id));
        if (ap!=null){
          bExistObject = true;
          nMaxPage = Integer.parseInt(ap.getPage_num());
        }
      }

      //循环每一个文件影像（页）,保存到数据库
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

          //生成当前页码
          if (bExistObject == false) { //扫描录入，页码最大页开始编号
            sPageNum = Integer.toString(nMaxPage
                                        + Integer.parseInt(sPageNum));
          }
          else { //补扫，插入到原页码之前
            sPageNum = Integer.toString(nMaxPage - htFile.size() +
                                        i);
          }

          //生成当前目标文件的扩展名、文件名、文件路径
          sFileType = AdcUtil.getFileExtentName(sSrcFile);
          sFileName = AdcUtil.getTimeString() ;
          AdcUtil.createFolder(fileRoot, sFileName.substring(0, 6)) ;//建立目标目录
          sDesFile = AdcUtil.AttachString(fileRoot, fileSeparator) +
              sFileName.substring(0, 6) + fileSeparator +
              sFileName.substring(6, sFileName.length()) + "." + sFileType;
          String page_pathName = fileSeparator +
              sFileName.substring(0, 6) + fileSeparator +
              sFileName.substring(6, sFileName.length()) + "." + sFileType;

          //1. 先将影像拷贝到目标“文件系统”中
          if (!AdcUtil.fileCopy(sSrcFile, sDesFile))
            return false;

          //2. 保存索引数据到“影像页”表
          java.sql.Timestamp ts = new java.sql.Timestamp(System.
              currentTimeMillis());
          apInsert.setPage_date(ts.toString().substring(0, 10));
          apInsert.setPage_pathName(page_pathName.replace('\\', '/')) ;//影像文件路径名
          apInsert.setArchives_id(archives_id);
          apInsert.setFile_id(file_id);
          apInsert.setPage_operate("1") ;
          apInsert.setPage_status("NOPASS");
          apInsert.setPage_id(Integer.toString(dao.getMaxPageID() +
                                               1));
          apInsert.setPage_num(sPageNum);
          apInsert.setPage_size("1"); //影像页大小
          apInsert.setPage_type(sFileType);
          apInsert.setData_file_id(null) ;
          apInsert.setRemark(" ");
          apInsert.setPage_area("");
          if (dao.addArchivesPage(apInsert) < 1){
            //保存失败
            return false;
          }
        }//next for

        //补扫功能，则更新page_id状态为 "未通过"
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
      //删除临时目录、文件、和zip文件
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