<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ page import="com.sunyard.hgam.persistence.dao.beans.smm.*"%>
<%@ page import="java.util.List"%>
<script language="javascript">
function submit()
{
	document.accountForm.submit();
}
function modifyPermissions(obj,flag,userID)
{
	var s;
	var str="";
	if (flag==1)
		str = "/smm/modifyAccountPermission.do?flag=1&userID="+userID+"&funPermissions=";
	else
		str = "/smm/modifyAccountPermission.do?flag=2&userID="+userID+"&dataPermissions=";
	var i = obj.length -1;
	for(;i>-1;i--)
	{
		s = obj.options[i];
		str = str+"|"+s.value;
	}
	location = str;
}
function moveSelected(from,to,flag)
{
	var s;
	var i = from.length - 1;
	if(flag==1)
    for(;i>-1;i--)
    {
		from[i].selected=true;
    }
	i = from.length-1;
  	for (; i > -1; i--)
	{
        if (from[i].selected)
	    {
    		s = from.options[i];
			from[i]=null;
			to.add(document.createElement("OPTION"));
			to.options[to.length-1].text = s.text;
			to.options[to.length-1].value = s.value;
		}
	}
}
function openWindow(newUrl) {

	var width = 600;
	var height = 480;
	var left = (screen.width - width)/2;
	var top = (screen.height - height)/2;
	style="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,left="+left+",top="+top+",width="+width+",height="+height; 

	window.open(newUrl, "", style);
}
</script>
<html:html>
<head>
<title>用户信息</title>
<link href="../../common/css/sunhoo.css" rel="stylesheet" type="text/css">
</head>
<body class="bg-page01">
<html:form action="/smm/modifyAccount.do" method="post">
<html:hidden name="accountForm" property="account.userID" />
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>
                  <td align="center" bgcolor="#E4F7FA" class="tishi">用户信息</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
<bean:write name="accountForm" property="operResults"/>
        <table width="92%" border="0">
          <tr>
          <td>
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr bgcolor="#FFFFFF">
                <td width="18%">帐号</td>
                <td width="33%"><bean:write name="accountForm" property="account.userName"/>
                  <html:hidden name="accountForm" property="account.userName" /></td>
                <td width="17%">E-Mail</td>
                <td width="32%" colspan="2"><html:text size="12" name="accountForm" property="account.email"/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td>姓名</td>
                <td><html:text size="12" name="accountForm" property="account.name"/></td>
                <td>登录次数</td>
                <td colspan="2"><bean:write name="accountForm" property="account.accessTimes"/>
                  <html:hidden name="accountForm" property="account.accessTimes" /></td>
              </tr>
              <tr bgcolor="#FFFFFF">
	            <td>组织</td>
	            <td>
		          <html:text size="12" property="account.orgName" readonly="true"/>
		          <html:hidden property="account.orgID"/>
		          <a href="javascript:openWindow('/smm/selectOrg.do?page=refresh')">选择...</a>
		        </td>
                <td>默认角色</td>
                <td align="center" colspan="2">
				  <html:select name="accountForm" property="account.roleID">
					<html:optionsCollection name="accountForm" property="groups"/>
				  </html:select>
				</td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td>部门</td>
                <td><html:text size="12" name="accountForm" property="account.department"/></td>
                <td>创建时间</td>
                <td colspan="2"><bean:write name="accountForm" property="account.creationDate"/>
                  <html:hidden name="accountForm" property="account.creationDate" /></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td>最后一次登录时间</td>
                <td><bean:write name="accountForm" property="account.lastAccessDate"/>
                  <html:hidden name="accountForm" property="account.lastAccessDate" /></td>
                <td>最后一次修改时间</td>
                <td colspan="2"><bean:write name="accountForm" property="account.lastModifiedDate"/>
                  <html:hidden name="accountForm" property="account.lastModifiedDate" /></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td>附注</td>
                <td colspan="4"><html:textarea name="accountForm" property="account.remark"/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td colspan="5" align="center"><a href="javascript:submit()">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../../smm/deleteAccount.do?userID=<bean:write name="accountForm" property="account.userID"/>">删除</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../../smm/queryAccount.do?flag=1">回上页</a></td>
              </tr>
              <tr align="center" bgcolor="#FFFFFF">
                <td colspan="2"><a href="/smm/viewAccount.do?target=func&userID=<bean:write name="accountForm" property="account.userID" />">用户功能权限</a></td>
                <td colspan="3"><a href="/smm/viewAccount.do?target=data&userID=<bean:write name="accountForm" property="account.userID" />">用户数据权限</a></td>
              </tr>
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
</html:form>
</body>
</html:html>
