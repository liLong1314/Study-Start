package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.arm.PageOperDao;
import com.sunyard.hgam.persistence.dao.beans.arm.PageOper;
import com.sunyard.hgam.presentation.form.adc.*;
import com.sunyard.hgam.util.adc.AdcUtil ;
import java.io.File;

/**
 * <p>Title: 显示页面影像</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class ArchImageShowAction
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

      PageOperDao pageOperDao = (PageOperDao) domainLogic.getDAO("PageOper");
      PageOper newPage = new PageOper();
      newPage = pageOperDao.getPage(pageId);
      fileName = newPage.getPagePathName();

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

      if (newPage != null) {
        request.setAttribute("pageOper", newPage);
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