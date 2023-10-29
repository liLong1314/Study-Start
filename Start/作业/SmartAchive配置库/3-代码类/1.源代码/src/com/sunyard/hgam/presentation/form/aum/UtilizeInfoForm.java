package com.sunyard.hgam.presentation.form.aum;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.aum.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.util.*;
import com.sunyard.hgam.presentation.base.OptionBean;

public class UtilizeInfoForm
    extends BaseForm {

  private UtilizeInfo utilizeInfo = new UtilizeInfo();


  public UtilizeInfo getUtilizeInfo() {
    return utilizeInfo;
  }

  public void setUtilizeInfo(UtilizeInfo utilizeInfo) {
    this.utilizeInfo = utilizeInfo;
  }

  public void reset(ActionMapping actionMapping,
                    HttpServletRequest httpServletRequest) {
  }

}