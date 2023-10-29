<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>建筑项目目录册</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
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
function doGoto(cataId){
	window.location.href="buidingCataLogView.do?cataId="+cataId;
}
</script>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="33"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="52" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="667" align="left" bgcolor="#FFFFFF"> 您现在的位置： &gt;&gt; 档案管理 &gt;&gt;
        全宗管理 &gt;&gt; 目录册管理</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">目录册管理</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center"    bgcolor="#FFFFFF"> <br> <table width="95%" border="1">
          <html:form action="/arm/queryBuildingCataLogList.do" method="post">
          <tr>
            <td height="39"> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr align="center" bgcolor="#FFFFFF">
                  <td width="19%" align="left"><select name=selParent onchange="doChange(this);">
                      <option selected value="1" url="/arm/viewAllbuildingCataLog.do" >建筑工程目录册</option>
                      <option value="2"url="/arm/viewAllotherCataLog.do" >杂项工程目录册</option>
                    </select></td>
                  <td width="9%" align="left" nowrap>建筑证号</td>
                  <td width="13%" align="left" nowrap>
 <html:text property="buildingCataLogInfo.cataCardNum" size="10"/></td>
                  <td width="9%" align="left" nowrap>建设单位</td>
                  <td width="13%" align="left" nowrap>
<html:text property="buildingCataLogInfo.cataUnit" size="10"/></td>
                  <td width="10%" align="left" nowrap>项目名称</td>
                  <td width="17%" align="left"><html:text property="buildingCataLogInfo.cataItem" size="18"/></td>
                  <td width="10%"><input type="Submit" name="Submit" value="查询"></td>
                </tr>
               </html:form>
              </table></td>
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
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">建筑工程目录册信息</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" valign="top"  bgcolor="#FFFFFF"><br>
        <table width="100%" height="0" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td>进件日期</td>
            <td>流水号（建号）</td>
            <td>建筑证号</td>
            <td>项目地址</td>
            <td>建筑面积</td>
            <td>柜号</td>
            <td>建设单位</td>
            <td>项目名称</td>
            <td>地形图号</td>
            <td>层数</td>
            <td>结构</td>
            <td >发证日期</td>
            <td >备注</td>
          </tr>
          <logic:present name="BuildingCataLogs">
          <logic:iterate id="buildingCataLog" name="BuildingCataLogs" >
          <tr align="center" style='cursor:hand' onMouseover="this.style.backgroundColor='#dff1ff'" onMouseOut="this.style.backgroundColor=''" onclick="doGoto('<bean:write name='buildingCataLog' property='cataId' />')">
            <td><bean:write name="buildingCataLog" property="cataBeginDate"/></td>
            <td><bean:write name="buildingCataLog" property="cataOrder"/></td>
            <td><bean:write name="buildingCataLog" property="cataCardNum"/></td>
            <td><bean:write name="buildingCataLog" property="cataAdress"/></td>
            <td><bean:write name="buildingCataLog" property="cataArea"/></td>
            <td><bean:write name="buildingCataLog" property="cataArkNum"/></td>
            <td><bean:write name="buildingCataLog" property="cataUnit"/></td>
            <td><bean:write name="buildingCataLog" property="cataItem"/></td>
            <td><bean:write name="buildingCataLog" property="cataMapNum"/></td>
            <td><bean:write name="buildingCataLog" property="cataLevel"/></td>
            <td><bean:write name="buildingCataLog" property="cataStruts"/></td>
            <td><bean:write name="buildingCataLog" property="cataEndData"/></td>
            <td><bean:write name="buildingCataLog" property="remark"/></td>
          </tr>
	  </logic:iterate>
          <logic:notEqual name="BuildingCataLogs" property="firstPage" value="true" >
				<a href="?page=first">&lt;&lt; 第一页</a>
				<a href="?page=previous">&lt;&lt; 上一页</a>
			</logic:notEqual>
			<logic:notEqual name="BuildingCataLogs" property="lastPage" value="true" >
				<a href="?page=next">下一页 &gt;&gt;</a>
				<a href="?page=last">最后页 &gt;&gt;</a>
			</logic:notEqual>
			共有<bean:write name="BuildingCataLogs" property="rowAmount" />条记录&nbsp;
			分为<bean:write name="BuildingCataLogs" property="pageAmount" />页&nbsp;
			每页<bean:write name="BuildingCataLogs" property="pageSize" />条&nbsp;
			当前第<input type="text" size="1" value="<bean:write name="BuildingCataLogs" property="pageIndex" />" onChange="javascript:gotoPage(this.value)" />页
          </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="9%" align="center" bgcolor="#F7EED9"><input name="Submit" type="button" onclick="window.print()" value="打印目录册">
            </td>
            <td width="6%" bgcolor="#F7EED9"><input type="button" name="Submit" onclick="window.location='buildingCataLogAdd.jsp'"value="增加"></td>
          </tr>
        </table>
        <br>
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
</html>

