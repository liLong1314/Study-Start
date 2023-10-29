package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;

public class ViewArchivesFileAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    //说明：根据file_id，取得文件的属性，并作如下逻辑处理：
    //1、如果文件有proj_id，说明该文件无论有否eform_id都是业务类文件，并予以导航
    String strForwardTo = "";
    ArchivesFileForm archivesFileForm = (ArchivesFileForm)form;

    try {
      //取得文件ID：1. 从参数表获取 ， 2.从session中获取
      String file_id = request.getParameter("file_id");
      if (file_id == null || file_id.equalsIgnoreCase("")) {
        file_id = (String) request.getSession().getAttribute("file_id");
      }

      //获取文件信息
      ArchivesFileDao archivesFileDao = (ArchivesFileDao) domainLogic.getDAO("ArchivesFile");
      EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");
      ArchivesFile archivesFile = archivesFileDao.getArchivesFileByFileID(file_id);
      archivesFileForm.setArchivesFile(archivesFile);

      //获取档案信息
      ArchivesDao archivesDao = (ArchivesDao) domainLogic.getDAO("Archives");
      Archives archives = archivesDao.getArchivesByArchivesID((new Integer(archivesFile.getArchives_id())).intValue());
      archivesFileForm.setArchives(archives);

      //修订（郑先全，20040226）：由于增加了“2－其他”的类目类型，故必须要修订逻辑
      if (archives.getAIS_OPERATION().trim().equals("0")) {
        //文书类
        strForwardTo = "WENSHU";
      }else if (archives.getAIS_OPERATION().trim().equals("1")) {
        //业务类
        strForwardTo = "YEWU";
        if (archivesFile.getEform_id() == null ||
            archivesFile.getEform_id().equalsIgnoreCase("")) {
          //否则务必设置为空
          archivesFileForm.setEformFieldValueList(new ArrayList());
        }
        else {
          //有电子表单，设置表单值列表
          archivesFileForm.setEformFieldValueList(
              eformDao.getEformFieldValueInfoByFileId(
              archivesFile.getFile_id()));
        }
      }else if (archives.getAIS_OPERATION().trim().equals("2")) {
        //其他类
        strForwardTo = "OTHER";

        if (archivesFile.getEform_id() == null ||
            archivesFile.getEform_id().equalsIgnoreCase("")) {
          //否则务必设置为空
          archivesFileForm.setEformFieldValueList(new ArrayList());
        }
        else {
          //有电子表单，设置表单值列表
          archivesFileForm.setEformFieldValueList(
              eformDao.getEformFieldValueInfoByFileId(
              archivesFile.getFile_id()));
        }
      }

      request.setAttribute("ArchivesFileForm", archivesFileForm);
      request.getSession().setAttribute("file_id", file_id);
    }catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      return mapping.findForward(strForwardTo);
    }
  }

}