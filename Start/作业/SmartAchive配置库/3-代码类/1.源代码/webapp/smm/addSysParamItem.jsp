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
<html:form action="/sys/addSysParamItem.do" method="POST">
<input type="hidden" name="sysParamItem.typeID" value="<%= request.getParameter("typeid") %>"/>
条目编号<html:text name="sysParamItemForm" property="sysParamItem.itemID"/><br>
条目名称<html:text name="sysParamItemForm" property="sysParamItem.itemName"/><br>
备注<html:text name="sysParamItemForm" property="sysParamItem.remark"/><br>
<html:submit property="submit" value="新建"/><html:reset value ="复位"/>
</html:form>
</body>
</html>
