<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�û��������ظ�������Ϣ</title>
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
//�ύ
function doSubmit(theform){
        if(validateForm(theform)){
                theform.submit();
        }
}
//��֤���Ϸ���
function validateForm(theform){
	//��֤��Ԫ��
	var info_feedback_content = document.getElementById("publishInfo.info_feedback_content");

        if(BASEtrim(info_feedback_content.value)=="")
		return BASEalert("��������ȷ��[�ظ�����]��",info_feedback_content);
        return true;
}
</script>
</head>
<body class="bg-page01">
<html:form action="/pub/updatePublishInfo" method="post">
  <html:hidden property="operName" value="REPLY"/>
  <html:hidden property="publishInfo.info_id"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="50" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8">
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="637" align="left" bgcolor="#FFFFFF">�����ڵ�λ�ã� &gt;&gt; �û����� &gt;&gt;
        �ظ��û�����</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">�ظ��û�����</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF">
        <logic:notEmpty name="PublishInfoForm" property="msgError">
	<b><font color=red>�ܱ�Ǹ�������з������󣡵��<a href="#" style="color:blue" onclick="var obj=document.all('err');if(obj.style.display=='none') {obj.style.display='block'} else{obj.style.display='none'}">�˴�</a>�鿴��ϸ��Ϣ</font></b>
	<span id=err style="display:none"><bean:write name="PublishInfoForm" property="msgError"/></span>
        </logic:notEmpty>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td nowrap>��������<font color=red>*</font></td>
            <td colspan="3" ><bean:write name="PublishInfoForm" property="publishInfo.info_title"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>��������</td>
            <td colspan="3" ><bean:write name="PublishInfoForm" property="publishInfo.info_content"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>����</td>
            <td colspan="3" >
		<logic:present name="publishInfoAccessoryList">
		<logic:iterate id="item" name="publishInfoAccessoryList">
		<a href="<bean:write name="item" property="accessory_filename"/>">����[<bean:write name="item" property="accessory_title"/>]</a>&nbsp;&nbsp;&nbsp;&nbsp;
	  	</logic:iterate>
		<logic:empty name="publishInfoAccessoryList">��</logic:empty>
		</logic:present>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>������Ա</td>
            <td colspan="3" ><bean:write name="PublishInfoForm" property="publishInfo.info_publish_person"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>����ʱ��</td>
            <td colspan="3" ><bean:write name="PublishInfoForm" property="publishInfo.info_publish_datetime"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>�ظ�����<font color=red>*</font></td>
            <td colspan="3" ><html:textarea property="publishInfo.info_feedback_content" cols="60" rows="6"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="4" align="center" nowrap>
		<input type="button" name="Submit2" value="ȷ��" onclick="doSubmit(this.form);">
		<input type="button" name="Submit3" value="����" onclick="window.location.href='/pub/queryFeedbackList.do?page='">
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
