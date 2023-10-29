<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html:html>
<head>
<title>显示总局指示</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
</head>
<body class="bg-page01">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">工作汇报</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><br>
        <table width="95%" border="1">
          <tr>
            <td height="62"> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td colspan="2" align="right"><div align="center">主题：<bean:write name="watchExamineDenoteInfo" property="denoteTitle"/></div></td>
                </tr>
                <tr valign="top">
                <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="watchExamineDenoteInfo" property="denoteContent"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td width="11%" align="right">&nbsp;</td>
                  <td width="89%"><div align="center">负责人：<bean:write name="watchExamineDenoteInfo" property="denoteSuperinrtendent"/></div></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td height="16" align="right">&nbsp;</td>
                  <td><div align="center">领导签字：<bean:write name="watchExamineDenoteInfo" property="leadshiperSignature"/></div></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td height="16" align="right">&nbsp;</td>
                  <td><div align="center">日期：<bean:write name="watchExamineDenoteInfo" property="denoteDate"/></div></td>
                </tr>
              </table></td>
          </tr>
        </table>
        <input type="button" name="Submit" onclick="window.location='/arm/viewallsubwatchexamine.do'"value="返回">
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
</body>
</html:html>
