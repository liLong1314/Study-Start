package com.sunyard.hgam.presentation.form.aum;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.aum.ConfirmInfo;

public class ConfirmInfoForm extends BaseForm {

  private ConfirmInfo cInfo = new ConfirmInfo();
  private String isAgree;

  public ConfirmInfo getCInfo() {
    return cInfo;
  }
  public void setCInfo(ConfirmInfo cInfo) {
    this.cInfo = cInfo;
  }
  public String getIsAgree() {
    return isAgree;
  }
  public void setIsAgree(String isAgree) {
    this.isAgree = isAgree;
  }

}