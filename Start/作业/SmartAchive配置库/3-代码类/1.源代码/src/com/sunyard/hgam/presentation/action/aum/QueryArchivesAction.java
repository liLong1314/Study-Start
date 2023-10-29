package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.arm.ArchOperForm;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.ArchOperDao;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.beans.arm.ArchOper;

/**
 * <p>Title: 档案综合查询－案卷查询</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 */

public class QueryArchivesAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    ArchOperForm archOperForm=(ArchOperForm) form;
    String flag=request.getParameter("flag");
    String entryLevel=request.getParameter("entryLevel");
    String actionName=request.getParameter("actionName");
    PaginatedList archOpers=(PaginatedList) request.getSession().getAttribute("QueryArchs");

    if(archOpers==null || "first".equalsIgnoreCase(flag)){
      ArchOperDao archOperDao=(ArchOperDao) domainLogic.getDAO("ArchOper");
      if(actionName.equals("1")){
        //一般查询
        if (entryLevel!=null && entryLevel.equals("1")){
          archOpers = archOperDao.queryArchiveX(archOperForm.getArchOperInfo());
        }else{
          archOpers = archOperDao.queryArchive(archOperForm.getArchOperInfo());
        }
      }else if(actionName.equals("2")){
        //模糊查询
        if (!archOperForm.getArchOperInfo().getBlurquery().equalsIgnoreCase("")) {
          archOperForm.getArchOperInfo().setBlurquery("%" +
              archOperForm.getArchOperInfo().
              getBlurquery() + "%");
        }
        if (entryLevel!=null && entryLevel.equals("1")){
          archOpers = archOperDao.queryblurArchiveX(archOperForm.getArchOperInfo());
        }else{
          archOpers = archOperDao.queryblurArchive(archOperForm.getArchOperInfo());
        }
      }else if(actionName.equals("3")){
        //业务查询
        /*
        List fieldNames = new ArrayList();
        List fieldValues = new ArrayList();
        fieldNames.add("建设单位");
        fieldNames.add("工程地点");
        fieldValues.add("杭州");
        fieldValues.add("杭州");
        archOperForm.getArchOperInfo().setFieldNames(fieldNames);
        archOperForm.getArchOperInfo().setFieldValues(fieldValues);
        */
        String fieldName1 = request.getParameter("fieldName");
        String fieldValue1 = request.getParameter("fieldValue");
        List tempNameList = new ArrayList();
        List tempValueList = new ArrayList();
        if (fieldName1 != null && fieldValue1 != null) {
          String[] fieldName = fieldName1.split(",");
          String[] fieldValue = fieldValue1.split(",");
          for (int i = 0; i < fieldValue.length; i++) {
            tempNameList.add(fieldName[i].toString());
            tempValueList.add(fieldValue[i].toString());
          }
        }
        ArchOper archOper = archOperForm.getArchOperInfo();
        archOper.setFieldNames(tempNameList);
        archOper.setFieldValues(tempValueList);
        if (entryLevel!=null && entryLevel.equals("1")){
          archOpers = archOperDao.queryOperArchiveX(archOper);
        }else{
          archOpers = archOperDao.queryOperArchive(archOper);
        }
      }
      request.getSession().setAttribute("QueryArchs",archOpers);
    }
    else{
      String page=request.getParameter("page");
      PagedListHelper.pageTo(archOpers,page);
    }

    return mapping.findForward("success");
  }

}
