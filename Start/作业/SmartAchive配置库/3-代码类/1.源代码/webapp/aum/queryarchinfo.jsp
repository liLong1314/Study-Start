<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html:html>
<head>
<title>档案信息</title>
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

    <td width="653" align="left" bgcolor="#FFFFFF"> 您现在的位置：<a href="/aum/querymain.jsp">档案综合查询</a>>&gt;&gt; 查看详细档案信息</td>
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

                <td align="center" bgcolor="#E4F2FA" class="tishi">档案详细信息</td>
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
                <td colspan=4>档案信息</td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">档号：</td>
                <td colspan=3> <bean:write name="ArchOperInfo" property="archivesNum"/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right">案卷题名：</td>
                <td colspan=3>
                  <bean:write name="ArchOperInfo" property="archivesName"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right">案卷年度：</td>
                <td colspan=3> <bean:write name="ArchOperInfo" property="archivesYear"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">项目编号：</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="projId"/>
                </td>
                <td width="20%" align="right">项目名称：</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="projName"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">单位：</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="archUnit"/>
                </td>
                <td width="20%" align="right">保管期限：</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="storeTerm"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">档案馆代码：</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="archRoomCode"/>
                </td>
                <td width="20%" align="right">总登记号：</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="regNum"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">规格：</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="specification"/>
                </td>
                <td width="20%" align="right">载体类型：</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="mediaType"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">数量：</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="archAmount"/>
                </td>
                <td width="20%" align="right">立档单位：</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="archFoundUnit"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right" width="20%">立卷时间：</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="archFoundDate"/>
                </td>
                <td align="right" width="20%">立卷人：</td>
                <td width="30%"> <bean:write name="ArchOperInfo" property="archFoundMan"/>
                </td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td align="right">备注：</td>
                <td colspan=3><bean:write name="ArchOperInfo" property="remark"/></td>
              </tr>
            </table>
            <!--项目概要信息-->
            <logic:notEmpty name="ProjBriefList">
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              	<tr>
                	<td colspan=2>项目概要信息</td>
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
<input name="Submit" type="button" value="返回" onclick="window.location='OperQuery.do'">
<input type="button" name="Submit3" value="打印" onclick="window.print()">
</center>
</body>
</html:html>
