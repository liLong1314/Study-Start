<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>分局目录管理</title>
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
      档案信息管理 &gt;&gt; <a href="/arm/viewallsubwatchexamine.do" target="hmain">分局工作汇报</a>&gt;&gt;分局目录管理</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">分局目录管理管理</td>
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
           <html:form action="/arm/querySubRollCatalogList.do" method="post">
          <tr>
            <td height="39"> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr align="center" bgcolor="#FFFFFF">
                  <td width="15%" align="center">分局名称
                   <html:select  property="subRollCatalogInfo.subCode">
                    <html:option value="8">上城规划分局</html:option>
                    <html:option value="9">下城规划分局</html:option>
                    <html:option value="11">江干规划分局</html:option>
                    <html:option value="12">拱墅规划分局</html:option>
                    <html:option value="10">西湖规划分局</html:option>
                 </html:select>
                </td>
                <td width="15%" rowspan="2">案卷题名 <html:text property="subRollCatalogInfo.rollCataTitle" size="8"/></td>
                <td width="15%" rowspan="2">归档号 <html:text property="subRollCatalogInfo.rollCataMegn" size="8"/></td>
                <td width="15%" rowspan="2">起止时间<html:text property="subRollCatalogInfo.rollCataDate" size="8"/> </td>
                <td width="15%"><input type="Submit" name="Submit" value="查询"/></td>
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
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">分局目录信息</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>

    <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
      <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td width="30%">分局名称</td>
          <td width="15%">案卷题名</td>
          <td width="5%">归档号</td>
          <td width="10%">起止时间</td>
          <td width="10%">保管期限</td>
          <td width="30%">备注</td>
        </tr>
        <logic:present name="SubRollCatalogs"> <logic:iterate id="subRollCatalog" name="SubRollCatalogs" >
        <tr align="center">
          <td width="30%" bgcolor="#f6f6f6"><bean:write name="subRollCatalog" property="subCode"/></td>
          <td width="15%" bgcolor="#f6f6f6"><bean:write name="subRollCatalog" property="rollCataTitle"/></td>
          <td width="5%" bgcolor="#f6f6f6"><bean:write name="subRollCatalog" property="rollCataMegn"/></td>
          <td width="10%" bgcolor="#f6f6f6"><bean:write name="subRollCatalog" property="rollCataDate"/></td>
          <td width="10%" bgcolor="#f6f6f6"><bean:write name="subRollCatalog" property="rollCataStor"/></td>
          <td width="30%" bgcolor="#f6f6f6"><bean:write name="subRollCatalog" property="remark"/></td>
        </tr>
        </logic:iterate>
       <logic:notEqual name="SubRollCatalogs" property="firstPage" value="true" >
				<a href="?page=first">&lt;&lt; 第一页</a>
				<a href="?page=previous">&lt;&lt; 上一页</a>
			</logic:notEqual>
			<logic:notEqual name="SubRollCatalogs" property="lastPage" value="true" >
				<a href="?page=next">下一页 &gt;&gt;</a>
				<a href="?page=last">最后页 &gt;&gt;</a>
			</logic:notEqual>
			共有<bean:write name="SubRollCatalogs" property="rowAmount" />条记录&nbsp;
			分为<bean:write name="SubRollCatalogs" property="pageAmount" />页&nbsp;
			每页<bean:write name="SubRollCatalogs" property="pageSize" />条&nbsp;
			当前第<input type="text" size="1" value="<bean:write name="SubRollCatalogs" property="pageIndex" />" onChange="javascript:gotoPage(this.value)" />页
       </logic:present>
      </table>
      <br>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="9%" bgcolor="#F7EED9"><div align="center">
                <input type="Submit" name="Submit" onclick="window.location='subRollCatalogAdd.jsp'"value="分局目录汇报">
              </div></td>
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
</body>
</html>
