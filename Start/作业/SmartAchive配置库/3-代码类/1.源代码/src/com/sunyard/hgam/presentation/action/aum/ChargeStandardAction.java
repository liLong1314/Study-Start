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
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
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

    //Ĭ����ʾ����
    if (functionName.equalsIgnoreCase(""))
      functionName = "ShowAllChargeStandard";

    //�޸ĳ�ʼ��
    String charge_id= request.getParameter("charge_id") ;
    if (charge_id!=null && charge_id.length()>0){
      ChargeStandard cs = dao.queryChargeStandardByChargeID(charge_id);
      csForm.setChargeStandard(cs);
      forwardJSP = "ShowInitUpdate";
      functionName = "";
    }

    //��ʼ�����ӽ���
    if (functionName.equalsIgnoreCase("InitInsert")){
      csForm.setChargeStandard(new ChargeStandard());
      csForm.getList_sentry() ;
      forwardJSP = "ShowInitAdd";
    }

    if (functionName.equalsIgnoreCase("insert")){
      //���Ӳ���
      //1.�õ�����ID��+1
      int nMaxID = dao.getMaxId()+1 ;
      Integer nChargeId = new Integer(nMaxID);
      csForm.getChargeStandard().setCharge_id(nChargeId.toString()) ;
      //2.����
      dao.insert(csForm.getChargeStandard());

      //�����ɹ���ˢ����ʾ
      functionName = "ShowAllChargeStandard";
    }

    if (functionName.equalsIgnoreCase("update")){
      //�޸��շѱ�׼
      dao.updateByChargeID(csForm.getChargeStandard()) ;

      //�����ɹ���ˢ����ʾ
      functionName = "ShowAllChargeStandard";
    }

    if (functionName.equalsIgnoreCase("delete")){
      //ѭ��ɾ������ѡ�е��շѱ�׼
      if (csForm.getSelectID() != null)
        for (int i = 0; i < csForm.getSelectID().length; i++) {
          dao.deleteByChargeID(csForm.getSelectID()[i]);
        }

      //�����ɹ���ˢ����ʾ
      functionName = "ShowAllChargeStandard";
    }

    if (functionName.equalsIgnoreCase("ShowAllChargeStandard")){
      //��ʾ���е��շѱ�׼
      List list= dao.queryChargeStandard() ;

      request.getSession().setAttribute("AllChargeStandard", list);
      forwardJSP = "ShowSuccess";
    }

    return (mapping.findForward(forwardJSP));
  }

}