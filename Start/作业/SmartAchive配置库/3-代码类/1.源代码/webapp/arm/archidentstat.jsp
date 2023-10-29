<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<html:html>
<head>
<title>鉴定统计</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
<script>
function doChange(obj){
	window.location.href=obj.options[obj.selectedIndex].url;
	}
        function gotoPage(pageIndex) {
  location = "?page=" + pageIndex;
}
</script>

</style></head>
<body class="bg-page01">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="39"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="50" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>

    <td width="620" align="left" bgcolor="#FFFFFF"> 您现在的位置：<a href="/arm/ArchView.do?flag=2">鉴定管理</a> &gt;&gt; 鉴定统计</td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">鉴定统计查询</td>
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
           <html:form action="/arm/queryIdentifyList" method="post">
            <tr>
              <td height="39">
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr bgcolor="#FFFFFF">
                <td width="20%">鉴定时间：</td>
                <td colspan="3"> 从
                  <html:text property="identifyInfo.checkupDateFrom" size="10"/>
                  到
                  <html:text property="identifyInfo.checkupDateTo" size="10"/>
                </td>
                <td rowspan="2">
                  <input type="Submit" name="Submit" value="查询">
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td width="20%">鉴定人：</td>
                <td width="20%">
                  <html:text property="identifyInfo.checkupOperator" size="8"/>
                </td>
                <td width="20%">鉴定情况：</td>
                <td width="20%">
                  <html:text property="identifyInfo.checkupSituation" size="8"/>
                </td>
              </tr>
              </html:form>
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
                <td align="center" bgcolor="#E4F2FA" class="tishi">档案鉴定信息</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
    <td align="center" bgcolor="#FFFFFF" valign="top">
    <logic:present name="Identifys">
<!--    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="Identifys" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            第一页 </a><a href="?page=previous">&lt;
            上一页 </a></logic:notEqual> <logic:notEqual name="Identifys" property="lastPage" value="true" >
            <a href="?page=next">下一页
            &gt; </a><a href="?page=last">最后页
            &gt;&gt; </a></logic:notEqual>&nbsp; 共<bean:write name="Identifys" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" value="<bean:write name="Identifys" property="pageIndex" />" onChange="javascript:gotoPage(this.value)">
            /<bean:write name="Identifys" property="pageAmount" />
            页&nbsp; 每页<bean:write name="Identifys" property="pageSize" />条</td>
        </tr>
      </table>
-->      </logic:present>
      <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
          <td>鉴定文件编号</td>
            <td>鉴定人</td>
            <td>鉴定情况</td>
            <td>鉴定时间</td>
            <td>说明</td>
          </tr>
          <logic:present name="Identifys">
          <logic:iterate id="identify" name="Identifys">
          <tr align="center">
            <td bgcolor="#f6f6f6"><bean:write name="identify" property="fileId"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="identify" property="checkupOperator"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="identify" property="checkupSituation"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="identify" property="checkupDate"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="identify" property="remark"/></td>
          </tr>
          </logic:iterate>
          <logic:notEqual name="Identifys" property="firstPage" value="true" >
				<a href="?page=first">&lt;&lt; 第一页</a>
				<a href="?page=previous">&lt;&lt; 上一页</a>
			</logic:notEqual>
			<logic:notEqual name="Identifys" property="lastPage" value="true" >
				<a href="?page=next">下一页 &gt;&gt;</a>
				<a href="?page=last">最后页 &gt;&gt;</a>
			</logic:notEqual>
			共有<bean:write name="Identifys" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" value="<bean:write name="Identifys" property="pageIndex" />" onChange="javascript:PageTo(this)">
			分为<bean:write name="Identifys" property="pageAmount" />页&nbsp;
			每页<bean:write name="Identifys" property="pageSize" />条&nbsp;

          </logic:present>
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
