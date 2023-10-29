package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.smm.LogDao;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 17,2003   yujx        created
 * @version 0.01
 */

public class DeleteUserLogAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping actionMapping,
                                 ActionForm actionForm,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    String idList = request.getParameter("ids");
    String[] ids = idList.split(",");

    LogDao logDao = (LogDao) domainLogic.
        getDAO("Log");
    for (int i = 0; i < ids.length; i++) {
      logDao.deleteLog(ids[i]);
    }

    return actionMapping.findForward("success");
  }
}