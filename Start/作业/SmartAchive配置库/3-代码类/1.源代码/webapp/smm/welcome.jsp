<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<html:html>
<head>
<title>���������ϵ�����</title>
</head>
<body>
<h3>��ӭ���������������ϵ�����</h3>
<table border="0">
  <tr>
    <td><bean:write name="accountForm" property="account.userName"/></td>
  </tr>
</table>
</body>
</html:html>
