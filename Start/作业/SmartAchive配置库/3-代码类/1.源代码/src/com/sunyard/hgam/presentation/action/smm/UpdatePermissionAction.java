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
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
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
      //进行赋权操作
      DAO.updatePermission(permissionForm.getPermission());
      permissionForm.setOperResults("对该用户的权限修改成功！");
      forwardString="success";
    }
    else
    {
      permissionForm.setOperResults("操作失败！");
      forwardString = "failure";
    }
    return mapping.findForward(forwardString);
  }

}