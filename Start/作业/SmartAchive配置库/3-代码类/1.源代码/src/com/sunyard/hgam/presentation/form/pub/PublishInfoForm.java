package com.sunyard.hgam.presentation.form.pub;

import com.sunyard.hgam.presentation.base.BaseForm;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import com.sunyard.hgam.persistence.dao.beans.pub.PublishInfo;
import com.sunyard.hgam.presentation.base.SysParamOper;
import com.sunyard.hgam.presentation.base.OptionBean;

public class PublishInfoForm extends BaseForm {

  private PublishInfo publishInfo = new PublishInfo();

  private java.util.List info_typeOptions = new ArrayList();

  private String operName = ""; //操作名称，用于判断用户的操作
  private String msgError = "";//错误信息提示

  public PublishInfoForm() {
    SysParamOper sysParamOper = SysParamOper.getInstance();

    info_typeOptions = sysParamOper.getSysParamByType("PUBLISH_INFO_TYPE");
    //去掉用户反馈
    info_typeOptions.remove(0);
  }

  public PublishInfo getPublishInfo() {
    return publishInfo;
  }
  public void setPublishInfo(PublishInfo publishInfo) {
    this.publishInfo = publishInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
  public String getOperName() {
    return operName;
  }

  public void setOperName(String operName) {
    this.operName = operName;
  }
  public String getMsgError() {
    return msgError;
  }
  public void setMsgError(String msgError) {
    this.msgError = msgError;
  }
  public java.util.List getInfo_typeOptions() {
    return info_typeOptions;
  }

}
