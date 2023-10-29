package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import com.ibatis.common.util.PaginatedList;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunyard.hgam.presentation.form.aum.UtilizePersonForm;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizePerson;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class ShowUtilizePersonFormAction
    extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
        "UtilizeInfoDao");
    UtilizePersonForm uPersonForm = (UtilizePersonForm)form;

    //�޸���������Ϣ
//    if (actionFlag.equals("2")) {
//      String personID = uPersonForm.getUtilizePerson().getPerson_id();
//      UtilizePerson utilPerson = utilDao.getUtilizePersonByID(personID);
//      request.getSession().setAttribute("utilPerson",utilPerson);
//    }
//    else {
//      request.getSession().setAttribute("uPersonForm",uPersonForm);
//    }
    request.getSession().setAttribute("uPersonForm",uPersonForm);
    return mapping.findForward("success");

  }
}