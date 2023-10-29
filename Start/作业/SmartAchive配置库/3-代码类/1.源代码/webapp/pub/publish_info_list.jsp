<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>发布信息列表</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<script language="javascript" src="../common/js/chkBoxOperation.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
//删除
function doDelete(theform){
	var operName = document.all("operName");
	if(!validateCheckBox(theform)){
		alert("请选择需要进行操作的记录");
		return false;
	}
	if(confirm("您确认删除所选的发布信息吗？")){
		theform.submit();
	}
}
//
function validateCheckBox(theform){
	var obj=document.getElementsByName("info_id");
	var isChecked = false;
	for(var i=0;i<obj.length;i++){
		if (obj[i].checked){
			isChecked=true;
			break;
		}
	}
	return isChecked;
}
</script>
</head>
<body class="bg-page01">
<html:form action="/pub/queryPublishInfoList" method="post" >
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="style1">发布信息查询</td>
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
                  <td nowrap>发布类型:</td>
                  <td nowrap>
			<html:select property="publishInfo.info_type">
			<html:optionsCollection property="info_typeOptions"/>
			</html:select>
                  </td>
                  <td nowrap>标题:</td>
                  <td nowrap><html:text property="publishInfo.info_title" value="" size="12" maxlength="100"/></td>
                  <td nowrap>内容:</td>
                  <td nowrap><html:text property="publishInfo.info_content" value="" size="12" maxlength="9"/></td>
                  <td nowrap>发布到外网:</td>
                  <td nowrap>
			<html:radio property="publishInfo.info_is_out" value="1"/>是
			<html:radio property="publishInfo.info_is_out" value="0"/>否
                  </td>
                  <td align="center" nowrap colspan=2> <input type="submit" name="btnQry" value="查询"></td>
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
</html:form>

<html:form action="/pub/deletePublishInfo" method="post" >
  <html:hidden property="operName" value="PUBLISH"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">发布信息列表</td>
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
            <logic:notEqual name="ACT" value="VIW">
            <td nowrap><input type="checkbox" onclick="if(this.checked)SelectAll(this.form,'info_id');else UnSelectAll(this.form,'info_id');">选择</td>
            </logic:notEqual>
            <td nowrap>发布类型</td>
            <td nowrap>标题</td>
            <td nowrap>作者</td>
            <td nowrap>日期</td>
            <td nowrap>状态</td>
          </tr>
          <logic:present name="publishInfoList">
	  <logic:iterate id="item" name="publishInfoList" >
          <tr align="center" bgcolor="#f6f6f6" style='cursor:hand'
			  onMouseover="this.style.backgroundColor='#dff1ff'"
			  onMouseOut="this.style.backgroundColor='#f6f6f6'">
            <logic:notEqual name="ACT" value="VIW">
            <td bgcolor="#F6F6F6">
		<input type="checkbox" name="info_id" value="<bean:write name="item" property="info_id" />">
            </td>
            </logic:notEqual>
            <td><bean:write name="item" property="info_type"/></td>
            <logic:equal name="ACT" value="CFM">
            <td><a href="/pub/viewPublishInfo.do?info_id=<bean:write name="item" property="info_id"/>&ACT=CFM"><bean:write name="item" property="info_title"/></a></td>
            </logic:equal>
            <logic:equal name="ACT" value="EDT">
            <td><a href="/pub/viewPublishInfo.do?info_id=<bean:write name="item" property="info_id"/>&ACT=EDT"><bean:write name="item" property="info_title"/></a></td>
            </logic:equal>
            <logic:equal name="ACT" value="VIW">
            <td><a href="/pub/viewPublishInfo.do?info_id=<bean:write name="item" property="info_id"/>&ACT=VIW"><bean:write name="item" property="info_title"/></a></td>
            </logic:equal>
            <td><bean:write name="item" property="info_publish_person"/></td>
            <td><bean:write name="item" property="info_publish_datetime"/></td>
            <logic:equal name="item" property="info_status" value="1">
            <td>已发布</td>
            </logic:equal>
            <logic:notEqual name="item" property="info_status" value="1">
            <td>未发布</td>
            </logic:notEqual>
          </tr>
	  </logic:iterate>
          </logic:present>
        </table>

      <logic:present name="publishInfoList">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#F7EED9"> <logic:notEqual name="publishInfoList" property="firstPage" value="true" >
            <a href="?page=first">&lt;&lt;
            第一页 </a><a href="?page=previous">&lt;
            上一页 </a></logic:notEqual> <logic:notEqual name="publishInfoList" property="lastPage" value="true" >
            <a href="?page=next">下一页
            &gt; </a><a href="?page=last">最后页
            &gt;&gt; </a></logic:notEqual>&nbsp; 共<bean:write name="publishInfoList" property="rowAmount" />条记录&nbsp;
            当前第
            <input type="text" size="1" value="<bean:write name="publishInfoList" property="pageIndex" />" onChange="javascript:PageTo(this)">
            /<bean:write name="publishInfoList" property="pageAmount" />
            页&nbsp; 每页<bean:write name="publishInfoList" property="pageSize" />条</td>
        </tr>
      </table>
      </logic:present>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="center">
              <logic:notEqual name="ACT" value="VIW">
              <input type="button" name="Submit1" value="删除" onClick="doDelete(this.form);">
              </logic:notEqual>
              <input type="button" name="Submit2" value="打印" onClick="window.print()">
              <input type="button" name="Submit3" value="返回" onClick="window.history.go(-1)">
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
