package com.sunyard.hgam.domain.logic;

import com.ibatis.common.resources.*;
import com.ibatis.common.util.*;
import com.ibatis.db.dao.*;

import java.util.*;
import java.io.*;
/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: ���������ϵ����ݽ��裨һ�ڣ�</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering�� Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @Date        Author      Changes
 * Nov 3,2003   yujx        created
 * @version 0.01
 */

public class DomainLogic {
  /* Constants */
  private static final DomainLogic instance = new DomainLogic();

  /* private fields */

//  private boolean useSimpleConfiguration;

  private static DaoManager daoManager;

  /* Constructors */

  private DomainLogic() {
    initIBatisConfigure();
  }
  /**
   * ��ʼ��IBatis������
   */
  private void initIBatisConfigure() {
    try {
      Properties props = new Properties();
      props.load(Resources.getResourceAsStream(
          "properties/ibatis/config/db.properties"));

      Reader reader = Resources.getResourceAsReader("properties/ibatis/config/dao.xml");
      DaoManager.configure(reader);

      daoManager = DaoManager.getInstance("DaoManager");

    }
    catch (Exception e) {
      throw new RuntimeException("Could not initialize BaseLogic.  Cause: " + e);
    }
  }
  /**
   * ��ȡ�����ʵ��
   * @return �����Ψһʵ��
   */
  public static DomainLogic getInstance() {
    return instance;
  }
  /**
   * ����dao���ƻ�ȡ����ʵ����
   * dao������dao.xml�����õ�����
   * @param daoName �����ʵ��
   * @return daoʵ��
   */
  public Object getDAO(String daoName) {
    return daoManager.getDao(daoName);
  }

}