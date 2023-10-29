package com.sunyard.hgam.presentation.form.adc;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldValue;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class EformFieldValueForm extends BaseForm {

  private EformFieldValue eformFieldValue = new EformFieldValue();
  private String operName = "";//操作名称，用于判断用户的操作

  public EformFieldValueForm() {
    //SysParamOper sysParamOper = SysParamOper.getInstance();
    //ARCHIVES_UNITOptions = sysParamOper.getSysParamByTypeID("SECRET");
    //msgArchivesNumCheck = "请先检查档号是否可用！";
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