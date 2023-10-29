package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.sunyard.hgam.presentation.form.adc.ArchivesForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import java.util.Calendar;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
/**
 *
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 * @log
 * 1���޶����������İ���Ų���Լ����ֱ�����루֣��ȫ��20040209��
 * 2���޶������ӡ���������Ŀ���ͣ�����Ӧ�޶���֣��ȫ��20040226��
 */
public class AddArchivesRollAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {

    ArchivesForm archivesForm = (ArchivesForm)form;
    Archives archives = archivesForm.getArchives();
    ArchivesDao archivesDao = (ArchivesDao)domainLogic.getDAO("Archives");
    String operName = archivesForm.getOperName();
    String IS_OPERATION = archivesForm.getArchives().getAIS_OPERATION();
    String strForwardTo = "";
    String strErrorForward = "";
    boolean blnPassRollNum = false;
    boolean blnPassArchivesNum = false;
    Integer newArchId = null;
    archivesForm.setMsgError("");
    //Calendar cal = Calendar.getInstance();
    //String today = cal.get(Calendar.YEAR) + "" + (cal.get(Calendar.MONTH)+1) + cal.get(Calendar.DAY_OF_MONTH);
    try {
      //������Ƿ����
      //�޶���־1��ע��
      /*
      Boolean isExistRollNum = archivesDao.getIsExistRollNum(archives.getAROLL_NUM());
      if (isExistRollNum.booleanValue()) {
        archivesForm.setMsgArchivesNumCheck("�˾��[" + archives.getAROLL_NUM() +
                                            "]��ռ�ã����鲢�������룡");
      }else {
        archivesForm.setMsgArchivesNumCheck("�˾��[" + archives.getAROLL_NUM() +
                                            "]���ã�");
        blnPassRollNum = true;
      }*/
      blnPassRollNum = true;

      //��鵵���Ƿ����
      if (blnPassRollNum){
        if(IS_OPERATION.equalsIgnoreCase("1")){
          Boolean isExistArchivesNum = archivesDao.getIsExistArchivesNum(
              archives.
              getAARCHIVES_NUM());
          if (isExistArchivesNum.booleanValue()) {
            archivesForm.setMsgArchivesNumCheck("�˵���[" +
                                                archives.getAARCHIVES_NUM() +
                                                "]��ռ�ã����鲢�������룡");
          }
          else {
            archivesForm.setMsgArchivesNumCheck("�˵���[" +
                                                archives.getAARCHIVES_NUM() +
                                                "]���ã�");
            blnPassArchivesNum = true;
          }
        }else if(IS_OPERATION.equalsIgnoreCase("0")){
          blnPassArchivesNum = true;
        }else if(IS_OPERATION.equalsIgnoreCase("2")){
          blnPassArchivesNum = true;
        }
      }

      switch (Integer.parseInt(IS_OPERATION)) {
        case 0: //0��������
          if (operName.equalsIgnoreCase("CHECK_ACTION")) {
            strForwardTo = "CHECKIT_WENSHU";
          }else if (operName.equalsIgnoreCase("SUBMIT_ACTION")){
            if (blnPassRollNum && blnPassArchivesNum) {
              //ִ�в��������స�����
              //�����ֶ�
              newArchId = new Integer(archivesDao.getMaxArchivesId().intValue()+1);
              archives.setAARCHIVES_ID(newArchId);
              String strRollNum = String.valueOf(archivesDao.getMaxRollNum().intValue() +1);
              archives.setAROLL_NUM(strRollNum);
              //TODO:���ݹ����������
              //�޶���־1����Ϊ����ֱ�����룬�ʲ��ظ�ֵ?
              archives.setAARCHIVES_NUM(archives.getAFONDS_NUM() + "-" + archives.getACATALOG_NUM() + "-" + strRollNum);

              //���ò�����Ա
              archives.setAMAKE_MAN("");
              AccountForm accountInfo = (AccountForm) request.getSession().getAttribute("ACCOUNT_INFORMATION");
              if (accountInfo!=null && accountInfo instanceof AccountForm){
                Account account = accountInfo.getAccount();
                if (account!=null){
                  archives.setAMAKE_MAN(account.getName());
                }
              }

              archivesDao.addArchives(archives);
              strForwardTo = "SUCCESS_WENSHU";
            }else {
              strErrorForward = "CHECKIT_WENSHU";
            }
          }
          break;
        case 1: //1��ҵ����
          if (operName.equalsIgnoreCase("CHECK_ACTION")) {
            strForwardTo = "CHECKIT_YEWU";
          }else if (operName.equalsIgnoreCase("SUBMIT_ACTION")){
            if (blnPassRollNum && blnPassArchivesNum) {
              //ִ�в��������స�����
              //�����ֶ�ֵ
              newArchId = new Integer(archivesDao.getMaxArchivesId().intValue()+1);
              archives.setAARCHIVES_ID(newArchId);
              //TODO:��¼��Ա
              archives.setAMAKE_MAN("");

              archivesDao.addArchives(archives);
              strForwardTo = "SUCCESS_YEWU";
            }else {
              strErrorForward = "CHECKIT_YEWU";
            }
          }
          break;
        case 2: //2��������
          if (operName.equalsIgnoreCase("CHECK_ACTION")) {
            strForwardTo = "CHECKIT_OTHER";
          }else if (operName.equalsIgnoreCase("SUBMIT_ACTION")){
            if (blnPassRollNum && blnPassArchivesNum) {
              //ִ�в��������స�����
              //�����ֶ�
              newArchId = new Integer(archivesDao.getMaxArchivesId().intValue()+1);
              archives.setAARCHIVES_ID(newArchId);
              String strRollNum = String.valueOf(archivesDao.getMaxRollNum().intValue() +1);
              archives.setAROLL_NUM(strRollNum);
              //TODO:���ݹ����������
              //�޶���־1����Ϊ����ֱ�����룬�ʲ��ظ�ֵ
              //archives.setAARCHIVES_NUM(archives.getAFONDS_NUM() + "-" + archives.getACATALOG_NUM() + "-" + strRollNum);

              //���ò�����Ա
              archives.setAMAKE_MAN("");
              AccountForm accountInfo = (AccountForm) request.getSession().getAttribute("ACCOUNT_INFORMATION");
              if (accountInfo!=null && accountInfo instanceof AccountForm){
                Account account = accountInfo.getAccount();
                if (account!=null){
                  archives.setAMAKE_MAN(account.getName());
                }
              }

              archivesDao.addArchives(archives);
              strForwardTo = "SUCCESS_OTHER";
            }else {
              strErrorForward = "CHECKIT_OTHER";
            }
          }
          break;
        default: //����
          strForwardTo = "FAILURE";
          break;
      }

      request.setAttribute("ArchivesForm", archivesForm);
      request.getSession().setAttribute("ARCHIVES_ID", newArchId);
    }
    catch (Exception ex) {
      //������Ϣ����
      archivesForm.setMsgError(ex.toString());
      ex.printStackTrace();
      strForwardTo = strErrorForward;
    }finally{
      //return mapping.findForward("SUCCESS");
      return mapping.findForward(strForwardTo);
    }
  }

}