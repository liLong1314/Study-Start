package com.sunyard.hgam.presentation.form.arm;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.arm.PageOper;

/**
 * <p>Title: ������ѯ��ҳ�沿��</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author Ҷ�
 * @version 1.0
 */

public class PageOperForm extends BaseForm {
  PageOper pageOperInfo=new PageOper();
  public PageOper getPageOperInfo() {
    return pageOperInfo;
  }
  public void setPageOperInfo(PageOper pageOperInfo) {
    this.pageOperInfo = pageOperInfo;
  }
}