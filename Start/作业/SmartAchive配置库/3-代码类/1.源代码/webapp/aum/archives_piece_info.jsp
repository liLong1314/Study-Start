<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����Ϣ</title>
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
      <td width="818" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã� &gt;&gt; ������ѯ &gt;&gt;
        ����Ϣ</td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">����Ϣ</td>
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
		<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td nowrap>ȫ�ں�</td>
                  <td nowrap><bean:write  name ="ArchivesForm" property="archives.AFONDS_NUM"/></td>
                  <td nowrap>���(YYYY)</td>
                  <td nowrap><bean:write  name ="ArchivesForm" property="archives.AARCHIVES_YEAR"/> </td>
                  <td nowrap>�ұ����</td>
                  <td nowrap><bean:write  name ="ArchivesForm" property="archives.APIECE_NUM"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td nowrap>����������</td>
                  <td nowrap><bean:write  name ="ArchivesForm" property="archives.AORGAN"/> </td>
                  <td nowrap>��������</td>
                  <td nowrap><html:select property="archives.ASTORE_TERM" disabled="true">
            <html:optionsCollection property="ASTORE_TERMOptions"/>
            </html:select></td>
                  <td nowrap>�ݱ����</td>
                  <td nowrap><bean:write  name ="ArchivesForm" property="archives.AARC_PIECE_NUM"/> </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td nowrap>����</td>
                  <td colspan="5" nowrap><bean:write  name ="ArchivesForm" property="archives.AARCHIVES_NUM"/> </td>
                </tr>
              </table>
              </td>
          </tr>
        </table>
        <br>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
	<tr bgcolor="#FFFFFF">
            <td width="25%" nowrap>�ļ�����</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesForm" property="archives.AARCHIVES_NAME"/></td>
        </tr>
        <tr bgcolor="#FFFFFF">
            <td nowrap>�ļ��ܼ�</td>
            <td nowrap colspan="3">
		<html:select property="archives.ASECRET_ID" disabled="true">
		<html:optionsCollection property="secret_idOptions"/>
		</html:select>
            </td>
        </tr>
        <tr bgcolor="#FFFFFF">
          <td nowrap>������λ</td>
          <td colspan="3" nowrap><html:select property="archives.AARCHIVES_FOUND_UNIT" disabled="true">
            <html:optionsCollection property="AARCHIVES_FOUND_UNITOptions"/> </html:select></td>
        </tr>
        <tr bgcolor="#FFFFFF">
          <td nowrap>��������</td>
          <td colspan="3" nowrap> <html:select property="archives.AMEDIA_TYPE" disabled="true">
            <html:optionsCollection property="AMEDIA_TYPEOptions"/> </html:select></td>
        </tr>
        <tr bgcolor="#FFFFFF">
          <td nowrap>�鵵��</td>
          <td colspan="3" nowrap><bean:write  name ="ArchivesForm" property="archives.AARC_NUM"/> </td>
        </tr>
        <tr bgcolor="#FFFFFF">
          <td nowrap>��΢��</td>
          <td colspan="3" nowrap><bean:write  name ="ArchivesForm" property="archives.AREDUCE_NUM"/> </td>
        </tr>
        <tr bgcolor="#FFFFFF">
          <td>��ע</td>
          <td colspan="3"><bean:write  name ="ArchivesForm" property="archives.AREMARK"/> </td>
        </tr>
        <tr align="center" bgcolor="#FFFFFF">
          <td colspan="4">
		<input type="button" name="Submit1" value="��ӡ" onclick="window.print();">
              	<input type="button" name="Submit2" value="����" onclick="window.location='queryArchives.do';">
          </td>
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

