package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Whole;

/**
 * <p>Title: ȫ����Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
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