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
      //检查件号是否可用
      Boolean isExistPieceNum = archivesDao.getIsExistPieceNum(archives.getAPIECE_NUM());
      if (isExistPieceNum.booleanValue()) {
        archivesForm.setMsgArchivesNumCheck("此件号[" + archives.getAPIECE_NUM() +
                                            "]已占用，请检查并重新输入！");
      }else {
        archivesForm.setMsgArchivesNumCheck("此件号[" + archives.getAPIECE_NUM() +
                                            "]可用！");
        blnPassPieceNum = true;
      }

      //检查档号是否可用
      if (blnPassPieceNum){
        Boolean isExistArchivesNum = archivesDao.getIsExistArchivesNum(archives.
            getAARCHIVES_NUM());
        if (isExistArchivesNum.booleanValue()) {
          archivesForm.setMsgArchivesNumCheck("档号[" + archives.getAARCHIVES_NUM() +
                                              "]已占用，请检查并重新输入！");
        }else {
          archivesForm.setMsgArchivesNumCheck("此档号[" + archives.getAARCHIVES_NUM() +
                                              "]可用！");
          if (operName.equalsIgnoreCase("SUBMIT_ACTION")) {
            //设置字段
            newArchId = new Integer(archivesDao.getMaxArchivesId().intValue() + 1);
            archives.setAARCHIVES_ID(newArchId);
            //设置其他的字段值
            archives.setAMAKE_MAN("");

            //进行著录操作
            archivesDao.addArchives(archives);
            strForwardTo = "SUCCESS";
          }
        }
      }

      request.setAttribute("ArchivesForm", archivesForm);
      request.getSession().setAttribute("ARCHIVES_ID", newArchId);
    }
    catch (Exception ex) {
      //错误信息处理
      archivesForm.setMsgError(ex.toString());

      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      return mapping.findForward(strForwardTo);
    }
  }

}
