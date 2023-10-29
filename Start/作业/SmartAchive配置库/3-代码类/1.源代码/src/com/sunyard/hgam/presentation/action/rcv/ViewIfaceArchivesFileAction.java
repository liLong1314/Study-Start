package com.sunyard.hgam.presentation.action.rcv;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.rcv.IfaceArchivesFileDao;
import java.util.ArrayList;


public class ViewIfaceArchivesFileAction extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{

    //说明：根据档案ID，显示该档案的所有文件信息，同时显示该案卷信息
    String strForwardTo = "SUCCESS";
    ArchivesFileForm archivesFileForm = (ArchivesFileForm)form;

    try {
      //取得文件ID：1. 从参数表获取 ， 2.从session中获取
      String file_id = request.getParameter("file_id");
      if (file_id == null || file_id.equalsIgnoreCase("")) {
        file_id = (String) request.getSession().getAttribute("file_id");
      }

      //获取文件信息
      IfaceArchivesFileDao IfacearchivesFileDao = (IfaceArchivesFileDao) domainLogic.getDAO("IfaceArchivesFile");
      ArchivesFile archivesFile = IfacearchivesFileDao.getIfaceArchivesFileByFileId(file_id);
      archivesFileForm.setArchivesFile(archivesFile);

      if(archivesFile.getEform_id()==null || archivesFile.getEform_id().equalsIgnoreCase("")){
        //无电子表单，否则务必设置为空
        archivesFileForm.setEformFieldValueList(new ArrayList());
      }else {
        //有电子表单，设置表单值列表
        archivesFileForm.setEformFieldValueList(
            IfacearchivesFileDao.getIfaceEformFieldValueInfoByFileId(
            archivesFile.getFile_id()));
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
