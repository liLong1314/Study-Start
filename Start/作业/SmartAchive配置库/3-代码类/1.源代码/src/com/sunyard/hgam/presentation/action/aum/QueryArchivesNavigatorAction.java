package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.sunyard.hgam.presentation.form.adc.ArchivesForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.domain.logic.DomainLogic;

public class QueryArchivesNavigatorAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {

    //ENTRY_ID=21&ISOPERATION=2&ENTRY_LEVEL=2
    String ENTRY_ID = request.getParameter("ENTRY_ID");
    String ISOPERATION = request.getParameter("ISOPERATION");
    String ENTRY_LEVEL = request.getParameter("ENTRY_LEVEL");
    if (ENTRY_ID == null || ENTRY_ID.equalsIgnoreCase("")) {
      ENTRY_ID = String.valueOf(request.getSession().getAttribute("ENTRY_ID"));
    }
    if (ISOPERATION == null || ISOPERATION.equalsIgnoreCase("")) {
      ISOPERATION = String.valueOf(request.getSession().getAttribute("ISOPERATION"));
    }
    if (ENTRY_LEVEL == null || ENTRY_LEVEL.equalsIgnoreCase("")) {
      ENTRY_LEVEL = String.valueOf(request.getSession().getAttribute("ENTRY_LEVEL"));
    }

    String strForwardTo = "SUCCESS";

    EformDao eformDao = (EformDao)DomainLogic.getInstance().getDAO("Eform");
    List fieldNames = new ArrayList();

    try {
      switch (Integer.parseInt(ISOPERATION)) {
        case 0: //0－文书类
          break;
        case 1: //1－业务类
          //初始化项目概要信息字段
          fieldNames = eformDao.getProjBriefFields();
          break;
        case 2: //2－其他类
          //初始化本类的扩展字段
          if (ENTRY_LEVEL!=null && ENTRY_LEVEL.equals("1")){
            fieldNames = eformDao.getEformFieldsByFirstEntryId(ENTRY_ID);
          }else{
            fieldNames = eformDao.getEformFieldsByEntryId(ENTRY_ID);
          }
          break;
        default: //错误
          strForwardTo = "FAILURE";
          break;
      }

      request.setAttribute("fieldNames", fieldNames);
      request.getSession().setAttribute("ENTRY_ID", ENTRY_ID);
      request.getSession().setAttribute("ISOPERATION", ISOPERATION);
      request.getSession().setAttribute("ENTRY_LEVEL", ENTRY_LEVEL);
    }
    catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      return mapping.findForward(strForwardTo);
    }
  }

}
