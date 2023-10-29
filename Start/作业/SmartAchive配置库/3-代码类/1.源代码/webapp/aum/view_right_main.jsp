<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %><html>
<head>
<title>查阅管理</title>
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
  function doChange(obj){
    window.location.href=obj.options[obj.selectedIndex].url;
  }
  function gotoPage(obj) {
    var pageIndex = document.all.pageIndex.value;
    var pageAmount=document.all.pageAmount.value;
    if(pageIndex>pageAmount){
      alert("您所选择的页应小于总页数["+pageAmount+"]，请重新选择！");
      document.all.pageIndex.focus();
    }
    else {
      window.location.href = "?pagingFlag=any&pageIndex=" + pageIndex;
    }
  }
  function MM_openBrWindow(theURL,winName,features) { //v2.0
    window.open(theURL,winName,features);
  }

  function doFilter(filterFlag) {
    window.location.href="/aum/ViewTaskList.do?flag=" + filterFlag;
  }

function mySubmit(flag){
  var obj=document.all.flag;
  if(flag==1) {
    obj.value="HANDLER"
    if(!isCheck()){
      alert("请选择一个要处理的任务！");
    }
    else{
      document.UtilizeInfoForm.submit();
    }
  }
  else if(flag=2){
    obj.value="TRACE"
    if(!isCheck())
      alert("请选择一个要跟踪的任务！");
    else
      document.UtilizeInfoForm.submit();
  }

  //MM_openBrWindow('view_handler_form.jsp','借阅管理','width=700,height=500')
}

function isCheck(){
  var obj=document.getElementsByName("utilizeInfo.taskoption");
  for(var i=0;i<obj.length;i++){
     if(obj[i].checked) return true;
  }
  return false;
}

function isCheckForQuery(obj) {
  for(var i=0;i<obj.length;i++){
    if(obj[i].checked) return true;
  }
  return false;
}


function doSelect(obj){
  var obj1=document.getElementsByName("utilizeInfo.taskoption");
  var obj2=document.getElementsByName("flagHandler1");
  var obj3=document.getElementById("flagHandler");
  for(var i=0;i<obj1.length;i++){
    if(obj1[i].checked){
      obj3.value=obj2[i].value;
      break;
    }
  }
}

function doFilter(obj){
  var unhandled = document.getElementById("unhandled");
  var handled = document.getElementById("handled");
  var both = document.getElementById("both");
  if(obj.name=="unhandled") {
    handled.checked=false;
    both.checked=false;
  }
  if(obj.name=="handled") {
    unhandled.checked=false;
    both.checked=false;
  }
  if(obj.name=="both") {
    handled.checked=false;
    unhandled.checked=false;
  }
}

function doCombQuery(form){

  var applyBeginTime = document.getElementById("applyBeginTime");
  var applyEndTime = document.getElementById("applyEndTime");
  var utilizer = document.getElementById("utilizer");
  var deliverBeginTime = document.getElementById("deliverBeginTime");
  var deliverEndTime = document.getElementById("deliverEndTime");
  var unhandled = document.getElementsByName("unhandled");
  var handled = document.getElementsByName("handled");
  var both = document.getElementsByName("both");
  var queryFlag=3;

  if(isCheckForQuery(unhandled))
    queryFlag=1;
  if(isCheckForQuery(handled))
    queryFlag=2;
  if(isCheckForQuery(both))
    queryFlag=0;

  if(!BASEtrim(applyBeginTime.value)=="" && BASEisNotDate(applyBeginTime.value))
    alert("请输入正确的[申请开始日期]，格式为YYYY-MM-DD。");
  else if(!BASEtrim(applyEndTime.value)=="" && BASEisNotDate(applyEndTime.value))
    alert("请输入正确的[申请结束日期]，格式为YYYY-MM-DD。");
  else if(!BASECompareDate(applyBeginTime.value,applyEndTime.value))
    alert("[申请开始日期]在[申请结束日期]之后，请重新输入正确的开始和结束日期！");
  else if(!BASEtrim(deliverBeginTime.value)=="" && BASEisNotDate(deliverBeginTime.value))
    alert("请输入正确的处理[开始日期]，格式为YYYY-MM-DD。");
  else if(!BASEtrim(deliverEndTime.value)=="" && BASEisNotDate(deliverEndTime.value))
    alert("请输入正确的处理[查询结束日期]，格式为YYYY-MM-DD。");
  else if(!BASECompareDate(deliverBeginTime.value,deliverEndTime.value))
    alert("处理[开始日期]在处理[结束日期]之后，请重新输入正确的开始和结束日期！");
  else
    window.location.href="/aum/ViewTaskList.do?queryFlag="+queryFlag+"&deliverBeginTime="+deliverBeginTime.value+"&deliverEndTime="+deliverEndTime.value+"&applyBeginTime="+applyBeginTime.value+"&applyEndTime="+applyEndTime.value+"&utilizer="+utilizer.value;;


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
      <form action="/aum/ViewTaskList.do" method="post">
      <table width="95%" border="1">
        <tr>
          <td height="20">
          <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
              <tr align="center" bgcolor="#FFFFFF">
                <td width="40%" align="center">
                  <logic:equal name="filterFlag" value="0">
                       <input type="radio" name="unhandled" value="3" onclick="doFilter(this)">未处理
                       <input type="radio" name="handled" value="4" onclick="doFilter(this)">已处理
                       <input type="radio" name="both" value="5" onclick="doFilter(this)">所有
                  </logic:equal>
                </td>
                <td width="50%" align="center">处理日期：
                  <input type="text" name="deliverBeginTime" size="10">至
                  <input type="text" name="deliverEndTime" size="10">
                </td>
                <td width="10%" align="center">
                </td>
              </tr>
              <tr align="center" bgcolor="#FFFFFF">
                <td width="40%" align="center">
                  查阅者姓名：<input type="text" name="utilizer">
                </td>
                <td width="50%" align="center">申请日期：
                  <input type="text" name="applyBeginTime" size="10">至
                  <input type="text" name="applyEndTime" size="10">
                </td>
                <td rowspan="2" width="10%">
                   <input type="button" name="Submit2" value="查询" onclick="doCombQuery(this.form)" >
                </td>
              </tr>
            </table>

        </td>
        </tr>
      </table>
      </form></td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">查阅管理&gt;&gt;任务列表</td>
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
        <html:form action="/aum/ViewShowForm.do" method="post">
          <input type="hidden" name="flag">
          <input type="hidden" name="flagHandler">
          <tr align="center" bgcolor="#F7EED9">
            <td nowrap>选择</td>
            <td nowrap>是否已处理</td>
            <td nowrap>查阅者姓名</td>
            <td nowrap>查阅者单位</td>
            <td nowrap>查阅方式</td>
            <td nowrap>申请日期</td>
            <td nowrap>查阅期限(天)</td>
            <td nowrap>处理环节</td>
          </tr>
          <logic:present name="taskListForPaging">
          <logic:iterate id="task" name="taskListForPaging">
          <tr align="center">
            <td bgcolor="#f6f6f6">
              <input type="radio" name="utilizeInfo.taskoption" value="<bean:write name="task" property="applyID"/>" onclick="doSelect(this)">
            </td>
            <td bgcolor="#f6f6f6">
              <input type="hidden" name="flagHandler1" value="<bean:write name="task" property="flagHandler"/>">
              <input type="hidden" name="utilizeStatus" value="<bean:write name="task" property="utilizeStatus"/>">
              <logic:equal name="task" property="utilizeStatus" value="REGCONFIRMED">
                <font color="green">
                <marquee direction=left width=70 id=cool scrollamount=1 scrolldelay=2 height=20 >
                <bean:write name="task" property="flagHandler"/>（可查看）
                </marquee></font>
              </logic:equal>
              <logic:notEqual name="task" property="utilizeStatus" value="REGCONFIRMED">
                <bean:write name="task" property="flagHandler"/></font>
              </logic:notEqual>
           </td>
            <td bgcolor="#f6f6f6"><bean:write name="task" property="personName"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="task" property="personCorp"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="task" property="modeName"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="task" property="beginDate"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="task" property="utilizeTerm"/></td>
            <td bgcolor="#f6f6f6"><bean:write name="task" property="taskName"/></td>
          </tr>
          </logic:iterate>
          </logic:present>
        </table>
        <logic:present name="pagingHelper">
        <input type="hidden" name="pageAmount" value="<bean:write name="pagingHelper" property="pageAmount" />"/>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td bgcolor="#F7EED9">
            <logic:equal name="pagingHelper" property="firstPage" value="0" >
              <a href="?pagingFlag=first&pageIndex=<bean:write name="pagingHelper" property="pageIndex" />">&lt;&lt;
              第一页 </a><a href="?pagingFlag=previous&pageIndex=<bean:write name="pagingHelper" property="pageIndex" />">&lt;
              上一页 </a>
            </logic:equal>
            <logic:equal name="pagingHelper" property="lastPage" value="0" >
              <a href="?pagingFlag=next&pageIndex=<bean:write name="pagingHelper" property="pageIndex" />">下一页
              &gt; </a><a href="?pagingFlag=last&pageIndex=<bean:write name="pagingHelper" property="pageIndex" />">最后页
              &gt;&gt; </a>
            </logic:equal>
              &nbsp; 共<bean:write name="pagingHelper" property="amountOfObject" />条记录&nbsp;
              当前第
              <input type="text" name="pageIndex" size="1" value="<bean:write name="pagingHelper" property="pageIndex" />" onChange="javascript:gotoPage(this)">
              /<bean:write name="pagingHelper" property="pageAmount" />
              页&nbsp; 每页<bean:write name="pagingHelper" property="pageSize" />条</td>
          </tr>
        </table>
        </logic:present>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td colspan="3" bgcolor="#F7EED9">
            <input name="Submit1" type="button" value="处理" onclick="mySubmit(1)">
            <input name="Submit2" type="button" value="跟踪" onclick="mySubmit(2)">
          </tr>
          </html:form>
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

