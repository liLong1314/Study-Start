package com.sunyard.hgam.presentation.action.aum;

import com.sunyard.hgam.presentation.base.BaseAction;
import org.apache.struts.action.ActionMapping;
import com.ibatis.common.util.PaginatedList;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesPage;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeDetail;
import com.sunyard.hgam.presentation.form.aum.UtilizeDetailForm;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeDetailDao;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesPageDao;
import java.util.Map;
import java.util.HashMap;
import com.sunyard.hgam.persistence.dao.beans.aum.UtilizeInfo;
import com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao;
import com.sunyard.hgam.persistence.dao.iface.adc.ArchivesFileDao;
import com.sunyard.hgam.persistence.dao.beans.adc.ArchivesFile;

public class AddUtilizeDetailAction
    extends BaseAction {

  public ActionForward doPerform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    String fileIDList[] = request.getParameterValues("file_id");
    if (fileIDList== null) {
      throw new Exception("�������ԣ�û��ָ���ļ���ţ�");
    }

    ArchivesPageDao archivesPageDao = (ArchivesPageDao) domainLogic.getDAO(
        "ArchivesPage");
    UtilizeDetailDao utilizeDetailDao = (UtilizeDetailDao) domainLogic.getDAO(
        "UtilizeDetail");

    UtilizeDetailForm uDetailForm = (UtilizeDetailForm) form;
    String strForwardTo = "";
    String fileID = "";
    List pageList = new ArrayList();
    ArchivesPage archivesPage = new ArchivesPage();
    UtilizeDetail utilizeDetail = null;
    String applyID = (String)request.getSession().getAttribute("applyID");
    UtilizeDetail tmpDetail = null;

    UtilizeInfoDao utilDao = (UtilizeInfoDao) domainLogic.getDAO(
        "UtilizeInfoDao");
    ArchivesFileDao archivesFileDao = (ArchivesFileDao) domainLogic.getDAO(
        "ArchivesFile");

    ArchivesFile archFile = new ArchivesFile();
    String isBorrow = "0";
    boolean flag = true;
    List invalidFileList = new ArrayList();
    UtilizeDetail utilDetail = null;


    try {

      //�ж��ĵ���Ч��
      Map queryMap = new HashMap();
      queryMap.put("applyID", applyID);
      UtilizeInfo utilInfo = utilDao.getUtilizeInfoByApplyID(queryMap);
      String modeID = utilInfo.getModeID();
      for (int i = 0; i < fileIDList.length; i++) {
        fileID = fileIDList[i];
        archFile = archivesFileDao.getArchivesFileByFileID(fileID);
        isBorrow = archFile.getIs_borrow();
        //���ֽ�����ϵ��ĵ��Ѿ��������ʾ���ܽ��
        if (modeID.equals("1") && isBorrow.equals("1")) {
          flag = false;
          utilDetail = new UtilizeDetail();
          utilDetail.setFile_id(archFile.getFile_id());
          utilDetail.setFile_name(archFile.getFile_title());
          invalidFileList.add(utilDetail);
        }
      }
      if (!flag) {
        request.getSession().setAttribute("invalidFileList", invalidFileList);
        return mapping.findForward("INVALID_SELECT");
      }



      //����page
      for (int i = 0; i < fileIDList.length; i++) {
        fileID = fileIDList[i];
        //ȡ��ĳһ���ļ����������page
        pageList = archivesPageDao.queryArchivesPageByFileID(new Integer(fileID),
            1000);
        //û��page
        if (pageList == null || pageList.size() == 0) {
          utilizeDetail = new UtilizeDetail();
          utilizeDetail.setApply_id(applyID);
          utilizeDetail.setPage_id("");
          utilizeDetail.setFile_id(fileID);
          //��ȡcharge_id
          tmpDetail = new UtilizeDetail();
          List tmpDetailList = utilizeDetailDao.queryPageChargeByFileID(fileID);
          if (tmpDetailList != null && tmpDetailList.size() > 0) {
            tmpDetail = (UtilizeDetail)tmpDetailList.get(0);
            if (tmpDetail.getCharge_id() == null) {
              utilizeDetail.setCharge_id("");
            } else {
              utilizeDetail.setCharge_id(tmpDetail.getCharge_id());
            }
          } else {
            utilizeDetail.setCharge_id("");
          }
          utilizeDetail.setRemark("˵��");
          utilizeDetailDao.insert(utilizeDetail);
          continue;
        }
        //��page
        for (int j = 0; j < pageList.size(); j++) {
          //�����page���뵽utilize_detail��
          archivesPage = (ArchivesPage) pageList.get(j);
          utilizeDetail = new UtilizeDetail();
          utilizeDetail.setApply_id(applyID);
          utilizeDetail.setPage_id(archivesPage.getPage_id());
          utilizeDetail.setFile_id(archivesPage.getFile_id());
          //��ȡcharge_id
          tmpDetail = new UtilizeDetail();
          tmpDetail = utilizeDetailDao.getUtilizeDetailByPageID(archivesPage.
              getPage_id());
          if (tmpDetail == null || tmpDetail.getCharge_id() == null) {
            utilizeDetail.setCharge_id("");
          } else {
            utilizeDetail.setCharge_id(tmpDetail.getCharge_id());
          }
          utilizeDetail.setRemark("˵��");
          utilizeDetailDao.insert(utilizeDetail);
        }
      }
      return mapping.findForward("SUCCESS");
    }
    catch (Exception ex) {
      ex.printStackTrace();
      return mapping.findForward("FAILURE");
    }
  }

}