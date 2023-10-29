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

public class AddArchivesPieceAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {

    ArchivesForm archivesForm = (ArchivesForm)form;
    Archives archives = archivesForm.getArchives();
    ArchivesDao archivesDao = (ArchivesDao)domainLogic.getDAO("Archives");
    String operName = archivesForm.getOperName();
    String strForwardTo = "CHECKIT";
    boolean blnPassPieceNum = false;
    boolean blnPassArchivesNum = false;
    Integer newArchId = null;

    archivesForm.setMsgError("");

    try {
      //�������Ƿ����
      Boolean isExistPieceNum = archivesDao.getIsExistPieceNum(archives.getAPIECE_NUM());
      if (isExistPieceNum.booleanValue()) {
        archivesForm.setMsgArchivesNumCheck("�˼���[" + archives.getAPIECE_NUM() +
                                            "]��ռ�ã����鲢�������룡");
      }else {
        archivesForm.setMsgArchivesNumCheck("�˼���[" + archives.getAPIECE_NUM() +
                                            "]���ã�");
        blnPassPieceNum = true;
      }

      //��鵵���Ƿ����
      if (blnPassPieceNum){
        Boolean isExistArchivesNum = archivesDao.getIsExistArchivesNum(archives.
            getAARCHIVES_NUM());
        if (isExistArchivesNum.booleanValue()) {
          archivesForm.setMsgArchivesNumCheck("����[" + archives.getAARCHIVES_NUM() +
                                              "]��ռ�ã����鲢�������룡");
        }else {
          archivesForm.setMsgArchivesNumCheck("�˵���[" + archives.getAARCHIVES_NUM() +
                                              "]���ã�");
          if (operName.equalsIgnoreCase("SUBMIT_ACTION")) {
            //�����ֶ�
            newArchId = new Integer(archivesDao.getMaxArchivesId().intValue() + 1);
            archives.setAARCHIVES_ID(newArchId);
            //�����������ֶ�ֵ
            archives.setAMAKE_MAN("");

            //������¼����
            archivesDao.addArchives(archives);
            strForwardTo = "SUCCESS";
          }
        }
      }

      request.setAttribute("ArchivesForm", archivesForm);
      request.getSession().setAttribute("ARCHIVES_ID", newArchId);
    }
    catch (Exception ex) {
      //������Ϣ����
      archivesForm.setMsgError(ex.toString());

      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      return mapping.findForward(strForwardTo);
    }
  }

}
