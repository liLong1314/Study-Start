<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ page import="java.lang.*" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>监督检查管理</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style></head>
<body class="bg-page01">
<script>
	function doChange(obj){
		window.location.href=obj.options[obj.selectedIndex].url;
	}
function gotoPage(pageIndex) {
  location = "?page=" + pageIndex;
}
</script>
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
    <td width="653" align="left" bgcolor="#FFFFFF"> 您现在的位置： &gt;&gt; 档案管理 &gt;&gt;
      档案信息管理 &gt;&gt; 监督检查管理</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">监督检查管理</td>
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
         <html:form action="/arm/queryWatchExamineList.do" method="post">
          <tr>

          <td height="39" nowrap>
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr align="center" bgcolor="#FFFFFF">
                <td align="center">分局名称</td>
                <td>
		<html:select property="watchExamineInfo.subCode">
		<html:optionsCollection property="subCodeOptions"/>
		</html:select>
		</td>
                <td width="15%">主题</td>
                <td width="20%"><html:text property="watchExamineInfo.watchTitle" size="20"/></td>
                <td width="10%" rowspan="2"><input type="Submit" name="Submit" value="查询"/></td>
              </tr>
              <tr align="center" bgcolor="#FFFFFF">
                <td width="15%" align="center">报告时间 </td>
                <td width="15%">从<html:text property="watchExamineInfo.watchTimeFrom" size="20"/>到<html:text property="watchExamineInfo.watchTimeTo" size="20"/></td>
                <td width="15%">报告人</td>
                <td width="20%"><html:text property="watchExamineInfo.watchAuthor" size="20"/></td>
              </tr></html:form>
            </table></td>
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
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">监督检查管理信息</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" valign="top" bgcolor="#FFFFFF"><br>
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td>分局名称</td>
            <td bgcolor="#F7EED9">主题</td>
            <td bgcolor="#F7EED9">报告时间</td>
            <td>报告人</td>
            <td>是否已批示</td>
            <td>操作</td>
          </tr>
         <logic:present name="watchExamineList">
          <logic:iterate id="watchExamine" name="watchExamineList" >
          <tr align="center">
            <td bgcolor="#f6f6f6"><bean:write name="watchExamine" property="subCode"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="watchExamine" property="watchTitle"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="watchExamine" property="watchTime"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="watchExamine" property="watchAuthor"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="watchExamine" property="refWatchId"/></td>
            <td bgcolor="#f6f6f6"><a href="/arm/watchExamineView.do?watchId=<bean:write name="watchExamine" property="watchId"/>">查看内容</a></td>
            <td bgcolor="#f6f6f6">
            </td>
          </tr>
	  </logic:iterate>
          <logic:notEqual name="watchExamineList" property="firstPage" value="true" >
				<a href="?page=first">&lt;&lt; 第一页</a>
				<a href="?page=previous">&lt;&lt; 上一页</a>
			</logic:notEqual>
			<logic:notEqual name="watchExamineList" property="lastPage" value="true" >
				<a href="?page=next">下一页 &gt;&gt;</a>
				<a href="?page=last">最后页 &gt;&gt;</a>
			</logic:notEqual>
			共有<bean:write name="watchExamineList" property="rowAmount" />条记录&nbsp;
			分为<bean:write name="watchExamineList" property="pageAmount" />页&nbsp;
			每页<bean:write name="watchExamineList" property="pageSize" />条&nbsp;
			当前第<input type="text" size="1" value="<bean:write name="watchExamineList" property="pageIndex" />" onChange="javascript:gotoPage(this.value)" />页
          </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
           <td width="9%" bgcolor="#F7EED9"><div align="center">
               <input type="Submit" name="Submit" onclick="window.location='/arm/viewallwatchsubrollcatalog.do'"value="查看分局目录">
              </div></td>
          </tr>
       </table>
        <br>
      </td>
      <td background="../image/2_table_c_l.gif"><img src="../image/2_table_c_l.gif" width="26" height="138"></td>
     </td>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</body>
</html>
