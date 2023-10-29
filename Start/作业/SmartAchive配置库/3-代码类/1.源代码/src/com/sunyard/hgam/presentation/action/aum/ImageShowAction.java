package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.CheckArchivesPageForm;
import com.sunyard.hgam.persistence.dao.iface.arm.PageOperDao;
import java.io.File;
import com.sunyard.hgam.util.adc.AdcUtil;
import com.sunyard.hgam.persistence.dao.beans.arm.PageOper;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesPageDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;

/**
 * <p>Title: 综合查询－显示影像</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class ImageShowAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    try {
      String pageId = request.getParameter("pageId");
      String fileName;
      CheckArchivesPageForm capForm = (CheckArchivesPageForm) form;
      String fileSeparator = System.getProperty("file.separator");
      String sSrcFile = "";
      String sDesFile = "";

      ArchivesPageDao dao = (ArchivesPageDao) domainLogic.getDAO("ArchivesPage");
      ArchivesPage page= dao.getArchivesPageByPageID(new Integer(pageId)) ;

      fileName = page.getPage_pathName();

      //修订：郑先全，20040204
      //设置页所在的文件名称
      //begin
      ArchivesFileDao archivesFileDao = (ArchivesFileDao) domainLogic.getDAO("ArchivesFile");
      String fileId = page.getFile_id();
      if (fileId!=null){
        ArchivesFile archivesFile = archivesFileDao.getArchivesFileByFileID(fileId);
        page.setFile_id(archivesFile.getFile_title());
      }
      //end

      //对服务器上进行文件操作
      fileName = fileName.replace('/', '\\');
      if (fileName.indexOf("\\") == 0)
        fileName = fileName.substring(fileName.indexOf("\\") + 1);
      capForm.setServerFileName(fileName.substring(fileName.indexOf("\\") + 1));
      capForm.setServerDir(IDGenerator.getTimeString());

      sSrcFile =
          AdcUtil.AttachString(capForm.getProperiesInfo().getFileroot(),
                               fileSeparator) +
          fileName;
      sDesFile =
          AdcUtil.AttachString(capForm.getProperiesInfo().getFtproot(),
                               fileSeparator) +
          capForm.getServerDir() + fileSeparator + capForm.getServerFileName();
      File f = new File(sSrcFile);
      if (f.exists()) {
        AdcUtil.createFolder(capForm.getProperiesInfo().getFtproot(),
                             capForm.getServerDir());
        AdcUtil.fileCopy(sSrcFile, sDesFile);
      }
      else {
        capForm.setServerDir("");
        capForm.setServerFileName("");
      }

      //返回成功信息，客户端可以通过FTP下载影像页了。
      capForm.setFunctionName("PageFileReady");

      if (page != null) {
        capForm.setArchivesPage(page);
        //request.setAttribute("pageOper", page);
      }
      else {
        return mapping.findForward("Failed");
      }
    }
    catch (Exception ex) {

    }
    return mapping.findForward("success");

  }

}