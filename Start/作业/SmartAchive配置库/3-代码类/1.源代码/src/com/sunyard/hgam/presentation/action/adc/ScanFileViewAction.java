package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.BaseAction;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunyard.hgam.presentation.form.adc.ScanFileViewForm;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class ScanFileViewAction extends BaseAction {
  public ScanFileViewAction() {
  }

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{
    String forwardJSP = "VIEWARCHIVESFILES";
    ScanFileViewForm scanFileViewForm = (ScanFileViewForm) form;

    String functionName = scanFileViewForm.getFunctionName();
    scanFileViewForm.setFunctionName("");

    //��ʾ����archives_id���ļ�
    //1. �Ӳ������ȡ �� 2.��session�л�ȡ
    String archives_id = request.getParameter("archives_id");
    if (archives_id==null || archives_id.equalsIgnoreCase(""))
      archives_id = (String)request.getSession().getAttribute("archives_id");
    scanFileViewForm.setArchives_id(archives_id) ;
    PaginatedList archivesList = null;

    functionName = "ShowArchivesFiles";
    if (functionName.equalsIgnoreCase("ShowArchivesFiles"))  {
      //���ݵ���ID����ʾ�õ����������ļ���Ϣ��ͬʱ��ʾ�ð�����Ϣ
      //1.��ȡ�����ļ�
      ArchivesFileDao fileDao = (ArchivesFileDao) domainLogic.getDAO(
          "ArchivesFile");
      archivesList = fileDao.queryArchivesFileByArchivesID(archives_id,
          Integer.parseInt(scanFileViewForm.getPageSize()));

      //2.��ȡ������Ϣ
      ArchivesDao dao = (ArchivesDao) domainLogic.getDAO("Archives");
      Archives a = dao.getArchivesByArchivesID(Integer.parseInt(archives_id)) ;
      scanFileViewForm.setArchives(a);

      //3.ͨ�� Session.queryArchivesRoll �������ݵ�ҳ��
      request.getSession().setAttribute("queryArchivesFile", archivesList);
      request.getSession().setAttribute("archives_id", archives_id);

      forwardJSP = "QUERYARCHIVESFILES";
      return (mapping.findForward(forwardJSP));
    }

    return (mapping.findForward(forwardJSP));
  }

}