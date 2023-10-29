<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>密集架登记</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
function doSubmit(theform){
	var obj=document.forms[0];
        if(validateForm(obj)){
		return true;
        }
		return false;
      }
function validateForm(theform){
	var roomCode = document.getElementById("containInfo.roomCode");
	var containCodeFrom = document.getElementById("containInfo.containCodeFrom");
	var containCodeTo = document.getElementById("containInfo.containCodeTo");
	var containRowFrom = document.getElementById("containInfo.containRowFrom");
	var containRowTo = document.getElementById("containInfo.containRowTo");
	var containColumnFrom = document.getElementById("containInfo.containColumnFrom");
	var containColumnTo = document.getElementById("containInfo.containColumnTo");

        if(BASEtrim(roomCode.value)=="")
        	return BASEalert("请输入正确的[库房]！",roomCode);
        if(BASEtrim(containCodeFrom.value)=="")
        	return BASEalert("请输入正确的[库柜号]！",containCodeFrom);
        if(BASEtrim(containCodeTo.value)=="")
        	return BASEalert("请输入正确的[库柜号]！",containCodeTo);
        if(BASEtrim(containRowFrom.value)=="")
        	return BASEalert("请输入正确的[层]！",containRowFrom);
        if(BASEtrim(containRowTo.value)=="")
        	return BASEalert("请输入正确的[层]！",containRowTo);
        if(BASEtrim(containColumnFrom.value)=="")
        	return BASEalert("请输入正确的[格]！",containColumnFrom);
        if(BASEtrim(containColumnTo.value)=="")
        	return BASEalert("请输入正确的[格]！",containColumnTo);
		return true;
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
    <td width="653" align="left" bgcolor="#FFFFFF"> 您现在的位置：<a href="/arm/ContainSearch.do">密集架管理</a>&gt;&gt; 密集架登记</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">密集架登记</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><br>
        <table width="100%" border="1">
          <tr>
            <td height="62">
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
            <html:form action="/arm/ContainAdd.do" method="post" onsubmit="return doSubmit(this.form);">
              <tr bgcolor="#FFFFFF">
                <td width="9%" align="right">库房<font color="#FF0000">*</font>：</td>
                <td width="15%">
                  <html:text property="containInfo.roomCode" size="10"/>
                  <html:hidden property="containInfo.containType" value="1"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right">库柜号<font color="#FF0000">*</font>：</td>
                <td> 从
                  <html:text property="containInfo.containCodeFrom" size="5"/>
                  到
                  <html:text property="containInfo.containCodeTo" size="5"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right">层<font color="#FF0000">*</font>：</td>
                <td> 从
                  <html:text property="containInfo.containRowFrom" size="5"/>
                  到
                  <html:text property="containInfo.containRowTo" size="5"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right">格<font color="#FF0000">*</font>：</td>
                <td> 从
                  <html:text property="containInfo.containColumnFrom" size="5"/>
                  到
                  <html:text property="containInfo.containColumnTo" size="5"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="center">
                  <input name="Submit" type="submit" value="提交">
                </td>
                <td align="center">
                  <input type="Reset" name="reset" value="重写">
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
</body>
</html:html>
