package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Identify;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: ��������</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class IdentifyForm extends BaseForm {
 private Identify identifyInfo=new Identify();
  public Identify getIdentifyInfo() {
    return identifyInfo;
  }
  public void setIdentifyInfo(Identify identifyInfo) {
    this.identifyInfo = identifyInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
}