package com.sunyard.hgam.presentation.action.rcv;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunyard.hgam.presentation.form.adc.ArchivesForm;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import java.util.ArrayList;

public class SettleArchivesFileNavigatorAction extends BaseAction {
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

      if(archivesFile.getProj_id()==null || archivesFile.getProj_id().equals("")){
        //一般文书类
        strForwardTo = "WENSHU";
      }else{
        //业务类
        strForwardTo = "YEWU";
        if (archivesFile.getEform_id() == null ||
            archivesFile.getEform_id().equalsIgnoreCase("")) {
          //否则务必设置为空
          archivesFileForm.setEformFieldValueList(new ArrayList());
        }else {
          //有电子表单，设置表单值列表
          archivesFileForm.setEformFieldValueList(
              eformDao.getEformFieldValueInfoByFileId(
              archivesFile.getFile_id()));
        }
      }

      request.getSession().setAttribute("ArchivesFileForm", archivesFileForm);
      request.getSession().setAttribute("file_id", file_id);
    }catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      return mapping.findForward(strForwardTo);
    }
  }

}

