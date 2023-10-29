<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����¼</title>
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
	//���
	function doCheck(theform){
		var operName = document.getElementById("operName");
		if(validateCheck()){
			operName.value="CHECK_ACTION";
			theform.submit();
		}
	}
	//���ύ
	function doSubmit(theform){
		var operName = document.getElementById("operName");
		if(validateCheck() && validateForm(theform)){
			operName.value="SUBMIT_ACTION";
			theform.submit();
		}
	}
	//��鵵������ĺϷ���
	function validateCheck(){
		var APIECE_NUM = document.getElementById("archives.APIECE_NUM");
		var AARCHIVES_NUM = document.getElementById("archives.AARCHIVES_NUM");
		var a = BASEtrim(APIECE_NUM.value);
		var b = BASEtrim(AARCHIVES_NUM.value);
		//alert(b.substring(b.lastIndexOf("-")+1,b.length));
		if(a==""){
			return BASEalert("������[�ұ����]",APIECE_NUM);
		}if(b==""){
			return BASEalert("������[����]",AARCHIVES_NUM);
		}if(a!=b.substring(b.lastIndexOf("-")+1,b.length)){
			return BASEalert("[����]��˳��ű�����[�ұ����]һ��",AARCHIVES_NUM);
		}
		return true;
	}
	//��������ĺϷ���
	function validateForm(theform){
		var AARCHIVES_YEAR = document.getElementById("archives.AARCHIVES_YEAR");
		var AARCHIVES_NAME = document.getElementById("archives.AARCHIVES_NAME");
		if(BASEtrim(AARCHIVES_NAME.value)=="")
			return BASEalert("��������ȷ��[�ļ�����]��",AARCHIVES_NAME);
		if(BASEtrim(AARCHIVES_YEAR.value)=="" || BASEisNotNum(AARCHIVES_YEAR.value) || (AARCHIVES_YEAR.value.length!=4)){
			return BASEalert("��������ȷ��[���]��",AARCHIVES_YEAR);
		}
		return true;
	}
</script>
</head>
<body class="bg-page01">
<html:form action="/adc/updatePieceArchives.do" method="post">
  <html:hidden property="archives.AENTRY_ID"/>
  <html:hidden property="archives.AIS_OPERATION"/>
  <html:hidden property="archives.AROLL_MODE"/>
  <html:hidden property="archives.AARCHIVES_STATUS"/>
  <html:hidden property="archives.AENTRY_ID"/>
  <html:hidden property="archives.AARCHIVES_ID"/>
  <html:hidden property="operName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="33"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="35"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="84" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="7" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="818" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã� &gt;&gt; �����ɼ� &gt;&gt;
        ���޶�</td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">����¼��Ϣ</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF"><table width="95%" border="1">
          <tr>
            <td>
		<logic:notEmpty name="ArchivesForm" property="msgError">
		<b><font color=red>�ܱ�Ǹ�������з������󣡵��<a href="#" style="color:blue" onclick="var obj=document.all('err');if(obj.style.display=='none') {obj.style.display='block'} else{obj.style.display='none'}">�˴�</a>�鿴��ϸ��Ϣ</font></b>
		<span id=err style="display:none"><bean:write name="ArchivesForm" property="msgError"/></span>
          	</logic:notEmpty>
		<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td nowrap>ȫ�ں�<font color=red>*</font></td>
                  <td nowrap><html:text property="archives.AFONDS_NUM" size="4" readonly="true"/></td>
                  <td nowrap>���(YYYY)<font color=red>*</font></td>
                  <td nowrap><html:text property="archives.AARCHIVES_YEAR" size="4"/></td>
                  <td nowrap>�ұ����<font color=red>*</font></td>
                  <td nowrap><html:text property="archives.APIECE_NUM" size="10" readonly="true"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td nowrap>����������</td>
                  <td nowrap><html:text property="archives.AORGAN" size="20"/></td>
                  <td nowrap>��������<font color=red>*</font></td>
                  <td nowrap><html:select property="archives.ASTORE_TERM">
            <html:optionsCollection property="ASTORE_TERMOptions"/>
            </html:select></td>
                  <td nowrap>�ݱ����<font color=red>*</font></td>
                  <td nowrap><html:text property="archives.AARC_PIECE_NUM" size="10"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td nowrap>����<font color=red>*</font></td>
                  <td colspan="5" nowrap><html:text property="archives.AARCHIVES_NUM" size="20" readonly="true"/></td>
                </tr>
              </table>
              </td>
          </tr>
        </table>
        <br>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
	<tr bgcolor="#FFFFFF">
            <td width="25%" nowrap>�ļ�����<font color=red>*</font></td>
            <td colspan="3" nowrap><html:textarea property="archives.AARCHIVES_NAME" cols="60" rows="2"/></td>
        </tr>
        <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ��ܼ�</td>
            <td nowrap colspan="3">
		<html:select property="archives.ASECRET_ID">
		<html:optionsCollection property="secret_idOptions"/>
		</html:select>
            </td>
        </tr>
        <tr bgcolor="#FFFFFF">
          <td nowrap>������λ<font color=red>*</font></td>
          <td colspan="3" nowrap><html:select property="archives.AARCHIVES_FOUND_UNIT">
            <html:optionsCollection property="AARCHIVES_FOUND_UNITOptions"/> </html:select></td>
        </tr>
        <tr bgcolor="#FFFFFF">
          <td nowrap>��������<font color=red>*</font></td>
          <td colspan="3" nowrap> <html:select property="archives.AMEDIA_TYPE">
            <html:optionsCollection property="AMEDIA_TYPEOptions"/> </html:select></td>
        </tr>
        <tr bgcolor="#FFFFFF">
          <td nowrap>�鵵��</td>
          <td colspan="3" nowrap><html:text property="archives.AARC_NUM" size="20"/></td>
        </tr>
        <tr bgcolor="#FFFFFF">
          <td nowrap>��΢��</td>
          <td colspan="3" nowrap><html:text property="archives.AREDUCE_NUM" size="20"/></td>
        </tr>
        <tr bgcolor="#FFFFFF">
          <td>��ע</td>
          <td colspan="3"><html:textarea property="archives.AREMARK" cols="60" rows="4"/></td>
        </tr>
        <tr align="center" bgcolor="#FFFFFF">
          <td colspan="4"><input type="button" name="Submit2" value="ȷ��" onclick="doSubmit(this.form);">
              <input type="reset" name="Submit3" value="ȡ��"></td>
        </tr>
      </table>
        <br>
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

