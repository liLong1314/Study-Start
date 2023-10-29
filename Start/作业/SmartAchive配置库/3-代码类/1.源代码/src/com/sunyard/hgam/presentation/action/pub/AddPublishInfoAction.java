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
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 * @log
 * 1���½���֣��ȫ��20040329��
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
      //�����ֶ�
      int newInfoId = publishInfoDao.getMaxInfoId()+1;
      publishInfo.setInfo_id(newInfoId+"");
      //���÷�����Ա
      publishInfo.setInfo_publish_person("");
      AccountForm accountInfo = (AccountForm) request.getSession().getAttribute(
          "ACCOUNT_INFORMATION");
      if (accountInfo != null && accountInfo instanceof AccountForm) {
        Account account = accountInfo.getAccount();
        if (account != null) {
          publishInfo.setInfo_publish_person(account.getName());
        }
      }

      //���ظ���
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

      //���뷢����Ϣ��¼
      if(publishInfoAccessoryList!=null && publishInfoAccessoryList.size()>0){
        //�и���
        publishInfoDao.addPublishInfo(publishInfo,publishInfoAccessoryList);
      }else{
        //�޸���
        publishInfoDao.addPublishInfo(publishInfo);
      }

      if(strType==null || strType.equals("0")){
        strForwardTo = "FEEDBACK";
      }else{
        strForwardTo = "PUBLISH";
      }
    }
    catch (Exception ex) {
      //������Ϣ����
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