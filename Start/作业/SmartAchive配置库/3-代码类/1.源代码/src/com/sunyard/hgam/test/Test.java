package com.sunyard.hgam.test;

import java.util.*;


import java.sql.*;
import java.sql.SQLException;
import com.sunyard.hgam.persistence.dao.beans.arm.Secret;
import com.sunyard.hgam.persistence.dao.iface.arm.SecretDao;
import com.ibatis.common.util.PaginatedList;
import com.ibatis.db.dao.DaoException;
import com.sunyard.hgam.domain.logic.DomainLogic;
import com.sunyard.hgam.persistence.dao.iface.smm.AccountDAO;

public class Test {

  public static void main(String[] args){
    Test test1 = new Test();
    test1.testGetPwdByLoginName();
  }

  private void testGetPwdByLoginName(){

    AccountDAO accountDAO = (AccountDAO) DomainLogic.getInstance().getDAO("Account");
    String pwd = accountDAO.getPasswordByUsername("hz");
    System.out.println("pwd:" + pwd);

  }

  private void testIBatis(){

    SecretDao accountDAO = (SecretDao) DomainLogic.getInstance().getDAO(
        "Secret");

    List secrets = accountDAO.getAllSecret();
    Iterator it = secrets.iterator();
    while (it.hasNext()) {
      Secret secret = (Secret) it.next();
      System.out.println(secret.getSecretId() + "\t" + secret.getSecretCode()+ "\t" +
                         secret.getSecretName()+ "\t" + secret.getRemark());
    }
  }

  }