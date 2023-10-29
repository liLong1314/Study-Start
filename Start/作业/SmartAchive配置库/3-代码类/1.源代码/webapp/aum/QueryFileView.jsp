<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.sunyard.hgam.util.adc.AdcUtil"%>
<%@ page import="com.sunyard.hgam.persistence.dao.beans.adc.Archives"%>
<%@ page import="java.lang.String"%>

<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>无标题文档</title>
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
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}
//-->
</script>
</head>
<body class="bg-page01">
<script>
	function myLoad(){
		
	}
	function doChange(obj){
		window.location.href=obj.options[obj.selectedIndex].url;
	}

function doConfirm(){
	if(confirm("你确认删除吗？"))
	{}
}	 
</script>

<html:form action="/aum/SelectArchivesFile" method="post" >
<html:hidden property="functionName"/>
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
      <td width="637" align="left" bgcolor="#FFFFFF"> 您现在的位置：档案扫描录入 &gt;&gt; 档案文件列表 &gt;&gt; </td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">案卷著录信息[**类]</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr> 
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <table width="100%"  border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
        <tr bgcolor="#FFFFFF"> 
          <td width="25%"nowrap>档号</td>
          <td nowrap colspan="3"><bean:write  name ="ScanFileViewForm" property="archives.AARCHIVES_NUM"/></td>
        </tr>
        <tr bgcolor="#FFFFFF"> 
          <td nowrap>案卷题名/件题名</td>
          <td colspan="3" nowrap><bean:write  name ="ScanFileViewForm" property="archives.AARCHIVES_NAME"/></td>
        </tr>
        <tr bgcolor="#FFFFFF"> 
          <td nowrap>立档单位</td>
          <td width="27%" nowrap><bean:write  name ="ScanFileViewForm" property="archives.AARCHIVES_FOUND_UNIT"/></td>
          <td width="17%" nowrap>文件起止日期</td>
          <td width="31%" nowrap><bean:write  name ="ScanFileViewForm" property="archives.ABEGIN_DATE"/>-<bean:write  name ="ScanFileViewForm" property="archives.AEND_DATE"/></td>
        </tr>
        <tr bgcolor="#FFFFFF"> 
          <td nowrap>密级</td>
          <td nowrap>
				    <bean:define id="archives" name="ScanFileViewForm" property="archives"/>
						<%
							String ais_private = ((Archives)archives).getAIS_PRIVATE();
							if (ais_private==null)
								ais_private = "";
							out.print((String)ais_private);
							//out.print(AdcUtil.getSecretNameById((String)ais_private));
						%>
          </td>
          <td nowrap>保管期限</td>
          <td nowrap>
				    <bean:define id="store_term" name="ScanFileViewForm" property="archives.ASTORE_TERM"/>
						<%
							out.print(AdcUtil.getSysParamByTypeAndValue("ArchiveStore", (String)store_term));
						%>
          </td>
        </tr>
        <tr bgcolor="#FFFFFF"> 
          <td nowrap>页数</td>
          <td nowrap><bean:write  name ="ScanFileViewForm" property="archives.APAGE_AMOUNT"/></td>
          <td nowrap>档案年度</td>
          <td nowrap><bean:write  name ="ScanFileViewForm" property="archives.AARCHIVES_YEAR"/></td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">档案文件列表</td>
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
            <td>文件序号</td>
            <td>文件题名</td>
            <td>日期</td>
            <td>页数</td>
            <td>责任者</td>
          </tr>

          <logic:present name="queryArchivesFile"> 
		  <logic:iterate id="archivesListItem" name="queryArchivesFile" > 
          <tr align="center" bgcolor="#f6f6f6" style='cursor:hand' 
			  onMouseover="this.style.backgroundColor='#dff1ff'" 
			  onMouseOut="this.style.backgroundColor='#f6f6f6'" 
			  onclick="window.location='../adc/ScanPage.do?archives_id=<bean:write name="ScanFileViewForm" property='archives_id'/>&file_id=<bean:write name='archivesListItem' property='file_id'/>&archives_name=<bean:write  name ="ScanFileViewForm" property="archives.AARCHIVES_NAME"/>&archives_num=<bean:write  name ="ScanFileViewForm" property="archives.AARCHIVES_NUM"/>&file_title=<bean:write name="archivesListItem" property="file_title"/>' ">
            <td><bean:write name="archivesListItem" property="file_seq" /></td>
            <td><bean:write name="archivesListItem" property="file_title"/></td>
            <td><bean:write name="archivesListItem" property="file_date" /></td>
            <td><bean:write name="archivesListItem" property="file_page_amount" /></td>
            <td><bean:write name="archivesListItem" property="file_duty" /></td>
          </tr>
		  </logic:iterate>
		  </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td align="center" bgcolor="#F7EED9"> 
              <div align="center"> </div>
              <input type="button" name="Submit22" value="打印" onClick="window.print()">
              <input type="button" name="Submit2" value="返回" onClick="window.location = '/adc/ScanArchivesView.do'">
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
