package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Safety;
import org.apache.struts.action.*;
import javax.servlet.http.*;

/**
 * <p>Title: ��ȫ����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class SafetyForm extends BaseForm {
  private Safety safetyInfo = new Safety();
  public Safety getSafetyInfo() {
    return safetyInfo;
  }
  public void setSafetyInfo(Safety safetyInfo) {
    this.safetyInfo = safetyInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }

}