<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%
String archiveId=(String) request.getSession().getAttribute("tmparchiveId");
%>
<html:html>
<head>
<title>档案变更</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
.style1 {font-size: 14px}
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

    <td width="653" align="left" bgcolor="#FFFFFF"> 您现在的位置：<a href="/arm/ArchView.do?flag=4">变更管理</a>&gt;&gt; 档案变更</td>
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
                  <td align="center" bgcolor="#E4F2FA" class="style1">档案变更信息</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
          <table width="100%" border="1">
          <tr>
            <td height="112">
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
		<html:form action="/arm/ArchChangeAdd.do" method="post">
                <tr bgcolor="#FFFFFF">
                  <td width="20%" align="right">案卷题名：</td>
                  <td width="30%">
                  <html:hidden property="archOperInfo.refarchivesId" value="<%=archiveId%>"/>
                  <html:hidden name="archOperForm" property="archOperInfo.archivesStatus"/>
                  <html:hidden property="archOperInfo.isChange" value="1"/>
                  <html:hidden name="archOperForm" property="archOperInfo.entryId"/>
                  <html:hidden name="archOperForm" property="archOperInfo.rollMode"/>
                  <html:hidden name="archOperForm" property="archOperInfo.isOperation"/>
                  <html:hidden name="archOperForm" property="archOperInfo.archivesNum"/>

                  <html:text name="archOperForm" property="archOperInfo.archivesName"/>
                  </td>
                  <td width="20%" align="right">案卷年度：</td>
                  <td width="30%">
                  <html:text name="archOperForm" property="archOperInfo.archivesYear" size="10"/>
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right" width="20%">项目编号：</td>
                  <td width="30%">
                  <html:text name="archOperForm" property="archOperInfo.projId" size="10"/>
                  </td>
                  <td width="20%" align="right">项目名称：</td>
                  <td width="30%">
                  <html:text name="archOperForm" property="archOperInfo.projName" size="15"/>
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right" width="20%">单位：</td>
                  <td width="30%">
                  <html:text name="archOperForm" property="archOperInfo.archUnit" size="15"/>
                  </td>
                  <td width="20%" align="right">保管期限：</td>
                  <td width="30%">
                  <html:text name="archOperForm" property="archOperInfo.storeTerm" size="10"/>
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right" width="20%">档案馆代码：</td>
                  <td width="30%">
                    <html:text name="archOperForm" property="archOperInfo.archRoomCode" size="10"/>
                  </td>
                  <td width="20%" align="right">总登记号：</td>
                  <td width="30%">
                    <html:text name="archOperForm" property="archOperInfo.regNum" size="10"/>
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right" width="20%">规格：</td>
                  <td width="30%">
                    <html:text name="archOperForm" property="archOperInfo.specification" size="10"/>
                  </td>
                  <td width="20%" align="right">载体类型：</td>
                  <td width="30%">
                    <html:text name="archOperForm" property="archOperInfo.mediaType" size="10"/>
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right" width="20%">数量：</td>
                  <td width="30%">
                    <html:text name="archOperForm" property="archOperInfo.archAmount" size="10"/>
                  </td>
                  <td width="20%" align="right">立档单位：</td>
                  <td width="30%">
                    <html:text name="archOperForm" property="archOperInfo.archFoundUnit" size="15"/>
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">

                <td align="right" width="20%">立卷时间：</td>
                <td width="30%"> <html:text name="archOperForm" property="archOperInfo.archFoundDate" size="10"/>
                </td>
                  <td align="right" width="20%">立卷人：</td>
                  <td width="30%">
                    <html:text name="archOperForm" property="archOperInfo.archFoundMan" size="10"/>
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right" width="20%">说明：</td>
                <td colspan="3">
                  <html:textarea name="archOperForm" property="archOperInfo.remark"/>
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="center" colspan="4">
                    <input name="Submit" type="submit" value="提交">
                  </td>
                </tr>
		</html:form>
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
</body>
</html:html>
