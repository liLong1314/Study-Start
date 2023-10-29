package com.sunyard.hgam.presentation.action.arm;

import com.sunyard.hgam.presentation.base.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.ibatis.common.util.PaginatedList;
import com.sunyard.hgam.persistence.dao.iface.adc.EntryTreeListDao;
import java.util.List;
import java.util.Iterator;
import com.sunyard.hgam.persistence.dao.beans.adc.EntryTreeList;

/**
 * <p>Title: HGAM</p>
 * <p>Description: �����й滮�����ۺϹ���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author ֣��ȫ
 * @version 1.0
 */
public class ViewTreeListAction
    extends BaseAction {
  //����������ӳ���
  protected static final String URL_ROLL = "InsertRollNavigator.do";
  protected static final String URL_PIECE = "InsertPieceNavigator.do";
  protected static final String URL_FILE = "InsertFileNavigator.do";
  protected static final String URL_ARCHIVES = "ViewArcList.do";

  protected static final String URL_ARCHVERIFY = "/arm/ArchView.do";
  protected static final String URL_ARCHIDENTIFY = "/arm/ArchView.do";
  protected static final String URL_ARCHDESTROY = "/arm/ArchView.do";
  protected static final String URL_ARCHCHANGE = "/arm/ArchView.do";
  protected static final String URL_QUERY = "/aum/queryArchivesNavigator.do";
  protected static final String URL_OAQUERY = "/aum/oaquerymain.jsp";

  public ActionForward doPerform(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws java.lang.
      Exception {

    //����������ʾ��ͬ����Ŀ��
    String entryType = request.getParameter("type");
    String strEntryTree = "";
    String strForwardTo = "";
    String strPara = "";
    try {
      if (entryType == null)
        return mapping.findForward("FAILURE");
      String strEntryTreeName = "";
      String strURL = "";
      switch (Integer.parseInt(entryType)) {
        case 1: //1��������¼
          strEntryTreeName = "ENTRY_ROLL";
          strURL = URL_ROLL;
          strForwardTo = "ROLL";
          break;
        case 2: //2������¼
          strEntryTreeName = "ENTRY_PIECE";
          strURL = URL_PIECE;
          strForwardTo = "PIECE";
          break;
        case 3: //3���ļ���¼
          strEntryTreeName = "ENTRY_FILE";
          strURL = URL_FILE;
          strForwardTo = "FILE";
          break;
        case 4: //4����������
          strEntryTreeName = "ENTRY_ARCHIVES";
          strURL = URL_ARCHIVES;
          strForwardTo = "ARCHIVES";
          break;
        case 5: //4������У��
          strEntryTreeName = "ENTRY_VERIFY";
          strURL = URL_ARCHVERIFY;
          strForwardTo = "ArchVerify";
          strPara = "flag=1";
          break;
        case 6: //4����������
          strEntryTreeName = "ENTRY_IDENTIFY";
          strURL = URL_ARCHIDENTIFY;
          strForwardTo = "ArchIdentify";
          strPara = "flag=2";
          break;
        case 7: //4�����ٹ���
          strEntryTreeName = "ENTRY_DESTROY";
          strURL = URL_ARCHDESTROY;
          strForwardTo = "ArchDestroy";
          strPara = "flag=3";
          break;
        case 8: //4���������
          strEntryTreeName = "ENTRY_CHANGE";
          strURL = URL_ARCHCHANGE;
          strForwardTo = "ArchChange";
          strPara = "flag=4";
          break;
        case 9: //�ۺϲ�ѯ-����������ϵͳ
          strEntryTreeName = "ENTRY_QUERY";
          strURL = URL_QUERY;
          strForwardTo = "Query";
          //strPara = "flag=4";
          break;
        case 10: //4���ļ���ѯ-����������ϵͳ
          strEntryTreeName = "ENTRY_OAQUERY";
          strURL = URL_OAQUERY;
          strForwardTo = "OAQuery";
          //strPara = "flag=4";
          break;
        default: //����
          strEntryTreeName = "";
          strURL = "";
          strForwardTo = "FAILURE";
          break;
      }

      strEntryTree = getEntryTreeListByType(entryType, strURL, strPara);
      request.getSession().setAttribute(strEntryTreeName, strEntryTree);
    }
    catch (Exception ex) {
      ex.printStackTrace();
      strForwardTo = "FAILURE";
    }
    finally {
      //return mapping.findForward("SUCCESS");
      return mapping.findForward(strForwardTo);
    }
  }

  /**
   * �������ȡ�þ��в�ͬ���ӵ���Ŀ��
   * @param entryType
   * 1��������¼
   * 2������¼
   * 3���ļ���¼
   * 4����������
   * @param strURL
   * @param strPara
   * @return
   */
  private String getEntryTreeListByType(String entryType, String strURL,
                                        String strPara) {
    //���JAVASCRIPT�ַ����б���ʽ���£�
    //firstLvlNode =root.add("��Ⱥ������")
    //secondLvlNode=n13.add("����")
    //secondLvlNode.onclick="doClick('../main/c_right_1_1_1_0.htm')"
    String strResult = "";

    try {
      EntryTreeListDao entryTreeListDao = (EntryTreeListDao) domainLogic.getDAO(
          "EntryTreeList");
      Iterator firstEntryIterator = entryTreeListDao.getAllFirstLevelTree().
          iterator();
      Iterator secondEntryIterator = null;
      EntryTreeList treeNode1, treeNode2 = null;
      while (firstEntryIterator.hasNext()) {
        treeNode1 = (EntryTreeList) firstEntryIterator.next();
        strResult += "firstLvlNode = " + "root.add(\"" + treeNode1.getEntryName() +
            "\");\n";
        //entryType=9 --�ۺϲ�ѯ-����������ϵͳ
        //�����ڵ�һ��Ҳ���Ե��
        if(entryType.equals("9")){
          strResult += "firstLvlNode.onclick = \"doClick('" + strURL +
              "?ENTRY_ID=" + treeNode1.getEntryId()
              + "&ISOPERATION=" + treeNode1.getIsOperation()
              + "&ENTRY_LEVEL=" + treeNode1.getEntryLevel();
          if (strPara.equalsIgnoreCase("")) {
            strResult += "')\";\n";
          }else {
            strResult += "&" + strPara + "')\";\n";
          }
        }
        secondEntryIterator = entryTreeListDao.getSecondLevelTreeByFatherId(
            treeNode1.getEntryId()).iterator();
        while (secondEntryIterator.hasNext()) {
          treeNode2 = (EntryTreeList) secondEntryIterator.next();
          strResult += "secondLvlNode = firstLvlNode.add(\"" +
              treeNode2.getEntryName() + "\");\n";

          //modify by yehao
          //����������������������
          strResult += "secondLvlNode.onclick = \"doClick('" + strURL +
              "?ENTRY_ID=" + treeNode2.getEntryId()
              + "&ISOPERATION=" + treeNode2.getIsOperation()
              + "&ENTRY_LEVEL=" + treeNode2.getEntryLevel();
          if (strPara.equalsIgnoreCase("")) {
            strResult += "')\";\n";
          }
          else {
            strResult += "&" + strPara +"')\";\n";
          }
          //end
        }
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      return strResult;
    }
  }
}