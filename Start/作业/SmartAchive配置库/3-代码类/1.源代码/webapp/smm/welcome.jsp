<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<html:html>
<head>
<title>杭州市网上档案馆</title>
</head>
<body>
<h3>欢迎您来到杭州市网上档案馆</h3>
<table border="0">
  <tr>
    <td><bean:write name="accountForm" property="account.userName"/></td>
  </tr>
</table>
</body>
</html:html>
