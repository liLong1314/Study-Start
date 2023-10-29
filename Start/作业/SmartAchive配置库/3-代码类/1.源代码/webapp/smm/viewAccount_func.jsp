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
                  <td align="center" bgcolor="#E4F7FA" class="tishi">用户功能权限</td>
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
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="4">功能（菜单）权限</td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td width="48%"> 可赋权限</td>
                <td colspan="2">&nbsp; </td>
                <td width="47%">已赋权限</td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td rowspan="5"> <select name="funFrom" size="10" multiple id="funFrom">

                    <logic:present name="defaultFunPermissions"> <logic:iterate id="dfp" name="defaultFunPermissions" >
                    <option value="<bean:write name="dfp" property="permID" />"><bean:write name="dfp" property="permContent" /></option>
                    </logic:iterate> </logic:present>

                  </select> </td>
                <td colspan="2"> <input type="button" value="=>" onclick="moveSelected(funFrom,funTo,1)" style="width:22px">
                </td>
                <td rowspan="5"> <select name="funTo" size="10" multiple id="funTo">
                    <logic:present name="funPermissions"> <logic:iterate id="fp" name="funPermissions" >
                    <option value="<bean:write name="fp" property="permID" />"><bean:write name="fp" property="permContent" /></option>
                    </logic:iterate> </logic:present>

                  </select> </td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="2"> <input type="button" value="->" onclick="moveSelected(funFrom,funTo,0)" style="width:22px">
                </td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="2"> <input type="button" value="<-" onclick="moveSelected(funTo,funFrom,0)" style="width:22px">
                </td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="2"><input type="button" value="<=" onclick="moveSelected(funTo,funFrom,1)" style="width:22px">
                </td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td height="25" colspan="2">
		<input type="button" name="btn1" value="提交" onclick="modifyPermissions(funTo,1,'<bean:write name="accountForm" property="account.userID"/>')">
                </td>
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
