<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>
添加参数类型
</title>
</head>
<body>
<p>
<html:form action="/sys/addSysParamType.do" method="POST">
类型编号<html:text name="sysParamTypeForm" property="sysParamType.typeID"/><br>
类型名称<html:text name="sysParamTypeForm" property="sysParamType.typeName"/><br>
备注<html:text name="sysParamTypeForm" property="sysParamType.remark"/><br>
<html:submit property="submit" value="Submit"/><html:reset value ="Reset"/>
</html:form>
</body>
</html>
