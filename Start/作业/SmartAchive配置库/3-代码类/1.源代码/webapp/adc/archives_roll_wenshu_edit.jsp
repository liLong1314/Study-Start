<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>案卷著录</title>
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
	//检查
	function doCheck(theform){
		var operName = document.getElementById("operName");
		if(validateCheck()){
			operName.value="CHECK_ACTION";
			theform.submit();
		}
	}
	//表单提交
	function doSubmit(theform){
		var operName = document.getElementById("operName");
		if(validateCheck() && validateForm(theform)){
			operName.value="SUBMIT_ACTION";
			theform.submit();
		}
	}
	//验证档号相关
	function validateCheck(){
		var FONDS_NUM = document.getElementById("archives.AFONDS_NUM");
		var CATALOG_NUM = document.getElementById("archives.ACATALOG_NUM");
		var ROLL_NUM = document.getElementById("archives.AROLL_NUM");
		if(BASEtrim(FONDS_NUM.value)==""){
			return BASEalert("请输入[全宗号]",FONDS_NUM);
		}if(BASEtrim(CATALOG_NUM.value)==""){
			return BASEalert("请输入[目录号]",CATALOG_NUM);
		}if(BASEtrim(ROLL_NUM.value)==""){
			return BASEalert("请输入[案卷号]",ROLL_NUM);
		}
		return true;
	}
	//验证表单
	function validateForm(theform){
		var AARCHIVES_NAME = document.getElementById("archives.AARCHIVES_NAME");
		var AARCHIVES_ROOM_CODE = document.getElementById("archives.AARCHIVES_ROOM_CODE");
		var ABEGIN_DATE = document.getElementById("archives.ABEGIN_DATE");
		var AEND_DATE = document.getElementById("archives.AEND_DATE");
		var AARCHIVES_YEAR = document.getElementById("archives.AARCHIVES_YEAR");
		var APAGE_AMOUNT = document.getElementById("archives.APAGE_AMOUNT");
		var AARCHIVES_FOUND_UNIT = document.getElementById("archives.AARCHIVES_FOUND_UNIT");
		var AREG_NUM = document.getElementById("archives.AREG_NUM");
		var AARCHIVES_AMOUNT = document.getElementById("archives.AARCHIVES_AMOUNT");
		var AARCHIVES_FOUND_MAN = document.getElementById("archives.AARCHIVES_FOUND_MAN");
		var AARCHIVES_FOUND_DATE = document.getElementById("archives.AARCHIVES_FOUND_DATE");
		var AARC_NUM = document.getElementById("archives.AARC_NUM");
		if(BASEtrim(AARCHIVES_NAME.value)=="")
			return BASEalert("请输入正确的[案卷题名]！",AARCHIVES_NAME);
		//if(BASEtrim(AARCHIVES_ROOM_CODE.value)=="")
		//	return BASEalert("请输入正确的[档案馆代码]！",AARCHIVES_ROOM_CODE);
		//if(BASEtrim(ABEGIN_DATE.value)!="")
		//	return BASEalert("请输入正确的[文件起止时间]！",ABEGIN_DATE);
		//if(BASEtrim(AEND_DATE.value)!="")
		//	return BASEalert("请输入正确的[文件起止时间]！",AEND_DATE);
		if(BASEisNotNum(AARCHIVES_YEAR.value) || (AARCHIVES_YEAR.value.length!=4))
			return BASEalert("请输入正确的[档案年度]！",AARCHIVES_YEAR);
		if(BASEtrim(APAGE_AMOUNT.value)!="" && BASEisNotNum(APAGE_AMOUNT.value))
			return BASEalert("请输入正确的[页数]！",APAGE_AMOUNT);
		if(BASEtrim(AARCHIVES_FOUND_UNIT.value)=="")
			return BASEalert("请输入正确的[立档单位]！",AARCHIVES_FOUND_UNIT);
		//if(BASEtrim(AREG_NUM.value)=="")
		//	return BASEalert("请输入正确的[总登记号]！",AREG_NUM);
		if(BASEtrim(AARCHIVES_AMOUNT.value)!="" && BASEisNotNum(AARCHIVES_AMOUNT.value))
			return BASEalert("请输入正确的[数量]！",AARCHIVES_AMOUNT);
		if(BASEtrim(AARCHIVES_FOUND_MAN.value)=="")
			return BASEalert("请输入正确的[立卷人]！",AARCHIVES_FOUND_MAN);
		if(BASEtrim(AARCHIVES_FOUND_DATE.value)=="")
			return BASEalert("请输入正确的[立卷时间]！",AARCHIVES_FOUND_DATE);
		//if(BASEtrim(AARC_NUM.value)=="")
		//	return BASEalert("请输入正确的[归档号]！",AARC_NUM);

		//同步是否限制件
		var IsPrivate = document.getElementById("archives.AIS_PRIVATE");
		var private = document.all("isPrivate");
		for(var i=0;i<private.length;i++){
                	if (private[i].checked) IsPrivate.value = private[i].value;
		}
		return true;
	}
	function doQuery(){
		window.location="archives_roll_query_for_edit.jsp";
	}
</script>
</head>
<body class="bg-page01">
<html:form action="/adc/updateRollArchives.do" method="post">
  <html:hidden property="archives.AENTRY_ID"/>
  <html:hidden property="archives.AIS_OPERATION"/>
  <html:hidden property="archives.AROLL_MODE"/>
  <html:hidden property="archives.AARCHIVES_STATUS"/>
  <html:hidden property="archives.AARCHIVES_ID"/>
  <html:hidden property="archives.AIS_PRIVATE"/>
  <html:hidden property="operName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="28" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="6" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="454" align="left" bgcolor="#FFFFFF"> 您现在的位置： &gt;&gt; 档案采集 &gt;&gt; 案卷著录</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">案卷著录信息[文书类]</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><table width="95%" border="1">
          <tr>
            <td>
		<logic:notEmpty name="ArchivesForm" property="msgError">
		<b><font color=red>很抱歉，过程中发生错误！点击<a href="#" style="color:blue" onclick="var obj=document.all('err');if(obj.style.display=='none') {obj.style.display='block'} else{obj.style.display='none'}">此处</a>查看详细信息</font></b>
		<span id=err style="display:none"><bean:write name="ArchivesForm" property="msgError"/></span>
          	</logic:notEmpty>
		<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td width="25%" nowrap>全宗号<font color=red>*</font></td>
                  <td width="27%" nowrap><html:text property="archives.AFONDS_NUM" size="4" readonly="true"/></td>
                  <td width="27%" nowrap>目录号<font color=red>*</font></td>
                  <td width="27%" nowrap><html:text property="archives.ACATALOG_NUM" size="8"/>
                  </td>
                  <td width="17%" nowrap>案卷号<font color=red>*</font></td>
                  <td width="31%" nowrap><html:text property="archives.AROLL_NUM" size="9"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td colspan="6" nowrap>
			<input type="button" name="Submit" value="检查合法性" onClick="doCheck(this.form);">
                    	<strong>
			<bean:write property="msgArchivesNumCheck" name="ArchivesForm"/>
			</strong>
		  </td>
                </tr>
              </table></td>
          </tr>
        </table>
        <br>
        <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td width="25%" nowrap>案卷题名<font color=red>*</font></td>
            <td colspan="3" nowrap><html:textarea property="archives.AARCHIVES_NAME" cols="60" rows="2"/></td>
          </tr>
        <tr bgcolor="#FFFFFF">
            <td nowrap>文件密级</td>
            <td nowrap colspan="3">
		<html:select property="archives.ASECRET_ID">
		<html:optionsCollection property="secret_idOptions"/>
		</html:select>
            </td>
        </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>档案馆代码</td>
            <td width="27%" nowrap><html:text property="archives.AARCHIVES_ROOM_CODE" size="20"/></td>
            <td width="17%" nowrap>文件起止时间</td>
            <td width="31%" nowrap><html:text property="archives.ABEGIN_DATE" size="10"/>-<html:text property="archives.AEND_DATE" size="10"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>档案年度(YYYY)<font color=red>*</font></td>
            <td nowrap><html:text property="archives.AARCHIVES_YEAR" size="20"/>
            </td>
            <td nowrap>页数</td>
            <td nowrap><html:text property="archives.APAGE_AMOUNT" size="20"/>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>立档单位<font color=red>*</font></td>
            <td nowrap><html:select property="archives.AARCHIVES_FOUND_UNIT">
            <html:optionsCollection property="AARCHIVES_FOUND_UNITOptions"/>
            </html:select></td>
            <td nowrap>是否限制件<font color=red>*</font></td>
            <td nowrap>
		<logic:notEmpty name="ArchivesForm" property="archives.AIS_PRIVATE">
		<logic:equal name="ArchivesForm" property="archives.AIS_PRIVATE" value="1">
		<input type="radio" name="isPrivate" value="1" checked>是
		<input type="radio" name="isPrivate" value="0">否
		</logic:equal>
		<logic:notEqual name="ArchivesForm" property="archives.AIS_PRIVATE" value="1">
		<input type="radio" name="isPrivate" value="1">是
		<input type="radio" name="isPrivate" value="0" checked>否
		</logic:notEqual>
		</logic:notEmpty>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>总登记号</td>
            <td nowrap><html:text property="archives.AREG_NUM" size="20"/></td>
            <td nowrap>单位</td>
            <td nowrap><html:select property="archives.AARCHIVES_UNIT">
            <html:optionsCollection property="AARCHIVES_UNITOptions"/>
            </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>载体类型<font color=red>*</font></td>
            <td nowrap><html:select property="archives.AMEDIA_TYPE">
            <html:optionsCollection property="AMEDIA_TYPEOptions"/>
            </html:select></td>
            <td nowrap>规格</td>
            <td nowrap><html:select property="archives.ASPECIFICATION">
            <html:optionsCollection property="ASPECIFICATIONOptions"/>
            </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>保管期限<font color=red>*</font></td>
            <td nowrap><html:select property="archives.ASTORE_TERM">
            <html:optionsCollection property="ASTORE_TERMOptions"/>
            </html:select></td>
            <td nowrap>数量</td>
            <td nowrap><html:text property="archives.AARCHIVES_AMOUNT" size="20"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>立卷人<font color=red>*</font></td>
            <td nowrap><html:text property="archives.AARCHIVES_FOUND_MAN" size="20"/></td>
            <td nowrap>立卷时间<font color=red>*</font></td>
            <td nowrap><html:text property="archives.AARCHIVES_FOUND_DATE" size="20"/></td>
          </tr>
          <!--
          <tr bgcolor="#FFFFFF">
            <td nowrap>存放地址</td>
            <td colspan="3" nowrap>
		<html:select property="archives.ACONTAINER_ID">
            		<html:optionsCollection property="ACONTAINER_IDOptions"/>
            	</html:select></td>
          </tr>
          -->
          <tr bgcolor="#FFFFFF">
            <td nowrap>归档号</td>
            <td nowrap colspan=3><html:text property="archives.AARC_NUM" size="20"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>备注</td>
            <td colspan="3"><html:textarea property="archives.AREMARK" cols="60" rows="4"/></td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td colspan="4">
		<input type="button" name="Submit1" value="确定" onclick="doSubmit(this.form);">
              	<input type="button" name="Submit3" value="返回" onclick="window.location.href='/adc/queryArchivesRollList.do?page='">
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
</html:form>
</body>
</html>

