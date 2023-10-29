package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.BaseAction;
import java.util.*;
import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.sunyard.hgam.presentation.form.adc.*;
import com.sunyard.hgam.persistence.dao.iface.adc.*;
import com.sunyard.hgam.persistence.dao.beans.adc.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.util.adc.AdcUtil ;
import com.sunyard.hgam.presentation.base.IDGenerator;
import java.io.File;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author not attributable
 * @version 1.0
 */

public class CheckArchivesPageAction extends BaseAction {
  public CheckArchivesPageAction() {
  }

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {
    String forwardJSP = "ShowPage";
    CheckArchivesPageForm capForm = (CheckArchivesPageForm) form;
    String functionName = capForm.getFunctionName();
    capForm.setFunctionName("");

    //Ĭ��"��ʾ"����
    String fileSeparator = System.getProperty("file.separator");
    String sSrcFile = "";
    String sDesFile = "";
    if (functionName==null || functionName.equalsIgnoreCase(""))
      functionName = "ShowPage";

    ArchivesPageDao dao = (ArchivesPageDao) domainLogic.getDAO("ArchivesPage");
    String fileName = "";
    if ("CheckSavePage".equalsIgnoreCase(functionName) ||
        "CheckSaveFile".equalsIgnoreCase(functionName) ||
        "CheckSave".equalsIgnoreCase(functionName) ){
      //��顰���桱����
      capForm.setFunctionName("SaveFail") ;

      //1.��������
      if ("CheckSavePage".equalsIgnoreCase(functionName) ||
          "CheckSave".equalsIgnoreCase(functionName) ){
        dao.updateArchivesPage(capForm.getArchivesPage()) ;
      }

      //2.����Ӱ��
      if (("CheckSaveFile".equalsIgnoreCase(functionName) ||
           "CheckSave".equalsIgnoreCase(functionName) ) &&
          (!capForm.getServerFileName().equalsIgnoreCase("")) &&
          (!capForm.getServerDir().equalsIgnoreCase("")) ){
        fileName = capForm.getArchivesPage().getPage_pathName();
        fileName = fileName.replaceAll("//", "\\");
        if (fileName.indexOf("\\") == 0)
          fileName = fileName.substring(fileName.indexOf("\\") + 1);
        sSrcFile =
            AdcUtil.AttachString(capForm.getProperiesInfo().getFtproot(),
                                 fileSeparator) +
            capForm.getServerDir() + fileSeparator + capForm.getServerFileName();
        sDesFile =
            AdcUtil.AttachString(capForm.getProperiesInfo().getFileroot(),
                                 fileSeparator) +
            fileName;
        AdcUtil.fileCopy(sSrcFile, sDesFile);
        //ɾ����ʱ�ļ���
        try{
          AdcUtil.deletePath(AdcUtil.AttachString(capForm.getProperiesInfo().getFtproot(),
                                 fileSeparator) + capForm.getServerDir()) ;
        }catch(Exception e){

        }
      }

      //3.���ر���ɹ���Ϣ
      capForm.setFunctionName("SaveOK") ;

      forwardJSP = "SaveFinished";
    }
    else if ("ShowPage".equalsIgnoreCase(functionName) ||
             "ShowPageUp".equalsIgnoreCase(functionName) ||
             "ShowPageDown".equalsIgnoreCase(functionName)){
      //ɾ����ʱ�ļ���
      try {
        if (capForm.getServerDir() != null && !capForm.getServerDir().equalsIgnoreCase(""))
          AdcUtil.deletePath(AdcUtil.AttachString(capForm.getProperiesInfo().
            getFtproot(), fileSeparator) + capForm.getServerDir());
      }
      catch (Exception e) {

      }

      //1.�Ӳ����л�ȡ����ҳID������ȡ����ҳ����
      int page_id = 0;
      if ("ShowPageUp".equalsIgnoreCase(functionName)){
        //��ʾ��һҳ
        page_id = dao.getPreviousPageId(capForm.getArchivesPage());
      }
      else if ("ShowPageDown".equalsIgnoreCase(functionName)){
        //��ʾ��һҳ
        page_id = dao.getNextPageId(capForm.getArchivesPage());
      }
      else{
        String sPage_ID = request.getParameter("page_id");
        try {
          page_id = Integer.parseInt(sPage_ID);
        }
        catch (Exception e) {

        }
        if (page_id == 0)
          page_id = Integer.parseInt(capForm.getArchivesPage().getPage_id());
      }

      if (page_id==0){
        capForm.setFunctionName("nonePage") ;
        forwardJSP = "nonePage";
        return (mapping.findForward(forwardJSP));
      }
      ArchivesPage page= dao.getArchivesPageByPageID(new Integer(page_id)) ;
      page.setArchives_id(Integer.toString(dao.getArchivesIdByPageId(new Integer(page_id)))) ;
      capForm.setArchivesPage(page) ;

      //2.
      fileName = page.getPage_pathName() ;
      fileName = fileName.replace('/', '\\') ;
      if (fileName.indexOf("\\")==0)
        fileName = fileName.substring(fileName.indexOf("\\")+1);
      capForm.setServerFileName(fileName.substring(fileName.indexOf("\\")+1)) ;
      capForm.setServerDir(IDGenerator.getTimeString()) ;

      sSrcFile =
          AdcUtil.AttachString(capForm.getProperiesInfo().getFileroot(), fileSeparator) +
          fileName;
      sDesFile =
          AdcUtil.AttachString(capForm.getProperiesInfo().getFtproot(), fileSeparator) +
          capForm.getServerDir() + fileSeparator + capForm.getServerFileName();
      File f = new File(sSrcFile);
      if (f.exists()){
        AdcUtil.createFolder(capForm.getProperiesInfo().getFtproot(), capForm.getServerDir()) ;
        AdcUtil.fileCopy(sSrcFile, sDesFile);
      }else{
        capForm.setServerDir("") ;
        capForm.setServerFileName("");
      }

      //���سɹ���Ϣ���ͻ��˿���ͨ��FTP����Ӱ��ҳ�ˡ�
      capForm.setFunctionName("PageFileReady");

      forwardJSP = "ShowPage";
    }

    return (mapping.findForward(forwardJSP));
  }


}