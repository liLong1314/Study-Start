package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.*;
import com.sunyard.hgam.persistence.dao.beans.arm.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;


/**
 * <p>Title: �ܼ�����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class SecretForm extends BaseForm {
  private Secret secretInfo = new Secret();
  public Secret getSecretInfo() {
    return secretInfo;
  }
  public void setSecretInfo(Secret secretInfo) {
    this.secretInfo = secretInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
}