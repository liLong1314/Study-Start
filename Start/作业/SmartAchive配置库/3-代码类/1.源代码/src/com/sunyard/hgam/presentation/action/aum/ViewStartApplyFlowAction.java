package com.sunyard.hgam.presentation.action.aum;

import javax.servlet.http.*;
import java.sql.Timestamp;
import java.util.*;
import org.apache.struts.action.*;
import com.sunyard.rdc.flowdriver.*;
import com.sunyard.hgam.presentation.base.BaseAction;
import com.sunyard.hgam.flowengine.FlowEngine;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
import com.sunyard.hgam.persistence.dao.iface.smm.AccountDAO;

/************************************************************
 * <p>Title: HGAM(�����й滮�����ۺϹ���ϵͳ)</p>
 * <p>Description: ����������������Action </p>
 * <p>Copyright: Sunhoo Copyright (c) 2004 </p>
 * <p>Company: Sunhoo Software Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 *************************************************************/

public class ViewStartApplyFlowAction extends BaseAction {


  /***************************************************************************
   * ����: �������Ĺ�������,������һ��������(��������)���ύ,������һ��������(�쵼����);
   *      ͬʱ��UTILIZE_APPLY�����һ����¼,����applyID;
   ***************************************************************************/
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    UtilizeInfoDao utilDao = (UtilizeInfoDao)domainLogic.getDAO("UtilizeInfoDao");

    String applyID = request.getParameter("applyID");
    String flowInsID = "";
    UtilizeInfo utilizeInfo = new UtilizeInfo();
    Map applyIDMap = new HashMap();
    applyIDMap.put("applyID", applyID);
    utilizeInfo = utilDao.getUtilizeInfoByApplyID(applyIDMap);

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
      flowInsID = m_FlowEngine.startFlow(1,listFormItem);  //����"1"������"���Ĺ���"����

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

      //�Ƿ�Ϊ������λ��Ա
      boolean bExternal = false;
      String userID = utilizeInfo.getUserID();
      if ( (userID == null) || (userID.equals("")))
        bExternal = true;

      //���ù�������ر���
      oFormItem = new FormItemInfo();
      oFormItem.setItemName("isExternal");
      if (bExternal)
        oFormItem.setItemValue(new Boolean(true));
      else
        oFormItem.setItemValue(new Boolean(false));
      listFormItem.add(oFormItem);

      //�Ƿ���ı���λ
      boolean bSelf = false;
      FormItemInfo oFormItem1 = new FormItemInfo();
      String isBrowseSelf = utilizeInfo.getSelf();
      if (isBrowseSelf.equals("1"))
        bSelf = true;

      //���ù�������ر���
      oFormItem1.setItemName("isSelf");
      if (bSelf)
        oFormItem1.setItemValue(new Boolean(true));
      else
        oFormItem1.setItemValue(new Boolean(false));
      listFormItem.add(oFormItem1);

      //�޸�����״̬
      HashMap hm = new HashMap();
      if (bExternal) {
        if (bSelf)
          hm.put("utilizeStatus", "CONFIRMED");
        else
          hm.put("utilizeStatus", "APPLIED");
      }
      else {
        hm.put("utilizeStatus", "CONFIRMED");
      }
      hm.put("applyID", applyID);
      utilDao.updateUtilizeStatus(hm);

      //�޸�����ʵ��ID
      hm = new HashMap();
      hm.put("flowInsID",flowInsID);
      hm.put("applyID", applyID);
      utilDao.updateFlowInsID(hm);

      //���빤����,����1="���Ĺ���"����
      m_FlowEngine.checkInTask(lWorkitemID, listFormItem, 1);

      //�Ͽ����������
      m_FlowEngine.disconnect();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return mapping.findForward("success");
  }

}