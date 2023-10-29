package com.sunyard.hgam.presentation.action.adc;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.sunyard.hgam.presentation.form.adc.ArchivesFileForm;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesDao;
import com.sunyard.hgam.persistence.dao.beans.adc.Archives;
import com.sunyard.hgam.persistence.dao.iface.adc.EformDao;
import com.sunyard.hgam.persistence.dao.beans.adc.EformFieldValue;
import java.util.ArrayList;
import java.util.List;
import com.sunyard.hgam.persistence.dao.beans.adc.EformDefine;

/**
 * 增加业务类档案文件著录信息
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 */
public class AddArchivesFileAction extends BaseAction {
  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.Exception {

    //ARCHIVES_ID=5&PROJ_ID=32&UP_PHASE_ID=0&PHASE_ID=0
    ArchivesFileForm archivesFileForm = (ArchivesFileForm)form;
    ArchivesFile archivesFile = archivesFileForm.getArchivesFile();
    ArchivesDao archivesDao = (ArchivesDao) domainLogic.getDAO("Archives");
    ArchivesFileDao archivesFileDao = (ArchivesFileDao)domainLogic.getDAO("ArchivesFile");
    EformDao eformDao = (EformDao)domainLogic.getDAO("Eform");

    String operName = archivesFileForm.getOperName();
    String strForwardTo = "SUCCESS";

    archivesFileForm.setMsgError("");

    //取得文件所在档案ID：1. 从参数表获取 ， 2.从session中获取
    String archives_id = request.getParameter("ARCHIVES_ID");
    if (archives_id == null || archives_id.equalsIgnoreCase("")) {
      archives_id = (String) request.getSession().getAttribute("ARCHIVES_ID");
    }

    //获取文件所在档案信息
    Archives archives = archivesDao.getArchivesByArchivesID(Integer.parseInt(archives_id));
    archivesFileForm.setArchives(archives);

    try {
      if (operName.equalsIgnoreCase("")){
        //刚进来，不是提交
        archivesFile.setArchives_id(archives.getAARCHIVES_ID()+"");
        if(archives.getAIS_OPERATION().equalsIgnoreCase("0")){
           //文书类
           strForwardTo = "WENSHU";
        }else if(archives.getAIS_OPERATION().equalsIgnoreCase("1")){
           //业务类
           strForwardTo = "YEWU";
           //参数
           String PROJ_ID = request.getParameter("PROJ_ID");
           String UP_PHASE_ID = request.getParameter("UP_PHASE_ID");
           String PHASE_ID = request.getParameter("PHASE_ID");
           if (PROJ_ID == null || PROJ_ID.equalsIgnoreCase("")) {
             PROJ_ID = (String) request.getSession().getAttribute("PROJ_ID");
           }
           if (UP_PHASE_ID == null || UP_PHASE_ID.equalsIgnoreCase("")) {
             UP_PHASE_ID = (String) request.getSession().getAttribute("UP_PHASE_ID");
           }
           if (PHASE_ID == null || PHASE_ID.equalsIgnoreCase("")) {
             PHASE_ID = (String) request.getSession().getAttribute("PHASE_ID");
           }
           request.getSession().setAttribute("PROJ_ID", PROJ_ID);
           request.getSession().setAttribute("UP_PHASE_ID", UP_PHASE_ID);
           request.getSession().setAttribute("PHASE_ID", PHASE_ID);
           //初始化文件元素
           archivesFile.setProj_id(PROJ_ID);
           archivesFile.setUp_phase_id(UP_PHASE_ID);
           archivesFile.setPhase_id(PHASE_ID);
           if(archivesFile.getEform_id()!=null && !archivesFile.getEform_id().equals("")){
             //初始化电子表单输入元素
             archivesFileForm.setEformFieldDefineList(eformDao.getEformFieldDefineByEformId(archivesFile.getEform_id()));
           }else{
             archivesFileForm.setEformFieldDefineList(new ArrayList());
           }
         }else if(archives.getAIS_OPERATION().equalsIgnoreCase("2")){
            //其他类
            strForwardTo = "OTHER";
            //取得这类的电子表单编码
            EformDefine eformDefine = eformDao.getEformDefineByEntryId(archives.getAENTRY_ID());
            if(eformDefine!=null){
              archivesFile.setEform_id(eformDefine.getEform_id());
            }
            if(archivesFile.getEform_id()!=null && !archivesFile.getEform_id().equals("")){
              //初始化电子表单输入元素
              archivesFileForm.setEformFieldDefineList(eformDao.getEformFieldDefineByEformId(archivesFile.getEform_id()));
            }else{
              archivesFileForm.setEformFieldDefineList(new ArrayList());
            }
         }
      } else if (operName.equalsIgnoreCase("SUBMIT_ACTION")) {
        //重置操作标识
        archivesFileForm.setOperName("");
        //设置字段值
        String fileId = (archivesFileDao.getMaxFileId().intValue()+1) + "";
        archivesFile.setFile_id(fileId);
        //进行著录操作
        if(archivesFile.getEform_id()==null || archivesFile.getEform_id().equals("")){
          //无电子表单：文书类文件著录
          archivesFileDao.addArchivesFile(archivesFile);
        }else{
          //有电子表单：业务类/其他类文件著录
          //archivesFileDao.addArchivesFile(archivesFile);
          //电子表单著录
          List eformFieldValueList = new ArrayList();
          String field_id[] = request.getParameterValues("field_id");
          String field_value[] = request.getParameterValues("field_value");
          for(int i=0;i<field_value.length;i++){
            if(!field_value[i].equalsIgnoreCase("")){
              //设置
              EformFieldValue EformFieldValue = new EformFieldValue();
              EformFieldValue.setFile_id(fileId);
              EformFieldValue.setField_id(field_id[i]);
              EformFieldValue.setField_value(field_value[i]);
              //封装2003-12-27
              eformFieldValueList.add(EformFieldValue);
              //eformDao.addEformFieldValue(EformFieldValue);
            }
          }
          //放在同一事务进行处理2003-12-27
          archivesFileDao.addArchivesFile(archivesFile,eformFieldValueList);
        }
      }

      request.getSession().setAttribute("ArchivesFileForm", archivesFileForm);
    }
    catch (Exception ex) {
      //错误信息处理
      archivesFileForm.setMsgError(ex.toString());

      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }finally{
      return mapping.findForward(strForwardTo);
    }
  }

}