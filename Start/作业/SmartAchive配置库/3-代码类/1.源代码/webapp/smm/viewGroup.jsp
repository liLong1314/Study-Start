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
		str = "/smm/modifyGroupUser.do?groupID="+groupID+"&users=";
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

                <td align="center" bgcolor="#E4F7FA" class="tishi">�û�����Ϣ</td>
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
              <tr bgcolor="#FFFFFF">
                <td width="20%">�û�������</td>
                <td width="18%"><bean:write name="groupForm" property="group.groupName"/>
                  <html:hidden name="groupForm" property="group.groupName" /></td>
                <td width="18%">�û���������Ϣ</td>
                <td width="44%"><html:text size="40" name="groupForm" property="group.description"/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td>����ʱ��</td>
                <td><bean:write name="groupForm" property="group.creationDate"/>
                  <html:hidden name="groupForm" property="group.creationDate" /></td>
                <td>����޸�ʱ��</td>
                <td colspan="2"><bean:write name="groupForm" property="group.modifiedDate"/>
                  <html:hidden name="groupForm" property="group.modifiedDate" /></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td colspan="3" align="center"><a href="javascript:submit()">�޸�</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../../smm/deleteGroup.do?groupID=<bean:write name="groupForm" property="group.groupID"/>">ɾ��</a>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../../smm/queryGroup.do?flag=1">����ҳ</a></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td colspan="5">&nbsp;</td>
              </tr>
            </table>
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="4">&nbsp;</td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="4">���û�</td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td width="48%"> �û��б�</td>
                <td colspan="2">&nbsp; </td>
                <td width="47%">�����û�</td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td rowspan="5"> <select name="userFrom" size="10" multiple id="userFrom">
                    <logic:present name="defaultUsers"> <logic:iterate id="du" name="defaultUsers" >
                    <option value="<bean:write name="du" property="userID" />"><bean:write name="du" property="userName" />
                    </logic:iterate> </logic:present> </select> </td>
                <td colspan="2"> <a href="#"  onclick="javascript:moveSelected(userFrom,userTo,1)">=&gt;</a>
                </td>
                <td rowspan="5"> <select name="userTo" size="10" multiple id="userTo">
                    <logic:present name="users"> <logic:iterate id="us" name="users" >
                    <option value="<bean:write name="us" property="userID" />"><bean:write name="us" property="userName" />
                    </logic:iterate> </logic:present> </select> </td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="2"> <a href="#"  onclick="javascript:moveSelected(userFrom,userTo,0)">-&gt;</a>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="2"> <a href="#"  onclick="javascript:moveSelected(userTo,userFrom,0)">&lt;-</a>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="2"> <a href="#"  onclick="javascript:moveSelected(userTo,userFrom,1)">&lt;=</a>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td height="25" colspan="2"><a href="#" onclick="javascript:modifyUsers(userTo,1,'<bean:write name="groupForm" property="group.groupID"/>')">�ύ </a>
                </td>
              </tr>
            </table>
			<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="4">&nbsp;</td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="4">��Ȩ�޹���</td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td><a href="/smm/viewGroup.do?target=func&groupID=<bean:write name="groupForm" property="group.groupID" />">�鹦��Ȩ��</a></td>
                <td><a href="/smm/viewGroup.do?target=data&groupID=<bean:write name="groupForm" property="group.groupID" />">������Ȩ��</a></td>
              </tr>
            </table>
            </td>
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
