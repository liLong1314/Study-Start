package com.sunyard.hgam.presentation.action.aum;

import java.util.*;
import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.aum.ChargeStandardForm;
import com.sunyard.hgam.persistence.dao.iface.aum.ChargeStandardDao;
import com.sunyard.hgam.persistence.dao.beans.aum.ChargeStandard;
/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class ChargeStandardAction extends BaseAction {
  public ChargeStandardAction() {
  }
  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {
    String forwardJSP = "ShowSuccess";
    ChargeStandardForm csForm = (ChargeStandardForm) form;
    String functionName = csForm.getFunctionName();
    csForm.setFunctionName("");
    ChargeStandardDao dao = (ChargeStandardDao) domainLogic.getDAO("ChargeStandard");

    //默认显示功能
    if (functionName.equalsIgnoreCase(""))
      functionName = "ShowAllChargeStandard";

    //修改初始化
    String charge_id= request.getParameter("charge_id") ;
    if (charge_id!=null && charge_id.length()>0){
      ChargeStandard cs = dao.queryChargeStandardByChargeID(charge_id);
      csForm.setChargeStandard(cs);
      forwardJSP = "ShowInitUpdate";
      functionName = "";
    }

    //初始化增加界面
    if (functionName.equalsIgnoreCase("InitInsert")){
      csForm.setChargeStandard(new ChargeStandard());
      csForm.getList_sentry() ;
      forwardJSP = "ShowInitAdd";
    }

    if (functionName.equalsIgnoreCase("insert")){
      //增加操作
      //1.得到最大的ID号+1
      int nMaxID = dao.getMaxId()+1 ;
      Integer nChargeId = new Integer(nMaxID);
      csForm.getChargeStandard().setCharge_id(nChargeId.toString()) ;
      //2.保存
      dao.insert(csForm.getChargeStandard());

      //操作成功，刷新显示
      functionName = "ShowAllChargeStandard";
    }

    if (functionName.equalsIgnoreCase("update")){
      //修改收费标准
      dao.updateByChargeID(csForm.getChargeStandard()) ;

      //操作成功，刷新显示
      functionName = "ShowAllChargeStandard";
    }

    if (functionName.equalsIgnoreCase("delete")){
      //循环删除所有选中的收费标准
      if (csForm.getSelectID() != null)
        for (int i = 0; i < csForm.getSelectID().length; i++) {
          dao.deleteByChargeID(csForm.getSelectID()[i]);
        }

      //操作成功，刷新显示
      functionName = "ShowAllChargeStandard";
    }

    if (functionName.equalsIgnoreCase("ShowAllChargeStandard")){
      //显示所有的收费标准
      List list= dao.queryChargeStandard() ;

      request.getSession().setAttribute("AllChargeStandard", list);
      forwardJSP = "ShowSuccess";
    }

    return (mapping.findForward(forwardJSP));
  }

}