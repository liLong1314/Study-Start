<%@ page contentType="text/html; charset=GBK" %>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>�����շѱ�׼</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
</head>
<script src="/common/js/validCheck.js">
//��ѡ���������
</script>
<script language="javascript"> 
<!--

function CheckValid(){
	if (isEmpty(document.forms[0].elements("chargeStandard.sentryid"))){
		alert("�Բ��������롰�շ���Ŀ��");
		document.forms[0].elements("chargeStandard.sentryid").focus();
		return false;
	}
	if (isEmpty(document.forms[0].elements("chargeStandard.charge_mode"))){
		alert("�Բ��������롰�շѷ�ʽ��");
		document.forms[0].elements("chargeStandard.charge_mode").focus();
		return false;
	}
	
	//�շѱ�׼�汾
	if (isEmpty(document.forms[0].elements("chargeStandard.charge_version"))){
		alert("�Բ��������롰�շѱ�׼�汾��");
		document.forms[0].elements("chargeStandard.charge_version").focus();
		return false;
	}
	if (!isMoney(document.forms[0].elements("chargeStandard.charge_version"))){
		alert("��������ȷ���շѱ�׼�汾��ֻ��Ϊ���֣���");
		document.forms[0].elements("chargeStandard.charge_version").focus();
		return false;
	}

	//�ж�ִ�п�ʼ����
	if (isEmpty(document.forms[0].elements("chargeStandard.charge_begin_date"))){
		alert("�Բ��������롰ִ�п�ʼ���ڡ�");
		document.forms[0].elements("chargeStandard.charge_begin_date").focus();
		return false;
	}
	if (!IsDateString(document.forms[0].elements("chargeStandard.charge_begin_date").value)){
		alert("��������ȷ�ġ�ִ�п�ʼ���ڡ�");
		document.forms[0].elements("chargeStandard.charge_begin_date").focus();
		return false;
	}
	
	//�ж�ִ�н�������
	if (isEmpty(document.forms[0].elements("chargeStandard.charge_end_date"))){
		alert("�Բ��������롰ִ�н������ڡ�");
		document.forms[0].elements("chargeStandard.charge_end_date").focus();
		return false;
	}
	if (!IsDateString(document.forms[0].elements("chargeStandard.charge_end_date").value)){
		alert("��������ȷ�ġ�ִ�н������ڡ�");
		document.forms[0].elements("chargeStandard.charge_end_date").focus();
		return false;
	}

	//�ж��շѽ��
	if (isEmpty(document.forms[0].elements("chargeStandard.charge_money"))){
		alert("�Բ��������롰�շѽ�");
		document.forms[0].elements("chargeStandard.charge_money").focus();
		return false;
	}
	if (!isMoney(document.forms[0].elements("chargeStandard.charge_money"))){
		alert("�������ȷ���շѽ��");
		document.forms[0].elements("chargeStandard.charge_money").focus();
		return false;
	}

	return true;
}

function mySubmit() {	
	if (!CheckValid())
		return false;	
	document.all.functionName.value = "insert";
	document.ChargeStandardForm.submit();
}
-->
</script>

<body class="bg-page01">
<html:form action="/aum/ChargeStandard" method="post" >
<html:hidden property="functionName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="39"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="50" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="620" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã� �շѱ�׼���� &gt;&gt; �����շѱ�׼ &gt;&gt;  </td>
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
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">�����շѱ�׼������Ϣ</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br>
          <table width="100%" height="37" border="1">
            <tr>
              <td height="31">
                <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                  <tr bgcolor="#FFFFFF">
                    <td width="100" nowrap>�շ���Ŀ</td>
                    <td width="30%" >
						<bean:define id="bb" name="ChargeStandardForm" property="list_sentry"/>
						<html:select property="chargeStandard.sentryid" size="1" style="width:100%"> 
							<html:options collection="bb" property="entryId" labelProperty="entryName"/> 
						</html:select>
					</td>
                    <td width="100" nowrap>�շѷ�ʽ</td>
                    <td width="30%" >
                    	<!-- <html:text property="chargeStandard.charge_mode" style="width:100%" /> -->
						<bean:define id="cc" name="ChargeStandardForm" property="list_charge_mode"/>
						<html:select property="chargeStandard.charge_mode" size="1" style="width:100%"> 
							<html:options collection="cc" property="value" labelProperty="label"/> 
						</html:select>
                    </td>
                    <td width="90" nowrap>�շѱ�׼�汾</td>
                    <td width="30%" ><html:text property="chargeStandard.charge_version" style="width:100%" maxlength="4"/></td>
                  </tr>
                  <tr bgcolor="#FFFFFF">
                    <td width="100">ִ�п�ʼ����(��:2003-12-31)</td>
                    <td ><html:text property="chargeStandard.charge_begin_date" style="width:100%" maxlength="10"/></td>
                    <td width="100">ִ�н�������(��:2003-12-31)</td>
                    <td ><html:text property="chargeStandard.charge_end_date" style="width:100%" maxlength="10"/></td>
                    <td nowrap>�շѱ�׼���</td>
                    <td ><html:text property="chargeStandard.charge_money" style="width:100%" maxlength="10"/></td>
                  </tr>
                  <tr bgcolor="#FFFFFF">
                    <td nowrap>�շ�����</td>
                    <td nowrap><html:text property="chargeStandard.charge_base" style="width:100%" maxlength="10"/></td>
                    <td nowrap>��ע</td>
                    <td nowrap><html:text property="chargeStandard.remark" style="width:100%" maxlength="10"/></td>
                    <td nowrap>&nbsp;</td>
                    <td nowrap>&nbsp;</td>
                  </tr>
                  <tr bgcolor="#FFFFFF">
					<table align="center" ><tr align="center" >
                    <td align="center" >
                    	<input type="button" name="btn91" value="ȷ��" onClick="mySubmit();">
                    	<input type="button" name="btn92" value="ȡ��" onClick="window.location='../aum/ChargeStandard.do'">
                    </td>
                    </tr></table>
                  </tr>
              </table></td>
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
</html>
