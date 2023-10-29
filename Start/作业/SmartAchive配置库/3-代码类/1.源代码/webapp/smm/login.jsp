<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<html:html>
<head>
<title>用户登录</title>
</head>
<body>
<h3>请输入用户名和密码</h3>
<html:form action="/sys/login.do" method="POST">
<table border="0">
  <tr>
    <td>登录名</td>
    <td><html:text name="accountForm" property="account.userName"/></td>
  </tr>
  <tr>
    <td>密码</td>
    <td><html:password name="accountForm" property="account.password"/></td>
  </tr>
  <tr>
    <td colspan="2"><html:submit property="submit" value="登录"/>&nbsp;<html:reset value ="复位"/></td>
  </tr>
</table>
</html:form>
</body>
</html:html>
