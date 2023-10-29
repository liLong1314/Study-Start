<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>业务类文件列表</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script src="/common/tree/alai_tree.js"></script>
<script src="/common/tree/alai_tree_win2k.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
	font-size:9pt;
}
-->
</style>
</head>
<body class="bg-page01">
<script>
//点击节点的接口函数
function doClick(projId,upPhaseId,phaseId){
        var ARCHIVES_ID = document.all("ARCHIVES_ID").value;
        window.location.href="/aum/utilizeArchivesFileListByPhaseId.do"
                + "?ARCHIVES_ID=" + ARCHIVES_ID
                + "&PROJ_ID=" + projId
                + "&UP_PHASE_ID=" + upPhaseId
                + "&PHASE_ID=" + phaseId;
}
</script>

<form action="" method="post" >
<input type="hidden" name="ARCHIVES_ID" value="<bean:write  name ="ArchivesFileForm" property="archives.AARCHIVES_ID"/>">
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
      <td width="637" align="left" bgcolor="#FFFFFF">您现在的位置：&gt;&gt; 档案采集 &gt;&gt; 档案信息(业务类)</td>
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
                  <td align="center" bgcolor="#E4F2FA" class="tishi">档案文件结构树</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><br>
	<!--档案结构树-->
	<div id="divTree"></div>

	<script>
	/*开始构建目录树*/
	var tree=new alai_tree_win2k(divTree);
	var root=tree.root;
	/*
	//动态脚本开始
	var LvlNode1;
	LvlNode1 = root.add("第二个项目名称");
	LvlNode1.onclick = "doClick(1002,0,0)";
	//动态脚本结束
	*/
	<%
	if (request.getAttribute("archivesFilesList")!=null){
		out.println(request.getAttribute("archivesFilesList"));
	}
	%>
	/*收缩目录树*/
	tree.expandToTier(10);

	/*简单的目录树事件处理*/
	tree.onmouseover=function(node){
		node.label.style.textDecoration="underline"
	}
	tree.onmouseout=function(node){
		node.label.style.textDecoration="none"
	}
	</script>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="center" bgcolor="#F7EED9">
              <input type="button" name="Submit5" value="打印" onClick="window.print()">
              <input type="button" name="Submit2" value="返回" onClick="window.history.go(-1)">
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
</form>
</body>
</html>
