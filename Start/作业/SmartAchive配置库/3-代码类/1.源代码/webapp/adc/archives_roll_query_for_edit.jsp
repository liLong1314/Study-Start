<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>档案查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
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
<!--

function doChangeMode(){
	var objMode = document.getElementById("archives.AROLL_MODE");
	var mode  = document.all("roll_mode");
	var span1 = document.all("Mode1");
	var span2 = document.all("Mode2");
	var iMode;
	for(var i=0;i<mode.length;i++){
		//alert(mode[i].checked);
		if (mode[i].checked) iMode = mode[i].value;
	}
	//alert(iMode);
	if(iMode == "1"){
		//alert("按卷查询");
		for(var i=0;i<span1.length;i++){
			span1[i].style.display="block";
		}
		for(var i=0;i<span2.length;i++){
			span2[i].style.display="none";
		}
	}else if(iMode == "2"){
		//alert("按件查询");
		for(var i=0;i<span2.length;i++){
			span2[i].style.display="block";
		}
		for(var i=0;i<span1.length;i++){
			span1[i].style.display="none";
		}
	}
	objMode.value = iMode;
}

//查询
function doQuery(theform){
	theform.submit();
}

//查看选中档案文件
function doGoto(url){
	window.location=url;
}
-->
</script>
</head>
<body class="bg-page01">
<html:form action="/adc/queryArchivesRollList" method="post" >
  <html:hidden property="archives.AENTRY_ID"/>
  <html:hidden property="archives.AIS_OPERATION"/>
  <html:hidden property="archives.AARCHIVES_STATUS"/>
  <html:hidden property="archives.AROLL_MODE" value="1"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">档案查询</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br>
          <table width="100%" height="37" border="1">
            <tr>
            <td height="31">
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td nowrap>档号:</td>
                  <td nowrap><html:text property="archives.AARCHIVES_NUM" value="" size="10" maxlength="50"/></td>
                  <td nowrap id="Mode1">案卷题名:</td>
                  <td nowrap colspan=3><html:text property="archives.AARCHIVES_NAME" value="" size="40" maxlength="100"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td nowrap id="Mode1">目录号:</td>
                  <td nowrap id="Mode1"><html:text property="archives.ACATALOG_NUM" value="" size="10" maxlength="9"/></td>
                  <td nowrap id="Mode1">案卷号:</td>
                  <td nowrap id="Mode1"><html:text property="archives.AROLL_NUM" value="" size="10" maxlength="9"/></td>
                  <td align="center" nowrap colspan=2> <input type="button" name="btnQry" value="查询" onClick="doQuery(this.form)"></td>
                </tr>
              </table>
              </td>
            </tr>
        </table></td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">未归档档案列表</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="4%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="24"></td>

    <td align="center" bgcolor="#FFFFFF">
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <!--<td nowrap>案卷号</td>-->
          <td nowrap>档号</td>
          <td nowrap>案卷题名</td>
          <td nowrap>档案年度</td>
        </tr>
	<logic:notPresent name="archivesList">
	<tr align="center" bgcolor="#F7EED9">
          <td colspan=5>暂无记录</td>
        </tr>
	</logic:notPresent>
	<logic:present name="archivesList">
	<logic:iterate id="list" name="archivesList" >
        <tr align="center" style='cursor:hand' onMouseover="this.style.backgroundColor='#dff1ff'" onMouseOut="this.style.backgroundColor=''" onclick="doGoto('viewArchives.do?ARCHIVES_ID=<bean:write name='list' property='AARCHIVES_ID' />')">
          <!--<td><bean:write name="list" property="AROLL_NUM" /></td>-->
          <td nowrap><bean:write name="list" property="AARCHIVES_NUM" /></td>
          <td><bean:write name="list" property="AARCHIVES_NAME" /></td>
          <td><bean:write name="list" property="AARCHIVES_YEAR" /></td>
        </tr>
	</logic:iterate>
	</logic:present>
      </table>

      <logic:present name="archivesList">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="archivesList" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            第一页 </a><a href="?page=previous">&lt;
            上一页 </a></logic:notEqual> <logic:notEqual name="archivesList" property="lastPage" value="true" >
            <a href="?page=next">下一页
            &gt; </a><a href="?page=last">最后页
            &gt;&gt; </a></logic:notEqual>&nbsp; 共<bean:write name="archivesList" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" value="<bean:write name="archivesList" property="pageIndex" />" onChange="javascript:PageTo(this)">
            /<bean:write name="archivesList" property="pageAmount" />
            页&nbsp; 每页<bean:write name="archivesList" property="pageSize" />条</td>
        </tr>
      </table>
      </logic:present>

      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" bgcolor="#F7EED9"> <p>
              <input type="button" name="Submit3" value="打印" onclick="window.print()">
              <input type="button" name="Submit4" value="返回" onclick="window.location='/adc/archives_roll_yewu_input.jsp'">
            </p></td>
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
