<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>数据字典管理</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style></head>
<script>
function doConfirm(){
	if(confirm("你确认删除吗？"))
	{

	}
}
function gotoPage(pageIndex) {
	location = "?page=" + pageIndex;
}
</script>
<body class="bg-page01">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>
                  <td align="center" bgcolor="#E4F7FA" class="tishi">主题词管理查询</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="3%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
	    <html:form method="post" action="/smm/searchTheme.do">
		<html:hidden property="search" value="true"/>
	    <table width="100%" border="0">
          <tr bgcolor="#f6f6f6">
            <td>主题词名</td>
            <td><html:text property="themeInfo.themeName" size="12"/></td>
            <td>主题词代码</td>
            <td><html:text property="themeInfo.themeCode" size="12"/></td>
            <td>主题词信息</td>
            <td><html:text property="themeInfo.themeMessage" size="12"/></td>
            <td align="center"><input type="submit" name="Submit" value="查询"></td>
          </tr>
        </table>
		</html:form>
        <br>
      </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif">&nbsp;</td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>
                  <td align="center" bgcolor="#E4F7FA" class="tishi">主题词信息列表</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="3%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
	  <logic:present name="Themes"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td bgcolor="#F7EED9"> 
			<logic:notEqual name="Themes" property="firstPage" value="true" > 
              <a href="?page=first">&lt;&lt; 第一页</a> <a href="?page=previous">&lt; 上一页</a> 
            </logic:notEqual> 
			<logic:notEqual name="Themes" property="lastPage" value="true" > 
              <a href="?page=next">下一页 &gt;</a> <a href="?page=last">最后页 &gt;&gt;</a> 
            </logic:notEqual>&nbsp; 
			共<bean:write name="Themes" property="rowAmount" />条记录&nbsp; 
            当前第<input name="text" type="text" onChange="javascript:gotoPage(this.value)" size="3" value="<bean:write name="Themes" property="pageIndex"/>" > /<bean:write name="Themes" property="pageAmount" /> 页&nbsp; 
			每页<bean:write name="Themes" property="pageSize" />条
		  </td>
        </tr>
      </table>
      </logic:present>
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td>序号</td>
            <td>主题词名</td>
            <td>主题词信息</td>
            <td>主题词代码</td>
            <td>备注</td>
            <td width="13%" bgcolor="#F7EED9">操作</td>
          </tr>
          <logic:present name="Themes">
          <logic:iterate id="theme" name="Themes" >
          <tr align="center">
            <td bgcolor="#f6f6f6"><bean:write name="theme" property="themeId"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="theme" property="themeName"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="theme" property="themeMessage"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="theme" property="themeCode"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="theme" property="remark"/></td>
            <td bgcolor="#f6f6f6"><a href="/smm/thememodview.do?themeId=<bean:write name="theme" property="themeId"/>"> 修改</a> <a href="/smm/ThemeDel.do?themeId=<bean:write name="theme" property="themeId"/>"> 删除</a></td>
          </tr>
	  </logic:iterate>
          </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="36%" bgcolor="#F7EED9">&nbsp;</td>
            <td width="9%" bgcolor="#F7EED9"><input type="button" name="Submit"onclick="window.location='themeadd.jsp'" value="增加主题词"></td>
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
</body>
<html>
