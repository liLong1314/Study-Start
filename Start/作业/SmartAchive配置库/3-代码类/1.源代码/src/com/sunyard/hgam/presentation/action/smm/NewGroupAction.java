package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import com.sunyard.hgam.util.common.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 0.01
 */

public class NewGroupAction extends BaseAction
{
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
  {
    String forwardString = "";
      GroupForm groupForm = (GroupForm) form;
      Group group = groupForm.getGroup();
      group.setCreationDate(DateTimeKit.getCurrentDateTime());
      GroupDao groupDao = (GroupDao) domainLogic.getDAO("Group");
      if (groupDao.getGroupByGroupName(group.getGroupName().trim()) == null)
      {
        groupDao.insertGroup(groupForm.getGroup());
        groupForm.setOperResults("�û������ӳɹ���");
        forwardString = "success";
      }
      else
      {
        groupForm.setOperResults("���û����Ѿ����ڣ�");
        forwardString = "failure";
      }
    return mapping.findForward(forwardString);
  }

}