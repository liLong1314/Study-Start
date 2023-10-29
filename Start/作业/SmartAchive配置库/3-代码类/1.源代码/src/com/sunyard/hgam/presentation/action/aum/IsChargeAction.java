package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.aum.IsChargeForm;
import com.sunyard.hgam.persistence.dao.iface.arm.EntryDao;
import java.util.List;
import com.sunyard.hgam.persistence.dao.beans.arm.Entry;
/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class IsChargeAction extends BaseAction {
  public IsChargeAction() {
  }
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
      throws java.lang.Exception {
    String forwardJSP = "ShowSuccess";
    IsChargeForm icForm = (IsChargeForm) form;
    String functionName = icForm.getFunctionName();
    icForm.setFunctionName("");
    EntryDao dao = (EntryDao) domainLogic.getDAO("Entry");

    //默认显示功能
    if (functionName.equalsIgnoreCase(""))
      functionName = "ShowAllSecondEntry";

    if (functionName.equalsIgnoreCase("Save")){
      //保存
      String sAll = icForm.getFunctionData() ;
      String[] sEntryList = sAll.split(",");
      if (sEntryList!=null)
        for (int i=0; i<sEntryList.length; i++){
          String[] sEntry = sEntryList[i].split("=") ;
          if (sEntry.length < 1)
            continue;

          Entry e= new Entry();
          e.setEntryId(sEntry[0]);
          e.setIs_charge(sEntry[1]);
          dao.updateEntryIsCharge(e) ;
        }
      functionName = "ShowAllSecondEntry";
    }
    if (functionName.equalsIgnoreCase("ShowAllSecondEntry")){
      //显示
      List list= dao.queryAllSecondEntry() ;
      icForm.setList_entry(list);

      request.getSession().setAttribute("AllSecondEntry", list);
    }

    return (mapping.findForward(forwardJSP));
  }

}