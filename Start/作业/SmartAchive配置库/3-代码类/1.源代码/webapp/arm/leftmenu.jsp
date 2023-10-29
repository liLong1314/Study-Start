<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sunyard.hgam.presentation.form.smm.AccountForm" %>
<%
  AccountForm accountInfo = (AccountForm) session.getAttribute("ACCOUNT_INFORMATION");
  List funcPerms = null;
	if(accountInfo != null) {
	  funcPerms = accountInfo.getFuncPerms();
	}
  int odivIndex = -1;
%>
<html>
<head>
<title>档案资源管理菜单</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}
//-->
</script>
</head>
<body background="../image/bg_color03.gif" leftmargin="0" topmargin="0">
	<script>
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
		if (funcPerms.contains("FUN0301")) {
		  odivIndex++;
	  %>
	  <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)"> 全宗管理</a></td>
        </tr>
      </table>
     <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN030101")) {%>
		  <tr>
            <td><a href="/arm/WholeView.do?type=1" target="hmain">全宗卷信息管理</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN030102")) {
		  %>
          <tr>
            <td><a href="/arm/EntryView.do?flag=1" target="hmain">档案类目管理</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN030103")) {
		  %>
		  <tr>
            <td><a href="/arm/SecretAllView.do" target="hmain">密级管理</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN030104")) {
		  %>
		  <tr>
            <td><a href="/arm/viewAllbuildingCataLog.do" target="hmain">历史目录册管理</a></td>
          </tr>
		  <% } %>
        </table>
	  </div>
    <%
      }
      if (funcPerms.contains("FUN0302")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)"> 档案信息管理</a></td>
        </tr>
      </table>
      <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN030201")) {%>
		  <tr>
            <td><a href="/arm/archverifyindex.jsp" target="hmain">档案校验</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN030202")) {
		  %>
		 <tr>
            <td><a href="/arm/archidentindex.jsp" target="hmain">鉴定管理</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN030203")) {
		  %>
          <tr>
            <td><a href="/arm/archdestroyindex.jsp" target="hmain">销毁管理</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN030204")) {
		  %>
          <tr>
            <td><a href="/arm/archchangeindex.jsp" target="hmain">变更管理</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN030205")) {
		  %>
		  <tr>
            <td><a href="/arm/StudyAllView.do" target="hmain">编研管理</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN030206")) {
		  %>
		  <tr>
            <td><a href="#" target="hmain">年检管理</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN030208")) {
		  %>
          <tr>
            <td><a href="/arm/viewallsubwatchexamine.do" target="hmain">分局工作汇报</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN030207")) {
		  %>
		  <tr>
            <td><a href="/arm/viewallwatchexamine.do" target="hmain">监督检查管理</a></td>
          </tr>

		  <% } %>
         </table>
      </div>
    <%
      }
      if (funcPerms.contains("FUN0303")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)">库房管理</a></td>
        </tr>
      </table>
      <div id="odiv" style="display:none">
	  <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
        <% if (funcPerms.contains("FUN030301")) {%>
		<tr>
            <td><a href="/arm/TemperatureView.do" target="hmain">温湿度管理</a></td>
        </tr>
		  <% }
			 if (funcPerms.contains("FUN030302")) {
		  %>
        <tr>
            <td><a href="/arm/SafetyView.do" target="hmain">安全管理</a></td>
        </tr>
		  <% }
			 if (funcPerms.contains("FUN030303")) {
		  %>
        <tr>
            <td><a href="/arm/ContainView.do" target="hmain">密集架管理</a></td>
        </tr>
		  <% } %>
      </table>
	  </div>
    <%
      }
      if (funcPerms.contains("FUN0304")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)">规范化管理</a></td>
        </tr>
      </table>
      <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN030401")) {%>
		  <tr>
            <td><a href="/arm/LawView.do" target="hmain">法律法规管理</a></td>
          </tr>
		  <% } %>
        </table>
      </div>
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