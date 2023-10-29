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
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_goToURL() { //v3.0
  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}
//-->
</script>
<style type="text/css">
<!--
.style1 {color: #006600}
-->
</style>
</head>

<body leftmargin="0" topmargin="0">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>

    <td width="61%" align="left" valign="top" background="../image/home_3.gif" ><img src="../image/home_2.gif"></td>
    <td width="39%" background="../image/home_3.gif"><table width="248" height="22" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="248" class="ninghao">系统当前登录用户：<logic:present name="ACCOUNT_INFORMATION"> <bean:write name="ACCOUNT_INFORMATION" property="account.userName"/> </logic:present> </td>
      </tr>
    </table></td>
  </tr>
</table><table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="37%" ><img src="../image/home_2_02.gif" width="381" height="27"></td>
    <td width="379" align="center" background="../image/home_10.gif" class="bg-left"><marquee direction=left width=300 id=cool scrollamount=1 scrolldelay=80 height=20 onMouseOver=cool.stop() onMouseOut=cool.start()>
    信雅达软件祝您工作愉快！</marquee>
    </td>
    <td width="26%" align="right" background="../image/home_21.gif"><img src="../image/home_21.gif" width="35" height="27"></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="234" ><img src="../image/home_5.gif" width="234" height="35"> </td>
    <td height="30" background="../image/home_9_02.gif">
	  <table border="0" cellspacing="0" cellpadding="4">
        <tr>
		<%
		 if(funcPerms != null) {
		  if (funcPerms.contains("FUN01")) {
	    %>
          <td><a href="#" target="left" onClick="MM_goToURL('parent.frames[\'left\']','../rcv/menu.jsp');MM_goToURL('parent.frames[\'hmain\']','../rcv/content.htm');return document.MM_returnValue"><img src="../image/3_buttom01.gif" border="0"></a></td>
		<%
          }
          if (funcPerms.contains("FUN02")) {        
        %>
          <td><a href="#"><img src="../image/3_buttom02.gif" border="0" onClick="MM_goToURL('parent.frames[\'left\']','../adc/menu.jsp');MM_goToURL('parent.frames[\'hmain\']','../adc/content.htm');return document.MM_returnValue"></a></td>
		<%
          }
          if (funcPerms.contains("FUN03")) {        
        %>
          <td><a href="#"><img src="../image/3_buttom03.gif" border="0" onClick="MM_goToURL('parent.frames[\'left\']','../arm/leftmenu.jsp');MM_goToURL('parent.frames[\'hmain\']','../arm/rightmain.htm');return document.MM_returnValue"></a></td>
		<%
          }
          if (funcPerms.contains("FUN04")) {        
        %>
          <td><a href="#"><img src="../image/3_buttom04.gif" border="0" onClick="MM_goToURL('parent.frames[\'left\']','../aum/view_left_menu.jsp');MM_goToURL('parent.frames[\'hmain\']','../aum/l_right.htm');return document.MM_returnValue"></a></td>
		<%
          }
          if (funcPerms.contains("FUN05")) {        
        %>
          <td><a href="#"><img src="../image/3_buttom05.gif" border="0"></a></td>
		<%
          }
          if (funcPerms.contains("FUN06")) {        
        %>
          <td><a href="#"><img src="../image/3_buttom06.gif" border="0" onClick="MM_goToURL('parent.frames[\'left\']','../smm/leftmenu.jsp');MM_goToURL('parent.frames[\'hmain\']','../smm/rightmain.htm');return document.MM_returnValue"></a></td>
		<% 
		  }
		 } 
		%>
        </tr>
      </table>	</td>
  </tr>
</table>

<logic:notPresent name="ACCOUNT_INFORMATION">
<script language="JavaScript">
alert("超时或者尚未登录，请重新登录");
if (top.location == self.location && opener) {
  opener.location.replace("/login.htm");
  self.close();
}
else {
  top.location.replace("/login.htm");
}
</script>
</logic:notPresent>

</body>
</html>
