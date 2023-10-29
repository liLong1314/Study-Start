package com.sunyard.hgam.presentation.base;

import com.sunyard.hgam.persistence.dao.iface.smm.SysParamDao;
import com.sunyard.hgam.persistence.dao.beans.smm.SysParam;
import com.sunyard.hgam.domain.logic.DomainLogic;
import java.util.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 18,2003   yujx        created
 * @version 0.01
 */

public class SysParamOper {
  /* Constants */
  private static final SysParamOper instance = new SysParamOper();

//  Hashtable sysParam = new Hashtable(13, 0.9f);
  SysParamDao sysParamDAO = (SysParamDao) DomainLogic.getInstance().getDAO("SysParam");
//  List sysParamList;
  Object locker = new Object();

  private SysParamOper() {
//    initSysParam();
  }

  /**
   * 获取该类的实例
   * @return 该类的唯一实例
   */
  public static SysParamOper getInstance() {
    return instance;
  }

  /**
   * 初始化系统参数
   */
  private void initSysParam() {
//    synchronized (locker) {
//      sysParamList = sysParamDAO.getSysParamList();

//      for (int i = 0; i < sysParamList.size(); i++) {
//        SysParam sysParamItem = (SysParam) sysParamList.get(i);
//        String itemValue = sysParamItem.getSysParamValue();
//        sysParam.put(itemValue, sysParamItem);
//      }
//    }
  }

  /**
   * 根据参数条目类型和值获取它的名称
   * @param type 参数条目类型
   * @param value 参数条目值
   * @return 参数条目名称
   */
  public String getSysParamName(String type, String value) {
    String name = "";
    if ((value != null) && (value.length() > 0)) {
      SysParam item = (SysParam) sysParamDAO.getSysParamByTypeAndValue(type, value);
      if (item != null) {
        name = item.getSysParamName();
      }
    }
    return name;
  }

  /**
   * 根据参数类型获得参数条目列表
   * @param type 参数类型
   * @return 参数条目列表
   */
  public List getSysParamByType(String type) {
    if ( (type == null) || (type.length() < 1)) {
      return null;
    }
    List sysParamByTypeList = sysParamDAO.getSysParamByType(type);
    List sysParamOptons = new ArrayList();
    for (int i = 0; i < sysParamByTypeList.size(); i++) {
      SysParam item = (SysParam) sysParamByTypeList.get(i);
      OptionBean optionBean = new OptionBean(item.getSysParamName(),
                                             item.getSysParamValue());
      sysParamOptons.add(optionBean);
    }

    return sysParamOptons;
  }

}