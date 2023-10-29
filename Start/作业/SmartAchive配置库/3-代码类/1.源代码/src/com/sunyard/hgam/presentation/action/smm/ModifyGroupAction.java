package com.sunyard.hgam.presentation.action.smm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.smm.*;
import com.sunyard.hgam.persistence.dao.iface.smm.*;
import com.ibatis.db.dao.*;
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

public class ModifyGroupAction extends BaseAction
{
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
  {
    String forwardString = "";
    GroupForm af = (GroupForm) form;
      GroupDao groupDAO = (GroupDao) domainLogic.getDAO("Group");
      Group group = af.getGroup();
      group.setModifiedDate(DateTimeKit.getCurrentDateTime());
      groupDAO.updateGroup(group);
      af.setGroup(group);
      af.setOperResults("�ɹ��޸��û�����Ϣ��");
      forwardString = "success";
    request.setAttribute("groupForm",af);
    return mapping.findForward(forwardString);
  }

}