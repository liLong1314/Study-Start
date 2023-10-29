package com.sunyard.hgam.util.aum;

import com.sunyard.hgam.domain.logic.DomainLogic;
import com.sunyard.hgam.persistence.dao.iface.arm.EntryDao;
import com.sunyard.hgam.persistence.dao.beans.arm.Entry;

import com.sunyard.hgam.persistence.dao.iface.adc.*;
import com.sunyard.hgam.persistence.dao.beans.adc.*;

import com.sunyard.hgam.persistence.dao.iface.arm.*;
import com.sunyard.hgam.persistence.dao.beans.arm.*;

import com.sunyard.hgam.persistence.dao.iface.aum.*;
import com.sunyard.hgam.persistence.dao.beans.aum.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class AumUtil {
  public static String getEntryNameById(String entryid){
    String Ret = entryid;
    try{
      EntryDao dao = (EntryDao)DomainLogic.getInstance().getDAO("Entry");
      Entry e = dao.getEntry(entryid);
      Ret = e.getEntryName() ;
    }catch(Exception e){

    }
    if (Ret == null)
      Ret= entryid;
    return Ret;
  }


  public static String getChargeIDByPageID(Integer page_id){
    String ret = "";
    try{
      ArchivesPageDao apDao = (ArchivesPageDao)DomainLogic.getInstance().getDAO("ArchivesPage");
      ArchivesPage ap =  apDao.getArchivesPageByPageID(page_id);
      ChargeStandardDao csDao = (ChargeStandardDao)DomainLogic.getInstance().getDAO("ChargeStandard");
      ChargeStandard cs = csDao.queryChargeStandardByChargeID(ap.getPage_size());
      ret = cs.getCharge_id() ;
    }catch(Exception e){

    }
    return ret;
  }
}