<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sunyard.hgam.presentation.form.smm.AccountForm" %>
<%
  AccountForm accountInfo = (AccountForm) session.getAttribute("ACCOUNT_INFORMATION");
  List funcPerms = null;
	if(accountInfo != null) {
	  funcPerms = accountInfo.getFuncPerms();
	}
  int odivIndex = 0;
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript">
<!--
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
//-->
</script>
</head>
<body background="../image/bg_color03.gif" leftmargin="0" topmargin="0">
<table width="188" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="12" valign="top"><img src="../image/home_38.gif" width="188" height="12"></td>
  </tr>
  <tr>
    <td height="80%" align="center" valign="top" background="../image/home_39.gif">
	  <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif">
	<img src="../image/dot01.gif" width="8" height="8">
	<a href="../smm/chpwd.jsp" target="hmain">密码修改</a></td>
        </tr>
      </table>
	  <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif">
	<img src="../image/dot01.gif" width="8" height="8">
	<a href="#" onclick="showObj(0)">角色切换</a></td>
		</tr>
      </table>
      <div id="odiv" style="display:none">
	   <logic:present name="ACCOUNT_INFORMATION">
	   <logic:notEmpty name="ACCOUNT_INFORMATION" property="myRoles">
	   <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
		<tr>
	      <html:form method="post" action="/smm/roleSwitch" target="_top">
		  <td align="center">
			<html:select name="ACCOUNT_INFORMATION" property="account.roleID" onchange="javascript:this.form.submit()">
	          <html:optionsCollection name="ACCOUNT_INFORMATION" property="myRoles"/>
			</html:select>
		  </td>
	      </html:form>
        </tr>
       </table>
	   </logic:notEmpty>
       </logic:present>
      </div>
    <%
      if (funcPerms.contains("FUN08")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="143" align="center" background="../image/2_menu_bg.gif" >
	<img src="../image/dot01.gif" width="8" height="8">
	<a href="#" onclick="showObj(<%= odivIndex %>)">用户反馈</a></td>
        </tr>
      </table>
	  <div id="odiv" style="display:none">
      <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
        <% if (funcPerms.contains("FUN080001")) {%>
	<tr>
          <td><a href="/pub/feedback_info_input.jsp" target="hmain">新增用户反馈</a></td>
        </tr>
	<% } %>
        <% if (funcPerms.contains("FUN080002")) {%>
	<tr>
          <td><a href="/pub/queryFeedbackList.do?ACT=REP" target="hmain">回复用户反馈</a></td>
        </tr>
	<% } %>
      </table>
      </div>
      <%}%>
    <%
      if (funcPerms.contains("FUN07")) {
        odivIndex++;
    %>
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="143" align="center" background="../image/2_menu_bg.gif" >
	<img src="../image/dot01.gif" width="8" height="8">
	<a href="#" onclick="showObj(<%= odivIndex %>)">信息发布</a></td>
        </tr>
      </table>
	  <div id="odiv" style="display:none">
      <table width="145" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
        <% if (funcPerms.contains("FUN070001")) {%>
	<tr>
          <td><a href="/pub/publish_info_input.jsp" target="hmain">新增发布信息</a></td>
        </tr>
	<% } %>
        <% if (funcPerms.contains("FUN070002")) {%>
	<tr>
          <td><a href="/pub/queryPublishInfoList.do?ACT=EDT" target="hmain">维护发布信息</a></td>
        </tr>
	<% } %>
        <% if (funcPerms.contains("FUN070003")) {%>
	<tr>
          <td><a href="/pub/queryPublishInfoList.do?ACT=CFM" target="hmain">审核发布信息</a></td>
        </tr>
	<% } %>
      </table>
      </div>
      <%}%>
      <!--
      <table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><a href="#" class="menu-1">系统说明</a></td>
        </tr>
      </table>
      <table width="144" border="0" cellpadding="2" cellspacing="1" background="../image/2_menu_bg2.gif">
        <tr>
          <td width="17" height="264" align="center"><img src="../image/dot01.gif" width="8" height="8"></td>
          <td width="116"><p>本系统是........</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p></td>
        </tr>
      </table> -->
	 <input type="hidden" name="odiv">
    </td>
  </tr>
  <tr>
    <td valign="top"><img src="../image/home_48.gif" width="188" height="43"></td>
  </tr>
</table>
</body>
</html>
