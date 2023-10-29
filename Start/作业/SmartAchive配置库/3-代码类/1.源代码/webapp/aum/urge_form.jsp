<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>催收单</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url('../image/2_mainpagebg_01.gif');
}
-->
</style></head>
<body class="bg-page01">
<script>
	function doChange(obj){
		window.location.href=obj.options[obj.selectedIndex].url;
	}
</script>

<form action="" method="post" name="form1">
  <table width="354" border="0" cellspacing="0" cellpadding="0" height="1">
    <tr>
      <td width="35" height="22"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="839" background="../image/2_table_c_t.gif" height="22"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">借阅催收单</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="26" height="22"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>

      <logic:present name="utilizeInfo">
      <td height="1" background="../image/2_table_c_r.gif" width="35">　</td>
      <td align="center" bgcolor="#FFFFFF" height="1" width="839"><br>
          <table width="567" border="0" cellpadding="2" cellspacing="0" bgcolor="#FFFFFF" style="border-collapse: collapse; border-width: 0" bordercolor="#111111" height="1">
          <tr bgcolor="#FFFFFF">
            <td nowrap>
            <p align="left"><bean:write name="utilizeInfo" property="personCorp"/>
            <font size="2">（部门）</font>
            <bean:write name="utilizeInfo" property="personName"/>
            <font size="2">：</font></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap style="border-left-style: none; border-left-width: medium; border-top-style: none; border-top-width: medium" height="19" width="563">
            <p align="left"><font size="2">你于</font>
              <bean:write name="utilizeInfo" property="beginDate"/>
            <font size="2">借了档案号为</font>
            <font size="2" color="red"><bean:write name="utilizeInfo" property="handleIdea"/></font>
            <font size="2">的档案，归还日期为<bean:write name="utilizeInfo" property="latestRenewDate"/>
            ，现在已超期，请及时归还。</font></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap align="right" ></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap align="right" >
            <font size="2">档案科</font></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap align="right" style="border-left-style: none; border-left-width: medium; border-top-style: none; border-top-width: medium" height="12" width="563">
            <font size="2"><bean:write name="utilizeInfo" property="remark"/>
            </font></td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td width="563" height="21">
            <input type="button" name="Submit22" value="打印" onclick="window.print()">
              <input type="button" name="Submit222" value="返回" onclick="window.close()">&nbsp; </td>
          </tr>
        </table>

        <br>
      </td>
      </logic:present>
    <td background="../image/2_table_c_l.gif" height="1" width="26">　</td>
    </tr>
    <tr>
      <td height="1" width="35"><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif" height="1" width="839"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td height="1" width="26"><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
  </form>
</body>
</html>