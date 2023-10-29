package com.sunyard.hgam.presentation.action.aum;

import javax.servlet.http.*;
import java.sql.Timestamp;
import java.util.*;
import org.apache.struts.action.*;
import com.sunyard.rdc.flowdriver.*;
import com.sunyard.hgam.presentation.form.aum.UtilizeInfoForm;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.util.common.*;
import com.sunyard.rdc.flowdriver.FlowDriver;
import com.sunyard.hgam.flowengine.FlowEngine;
import com.sunyard.hgam.presentation.base.*;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
import com.sunyard.hgam.persistence.dao.iface.smm.AccountDAO;

/************************************************************
 * <p>Title: HGAM(�����й滮�����ۺϹ���ϵͳ)</p>
 * <p>Description: ������֤��������Action </p>
 * <p>Copyright: Sunhoo Copyright (c) 2004 </p>
 * <p>Company: Sunhoo Software Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 *************************************************************/

public class RepairStartApplyFlowAction extends BaseAction {


  /***************************************************************************
   * ����: ������֤��������,������һ��������(��֤����)���ύ,������һ��������;
   *      ͬʱ��UTILIZE_APPLY�����һ����¼;
   ***************************************************************************/
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    UtilizeInfoDao utilDao = (UtilizeInfoDao)domainLogic.getDAO("UtilizeInfoDao");

    String applyID = request.getParameter("applyID");
    String sModeID = "";
    UtilizeInfoForm uform = (UtilizeInfoForm) form;
    UtilizeInfo uInfo = uform.getUtilizeInfo();
    Map applyIDMap = new HashMap();
    applyIDMap.put("applyID",applyID);
    uInfo = utilDao.getUtilizeInfoByApplyID(applyIDMap);
    String flowInsID = "";

    //��ȡ��¼��Ϣ
    String loginName = "";
    String pwd = "";
    AccountForm accountInfo = (AccountForm) request.getSession().getAttribute(
        "ACCOUNT_INFORMATION");
    if (accountInfo != null) {
      Account account = accountInfo.getAccount();
      loginName = account.getUserName();
    }
    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
    pwd = accountDAO.getPasswordByUsername(loginName);

    try {

      /*** ���̿��Ʋ��� ***/
      //ʵ��������ӿ�
      FlowEngine m_FlowEngine = new FlowEngine(loginName,pwd);

      //�޸����̱���procState
      FormItemInfo oFormItem = new FormItemInfo();
      oFormItem.setItemName("utilizeStatus");
      oFormItem.setItemValue("APPLIED");
      List listFormItem = new ArrayList();
      listFormItem.add(oFormItem);

      //��������ʵ��
      flowInsID = m_FlowEngine.startFlow(3,listFormItem);  //����"3"������"��֤����"����

      //���������
      TaskInfo oTaskInfo = m_FlowEngine.getTaskByApplyID(flowInsID);
      long lWorkitemID = oTaskInfo.getWorkItemID();
      System.out.println("WorkitemID:" + lWorkitemID);
      m_FlowEngine.checkOutTask(lWorkitemID);

      /*** ��乤�������ر���ֵ ***/
      listFormItem = new ArrayList();
      oFormItem = new FormItemInfo();

      //����ID
      oFormItem = new FormItemInfo();
      oFormItem.setItemName("applyID");
      oFormItem.setItemValue(applyID);
      listFormItem.add(oFormItem);

      //�޸�����ʵ��ID
      HashMap hm = new HashMap();
      hm.put("flowInsID",flowInsID);
      hm.put("applyID", applyID);
      utilDao.updateFlowInsID(hm);

      //�޸�����״̬
      hm = new HashMap();
      hm.put("utilizeStatus", "APPLIED");
      hm.put("applyID", applyID);
      utilDao.updateUtilizeStatus(hm);

      //���빤����,����3="��֤����"����
      m_FlowEngine.checkInTask(lWorkitemID, listFormItem, 3);

      //�Ͽ����������
      m_FlowEngine.disconnect();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return mapping.findForward("success");
  }

}