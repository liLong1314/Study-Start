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
<html:form action="/sys/addSysParamItem.do" method="POST">
<input type="hidden" name="sysParamItem.typeID" value="<%= request.getParameter("typeid") %>"/>
��Ŀ���<html:text name="sysParamItemForm" property="sysParamItem.itemID"/><br>
��Ŀ����<html:text name="sysParamItemForm" property="sysParamItem.itemName"/><br>
��ע<html:text name="sysParamItemForm" property="sysParamItem.remark"/><br>
<html:submit property="submit" value="�½�"/><html:reset value ="��λ"/>
</html:form>
</body>
</html>
