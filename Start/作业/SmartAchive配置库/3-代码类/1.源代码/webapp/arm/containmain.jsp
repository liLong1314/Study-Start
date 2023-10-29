<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>密集架管理</title>
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
	window.location="/arm/ContainDel.do?containId=" + id;
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
    <td width="653" align="left" bgcolor="#FFFFFF"> 您现在的位置：密集架管理</td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">密集架管理</td>
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
		<html:form action="/arm/ContainSearch.do?flag=first" method="post">
                <tr align="center" bgcolor="#FFFFFF">
                  <td nowrap width="20%">库柜号：</td>
                  <td width="20%">
                    <html:text property="containInfo.containCode" size="10"/>
                  </td>
                  <td nowrap width="20%">层：</td>
                  <td width="20%">
                    <html:text property="containInfo.containRow" size="5"/>
                  </td>
                  <td rowspan="2">
                    <input type="submit" name="Submit" value="查询">
                  </td>
                </tr>
                <tr align="center" bgcolor="#FFFFFF">
                  <td width="20%">面：</td>
                  <td width="20%">
                  <html:select property="containInfo.containSide">
                  <html:option value="">--全部--</html:option>
                  <html:option value="左面">左面</html:option>
                  <html:option value="右面">右面</html:option>
                  </html:select>
                  <td width="20%" nowrap>格：</td>
                  <td width="20%">
                    <html:text property="containInfo.containColumn" size="5"/>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">密集架管理信息</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
    <td align="center" bgcolor="#FFFFFF" valign="top">
    <logic:present name="Contains">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="Contains" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            第一页 </a><a href="?page=previous">&lt;
            上一页 </a></logic:notEqual> <logic:notEqual name="Contains" property="lastPage" value="true" >
            <a href="?page=next">下一页
            &gt; </a><a href="?page=last">最后页
            &gt;&gt; </a></logic:notEqual>&nbsp; 共<bean:write name="Contains" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" value="<bean:write name="Contains" property="pageIndex" />" onChange="javascript:gotoPage(this.value)">
            /<bean:write name="Contains" property="pageAmount" />
            页&nbsp; 每页<bean:write name="Contains" property="pageSize" />条</td>
        </tr>
      </table>
      </logic:present>
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td>库房</td>
            <td>库柜号</td>
            <td>层</td>
            <td>格</td>
            <td>面</td>
            <td>操作</td>
          </tr>
          <logic:present name="Contains">
          <logic:iterate id="contains" name="Contains">
          <tr align="center">
            <td bgcolor="#f6f6f6"><bean:write name="contains" property="roomCode"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="contains" property="containCode"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="contains" property="containRow"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="contains" property="containColumn"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="contains" property="containSide"/></td>
            <td bgcolor="#f6f6f6">
		<a href="javascript:doConfirm(<bean:write name="contains" property="containId"/>)">删除</a>
            </td>
          </tr>
          </logic:iterate>
          </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
          <td width="9%" bgcolor="#F7EED9" align="right">
          <input type="button" name="Submit" value="密集架登记" onclick="window.location='/arm/containadd.jsp'">
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