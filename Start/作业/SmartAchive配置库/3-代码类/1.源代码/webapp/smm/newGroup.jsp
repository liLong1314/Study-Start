<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<html:html>
<head>
<title></title>
<link href="../../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script src="../common/js/validCheck.js">
//���������Ч�Ժ����Ĵ���
</script>
<script language="javascript">
function mysubmit()
{
	if(document.getElementById("group.groupName").value=="")
	{
		alert("�������û������ƣ�");
		document.getElementById("group.groupName").focus();
		return false;
	}
	document.groupForm.submit();
}
</script>
</head>
<body class="bg-page01">
<html:form action="/smm/newGroup.do" method="POST">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>

                <td align="center" bgcolor="#E4F7FA" class="tishi">�½��û���</td>
                </tr>
              </table>
            </td>
          </tr>
        </table></td>
      <td width="4%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
      <bean:write name="groupForm" property="operResults"/> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
        <tr bgcolor="#FFFFFF">
          <td width="28%">�û�������</td>
          <td colspan="3"><html:text size="20" name="groupForm" property="group.groupName"/></td>
        </tr>
        <tr bgcolor="#FFFFFF">
          <td>�û���������Ϣ</td>
          <td colspan="3"><html:text size="50" name="groupForm" property="group.description"/></td>
        </tr>
        <tr bgcolor="#FFFFFF">
          <td>&nbsp;</td>
          <td width="23%"><a href="#" onClick="javascript:mysubmit()">ȷ��</a></td>
          <td width="16%"><a href="/smm/queryGroup.do">����</a></td>
          <td width="33%">&nbsp;</td>
        </tr>
      </table></td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>

</html:form>
</body>
</html:html>
