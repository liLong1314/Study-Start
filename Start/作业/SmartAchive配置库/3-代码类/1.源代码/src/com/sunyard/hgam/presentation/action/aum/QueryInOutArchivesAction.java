package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.presentation.base.PagedListHelper;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.presentation.form.adc.ArchivesForm;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeDetailDao;
import com.sunyard.hgam.presentation.form.aum.UtilizeInfoForm;
import java.util.Map;
import java.util.HashMap;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import java.util.Date;
import com.sunyard.hgam.util.aum.Blackbox;
import java.util.List;

public class QueryInOutArchivesAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    UtilizeDetailDao utilizeDetailDao = (UtilizeDetailDao) domainLogic.getDAO(
        "UtilizeDetail");
    String forwardJSP = "";
    String mediaFlag = request.getParameter("mediaFlag");
    String inoutFlag = request.getParameter("inoutFlag");
    String strBeginTime = request.getParameter("beginTime");
    String strEndTime = request.getParameter("endTime");

    Map conditionMap = new HashMap();
    if (!inoutFlag.equals("3")) {
      conditionMap.put("status", inoutFlag);
    }
    if (!mediaFlag.equals("3")) {
      conditionMap.put("modeID", mediaFlag);
    }
    if (strBeginTime!=null) {
      conditionMap.put("beginDate",strBeginTime);
    }
    if (strEndTime!=null) {
      conditionMap.put("endDate",strEndTime);
    }

    List utilizeDetailList = (List) utilizeDetailDao.
        queryUtilizeDetailByCondition(conditionMap);

    //∑≈»Îª∫¥Ê
    request.getSession().setAttribute("utilizeDetailList", utilizeDetailList);
    forwardJSP = "SUCCESS";
    return (mapping.findForward(forwardJSP));
  }

}
