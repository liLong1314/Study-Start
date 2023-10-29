package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Whole;

/**
 * <p>Title: 全宗信息</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class WholeForm extends BaseForm {
  private Whole wholeInfo=new Whole();
  public Whole getWholeInfo() {
    return wholeInfo;
  }
  public void setWholeInfo(Whole wholeInfo) {
    this.wholeInfo = wholeInfo;
  }
}