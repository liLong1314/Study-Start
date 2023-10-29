<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%
String entryId=(String)request.getSession().getAttribute("ENTRY_ID");
if (entryId==null) entryId="";
String entryLevel=(String)request.getSession().getAttribute("ENTRY_LEVEL");
if (entryLevel==null) entryLevel="";
String isOperation=(String)request.getSession().getAttribute("ISOPERATION");
if (isOperation==null) isOperation="";
%>
<html:html>
<head>
<title>档案查询</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script>
function doQuery(theform,type){
	//var obj=document.all("actionName");
	if(type==1){
	  //一般查询
	  //obj.value="1";
  	}else if(type==2){
	  //模糊查询
          //obj.value="2";
  	}else if(type==3){
	  //业务查询
	  var objName=document.all("fieldName");
	  var objValue=document.all("fieldValue");
          if (objName.value=="" || objValue.value==""){
		alert("请选择扩展字段并输入查询内容！");
		return false;
          }
          if(objName.value!="") objName.value=objName.value.substring(0,objName.value.length-1);
          if(objValue.value!="") objValue.value=objValue.value.substring(0,objValue.value.length-1);
          //alert(objName.value);alert(objValue.value);
          //obj.value="3";
  	}
	//theform.submit();
	return true;
}

function doAddField(){
	var objTmpName=document.all("tmpFieldName");
	var objTmpValue=document.all("tmpFieldValue");
	var objName=document.all("fieldName");
	var objValue=document.all("fieldValue");
	var objLabel=document.all("fieldLabel");
	if(isCanAdd(objTmpName,objTmpValue)){
		var aa=objTmpName.options[objTmpName.selectedIndex].value;
		objName.value  += aa + ",";
		objValue.value += objTmpValue.value + ",";
		objLabel.innerHTML += "[" + aa + "]    包含    \"" + objTmpValue.value + "\"<br>";
		objTmpValue.value="";
	}
}
function isCanAdd(obj1,obj2){
	if(obj1.selectedIndex==0){
		alert("请选择字段名称");
		obj1.focus();
		return false;
	}
	if(obj2.value==""){
		alert("请输入查询内容");
		obj2.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body class="bg-page01">
<html:form action="/aum/queryArchives.do?flag=first" method="post" onsubmit="return doQuery(this,'1');">
<html:hidden property="archOperInfo.entryId" value="<%=entryId%>"/>
<html:hidden property="archOperInfo.archivesStatus" value=""/>
<input type="hidden" name="entryLevel" value="<%=entryLevel%>">
<input type="hidden" name="actionName" value="1">
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

    <td width="653" align="left" bgcolor="#FFFFFF"> 您现在的位置：档案综合查询</td>
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
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
                <tr>
                  <td align="center" bgcolor="#F2F9E6" class="tishi">案卷查询</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br> <table width="100%" height="37" border="0">
          <tr>
            <td height="31">
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr bgcolor="#FFFFFF">
                <td nowrap>档号</td>
                <td nowrap> <html:text property="archOperInfo.archivesNum" size="20" value=""/>
                </td>
                <td nowrap>案卷/件题名</td>
                <td nowrap><html:text property="archOperInfo.archivesName" size="20" value=""/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td nowrap>项目编号（预审号）</td>
                <td nowrap><html:text property="archOperInfo.projId" size="20" value=""/></td>
                <td nowrap>项目名称</td>
                <td nowrap><html:text property="archOperInfo.projName" size="20" value=""/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td nowrap>建设单位</td>
                <td nowrap><input type="text" name="archOperInfo.archFoundUnit" size="20" value=""></td>
                <td nowrap>年度</td>
                <td nowrap><html:text property="archOperInfo.archivesYear" size="4" value=""/>
		<input type="submit" name="Submit" value="案卷/件查询">
                </td>
              </tr><!--
              <tr bgcolor="#FFFFFF">
                <td width="16%" height="25" nowrap>立档单位</td>
                <td width="16%" nowrap><html:text property="archOperInfo.archFoundUnit" size="15" value=""/></td>
                <td width="16%" nowrap>立卷时间</td>
                <td width="16%" nowrap><html:text property="archOperInfo.archFoundDate" size="10" value=""/></td>
                <td width="16%" nowrap>立卷人</td>
                <td width="16%" nowrap><html:text property="archOperInfo.archFoundMan" size="8" value=""/></td>
              </tr>
              <tr bgcolor="#FFFFFF">
                <td colspan="6" nowrap align="center">
                  <input type="button" name="Submit" value="案卷/件查询" onclick="doQuery(this.form,1);">
                </td>
              </tr>-->
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
<html:form action="/aum/queryArchives.do?flag=first" method="post">
<html:hidden property="archOperInfo.entryId" value="<%=entryId%>"/>
<html:hidden property="archOperInfo.archivesStatus" value=""/>
<input type="hidden" name="entryLevel" value="<%=entryLevel%>">
<input type="hidden" name="actionName" value="2">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
    <td width="94%" background="../image/2_table_c_t.gif">
      <table width="237" border="0" cellspacing="0" cellpadding="0">
        <tr align="center">
          <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
          <td width="212">
            <table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
              <tr>
                <td align="center" bgcolor="#F2F9E6" class="tishi">模糊查询</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
    <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
  </tr>
  <tr>
    <td background="../image/2_table_c_r.gif">&nbsp;</td>
    <td align="center" bgcolor="#FFFFFF"> <br>
      <table width="100%" height="37" border="0">
        <tr>
          <td height="31">
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr bgcolor="#FFFFFF">
                <td width="20%" height="25" nowrap>请输入查询文字：</td>
                <td width="50%" nowrap> <html:text property="archOperInfo.blurquery" value="" size="15"/>
                </td>
                <td width="30%" nowrap>
                  <input type="submit" name="Submit" value="模糊查询" >
                </td>
              </tr>
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
</html:form>
<%if (isOperation!=null && !isOperation.equals("0")){%>
<html:form action="/aum/queryArchives.do?flag=first" method="post" onsubmit="return doQuery(this,'3');">
<html:hidden property="archOperInfo.entryId" value="<%=entryId%>"/>
<html:hidden property="archOperInfo.archivesStatus" value=""/>
<input type="hidden" name="entryLevel" value="<%=entryLevel%>">
<input type="hidden" name="actionName" value="3">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
    <td width="94%" background="../image/2_table_c_t.gif">
      <table width="237" border="0" cellspacing="0" cellpadding="0">
        <tr align="center">
          <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
          <td width="212">
            <table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
              <tr>
                <td align="center" bgcolor="#F2F9E6" class="tishi">扩展信息查询</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
    <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
  </tr>
  <tr>
    <td background="../image/2_table_c_r.gif">&nbsp;</td>
    <td align="center" bgcolor="#FFFFFF"> <br>
      <table width="100%" height="37" border="0">
        <tr>
          <td height="31">
            <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr bgcolor="#FFFFFF">
                <td nowrap colspan=4>
		<select name="tmpFieldName">
		<option value="">--请选择查询字段--</option>
		<logic:present name="fieldNames">
		<logic:iterate id="element" name="fieldNames">\
		<option value="<bean:write name="element" property="field_cname"/>"><bean:write name="element" property="field_cname"/></option>
		</logic:iterate>
		</logic:present>
            	</select>
		<input type="text" name="tmpFieldValue" value="" size="30">
		<input type="button" name="add" value=" ＋ " onclick="doAddField();">
		</td>
              </tr>
              <tr bgcolor="#FFFFFF" align="left">
                <td colspan="4" height="25" nowrap>
			<div id="fieldLabel"></div>
			<input type="hidden" name="fieldName" value="">
			<input type="hidden" name="fieldValue" value="">
                </td>
              </tr>
              <tr bgcolor="#FFFFFF" align="center">
                <td colspan="4" height="25" nowrap>
                  <input type="submit" name="Submit2" value="扩展信息查询" >
                </td>
              </tr>
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
</html:form>
<%}%>
</body>
</html:html>
