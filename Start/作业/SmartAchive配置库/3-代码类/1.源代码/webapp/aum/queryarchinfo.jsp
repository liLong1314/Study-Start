<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>������Ϣ</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_goToURL() { //v3.0
  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}
//-->
</script>
</head>
<body class="bg-page01">
<center>
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

    <td width="653" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã�<a href="/aum/querymain.jsp">�����ۺϲ�ѯ</a>>&gt;&gt; �鿴��ϸ������Ϣ</td>
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
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>

                <td align="center" bgcolor="#E4F2FA" class="tishi">������ϸ��Ϣ</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
          <table width="100%" border="0">
          <tr>
            <td height="112">
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr>
                <td colspan=4>������Ϣ</td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">���ţ�</td>
                <td colspan=3> <bean:write name="ArchOperInfo" property="archivesNum"/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right">����������</td>
                <td colspan=3>
                  <bean:write name="ArchOperInfo" property="archivesName"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right">������ȣ�</td>
                <td colspan=3> <bean:write name="ArchOperInfo" property="archivesYear"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">��Ŀ��ţ�</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="projId"/>
                </td>
                <td width="20%" align="right">��Ŀ���ƣ�</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="projName"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">��λ��</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="archUnit"/>
                </td>
                <td width="20%" align="right">�������ޣ�</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="storeTerm"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">�����ݴ��룺</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="archRoomCode"/>
                </td>
                <td width="20%" align="right">�ܵǼǺţ�</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="regNum"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">���</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="specification"/>
                </td>
                <td width="20%" align="right">�������ͣ�</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="mediaType"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">������</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="archAmount"/>
                </td>
                <td width="20%" align="right">������λ��</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="archFoundUnit"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">����ʱ�䣺</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="archFoundDate"/>
                </td>
                <td align="right" width="20%">�����ˣ�</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="archFoundMan"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right">��ע��</td>
                <td colspan=3><bean:write name="ArchOperInfo" property="remark"/></td>
              </tr>
            </table>
            <!--��Ŀ��Ҫ��Ϣ-->
            <logic:notEmpty name="ProjBriefList">
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              	<tr>
                	<td colspan=2>��Ŀ��Ҫ��Ϣ</td>
              	</tr>
	  	<logic:iterate id="item" name="ProjBriefList">
          	<tr bgcolor="#FFFFFF">
            		<td nowrap align="right">
			<bean:write name ="item" property="field_cname"/>:
            		</td>
            		<td nowrap>
			<bean:write name ="item" property="field_value"/>
            		</td>
          	</tr>
	  	</logic:iterate>
            </table>
            </logic:notEmpty>
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
<input name="Submit" type="button" value="����" onclick="window.location='OperQuery.do'">
<input type="button" name="Submit3" value="��ӡ" onclick="window.print()">
</center>
</body>
</html:html>
