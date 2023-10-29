<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %><html>
<head>
<title>出入库查询</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style></head>
<body class="bg-page01">
<script>
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}

function isCheck(){
  var obj=document.getElementsByName("utilizeInfo.taskoption");
  for(var i=0;i<obj.length;i++){
     if(obj[i].checked) return true;
  }
  return false;
}

function doSelectMedia(obj){
  var paper=document.getElementById("paper");
  var electronic=document.getElementById("electronic");
  var mediaBoth=document.getElementById("mediaBoth");
  if(obj.name=="paper"){
    electronic.checked=false;
    mediaBoth.checked=false;
  }
  if(obj.name=="electronic"){
    paper.checked=false;
    mediaBoth.checked=false;
  }
  if(obj.name=="mediaBoth"){
    paper.checked=false;
    electronic.checked=false;
  }
}

function doSelectInOut(obj){
  var inFlag=document.getElementById("inlib");
  var outFlag=document.getElementById("outlib");
  var inoutFlag=document.getElementById("inoutlib");
  if(obj.name=="inlib"){
    outFlag.checked=false;
    inoutFlag.checked=false;
  }
  if(obj.name=="outlib"){
    inFlag.checked=false;
    inoutFlag.checked=false;
  }
  if(obj.name=="inoutlib"){
    inFlag.checked=false;
    outFlag.checked=false;
  }
}

function isCheckForQuery(obj) {
  for(var i=0;i<obj.length;i++){
    if(obj[i].checked) return true;
  }
  return false;
}

function doQuery(form){
  var beginTime=document.getElementById("beginTime");
  var endTime=document.getElementById("endTime");
  var paper=document.getElementsByName("paper");
  var electronic=document.getElementsByName("electronic");
  var mediaBoth=document.getElementsByName("mediaBoth");
  var inlib=document.getElementsByName("inlib");
  var outlib=document.getElementsByName("outlib");
  var inoutlib=document.getElementsByName("inoutlib");
  var mediaFlag= 3;
  var inoutFlag= 3;

  if(isCheckForQuery(paper))
    mediaFlag=1;
  else if(isCheckForQuery(electronic))
    mediaFlag=2;
  else if(isCheckForQuery(mediaBoth))
    mediaFlag=3;
  else
    mediaFlag=3;

  if(isCheckForQuery(inlib)){
    inoutFlag=1;
  }
  else if(isCheckForQuery(outlib)){
    inoutFlag=2;
  }
  else if(isCheckForQuery(inoutlib)){
    inoutFlag=3;
  }
  else {
    inoutFlag=3;
  }
  if(!BASEtrim(beginTime.value)=="" && BASEisNotDate(beginTime.value))
    alert("请输入正确的[开始日期]，格式为YYYY-MM-DD。");
  else if(!BASEtrim(endTime.value)=="" && BASEisNotDate(endTime.value))
    alert("请输入正确的[结束日期]，格式为YYYY-MM-DD。");
  else if(!BASECompareDate(beginTime.value,endTime.value))
    alert("[开始日期]在[结束日期]之后，请重新输入正确的开始和结束日期！");
  else
    window.location.href="/aum/QueryInOutArchives.do?mediaFlag="+mediaFlag+"&inoutFlag="+inoutFlag+"&beginTime="+beginTime.value+"&endTime="+endTime.value;
}



</script>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="4%"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="94%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif" bgcolor="#FFFFFF"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#99CC00">
            </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>

    <td background="../image/2_table_c_r.gif" width="26" height="12">&nbsp;</td>
    <td align="center"    bgcolor="#FFFFFF">
      <table width="95%" border="1">
        <tr>
          <td height="20">
          <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr align="center" bgcolor="#FFFFFF">
              <%request.setAttribute("mediaFlag",request.getParameter("mediaFlag"));%>
              <%request.setAttribute("inoutFlag",request.getParameter("inoutFlag"));%>
                <td width="25%" align="center">
                   <input type="radio" name="paper" value="1" onclick="doSelectMedia(this)"
                    <logic:equal name="mediaFlag" value="1">checked</logic:equal>>纸质
                   <input type="radio" name="electronic" value="2" onclick="doSelectMedia(this)"
                    <logic:equal name="mediaFlag" value="2">checked</logic:equal>>电子
                   <input type="radio" name="mediaBoth" value="3" onclick="doSelectMedia(this)"
                    <logic:equal name="mediaFlag" value="3">checked</logic:equal>>所有
                </td>
                <td width="25%" align="center">
                   <input type="radio" name="inlib" value="1" onclick="doSelectInOut(this)"
                    <logic:equal name="inoutFlag" value="1">checked</logic:equal>>入库
                   <input type="radio" name="outlib" value="2" onclick="doSelectInOut(this)"
                    <logic:equal name="inoutFlag" value="2">checked</logic:equal>>出库
                   <input type="radio" name="inoutlib" value="3" onclick="doSelectInOut(this)"
                    <logic:equal name="inoutFlag" value="3">checked</logic:equal>>所有
                </td>
                <td width="60%" align="center">申请时间：
                  <input type="text" name="beginTime" size="10">至
                  <input type="text" name="endTime" size="10">
                </td>
                <td width="10%">
                   <input type="button" name="Submit" value="查询" onclick="doQuery(this.form)" >
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

    <td background="../image/2_table_c_b.gif">&nbsp;</td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">出入库查询&gt;&gt;查询结果</td>
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
            <td nowrap>类目名称</td>
            <td nowrap>档号</td>
            <td nowrap>案卷名称</td>
            <td nowrap>文件名称</td>
            <td nowrap>页数</td>
          </tr>
          <logic:present name="utilizeDetailList">
          <logic:iterate id="item" name="utilizeDetailList">
          <tr align="center">
            <td bgcolor="#f6f6f6"><bean:write name="item" property="entry_name"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="item" property="archives_num"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="item" property="archives_name"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="item" property="file_name"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="item" property="page_count"/></td>
          </tr>
          </logic:iterate>
          </logic:present>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td colspan="3" bgcolor="#F7EED9">
            <input name="Submit3" type="button" value="打印" onclick="window.print()">
          </tr>
        </table>
        <br>
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
</html>

