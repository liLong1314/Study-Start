<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<html>
<head>
<title></title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script src="../common/js/validCheck.js">
//���������Ч�Ժ����Ĵ���
</script>
<script language="javascript">
function mysubmit()
{
	if(document.getElementById("account.userName").value=="")
	{
		alert("�������û��ʺţ�");
		document.getElementById("account.userName").focus();
		return false;
	}
	if(document.getElementById("account.userName").value.length<3)
	{
		alert("�û��ʺų��ȱ������3λ��");
		document.getElementById("account.userName").focus();
		return false;
	}
	if(document.getElementById("account.password").value=="")
	{
		alert("�������û����룡");
		document.getElementById("repeatedPassword").value="";
		document.getElementById("account.password").focus();
		return false;
	}
	if(document.getElementById("account.password").value.length<6)
	{
		alert("�û����볤�ȱ������6λ��");
		document.getElementById("account.password").value="";
		document.getElementById("repeatedPassword").value="";
		document.getElementById("account.password").focus();
		return false;
	}
	if(document.getElementById("account.password").value!=document.getElementById("repeatedPassword").value)
	{
		alert("������������벻һ�£����������룡");
		document.getElementById("account.password").value="";
		document.getElementById("repeatedPassword").value="";
		document.getElementById("account.password").focus();
		return false;
	}
	if(document.getElementById("account.name").value=="")
	{
		alert("�������û�������");
		document.getElementById("account.name").focus();
		return false;
	}
	document.accountForm.submit();
}
function displayinfo()
{
	if(document.getElementById("operResults").value!="")
	{
		alert(document.getElementById("operResults").value);
	}
}
function openWindow(newUrl) {

	var width = 600;
	var height = 480;
	var left = (screen.width - width)/2;
	var top = (screen.height - height)/2;
	style="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,left="+left+",top="+top+",width="+width+",height="+height;

	window.open(newUrl, "", style);
}
</script>
</head>
<body class="bg-page01" onload="javascript:displayinfo()">
<html:form action="/smm/newAccount.do" method="POST">
<html:hidden name="accountForm" property="operResults"/>
<html:hidden name="accountForm" property="validate" value="newAccount"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr nowrap>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr nowrap align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr nowrap>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">ע���û�</td>
                </tr>
              </table>
            </td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr nowrap>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
	<bean:write name="accountForm" property="operResults"/>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr nowrap bgcolor="#FFFFFF">
	    <td width="28%">�ʺ�</td>
	    <td colspan="3"><html:text size="12" name="accountForm" property="account.userName"/></td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
	    <td>����</td>
	    <td colspan="3"><html:password size="12" name="accountForm" property="account.password"/></td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
	    <td>ȷ������</td>
	    <td colspan="3"><html:password property="repeatedPassword"/></td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
	    <td>����</td>
	    <td colspan="3"><html:text size="12" name="accountForm" property="account.name"/></td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
	    <td>����</td>
	    <td colspan="3"><html:text size="12" name="accountForm" property="account.department"/></td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
	    <td>��֯</td>
	    <td colspan="3">
		  <html:text size="12" property="account.orgName" readonly="true"/>
		  <html:hidden property="account.orgID"/>
			<input type="button" name="button" value="..." title="ѡ��" onclick="javascript:openWindow('/smm/selectOrg.do?page=refresh')">
		</td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
	    <td>�����ʼ�</td>
	    <td colspan="3"><html:text size="12" name="accountForm" property="account.email"/></td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
	    <td>Ĭ�Ͻ�ɫ</td>
	    <td colspan="3">
		  <html:select name="accountForm" property="account.roleID">
            <html:optionsCollection name="accountForm" property="groups"/>
          </html:select>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
	    <td>��ע</td>
	    <td colspan="3"><html:textarea name="accountForm" property="account.remark"/></td>
          </tr>
          <tr nowrap bgcolor="#FFFFFF">
            <td colspan="4">
		<center>
		<input type="button" name="button" value="ȷ��" onclick="mysubmit()">
		<input type="button" name="button" value="����" onclick="window.location='/smm/queryAccount.do'">
		</center>
            </td>
          </tr>
        </table></td>
      <td background="../image/2_table_c_l.gif"><img src="../image/2_table_c_l.gif" width="26" height="138"></td>
    </tr>
    <tr nowrap>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif">&nbsp;</td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</html:form>
</body>
</html>
