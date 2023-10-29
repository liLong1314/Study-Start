package com.sunyard.hgam.presentation.base;

import com.sunyard.hgam.domain.logic.DomainLogic;

import org.apache.struts.action.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 3,2003   yujx        created
 * @version 0.01
 */

public abstract class BaseAction extends Action {

  /* Constants */

  protected static final DomainLogic domainLogic = DomainLogic.getInstance();

  /* Public Methods */

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    try {
      /** @todo:全局控制，如登录检查和权限控制 */
      return doPerform(mapping, form, request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("message", "Unhandled Exception: " + e.toString());
      return mapping.findForward("unknown-error");
    }
  }

  public abstract ActionForward doPerform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception;

}