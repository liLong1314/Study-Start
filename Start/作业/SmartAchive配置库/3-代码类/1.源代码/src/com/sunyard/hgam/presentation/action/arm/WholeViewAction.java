package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.arm.WholeDao;
import java.util.List;

/**
 * <p>Title: 分类查看全宗信息列表</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 叶昊
 * @version 1.0
 */

public class WholeViewAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
    String wholeType = request.getParameter("type");
    String wholeTypeName;

    if (wholeType == null) {
      wholeType = request.getSession().getAttribute("tmpwholeType").toString();
    }
    else {
      request.getSession().setAttribute("tmpwholeType", wholeType);
    }

    switch (Integer.parseInt(wholeType)) {
      case 1:
        wholeTypeName = "全宗介绍";
        break;
      case 2:
        wholeTypeName = "档案收集材料";
        break;
      case 3:
        wholeTypeName = "档案整理材料";
        break;
      case 4:
        wholeTypeName = "档案鉴定材料";
        break;
      case 5:
        wholeTypeName = "档案保管材料";
        break;
      case 6:
        wholeTypeName = "档案统计材料";
        break;
      case 7:
        wholeTypeName = "档案利用材料";
        break;
      case 8:
        wholeTypeName = "档案现代化管理";
        break;
      case 9:
        wholeTypeName = "大事记";
        break;
      default:
        wholeTypeName = "其他";
    }

    List wholes = null;
    WholeDao wholeDao = (WholeDao) domainLogic.getDAO("Whole");
    wholes = wholeDao.getWholeByType(wholeType);
    request.getSession().setAttribute("Wholes", wholes);
    request.getSession().setAttribute("WholeTypeName", wholeTypeName);

    return mapping.findForward("success");
  }

}