<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>安全信息管理</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
function doConfirm(id){
	var tmp=confirm("您确认删除吗？");
	if(tmp)
	window.location="/arm/SafetyDel.do?safetyId=" + id;
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
    <td width="620" align="left" bgcolor="#FFFFFF"> 您现在的位置：安全管理</td>
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
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">安全管理</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br>
        <table width="95%" border="1">
          <tr>
            <td height="39">
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
            <html:form action="/arm/SafetySearch.do?flag=first" method="post">
              <tr align="center" bgcolor="#FFFFFF">
                <td rowspan="2">安全类型：</td>
                <td rowspan="2">
                  <html:select property="safetyInfo.safetyType">
                  <html:option value="">--全部--</html:option>
                  <html:option value="1">虫霉防治</html:option>
                  <html:option value="2">除尘管理</html:option>
                  <html:option value="3">防火管理</html:option>
                  <html:option value="4">防盗管理</html:option>
                  <html:option value="5">照明管理</html:option>
                  </html:select>
                </td>
                <td width="13%">情况描述：</td>
                <td width="13%">
                  <html:text property="safetyInfo.safetySituation" size="12"/>
                </td>
                <td width="13%">检查日期：</td>
                <td width="13%">
                  <html:text property="safetyInfo.safetyCheckDate" size="10"/>
                </td>
                <td rowspan="2">
                  <input type="submit" name="Submit" value="查询">
                </td>
              </tr>
              <tr align="center" bgcolor="#FFFFFF">
                <td width="13%">处理结果：</td>
                <td width="13%">
                  <html:text property="safetyInfo.safetyResult" size="12"/>
                </td>
                <td width="13%">处理日期：</td>
                <td width="13%">
                  <html:text property="safetyInfo.safetyDealedDate" size="10"/>
                </td>
              </tr>
              </html:form>
            </table>
          </td>
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
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">安全管理信息</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
    <td align="center" bgcolor="#FFFFFF" valign="top">
    <logic:present name="Safetys">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="Safetys" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            第一页 </a><a href="?page=previous">&lt;
            上一页 </a></logic:notEqual> <logic:notEqual name="Safetys" property="lastPage" value="true" >
            <a href="?page=next">下一页
            &gt; </a><a href="?page=last">最后页
            &gt;&gt; </a></logic:notEqual>&nbsp; 共<bean:write name="Safetys" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" value="<bean:write name="Safetys" property="pageIndex" />" onChange="javascript:gotoPage(this.value)">
            /<bean:write name="Safetys" property="pageAmount" />
            页&nbsp; 每页<bean:write name="Safetys" property="pageSize" />条</td>
        </tr>
      </table>
      </logic:present>
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td>库房</td>
            <td>安全类型</td>
            <td>情况描述</td>
            <td>检查人</td>
            <td>检查日期</td>
            <td>处理人</td>
            <td>处理日期</td>
            <td>处理结果</td>
            <td>说明</td>
            <td>操作</td>
          </tr>
          <logic:present name="Safetys">
          <logic:iterate id="safety" name="Safetys">
          <tr align="center">
            <td bgcolor="#f6f6f6"><bean:write name="safety" property="roomCode"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="safety" property="safetyType"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="safety" property="safetySituation"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="safety" property="safetyChecker"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="safety" property="safetyCheckDate"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="safety" property="safetyDealWithPerson"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="safety" property="safetyDealedDate"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="safety" property="safetyResult"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="safety" property="remark"/></td>
            <td bgcolor="#f6f6f6">
		<a href="/arm/SafetyModView.do?safetyId=<bean:write name="safety" property="safetyId"/>">修改</a>
		<a href="javascript:doConfirm(<bean:write name="safety" property="safetyId"/>)">删除</a>
            </td>
          </tr>
          </logic:iterate>
          </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
          <td width="9%" bgcolor="#F7EED9" align="right">
          <input type="button" name="Submit" onclick="window.location='/arm/safetyadd.jsp'" value="安全信息登记">
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
</body>
</html:html>