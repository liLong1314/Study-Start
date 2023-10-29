package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.PageOperDao;
import com.sunyard.hgam.presentation.form.adc.CheckArchivesPageForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesPageDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import java.util.Iterator;
import com.sunyard.hgam.persistence.dao.beans.arm.PageOper;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.util.adc.AdcUtil;
import java.io.File;
import java.io.IOException;

/**
 *
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 * @log:
 * 1、新增文件，确保影像页可以直接查看（而不用列表），且可翻页
 */
public class ViewArchivesPageAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws
      IOException {
    String strForward = "SUCCESS";
    String page = request.getParameter("page");
    //取得文件ID
    String fileId = request.getParameter("fileId");
    //根据需要将文件ID保存到SESSION中
    if (fileId != null && fileId != "") {
      request.getSession().setAttribute("fileId", fileId);
    }
    else {
      fileId = request.getSession().getAttribute("fileId").toString();
    }

    PaginatedList pageImageList = (PaginatedList) request.getSession().getAttribute(
        "pageImageList");

    if (pageImageList == null || page==null) {
      PageOperDao pageOperDao = (PageOperDao) domainLogic.getDAO("PageOper");
      pageImageList = pageOperDao.getPages(fileId,1);
      request.getSession().setAttribute("pageImageList", pageImageList);
    }else {
      PagedListHelper.pageTo(pageImageList, page);
    }

    //取得当前页影像页的ID
    Iterator pageListIterator = pageImageList.iterator();
    if(pageListIterator.hasNext()){
      PageOper pageOper=(PageOper)pageListIterator.next();
      String pageId =pageOper.getPageId();

      //处理显示问题-BEGIN
      try {
        String fileName;
        CheckArchivesPageForm capForm = (CheckArchivesPageForm) form;
        String fileSeparator = System.getProperty("file.separator");
        String sSrcFile = "";
        String sDesFile = "";

        ArchivesPageDao dao = (ArchivesPageDao) domainLogic.getDAO("ArchivesPage");
        ArchivesPage archivesPage = dao.getArchivesPageByPageID(new Integer(pageId));

        fileName = archivesPage.getPage_pathName();

        //修订：郑先全，20040204
        //设置页所在的文件名称
        //begin
        /*
        ArchivesFileDao archivesFileDao = (ArchivesFileDao) domainLogic.getDAO(
            "ArchivesFile");
        String fileId = archivesPage.getFile_id();
        if (fileId != null) {
          ArchivesFile archivesFile = archivesFileDao.getArchivesFileByFileID(
              fileId);
          archivesPage.setFile_id(archivesFile.getFile_title());
        }*/
        //end

        //对服务器上进行文件操作
        fileName = fileName.replace('/', '\\');
        if (fileName.indexOf("\\") == 0)
          fileName = fileName.substring(fileName.indexOf("\\") + 1);
        capForm.setServerFileName(fileName.substring(fileName.indexOf("\\") + 1));
        capForm.setServerDir(IDGenerator.getTimeString());

        sSrcFile =
            AdcUtil.AttachString(capForm.getProperiesInfo().getFileroot(),
                                 fileSeparator) + fileName;
        sDesFile =
            AdcUtil.AttachString(capForm.getProperiesInfo().getFtproot(),fileSeparator) +
            capForm.getServerDir() + fileSeparator + capForm.getServerFileName();
        File f = new File(sSrcFile);
        if (f.exists()) {
          AdcUtil.createFolder(capForm.getProperiesInfo().getFtproot(),capForm.getServerDir());
          AdcUtil.fileCopy(sSrcFile, sDesFile);
        }
        else {
          capForm.setServerDir("");
          capForm.setServerFileName("");
        }

        //返回成功信息，客户端可以通过FTP下载影像页了。
        capForm.setFunctionName("PageFileReady");

        if (archivesPage != null) {
          capForm.setArchivesPage(archivesPage);
        }
        else {
          strForward = "FAILURE";
        }
      }
      catch (Exception ex) {
        strForward = "FAILURE";
        ex.printStackTrace();
      }
      //处理显示问题-END
    }else{
      //没有影像页
      response.getWriter().println("错误：没有影像页！");
      strForward = "FAILURE";
    }

    return mapping.findForward("SUCCESS");
  }
}