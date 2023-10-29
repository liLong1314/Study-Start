package com.sunyard.hgam.presentation.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.struts.action.ActionServlet;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 5,2003   yujx        created
 * @version 0.01
 */

public class BaseActionServlet extends ActionServlet {
  protected void process(HttpServletRequest request,
                           HttpServletResponse response)
        throws IOException, ServletException {
      request.setCharacterEncoding("GBK");
      super.process(request,response);
    }
}