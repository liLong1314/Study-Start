package com.sunyard.hgam.presentation.form.adc;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldValue;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class EformFieldValueForm extends BaseForm {

  private EformFieldValue eformFieldValue = new EformFieldValue();
  private String operName = "";//�������ƣ������ж��û��Ĳ���

  public EformFieldValueForm() {
    //SysParamOper sysParamOper = SysParamOper.getInstance();
    //ARCHIVES_UNITOptions = sysParamOper.getSysParamByTypeID("SECRET");
    //msgArchivesNumCheck = "���ȼ�鵵���Ƿ���ã�";
  }

  public EformFieldValue getEformFieldValue() {
    return eformFieldValue;
  }
  public void setEformFieldValue(EformFieldValue eformFieldValue) {
    this.eformFieldValue = eformFieldValue;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
  public String getOperName() {
    return operName;
  }
  public void setOperName(String operName) {
    this.operName = operName;
  }


}