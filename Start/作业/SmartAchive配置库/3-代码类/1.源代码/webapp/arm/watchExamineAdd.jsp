<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html:html>
<head>
<title>监督检查管理</title>
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
	var watchTitle = document.getElementById("watchExamineInfo.watchTitle");
	var watchTime = document.getElementById("watchExamineInfo.watchTime");
        if(BASEtrim(watchTitle.value)=="")
        	return BASEalert("请输入正确的[主题]！",watchTitle);
        if(BASEtrim(watchTime.value)!="" && BASEisNotDate(watchTime.value))
        	return BASEalert("请输入正确的[报告时间]！",watchTime);
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
      <td width="653" align="left" bgcolor="#FFFFFF"> 您现在的位置： &gt;&gt; 档案管理 &gt;&gt;
        档案信息管理 &gt;&gt; <a href="/arm/viewallsubwatchexamine.do" target="hmain">分局工作汇报</a>&gt;&gt;工作汇报</td>
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
          <html:form action="/arm/watchExamineAdd.do" method="post" onsubmit="return doSubmit(this.form);">
          <tr>
            <td height="62"> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td width="9%" align="right">分局名称</td>
                  <td width="15%">
                  <html:select  property="watchExamineInfo.subCode">
                    <html:option value="8">上城规划分局</html:option>
                    <html:option value="9">下城规划分局</html:option>
                    <html:option value="11">江干规划分局</html:option>
                    <html:option value="12">拱墅规划分局</html:option>
                    <html:option value="10">西湖规划分局</html:option>
                 </html:select>
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">主题<font color="#FF0000">*</td>
                  <td><html:text property="watchExamineInfo.watchTitle" size="24"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">报告时间(YYYY-MM-DD)</td>
                  <td><html:text property="watchExamineInfo.watchTime" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">报告人</td>
                  <td><html:text property="watchExamineInfo.watchAuthor" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">工作内容</td>
                  <td><html:textarea property="watchExamineInfo.watchContent" /></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">备注</td>
                  <td><html:textarea property="watchExamineInfo.remark" /></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="center"><input name="Submit" type="Submit" value="提交"></td>
                  <td align="center"><input type="reset" name="重写" "value="reset"></td>
                </tr>
                </html:form>
              </table></td>
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
</html:html>
