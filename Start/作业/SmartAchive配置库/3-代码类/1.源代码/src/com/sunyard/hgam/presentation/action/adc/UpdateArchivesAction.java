package com.sunyard.hgam.presentation.action.adc;


import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.rcv.IfaceArchivesFileDao;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import java.util.List;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldValue;
import com.sunyard.hgam.presentation.form.adc.ArchivesForm;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;


public class UpdateArchivesAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{


    ArchivesForm archivesForm = (ArchivesForm)form;
    Archives archives = archivesForm.getArchives();

    String operName = archivesForm.getOperName();
    String strForwardTo = "SUCCESS";

    try {
      if (operName.equalsIgnoreCase("SUBMIT_ACTION")) {
        //重置操作标识
        archivesForm.setOperName("");
        //更新档案
        ArchivesDao archivesDao = (ArchivesDao) domainLogic.getDAO("Archives");

        //设置操作人员
        archives.setAMAKE_MAN("");
        AccountForm accountInfo = (AccountForm) request.getSession().
            getAttribute("ACCOUNT_INFORMATION");
        if (accountInfo != null && accountInfo instanceof AccountForm) {
          Account account = accountInfo.getAccount();
          if (account != null) {
            archives.setAMAKE_MAN(account.getName());
          }
        }

        archivesDao.updateArchives(archives);
      }

      request.getSession().setAttribute("ArchivesFileForm", archivesForm);
    }
    catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      return mapping.findForward(strForwardTo);
    }
  }

}