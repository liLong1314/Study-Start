package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.Law;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: ���ɷ������</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class LawForm extends BaseForm {
  private Law lawInfo = new Law();
  public Law getLawInfo() {
    return lawInfo;
  }
  public void setLawInfo(Law lawInfo) {
    this.lawInfo = lawInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }

}