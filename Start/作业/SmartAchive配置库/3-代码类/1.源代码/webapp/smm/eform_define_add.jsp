<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>���ӱ��޶�</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script>
	//���ύ
	function doSubmit(theform){
		var operName = document.getElementById("operName");
		if(validateForm(theform)){
			operName.value="SUBMIT_ACTION";
			theform.submit();
		}
	}
	//��֤��
	function validateForm(theform){
		var eform_name = document.getElementById("eformDefine.eform_name");
		var eform_version = document.getElementById("eformDefine.eform_version");
		var eform_begin_date = document.getElementById("eformDefine.eform_begin_date");
		var eform_end_date = document.getElementById("eformDefine.eform_end_date");

		if(BASEtrim(eform_name.value)=="")
			return BASEalert("��������ȷ��[������]��",eform_name);
		if(BASEisNotNum(eform_version.value))
			return BASEalert("��������ȷ��[���汾]��",eform_version);
		if(BASEtrim(eform_begin_date.value)=="" || BASEisNotDate(eform_begin_date.value))
			return BASEalert("��������ȷ��[��Ч��ʼ����]��",eform_begin_date);
		if(BASEtrim(eform_end_date.value)!="" && BASEisNotDate(eform_end_date.value))
			return BASEalert("��������ȷ��[��Ч��������]��",eform_end_date);
		return true;
	}
</script>
</head>
<body class="bg-page01">
<html:form action="/smm/addEformDefine" method="post">
  <html:hidden property="operName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="28" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="6" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="454" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã� &gt;&gt; ϵͳ���� &gt;&gt; ���ӱ�����</td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td colspan="3" background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">���ӱ��޶�</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
	  <logic:notEmpty name="EformDefineForm" property="msgError">
          <tr bgcolor="#FFFFFF">
		<td colspan="4">
		<b><font color=red>�ܱ�Ǹ�������з������󣡵��<a href="#" style="color:blue" onclick="var obj=document.all('err');if(obj.style.display=='none') {obj.style.display='block'} else{obj.style.display='none'}">�˴�</a>�鿴��ϸ��Ϣ</font></b>
		<span id=err style="display:none"><bean:write name="EformDefineForm" property="msgError"/></span>
		</td>
          </tr>
          </logic:notEmpty>
          <tr bgcolor="#FFFFFF">
            <td width="25%" nowrap>������<font color=red>*</font></td>
            <td colspan="3" nowrap><html:text property="eformDefine.eform_name" size="40" maxlength="50"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td width="25%" nowrap>���汾<font color=red>*</font></td>
            <td colspan="3" nowrap><html:text property="eformDefine.eform_version" size="4" maxlength="4"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td width="25%" nowrap>��Ч��ʼ����<font color=red>*</font></td>
            <td colspan="3" nowrap><html:text property="eformDefine.eform_begin_date" size="10" maxlength="10"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td width="25%" nowrap>��Ч��������</td>
            <td colspan="3" nowrap><html:text property="eformDefine.eform_end_date" size="10" maxlength="10"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>������Ŀ</td>
            <td colspan="3">
		<html:select property="eformDefine.entry_id">
		<option value="">--�滮������--</option>
		<html:optionsCollection property="entry_idOptions"/>
		</html:select>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>��ע</td>
            <td colspan="3"><html:textarea property="eformDefine.remark" cols="60" rows="4"/></td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td colspan="4">
		<input type="button" name="Submit1" value="ȷ��" onclick="doSubmit(this.form);">
              	<input type="reset" name="Submit3" value="����" onclick="window.location.href='/smm/queryEformDefineList.do';">
            </td>
          </tr>
        </table>
        <br>
      </td>
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
</html>

