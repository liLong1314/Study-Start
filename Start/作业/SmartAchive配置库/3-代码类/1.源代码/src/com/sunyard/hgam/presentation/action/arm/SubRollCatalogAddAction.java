package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.BaseAction;


import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunyard.hgam.presentation.form.arm.SubRollCatalogForm;
import com.sunyard.hgam.persistence.dao.iface.arm.SubRollCatalogDao;

/**
 * <p>Title: ���ӷ־�Ŀ¼��Ϣ</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ������
 * @version 1.0
 */

public class SubRollCatalogAddAction  extends BaseAction{
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    SubRollCatalogForm subRollCatalogForm=(SubRollCatalogForm)form;
    SubRollCatalogDao subRollCatalogDao=(SubRollCatalogDao) domainLogic.getDAO("SubRollCatalog");
    subRollCatalogDao.addSubRollCatalog(subRollCatalogForm.getSubRollCatalogInfo());
    return mapping.findForward("success");
  }


}
