package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.sunyard.hgam.util.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public class UpdatePermissionAction extends BaseAction
{
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
  {
    String forwardString = "";
    PermissionForm permissionForm = (PermissionForm) form;
    Permission permission = permissionForm.getPermission();
    PermissionDao DAO = (PermissionDao) domainLogic.getDAO("Permission");
    if(DAO.getPermissionByCode(permission.getPermCode().trim())!=null)
    {
      //���и�Ȩ����
      DAO.updatePermission(permissionForm.getPermission());
      permissionForm.setOperResults("�Ը��û���Ȩ���޸ĳɹ���");
      forwardString="success";
    }
    else
    {
      permissionForm.setOperResults("����ʧ�ܣ�");
      forwardString = "failure";
    }
    return mapping.findForward(forwardString);
  }

}