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
    <td colspan="10"><a href="../../jsp/sys/newAccount.jsp">���û�</a></td>
<tr> 
<tr>
<td>���</td>
<td>��¼��</td>
<td>����</td>
<td>����</td>
<td>EMail</td>
<td>��¼����</td>
<td>���һ�ε�¼ʱ��</td>
<td>����ʱ��</td>
<td>���һ���޸�ʱ��</td>
<td>��ע</td>
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
