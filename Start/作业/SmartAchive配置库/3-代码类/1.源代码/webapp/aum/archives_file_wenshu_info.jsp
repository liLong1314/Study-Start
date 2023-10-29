<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>文件信息－文书类</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script>
function doViewFile(filePathName){
	window.open("/rcv/viewArchivesFileAccessory.do?filePathName=" + filePathName,"filewin","nomenu=1;notoolbar=1");
}
</script>
</head>
<body class="bg-page01">

<html:form action="/adc/updateArchivesFile.do" method="post">
  <html:hidden property="archivesFile.file_id"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="76" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="10" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="849" align="left" bgcolor="#FFFFFF"> 您现在的位置： &gt;&gt; 档案查询 &gt;&gt; 文件信息(文书类)</td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">文件详细信息</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td height="355" background="../image/2_table_c_r.gif">&nbsp;</td>
	<td align="center" bgcolor="#FFFFFF">
	<table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件序号</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_seq"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td width="25%" nowrap>文件题名</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_title"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件编号</td>
            <td width="27%" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_num"/>
            </td>
            <td width="17%" nowrap>责任者</td>
            <td width="31%" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_duty"/>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件日期</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_date"/></td>
            <td nowrap>文件页数</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_page_amount"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件起止页号</td>
            <td nowrap colspan=3><bean:write  name ="ArchivesFileForm" property="archivesFile.page_num_from_to"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件密级</td>
            <td nowrap><html:select property="archivesFile.secret_id" disabled="true">
            <html:optionsCollection property="secret_idOptions"/>
            </html:select></td>
            <td nowrap>保管期限</td>
            <td nowrap><html:select property="archivesFile.file_store_term" disabled="true">
            <html:optionsCollection property="file_store_termOptions"/>
            </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>载体类型</td>
            <td nowrap> <html:select property="archivesFile.media_type" disabled="true">
            <html:optionsCollection property="media_typeOptions"/>
            </html:select></td>
            <td nowrap>载体规格</td>
            <td nowrap><html:select property="archivesFile.file_spec" disabled="true">
            <html:optionsCollection property="file_specOptions"/>
            </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>附件</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_page_amount"/></td>
            <logic:notEmpty name="ArchivesFileForm" property="archivesFile.file_pathName">
		<input type="button" name="viewFile" value="查看附件文件"
			onclick="doViewFile('<bean:write name="ArchivesFileForm" property="archivesFile.file_pathName"/>')">
            </logic:notEmpty>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>主题词</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_keywords"/>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>文件份数</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_count"/></td>
            <td nowrap>稿本类型</td>
            <td nowrap>
              <html:select property="archivesFile.file_type" disabled="true">
            <html:optionsCollection property="file_typeOptions"/>
            </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>备注</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.remark"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>是否开放</td>
            <td nowrap>
		<logic:notEmpty name="ArchivesFileForm" property="archivesFile.is_private">
		<logic:equal name="ArchivesFileForm" property="archivesFile.is_private" value="1">
		限制件
		</logic:equal>
		<logic:notEqual name="ArchivesFileForm" property="archivesFile.is_private" value="1">
		开发件
		</logic:notEqual>
		</logic:notEmpty>
            </td>
            <td nowrap>&nbsp;</td>
            <td nowrap>&nbsp;</td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="4" nowrap><strong>收文信息</strong></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>收文时间</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_get_date"/></td>
            <td nowrap>主（抄）送</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_get_forward"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>收件人</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_get_person"/></td>
            <td nowrap>&nbsp;</td>
            <td nowrap>&nbsp;</td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td colspan="4" nowrap><strong>发文信息</strong></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>主送单位</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_to_unit"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>抄送单位</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_to_forward"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>拟稿人</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_to_createby"/></td>
            <td nowrap>签发人</td>
            <td nowrap><bean:write  name ="ArchivesFileForm" property="archivesFile.file_to_signby"/></td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td colspan="4" nowrap>
		<input type="button" name="Submit2" value="打印" onclick="window.print();">
		<input type="button" name="Submit3" value="返回" onclick="window.history.go(-1)">
            </td>
          </tr>
        </table>

        <br>      </td>
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
