<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>
��Ӳ�������
</title>
</head>
<body>
<p>
<html:form action="/sys/addSysParamType.do" method="POST">
���ͱ��<html:text name="sysParamTypeForm" property="sysParamType.typeID"/><br>
��������<html:text name="sysParamTypeForm" property="sysParamType.typeName"/><br>
��ע<html:text name="sysParamTypeForm" property="sysParamType.remark"/><br>
<html:submit property="submit" value="Submit"/><html:reset value ="Reset"/>
</html:form>
</body>
</html>
