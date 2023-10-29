package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.presentation.form.aum.UtilizePersonForm;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizePerson;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author wanghua
 * @version 1.0
 */

public class AddUtilizePersonAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
        "UtilizeInfoDao");

    UtilizePersonForm uPersonform = (UtilizePersonForm) form;
    UtilizePerson uPersonInfo = uPersonform.getUtilizePerson();
    utilDao.insertUtilizePerson(uPersonInfo);

    return (mapping.findForward("success"));
  }

}
