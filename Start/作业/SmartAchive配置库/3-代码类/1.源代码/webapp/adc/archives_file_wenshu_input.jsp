<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>文件著录页面－文书类</title>
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
function doSubmit(theform){
	var operName = theform.operName;
        if(validateForm(theform)){
        operName.value="SUBMIT_ACTION";
        theform.submit();
        }
      }
function validateForm(theform){
	var file_title = document.getElementById("archivesFile.file_title");
	var file_num = document.getElementById("archivesFile.file_num");
	var file_duty = document.getElementById("archivesFile.file_duty");
	var file_date = document.getElementById("archivesFile.file_date");
	var file_page_amount = document.getElementById("archivesFile.file_page_amount");
	var file_get_date = document.getElementById("archivesFile.file_get_date");
	var page_num_from_to = document.getElementById("archivesFile.page_num_from_to");

        if(BASEtrim(file_title.value)=="")
        	return BASEalert("请输入正确的[文件题名]！",file_title);
        if(BASEtrim(file_num.value)=="")
        	return BASEalert("请输入正确的[文件编号]！",file_num);
        //if(BASEtrim(file_duty.value)=="")
        //	return BASEalert("请输入正确的[责任者]！",file_duty);
        //if(BASEtrim(file_date.value)=="")
        //	return BASEalert("请输入正确的[文件日期]！",file_date);
        //if(BASEtrim(page_num_from_to.value)=="")
	//	return BASEalert("请输入正确的[文件起止页号]！",page_num_from_to);
        if(BASEtrim(file_page_amount.value)!="" && BASEisNotNum(file_page_amount.value))
        	return BASEalert("请输入正确的[文件页数]！",file_page_amount);
        if(BASEtrim(file_get_date.value)!="" && BASEisNotDate(file_get_date.value))
        	return BASEalert("请输入正确的[收文时间]！",file_get_date);

	//同步是否限制件
	var IsPrivate = document.getElementById("archivesFile.is_private");
	var private = document.all("isPrivate");
	for(var i=0;i<private.length;i++){
               	if (private[i].checked) IsPrivate.value = private[i].value;
	}
	return true;
	}
</script>
</head>
<body class="bg-page01">

<html:form action="/adc/addArchivesFile.do" method="post">
  <html:hidden property="archivesFile.is_private"/>
  <html:hidden property="operName"/>
  <html:hidden property="archivesFile.archives_id"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="76" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="10" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="849" align="left" bgcolor="#FFFFFF"> 您现在的位置： &gt;&gt; 档案采集 &gt;&gt; 文件著录(文书类)</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">文件著录信息</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td height="355" background="../image/2_table_c_r.gif">&nbsp;</td>
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
            <td width="25%" nowrap>文件题名<font color=red>*</font></td>
            <td colspan="3" nowrap><html:textarea property="archivesFile.file_title" cols="60" rows="2"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件编号<font color=red>*</font></td>
            <td width="27%" nowrap><html:text property="archivesFile.file_num" size="24" maxlength="20"/>
            </td>
            <td width="17%" nowrap>责任者</td>
            <td width="31%" nowrap><html:text property="archivesFile.file_duty" size="24" maxlength="100"/>
            </td>
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
            <td nowrap><html:select property="archivesFile.secret_id">
            <html:optionsCollection property="secret_idOptions"/>
            </html:select></td>
            <td nowrap>保管期限</td>
            <td nowrap><html:select property="archivesFile.file_store_term">
            <html:optionsCollection property="file_store_termOptions"/>
            </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>载体类型</td>
            <td nowrap> <html:select property="archivesFile.media_type">
            <html:optionsCollection property="media_typeOptions"/>
            </html:select></td>
            <td nowrap>载体规格</td>
            <td nowrap><html:select property="archivesFile.file_spec">
            <html:optionsCollection property="file_specOptions"/>
            </html:select></td>
          </tr>
          <!--
          <tr bgcolor="#FFFFFF">
            <td nowrap>附件题名</td>
            <td colspan="3" nowrap><html:text property="archivesFile.file_pathName" size="50" maxlength="100"/></td>
          </tr>-->
          <tr bgcolor="#FFFFFF">
            <td nowrap>主题词</td>
            <td colspan="3" nowrap><html:text property="archivesFile.file_keywords" size="50" maxlength="50"/>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件份数</td>
            <td nowrap><html:text property="archivesFile.file_count" size="10" maxlength="9"/></td>
            <td nowrap>稿本类型</td>
            <td nowrap>
              <html:select property="archivesFile.file_type">
            <html:optionsCollection property="file_typeOptions"/>
            </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>备注</td>
            <td colspan="3" nowrap> <html:textarea property="archivesFile.remark" cols="60" rows="4"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>是否限制件</td>
            <td nowrap>
		<logic:equal name="ArchivesFileForm" property="archivesFile.is_private" value="1">
		<input type="radio" name="isPrivate" value="1" checked>是
		<input type="radio" name="isPrivate" value="0">否
		</logic:equal>
		<logic:notEqual name="ArchivesFileForm" property="archivesFile.is_private" value="1">
		<input type="radio" name="isPrivate" value="1">是
		<input type="radio" name="isPrivate" value="0" checked>否
		</logic:notEqual>
            </td>
            <td nowrap>&nbsp;</td>
            <td nowrap>&nbsp;</td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="4" nowrap><strong>收文信息</strong></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>收文时间</td>
            <td nowrap><html:text property="archivesFile.file_get_date" size="24"/></td>
            <td nowrap>主（抄）送</td>
            <td nowrap><html:text property="archivesFile.file_get_forward" size="24" maxlength="100"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>收件人</td>
            <td nowrap><html:text property="archivesFile.file_get_person" size="24" maxlength="10"/></td>
            <td nowrap>&nbsp;</td>
            <td nowrap>&nbsp;</td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="4" nowrap><strong>发文信息</strong></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>主送单位</td>
            <td colspan="3" nowrap><html:text property="archivesFile.file_to_unit" size="50" maxlength="100"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>抄送单位</td>
            <td colspan="3" nowrap><html:text property="archivesFile.file_to_forward" size="50" maxlength="100"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>拟稿人</td>
            <td nowrap><html:text property="archivesFile.file_to_createby" size="24" maxlength="10"/></td>
            <td nowrap>签发人</td>
            <td nowrap><html:text property="archivesFile.file_to_signby" size="24" maxlength="10"/></td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td colspan="4" nowrap>
		<input type="button" name="Submit2" value="确定" onclick="doSubmit(this.form);">
		<input type="reset" name="Submit3" value="取消" onclick="window.history.go(-1)"></td>
          </tr>
        </table>

        <br>      </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
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
