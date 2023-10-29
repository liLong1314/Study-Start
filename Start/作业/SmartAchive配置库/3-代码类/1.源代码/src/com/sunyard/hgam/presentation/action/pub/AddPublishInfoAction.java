package com.sunyard.hgam.presentation.action.pub;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.DynaActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.sunyard.hgam.presentation.form.smm.AccountForm;
import com.sunyard.hgam.persistence.dao.beans.smm.Account;
import com.sunyard.hgam.presentation.form.pub.PublishInfoForm;
import com.sunyard.hgam.persistence.dao.beans.pub.PublishInfo;
import com.sunyard.hgam.persistence.dao.iface.pub.PublishInfoDao;
import javax.servlet.ServletConfig;
import org.apache.struts.upload.FormFile;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.beans.pub.PublishInfoAccessory;
import java.io.File;
/**
 *
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 * @log
 * 1、新建（郑先全，20040329）
 */
public class AddPublishInfoAction
    extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    PublishInfoForm publishInfoForm = (PublishInfoForm) form;
    PublishInfo publishInfo = publishInfoForm.getPublishInfo();
    String strType=publishInfo.getInfo_type();
    PublishInfoDao publishInfoDao = (PublishInfoDao) domainLogic.getDAO(
        "PublishInfo");
    //String operName = publishInfoForm.getOperName();
    String strForwardTo = "";
    publishInfoForm.setMsgError("");
    try {
      //设置字段
      int newInfoId = publishInfoDao.getMaxInfoId()+1;
      publishInfo.setInfo_id(newInfoId+"");
      //设置发布人员
      publishInfo.setInfo_publish_person("");
      AccountForm accountInfo = (AccountForm) request.getSession().getAttribute(
          "ACCOUNT_INFORMATION");
      if (accountInfo != null && accountInfo instanceof AccountForm) {
        Account account = accountInfo.getAccount();
        if (account != null) {
          publishInfo.setInfo_publish_person(account.getName());
        }
      }

      //上载附件
      FormFile accessory_file = publishInfo.getAccessory_file();
      List publishInfoAccessoryList = new ArrayList();
      if(accessory_file.getFileSize()>0){
        try {
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          InputStream stream = accessory_file.getInputStream();
          String path = this.getServlet().getServletContext().getRealPath("/");
          String separator = System.getProperty("file.separator");
          String fileName = accessory_file.getFileName();
          String saveFileName = separator + "accessory" + separator + newInfoId +
              "-" + fileName + ".gif";
          String fileExt = fileName.substring(fileName.lastIndexOf("."));
          OutputStream bos = new FileOutputStream(new File(path + saveFileName));
          int bytesRead = 0;
          byte[] buffer = new byte[8192];
          while ( (bytesRead = stream.read(buffer, 0, 8192)) != -1) {
            bos.write(buffer, 0, bytesRead);
          }
          bos.close();
          stream.close();

          PublishInfoAccessory publishInfoAccessory = new PublishInfoAccessory();
          publishInfoAccessory.setInfo_id(newInfoId + "");
          String title = publishInfo.getAccessory_title();
          if(title==null || title.equals("")){
            publishInfoAccessory.setAccessory_title(fileName);
          }else{
            publishInfoAccessory.setAccessory_title(title);
          }
          publishInfoAccessory.setAccessory_filename(saveFileName);
          publishInfoAccessoryList.add(publishInfoAccessory);
        }
        catch (FileNotFoundException fnfe) {
          throw fnfe;
        }
        catch (IOException ioe) {
          throw ioe;
        }
      }

      //插入发布信息记录
      if(publishInfoAccessoryList!=null && publishInfoAccessoryList.size()>0){
        //有附件
        publishInfoDao.addPublishInfo(publishInfo,publishInfoAccessoryList);
      }else{
        //无附件
        publishInfoDao.addPublishInfo(publishInfo);
      }

      if(strType==null || strType.equals("0")){
        strForwardTo = "FEEDBACK";
      }else{
        strForwardTo = "PUBLISH";
      }
    }
    catch (Exception ex) {
      //错误信息处理
      publishInfoForm.setMsgError(ex.toString());
      if(strType==null && strType.equals("0")){
        strForwardTo = "FAILURE_FEEDBACK";
      }else{
        strForwardTo = "FAILURE_PUBLISH";
      }
    }
    finally {
      return mapping.findForward(strForwardTo);
    }
  }

}