<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>
ϵͳ������Ŀ
</title>
</head>
<body>
<h1>ϵͳ�����б�:</h1>
<table border="0">
<tr><td colspan="3"><a href="../../jsp/sys/addSysParamItem.jsp?typeid=<%= request.getParameter("typeid") %>">������Ŀ</a></td></tr>
<tr>
<td>���</td>
<td>��������</td>
<td>��ע</td>
</tr>
<logic:iterate id="sysParamItem" name="SysParamItemList" >
<tr>
<td><bean:write name="sysParamItem" property="itemID" /></td>
<td><bean:write name="sysParamItem" property="itemName" /></td>
<td><bean:write name="sysParamItem" property="remark" /></td>
</tr>
</logic:iterate>
<tr><td><input type="button" name="back" value="����" onclick="javascript:history.back();"></td></tr>
</table>
</body>
</html>
