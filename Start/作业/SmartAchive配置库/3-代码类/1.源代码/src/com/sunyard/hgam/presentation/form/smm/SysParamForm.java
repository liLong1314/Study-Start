package com.sunyard.hgam.presentation.form.smm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.smm.SysParam;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: ϵͳ��������</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class SysParamForm extends BaseForm{
  private SysParam SysParamInfo=new SysParam();
  public SysParam getSysParamInfo() {
    return SysParamInfo;
  }
  public void setSysParamInfo(SysParam SysParamInfo) {
    this.SysParamInfo = SysParamInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
}