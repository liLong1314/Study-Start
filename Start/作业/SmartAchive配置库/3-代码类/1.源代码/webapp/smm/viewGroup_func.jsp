<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<script language="javascript">
function submit()
{
	document.groupForm.submit();
}
//�޸����û�
function modifyUsers(obj,flag,groupID)
{
	var s;
	var str="";
		str = "../../smm/modifyGroupUser.do?groupID="+groupID+"&users=";
	var i = obj.length -1;
	for(;i>-1;i--)
	{
		s = obj.options[i];
		str = str+"|"+s.value;
	}
	location = str;
}
//�޸��鹦�ܲ˵�Ȩ�޺����ݲ���Ȩ��
function modifyPermissions(obj,flag,groupID)
{
	var s;
	var str="";
	if (flag==1)
		str = "/smm/modifyGroupPermission.do?flag=1&groupID="+groupID+"&funGPermissions=";
	else
		str = "/smm/modifyGroupPermission.do?flag=2&groupID="+groupID+"&dataGPermissions=";
	var i = obj.length -1;
	for(;i>-1;i--)
	{
		s = obj.options[i];
		str = str+"|"+s.value;
	}
	location = str;
}
//�б��ѡ���ƶ�
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
</script>
<html:html>
<head>
<title>�û���Ϣ</title>
<link href="../../common/css/sunhoo.css" rel="stylesheet" type="text/css">
</head>
<body class="bg-page01">
<html:form action="/smm/modifyGroup.do" method="post">
<html:hidden name="groupForm" property="group.groupID" />
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>

                <td align="center" bgcolor="#E4F7FA" class="tishi">�û��鹦��Ȩ��</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><br>

<bean:write name="groupForm" property="operResults"/>
        <table width="92%" border="0">
          <tr>
          <td>
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="4">&nbsp;</td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="4">���ܣ��˵���Ȩ��</td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td width="48%"> �ɸ�Ȩ��</td>
                <td colspan="2">&nbsp; </td>
                <td width="47%">�Ѹ�Ȩ��</td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td rowspan="5"> <select name="funFrom" size="10" multiple id="funFrom">
                    <logic:present name="defaultGFunPermissions"> <logic:iterate id="dfp" name="defaultGFunPermissions" >
                    <option value="<bean:write name="dfp" property="permID" />"><bean:write name="dfp" property="permContent" />
                    </logic:iterate> </logic:present> </select> </td>
                <td colspan="2"> <input type="button" value="=>" onclick="moveSelected(funFrom,funTo,1)" style="width:22px">
                </td>
                <td rowspan="5"> <select name="funTo" size="10" multiple id="funTo">
                    <logic:present name="funGPermissions"> <logic:iterate id="fp" name="funGPermissions" >
                    <option value="<bean:write name="fp" property="permID" />"><bean:write name="fp" property="permContent" />
                    </logic:iterate> </logic:present> </select> </td>
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
                <td colspan="2"> <input type="button" value="<=" onclick="moveSelected(funTo,funFrom,1)" style="width:22px">
                </td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td height="25" colspan="2">
		<input type="button" name="btn1" value="�ύ" onclick="modifyPermissions(funTo,1,'<bean:write name="groupForm" property="group.groupID"/>')">
                </td>
              </tr>
            </table>
            <p>&nbsp;</p></td>
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
</html:form>
</body>
</html:html>
