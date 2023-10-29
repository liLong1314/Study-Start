package com.sunyard.hgam.presentation.form.adc;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldDefine;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import com.sunyard.hgam.presentation.base.SysParamOper;

public class EformFieldDefineForm extends BaseForm {

  private EformFieldDefine eformFieldDefine = new EformFieldDefine();
  private java.util.List field_type_idOptions = new ArrayList();

  private String operName = "";//操作名称，用于判断用户的操作
  private String msgError = "";//错误信息提示

  public EformFieldDefineForm() {
    SysParamOper sysParamOper = SysParamOper.getInstance();
    field_type_idOptions = sysParamOper.getSysParamByType("FIELD_TYPE");
  }

  public EformFieldDefine getEformFieldDefine() {
    return eformFieldDefine;
  }
  public void setEformFieldDefine(EformFieldDefine eformFieldDefine) {
    this.eformFieldDefine = eformFieldDefine;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
  public String getOperName() {
    return operName;
  }
  public void setOperName(String operName) {
    this.operName = operName;
  }
  public java.util.List getField_type_idOptions() {
    return field_type_idOptions;
  }
  public String getMsgError() {
    return msgError;
  }
  public void setMsgError(String msgError) {
    this.msgError = msgError;
  }

}