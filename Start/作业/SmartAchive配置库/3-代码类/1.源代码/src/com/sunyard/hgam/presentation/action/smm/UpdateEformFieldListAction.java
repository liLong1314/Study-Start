package com.sunyard.hgam.presentation.action.smm;


import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.EformDefineForm;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldDefine;


public class UpdateEformFieldListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    String strForward = "SUCCESS";
    EformDefineForm eformDefineForm = (EformDefineForm)form;
    EformDefine eformDefine = eformDefineForm.getEformDefine();
    String eform_id = eformDefine.getEform_id();

    EformFieldDefine eformFieldDefine = null;
    EformDao eformDao = (EformDao) domainLogic.getDAO("Eform");

    try {
      if(eformDefineForm.getOperName().equals("DELETE")){
        //删除指定字段
        String[] field_id = request.getParameterValues("field_id");
        List field_idList = new ArrayList();

        for(int i=0;i<field_id.length;i++){
          eformFieldDefine = new EformFieldDefine();
          eformFieldDefine.setField_id(field_id[i].toString());
          eformFieldDefine.setEform_id(eform_id);
          field_idList.add(eformFieldDefine);
        }
        if(field_idList.size()>0){
          eformDao.deleteEformField(field_idList);
        }
      }else if(eformDefineForm.getOperName().equals("UPDATE")){
        //更新指定字段的信息（目前是字段顺序）
        String[] field_id = request.getParameterValues("field_id");
        String[] field_seq = request.getParameterValues("field_seq");
        List field_idList = new ArrayList();
        for(int i=0;i<field_id.length;i++){
          eformFieldDefine = new EformFieldDefine();
          eformFieldDefine.setField_id(field_id[i].toString());
          eformFieldDefine.setField_seq(field_seq[i].toString());
          eformFieldDefine.setEform_id(eform_id);
          field_idList.add(eformFieldDefine);
        }
        if(field_idList.size()>0){
          eformDao.updateEformField(field_idList);
        }
      }
    }catch (Exception ex) {
      ex.printStackTrace();
      eformDefineForm.setMsgError(ex.toString());
      strForward = "FAILURE";
    }finally{
      return mapping.findForward(strForward);
    }

  }

}