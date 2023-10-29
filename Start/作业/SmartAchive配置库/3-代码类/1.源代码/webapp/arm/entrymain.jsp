<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<html:html>
<head>
<title>类目管理</title>
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
	var tmp=confirm("您确认删除吗？\n注意：删除一级类目将同时删除该类目下的所有二级类目！\n继续吗？");
	if(tmp)
	window.location="/arm/EntryDel.do?flag=1&entryId=" + id;
}
</script>
</head>
<body class="bg-page01">
<form action="" method="post" name="form1">
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
      <td width="620" align="left" bgcolor="#FFFFFF"> 您现在的位置：档案类目管理</td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">档案类目管理信息</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" valign="top" bgcolor="#FFFFFF"> <logic:present name="Secrets">
        </logic:present>
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td>序号</td>
            <td>类目级别</td>
            <td>类目类型</td>
            <td bgcolor="#F7EED9">类目名称</td>
            <td bgcolor="#F7EED9">说明</td>
            <td>操作</td>
          </tr>
          <logic:present name="Entrys">
          <logic:iterate id="entry" name="Entrys">
          <tr align="center">
            <td bgcolor="#f6f6f6"><bean:write name="entry" property="entryId"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="entry" property="entryLevel"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="entry" property="isOperation"/></td>
            <td bgcolor="#f6f6f6"><a href="/arm/EntryView.do?flag=2&entryId=<bean:write name="entry" property="entryId"/>"><bean:write name="entry" property="entryName"/></a></td>
            <td bgcolor="#f6f6f6"><bean:write name="entry" property="remark"/></td>
            <td bgcolor="#f6f6f6">
		<a href="/arm/EntryModView.do?flag=1&entryId=<bean:write name="entry" property="entryId"/>">修改</a>
		<a href="javascript:doConfirm(<bean:write name="entry" property="entryId"/>)">删除</a>
            </td>
          </tr>
          </logic:iterate>
          </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="36%" bgcolor="#F7EED9">&nbsp;</td>

          <tr>
            <td align="center" bgcolor="#F7EED9"><input type="button" name="Submit"onclick="window.location='entryFadd.jsp'" value="增加一级类目"></td>
          </tr>
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
</form>
</body>
</html:html>
