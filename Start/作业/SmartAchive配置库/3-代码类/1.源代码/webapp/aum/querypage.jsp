<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%
String fileId=request.getSession().getAttribute("tmpfileId").toString();
%>

<html:html>
<head>
<title>�����ۺϲ�ѯ-�鿴ҳ��</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script>
function showImage(id){
	var iWidth =screen.width-20;
	var iHeight=screen.height-80;
	//alert(iWidth);alert(iHeight);
	var para = "toolbar=0,location=0,status=0,scrollbars=0,resizable=0,top=5,left=5,width="+iWidth+",height="+iHeight
	//alert(para);
	//ע�⣺�ڵ���������Ӱ��ҳ����ֲ�����ʾ�����⣨֣��ȫ��20040220��
	//window.open("/aum/ImageShow.do?pageId=" + id,"image",para);
	window.location.href="/aum/ImageShow.do?pageId=" + id;
}
</script>
</head>
<body class="bg-page01">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="39"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="50" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
    <td width="620" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã� <a href="/aum/ArchQuery.do">�����ۺϲ�ѯ</a>
      &gt;&gt; <a href="/aum/FileLook.do">�����ļ�</a> &gt;&gt; ����ҳ��</td>
      <td background="../image/2_table_c_l.gif">&nbsp;</td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td colspan="3" background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
  <!--
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                  <td align="center" bgcolor="#E4F2FA" class="tishi">ҳ���ѯ</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"> <br> <table width="100%" height="37" border="1">
          <tr>
            <td height="31">
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
		<html:form action="/aum/PageQuery.do" method="post">
                <tr bgcolor="#FFFFFF">
                <td width="20%" height="25" nowrap>ҳ��</td>
                  <td width="20%" nowrap>
                    <html:hidden property="pageOperInfo.fileId" value="<%=fileId%>"/>
                    <html:text property="pageOperInfo.pageNum" size="10"/>
                  </td>
                <td width="20%" nowrap>ҳ����</td>
                  <td width="20%" nowrap>
                    <html:text property="pageOperInfo.pageType" size="10"/>
                  </td>
                  <td rowspan="2" nowrap>
                    <input type="submit" name="Submit" value="��ѯ">
                  </td>
                </tr>
                <tr bgcolor="#FFFFFF">
                <td width="20%" height="25" nowrap>ҳ��</td>
                  <td width="20%" nowrap>
                    <html:text property="pageOperInfo.pageSize" size="10"/>
                  </td>
                <td width="20%" nowrap>¼������</td>
                  <td width="20%" nowrap>
                    <html:text property="pageOperInfo.pageDate" size="10"/>
                  </td>
                </tr>
		</html:form>
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
  </table>-->
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="32"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td width="100%" background="../image/2_table_c_t.gif"><table width="237" border="0" cellspacing="0" cellpadding="0">
          <tr align="center">
            <td width="25" align="right" background="../image/2_table_c_t.gif"><img src="../image/dot01.gif" width="8" height="8"></td>
            <td width="212"><table width="200" border="0" cellpadding="2" cellspacing="1" bgcolor="#00A8CC">
                <tr>
                <td align="center" bgcolor="#E4F2FA" class="tishi">����Ӱ��ҳ�б�</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif"><img src="../image/2_table_c_r.gif" width="32" height="234"></td>
      <td align="center" bgcolor="#FFFFFF" valign="top">
      <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF">
        <tr align="center" bgcolor="#F7EED9">
          <td width="20%">ҳ��</td>
          <td width="20%">ҳ����</td>
          <td width="20%">ҳ��</td>
          <td width="20%">¼������</td>
          <td width="20%">����</td>
        </tr>
        <logic:present name="PageOpers">
	<logic:iterate id="pageOper" name="PageOpers">
        <tr align="center">
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="pageOper" property="pageNum"/></td>
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="pageOper" property="pageType"/></td>
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="pageOper" property="pageSize"/></td>
          <td bgcolor="#f6f6f6" width="20%"><bean:write name="pageOper" property="pageDate"/></td>
          <td bgcolor="#f6f6f6" width="20%"><a href="javascript:showImage('<bean:write name="pageOper" property="pageId"/>');" >�鿴Ӱ��</a></td>
        </tr>
        </logic:iterate>
	</logic:present>
      </table>
		<input type="button" name="Submit1" value="��ӡ" onclick="window.print();">
              	<input type="button" name="Submit2" value="����" onclick="window.history.go(-1);">
    </td>
      <td background="../image/2_table_c_l.gif"><img src="../image/2_table_c_l.gif" width="26" height="138"></td>
    </tr>
    <tr>
      <td><img src="../image/2_table_r_b.gif" width="32" height="20"></td>
      <td background="../image/2_table_c_b.gif"><img src="../image/2_table_c_b.gif" width="115" height="20"></td>
      <td><img src="../image/2_table_l_b.gif" width="26" height="20"></td>
    </tr>
  </table>
</body>
</html:html>
