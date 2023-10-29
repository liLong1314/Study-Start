<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>文件著录页面</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<script language="javascript" src="../common/js/validateEform.js"></script>
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
	//先验证电子表单
	if(!validateEform(theform)) return false;
	//验证其他的表单元素
	var file_title = document.getElementById("archivesFile.file_title");
	var file_id = document.getElementById("archivesFile.file_id");
	var file_duty = document.getElementById("archivesFile.file_duty");
	var file_date = document.getElementById("archivesFile.file_date");
	var file_page_amount = document.getElementById("archivesFile.file_page_amount");
	var page_num_from_to = document.getElementById("archivesFile.page_num_from_to");

        if(BASEtrim(file_title.value)=="")
		return BASEalert("请输入正确的[文件题名]！",file_title);
        //if(BASEtrim(file_id.value)=="")
	//	return BASEalert("请输入正确的[文件编号]！",file_id);
        //if(BASEtrim(file_duty.value)=="")
	//	return BASEalert("请输入正确的[责任者]！",file_duty);
        //if(BASEtrim(file_date.value)=="")
	//	return BASEalert("请输入正确的[文件日期]！",file_date);
        if(BASEtrim(file_page_amount.value)!="" && BASEisNotNum(file_page_amount.value))
		return BASEalert("请输入正确的[文件页数]！",file_page_amount);
        if(BASEtrim(page_num_from_to.value)=="")
		return BASEalert("请输入正确的[文件起止页号]！",page_num_from_to);
        return true;
}
</script>
</head>
<body class="bg-page01">
<html:form action="/adc/updateArchivesFile.do" method="post">
  <html:hidden property="operName"/>
  <html:hidden property="archivesFile.file_id"/>
  <html:hidden property="archivesFile.eform_id"/>
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
      <td width="637" align="left" bgcolor="#FFFFFF">您现在的位置： &gt;&gt; 档案采集 &gt;&gt;
        文件著录</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">文件著录页面</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF">
        <logic:notEmpty name="ArchivesFileForm" property="msgError">
	<b><font color=red>很抱歉，过程中发生错误！点击<a href="#" style="color:blue" onclick="var obj=document.all('err');if(obj.style.display=='none') {obj.style.display='block'} else{obj.style.display='none'}">此处</a>查看详细信息</font></b>
	<span id=err style="display:none"><bean:write name="ArchivesFileForm" property="msgError"/></span>
        </logic:notEmpty>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件序号</td>
            <td colspan="3" nowrap><html:text property="archivesFile.file_seq" size="24" maxlength="20"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件题名<font color=red>*</font></td>
            <td colspan="3" nowrap><html:textarea property="archivesFile.file_title" cols="60" rows="2"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件编号</td>
            <td nowrap><html:text property="archivesFile.file_num" size="24" maxlength="20"/> </td>
            <td nowrap>责任者</td>
            <td nowrap><html:text property="archivesFile.file_duty" size="24" maxlength="100"/> </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件日期</td>
            <td nowrap><html:text property="archivesFile.file_date" size="24"/> </td>
            <td nowrap>文件页数</td>
            <td nowrap><html:text property="archivesFile.file_page_amount" size="10" maxlength="9"/> </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件起止页号</td>
            <td nowrap colspan=3><html:text property="archivesFile.page_num_from_to" size="24"/> </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件密级</td>
            <td nowrap>
		<html:select property="archivesFile.secret_id">
		<html:optionsCollection property="secret_idOptions"/>
		</html:select>
            </td>
            <td nowrap>保管期限</td>
            <td nowrap>
		<html:select property="archivesFile.file_store_term">
		<html:optionsCollection property="file_store_termOptions"/>
		</html:select>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>载体类型</td>
            <td nowrap> <html:select property="archivesFile.media_type"> <html:optionsCollection property="media_typeOptions"/> </html:select></td>
            <td nowrap>载体规格</td>
            <td nowrap><html:select property="archivesFile.file_spec"> <html:optionsCollection property="file_specOptions"/> </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件份数</td>
            <td nowrap><html:text property="archivesFile.file_count" size="10" maxlength="9"/></td>
            <td nowrap>稿本类型</td>
            <td nowrap> <html:select property="archivesFile.file_type"> <html:optionsCollection property="file_typeOptions"/> </html:select></td>
          </tr>
	  <logic:notEmpty name="ArchivesFileForm" property="eformFieldValueList">
	  <logic:iterate id="eformFieldValueItem" name="ArchivesFileForm" property="eformFieldValueList">
          <tr bgcolor="#FFFFFF">
            <td nowrap>
		<bean:write name ="eformFieldValueItem" property="field_cname"/>
            </td>
            <td nowrap colspan="3">
		<input type="hidden" name="field_id" value="<bean:write name ="eformFieldValueItem" property="field_id"/>">
		<input type="hidden" name="field_cname" value="<bean:write name ="eformFieldValueItem" property="field_cname"/>">
		<logic:lessThan name="eformFieldValueItem" property="field_len" value="21">
		<input type="text" name="field_value"
			field_type_id="<bean:write name ="eformFieldValueItem" property="field_type_id"/>"
			field_isEdit ="<bean:write name ="eformFieldValueItem" property="field_isEdit"/>"
			size   	     ="20"
			maxlength    ="<bean:write name ="eformFieldValueItem" property="field_len"/>"
			field_isNull ="<bean:write name ="eformFieldValueItem" property="field_isNull"/>"
			value	     ="<bean:write name ="eformFieldValueItem" property="field_value"/>">
		</logic:lessThan>
		<logic:greaterEqual name="eformFieldValueItem" property="field_len" value="21">
		<textarea name="field_value" cols="60" rows="2"
			field_type_id="<bean:write name ="eformFieldValueItem" property="field_type_id"/>"
			field_isEdit ="<bean:write name ="eformFieldValueItem" property="field_isEdit"/>"
			field_isNull ="<bean:write name ="eformFieldValueItem" property="field_isNull"/>"><bean:write name ="eformFieldValueItem" property="field_value"/></textarea>
		</logic:greaterEqual>
            </td>
          </tr>
	  </logic:iterate>
          </logic:notEmpty>
          <tr bgcolor="#FFFFFF">
            <td nowrap>备注</td>
            <td colspan="3" nowrap> <html:textarea property="archivesFile.remark" cols="60" rows="4"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="4" align="center" nowrap>
		<input type="button" name="Submit2" value="确定" onclick="doSubmit(this.form);">
		<input type="reset" name="Submit3" value="返回" onclick="window.history.go(-1)">
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
