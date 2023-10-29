package com.sunyard.hgam.presentation.action.aum;

import javax.servlet.http.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.struts.action.*;
import com.sunyard.hgam.presentation.base.*;
import com.sunyard.hgam.presentation.form.aum.UtilizeInfoForm;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.flowengine.FlowEngine;
import com.sunyard.rdc.flowdriver.*;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.persistence.dao.iface.aum.ConfirmInfoDao;
import com.sunyard.hgam.persistence.dao.beans.aum.ConfirmInfo;
import com.sunyard.hgam.util.common.DateTimeKit;
import java.util.Date;
import com.sunyard.hgam.util.aum.Blackbox;
import java.sql.Timestamp;
import java.util.Map;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
import com.sunyard.hgam.persistence.dao.iface.smm.AccountDAO;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeDetailDao;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeDetail;

/*********************************************************
 * <p>Title: HGAM(�����й滮�����ۺϹ���ϵͳ)</p>
 * <p>Description: ���ݲ�ͬ�Ĵ������ύ��ǰ������ </p>
 * <p>Copyright: Sunhoo Copyright (c) 2004 </p>
 * <p>Company: Sunhoo Software Co.,Ltd. </p>
 * @author wanghua
 * @version 1.0
 *********************************************************/

public class RepairCommitTaskAction
    extends BaseAction {

  /*********************************************************************
   * ����: ���ݲ�ͬ�Ĵ������ύ��ǰ������
   *********************************************************************/
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

    UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
        "UtilizeInfoDao");
    ConfirmInfoDao confirmDao = (ConfirmInfoDao) domainLogic.getDAO(
        "ConfirmInfo");
    UtilizeDetailDao utilizeDetailDao = (UtilizeDetailDao) domainLogic.getDAO(
        "UtilizeDetail");
    ArchivesFileDao archivesFileDao = (ArchivesFileDao)domainLogic.getDAO("ArchivesFile");
    UtilizeInfoForm uForm = (UtilizeInfoForm) form;
    UtilizeInfo uInfo = uForm.getUtilizeInfo();
    String sApplyID = uInfo.getApplyID();  //��������ID

    //�������ʵ��ID
    UtilizeInfo tmpUtilizeInfo = new UtilizeInfo();
    Map applyIDMap = new HashMap();
    applyIDMap.put("applyID",sApplyID);
    tmpUtilizeInfo = utilDao.getUtilizeInfoByApplyID(applyIDMap);
    String flowInsID = tmpUtilizeInfo.getFlowInsID(); //����ʵ��ID

    //������������б�
    List listFormItem = new ArrayList();
    FormItemInfo oFormItem = new FormItemInfo();

    //��ȡ��¼��Ϣ
    String loginName = "";
    String pwd = "";
    Account account =  new Account();
    AccountForm accountInfo = (AccountForm) request.getSession().getAttribute(
        "ACCOUNT_INFORMATION");
    if (accountInfo != null) {
      account = accountInfo.getAccount();
      loginName = account.getUserName();
    }
    AccountDAO accountDAO = (AccountDAO) domainLogic.getDAO("Account");
    pwd = accountDAO.getPasswordByUsername(loginName);

    try {
      //ʵ��������ӿ�
      FlowEngine m_FlowEngine = new FlowEngine(loginName, pwd);

      //���������
      TaskInfo oTaskInfo = m_FlowEngine.getTaskByApplyID(flowInsID);
      long lWorkitemID = oTaskInfo.getWorkItemID();
      System.out.println("WorkitemID:" + lWorkitemID);
      m_FlowEngine.checkOutTask(lWorkitemID);

      //����ʵ��״̬
      String flowInsStatus = uInfo.getUtilizeStatus();
      //�쵼������Ϣ
      ConfirmInfo oConfirmInfo = new ConfirmInfo();
      HashMap hm = new HashMap();

      /*** ��֤���̵�"����"������ ***/
      //��һ��������"���������"����(��˲�ͨ��)��"�ۺϿ����"����(��˲�ͨ��)
      if (flowInsStatus.equals("UNCONFIRMEDBYAR") ||
          flowInsStatus.equals("UNCONFIRMEDBYCO")) {
        //ҵ�����ݲ���
        //�޸�����ʵ��״̬Ϊ"������"
        hm.put("utilizeStatus", "APPLIED");
        hm.put("applyID", sApplyID);
        utilDao.updateUtilizeStatus(hm);
        //�������ݲ���,���빤����,����3="���Ĺ���"����;��ʱ����Ҫ�޸����̱���,��˵ڶ�������Ϊnull
        m_FlowEngine.checkInTask(lWorkitemID,null,3);
        return mapping.findForward("success");
      }

      /*** ��֤���̵�"�Ǽ�"������ ***/
      //��һ��������"����"����
      if (flowInsStatus.equals("APPLIED")) {
        //ҵ�����ݲ���
        //�޸�����ʵ��״̬Ϊ"�ѵǼ�"
        hm.put("utilizeStatus", "REGISTED");
        hm.put("applyID", sApplyID);
        utilDao.updateUtilizeStatus(hm);
        //�������ݲ���,���빤����,����2="��֤����"����;��ʱ����Ҫ�޸����̱���,��˵ڶ�������Ϊnull
        m_FlowEngine.checkInTask(lWorkitemID,null,3);

        //����Ǽ���Ϣ
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//�ӵ�¼��Ϣ��ȡ��
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        oConfirmInfo.setConfirmIdea("�ѵǼ�");
        oConfirmInfo.setIsAgree("1");
        oConfirmInfo.setRemark("");//��ע��Ϣ����
        oConfirmInfo.setStatus("");//״̬��Ϣ����
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

      /*** ��֤���̵�"���������"������ ***/
      String sIsAgreeOfReg = uInfo.getAgreeOfRegistration();
      //��һ��������"�Ǽ�"����
      if (flowInsStatus.equals("REGISTED")) {
        //����HGAM�ı���ֵ
        oFormItem.setItemName("isAgree");
        if (sIsAgreeOfReg.equals("1")) {
          oFormItem.setItemValue(new Boolean("true"));
          //�޸�����ʵ��״̬Ϊ"�����������ͨ��"
          hm.put("utilizeStatus","CONFIRMEDBYAR");
          hm.put("applyID",sApplyID);
          oConfirmInfo.setIsAgree("1");
        }
        else {
          oFormItem.setItemValue(new Boolean("false"));
          //�޸�����ʵ��״̬Ϊ"���������δͨ��"
          hm.put("utilizeStatus","UNCONFIRMEDBYAR");
          hm.put("applyID",sApplyID);
          oConfirmInfo.setIsAgree("0");
        }
        utilDao.updateUtilizeStatus(hm);
        listFormItem.add(oFormItem);

        //���빤����,����3="��֤����"����
        m_FlowEngine.checkInTask(lWorkitemID,listFormItem,3);

        //���뵵���������Ϣ
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//�ӵ�¼��Ϣ��ȡ��
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        String confirmIdea = "";
        if (sIsAgreeOfReg.equals("1")) {
          confirmIdea = "��ͬ�⣩";
        }
        else {
          confirmIdea = "����ͬ�⣩";
        }
        oConfirmInfo.setConfirmIdea(uInfo.getRegistConfirmIdea() + confirmIdea);
        oConfirmInfo.setRemark("");//��ע��Ϣ����
        oConfirmInfo.setStatus("1");//�����ǵ����������Ϣ
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

      /*** ��֤���̵�"�ۺϿ����"������ ***/
      String sIsAgreeOfStore = uInfo.getAgreeOfRestore();
      //��һ��������"���������"����
      if (flowInsStatus.equals("CONFIRMEDBYAR")) {
        //����HGAM�ı���ֵ
        oFormItem.setItemName("isAgree");
        if (sIsAgreeOfStore.equals("1")) {
          oFormItem.setItemValue(new Boolean("true"));
          //�޸�����ʵ��״̬Ϊ"�ۺϿ������ͨ��"
          hm.put("utilizeStatus","CONFIRMEDBYCO");
          hm.put("applyID",sApplyID);
          oConfirmInfo.setIsAgree("1");
          //�޸��ļ�״̬Ϊ����
          Map queryMap = new HashMap();
          Map updateMap = new HashMap();
          queryMap.put("applyID", sApplyID);
          List detailList = utilizeDetailDao.queryUtilizeDetailByApplyID(
              queryMap);
          UtilizeDetail utilDetail = null;
          for (int i = 0; i < detailList.size(); i++) {
            utilDetail = new UtilizeDetail();
            utilDetail = (UtilizeDetail) detailList.get(i);
            updateMap.put("isBorrow", "1");
            updateMap.put("fileID", utilDetail.getFile_id());
            archivesFileDao.updateBorrowStatusByFileID(updateMap);
          }
        }
        else {
          oFormItem.setItemValue(new Boolean("false"));
          //�޸�����ʵ��״̬Ϊ"�ۺϿ����δͨ��"
          hm.put("utilizeStatus","UNCONFIRMEDBYCO");
          hm.put("applyID",sApplyID);
          oConfirmInfo.setIsAgree("0");
        }
        utilDao.updateUtilizeStatus(hm);
        listFormItem.add(oFormItem);

        //���빤����,����3="��֤����"����
        m_FlowEngine.checkInTask(lWorkitemID,listFormItem,3);

        //�����ۺϿ������Ϣ
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//�ӵ�¼��Ϣ��ȡ��
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        String confirmIdea = "";
        if (sIsAgreeOfStore.equals("1")) {
          confirmIdea = "��ͬ�⣩";
        }
        else {
          confirmIdea = "����ͬ�⣩";
        }
        oConfirmInfo.setConfirmIdea(uInfo.getRestoreConfirmIdea() + confirmIdea);
        oConfirmInfo.setRemark("");//��ע��Ϣ����
        oConfirmInfo.setStatus("2");//�������ۺϿ������Ϣ
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

      /*** ��֤���̵�"����֤"������ ***/
      //��һ��������"�ۺϿ����"����
      if (flowInsStatus.equals("CONFIRMEDBYCO")) {
        //ҵ�����ݲ���
        //�޸�����ʵ��״̬Ϊ"�Ѱ���"
        hm.put("utilizeStatus", "TRANSACTED");
        hm.put("applyID", sApplyID);
        utilDao.updateUtilizeStatus(hm);
        //�������ݲ���,���빤����,����3="��֤����"����;��ʱ����Ҫ�޸����̱���,��˵ڶ�������Ϊnull
        m_FlowEngine.checkInTask(lWorkitemID,null,3);

        //�������֤��Ϣ
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//�ӵ�¼��Ϣ��ȡ��
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        oConfirmInfo.setConfirmIdea(uInfo.getLeadConfirmIdea());
        oConfirmInfo.setIsAgree("1");
        oConfirmInfo.setRemark("");//��ע��Ϣ����
        oConfirmInfo.setStatus("3");//�����ǰ�����Ϣ
        confirmDao.addConfirmInfo(oConfirmInfo);

        return mapping.findForward("success");
      }

      /*** ��֤���̵�"�շ�"������ ***/
      //��һ��������"�����֤"����
      if (flowInsStatus.equals("TRANSACTED")) {
        //�޸�����ʵ��״̬Ϊ"���շ�"
        hm.put("utilizeStatus", "CHARGED");
        hm.put("applyID", sApplyID);
        utilDao.updateUtilizeStatus(hm);
        //���빤����,����3="��֤����"����;��ʱ����Ҫ�޸����̱���,��˵ڶ�������Ϊnull
        m_FlowEngine.checkInTask(lWorkitemID,null,3);

        //����ʵ�ս����Ϣ
        String totalCharge = uInfo.getRealGetMoney();
        hm = new HashMap();
        hm.put("realGetMoney",totalCharge);
        hm.put("applyID",sApplyID);
        int result = utilDao.updateChargeInfo(hm);
        if(result != 1){
          return mapping.findForward("endError");
        }

        //�����շ���Ϣ
        oConfirmInfo.setApplyID(sApplyID);
        oConfirmInfo.setConfirmUserID(account.getUserID());//�ӵ�¼��Ϣ��ȡ��
        oConfirmInfo.setTaskID(m_FlowEngine.getActivityInsIDByWorkitemID(
            lWorkitemID));
        oConfirmInfo.setConfirmDate(DateTimeKit.getCurrentTimestamp().substring(
            0, 10));
        oConfirmInfo.setConfirmIdea("���շ�");
        oConfirmInfo.setIsAgree("1");
        oConfirmInfo.setRemark("");//��ע��Ϣ����
        oConfirmInfo.setStatus("");//״̬��Ϣ����
        confirmDao.addConfirmInfo(oConfirmInfo);

        //�޸��ļ�״̬Ϊ����
        Map queryMap = new HashMap();
        Map updateMap = new HashMap();
        queryMap.put("applyID", sApplyID);
        List detailList = utilizeDetailDao.queryUtilizeDetailByApplyID(
            queryMap);
        UtilizeDetail utilDetail = null;
        for (int i = 0; i < detailList.size(); i++) {
          utilDetail = new UtilizeDetail();
          utilDetail = (UtilizeDetail) detailList.get(i);
          updateMap.put("isBorrow", "0");
          updateMap.put("fileID", utilDetail.getFile_id());
          archivesFileDao.updateBorrowStatusByFileID(updateMap);
        }

        return mapping.findForward("success");
      }

    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    //����
    return mapping.findForward("endError");

  }

}