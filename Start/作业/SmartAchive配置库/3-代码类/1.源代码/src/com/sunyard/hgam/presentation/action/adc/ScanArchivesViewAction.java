package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.adc.ScanArchivesViewForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.presentation.base.PagedListHelper;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class ScanArchivesViewAction extends BaseAction {
  public ScanArchivesViewAction() {
  }

  public ActionForward doPerform(ActionMapping mapping,

                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{
    String forwardJSP = "VIEWARCHIVES";
    ScanArchivesViewForm scanArchivesViewForm = (ScanArchivesViewForm) form;
    String functionName = scanArchivesViewForm.getFunctionName();
    String sRollMode = scanArchivesViewForm.getRoll_mode();
    scanArchivesViewForm.setFunctionName("");
    PaginatedList archivesList = null;

    //ǰһҳ����һҳ����ת��ʾ
    String page = request.getParameter("page") ;
    if (page!=null && page.length()>0){
      PaginatedList list = (PaginatedList) request.getSession().getAttribute("queryArchivesRoll");
      if (list!=null){
        PagedListHelper.pageTo(list, page);
        forwardJSP = "QUERYARCHIVES";
        return (mapping.findForward(forwardJSP));
      }
    }

    if ("QUERYARCHIVES".equalsIgnoreCase(functionName)) {
      archivesList = (PaginatedList) request.getAttribute("queryArchivesRoll");

      Archives archives = scanArchivesViewForm.getArchives() ;
      archives.setAARCHIVES_STATUS("0") ;//δ�鵵

      ArchivesDao dao = (ArchivesDao) domainLogic.getDAO("Archives");
      archivesList = dao.queryArchivesListCheck(archives,
          Integer.parseInt(scanArchivesViewForm.getPageSize()));

      //ͨ�� Session.queryArchivesRoll �������ݵ�ҳ��
      request.getSession().setAttribute("queryArchivesRoll", archivesList);

      forwardJSP = "QUERYARCHIVES";
      return (mapping.findForward(forwardJSP));
    }

    return (mapping.findForward(forwardJSP));
  }

}