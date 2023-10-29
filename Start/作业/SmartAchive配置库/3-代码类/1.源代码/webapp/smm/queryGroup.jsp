<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%
  String search = request.getParameter("search");
	if(search != null && search.equalsIgnoreCase("first")) {
	  session.removeAttribute("allGroupList");
	}
%>
<html:html>
<head>
<title>用户组查询</title>
<link href="../../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/delete.js"></script>
</head>
<body class="bg-page01">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>      
    <td width="4%" background="../image/2_table_l_t.gif">&nbsp;</td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>
                <td align="center" bgcolor="#E4F7FA" class="tishi">用户组查询</td>
                </tr>
              </table></td>
          </tr>
        </table></td>      
    <td width="2%" background="../image/2_table_r_t.gif">&nbsp;</td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
        <html:form action="/smm/queryGroup.do" method="post">
        <table width="95%" border="0">
          <tr>
            <td height="62"> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr bgcolor="#FFFFFF">
                <td width="19%">用户组名称</td>
                <td width="26%"><html:text size="20" name="groupForm" property="group.groupName"/></td>
                <td width="26%">用户组描述信息</td>
                <td width="29%"><html:text size="40" name="groupForm" property="group.description"/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td>&nbsp;</td>
                <td></td>
                <td>&nbsp;</td>
                <td><html:submit property="submit" value="查询"/></td>
              </tr>
            </table></td>
          </tr>
        </table>
        </html:form>
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
                  <td align="center" bgcolor="#E4F7FA" class="tishi">查询列表</td>
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
            <td width="5%"><input type="checkbox" name="checkbox11" value="checkbox" onClick="javascript:setCheckBoxes(allGroupList,this.checked)"></td>
            <td width="6%">序号</td>
            <td width="7%" bgcolor="#F7EED9">用户组名称</td>
            <td width="11%" bgcolor="#F7EED9">用户组描述信息</td>
            <td width="7%">创建时间</td>
            <td width="12%">最后修改时间</td>
          </tr>
        <form name="allGroupList">
		<logic:present name="allGroupList">
		<logic:iterate id="group" name="allGroupList" >
          <tr align="center">
            <td bgcolor="#f6f6f6"><input type="checkbox" name="checkbox" value="<bean:write name="group" property="groupID" />"></td>
            <td bgcolor="#f6f6f6"><bean:write name="group" property="groupID" /></td>
            <td bgcolor="#f6f6f6"><a href="../../smm/viewGroup.do?groupID=<bean:write name="group" property="groupID" />" style='cursor:hand' onMouseover="this.style.backgroundColor='#dff1ff'" onMouseOut="this.style.backgroundColor='#f6f6f6'"><bean:write name="group" property="groupName" /></a></td>
            <td bgcolor="#f6f6f6"><bean:write name="group" property="description" /></td>
            <td bgcolor="#f6f6f6"><bean:write name="group" property="creationDate" /></td>
            <td bgcolor="#f6f6f6"><bean:write name="group" property="modifiedDate" /></td>
          </tr>
		</logic:iterate>
		</logic:present>
		</form>
        </table>
        <logic:present name="allGroupList">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td bgcolor="#F7EED9">
              <logic:notEqual name="allGroupList" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt; 第一页</a> <a href="?page=previous">&lt; 上一页</a>
            </logic:notEqual> <logic:notEqual name="allGroupList" property="lastPage" value="true" >
            <a href="?page=next">下一页 &gt;</a> <a href="?page=last">最后页 &gt;&gt;</a>
            </logic:notEqual>&nbsp; 共<bean:write name="allGroupList" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" onChange="javascript:gotoPage(this.value)" value="<bean:write name="allGroupList" property="pageIndex" />" >
						/<bean:write name="allGroupList" property="pageAmount" /> 页&nbsp;
						每页<bean:write name="allGroupList" property="pageSize" />条</td>
          </tr>
        </table>
        </logic:present>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <form name="delform" method="post" action="../../smm/deleteGroup.do" onSubmit="return delConfirm(allGroupList,this.groupID)">
            <td width="13%" align="center" bgcolor="#F7EED9">
              <input type="hidden" name="groupID">
              <input type="submit" name="delete" value="删除选中" alt="删除选中"></td>
            </form>
            <td width="65%" bgcolor="#F7EED9"><input type="button" name="addUser" value="新增组" onClick="javascript:location='/smm/newGroup.jsp'"></td>
            <td width="12%" align="center" bgcolor="#F7EED9">
            </td>
            <td width="65%" bgcolor="#F7EED9">&nbsp;</td>
          </tr>
        </table>
      </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif">&nbsp;</td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</body>
</html:html>
