<%@ page contentType="text/html; charset=gbk" %>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html >
<head>
<title>�޸�ҳ��</title>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
</head>
<link href="../../common/css/sunhoo.css" rel="stylesheet" type="text/css">

<script src="/common/js/validCheck.js">
//���������Ч�Ժ����Ĵ���
</script>
<script src="/common/js/radioOperation.js">
//��radio�����Ĵ���
</script>

<script language="JavaScript" type="text/JavaScript">
<!--

//���ù�������

function setFunctionName(functionName){
	document.CheckArchivesPageViewForm.functionName.value=functionName;
}

//���������Ӵ��ڵĵݽ�
function mySubmit() {

	if(window.opener) {
		window.opener.document.CheckArchivesPageViewForm.functionName.value = "UpdatePageSize";
		window.opener.document.CheckArchivesPageViewForm.functionData.value = document.all.functionData.value;
		window.opener.document.CheckArchivesPageViewForm.submit();
		
		self.close();
	}
}
-->
</script>
<body class="bg-page01">
<html:form action="/adc/CheckArchivesPageView" method="post"> 
<html:hidden property="archives.AARCHIVES_ID"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="4%"><img src="../../image/2_table_l_t.gif" width="32" height="22"></td>
    <td width="94%" height="10" background="../../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
        <tr align="center"> 
          <td width="25" align="right" background="../../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
          <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
              <tr> 
                <td align="center" bgcolor="#E4F2FA" class="tishi">�޸�ҳ��</td>
              </tr>
            </table></td>
        </tr>
      </table></td>
    <td width="2%"><img src="../../image/2_table_r_t.gif" width="26" height="22"></td>
  </tr>
  <tr> 
    <td background="../../image/2_table_c_r.gif">&nbsp;</td>
    <td align="center" valign="middle" bgcolor="#FFFFFF"><br>
      <table align="center">
        <tr> 
          <td> 
          	<bean:define id="aa" name="CheckArchivesPageViewForm" property="list_pageSize"/> 
            <html:select property="functionData" size="1" style="width:300" onkeypress="if(event.keyCode==13) {event.returnValue=false; mySubmit(); }"> 
            <html:options collection="aa" property="value" labelProperty="label"/> 
            </html:select>
          </td>
        </tr>
        <tr> 
          <td>
          	<input type="button" name="Submit" value="ȷ��" onclick="mySubmit();"> 
          	<input type="button" name="Submit" value="ȡ��" onclick="self.close()"> 
          </td>
        </tr>
      </table>
      <br></td>
    <td background="../../image/2_table_c_l.gif">&nbsp;</td>
  </tr>
  <tr> 
    <td><img src="../../image/2_table_r_b.gif" width="32" height="20"></td>
    <td height="10" background="../../image/2_table_c_b.gif"><img src="../../image/2_table_c_b.gif" width="115" height="20"></td>
    <td><img src="../../image/2_table_l_b.gif" width="26" height="20"></td>
  </tr>
</table>
</html:form> 
</body>
</html>