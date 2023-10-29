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
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 * @log:
 * 1�������ļ���ȷ��Ӱ��ҳ����ֱ�Ӳ鿴���������б����ҿɷ�ҳ
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
    //ȡ���ļ�ID
    String fileId = request.getParameter("fileId");
    //������Ҫ���ļ�ID���浽SESSION��
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

    //ȡ�õ�ǰҳӰ��ҳ��ID
    Iterator pageListIterator = pageImageList.iterator();
    if(pageListIterator.hasNext()){
      PageOper pageOper=(PageOper)pageListIterator.next();
      String pageId =pageOper.getPageId();

      //������ʾ����-BEGIN
      try {
        String fileName;
        CheckArchivesPageForm capForm = (CheckArchivesPageForm) form;
        String fileSeparator = System.getProperty("file.separator");
        String sSrcFile = "";
        String sDesFile = "";

        ArchivesPageDao dao = (ArchivesPageDao) domainLogic.getDAO("ArchivesPage");
        ArchivesPage archivesPage = dao.getArchivesPageByPageID(new Integer(pageId));

        fileName = archivesPage.getPage_pathName();

        //�޶���֣��ȫ��20040204
        //����ҳ���ڵ��ļ�����
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

        //�Է������Ͻ����ļ�����
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

        //���سɹ���Ϣ���ͻ��˿���ͨ��FTP����Ӱ��ҳ�ˡ�
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
      //������ʾ����-END
    }else{
      //û��Ӱ��ҳ
      response.getWriter().println("����û��Ӱ��ҳ��");
      strForward = "FAILURE";
    }

    return mapping.findForward("SUCCESS");
  }
}