package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Destroy;

/**
 * <p>Title: ���ٹ���</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
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