<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>
Accounts list
</title>
</head>
<body>
<h1>Accounts List:</h1>
<table>
<tr>
    <td colspan="10"><a href="../../jsp/sys/newAccount.jsp">新用户</a></td>
<tr> 
<tr>
<td>编号</td>
<td>登录名</td>
<td>姓名</td>
<td>部门</td>
<td>EMail</td>
<td>登录次数</td>
<td>最后一次登录时间</td>
<td>创建时间</td>
<td>最后一次修改时间</td>
<td>备注</td>
</tr>
<logic:iterate id="account" name="allAccountList" >
<tr>
<td><bean:write name="account" property="userID" /></td>
<td><bean:write name="account" property="userName" /></td>
<td><bean:write name="account" property="name" /></td>
<td><bean:write name="account" property="department" /></td>
<td><bean:write name="account" property="email" /></td>
<td><bean:write name="account" property="accessTimes" /></td>
<td><bean:write name="account" property="lastAccessDate" /></td>
<td><bean:write name="account" property="creationDate" /></td>
<td><bean:write name="account" property="lastModifiedDate" /></td>
<td><bean:write name="account" property="remark" /></td>
</tr>
</logic:iterate>
</table>
</body>
</html>
