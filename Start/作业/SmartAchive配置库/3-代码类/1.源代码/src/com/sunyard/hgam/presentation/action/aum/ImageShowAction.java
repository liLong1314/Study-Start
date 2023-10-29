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
 * <p>Title: �ۺϲ�ѯ����ʾӰ��</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
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

      //�޶���֣��ȫ��20040204
      //����ҳ���ڵ��ļ�����
      //begin
      ArchivesFileDao archivesFileDao = (ArchivesFileDao) domainLogic.getDAO("ArchivesFile");
      String fileId = page.getFile_id();
      if (fileId!=null){
        ArchivesFile archivesFile = archivesFileDao.getArchivesFileByFileID(fileId);
        page.setFile_id(archivesFile.getFile_title());
      }
      //end

      //�Է������Ͻ����ļ�����
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

      //���سɹ���Ϣ���ͻ��˿���ͨ��FTP����Ӱ��ҳ�ˡ�
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