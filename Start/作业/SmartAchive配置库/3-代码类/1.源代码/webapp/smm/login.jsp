<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<html:html>
<head>
<title>�û���¼</title>
</head>
<body>
<h3>�������û���������</h3>
<html:form action="/sys/login.do" method="POST">
<table border="0">
  <tr>
    <td>��¼��</td>
    <td><html:text name="accountForm" property="account.userName"/></td>
  </tr>
  <tr>
    <td>����</td>
    <td><html:password name="accountForm" property="account.password"/></td>
  </tr>
  <tr>
    <td colspan="2"><html:submit property="submit" value="��¼"/>&nbsp;<html:reset value ="��λ"/></td>
  </tr>
</table>
</html:form>
</body>
</html:html>
