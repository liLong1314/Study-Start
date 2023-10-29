package com.sunyard.hgam.presentation.form.smm;

import com.sunyard.hgam.presentation.base.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
//import com.sunyard.hgam.domain.logic.DomainLogic;
//import com.sunyard.hgam.persistence.dao.iface.smm.AccountDAO;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @version 0.01
 */

public class OrgForm
    extends BaseForm{
//  public static final String VALIDATE_EDIT_ACCOUNT = "editAccount";
//  public static final String VALIDATE_NEW_ACCOUNT = "newAccount";

  private Organization org = new Organization();
//  private String newPassword;
//  private String repeatedPassword;
//  private String validate;
  private String operResults;
//  private String creationDateStart;
//  private String creationDateEnd;
//  private List funcPerms;
//  private List dataPerms;
//  private List groups;
//  private List myRoles;

  public OrgForm() {
//    DomainLogic domainLogic = DomainLogic.getInstance();
//    AccountDAO accountDao = (AccountDAO) domainLogic.getDAO("Account");
//    groups = accountDao.getUserGroups(null);
  }

  public Organization getOrg() {
    return org;
  }

  public void setOrg(Organization org) {
    this.org = org;
  }

//  public String getRepeatedPassword() {
//    return repeatedPassword;
//  }
//
//  public void setRepeatedPassword(String repeatedPassword) {
//    this.repeatedPassword = repeatedPassword;
//  }
//
//  public String getValidate() {
//    return validate;
//  }
//
//  public void setValidate(String validate) {
//    this.validate = validate;
//  }

  public void doValidate(ActionMapping mapping, HttpServletRequest request,
                         List errors) {
/*    addErrorIfStringEmpty(errors, "请输入登录名", account.getUserName());
    if (account.getPassword() == null || account.getPassword().length() < 1) {
      errors.add("请输入密码");
    }

    if (validate != null) {
      if (VALIDATE_EDIT_ACCOUNT.equals(validate) ||
          VALIDATE_NEW_ACCOUNT.equals(validate)) {
        if (account.getPassword() == null ||
            account.getPassword().length() < 1) {
          errors.add("请输入密码");
        }
        else if (repeatedPassword == null || repeatedPassword.length() < 1) {
          errors.add("请输入匹配密码");
        }
        else if (!account.getPassword().equals(repeatedPassword)) {
          errors.add("密码不一致");
        }

        addErrorIfStringEmpty(errors, "请输入你的姓名",
                              this.account.getName());
        addErrorIfStringEmpty(errors, "请输入您的电子邮件地址",
                              this.account.getEmail());
        addErrorIfStringEmpty(errors, "请输入你的工作部门",
                              this.account.getDepartment());
      }
    }
*/
  }

  public void reset(ActionMapping actionMapping,
                    HttpServletRequest httpServletRequest) {
  }
  public String getOperResults() {
    return operResults;
  }
  public void setOperResults(String operResults) {
    this.operResults = operResults;
  }
//  public String getCreationDateStart()
//  {
//    return creationDateStart;
//  }
//  public void setCreationDateStart(String creationDateStart)
//  {
//    this.creationDateStart = creationDateStart;
//  }
//  public String getCreationDateEnd()
//  {
//    return creationDateEnd;
//  }
//  public void setCreationDateEnd(String creationDateEnd)
//  {
//    this.creationDateEnd = creationDateEnd;
//  }
//  public List getFuncPerms() {
//    return funcPerms;
//  }
//  public void setFuncPerms(List funcPerms) {
//    this.funcPerms = funcPerms;
//  }
//  public List getDataPerms() {
//    return dataPerms;
//  }
//  public void setDataPerms(List dataPerms) {
//    this.dataPerms = dataPerms;
//  }
//  public List getGroups() {
//    return groups;
//  }
//  public void setGroups(List groups) {
//    this.groups = groups;
//  }
//  public List getMyRoles() {
//    return myRoles;
//  }
//  public void setMyRoles(List roles) {
//    this.myRoles = roles;
//  }
//  public String getNewPassword() {
//    return newPassword;
//  }
//  public void setNewPassword(String newPassword) {
//    this.newPassword = newPassword;
//  }
}