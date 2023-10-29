<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ page import="com.ibatis.common.util.PaginatedList"%>
<html>
<head>
<title>选择上级组织</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript">
function retCheckedRadioValue(frm){
  if(window.opener) {
	  var selected = false;
		for(var i=0;i<frm.elements.length;i=i+2){
		 if((frm.elements[i].type=="radio") && (frm.elements[i].checked)){
		   //增加和修改组织信息
		   if(window.opener.document.getElementById("org.superiorOrgId")) {
			   window.opener.document.getElementById("org.superiorOrgId").value = frm.elements[i].value;
			 }
			 if(window.opener.document.getElementById("org.superiorOrgName")) {
			   window.opener.document.getElementById("org.superiorOrgName").value = frm.elements[i+1].value;
			 }
		   //增加和修改用户组织信息
		   if(window.opener.document.getElementById("account.orgID")) {
			   window.opener.document.getElementById("account.orgID").value = frm.elements[i].value;
			 }
			 if(window.opener.document.getElementById("account.orgName")) {
			   window.opener.document.getElementById("account.orgName").value = frm.elements[i+1].value;
			 }
			 selected = true;
			 self.close();
		 }
		}
		if(!selected) {
		  alert('请选择组织');
		}
	} else {
		alert('请用正确的方式打开本页！');
	}
}

function gotoPage(pageIndex) {
	location = "?page=" + pageIndex;
}
</script>
</head>
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
            <td width="5%">&nbsp;</td>
            <td>编号</td>
            <td>组织名称</td>
            <td>上级组织</td>
            <td>备注</td>
          </tr>
        <form name="selectOrg">
		<logic:present name="selectOrg">
		<logic:iterate id="org" name="selectOrg" >
          <tr nowrap  align="center">
            <td bgcolor="#f6f6f6"><input type="radio" name="radio" value="<bean:write name="org" property="id" />"></td>
            <td bgcolor="#f6f6f6"><bean:write name="org" property="id" /></td>
            <td bgcolor="#f6f6f6">
			  <bean:write name="org" property="name" />
			  <input type="hidden" name="orgName" value="<bean:write name="org" property="name" />">
			</td>
            <td bgcolor="#f6f6f6"><bean:write name="org" property="superiorOrgName" /></td>
			<td bgcolor="#f6f6f6"><bean:write name="org" property="desc" /></td>
          </tr>
		</logic:iterate>
		</logic:present>
		</form>
        </table>
	    <logic:present name="selectOrg">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr nowrap >
            <td bgcolor="#F7EED9">
            <logic:notEqual name="selectOrg" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt; 第一页</a> <a href="?page=previous">&lt; 上一页</a>
            </logic:notEqual> <logic:notEqual name="selectOrg" property="lastPage" value="true" >
            <a href="?page=next">下一页 &gt;</a> <a href="?page=last">最后页 &gt;&gt;</a>
            </logic:notEqual>&nbsp; 共<bean:write name="selectOrg" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" onChange="javascript:gotoPage(this.value)" value="<bean:write name="selectOrg" property="pageIndex" />" >
						/<bean:write name="selectOrg" property="pageAmount" /> 页&nbsp;
				每页<bean:write name="selectOrg" property="pageSize" />条</td>
          </tr>
        </table>
	    </logic:present>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr nowrap >
            <td width="10%" align="center" bgcolor="#F7EED9"><input type="submit" name="select" value="选定" alt="确定选择" onClick="javascript:retCheckedRadioValue(selectOrg)"></td>
            <td width="65%" bgcolor="#F7EED9">&nbsp;</td>
          </tr>
      </table>
      </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr nowrap >
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif">&nbsp;</td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
</table>
</body>
</html>
