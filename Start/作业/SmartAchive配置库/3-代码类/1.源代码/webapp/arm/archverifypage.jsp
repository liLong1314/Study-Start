<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>����У��-�鿴ҳ��</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style></head>
<body class="bg-page01">
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
    <td width="620" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã�<a href="/arm/ArchView.do?flag=1">����У��</a> &gt;&gt; <a href="/arm/FileView.do?flag=1">�����ļ�</a>
      &gt;&gt; �ļ�ҳ��</td>
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
                <td align="center" bgcolor="#E4F2FA" class="tishi">�����ļ�</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF" valign="top">
    <logic:present name="PageOpers">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="PageOpers" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            ��һҳ </a><a href="?page=previous">&lt;
            ��һҳ </a></logic:notEqual> <logic:notEqual name="PageOpers" property="lastPage" value="true" >
            <a href="?page=next">��һҳ
            &gt; </a><a href="?page=last">���ҳ
            &gt;&gt; </a></logic:notEqual>&nbsp; ��<bean:write name="PageOpers" property="rowAmount" />����¼&nbsp;
            ��ǰ��
            <input type="text" size="1" value="<bean:write name="PageOpers" property="pageIndex" />" onChange="javascript:gotoPage(this.value)">
            /<bean:write name="PageOpers" property="pageAmount" />
            ҳ&nbsp; ÿҳ<bean:write name="PageOpers" property="pageSize" />��</td>
        </tr>
      </table>
      </logic:present>
      <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td width="20%">ҳ��</td>
          <td width="20%">ҳ����</td>
          <td width="20%">ҳ��</td>
          <td width="20%">¼������</td>
          <td width="20%">����</td>
        </tr>
        <logic:present name="PageOpers">
	<logic:iterate id="pageOper" name="PageOpers">
        <tr align="center">
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="pageOper" property="pageNum"/></td>
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="pageOper" property="pageType"/></td>
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="pageOper" property="pageSize"/></td>
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="pageOper" property="pageDate"/></td>
          <td bgcolor="#f6f6f6" width="20%"><a href="/aum/ImageShow.do?pageId=<bean:write name="pageOper" property="pageId"/>">�鿴Ӱ��</a></td>
        </tr>
        </logic:iterate>
	</logic:present>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9" align="center">&nbsp; </td>
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
