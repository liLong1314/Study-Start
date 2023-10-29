package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.presentation.form.adc.EformFieldDefineForm;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldDefine;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;

public class SelectEformFieldAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {
    //选定的字段
    String fieldId[] = null;
    String strForwardTo = "SUCCESS";

    try {
      if(request.getParameterValues("field_id")!=null){
        fieldId=request.getParameterValues("field_id");
      }else{
        throw new Exception("参数不对，没有指定字段编号（fieldId）");
      }

      String eform_id = request.getParameter("eform_id");
      if (eform_id == null || eform_id.equalsIgnoreCase("")) {
        eform_id = String.valueOf(request.getSession().getAttribute("eform_id"));
      }


      EformFieldDefineForm eformFieldDefineForm = (EformFieldDefineForm) form;
      EformFieldDefine eformFieldDefine = eformFieldDefineForm.getEformFieldDefine();
      EformDao eformDao = (EformDao)domainLogic.getDAO("Eform");

      //更新选定的字段
      List fieldList = new ArrayList();
      for (int i = 0; i < fieldId.length; i++) {
        //初始化字段实例
        eformFieldDefine = eformDao.getFieldDefineByFieldId(fieldId[i]);

        //设置字段的EFORM_ID属性
        eformFieldDefine.setEform_id(eform_id);

        //封装起来先
        fieldList.add(eformFieldDefine);
      }

      //事务化更新操作
      eformDao.addEformField(fieldList);

    }catch (Exception ex) {
      strForwardTo = "FAILURE";
      ex.printStackTrace();
    }

    //返回
    return (mapping.findForward(strForwardTo));
  }

}