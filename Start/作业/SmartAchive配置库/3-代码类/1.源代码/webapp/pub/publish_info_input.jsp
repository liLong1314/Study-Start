<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>发布信息－新增发布信息</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script>
//提交
function doSubmit(theform){
        var operName = theform.operName;
        if(validateForm(theform)){
                operName.value="SUBMIT_ACTION";
                theform.submit();
        }
}
//验证表单合法性
function validateForm(theform){
	//验证表单元素
	var info_title = document.getElementById("publishInfo.info_title");

        if(BASEtrim(info_title.value)=="")
		return BASEalert("请输入正确的[发布标题]！",info_title);
        return true;
}
</script>
</head>
<body class="bg-page01">
<html:form action="/pub/addPublishInfo" enctype="multipart/form-data">
  <html:hidden property="operName"/>
  <html:hidden property="publishInfo.info_status" value="0"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="50" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8">
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="637" align="left" bgcolor="#FFFFFF">您现在的位置： &gt;&gt; 信息发布 &gt;&gt;
        新增发布信息</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">新增发布信息</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF">
        <logic:notEmpty name="PublishInfoForm" property="msgError">
	<b><font color=red>很抱歉，过程中发生错误！点击<a href="#" style="color:blue" onclick="var obj=document.all('err');if(obj.style.display=='none') {obj.style.display='block'} else{obj.style.display='none'}">此处</a>查看详细信息</font></b>
	<span id=err style="display:none"><bean:write name="PublishInfoForm" property="msgError"/></span>
        </logic:notEmpty>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td nowrap>发布类型<font color=red>*</font></td>
            <td colspan="3" nowrap>
		<html:select property="publishInfo.info_type">
		<html:optionsCollection property="info_typeOptions"/>
		</html:select>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>发布标题<font color=red>*</font></td>
            <td colspan="3" nowrap><html:textarea property="publishInfo.info_title" cols="60" rows="2"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>发布内容</td>
            <td colspan="3" nowrap><html:textarea property="publishInfo.info_content" cols="60" rows="6"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>发布到外网</td>
            <td colspan="3" nowrap><html:checkbox property="publishInfo.info_is_out" value="1"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>附件</td>
            <td colspan="3" nowrap>
		说明<html:text property="publishInfo.accessory_title" size="50"/><br>
		文件<html:file property="publishInfo.accessory_file" size="50"/>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="4" align="center" nowrap>
		<input type="button" name="Submit2" value="确定" onclick="doSubmit(this.form);">
		<input type="reset" name="Submit3" value="重输">
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
</html:form>
</body>
</html>
