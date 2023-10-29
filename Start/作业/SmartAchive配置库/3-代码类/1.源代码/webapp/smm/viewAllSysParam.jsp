<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>
系统参数类型
</title>
</head>
<script language="JavaScript">
function gotoPage(pageIndex) {
  location = "?page=" + pageIndex;
}
</script>
<body>
<h1>系统参数类型列表:</h1>
<table border="1">
<tr>
<td><a href="../../jsp/sys/addSysParamType.jsp">增加参数类型</a></td>
<td>
<logic:notEqual name="allSysParamTypeList" property="firstPage" value="true" >
  <a href="?page=first">&lt;&lt; 第一页</a>
  <a href="?page=previous">&lt;&lt; 上一页</a>
</logic:notEqual>
</td>
<td>
<logic:notEqual name="allSysParamTypeList" property="lastPage" value="true" >
  <a href="?page=next">下一页 &gt;&gt;</a>
  <a href="?page=last">最后页 &gt;&gt;</a>
</logic:notEqual>
</td>
</tr>
<tr><td colspan="3">
共有<bean:write name="allSysParamTypeList" property="rowAmount" />条记录&nbsp;
分为<bean:write name="allSysParamTypeList" property="pageAmount" />页&nbsp;
每页<bean:write name="allSysParamTypeList" property="pageSize" />条&nbsp;
当前第<input type="text" size="1" value="<bean:write name="allSysParamTypeList" property="pageIndex" />" onChange="javascript:gotoPage(this.value)" />页
</td></tr>
<tr>
<td>编号</td>
<td>参数类型名称</td>
<td>备注</td>
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
