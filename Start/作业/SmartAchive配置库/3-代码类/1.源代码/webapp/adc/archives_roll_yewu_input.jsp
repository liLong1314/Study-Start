<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>案卷著录</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
</head>
<body class="bg-page01">
<script language="javascript">
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
	function validateCheck(){
		var AARCHIVES_NUM = document.getElementById("archives.AARCHIVES_NUM");
		var AROLL_NUM = document.getElementById("archives.AROLL_NUM");
		var a = BASEtrim(AARCHIVES_NUM.value);
		var b = BASEtrim(AROLL_NUM.value);
		//alert(b.substring(b.lastIndexOf("-")+1,b.length));
		if(a==""){
			return BASEalert("请输入[档号]",AARCHIVES_NUM);
		}
		/*if(b==""){
			return BASEalert("请输入[案卷号]",AROLL_NUM);
		}if(b!=a.substring(a.lastIndexOf("-")+1,a.length)){
			return BASEalert("[档号]的顺序号必须与[案卷号]一致",AARCHIVES_NUM);
		}*/
		return true;
	}
	//验证表单
	function validateForm(theform){
		var AARCHIVES_YEAR = document.getElementById("archives.AARCHIVES_YEAR");
		var AARCHIVES_NAME = document.getElementById("archives.AARCHIVES_NAME");
		var AARCHIVES_MAKE_PERIOD = document.getElementById("archives.AARCHIVES_MAKE_PERIOD");
		var AARCHIVES_AMOUNT = document.getElementById("archives.AARCHIVES_AMOUNT");
		var APAGE_AMOUNT = document.getElementById("archives.APAGE_AMOUNT");
		var APAGE_NUM_FROM_TO = document.getElementById("archives.APAGE_NUM_FROM_TO");
		var AARCHIVES_FOUND_MAN = document.getElementById("archives.AARCHIVES_FOUND_MAN");
		var AARCHIVES_FOUND_DATE = document.getElementById("archives.AARCHIVES_FOUND_DATE");
		var AROLL_AMOUNT = document.getElementById("archives.AROLL_AMOUNT");
		var AROLL_SEQ = document.getElementById("archives.AROLL_SEQ");
		var AARC_NUM = document.getElementById("archives.AARC_NUM");
		var AARC_DATE = document.getElementById("archives.AARC_DATE");
		var APROJ_ID = document.getElementById("archives.APROJ_ID");
		var APROJ_NAME = document.getElementById("archives.APROJ_NAME");

		if(BASEisNotNum(AARCHIVES_YEAR.value) || (AARCHIVES_YEAR.value.length!=4))
			return BASEalert("请输入正确的[年度]！",AARCHIVES_YEAR);
		if(BASEtrim(AARCHIVES_NAME.value)=="")
			return BASEalert("请输入[案卷题名]！",AARCHIVES_NAME);
		//if(BASEtrim(AARCHIVES_MAKE_PERIOD.value)=="" || BASEisNotDate(AARCHIVES_MAKE_PERIOD.value))
		//	return BASEalert("请输入正确的[编制日期]！",AARCHIVES_MAKE_PERIOD);
		if(BASEtrim(APAGE_AMOUNT.value)!="" && BASEisNotNum(APAGE_AMOUNT.value))
			return BASEalert("请输入正确的[页数]！",APAGE_AMOUNT);
		//if(BASEtrim(APAGE_NUM_FROM_TO.value)=="")
		//	return BASEalert("请输入正确的[起止页次]！",APAGE_NUM_FROM_TO);
		if(BASEtrim(AARCHIVES_AMOUNT.value)!="" && BASEisNotNum(AARCHIVES_AMOUNT.value))
			return BASEalert("请输入正确的[数量]！",AARCHIVES_AMOUNT);
		if(BASEtrim(AARCHIVES_FOUND_MAN.value)=="")
			return BASEalert("请输入正确的[立卷人]！",AARCHIVES_FOUND_MAN);
		if(BASEtrim(AARCHIVES_FOUND_DATE.value)=="")
			return BASEalert("请输入正确的[立卷时间]！",AARCHIVES_FOUND_DATE);
		if(BASEtrim(AROLL_AMOUNT.value)!="" && BASEisNotNum(AROLL_AMOUNT.value))
			return BASEalert("请输入正确的[卷数]！",AROLL_AMOUNT);
		if(BASEtrim(AROLL_SEQ.value)!="" && BASEisNotNum(AROLL_SEQ.value))
			return BASEalert("请输入正确的[卷数]！",AROLL_SEQ);
		//if(BASEtrim(AARC_NUM.value)=="")
		//	return BASEalert("请输入正确的[归档号]！",AARC_NUM);
		if(BASEtrim(AARC_DATE.value)=="")
			return BASEalert("请输入正确的[归档日期]！",AARC_DATE);
		if(BASEtrim(APROJ_ID.value)=="")
			return BASEalert("请输入[项目编号]！",APROJ_ID);
		if(BASEtrim(APROJ_NAME.value)=="")
			return BASEalert("请输入[项目名称]！",APROJ_NAME);
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
<html:form action="/adc/insertRoll.do" method="post">
  <html:hidden property="archives.AENTRY_ID"/>
  <html:hidden property="archives.AIS_OPERATION"/>
  <html:hidden property="archives.AROLL_MODE"/>
  <html:hidden property="archives.AARCHIVES_STATUS"/>
  <html:hidden property="archives.AIS_PRIVATE"/>
  <html:hidden property="archives.AROLL_NUM"/>
  <html:hidden property="operName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="73" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="10" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="836" align="left" bgcolor="#FFFFFF"> 您现在的位置： &gt;&gt; 档案采集 &gt;&gt;
        规划审批类 &gt;&gt; 案卷著录</td>
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
      <td width="1%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">案卷著录信息[业务类]</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="3%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF"><table width="95%" border="1">
          <tr>
            <td>
		<logic:notEmpty name="ArchivesForm" property="msgError">
		<b><font color=red>很抱歉，过程中发生错误！点击<a href="#" style="color:blue" onclick="var obj=document.all('err');if(obj.style.display=='none') {obj.style.display='block'} else{obj.style.display='none'}">此处</a>查看详细信息</font></b>
		<span id=err style="display:none"><bean:write name="ArchivesForm" property="msgError"/></span>
          	</logic:notEmpty>
		<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td nowrap>档号<font color=red>*</font></td>
                  <td nowrap colspan=3><html:text property="archives.AARCHIVES_NUM" size="35"/></td>
                  <!--
                  <td nowrap>案卷号<font color=red>*</font></td>
                  <td nowrap><html:text property="archives.AROLL_NUM" size="4"/></td>-->
                  <td nowrap>档案年度(YYYY)<font color=red>*</font></td>
                  <td nowrap><html:text property="archives.AARCHIVES_YEAR" size="4"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td nowrap>总登记号</td>
                  <td nowrap><html:text property="archives.AREG_NUM" size="14"/></td>
                  <td nowrap>缩微号</td>
                  <td nowrap><html:text property="archives.AREDUCE_NUM" size="12"/></td>
                  <td nowrap>档案馆代码</td>
                  <td nowrap><html:text property="archives.AARCHIVES_ROOM_CODE" size="12"/></td>
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
            <td nowrap>案卷题名<font color=red>*</font></td>
            <td colspan="3" nowrap>
		<html:textarea property="archives.AARCHIVES_NAME" cols="60" rows="2"/>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>立档单位<font color=red>*</font></td>
            <td nowrap colspan="3"><html:select property="archives.AARCHIVES_FOUND_UNIT">
            <html:optionsCollection property="AARCHIVES_FOUND_UNITOptions"/>
            </html:select></td>
	  </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>建设单位</td>
            <td nowrap><html:text property="archives.AARCHIVES_MAKE_UNIT" size="20"/>
            </td>
            <td nowrap>编制日期</td>
            <td nowrap><html:text property="archives.AARCHIVES_MAKE_PERIOD" size="20"/>
            </td>
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
            <td nowrap>是否限制件<font color=red>*</font></td>
            <td nowrap>
		<input type="radio" name="isPrivate" value="1">是
		<input type="radio" name="isPrivate" value="0" checked>否
            </td>
            <td nowrap>保管期限<font color=red>*</font></td>
            <td nowrap><html:select property="archives.ASTORE_TERM">
            <html:optionsCollection property="ASTORE_TERMOptions"/>
            </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>页数</td>
            <td nowrap><html:text property="archives.APAGE_AMOUNT" size="20"/></td>
            <td nowrap>文件起止页次</td>
            <td nowrap><html:text property="archives.APAGE_NUM_FROM_TO" size="20"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>数量</td>
            <td nowrap><html:text property="archives.AARCHIVES_AMOUNT" size="20"/></td>
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
            <td nowrap>立卷人<font color=red>*</font></td>
            <td nowrap><html:text property="archives.AARCHIVES_FOUND_MAN" size="20"/></td>
            <td nowrap>立卷时间<font color=red>*</font></td>
            <td nowrap><html:text property="archives.AARCHIVES_FOUND_DATE" size="20"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td height="21" nowrap>卷数</td>
            <td colspan="3" nowrap>共
              <html:text property="archives.AROLL_AMOUNT" size="4"/>
              卷　　　　　　 第
              <html:text property="archives.AROLL_SEQ" size="4"/>
              卷 </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>归档号</td>
            <td nowrap><html:text property="archives.AARC_NUM" size="20"/></td>
            <td nowrap>归档日期<font color=red>*</font></td>
            <td nowrap><html:text property="archives.AARC_DATE" size="20"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>项目编号<font color=red>*</font></td>
            <td colspan="3" nowrap><html:text property="archives.APROJ_ID" size="20"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>项目名称<font color=red>*</font></td>
            <td colspan="3" nowrap><html:text property="archives.APROJ_NAME" size="61"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>备注</td>
            <td colspan="3"><html:textarea property="archives.AREMARK" cols="60" rows="4"/></td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td colspan="4">
		<input type="button" name="Submit1" value="确定" onclick="doSubmit(this.form);">
              	<input type="reset" name="Submit3" value="取消">
              	<input type="button" name="Submit2" value="查询/修订本类目档案" onclick="doQuery(this.form);">
            </td>
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