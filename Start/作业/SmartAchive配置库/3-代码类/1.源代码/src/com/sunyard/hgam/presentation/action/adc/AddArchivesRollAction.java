package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.sunyard.hgam.presentation.form.adc.ArchivesForm;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import java.util.Calendar;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
/**
 *
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 * @log
 * 1、修订：按卷管理的案卷号不做约束，直接输入（郑先全，20040209）
 * 2、修订：增加“其他”类目类型，并相应修订（郑先全，20040226）
 */
public class AddArchivesRollAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {

    ArchivesForm archivesForm = (ArchivesForm)form;
    Archives archives = archivesForm.getArchives();
    ArchivesDao archivesDao = (ArchivesDao)domainLogic.getDAO("Archives");
    String operName = archivesForm.getOperName();
    String IS_OPERATION = archivesForm.getArchives().getAIS_OPERATION();
    String strForwardTo = "";
    String strErrorForward = "";
    boolean blnPassRollNum = false;
    boolean blnPassArchivesNum = false;
    Integer newArchId = null;
    archivesForm.setMsgError("");
    //Calendar cal = Calendar.getInstance();
    //String today = cal.get(Calendar.YEAR) + "" + (cal.get(Calendar.MONTH)+1) + cal.get(Calendar.DAY_OF_MONTH);
    try {
      //检查卷号是否可用
      //修订日志1：注释
      /*
      Boolean isExistRollNum = archivesDao.getIsExistRollNum(archives.getAROLL_NUM());
      if (isExistRollNum.booleanValue()) {
        archivesForm.setMsgArchivesNumCheck("此卷号[" + archives.getAROLL_NUM() +
                                            "]已占用，请检查并重新输入！");
      }else {
        archivesForm.setMsgArchivesNumCheck("此卷号[" + archives.getAROLL_NUM() +
                                            "]可用！");
        blnPassRollNum = true;
      }*/
      blnPassRollNum = true;

      //检查档号是否可用
      if (blnPassRollNum){
        if(IS_OPERATION.equalsIgnoreCase("1")){
          Boolean isExistArchivesNum = archivesDao.getIsExistArchivesNum(
              archives.
              getAARCHIVES_NUM());
          if (isExistArchivesNum.booleanValue()) {
            archivesForm.setMsgArchivesNumCheck("此档号[" +
                                                archives.getAARCHIVES_NUM() +
                                                "]已占用，请检查并重新输入！");
          }
          else {
            archivesForm.setMsgArchivesNumCheck("此档号[" +
                                                archives.getAARCHIVES_NUM() +
                                                "]可用！");
            blnPassArchivesNum = true;
          }
        }else if(IS_OPERATION.equalsIgnoreCase("0")){
          blnPassArchivesNum = true;
        }else if(IS_OPERATION.equalsIgnoreCase("2")){
          blnPassArchivesNum = true;
        }
      }

      switch (Integer.parseInt(IS_OPERATION)) {
        case 0: //0－文书类
          if (operName.equalsIgnoreCase("CHECK_ACTION")) {
            strForwardTo = "CHECKIT_WENSHU";
          }else if (operName.equalsIgnoreCase("SUBMIT_ACTION")){
            if (blnPassRollNum && blnPassArchivesNum) {
              //执行插入文书类案卷操作
              //设置字段
              newArchId = new Integer(archivesDao.getMaxArchivesId().intValue()+1);
              archives.setAARCHIVES_ID(newArchId);
              String strRollNum = String.valueOf(archivesDao.getMaxRollNum().intValue() +1);
              archives.setAROLL_NUM(strRollNum);
              //TODO:根据规则产生档号
              //修订日志1：改为档号直接输入，故不必赋值?
              archives.setAARCHIVES_NUM(archives.getAFONDS_NUM() + "-" + archives.getACATALOG_NUM() + "-" + strRollNum);

              //设置操作人员
              archives.setAMAKE_MAN("");
              AccountForm accountInfo = (AccountForm) request.getSession().getAttribute("ACCOUNT_INFORMATION");
              if (accountInfo!=null && accountInfo instanceof AccountForm){
                Account account = accountInfo.getAccount();
                if (account!=null){
                  archives.setAMAKE_MAN(account.getName());
                }
              }

              archivesDao.addArchives(archives);
              strForwardTo = "SUCCESS_WENSHU";
            }else {
              strErrorForward = "CHECKIT_WENSHU";
            }
          }
          break;
        case 1: //1－业务类
          if (operName.equalsIgnoreCase("CHECK_ACTION")) {
            strForwardTo = "CHECKIT_YEWU";
          }else if (operName.equalsIgnoreCase("SUBMIT_ACTION")){
            if (blnPassRollNum && blnPassArchivesNum) {
              //执行插入文书类案卷操作
              //设置字段值
              newArchId = new Integer(archivesDao.getMaxArchivesId().intValue()+1);
              archives.setAARCHIVES_ID(newArchId);
              //TODO:登录人员
              archives.setAMAKE_MAN("");

              archivesDao.addArchives(archives);
              strForwardTo = "SUCCESS_YEWU";
            }else {
              strErrorForward = "CHECKIT_YEWU";
            }
          }
          break;
        case 2: //2－其他类
          if (operName.equalsIgnoreCase("CHECK_ACTION")) {
            strForwardTo = "CHECKIT_OTHER";
          }else if (operName.equalsIgnoreCase("SUBMIT_ACTION")){
            if (blnPassRollNum && blnPassArchivesNum) {
              //执行插入文书类案卷操作
              //设置字段
              newArchId = new Integer(archivesDao.getMaxArchivesId().intValue()+1);
              archives.setAARCHIVES_ID(newArchId);
              String strRollNum = String.valueOf(archivesDao.getMaxRollNum().intValue() +1);
              archives.setAROLL_NUM(strRollNum);
              //TODO:根据规则产生档号
              //修订日志1：改为档号直接输入，故不必赋值
              //archives.setAARCHIVES_NUM(archives.getAFONDS_NUM() + "-" + archives.getACATALOG_NUM() + "-" + strRollNum);

              //设置操作人员
              archives.setAMAKE_MAN("");
              AccountForm accountInfo = (AccountForm) request.getSession().getAttribute("ACCOUNT_INFORMATION");
              if (accountInfo!=null && accountInfo instanceof AccountForm){
                Account account = accountInfo.getAccount();
                if (account!=null){
                  archives.setAMAKE_MAN(account.getName());
                }
              }

              archivesDao.addArchives(archives);
              strForwardTo = "SUCCESS_OTHER";
            }else {
              strErrorForward = "CHECKIT_OTHER";
            }
          }
          break;
        default: //错误
          strForwardTo = "FAILURE";
          break;
      }

      request.setAttribute("ArchivesForm", archivesForm);
      request.getSession().setAttribute("ARCHIVES_ID", newArchId);
    }
    catch (Exception ex) {
      //错误信息处理
      archivesForm.setMsgError(ex.toString());
      ex.printStackTrace();
      strForwardTo = strErrorForward;
    }finally{
      //return mapping.findForward("SUCCESS");
      return mapping.findForward(strForwardTo);
    }
  }

}