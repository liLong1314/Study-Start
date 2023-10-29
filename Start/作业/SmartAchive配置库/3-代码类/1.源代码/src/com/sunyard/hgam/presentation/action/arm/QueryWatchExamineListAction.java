package com.sunyard.hgam.presentation.action.arm;
import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.arm.WatchExamine;
import com.sunyard.hgam.presentation.base.PagedListHelper;
import com.sunyard.hgam.persistence.dao.iface.arm.WatchExamineDao;
import com.sunyard.hgam.presentation.form.arm.WatchExamineForm;

/**
 * <p>Title: 查询监督检查管理</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */




public class QueryWatchExamineListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{

    PaginatedList watchExamineList = (PaginatedList) request.getAttribute("watchExamineList");

    String page = request.getParameter("page");

    if(page == null){
      WatchExamineForm watchExamineForm = (WatchExamineForm) form;
      WatchExamine watchExamine = watchExamineForm.getWatchExamineInfo();

      WatchExamineDao watchExamineDao = (WatchExamineDao) domainLogic.getDAO("WatchExamine");
      watchExamineList = watchExamineDao.queryWatchExamineList(watchExamine);
      //替换分局代号为分局名称
   for(int i=0;i<watchExamineList.size();i++){
    WatchExamine oneWatchExamine=(WatchExamine)watchExamineList.get(i);
    String refWatchId=oneWatchExamine.getRefWatchId();
    if(refWatchId==null){
      oneWatchExamine.setRefWatchId("总局未批示");
    }else{
      oneWatchExamine.setRefWatchId("总局已批示");}

    int subCode=Integer.parseInt(oneWatchExamine.getSubCode());
    switch(subCode){
      case 8:
               oneWatchExamine.setSubCode("上城规划分局");
               break;
             case 9:
               oneWatchExamine.setSubCode("下城规划分局");
               break;
             case 11:
               oneWatchExamine.setSubCode("江干规划分局");
               break;
             case 12:
               oneWatchExamine.setSubCode("拱墅规划分局");
               break;
             case 10:
               oneWatchExamine.setSubCode("西湖规划分局");
               break;
             default:
               oneWatchExamine.setSubCode("其他");
               break;
    }
   }

      //放入缓存
      request.getSession().setAttribute("watchExamineList", watchExamineList);
      PagedListHelper.pageTo(watchExamineList, page);
      }
      else{ PaginatedList list = (PaginatedList) request.getSession().getAttribute("watchExamineList");
        if (list!=null){
          PagedListHelper.pageTo(list, page);
          return (mapping.findForward("success"));
        }

      }

    //
    return (mapping.findForward("success"));
  }

}

