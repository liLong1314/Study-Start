<%@ page contentType="text/html;charset=GBK" language="java"%>
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
<title>系统维护管理菜单</title>
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
		if (funcPerms.contains("FUN0601")) {
		  odivIndex++;
	  %>
	  <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
		<tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)"> 日志管理</a></td>
        </tr>
      </table>
     <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN060101")) {%>
		  <tr>
            <td><a href="/smm/viewUserLog.do?page=refresh" target="hmain">系统运行日志管理</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN060102")) {
		  %>
          <tr>
            <td><a href="userLogManage.htm" target="hmain">用户操作日志管理</a></td>
          </tr>
		  <% } %>
        </table>
	  </div>
    <%
      }
      if (funcPerms.contains("FUN0602")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)"> 用户权限管理</a></td>
        </tr>
      </table>
      <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN060201")) {%>
		  <tr>
            <td><a href="/smm/queryAccount.do" target="hmain">用户管理</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN060202")) {
		  %>
          <tr>
            <td><a href="/smm/queryGroup.do" target="hmain">用户组管理</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN060203")) {
		  %>
          <tr>
            <td><a href="/smm/queryOrg.do" target="hmain">组织管理</a></td>
          </tr>
		  <% } %>
        </table>
      </div>
    <%
      }
      if (funcPerms.contains("FUN0603")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
		  <a href="#" onclick="showObj(<%= odivIndex %>)">数据字典管理</a></td>
        </tr>
      </table>
      <div id="odiv" style="display:none">
	  <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN060301")) {%>
		  <tr>
            <td><a href="/smm/viewallsysparam.do?view=true" target="hmain">系统参数</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN060302")) {
		  %>
          <tr>
            <td><a href="/smm/viewalltheme.do?view=true" target="hmain">主题词</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN060303")) {
		  %>
		  <tr>
            <td><a href="w_right_5.htm" target="hmain">标准定义</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN060304")) {
		  %>
		  <tr>
            <td><a href="w_right_3_5.htm" target="hmain">文件类型</a></td>
          </tr>
		  <% } %>
        </table>
	</div>
    <%
       }
      if (funcPerms.contains("FUN0605")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
		  <a href="#" onclick="showObj(<%= odivIndex %>)">电子表单管理</a></td>
        </tr>
      </table>
      <div id="odiv" style="display:none">
	  <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN060501")) {%>
		  <tr>
            <td><a href="/smm/queryEformDefineList.do" target="hmain">表单定义管理</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN060502")) {
		  %>
          <tr>
            <td><a href="/smm/queryFieldDefineList.do" target="hmain">字段定义管理</a></td>
          </tr>
		  <% } %>
        </table>
	</div>
    <%
      }
      if (funcPerms.contains("FUN0604")) {
        odivIndex++;
    %>
<!--
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)">数据库备份与恢复</a></td>
        </tr>
      </table>
      <div id="odiv" style="display:none">
	  <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN060401")) {%>
		  <tr>
            <td><a href="w_right_4_1.htm" target="hmain">备份</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN060402")) {
		  %>
          <tr>
            <td><a href="w_right_4_2_1.htm" target="hmain">恢复</a></td>
          </tr>
		  <% } %>
        </table>
	</div>
-->
	<%}%>
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
