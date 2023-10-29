package com.sunyard.hgam.presentation.action.adc;

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
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import java.util.List;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldValue;


public class UpdateArchivesFileAction extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{


    ArchivesFileForm archivesFileForm = (ArchivesFileForm)form;
    ArchivesFile archivesFile = archivesFileForm.getArchivesFile();
    ArchivesFileDao archivesFileDao = (ArchivesFileDao)domainLogic.getDAO("ArchivesFile");
    EformDao eformDao = (EformDao)domainLogic.getDAO("Eform");

    String operName = archivesFileForm.getOperName();
    String strForwardTo = "SUCCESS";

    try {
      if (operName.equalsIgnoreCase("SUBMIT_ACTION")) {
        //重置操作标识
        archivesFileForm.setOperName("");
        //设置字段值
        //进行文件更新操作
        if(archivesFile.getEform_id()==null || archivesFile.getEform_id().equals("")){
          //文书类文件
          archivesFileDao.updateArchivesFile(archivesFile);
        }else{
          //业务类文件著录
          //电子表单著录
          List eformFieldValueList = new ArrayList();
          String field_id[] = request.getParameterValues("field_id");
          String field_value[] = request.getParameterValues("field_value");
          for(int i=0;i<field_value.length;i++){
            if(!field_value[i].equalsIgnoreCase("")){
              //设置
              EformFieldValue EformFieldValue = new EformFieldValue();
              EformFieldValue.setFile_id(archivesFile.getFile_id());
              EformFieldValue.setField_id(field_id[i]);
              EformFieldValue.setField_value(field_value[i]);
              //封装2003-12-27
              eformFieldValueList.add(EformFieldValue);
              //eformDao.addEformFieldValue(EformFieldValue);
            }
          }
          //放在同一事务进行处理
          archivesFileDao.updateArchivesFile(archivesFile,eformFieldValueList);
        }
      }

      request.getSession().setAttribute("ArchivesFileForm", archivesFileForm);
    }
    catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      return mapping.findForward(strForwardTo);
    }

  }

}
