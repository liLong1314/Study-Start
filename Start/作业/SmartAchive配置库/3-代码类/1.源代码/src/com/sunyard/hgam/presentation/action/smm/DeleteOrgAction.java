package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.ibatis.db.dao.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 0.01
 */

public class DeleteOrgAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String forwardString = "success";
    String orgID = (String) request.getParameter("ids");
    String[] orgIDList = orgID.split(",");
    int size = orgIDList.length;

    OrgDao orgDAO = (OrgDao) domainLogic.getDAO("Org");
    for (int i = 0; i < size; i++) {
      String id = orgIDList[i];
      if (orgDAO.getSubOrg(id).size() == 0) {
        orgDAO.deleteOrganization(id);
      }
      else {
        request.getSession().setAttribute("message", "��ʾ��ĳЩ��֯��������֯������ɾ���������������֯ɾ���� ��ɾ������֯��");
      }
    }
    return mapping.findForward(forwardString);
  }
}