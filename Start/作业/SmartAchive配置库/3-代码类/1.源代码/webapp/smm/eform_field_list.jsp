<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>���ӱ��ֶ��б�</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<script language="javascript" src="../common/js/chkBoxOperation.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
.style1 {font-size: 14px}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
<!--
//�鿴ѡ���ֶ�
function doGoto(field_id){
	window.location="viewFieldDefine.do?field_id=" + field_id;
}
//����
function doSubmit(form,act){
	var operName = document.all("operName");
	var eform_id=document.getElementById("eformDefine.eform_id");
	if(act=="DELETE"){
	//ɾ��
		if(validateCheckBox(form)){
			operName.value="DELETE";
			form.submit();
		}else{
                	alert("��ѡ���ֶΣ�");
		}
	}else if(act=="UPDATE"){
	//����
		SelectAll(form,'field_id')
		if(!validateCheckBox(form)){
                	alert("��ѡ���ֶΣ�");
			return false;
		}
		operName.value="UPDATE";
		form.submit();
	}else if(act=="ADD"){
	//����
		window.location="/smm/viewEformFieldListForSelect.do?eform_id="+eform_id.value;
	}
}
function doBack(form){
	var eform_id=document.getElementById("eformDefine.eform_id");
	window.location="/smm/viewEformDefine.do?eform_id="+eform_id.value;
}
//ɾ���ֶ�
function doDelete(field_id){
	window.location.href="deleteEformField.do?field_id=" + field_id;
}
function validateCheckBox(theform){
	var obj=document.getElementsByName("field_id");
	var isChecked = false;
	fileId = "";
	for(var i=0;i<obj.length;i++){
		if (obj[i].checked){
			isChecked=true;
			fileId += obj[i].value + ",";
		}
	}
	return isChecked;
}
-->
</script>
</head>
<body class="bg-page01">
<html:form action="/smm/updateEformFieldList" method="post" >
  <html:hidden property="eformDefine.eform_id"/>
  <html:hidden property="operName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="style1">��[<font color="red"><bean:write name="EformDefineForm" property="eformDefine.eform_name" /></font>]�ֶ��б�</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="4%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="24"></td>

    <td align="center" bgcolor="#FFFFFF">
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td bgcolor="#F7EED9"><input type="checkbox" onclick="if(this.checked)SelectAll(this.form,'field_id');else UnSelectAll(this.form,'field_id');">ѡ��</td>
          <td nowrap>�ֶ�˳��</td>
          <td nowrap>�ֶ���������</td>
          <td nowrap>�ֶ�Ӣ������</td>
          <td nowrap>�ֶ�����</td>
          <td nowrap>�ֶγ���</td>
          <td nowrap>�Ƿ�Ϊ��</td>
          <td nowrap>�Ƿ�ժҪ�ֶ�</td>
          <td nowrap>�Ƿ�ɱ༭</td>
          <td nowrap>�鿴�ֶ�</td>
        </tr>
	<logic:notPresent name="eformFieldList">
	<tr align="center" bgcolor="#F7EED9">
          <td colspan=10>���޼�¼</td>
        </tr>
	</logic:notPresent>
	<logic:present name="eformFieldList">
	<logic:iterate id="list" name="eformFieldList" >
        <tr align="center">
          <td><input type="checkbox" name="field_id" value="<bean:write name="list" property="field_id"/>"></td>
          <td><input type="text" name="field_seq" value="<bean:write name="list" property="field_seq"/>" size=4 maxlength=4></td>
          <td align="left"><bean:write name="list" property="field_cname" /></td>
          <td><bean:write name="list" property="field_ename" /></td>
          <td><bean:write name="list" property="field_type_id" /></td>
          <td><bean:write name="list" property="field_len" /></td>
          <td><bean:write name="list" property="field_isNull" /></td>
          <td><bean:write name="list" property="field_isBrief" /></td>
          <td><bean:write name="list" property="field_isEdit" /></td>
          <td><a href="javascript:doGoto('<bean:write name='list' property='field_id' />')">GO</a></td>
        </tr>
	</logic:iterate>
	</logic:present>
      </table>

      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" bgcolor="#F7EED9">
		<input type="button" name="Submit2" value="�����ֶ���Ϣ" onclick="doSubmit(this.form,'UPDATE');">
		<input type="button" name="Submit3" value="������ֶ�" onclick="doSubmit(this.form,'ADD');">
              	<input type="button" name="Submit1" value="ɾ����ѡ�ֶ�" onclick="doSubmit(this.form,'DELETE');">
		<input type="button" name="Submit9" value="��ӡ" onclick="window.print()">
              	<input type="reset" name="Submit9" value="����" onclick="doBack(this.form);">

          </td>
        </tr>
      </table>

      </td>
      <td background="../image/2_table_c_l.gif"><img src="../image/2_table_c_l.gif" width="26" height="138"></td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</html:form>
</body>
</html>
