<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>增加温湿度</title>
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
	var roomCode = document.getElementById("temperatureInfo.roomCode");
	var temperatureDegree = document.getElementById("temperatureInfo.temperatureDegree");
	var temperatureWet = document.getElementById("temperatureInfo.temperatureWet");
	var temperatureDate = document.getElementById("temperatureInfo.temperatureDate");

        if(BASEtrim(roomCode.value)=="")
        	return BASEalert("请输入正确的[库房]！",roomCode);
        if(BASEtrim(temperatureDegree.value)=="")
        	return BASEalert("请输入正确的[温度]！",temperatureDegree);
        if(BASEtrim(temperatureWet.value)=="")
        	return BASEalert("请输入正确的[湿度]！",temperatureWet);
        if(BASEtrim(temperatureDate.value)!="" && BASEisNotDate(temperatureDate.value))
        	return BASEalert("请输入正确的[登记日期]！",temperatureDate);
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
    <td width="653" align="left" bgcolor="#FFFFFF"> 您现在的位置： &gt;&gt; <a href="/arm/TemperatureSearch.do">温湿度管理</a> 
      &gt;&gt; 温湿度登记</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">温湿度登记</td>
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
	<html:form action="/arm/TemperatureAdd.do" method="post" onsubmit="return doSubmit(this.form);">
          <tr>
            <td height="62"> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  
                <td width="9%" align="right">库房<font color="#FF0000">*</font></td>
                  <td width="15%"><html:text property="temperatureInfo.roomCode"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  
                <td align="right">温度<font color="#FF0000">*</font></td>
                  <td><html:text property="temperatureInfo.temperatureDegree"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  
                <td align="right">湿度<font color="#FF0000">*</font></td>
                  <td><html:text property="temperatureInfo.temperatureWet"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  
                <td align="right">登记日期(YYYY-MM-DD)</td>
                  <td><html:text property="temperatureInfo.temperatureDate"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">登记人</td>
                  <td><html:text property="temperatureInfo.temperatureMan"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">说明</td>
                  <td><html:textarea property="temperatureInfo.remark"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="center"><input name="Submit" type="submit" value="提交"></td>
                  <td align="center"><input name="Reset" type="reset" value="重写"></td>
                </tr>
		</html:form>
              </table></td>
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
