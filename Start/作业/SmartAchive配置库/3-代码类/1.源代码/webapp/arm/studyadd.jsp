<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>增加编研信息</title>
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
	var studyTitle = document.getElementById("studyInfo.studyTitle");
	var studyDate = document.getElementById("studyInfo.studyDate");

        if(BASEtrim(studyTitle.value)=="")
        	return BASEalert("请输入正确的[主题]！",studyTitle);
        if(BASEtrim(studyDate.value)!="" && BASEisNotDate(studyDate.value))
        	return BASEalert("请输入正确的[编写时间]！",studyDate);
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
      <td width="653" align="left" bgcolor="#FFFFFF"> 您现在的位置：  &gt;&gt; <a href="/arm/StudySearch.do">编研管理</a> &gt;&gt; 增加编研信息</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">增加编研信息</td>
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
		<html:form action="/arm/StudyAdd.do" method="post" onsubmit="return doSubmit(this.form);">
                <tr bgcolor="#FFFFFF">
                  <td width="9%" align="right">编研类别</td>
                  <td width="15%">
                  <html:select property="studyInfo.studyType">
                  <html:option value="1">组织机构沿革</html:option>
                  <html:option value="2">基础数字汇编</html:option>
                  <html:option value="3">会议简介</html:option>
                  <html:option value="4">大事记</html:option>
                  </html:select>
		</td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right">主题<font color="#FF0000">*</font></td>
                  <td><html:text property="studyInfo.studyTitle" size="24"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">前言</td>
                  <td><html:text property="studyInfo.studyPre" size="30"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">内容</td>
                  <td><html:text property="studyInfo.studyContent" size="30"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">作者</td>
                  <td><html:text property="studyInfo.studyAuthor" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right">编写时间(YYYY-MM-DD)</td>
                  <td><html:text property="studyInfo.studyDate" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">备注</td>
                  <td><html:textarea property="studyInfo.remark" /></td>
                </tr>
                  <tr bgcolor="#FFFFFF">
                  <td align="center"><input type="submit" name="submit" value="提交"></td>
                  <td align="center"><input type="reset" name="reset" value="重写"></td>
                </tr>
		</html:form>
              </table>
              </td>
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
