<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ page import="com.ibatis.common.util.PaginatedList"%>
<html:html>
<head>
<title>组织查询</title>
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
                  <td align="center" bgcolor="#E4F7FA" class="tishi">组织查询</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr nowrap >
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
        <html:form action="/smm/queryOrg.do" method="post">
        <table width="95%" border="0">
          <tr nowrap >
            <td> <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr nowrap  bgcolor="#FFFFFF">
                  <td>组织名称</td>
                  <td><html:text property="org.name"/></td>
                  <td><html:submit property="submit" value="查询"/></td>
                </tr>
            </table></td>
          </tr>
        </table>
        </html:form>      
	  </td>
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
                  <td align="center" bgcolor="#E4F7FA" class="tishi">组织列表</td>
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
            <td width="5%"><input type="checkbox" name="checkbox11" value="checkbox" onClick="javascript:setCheckBoxes(allOrgList,this.checked)"></td>
            <td>编号</td>
            <td>组织名称</td>
            <td>上级组织</td>
            <td>备注</td>
            <td>操作</td>
          </tr>
        <form name="allOrgList">
		<logic:present name="allOrgList">
		<logic:iterate id="org" name="allOrgList" >
          <tr nowrap  align="center">
            <td bgcolor="#f6f6f6"><input type="checkbox" name="checkbox" value="<bean:write name="org" property="id" />"></td>
            <td bgcolor="#f6f6f6"><bean:write name="org" property="id" /></td>
            <td bgcolor="#f6f6f6"><bean:write name="org" property="name" /></td>
            <td bgcolor="#f6f6f6"><bean:write name="org" property="superiorOrgName" /></td>
			<td bgcolor="#f6f6f6"><bean:write name="org" property="desc" /></td>
			<td bgcolor="#f6f6f6"><a href="/smm/newOrgModifyForm.do?orgid=<bean:write name="org" property="id" />">修改</a></td>
          </tr>
		</logic:iterate>
		</logic:present>
		</form>
        </table>
	    <logic:present name="allOrgList">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr nowrap >
            <td bgcolor="#F7EED9">
            <logic:notEqual name="allOrgList" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt; 第一页</a> <a href="?page=previous">&lt; 上一页</a>
            </logic:notEqual> <logic:notEqual name="allOrgList" property="lastPage" value="true" >
            <a href="?page=next">下一页 &gt;</a> <a href="?page=last">最后页 &gt;&gt;</a>
            </logic:notEqual>&nbsp; 共<bean:write name="allOrgList" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" onChange="javascript:gotoPage(this.value)" value="<bean:write name="allOrgList" property="pageIndex" />" >
						/<bean:write name="allOrgList" property="pageAmount" /> 页&nbsp;
				每页<bean:write name="allOrgList" property="pageSize" />条</td>
          </tr>
        </table>
	    </logic:present>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr nowrap >
            <td width="10%" align="center" bgcolor="#F7EED9">&nbsp;</td>
		    <form name="delform" method="post" action="../../smm/deleteOrg.do" onSubmit="return delConfirm(allOrgList,this.ids)">
            <td width="13%" align="center" bgcolor="#F7EED9">
              <input type="hidden" name="ids">
              <input type="submit" name="delete" value="删除选中" alt="删除选中">
			</td>
            </form>
            <td width="65%" bgcolor="#F7EED9"><input name="addOrg" type="button" id="addOrg" onClick="javascript:location='newOrg.jsp'" value="新增组织"></td>
            <td width="65%" bgcolor="#F7EED9">&nbsp;</td>
          </tr>
      </table>
      </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr nowrap >
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif">
	    <% 
		  String message = (String) session.getAttribute("message");
		  if(message != null && message.length() > 0) {
		    out.print("<font color=\"#FF0000\">" + message + "</font>");
		  }
	      session.removeAttribute("message"); 
		%>
	  </td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
</table>
</body>
</html:html>
