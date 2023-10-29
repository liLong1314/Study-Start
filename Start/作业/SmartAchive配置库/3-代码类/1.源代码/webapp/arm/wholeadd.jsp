<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%
String wholeType=request.getSession().getAttribute("tmpwholeType").toString();
String wholeTypeName=request.getSession().getAttribute("WholeTypeName").toString();
%>

<html>
<head>
<title>增加全宗卷信息</title>
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
	var wholeYear = document.getElementById("wholeInfo.wholeYear");
	var wholeName = document.getElementById("wholeInfo.wholeName");
	var wholeMakeDate = document.getElementById("wholeInfo.wholeMakeDate");

        if(BASEtrim(wholeYear.value)=="" || BASEisNotNum(wholeYear.value))
        	return BASEalert("请输入正确的[年度]！",wholeYear);
        if(BASEtrim(wholeName.value)=="")
        	return BASEalert("请输入正确的[题名]！",wholeName);
        if(BASEtrim(wholeMakeDate.value)!="" && BASEisNotDate(wholeMakeDate.value))
        	return BASEalert("请输入正确的[日期]！",wholeMakeDate);
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
    <td width="653" align="left" bgcolor="#FFFFFF">您现在的位置：<a href="/arm/WholeView.do">全宗卷信息管理</a>
      &gt;&gt; 增加<%=wholeTypeName%></td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">增加<%=wholeTypeName%></td>
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
            <td height="112">
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
		<html:form action="/arm/WholeAdd.do" method="post" onsubmit="return doSubmit(this.form);">
                <tr bgcolor="#FFFFFF">

                <td width="30%" align="right">年代<font color="#FF0000">*</font></td>
                <td width="70%"> <html:hidden property="wholeInfo.wholeType" value="<%=wholeType%>"/>
                  <html:text property="wholeInfo.wholeYear" size="8" maxlength="4"/> </td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right" width="30%">题名<font color="#FF0000">*</font></td>

                <td width="70%"><html:text property="wholeInfo.wholeName" size="60"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right" width="30%">责任人</td>

                <td width="70%"><html:text property="wholeInfo.wholeMakeMan" size="25"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right" width="30%">时间(YYYY-MM-DD)</td>

                <td width="70%"><html:text property="wholeInfo.wholeMakeDate" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right" width="30%">说明</td>

                <td width="70%"><html:textarea property="wholeInfo.remark"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right" width="30%">内容</td>

                <td width="70%"><html:textarea property="wholeInfo.wholeContent" cols="60" rows="10"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="center" width="30%">
<input type="submit" name="submit" value="提交"></td>

                <td align="center" width="70%">
<input type="Reset" name="reset" value="重写"></td>
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
</html>
