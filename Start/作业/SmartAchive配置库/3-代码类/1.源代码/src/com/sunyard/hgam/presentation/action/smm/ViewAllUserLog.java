package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.smm.LogDao;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 12,2003   yujx        created
 * @version 0.01
 */

public class ViewAllUserLog
    extends BaseAction {
  public ActionForward doPerform(ActionMapping actionMapping,
                                 ActionForm actionForm,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    PaginatedList logList = (PaginatedList) request.getSession().getAttribute("allUserLogList");
    if (logList == null) {
      LogDao logDao = (LogDao) domainLogic.getDAO("Log");
      logList = logDao.getAllLog();
      request.getSession().setAttribute("allUserLogList", logList);
    }

    String page = request.getParameter("page");
    PagedListHelper.pageTo(logList, page);

    return actionMapping.findForward("success");
  }
}