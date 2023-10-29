package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.aum.UtilizeInfoForm;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import java.util.List;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
import com.sunyard.hgam.util.common.DateTimeKit;

/*********************************************************
 * <p>Title: HGAM(�����й滮�����ۺϹ���ϵͳ)</p>
 * <p>Description: �½������ </p>
 * <p>Copyright: Sunhoo Copyright (c) 2004 </p>
 * <p>Company: Sunhoo Software Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 *********************************************************/

public class BorrowNewApplyFormAction
    extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    UtilizeInfoForm utilForm = (UtilizeInfoForm) form;
    UtilizeInfo utilInfo = new UtilizeInfo();
    UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
        "UtilizeInfoDao");

    String showFlag = request.getParameter("showFlag");

    if (showFlag == null) {
      //����������Ա��Ϣ,ȱʡ����ǵ�¼�˼�Ϊ������
      AccountForm accountInfo = (AccountForm) request.getSession().getAttribute(
          "ACCOUNT_INFORMATION");
      if (accountInfo != null) {
        Account account = accountInfo.getAccount();
        utilInfo.setPersonName(account.getName());
        utilInfo.setPersonCorp(account.getDepartment());
      }
      request.getSession().setAttribute("isSelf", "1");
    }
    else {
      request.getSession().setAttribute("personID",
                                        utilForm.getUtilizeInfo().getPersonID());
      request.getSession().setAttribute("isSelf", "0");
      utilInfo.setPersonID(utilForm.getUtilizeInfo().getPersonID());
      utilInfo.setPersonName(utilForm.getUtilizeInfo().getPersonName());
      utilInfo.setPersonCorp(utilForm.getUtilizeInfo().getPersonCorp());
    }

    //��ȡ���е����÷�ʽ����
    List listModeName = utilDao.getAllUtilModeName();
    utilInfo.setListModeName(listModeName);

    //������������Ϊϵͳ��ǰ����
    utilInfo.setBeginDate(DateTimeKit.getCurrentTimestamp().substring(0, 10));
    utilForm.setUtilizeInfo(utilInfo);

    request.getSession().setAttribute("utilForm", utilForm);

    //���ñ�־λ����ʶ������������,"2"=��������
    request.getSession().setAttribute("flowDefID", "2");

    System.out.println("��ʾ������ɹ�!");
    return mapping.findForward("success");
  }

}