<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
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
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
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
      if (funcPerms.contains("FUN0201")) {
        odivIndex++;
    %>
	  <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="146" align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)"> 档案著录</a></td>
        </tr>
      </table>
     <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
		  <% if (funcPerms.contains("FUN020101")) {%>
          <tr>
            <td><a href="frame_roll_default.htm" target="hmain">案卷著录</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN020102")) {
		  %>
          <tr>
            <td><a href="frame_piece_default.htm" target="hmain">件著录</a></td>
          </tr>
		  <% }
			 if (funcPerms.contains("FUN020103")) {
		  %>
		  <tr>
            <td><a href="frame_file_default.htm" target="hmain">文件著录</a></td>
          </tr>
		  <% } %>
        </table>
	  </div>
    <%
      }
      if (funcPerms.contains("FUN0202")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)"> 档案扫描</a></td>
        </tr>
      </table>
      <div id="odiv" style="display:none">
	    <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
          <% if (funcPerms.contains("FUN020201")) {%>
		  <tr>
            <td><a href="/adc/ScanArchivesView.do" target="hmain">档案扫描录入</a></td>
          </tr>
		  <% } %>
        </table>
      </div>
    <%
      }
      if (funcPerms.contains("FUN0203")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="143" align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)"> 档案检查</a></td>
        </tr>
      </table>
	  <div id="odiv" style="display:none">
      <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
        <% if (funcPerms.contains("FUN020301")) {%>
		<tr>
          <td><a href="/adc/checkArchivesView.do" target="hmain">检查</a></td>
        </tr>
		<% } %>
      </table>
      </div>
    <%
      }
      if (funcPerms.contains("FUN0204")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="143" align="center" background="../image/2_menu_bg.gif" ><img src="../image/dot01.gif" width="8" height="8">
            <a href="#" onclick="showObj(<%= odivIndex %>)"> 档案归档</a></td>
        </tr>
      </table>
	   <div id="odiv" style="display:none">
      <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
        <% if (funcPerms.contains("FUN020401")) {%>
		<tr>
          <td><a href="/adc/queryArchivesView.do" target="hmain">归档</a></td>
        </tr>
		<% } %>
      </table>
      </div>
	<%
	  }
	%>
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
