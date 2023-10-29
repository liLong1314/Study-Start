package com.sunyard.hgam.presentation.base;

import org.apache.struts.action.*;

import javax.servlet.http.*;
import java.util.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 3,2003   yujx        created
 * @version 0.01
 */

public class BaseForm extends ActionForm {

  /* Public Methods */

  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    ActionErrors actionErrors = null;
    ArrayList errorList = new ArrayList();
    doValidate(mapping, request, errorList);
    request.setAttribute("errors", errorList);
    if (!errorList.isEmpty()) {
      actionErrors = new ActionErrors();
      actionErrors.add(ActionErrors.GLOBAL_ERROR, new ActionError("global.error"));
    }
    return actionErrors;
  }

  public void doValidate(ActionMapping mapping, HttpServletRequest request, List errors) {
  }

  /* Protected Methods */

  protected void addErrorIfStringEmpty(List errors, String message, String value) {
    if (value == null || value.trim().length() < 1) {
      errors.add(message);
    }
  }

}