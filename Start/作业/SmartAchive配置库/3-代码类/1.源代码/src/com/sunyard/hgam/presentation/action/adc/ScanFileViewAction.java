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
 * <p>Description: 杭州市规划档案综合管理系统</p>
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

    //显示档案archives_id的文件
    //1. 从参数表获取 ， 2.从session中获取
    String archives_id = request.getParameter("archives_id");
    if (archives_id==null || archives_id.equalsIgnoreCase(""))
      archives_id = (String)request.getSession().getAttribute("archives_id");
    scanFileViewForm.setArchives_id(archives_id) ;
    PaginatedList archivesList = null;

    functionName = "ShowArchivesFiles";
    if (functionName.equalsIgnoreCase("ShowArchivesFiles"))  {
      //根据档案ID，显示该档案的所有文件信息，同时显示该案卷信息
      //1.获取所有文件
      ArchivesFileDao fileDao = (ArchivesFileDao) domainLogic.getDAO(
          "ArchivesFile");
      archivesList = fileDao.queryArchivesFileByArchivesID(archives_id,
          Integer.parseInt(scanFileViewForm.getPageSize()));

      //2.获取档案信息
      ArchivesDao dao = (ArchivesDao) domainLogic.getDAO("Archives");
      Archives a = dao.getArchivesByArchivesID(Integer.parseInt(archives_id)) ;
      scanFileViewForm.setArchives(a);

      //3.通过 Session.queryArchivesRoll 返回数据到页面
      request.getSession().setAttribute("queryArchivesFile", archivesList);
      request.getSession().setAttribute("archives_id", archives_id);

      forwardJSP = "QUERYARCHIVESFILES";
      return (mapping.findForward(forwardJSP));
    }

    return (mapping.findForward(forwardJSP));
  }

}