<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sunyard.hgam.presentation.form.smm.AccountForm" %>
<%@ page import="com.sunyard.hgam.persistence.dao.iface.aum.UtilizeInfoDao" %>
<%@ page import="com.sunyard.hgam.domain.logic.DomainLogic" %>
<%@ page import="com.sunyard.hgam.persistence.dao.iface.smm.AccountDAO" %>
<%@ page import="com.sunyard.hgam.persistence.dao.beans.smm.Account" %>
<%
  AccountForm accountInfo = (AccountForm) session.getAttribute("ACCOUNT_INFORMATION");
  List funcPerms = null;
	if(accountInfo != null) {
	  funcPerms = accountInfo.getFuncPerms();
	}
  int odivIndex = -1;
%>

<%

  List taskList = null;
  UtilizeInfoDao utilDao = (UtilizeInfoDao) DomainLogic.getInstance().getDAO(
        "UtilizeInfoDao");
  AccountDAO accountDAO = (AccountDAO) DomainLogic.getInstance().getDAO("Account");
  Account account = new Account();
  account = accountInfo.getAccount();
  String loginName = account.getUserName();
  String pwd = accountDAO.getPasswordByUsername(loginName);

  //view
  taskList = utilDao.getAllTaskByUser(loginName, pwd, "0", 1);
  int allViewTaskAmount = taskList.size();
  taskList = utilDao.getAllTaskByUser(loginName, pwd, "1", 1);
  int unhandledViewTaskAmount = taskList.size();
  taskList = utilDao.getAllTaskByUser(loginName, pwd, "2", 1);
  int handledViewTaskAmount = taskList.size();

  //borrow
  taskList = utilDao.getAllTaskByUser(loginName, pwd, "0", 2);
  int allBorrowTaskAmount = taskList.size();
  taskList = utilDao.getAllTaskByUser(loginName, pwd, "1", 2);
  int unhandledBorrowTaskAmount = taskList.size();
  taskList = utilDao.getAllTaskByUser(loginName, pwd, "2", 2);
  int handledBorrowTaskAmount = taskList.size();

  //repair
  taskList = utilDao.getAllTaskByUser(loginName, pwd, "0", 3);
  int allRepairTaskAmount = taskList.size();
  taskList = utilDao.getAllTaskByUser(loginName, pwd, "1", 3);
  int unhandledRepairTaskAmount = taskList.size();
  taskList = utilDao.getAllTaskByUser(loginName, pwd, "2", 3);
  int handledRepairTaskAmount = taskList.size();

%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
</head>

<body background="../image/bg_color03.gif" leftmargin="0" topmargin="0">
	<script>
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}

function hideAll() {
  for(i=0;i<odiv.length;i++) {
    odiv[i].style.display="none";
  }
}

function showObj(num) {

  if (odiv[num].style.display=="none") {
    hideAll();
    odiv[num].style.display="inline";
  }
  else {
    odiv[num].style.display="none";
  }

}
</script>
<table width="188" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="12" valign="top"><img src="../image/home_38.gif" width="188" height="12"></td>
  </tr>
<logic:present name="ACCOUNT_INFORMATION">
  <tr>
    <td height="80%" align="center" valign="top" background="../image/home_39.gif">
	  <%
		if (funcPerms.contains("FUN0401")) {
		  odivIndex++;
	  %>
<table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="/aum/ViewTaskList.do?flag=0" target="hmain" onclick="showObj(<%= odivIndex %>)">查阅管理</a></td>
        </tr>
      </table>
     <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN040101")) {%>
          <tr>
            <td><a href="/aum/ViewNewApplyForm.do"  target="hmain">新建申请</a></td>
          </tr>
          <% }
             if (funcPerms.contains("FUN040102")) {
          %>
          <tr>
            <td><a href="/aum/ViewTaskList.do?flag=1" target="hmain">未办任务
              <% if (unhandledViewTaskAmount > 0) {%>
                <font color="blue">（<%=unhandledViewTaskAmount%>）</font>
              <%}%>
            </a></td>
          </tr>
          <% }
             if (funcPerms.contains("FUN040103")) {
          %>
          <tr>
            <td><a href="/aum/ViewTaskList.do?flag=2" target="hmain">已办任务
              <% if (handledViewTaskAmount > 0) {%>
                <font color="blue">（<%=handledViewTaskAmount%>）</font>
              <%}%>
            </a></td>
          </tr>
          <% }
             if (funcPerms.contains("FUN040104")) {
          %>
          <tr>
            <td><a href="/aum/ViewTaskList.do?flag=0" target="hmain">所有任务
              <% if (allViewTaskAmount > 0) {%>
                <font color="blue">（<%=allViewTaskAmount%>）</font>
              <%}%>
            </a></td>
          </tr>
          <% } %>
        </table>
	  </div>
    <%
      }
      if (funcPerms.contains("FUN0402")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="/aum/BorrowTaskList.do?flag=0" target="hmain" onclick="showObj(<%= odivIndex %>)"> 借阅管理</a></td>
        </tr>
      </table>
      <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN040201")) {%>
          <tr>
            <td><a href="/aum/BorrowNewApplyForm.do"  target="hmain">新建申请</a></td>
          </tr>
          <% }
             if (funcPerms.contains("FUN040202")) {
          %>
          <tr>
            <td><a href="/aum/BorrowTaskList.do?flag=1" target="hmain">未办任务
              <% if (unhandledBorrowTaskAmount > 0) {%>
                <font color="blue">（<%=unhandledBorrowTaskAmount%>）</font>
              <%}%>
            </a></td>
          </tr>
          <% }
             if (funcPerms.contains("FUN040203")) {
          %>
          <tr>
            <td><a href="/aum/BorrowTaskList.do?flag=2" target="hmain">已办任务
              <% if (handledBorrowTaskAmount > 0) {%>
                <font color="blue">（<%=handledBorrowTaskAmount%>）</font>
              <%}%>
            </a></td>
          </tr>
          <% }
             if (funcPerms.contains("FUN040204")) {
          %>
          <tr>
            <td><a href="/aum/BorrowTaskList.do?flag=0" target="hmain">所有任务
              <% if (allBorrowTaskAmount > 0) {%>
                <font color="blue">（<%=allBorrowTaskAmount%>）</font>
              <%}%>
            </a></td>
          </tr>
          <% } %>
        </table>
      </div>
    <%
      }
      if (funcPerms.contains("FUN0403")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="/aum/RepairTaskList.do?flag=0" target="hmain" onclick="showObj(<%= odivIndex %>)">查证管理</a></td>
        </tr>
      </table>
      <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN040301")) {%>
          <tr>
            <td><a href="/aum/RepairNewApplyForm.do"  target="hmain">新建申请</a></td>
          </tr>
          <% }
             if (funcPerms.contains("FUN040302")) {
          %>
          <tr>
            <td><a href="/aum/RepairTaskList.do?flag=1" target="hmain">未办任务
              <% if (unhandledRepairTaskAmount > 0) {%>
                <font color="blue">（<%=unhandledRepairTaskAmount%>）</font>
              <%}%>
            </a></td>
          </tr>
          <% }
             if (funcPerms.contains("FUN040303")) {
          %>
          <tr>
            <td><a href="/aum/RepairTaskList.do?flag=2" target="hmain">已办任务
              <% if (handledRepairTaskAmount > 0) {%>
                <font color="blue">（<%=handledRepairTaskAmount%>）</font>
              <%}%>
            </a></td>
          </tr>
          <% }
             if (funcPerms.contains("FUN040304")) {
          %>
          <tr>
            <td><a href="/aum/RepairTaskList.do?flag=0" target="hmain">所有任务
              <% if (allRepairTaskAmount > 0) {%>
                <font color="blue">（<%=allRepairTaskAmount%>）</font>
              <%}%>
            </a></td>
          </tr>
          <% } %>
        </table>
      </div>
    <%
      }
      if (funcPerms.contains("FUN0404")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)">收费管理</a></td>
        </tr>
      </table>
	  <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN040401")) {%>
          <tr>
            <td><a href="/aum/IsCharge.do" target="hmain">收费项目定义</a></td>
          </tr>
          <% }
             if (funcPerms.contains("FUN040402")) {
          %>
          <tr>
            <td><a href="/aum/ChargeStandard.do" target="hmain">收费标准定义</a></td>
          </tr>
          <% } %>
        </table>
      </div>
    <%
      }
      if (funcPerms.contains("FUN0405")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)">综合查询</a></td>
        </tr>
      </table>
	  <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN040501")) {%>
          <tr>
            <td><a href="../aum/queryindex.jsp" target="hmain">档案综合查询</a></td>
          </tr>
          <tr>
            <td><a href="../aum/in_out_lib_query.jsp" target="hmain">出入库查询</a></td>
          </tr>
          <% }
             if (funcPerms.contains("FUN040502")) {
          %>
<!--
          <tr>
            <td><a href="../main/l_right_5_3.htm" target="hmain">统计报表</a></td>
          </tr>
-->
          <% } %>
        </table>
      </div>
    <%
      }
      if (funcPerms.contains("FUN0406")) {
        odivIndex++;
    %>
<!--
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)">发布管理</a></td>
        </tr>
      </table>
      <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN040601")) {%>
          <tr>
            <td><a href="../main/l_right_6_1.htm" target="hmain">信息发布</a></td>
          </tr>
          <% }
             if (funcPerms.contains("FUN040602")) {
          %>
          <tr>
            <td><a href="../main/l_right_6_2.htm" target="hmain">取消发布</a></td>
          </tr>
          <% } %>
        </table>
      </div>
 -->
    <% } %>
    <input type="hidden" name="odiv">
    </td>
  </tr>
</logic:present>
<logic:notPresent name="ACCOUNT_INFORMATION">
  <tr>
    <td height="80%" align="center" valign="top" background="../image/home_39.gif">
	</td>
  </tr>
</logic:notPresent>
  <tr>
    <td valign="top"><img src="../image/home_48.gif" width="188" height="43"></td>
  </tr>
</table>
</body>
</html>
