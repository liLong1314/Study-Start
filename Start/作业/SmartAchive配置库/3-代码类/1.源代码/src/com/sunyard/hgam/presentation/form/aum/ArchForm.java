package com.sunyard.hgam.presentation.form.aum;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.aum.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;

public class ArchForm extends BaseForm {
  private Arch arch = new Arch();
  public Arch getArch() {
    return arch;
  }
  public void setArch(Arch arch) {
    this.arch = arch;
  }
  public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
  }
}