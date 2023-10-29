package com.sunyard.hgam.presentation.action.arm;


import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.SubRollCatalogDao;
import com.sunyard.hgam.presentation.base.PagedListHelper;
import com.sunyard.hgam.persistence.dao.beans.arm.SubRollCatalog;

public class ViewAllSubRollCatalogAction
  extends BaseAction{
  public ActionForward doPerform(ActionMapping mapping,
                             ActionForm form,
                             HttpServletRequest request,
                             HttpServletResponse response) {
   PaginatedList subRollCatalogs=(PaginatedList) request.getAttribute("SubRollCatalogs");

   String page = request.getParameter("page");
    if (page == null){
    SubRollCatalogDao subRollCatalogDao=(SubRollCatalogDao) domainLogic.getDAO("SubRollCatalog");
    subRollCatalogs=subRollCatalogDao.getAllSubRollCatalog();
  //替换分局代号为分局名称
   for(int i=0;i<subRollCatalogs.size();i++){
    SubRollCatalog oneSubRollCatalog=(SubRollCatalog)subRollCatalogs.get(i);
    int subCode=0;
          try{
            subCode = Integer.parseInt(oneSubRollCatalog.getSubCode());
          }catch(Exception e){
            subCode=0;
          }

    //int subCode=Integer.parseInt(oneSubRollCatalog.getSubCode());
    switch(subCode){
      case 8:
               oneSubRollCatalog.setSubCode("上城规划分局");
               break;
             case 9:
               oneSubRollCatalog.setSubCode("下城规划分局");
               break;
             case 11:
               oneSubRollCatalog.setSubCode("江干规划分局");
               break;
             case 12:
               oneSubRollCatalog.setSubCode("拱墅规划分局");
               break;
             case 10:
               oneSubRollCatalog.setSubCode("西湖规划分局");
               break;
      }
    }
    request.getSession().setAttribute("SubRollCatalogs",subRollCatalogs);
   }
   else{ PaginatedList list = (PaginatedList) request.getSession().getAttribute("SubRollCatalogs");
      if (list!=null){
        PagedListHelper.pageTo(list, page);
        //替换分局代号为分局名称
   for(int i=0;i<list.size();i++){
    SubRollCatalog oneSubRollCatalog=(SubRollCatalog)list.get(i);
    int subCode=0;
          try{
            subCode = Integer.parseInt(oneSubRollCatalog.getSubCode());
          }catch(Exception e){
            subCode=0;
          }

    //int subCode=Integer.parseInt(oneSubRollCatalog.getSubCode());
    switch(subCode){
      case 8:
               oneSubRollCatalog.setSubCode("上城规划分局");
               break;
             case 9:
               oneSubRollCatalog.setSubCode("下城规划分局");
               break;
             case 11:
               oneSubRollCatalog.setSubCode("江干规划分局");
               break;
             case 12:
               oneSubRollCatalog.setSubCode("拱墅规划分局");
               break;
             case 10:
               oneSubRollCatalog.setSubCode("西湖规划分局");
               break;
      }
    }

        return (mapping.findForward("success"));
      }

    }

    return mapping.findForward("success");
  }
}
