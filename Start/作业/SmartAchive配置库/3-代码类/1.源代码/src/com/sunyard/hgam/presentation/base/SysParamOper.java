package com.sunyard.hgam.presentation.base;

import com.sunyard.hgam.persistence.dao.iface.smm.SysParamDao;
import com.sunyard.hgam.persistence.dao.beans.smm.SysParam;
import com.sunyard.hgam.domain.logic.DomainLogic;
import java.util.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
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
   * ��ȡ�����ʵ��
   * @return �����Ψһʵ��
   */
  public static SysParamOper getInstance() {
    return instance;
  }

  /**
   * ��ʼ��ϵͳ����
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
   * ���ݲ�����Ŀ���ͺ�ֵ��ȡ��������
   * @param type ������Ŀ����
   * @param value ������Ŀֵ
   * @return ������Ŀ����
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
   * ���ݲ������ͻ�ò�����Ŀ�б�
   * @param type ��������
   * @return ������Ŀ�б�
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