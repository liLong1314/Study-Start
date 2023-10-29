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
import com.sunyard.hgam.persistence.dao.beans.pub.PublishInfoAccessory;

public class PublishInfoAccessoryForm
    extends BaseForm {

  private PublishInfoAccessory publishInfoAccessory = new PublishInfoAccessory();

  private String operName = ""; //操作名称，用于判断用户的操作
  private String msgError = ""; //错误信息提示

  public PublishInfoAccessoryForm() {
  }

  public PublishInfoAccessory getPublishInfoAccessory() {
    return publishInfoAccessory;
  }
  public void setPublishInfo(PublishInfoAccessory publishInfoAccessory) {
    this.publishInfoAccessory = publishInfoAccessory;
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

}
