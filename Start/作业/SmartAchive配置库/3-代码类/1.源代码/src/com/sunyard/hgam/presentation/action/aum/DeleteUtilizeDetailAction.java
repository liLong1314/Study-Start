package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import com.ibatis.common.util.PaginatedList;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeDetail;
import com.sunyard.hgam.presentation.form.aum.UtilizeDetailForm;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeDetailDao;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesPageDao;

public class DeleteUtilizeDetailAction
    extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    String fileIDList[] = request.getParameterValues("uDetail.selectID");
    if (fileIDList== null) {
      throw new Exception("参数不对,没有指定文件编号！");
    }

    UtilizeDetailDao utilizeDetailDao = (UtilizeDetailDao) domainLogic.getDAO(
        "UtilizeDetail");

    String strForwardTo = "";

    try {
      for (int i = 0; i < fileIDList.length; i++) {
        //delete all files selected
        utilizeDetailDao.deleteByFileID(fileIDList[i]);
      }
      strForwardTo = "success";
    }
    catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }
    finally {
      return mapping.findForward(strForwardTo);
    }
  }

}
