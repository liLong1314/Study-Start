<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<html>
<head>
<title>流程跟踪</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}
//-->
</script>
</head>
<body class="bg-page01">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <input type="hidden" name="handler">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">流程跟踪</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><br>
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td nowrap>环节</td>
            <td nowrap>处理人</td>
            <td nowrap>处理时间</td>
            <td nowrap>处理意见</td>
            <td nowrap>状态</td>
          </tr>
          <logic:present name="actList">
          <logic:iterate id="act" name="actList">
          <tr align="center">
            <td bgcolor="#f6f6f6"><bean:write name="act" property="taskName"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="act" property="handleMan"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="act" property="handleDate"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="act" property="handleIdea"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="act" property="flagHandler"/></td>
          </tr>
          </logic:iterate>
          </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <td bgcolor="#F7EED9"></td>
          </tr>
          <tr align="center">
            <td colspan="3" bgcolor="#F7EED9">
            <input name="Submit3" type="button" value="关闭" onclick="window.location='/aum/RepairTaskList.do'">
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
</body>
</html>
