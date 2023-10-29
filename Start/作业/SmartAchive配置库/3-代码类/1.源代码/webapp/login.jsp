<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<html>
<head>
<title>杭州市网上档案馆 | 欢迎登录</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,fullscreen=1,menubar=0,toolbar=0,directories=0,location=0,status=0,scrollbars=0);
}
//-->
</script>
</head>
<body leftmargin="0" topmargin="0">
<p>&nbsp;</p><table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center"><table width="768" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><img src="image/dang_login01.gif" width="768" height="39"></td>
        </tr>
      </table></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center"><table width="768" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><img src="image/dang_login02.gif" width="768" height="158"></td>
        </tr>
      </table></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center"><table width="768" height="123" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" background="image/dang_login03.gif">
		         <table width="341" border="0" cellspacing="0" cellpadding="4">
              <html:form action="/sys/login.do" method="POST">
                <tr>
                  <td width="128" height="24" align="right">用户名：</td>
                  <td width="113" align="center"><html:text value="admin" name="accountForm" property="account.userName" size="12"/></td>
                  <td width="76">&nbsp;</td>
                </tr>
                <tr>
                  <td align="right">登录密码：</td>
                  <td align="center"><html:password value="password" name="accountForm" property="account.password" size="12"/></td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td align="right">&nbsp;</td>
                  <td align="center">&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td align="center">&nbsp;</td>
                  <td align="center"><input type="image" src="image/button_home_39.gif" width="59" height="22" border="0"></td>
                  <td>&nbsp;</td>
                </tr>
              </html:form>
            </table>
					</td>
        </tr>
      </table></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center"><table width="768" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><img src="image/dang_login04.gif" width="768" height="100"></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
