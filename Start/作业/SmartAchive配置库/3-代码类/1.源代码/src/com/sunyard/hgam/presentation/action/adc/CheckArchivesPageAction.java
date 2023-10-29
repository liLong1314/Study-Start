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
 * <p>Description: 杭州市规划档案综合管理系统</p>
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

    //默认"显示"功能
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
      //检查“保存”功能
      capForm.setFunctionName("SaveFail") ;

      //1.保存数据
      if ("CheckSavePage".equalsIgnoreCase(functionName) ||
          "CheckSave".equalsIgnoreCase(functionName) ){
        dao.updateArchivesPage(capForm.getArchivesPage()) ;
      }

      //2.保存影像
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
        //删除临时文件夹
        try{
          AdcUtil.deletePath(AdcUtil.AttachString(capForm.getProperiesInfo().getFtproot(),
                                 fileSeparator) + capForm.getServerDir()) ;
        }catch(Exception e){

        }
      }

      //3.返回保存成功信息
      capForm.setFunctionName("SaveOK") ;

      forwardJSP = "SaveFinished";
    }
    else if ("ShowPage".equalsIgnoreCase(functionName) ||
             "ShowPageUp".equalsIgnoreCase(functionName) ||
             "ShowPageDown".equalsIgnoreCase(functionName)){
      //删除临时文件夹
      try {
        if (capForm.getServerDir() != null && !capForm.getServerDir().equalsIgnoreCase(""))
          AdcUtil.deletePath(AdcUtil.AttachString(capForm.getProperiesInfo().
            getFtproot(), fileSeparator) + capForm.getServerDir());
      }
      catch (Exception e) {

      }

      //1.从参数中获取档案页ID，并读取档案页内容
      int page_id = 0;
      if ("ShowPageUp".equalsIgnoreCase(functionName)){
        //显示上一页
        page_id = dao.getPreviousPageId(capForm.getArchivesPage());
      }
      else if ("ShowPageDown".equalsIgnoreCase(functionName)){
        //显示下一页
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

      //返回成功信息，客户端可以通过FTP下载影像页了。
      capForm.setFunctionName("PageFileReady");

      forwardJSP = "ShowPage";
    }

    return (mapping.findForward(forwardJSP));
  }


}