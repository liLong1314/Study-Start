package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.BaseAction;
import java.util.*;
import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.*;
import com.sunyard.hgam.persistence.dao.iface.adc.*;
import com.sunyard.hgam.persistence.dao.beans.adc.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.base.PagedListHelper;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class CheckArchivesPageViewAction extends BaseAction {
  public CheckArchivesPageViewAction() {
  }

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {
    String forwardJSP = "ShowPage";
    ArchivesPageDao pageDao = (ArchivesPageDao) domainLogic.getDAO("ArchivesPage");
    CheckArchivesPageViewForm capvForm = (CheckArchivesPageViewForm) form;
    String functionName = capvForm.getFunctionName();
    String[] selectPageID = capvForm.getSelectedPageID() ;
    capvForm.setFunctionName("");
    if (functionName.equalsIgnoreCase(""))
      functionName = "ShowPage";

    //前一页、后一页等跳转显示
    String page = request.getParameter("page") ;
    if (page!=null && page.length()>0){
      PaginatedList list = (PaginatedList) request.getSession().getAttribute("queryArchivesPage");
      if (list!=null){
        PagedListHelper.pageTo(list, page);
        forwardJSP = "ShowPage";
        return (mapping.findForward(forwardJSP));
      }
    }

    if ("DeletePage".equalsIgnoreCase(functionName)) {
      //批量删除影像页功能

      if (pageDao.deleteListArchivesPageByPageID(selectPageID)>0)
        capvForm.setFunctionName("DeleteOK") ;
      else
        capvForm.setFunctionName("DeleteFailure") ;

      //重新显示页面内容
      functionName = "ShowPage";
    }
    if ("UpdatePageNum".equalsIgnoreCase(functionName)){
      //批量更新页码

      if (pageDao.updateListArchivesPageNum(selectPageID, capvForm.getFunctionData())>0)
        capvForm.setFunctionName("UpdateOK") ;
      else
        capvForm.setFunctionName("UpdateFailure") ;

      //重新显示页面内容
      functionName = "ShowPage";
    }
    if ("UpdateFileID".equalsIgnoreCase(functionName)){
      //批量更新档案状态

      if (pageDao.updateListArchivesPageFileID(selectPageID, capvForm.getFunctionData())>0)
        capvForm.setFunctionName("UpdateOK") ;
      else
        capvForm.setFunctionName("UpdateFailure") ;

      //重新显示页面内容
      functionName = "ShowPage";
    }
    if ("UpdateStatus".equalsIgnoreCase(functionName)){
      //批量更新档案状态

      if (pageDao.updateListArchivesPageStatus(selectPageID, capvForm.getFunctionData())>0)
        capvForm.setFunctionName("UpdateOK") ;
      else
        capvForm.setFunctionName("UpdateFailure") ;

      //重新显示页面内容
      functionName = "ShowPage";
    }
    if ("UpdatePageSize".equalsIgnoreCase(functionName)){
      //批量更新“页幅”

      if (pageDao.updateListArchivesPageSize(selectPageID, capvForm.getFunctionData())>0)
        capvForm.setFunctionName("UpdateOK") ;
      else
        capvForm.setFunctionName("UpdateFailure") ;

      //重新显示页面内容
      functionName = "ShowPage";
    }
    if ("UpdateOperator".equalsIgnoreCase(functionName)){
      //批量更新“操作权限”

      if (pageDao.updateListArchivesPageOperate(selectPageID, capvForm.getFunctionData())>0)
        capvForm.setFunctionName("UpdateOK") ;
      else
        capvForm.setFunctionName("UpdateFailure") ;

      //重新显示页面内容
      functionName = "ShowPage";
    }
    if ("ShowPage".equalsIgnoreCase(functionName)) {
      //显示档案的影像页列表功能

      //1.从参数中获取档案ID，并读取档案内容
      String sArchives_ID = request.getParameter("archives_id");
      int archives_id = 0;
      try{
        archives_id = Integer.parseInt(sArchives_ID);
      }catch(Exception e){

      }
      if (archives_id==0){
        archives_id = capvForm.getArchives().getAARCHIVES_ID().intValue() ;
      }
      ArchivesDao dao = (ArchivesDao) domainLogic.getDAO("Archives");
      Archives a= dao.getArchivesByArchivesID(archives_id);
      capvForm.setArchives(a) ;

      //2.根据档案ID查询所有的影像页
      ArchivesPageDao pagedao = (ArchivesPageDao) domainLogic.getDAO(
          "ArchivesPage");
      PaginatedList pageList = pagedao.queryArchivesPageByArchivesID(
          new Integer(archives_id),
          Integer.parseInt(capvForm.getPageSize()));

      //3.通过 Session.queryArchivesPage 返回数据到页面
      request.getSession().setAttribute("queryArchivesPage", pageList);

      forwardJSP = "ShowPage";
      return (mapping.findForward(forwardJSP));
    }

    return (mapping.findForward(forwardJSP));
  }

}