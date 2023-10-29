<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<html>
<head>
<title></title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script src="../common/js/validCheck.js">
//检查数据有效性函数的代码
</script>
<script language="javascript">
function mysubmit()
{
	if(document.getElementById("account.password").value=="")
	{
		alert("请输入旧密码！");
		document.getElementById("account.password").focus();
		return false;
	}
	if(document.getElementById("newPassword").value=="")
	{
		alert("请输入新密码！");
		document.getElementById("newPassword").focus();
		return false;
	}
	if(document.getElementById("newPassword").value.length<6)
	{
		alert("密码长度不能小于6位！");
		document.getElementById("newPassword").focus();
		return false;
	}
	if(document.getElementById("newPassword").value!=document.getElementById("repeatedPassword").value)
	{
		alert("两次输入的密码不一致，请重新输入！");
		document.getElementById("repeatedPassword").value="";
		document.getElementById("repeatedPassword").focus();
		return false;
	}
	document.accountForm.submit();
}
function displayinfo()
{
	if(document.getElementById("operResults").value!="")
	{
		alert(document.getElementById("operResults").value);
	}
}
</script>
</head>
<body class="bg-page01" onload="javascript:displayinfo()">
<html:form action="/smm/chpasswd.do" method="POST">
<html:hidden name="accountForm" property="operResults"/>
<html:hidden name="accountForm" property="validate" value="changePassword"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr nowrap>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr nowrap align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr nowrap>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">修改密码</td>
                </tr>
              </table>
            </td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr nowrap>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
	    <bean:write name="accountForm" property="operResults"/>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr nowrap bgcolor="#FFFFFF">
            <td width="20%">旧密码</td>
            <td width="80%"><html:password size="12" name="accountForm" property="account.password"/></td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
	        <td>新密码</td>
	        <td><html:password size="12" property="newPassword"/></td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
	        <td>确认新密码</td>
	        <td><html:password size="12" property="repeatedPassword"/></td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
            <td align="center"><a href="#" onclick="javascript:mysubmit()">确定</a></td>
            <td><a href="/public/main_index.htm">取消</a></td>
          </tr>
        </table></td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr nowrap>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif">&nbsp;</td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</html:form>
</body>
</html>
