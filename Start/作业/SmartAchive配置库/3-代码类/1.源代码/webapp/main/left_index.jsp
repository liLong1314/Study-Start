<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript">
<!--
function doSubmit(form){
	if(!validateForm(form)){
		alert("请输入正确的帐号/密码.");
		return false;
	}
	var obj = form.fullScreen;
	if (obj.checked){
		window.open("about:blank","fullScreeWindow","channelMode=yes");
		form.target="fullScreeWindow";
	}else{
		form.target="_top";
	}
	//top.window.location="/main/main_index.htm";
	return true;
}
function validateForm(form){
	var user = document.all("account.userName");
	var pass = document.all("account.password");
	if(user.value==""){
		user.focus();
		return false;
	}
	if(pass.value==""){
		pass.focus();
		return false;
	}
	return true;
}
function MM_goToURL() { //v3.0
  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
  return true;
}
//-->
</script>
</head>
<body background="../image/2_mainpagebg_01.gif" leftmargin="0" topmargin="0">
<table width="90%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="21" valign="top" background="../image/bg_color03.gif"><br>
      <img src="../image/home_38.gif" width="188" height="12"></td>
  </tr>
  <tr>
    <td height="80%" align="center" valign="top" background="../image/home_39.gif"><table width="145" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="../image/2_menu_bg.gif" ><a href="#" class="menu-1">系统登陆</a></td>
        </tr>
      </table>
      <table width="90%" height="200" border="0">
        <tr>
          <td valign="top">
	        <html:form action="/smm/login.do" method="POST" onsubmit="return doSubmit(this);">
	        <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr align="center">
                <td nowrap height="30">用户：</td>
                <td align="left"><html:text name="accountForm" property="account.userName" size="12"/></td>
              </tr>
              <tr align="center">
                <td nowrap height="30">密码：</td>
                <td align="left"><html:password name="accountForm" property="account.password" size="12"/></td>
              </tr>
              <tr align="center" style="display:none">
                <td nowrap height="30">全屏：</td>
                <td align="left"><input type="checkbox" name="fullScreen" value="1"></td>
              </tr>
              <tr align="center">
                <td height="30">&nbsp;</td>
                <td><input type="image" src="../image/2_buttom06.gif" width="59" height="19" border="0" ></td>
              </tr>
            </table>
			</html:form>
		  </td>
        </tr>
      </table> </td>
  </tr>
  <tr>
    <td valign="top"><img src="../image/home_48.gif" width="188" height="43"></td>
  </tr>
</table>
</body>
</html>
