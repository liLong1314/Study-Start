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
body{
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
function addArchivesFile(ARCHIVES_ID){
	window.location.href="addArchivesFile.do?ARCHIVES_ID="+ARCHIVES_ID;
}

function doSubmit(form){
        if (!validateCheckBox(form)){
          alert("请选择文件！");
        }else
	  form.submit();
}

function validateCheckBox(theform){
	var obj=document.getElementsByName("file_id");
	var isChecked = false;
	fileId = "";
	for(var i=0;i<obj.length;i++){
		if (obj[i].checked){
			isChecked=true;
			//fileId += obj[i].value + ",";
		}
	}
	return isChecked;
}
</script>
</head>
<body class="bg-page01">
<html:form action="/aum/AddUtilizeDetail.do" method="post" target="_parent">
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
            <td>选择</td>
            <td>文件编号</td>
            <td>文件题名</td>
            <td>责任者</td>
            <td>文件日期</td>
            <td>页数</td>
          </tr>
          <logic:present name="archivesFilesList">
	  <logic:iterate id="archivesListItem" name="archivesFilesList" >
          <tr align="center" bgcolor="#f6f6f6">
            <td>
              <input type="checkbox" name="file_id" value="<bean:write name="archivesListItem" property="file_id"/>">
            </td>
            <td><bean:write name="archivesListItem" property="file_num"/></td>
            <td><bean:write name="archivesListItem" property="file_title"/></td>
            <td><bean:write name="archivesListItem" property="file_duty"/></td>
            <td><bean:write name="archivesListItem" property="file_date"/></td>
            <td><bean:write name="archivesListItem" property="file_page_amount"/></td>
          </tr>
	  </logic:iterate>
          </logic:present>
        </table>
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
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="center" bgcolor="#F7EED9">
              <input type="button" name="Submit" value="选择" onClick="doSubmit(this.form)">
              <input type="button" name="Submit5" value="打印" onClick="window.print()">
              <input type="button" name="Submit2" value="返回" onClick="window.history.go(-1)">
              </logic:present>
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
</html:form>
</body>
</html>
