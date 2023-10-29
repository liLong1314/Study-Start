package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Destroy;

/**
 * <p>Title: 销毁管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class DestroyForm extends BaseForm {
  private Destroy destroyInfo=new Destroy();
  public Destroy getDestroyInfo() {
    return destroyInfo;
  }
  public void setDestroyInfo(Destroy destroyInfo) {
    this.destroyInfo = destroyInfo;
  }
}