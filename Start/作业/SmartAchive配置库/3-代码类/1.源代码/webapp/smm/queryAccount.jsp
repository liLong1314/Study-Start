<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ page import="com.ibatis.common.util.PaginatedList"%>
<html:html>
<head>
<title>用户查询</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/delete.js"></script>
</head>
<body class="bg-page01">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr nowrap >
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr nowrap  align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr nowrap >
                  <td align="center" bgcolor="#E4F7FA" class="tishi">用户查询</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr nowrap >
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
        <html:form action="/smm/queryAccount.do" method="post">
        <table width="95%" border="0">
          <tr nowrap >
            <td height="62"> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr nowrap  bgcolor="#FFFFFF">
                  <td width="12%">帐号</td>
                  <td width="10%"><html:text size="12" name="accountForm" property="account.userName"/></td>
                  <td width="13%">姓名</td>
                  <td width="17%"><html:text size="12" name="accountForm" property="account.name"/></td>
                  <td width="13%">部门</td>
                  <td width="16%"><html:text size="12" name="accountForm" property="account.department"/></td>
                </tr>
                <tr nowrap  bgcolor="#FFFFFF">
                  <td>电子邮件</td>
                  <td><html:text size="12" name="accountForm" property="account.email"/></td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td><html:submit property="submit" value="查询"/></td>
                </tr>
            </table></td>
          </tr>
        </table>
        </html:form>      </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr nowrap >
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
</table>

  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr nowrap >
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr nowrap  align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr nowrap >
                  <td align="center" bgcolor="#E4F7FA" class="tishi">查询列表</td>
                </tr>
              </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr nowrap >
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr nowrap  align="center" bgcolor="#F7EED9">
            <td width="5%"><input type="checkbox" name="checkbox11" value="checkbox" onClick="javascript:setCheckBoxes(allAccountList,this.checked)"></td>
            <td width="6%">序号</td>
            <td width="7%" bgcolor="#F7EED9">帐号</td>
            <td width="11%" bgcolor="#F7EED9">姓名</td>
            <td width="7%">部门</td>
            <td width="12%">EMail</td>
          </tr>
        <form name="allAccountList">
		<logic:present name="allAccountList">
		<logic:iterate id="account" name="allAccountList" >
          <tr nowrap  align="center">
            <td bgcolor="#f6f6f6"><input type="checkbox" name="checkbox" value="<bean:write name="account" property="userID" />"></td>
            <td bgcolor="#f6f6f6"><bean:write name="account" property="userID" /></td>
            <td bgcolor="#f6f6f6"><a href="../../smm/viewAccount.do?userID=<bean:write name="account" property="userID" />" style='cursor:hand' onMouseover="this.style.backgroundColor='#dff1ff'" onMouseOut="this.style.backgroundColor='#f6f6f6'"><bean:write name="account" property="userName" /></a></td>
            <td bgcolor="#f6f6f6"><bean:write name="account" property="name" /></td>
            <td bgcolor="#f6f6f6"><bean:write name="account" property="department" /></td>
            <td bgcolor="#f6f6f6"><bean:write name="account" property="email" /></td>
          </tr>
		</logic:iterate>
		</logic:present>
		</form>
        </table>
	    <logic:present name="allAccountList">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr nowrap >
            <td bgcolor="#F7EED9">
            <logic:notEqual name="allAccountList" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt; 第一页</a> <a href="?page=previous">&lt; 上一页</a>
            </logic:notEqual> <logic:notEqual name="allAccountList" property="lastPage" value="true" >
            <a href="?page=next">下一页 &gt;</a> <a href="?page=last">最后页 &gt;&gt;</a>
            </logic:notEqual>&nbsp; 共<bean:write name="allAccountList" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" onChange="javascript:gotoPage(this.value)" value="<bean:write name="allAccountList" property="pageIndex" />" >
						/<bean:write name="allAccountList" property="pageAmount" /> 页&nbsp;
				每页<bean:write name="allAccountList" property="pageSize" />条</td>
          </tr>
        </table>
	    </logic:present>
	<center>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr nowrap >
            <form name="delform" method="post" action="../../smm/deleteAccount.do" onSubmit="return delConfirm(allAccountList,this.userID)">
            <td align="center" bgcolor="#F7EED9">
              	<input type="hidden" name="userID">
              	<input type="submit" name="delete" value="删除选中" alt="删除选中">
		<input type="button" name="addUser" value="新增用户" onClick="javascript:location='newAccount.jsp'">
            </td>
            </form>
          </tr>
      </table></center>
      </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr nowrap >
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
</table>
</body>
</html:html>
