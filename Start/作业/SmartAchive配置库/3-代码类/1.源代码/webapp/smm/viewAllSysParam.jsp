<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>
ϵͳ��������
</title>
</head>
<script language="JavaScript">
function gotoPage(pageIndex) {
  location = "?page=" + pageIndex;
}
</script>
<body>
<h1>ϵͳ���������б�:</h1>
<table border="1">
<tr>
<td><a href="../../jsp/sys/addSysParamType.jsp">���Ӳ�������</a></td>
<td>
<logic:notEqual name="allSysParamTypeList" property="firstPage" value="true" >
  <a href="?page=first">&lt;&lt; ��һҳ</a>
  <a href="?page=previous">&lt;&lt; ��һҳ</a>
</logic:notEqual>
</td>
<td>
<logic:notEqual name="allSysParamTypeList" property="lastPage" value="true" >
  <a href="?page=next">��һҳ &gt;&gt;</a>
  <a href="?page=last">���ҳ &gt;&gt;</a>
</logic:notEqual>
</td>
</tr>
<tr><td colspan="3">
����<bean:write name="allSysParamTypeList" property="rowAmount" />����¼&nbsp;
��Ϊ<bean:write name="allSysParamTypeList" property="pageAmount" />ҳ&nbsp;
ÿҳ<bean:write name="allSysParamTypeList" property="pageSize" />��&nbsp;
��ǰ��<input type="text" size="1" value="<bean:write name="allSysParamTypeList" property="pageIndex" />" onChange="javascript:gotoPage(this.value)" />ҳ
</td></tr>
<tr>
<td>���</td>
<td>������������</td>
<td>��ע</td>
</tr>
<logic:iterate id="sysParamType" name="allSysParamTypeList" >
<tr>
<td><a href="viewSysParamItemByType.do?typeid=<bean:write name="sysParamType" property="typeID" />"><bean:write name="sysParamType" property="typeID" /></a></td>
<td><bean:write name="sysParamType" property="typeName" /></td>
<td><bean:write name="sysParamType" property="remark" /></td>
</tr>
</logic:iterate>
<tr></tr>
</table>
</body>
</html>
