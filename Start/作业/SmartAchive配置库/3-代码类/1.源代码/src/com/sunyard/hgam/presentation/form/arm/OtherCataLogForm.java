package com.sunyard.hgam.presentation.form.arm;



import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.OtherCataLog;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;


/**
 * <p>Title: �����Ŀ¼�����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class OtherCataLogForm
    extends BaseForm{
  private OtherCataLog OtherCataLogInfo=new OtherCataLog();
  public OtherCataLog getOtherCataLogInfo() {
    return OtherCataLogInfo;
  }
  public void setOtherCataLogInfo(OtherCataLog OtherCataLogInfo) {
    this.OtherCataLogInfo = OtherCataLogInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
}
