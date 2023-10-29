package com.sunyard.hgam.domain.logic;

import com.ibatis.common.resources.*;
import com.ibatis.common.util.*;
import com.ibatis.db.dao.*;

import java.util.*;
import java.io.*;
/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
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
   * 初始化IBatis的配置
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
   * 获取该类的实例
   * @return 该类的唯一实例
   */
  public static DomainLogic getInstance() {
    return instance;
  }
  /**
   * 根据dao名称获取它的实例。
   * dao名称在dao.xml中配置的名称
   * @param daoName 该类的实例
   * @return dao实例
   */
  public Object getDAO(String daoName) {
    return daoManager.getDao(daoName);
  }

}