<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%
String wholeTypeName=request.getSession().getAttribute("WholeTypeName").toString();
%>
<html:html>
<head>
<title>ȫ�ھ���Ϣ����</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}
//-->
</script>
<script language="JavaScript" type="text/JavaScript">
function doConfirm(id){
	var tmp=confirm("��ȷ��ɾ����");
	if(tmp)
	window.location="/arm/WholeDel.do?wholeId=" + id;
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
      <td width="50" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="637" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã�ȫ�ھ���Ϣ����</td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td colspan="3" background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">ȫ�ھ����</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
      <table width="100%"  border="1" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
        <tr bgcolor="#FFFFFF" align="center">
          <td nowrap> <a href="/arm/WholeView.do?type=1">ȫ�ڽ���</a></td>
          <td nowrap> <a href="/arm/WholeView.do?type=2">�����ռ�����</a></td>
          <td nowrap> <a href="/arm/WholeView.do?type=3">�����������</a></td>
          <td nowrap> <a href="/arm/WholeView.do?type=4">������������</a></td>
          <td nowrap> <a href="/arm/WholeView.do?type=5">�������ܲ���</a></td>
        </tr>
        <tr bgcolor="#FFFFFF" align="center">
          <td nowrap> <a href="/arm/WholeView.do?type=6">����ͳ�Ʋ���</a> </td>
          <td nowrap> <a href="/arm/WholeView.do?type=7">�������ò���</a></td>
          <td nowrap> <a href="/arm/WholeView.do?type=8">�����ִ�������</a></td>
          <td nowrap> <a href="/arm/WholeView.do?type=9">���¼�</a></td>
          <td nowrap>&nbsp;</td>
        </tr>
      </table>
    </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td height="20"><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi"><%=wholeTypeName%></td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
      <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td width="15%">���</td>
          <td width="30%">����</td>
          <td width="15%">������</td>
          <td width="20%">ʱ��</td>
          <td width="20%">����</td>
        </tr>
	<logic:present name="Wholes">
	<logic:iterate id="whole" name="Wholes">
        <tr align="center">
          <td bgcolor="#f6f6f6" width="15%"><bean:write name="whole" property="wholeYear"/></td>
          <td bgcolor="#f6f6f6" width="30%"><a href="/arm/WholeInfoView.do?wholeId=<bean:write name="whole" property="wholeId"/>"><bean:write name="whole" property="wholeName"/></a></td>
          <td bgcolor="#f6f6f6" width="15%"><bean:write name="whole" property="wholeMakeMan"/></td>
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="whole" property="wholeMakeDate"/></td>
          <td bgcolor="#f6f6f6" width="20%">
          	<a href="/arm/WholeModView.do?wholeId=<bean:write name="whole" property="wholeId"/>">�޸�</a>
            	<a href="javascript:doConfirm(<bean:write name="whole" property="wholeId"/>)">ɾ��</a>
          </td>
        </tr>
	</logic:iterate>
	</logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="center" bgcolor="#F7EED9"><input type="button" name="Submit" onclick="window.location='/arm/wholeadd.jsp'"value="����"></td>
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
</body>
</html:html>
