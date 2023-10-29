<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>待整理文件列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/chkBoxOperation.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
<!--
var fileId = "";
//查询
function doQuery(theform){
	theform.submit();
}
//查看
function doGoto(url){
	window.location=url;
}
-->
</script>
</head>
<body class="bg-page01">
<html:form action="/rcv/querySettleArchivesFileList" method="post" >
  <html:hidden property="operName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>

                <td align="center" bgcolor="#E4F7FA" class="tishi">待接收文件查询条件</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br>
          <table width="100%" height="37" border="1">
            <tr>
            <td height="31">
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td nowrap id="Mode1">文件编号:</td>
                  <td nowrap id="Mode1">
			<html:text property="archivesFile.file_num" value="" size="20" maxlength="40"/>
                  </td>
                  <td nowrap id="Mode1">文件题名:</td>
                  <td nowrap id="Mode1">
			<html:text property="archivesFile.file_title" value="" size="20" maxlength="40"/>
                  </td>
                  <td align="center" nowrap colspan=1>&nbsp;</td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td nowrap id="Mode1">项目编号:</td>
                  <td nowrap id="Mode1">
			<html:text property="archivesFile.proj_id" value="" size="20" maxlength="40"/>
                  </td>
                  <td nowrap id="Mode1">项目名称:</td>
                  <td nowrap id="Mode1">
			<html:text property="archivesFile.proj_name" value="" size="20" maxlength="40"/>
                  </td>
                  <td align="center" nowrap colspan=1>
			<input type="button" name="btnQry" value="查询" onClick="doQuery(this.form)">
                  </td>
                </tr>
              </table>
              </td>
            </tr>
        </table></td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif">
	<table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#0293CA">
                <tr>

                <td align="center" bgcolor="#E4F7FA" class="tishi">待接收文件信息列表</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="4%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="24"></td>

    <td align="center" bgcolor="#FFFFFF">
        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td bgcolor="#F7EED9">项目编号</td>
          <td bgcolor="#F7EED9">项目名称</td>
          <td bgcolor="#F7EED9">文件编号</td>
          <td bgcolor="#F7EED9">文件题名</td>
          <td bgcolor="#F7EED9">操作</td>
        </tr>
	<logic:notPresent name="toSettleArchivesFileList">
	<tr align="center" bgcolor="#F7EED9">
          <td colspan=5>暂无记录</td>
        </tr>
	</logic:notPresent>
	<logic:present name="toSettleArchivesFileList">
	<logic:iterate id="list" name="toSettleArchivesFileList" >
        <tr align="center" bgcolor="#F7EED9">
          <td bgcolor="#F6F6F6"><bean:write name="list" property="proj_id" /></td>
          <td bgcolor="#F6F6F6"><bean:write name="list" property="proj_name" /></td>
          <td bgcolor="#F6F6F6"><bean:write name="list" property="file_num" /></td>
          <td bgcolor="#F6F6F6"><bean:write name="list" property="file_title" /></td>
          <td bgcolor="#F6F6F6"><a href="settleArchivesFileNavigator.do?file_id=<bean:write name="list" property="file_id" />">整理</a></td>
          </tr>
	</logic:iterate>
	</logic:present>
      </table>

      <logic:present name="toSettleArchivesFileList">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="toSettleArchivesFileList" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            第一页 </a><a href="?page=previous">&lt;
            上一页 </a></logic:notEqual> <logic:notEqual name="toSettleArchivesFileList" property="lastPage" value="true" >
            <a href="?page=next">下一页
            &gt; </a><a href="?page=last">最后页
            &gt;&gt; </a></logic:notEqual>&nbsp; 共<bean:write name="toSettleArchivesFileList" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" value="<bean:write name="toSettleArchivesFileList" property="pageIndex" />" onChange="javascript:PageTo(this)">
            /<bean:write name="toSettleArchivesFileList" property="pageAmount" />
            页&nbsp; 每页<bean:write name="toSettleArchivesFileList" property="pageSize" />条</td>
        </tr>
      </table>
      </logic:present>

      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" bgcolor="#F7EED9">
              <input type="button" name="button4" value="打印" onclick="window.print()">
          </td>
        </tr>
      </table>

      </td>
      <td background="../image/2_table_c_l.gif"><img src="../image/2_table_c_l.gif" width="26" height="138"></td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</html:form>
</body>
</html>
