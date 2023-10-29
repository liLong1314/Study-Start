<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>案卷著录</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
</head>
<body class="bg-page01">
<script language="javascript">

</script>
<html:form action="/adc/updateRollArchives.do" method="post">
  <html:hidden property="archives.AENTRY_ID"/>
  <html:hidden property="archives.AIS_OPERATION"/>
  <html:hidden property="archives.AROLL_MODE"/>
  <html:hidden property="archives.AARCHIVES_STATUS"/>
  <html:hidden property="archives.AIS_PRIVATE"/>
  <html:hidden property="archives.AARCHIVES_ID"/>
  <html:hidden property="archives.AROLL_NUM"/>
  <html:hidden property="operName"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="73" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="10" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="836" align="left" bgcolor="#FFFFFF"> 您现在的位置： &gt;&gt; 档案查询 &gt;&gt;
         案卷信息（业务类）</td>
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
      <td width="1%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="96%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">案卷著录信息[业务类]</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="3%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF"><table width="95%" border="1">
          <tr>
            <td>
		<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <tr bgcolor="#FFFFFF">
                  <td nowrap>档号</td>
                  <td nowrap colspan=3><bean:write  name ="ArchivesForm" property="archives.AARCHIVES_NUM"/> </td>
                  <!--<td nowrap>案卷号</td>
                  <td nowrap><bean:write  name ="ArchivesForm" property="archives.AROLL_NUM"/> </td>-->
                  <td nowrap>档案年度(YYYY)</td>
                  <td nowrap><bean:write  name ="ArchivesForm" property="archives.AARCHIVES_YEAR"/> </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td nowrap>总登记号</td>
                  <td nowrap><bean:write  name ="ArchivesForm" property="archives.AREG_NUM"/> </td>
                  <td nowrap>缩微号</td>
                  <td nowrap><bean:write  name ="ArchivesForm" property="archives.AREDUCE_NUM"/> </td>
                  <td nowrap>档案馆代码</td>
                  <td nowrap><bean:write  name ="ArchivesForm" property="archives.AARCHIVES_ROOM_CODE"/></td>
                </tr>
              </table>
              </td>
          </tr>
        </table>
        <br>
 <table width="95%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
          <tr bgcolor="#FFFFFF">
            <td nowrap>案卷题名</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesForm" property="archives.AARCHIVES_NAME"/>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>立档单位</td>
            <td nowrap colspan="3"><html:select property="archives.AARCHIVES_FOUND_UNIT" disabled="true">
            <html:optionsCollection property="AARCHIVES_FOUND_UNITOptions"/>
            </html:select></td>
	  </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>建设单位</td>
            <td nowrap><bean:write  name ="ArchivesForm" property="archives.AARCHIVES_MAKE_UNIT"/>
            </td>
            <td nowrap>编制日期</td>
            <td nowrap><bean:write  name ="ArchivesForm" property="archives.AARCHIVES_MAKE_PERIOD"/>
            </td>
          </tr>
        <tr bgcolor="#FFFFFF">
            <td nowrap>文件密级</td>
            <td nowrap colspan="3">
		<html:select property="archives.ASECRET_ID" disabled="true">
		<html:optionsCollection property="secret_idOptions"/>
		</html:select>
            </td>
        </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>是否限制件</td>
            <td nowrap>
		<logic:notEmpty name="ArchivesForm" property="archives.AIS_PRIVATE">
		<logic:equal name="ArchivesForm" property="archives.AIS_PRIVATE" value="1">
		是
		</logic:equal>
		<logic:notEqual name="ArchivesForm" property="archives.AIS_PRIVATE" value="1">
		否
		</logic:notEqual>
		</logic:notEmpty>
            </td>
            <td nowrap>保管期限</td>
            <td nowrap><html:select property="archives.ASTORE_TERM" disabled="true">
            <html:optionsCollection property="ASTORE_TERMOptions"/>
            </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>页数</td>
            <td nowrap><bean:write  name ="ArchivesForm" property="archives.APAGE_AMOUNT"/></td>
            <td nowrap>文件起止页次</td>
            <td nowrap><bean:write  name ="ArchivesForm" property="archives.APAGE_NUM_FROM_TO"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>数量</td>
            <td nowrap><bean:write  name ="ArchivesForm" property="archives.AARCHIVES_AMOUNT"/></td>
            <td nowrap>单位</td>
            <td nowrap><html:select property="archives.AARCHIVES_UNIT" disabled="true">
            <html:optionsCollection property="AARCHIVES_UNITOptions"/>
            </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>载体类型</td>
            <td nowrap><html:select property="archives.AMEDIA_TYPE" disabled="true">
            <html:optionsCollection property="AMEDIA_TYPEOptions"/>
            </html:select></td>
            <td nowrap>规格</td>
            <td nowrap><html:select property="archives.ASPECIFICATION" disabled="true">
            <html:optionsCollection property="ASPECIFICATIONOptions"/>
            </html:select></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>立卷人</td>
            <td nowrap><bean:write  name ="ArchivesForm" property="archives.AARCHIVES_FOUND_MAN"/></td>
            <td nowrap>立卷时间</td>
            <td nowrap><bean:write  name ="ArchivesForm" property="archives.AARCHIVES_FOUND_DATE"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td height="21" nowrap>卷数</td>
            <td colspan="3" nowrap>共
              <bean:write  name ="ArchivesForm" property="archives.AROLL_AMOUNT"/>
              卷　　　　　　 第
              <bean:write  name ="ArchivesForm" property="archives.AROLL_SEQ"/>
              卷 </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>归档号</td>
            <td nowrap><bean:write  name ="ArchivesForm" property="archives.AARC_NUM"/></td>
            <td nowrap>归档日期</td>
            <td nowrap><bean:write  name ="ArchivesForm" property="archives.AARC_DATE"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>项目编号</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesForm" property="archives.APROJ_ID"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td nowrap>项目名称</td>
            <td colspan="3" nowrap><bean:write  name ="ArchivesForm" property="archives.APROJ_NAME"/></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td>备注</td>
            <td colspan="3"><bean:write  name ="ArchivesForm" property="archives.AREMARK"/></td>
          </tr>
	  <tr bgcolor="#FFFFFF">
            <td colspan=4>
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
          <tr align="center" bgcolor="#FFFFFF">
            <td colspan="4">
		<input type="button" name="Submit1" value="打印" onclick="window.print();">
		<!--修订（郑先全，20040216）：增加几个链接的返回-档案校验、鉴定管理、销毁管理、变更管理-->
		<%
                String flag = (String)request.getParameter("flag");
		if (flag==null || flag.equals("")){
		%>
              	<input type="button" name="Submit2" value="返回" onclick="window.location='queryArchives.do';">
		<%}else if (flag.equals("1")){%>
		<input type="button" name="Submit2" value="返回" onclick="window.location='/arm/ArchSearch.do?flag=1';">
		<%}else if (flag.equals("2")){%>
		<input type="button" name="Submit2" value="返回" onclick="window.location='/arm/ArchSearch.do?flag=2';">
		<%}else if (flag.equals("3")){%>
		<input type="button" name="Submit2" value="返回" onclick="window.location='/arm/ArchSearch.do?flag=3';">
		<%}else if (flag.equals("4")){%>
		<input type="button" name="Submit2" value="返回" onclick="window.location='/arm/ArchSearch.do?flag=4';">
		<%}else{%>
		<input type="button" name="Submit2" value="返回" onclick="window.location='queryArchives.do';">
		<%}%>
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