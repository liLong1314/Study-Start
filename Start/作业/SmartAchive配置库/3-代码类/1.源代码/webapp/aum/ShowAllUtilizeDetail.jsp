<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.sunyard.hgam.util.aum.AumUtil"%>
<%@ page import="com.sunyard.hgam.util.adc.AdcUtil"%>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>�б�</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script src="/common/js/chkBoxOperation.js">
//��ѡ���������
</script>
</head>
<script language="javascript"> 
<!--
function addCharge(){
	document.all.functionName.value = "InitInsert";
	document.ChargeStandardForm.submit();
}

function deleteCharge() {	
	document.all.functionName.value = "delete";
	document.ChargeStandardForm.submit();
}
-->
</script>
<body class="bg-page01">
<html:form action="/aum/UtilizeDetail" method="post" >
<html:hidden property="functionName"/>
<html:hidden property="apply_id"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="35"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="51"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="70" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="10" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="796" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã��շѱ�׼�����б� &gt;&gt; </td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">�շѱ�׼������Ϣ�б�</td>
                </tr></table>              
              <table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00"><tr></tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr> 
      
    <td background="../image/2_table_c_r.gif">&nbsp;</td>
      
    <td align="center" bgcolor="#FFFFFF"> <br>
			<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9"> 
          <td nowrap>ѡ��</td>
          <td nowrap>��Ŀ����</td>
          <td nowrap bgcolor="#F7EED9">�����/����</td>
          <td nowrap bgcolor="#F7EED9">��������</td>
          <td nowrap>�ļ�����</td>
          <td nowrap>ҳ��</td>
          <td nowrap>�շѽ��</td>
          <td nowrap>���</td>
          <td nowrap>����</td>
          <td nowrap>�Ƿ�������</td>
        </tr>
        <bean:define id="list_detail" name="UtilizeDetailForm" property="list_detail"/>
				<logic:iterate id="item" name="list_detail" >
        <tr align="center"> 
          <td bgcolor="#f6f6f6"><input type="checkbox" name="selectID" value="<bean:write name='item' property='apply_id'/>"></td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="entry_name"/></td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="archives_num"/></td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="archives_name"/></td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="file_name"/></td>
          <td bgcolor="#f6f6f6"><a href="#"><bean:write name="item" property="page_count"/></a></td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="page_size"/></td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="page_money"/></td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="is_in"/></td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="is_out"/></td>
          <td bgcolor="#f6f6f6"><bean:write name="item" property="is_full"/></td>
        </tr>
        </logic:iterate>
      </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="36%" nowrap bgcolor="#F7EED9">��һҳ ��һҳ&gt;&gt; ��һҳ&lt;&lt; ���һҳ-- ���� �� </td>
            <td width="5%" bgcolor="#F7EED9"><select name="select">
            </select></td>
            <td bgcolor="#F7EED9">ҳ �� 23 ҳ</td>
          </tr>
          <tr align="center">
            <td colspan="3" bgcolor="#F7EED9">
            	<input type="button" name="Submit" value="���ӵ���" onClick="window.open('/aum/queryArchivesView.do','','')">
            	<input type="button" name="Submit2" value="ɾ������">
            	<input type="button" name="Submit3" value="ȷ��" onclick="window.close()"></td>
          </tr>
        </table>
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
