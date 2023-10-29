<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>安全登记</title>
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
	var roomCode = document.getElementById("safetyInfo.roomCode");
	var safetyCheckDate = document.getElementById("safetyInfo.safetyCheckDate");
	var safetyDealedDate = document.getElementById("safetyInfo.safetyDealedDate");

        if(BASEtrim(roomCode.value)=="")
        	return BASEalert("请输入正确的[库房名称]！",roomCode);
        if(BASEtrim(safetyCheckDate.value)!="" && BASEisNotDate(safetyCheckDate.value))
        	return BASEalert("请输入正确的[检查日期]！",safetyCheckDate);
        if(BASEtrim(safetyDealedDate.value)!="" && BASEisNotDate(safetyDealedDate.value))
        	return BASEalert("请输入正确的[处理日期]！",safetyDealedDate);
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
    <td width="620" align="left" bgcolor="#FFFFFF"> 您现在的位置：<a href="/arm/SafetySearch.do">安全管理</a> 
      &gt;&gt; 安全信息登记</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">安全登记</td>
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
            <td height="259">
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
		<html:form action="/arm/SafetyAdd.do" method="post" onsubmit="return doSubmit(this.form);">
                 <tr bgcolor="#FFFFFF">
                  
                <td width="9%" align="right">库房<font color="#FF0000">*</font></td>
                  <td width="15%"><html:text property="safetyInfo.roomCode" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">安全类型</td>
                  <td>
                  <html:select property="safetyInfo.safetyType">
                  <html:option value="1">虫霉防治</html:option>
                  <html:option value="2">除尘管理</html:option>
                  <html:option value="3">防火管理</html:option>
                  <html:option value="4">防盗管理</html:option>
                  <html:option value="5">照明管理</html:option>
                  </html:select>
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">情况描述</td>
                  <td><html:text property="safetyInfo.safetySituation" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">检查人</td>
                  <td><html:text property="safetyInfo.safetyChecker" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  
                <td align="right">检查日期(YYYY-MM-DD)</td>
                  <td><html:text property="safetyInfo.safetyCheckDate" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">处理人</td>
                  <td><html:text property="safetyInfo.safetyDealWithPerson" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  
                <td align="right">处理日期(YYYY-MM-DD)</td>
                  <td><html:text property="safetyInfo.safetyDealedDate" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">处理结果</td>
                  <td><html:text property="safetyInfo.safetyResult" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">说明</td>
                  <td><html:textarea property="safetyInfo.remark"/></td>
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
