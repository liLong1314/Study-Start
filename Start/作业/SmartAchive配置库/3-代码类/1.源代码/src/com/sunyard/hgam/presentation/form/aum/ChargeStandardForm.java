package com.sunyard.hgam.presentation.form.aum;

import com.sunyard.hgam.presentation.base.BaseForm;
import com.sunyard.hgam.persistence.dao.beans.aum.ChargeStandard;
import com.sunyard.hgam.presentation.base.SysParamOper;
import com.sunyard.hgam.domain.logic.DomainLogic;
import com.sunyard.hgam.persistence.dao.iface.arm.EntryDao;
import java.util.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class ChargeStandardForm extends BaseForm {

  private ChargeStandard chargeStandard = new ChargeStandard();
  private String functionName = "";
  private String[] selectID ;
  private List list_sentry;
  private List list_charge_mode;
  public ChargeStandardForm() {

  }
  public ChargeStandard getChargeStandard() {
    return chargeStandard;
  }
  public void setChargeStandard(ChargeStandard chargeStandard) {
    this.chargeStandard = chargeStandard;
  }
  public String getFunctionName() {
    return functionName;
  }
  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }
  public String[] getSelectID() {
    return selectID;
  }
  public void setSelectID(String[] selectID) {
    this.selectID = selectID;
  }
  public List getList_sentry() {
    //if (list_sentry==null || list_sentry.size()<1){
      EntryDao dao = (EntryDao)DomainLogic.getInstance().getDAO("Entry") ;
      try{
        String sentryid = chargeStandard.getSentryid() ;
        if (sentryid==null || sentryid.length()<1)
          sentryid = "0";
        list_sentry = dao.queryChargeStandardSEntry(sentryid);
      }catch(Exception e){

      }
    //}
    if (list_sentry==null)
      list_sentry = new ArrayList();
    return list_sentry;
  }
  public void setList_sentry(List list_sentry) {
    this.list_sentry = list_sentry;
  }
  public List getList_charge_mode() {
    if (list_charge_mode==null || list_charge_mode.size()<1)
      list_charge_mode = SysParamOper.getInstance().getSysParamByType("CHARGE_MODE");
    if (list_charge_mode==null)
      list_charge_mode = new ArrayList();
    return list_charge_mode;
  }
  public void setList_charge_mode(List list_charge_mode) {
    this.list_charge_mode = list_charge_mode;
  }

}