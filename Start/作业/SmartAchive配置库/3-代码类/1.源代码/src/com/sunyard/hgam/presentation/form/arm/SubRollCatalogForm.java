package com.sunyard.hgam.presentation.form.arm;


import com.sunyard.hgam.presentation.base.BaseForm;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import com.sunyard.hgam.persistence.dao.beans.arm.SubRollCatalog;



/**
 * <p>Title: �־�Ŀ¼����</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class SubRollCatalogForm
  extends BaseForm{
  private SubRollCatalog subRollCatalogInfo=new SubRollCatalog();
  public SubRollCatalog getSubRollCatalogInfo() {
    return subRollCatalogInfo;
  }
  public void setSubRollCatalogInfo(SubRollCatalog subRollCatalogInfo) {
    this.subRollCatalogInfo = subRollCatalogInfo;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
}
