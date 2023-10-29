package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.presentation.form.arm.SubRollCatalogForm;
import com.sunyard.hgam.persistence.dao.beans.arm.SubRollCatalog;
import com.sunyard.hgam.persistence.dao.iface.arm.SubRollCatalogDao;

/**
 * <p>Title: 查询分局目录信息</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 华良东
 * @version 1.0
 */

public class QuerySubRollCatalogListAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception{

    PaginatedList SubRollCatalogs = (PaginatedList) request.getAttribute("SubRollCatalogs");
     String page=request.getParameter("page");
    if(page==null){
      SubRollCatalogForm subRollCatalogForm=(SubRollCatalogForm) form;
      SubRollCatalog subRollCatalog=subRollCatalogForm.getSubRollCatalogInfo();
      SubRollCatalogDao subRollCatalogDao=(SubRollCatalogDao)domainLogic.getDAO("SubRollCatalog");
      SubRollCatalogs=subRollCatalogDao.querySubRollCatalogList(subRollCatalog);
      //替换分局代号为分局名称
  for(int i=0;i<SubRollCatalogs.size();i++){
   SubRollCatalog oneSubRollCatalog=(SubRollCatalog)SubRollCatalogs.get(i);
   int subCode=Integer.parseInt(oneSubRollCatalog.getSubCode());
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
              default:
                oneSubRollCatalog.setSubCode("其他");
                break;

     }
}
   //放入缓存
      request.getSession().setAttribute("SubRollCatalogs", SubRollCatalogs);
          PagedListHelper.pageTo(SubRollCatalogs, page);
        }
        else{ PaginatedList list = (PaginatedList) request.getSession().getAttribute("SubRollCatalogs");
          if (list != null) {
            PagedListHelper.pageTo(list, page);
            return (mapping.findForward("success"));
          }
        }


        //
        return (mapping.findForward("success"));
      }

    }

