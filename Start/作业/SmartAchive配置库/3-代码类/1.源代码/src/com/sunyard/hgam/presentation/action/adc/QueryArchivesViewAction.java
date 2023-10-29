package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.adc.QueryArchivesViewForm;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import com.sunyard.hgam.presentation.base.PagedListHelper;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesPageDao;
import java.util.List;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class QueryArchivesViewAction extends BaseAction {
  public QueryArchivesViewAction() {
  }

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{
    String forwardJSP = "QueryAllArchives";
    QueryArchivesViewForm qavfForm = (QueryArchivesViewForm) form;
    String functionName = qavfForm.getFunctionName();
    String sRollMode = qavfForm.getArchives().getAROLL_MODE() ;
    qavfForm.setFunctionName("");
    PaginatedList archivesList = null;
    ArchivesDao adao = (ArchivesDao) domainLogic.getDAO("Archives");
    ArchivesPageDao apdao = (ArchivesPageDao) domainLogic.getDAO("ArchivesPage");

    //前一页、后一页等跳转显示
    String page = request.getParameter("page") ;
    if (page!=null && page.length()>0){
      archivesList = (PaginatedList) request.getSession().getAttribute("queryAllArchives");
      if (archivesList!=null){
        PagedListHelper.pageTo(archivesList, page);
        forwardJSP = "QueryAllArchives";
        return (mapping.findForward(forwardJSP));
      }
    }

    //“归档功能” ==> 归档
    if ("Roll".equalsIgnoreCase(functionName)) {
      if (qavfForm.getSelectID()!=null){
        for (int i = 0; i < qavfForm.getSelectID().length; i++) {
          List lst = null;
          String archives_id = qavfForm.getSelectID()[i];
          Archives a = new Archives();
          a.setAARCHIVES_ID(new Integer(archives_id));

          /*
          //1.判断该档案是否有影像页
          int nPageCount = apdao.getPageCountByArchivesID(new Integer(
              archives_id));
          if (nPageCount < 1) {
            a.setAARCHIVES_STATUS("2"); //该档案没有档案页
            adao.updateArchivesStatusByArchivesID(a);
            continue;
          }
          */

          //2.判断是否存在有相同的页码
          lst = apdao.queryConflictPageNum(archives_id);
          if (lst != null)
            if (lst.size() > 0) {
              a.setAARCHIVES_STATUS("3"); //档案页存在有相同的页码
              adao.updateArchivesStatusByArchivesID(a);
              continue;
            }

          //3.判断是否有未通过检查的影像页
          lst = apdao.queryArchivesPageNotPass(archives_id);
          if (lst != null)
            if (lst.size() > 0) {
              a.setAARCHIVES_STATUS("4"); //档案页存在有“未通过检查”的影像页
              adao.updateArchivesStatusByArchivesID(a);
              continue;
            }
          //4.允许归档
          a.setAARCHIVES_STATUS("1"); //已归档
          adao.updateArchivesStatusByArchivesID(a);
        }
      }

      //更新成功，重新显示页面
      functionName = "QueryAllArchives";
    }

    //“复查整理功能” ==> 未归档
    if ("UnRoll".equalsIgnoreCase(functionName)) {
      if (qavfForm.getSelectID()!=null){
        for (int i = 0; i < qavfForm.getSelectID().length; i++) {
          String archives_id = qavfForm.getSelectID()[i];
          Archives a = new Archives();
          a.setAARCHIVES_ID(new Integer(archives_id));
          a.setAARCHIVES_STATUS("0"); //未归档
          adao.updateArchivesStatusByArchivesID(a);
        }
      }

      //更新成功，重新显示页面
      functionName = "QueryAllArchives";
    }

    //“查询功能”
    if ("QueryAllArchives".equalsIgnoreCase(functionName)) {
      archivesList = (PaginatedList) request.getAttribute("queryAllArchives");

      Archives archives = qavfForm.getArchives();
      //档号
      String archivesNum = archives.getAARCHIVES_NUM();
      if (!archivesNum.equalsIgnoreCase("")){
        archives.setAARCHIVES_NUM("%" + archivesNum + "%") ;
      }
      //档案名称
      String archivesName = qavfForm.getArchives().getAARCHIVES_NAME();
      if (!archivesName.equalsIgnoreCase("")){
        archives.setAARCHIVES_NAME("%" + archivesName + "%") ;
      }

      archivesList = adao.queryArchivesListCheck(archives,
          Integer.parseInt(qavfForm.getPageSize()));

      //通过 Session.queryArchivesRoll 返回数据到页面
      request.getSession().setAttribute("queryAllArchives", archivesList);
      archives.setAARCHIVES_NUM(archivesNum) ;
      archives.setAARCHIVES_NAME(archivesName) ;

      forwardJSP = "QueryAllArchives";
      return (mapping.findForward(forwardJSP));
    }

    return (mapping.findForward(forwardJSP));
  }

}