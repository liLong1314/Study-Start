<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>��ʪ�ȹ���</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
function doConfirm(id){
	var tmp=confirm("��ȷ��ɾ����");
	if(tmp)
	window.location="/arm/TemperatureDel.do?temperatureId=" + id;
}
</script>
</head>
<body class="bg-page01">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
    <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
    <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
  </tr>
  <tr>
    <td background="../image/2_table_c_r.gif">&nbsp;</td>
    <td width="51" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
    </td>
    <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="653" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã���ʪ�ȹ���</td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">��ʪ�ȹ���</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br>
        <table width="95%" border="1">
          <tr>
            <td height="39">
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
            <html:form action="/arm/TemperatureSearch.do?flag=first" method="post">
              <tr bgcolor="#FFFFFF">
                <td width="20%">�Ǽ����ڣ�</td>
                <td width="40%">��
                  <html:text property="temperatureInfo.temDateFrom" size="10"/>
                  ��
                  <html:text property="temperatureInfo.temDateTo" size="10"/>
                </td>
                <td rowspan="2">
                  <input type="submit" name="Submit" value="��ѯ">
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td width="20%">
                  <p>�Ǽ��ˣ�</p>
                </td>
                <td width="40%"> ��
                  <html:text property="temperatureInfo.temperatureMan" size="15"/>
                </td>
              </tr>
              </html:form>
            </table>
          </td>
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
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">��ʪ�ȹ�����Ϣ</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
    <td align="center" bgcolor="#FFFFFF" valign="top">
    <logic:present name="Temperatures">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="Temperatures" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            ��һҳ </a><a href="?page=previous">&lt;
            ��һҳ </a></logic:notEqual> <logic:notEqual name="Temperatures" property="lastPage" value="true" >
            <a href="?page=next">��һҳ
            &gt; </a><a href="?page=last">���ҳ
            &gt;&gt; </a></logic:notEqual>&nbsp; ��<bean:write name="Temperatures" property="rowAmount" />����¼&nbsp;
            ��ǰ��
            <input type="text" size="1" value="<bean:write name="Temperatures" property="pageIndex" />" onChange="javascript:gotoPage(this.value)">
            /<bean:write name="Temperatures" property="pageAmount" />
            ҳ&nbsp; ÿҳ<bean:write name="Temperatures" property="pageSize" />��</td>
        </tr>
      </table>
      </logic:present>
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td width="0">�ⷿ</td>
            <td width="0">�¶�</td>
            <td width="0">ʪ��</td>
            <td width="0">�Ǽ�����</td>
            <td width="0">�Ǽ���</td>
            <td width="0">˵��</td>
            <td width="0">����</td>
          </tr>
          <logic:present name="Temperatures">
          <logic:iterate id="temperatures" name="Temperatures">
          <tr align="center">
            <td width="0" bgcolor="#f6f6f6"><bean:write name="temperatures" property="roomCode"/></td>
            <td width="0" bgcolor="#f6f6f6"><bean:write name="temperatures" property="temperatureDegree"/></td>
            <td width="0" bgcolor="#f6f6f6"><bean:write name="temperatures" property="temperatureWet"/></td>
            <td width="0" bgcolor="#f6f6f6"><bean:write name="temperatures" property="temperatureDate"/></td>
            <td width="0" bgcolor="#f6f6f6"><bean:write name="temperatures" property="temperatureMan"/></td>
            <td width="0" bgcolor="#f6f6f6"><bean:write name="temperatures" property="remark"/></td>
            <td width="0" bgcolor="#f6f6f6">
		<a href="/arm/TemperatureModView.do?temperatureId=<bean:write name="temperatures" property="temperatureId"/>">�޸�</a>
		<a href="javascript:doConfirm(<bean:write name="temperatures" property="temperatureId"/>)">ɾ��</a>
            </td>
          </tr>
          </logic:iterate>
          </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="right" bgcolor="#F7EED9"><input type="button" name="Submit"onclick="window.location='temadd.jsp'" value="��ʪ�ȵǼ�"></td>
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
</body>
</html:html>
