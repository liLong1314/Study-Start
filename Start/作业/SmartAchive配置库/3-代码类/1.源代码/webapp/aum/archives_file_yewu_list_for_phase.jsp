<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>业务类文件列表</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
function doIt(fileId){
	window.location.href="/aum/viewArchivesPage.do?fileId="+fileId;
}
function doSwitchQuery(){
	var obj=document.all("queryID");
	var btn=document.all("btnQry");
	if(obj.style.display=="none"){
		//打开查询界面
		obj.style.display="block";
		btn.value="查询<<";
	}else{
		//关上查询界面
		obj.style.display="none";
		btn.value="查询>>";
	}
}
</script>
</head>
<body class="bg-page01">
<html:form action="/adc/addArchivesFile" method="post" >
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="50" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="637" align="left" bgcolor="#FFFFFF">您现在的位置：&gt;&gt; 档案查询 &gt;&gt; 档案文件列表(业务类)</td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td colspan="3" background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>

  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">档案信息[业务类]</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
	<table width="100%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td width="18%"nowrap>档号</td>
            <td nowrap colspan="3"><bean:write  name ="ArchivesFileForm" property="archives.AARCHIVES_NUM"/></td>
    	  </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>案卷题名</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archives.AARCHIVES_NAME"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>立档单位</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archives.AARCHIVES_FOUND_UNIT"/></td>
            <td nowrap width="18%">文件起止日期</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archives.ABEGIN_DATE"/>-<bean:write  name ="ArchivesFileForm" property="archives.AEND_DATE"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>密级</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archives.ASECRET_ID"/></td>
            <td nowrap>保管期限</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archives.ASTORE_TERM"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>页数</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archives.APAGE_AMOUNT"/></td>
            <td nowrap>档案年度</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archives.AARCHIVES_YEAR"/></td>
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
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi" nowrap>
			档案阶段文件列表[阶段编号：<%=request.getSession().getAttribute("PHASE_ID")%>]
		  </td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><br>

        <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
          <tr align="center" bgcolor="#F7EED9">
            <td nowrap>文件序号</td>
            <td nowrap>所在档号</td>
            <td nowrap>文件编号</td>
            <td nowrap>文件题名</td>
            <td nowrap>责任者</td>
            <td nowrap>文件日期</td>
            <td nowrap>页数</td>
            <td nowrap>查看影像页</td>
          </tr>
          <logic:present name="archivesFilesList">
	  <logic:iterate id="archivesListItem" name="archivesFilesList" >
          <tr align="center" bgcolor="#f6f6f6">
            <td nowrap><bean:write name="archivesListItem" property="file_seq"/></td>
            <td nowrap><bean:write name="archivesListItem" property="archives_id"/></td>
            <td><bean:write name="archivesListItem" property="file_num"/></td>
            <td title="查看文件详细信息"><a href="/aum/viewArchivesFile.do?file_id=<bean:write name="archivesListItem" property="file_id"/>"><bean:write name="archivesListItem" property="file_title"/></a></td>
            <td><bean:write name="archivesListItem" property="file_duty"/></td>
            <td><bean:write name="archivesListItem" property="file_date"/></td>
            <td><bean:write name="archivesListItem" property="file_page_amount"/></td>
            <logic:greaterThan name="archivesListItem" property="media_type" value="0">
            <td nowrap title="查看影像页[共<bean:write name="archivesListItem" property="media_type"/>页]"
		style="cursor:hand;color:blue"
		onclick="doIt('<bean:write name="archivesListItem" property="file_id"/>');">GO</td>
            </logic:greaterThan>
            <logic:lessEqual name="archivesListItem" property="media_type" value="0">
            <td nowrap title="无影像页">--</td>
            </logic:lessEqual>
          </tr>
	  </logic:iterate>
          </logic:present>
        </table>
</html:form>
      <logic:present name="archivesFilesList">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="archivesFilesList" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            第一页 </a><a href="?page=previous">&lt;
            上一页 </a></logic:notEqual> <logic:notEqual name="archivesFilesList" property="lastPage" value="true" >
            <a href="?page=next">下一页
            &gt; </a><a href="?page=last">最后页
            &gt;&gt; </a></logic:notEqual>&nbsp; 共<bean:write name="archivesFilesList" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" value="<bean:write name="archivesFilesList" property="pageIndex" />" onChange="javascript:PageTo(this)">
            /<bean:write name="archivesFilesList" property="pageAmount" />
            页&nbsp; 每页<bean:write name="archivesFilesList" property="pageSize" />条</td>
        </tr>
      </table>
      </logic:present>

	<html:form action="/aum/queryArchivesFile" method="post">
	<table id="queryID" style="display:none" width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr bgcolor="#FFFFFF">
            <td nowrap colspan=5><B>查询条件设置</B></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件编号:</td>
            <td nowrap><html:text property="archivesFile.file_num" size="20" maxlength="9"/></td>
            <td nowrap>文件题名:</td>
            <td nowrap><html:text property="archivesFile.file_title" size="30" maxlength="9"/></td>
            <td > <input type="submit" name="Submit1" value="GO"></td>
          </tr>
        </table>
	</html:form>

        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="center" >
              <input type="button" name="btnQry" value="查询>>" onClick="doSwitchQuery();">
              <input type="button" name="Submit5" value="打印" onClick="window.print()">
              <input type="button" name="Submit4" value="返回" onClick="window.location.href='/aum/viewArchivesFilesList.do'">
            </td>
          </tr>
        </table>
        <br> </td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</body>
</html>
