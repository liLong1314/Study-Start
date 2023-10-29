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

public class ViewUtilizeDetailAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
        "UtilizeInfoDao");
    String applyID = (String) request.getSession().getAttribute("applyID");
    String flag = request.getParameter("flag");
    String flowDefID = (String)request.getSession().getAttribute("flowDefID");
    String forwardJSP = "";

    //根据不同的流程定义ID转向不同的档案明细页面
    if (flowDefID != null) {
      if (flowDefID.equals("1"))
        forwardJSP = "APPLY";
      else if (flowDefID.equals("2"))
        forwardJSP = "APPLYBORROW";
      else if (flowDefID.equals("3"))
        forwardJSP = "APPLYREPAIR";
    }

    if (flag != null) {
      applyID = request.getParameter("applyID");

      //获得流程实例状态
      UtilizeInfo tmpUtilizeInfo = new UtilizeInfo();
      Map applyIDMap = new HashMap();
      applyIDMap.put("applyID",applyID);
      tmpUtilizeInfo = utilDao.getUtilizeInfoByApplyID(applyIDMap);
      String flowStatus = tmpUtilizeInfo.getUtilizeStatus();
      //获得利用方式ID判断是否为查看电子文档
      String modeID = tmpUtilizeInfo.getModeID();
      //若已经过出库审核并且利用的是电子文件,则设置为可查看
      //计算是否超期
      String bExpire = "0";
      UtilizeInfo tempUtilInfo = new UtilizeInfo();
      tempUtilInfo = utilDao.getUtilizeInfoByApplyID(applyIDMap);
      Date beginDate = Blackbox.changeStr2DateTime(tempUtilInfo.getBeginDate());
      Date now = new Date();
      Date endDate = Blackbox.changeStr2DateTime(now.toLocaleString());
      long term = Long.parseLong(tempUtilInfo.getUtilizeTerm());
      if (term < Blackbox.computeInterval(beginDate, endDate))
        bExpire = "1";
      if (! (flowStatus.equals("UNCONFIRMED") ||
             flowStatus.equals("APPLIED") ||
             flowStatus.equals("CONFIRMED") ||
             flowStatus.equals("UNREGCONFIRMED") ||
             flowStatus.equals("REGISTED") ||
             flowStatus.equals("UNCONFIRMEDBYAR") ||
             flowStatus.equals("CONFIRMEDBYAR"))) {
        if (bExpire.equals("0")) {
          if (modeID.equals("2"))
            request.getSession().setAttribute("isViewable", "1");
          else if (modeID.equals("1"))
            request.getSession().setAttribute("isViewable", "0");
        }
        else {
          request.getSession().setAttribute("isViewable", "0");
        }
      }
      else {
        request.getSession().setAttribute("isViewable", "0");
      }
      forwardJSP = "HANDLER";
    }

    UtilizeDetailDao utilizeDetailDao = (UtilizeDetailDao) domainLogic.getDAO(
        "UtilizeDetail");
    Map applyIDMap = new HashMap();
    applyIDMap.put("applyID",applyID);
    PaginatedList utilizeDetailList = (PaginatedList) utilizeDetailDao.
        queryUtilizeDetailByApplyID(applyIDMap);

    //放入缓存
    request.getSession().setAttribute("utilizeDetailList", utilizeDetailList);
    request.getSession().setAttribute("applyID", applyID);
    request.getSession().setAttribute("flowDefID",flowDefID);

    return (mapping.findForward(forwardJSP));
  }

}
