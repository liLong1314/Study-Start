<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>
系统参数条目
</title>
</head>
<body>
<h1>系统参数列表:</h1>
<table border="0">
<tr><td colspan="3"><a href="../../jsp/sys/addSysParamItem.jsp?typeid=<%= request.getParameter("typeid") %>">增加条目</a></td></tr>
<tr>
<td>编号</td>
<td>参数名称</td>
<td>备注</td>
</tr>
<logic:iterate id="sysParamItem" name="SysParamItemList" >
<tr>
<td><bean:write name="sysParamItem" property="itemID" /></td>
<td><bean:write name="sysParamItem" property="itemName" /></td>
<td><bean:write name="sysParamItem" property="remark" /></td>
</tr>
</logic:iterate>
<tr><td><input type="button" name="back" value="后退" onclick="javascript:history.back();"></td></tr>
</table>
</body>
</html>
