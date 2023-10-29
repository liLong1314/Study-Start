package com.sunyard.hgam.presentation.form.aum;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.aum.*;
import java.util.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class UtilizeDetailForm
    extends BaseForm {

  private UtilizeDetail uDetail = new UtilizeDetail();

  public UtilizeDetailForm() {
  }

  public UtilizeDetail getUDetail() {
    return uDetail;
  }

  public void setUDetail(UtilizeDetail uDetail) {
    this.uDetail = uDetail;
  }

}