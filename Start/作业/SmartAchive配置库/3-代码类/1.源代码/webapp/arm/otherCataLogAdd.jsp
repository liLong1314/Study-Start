<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<html>
<head>
<title>�����Ŀ¼��Ϣ</title>
<link href="../common/css/sunhoo.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../common/js/base.js"></script>
<style type="text/css">
<!--
body {
	background-image: url(../image/2_mainpagebg_01.gif);
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
function doSubmit(theform){
	var obj=document.forms[0];
        if(validateForm(obj)){
		return true;
        }
		return false;
      }
function validateForm(theform){
	var cataCardNum = document.getElementById("otherCataLogInfo.cataCardNum");
	var cataNum = document.getElementById("otherCataLogInfo.cataNum");
        var cataDate = document.getElementById("otherCataLogInfo.cataDate");
        var cataCardDate = document.getElementById("otherCataLogInfo.cataCardDate");
        if(BASEtrim(cataCardNum.value)=="")
        	return BASEalert("��������ȷ��[֤��]��",cataCardNum);
        if(BASEtrim(cataNum.value)=="")
        	return BASEalert("��������ȷ��[���]��",cataNum);
        if(BASEtrim(cataDate.value)!="" && BASEisNotDate(cataDate.value))
        	return BASEalert("��������ȷ��[����]��",cataDate);
        if(BASEtrim(cataCardDate.value)!="" && BASEisNotDate(cataCardDate.value))
        	return BASEalert("��������ȷ��[��֤����]��",cataCardDate);
		return true;
	}
</script>
</head>
<body class="bg-page01">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="33"><img src="../image/2_table_l_t.gif" width="32" height="22"></td>
      <td colspan="3" background="../image/2_table_c_t.gif">&nbsp;</td>
      <td width="26"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td width="52" align="right" bgcolor="#FFFFFF"> <img src="../image/dot01.gif" width="8" height="8"><br>
      </td>
      <td width="8" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td width="667" align="left" bgcolor="#FFFFFF"> �����ڵ�λ�ã� &gt;&gt; �������� &gt;&gt;
        ȫ�ڹ��� &gt;&gt;<a href="/arm/viewAllbuildingCataLog.do" target="hmain"> ��ʷĿ¼�����</a></td>
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
                  <td align="center" bgcolor="#F2F9E6" class="tishi">���������Ŀ¼��Ϣ</td>
                </tr>
            </table></td>
          </tr>
      </table></td>
      <td width="2%"><img src="../image/2_table_r_t.gif" width="26" height="22"></td>
    </tr>
    <tr>
      <td background="../image/2_table_c_r.gif">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF"><br>
          <table width="100%" border="1">
          <tr>

            <td height="112">
              <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                <html:form action="/arm/otherCataLogAdd.do" method="post" onsubmit="return doSubmit(this.form);">
                <tr bgcolor="#FFFFFF">
                  <td align="right">����(YYYY-MM-DD)</td>
                  <td align="right"><div align="left">
                      <html:text property="otherCataLogInfo.cataDate" size="12"/>
                    </div></td>
                  <td><div align="right">���<font color="#FF0000">*</font></div></td>
                  <td><html:text property="otherCataLogInfo.cataNum" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td width="23%" align="right">��λ����</td>
                  <td width="27%" align="right"><div align="left">
                       <html:text property="otherCataLogInfo.cataUnit" size="12"/>
                    </div></td>
                  <td width="26%"><div align="right">�⽨�ص�</div></td>
                  <td width="24%"><html:text property="otherCataLogInfo.cataAddress" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">������Ŀ</td>
                  <td align="right"><div align="left">
                       <html:text property="otherCataLogInfo.cataItem" size="12"/>
                    </div></td>
                  <td><div align="right">�н���λ</div></td>
                  <td> <html:text property="otherCataLogInfo.cataBuid" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">��</td>
                  <td align="right"><div align="left">
                       <html:text property="otherCataLogInfo.cataSec" size="12"/>
                    </div></td>
                  <td><div align="right">����</div></td>
                  <td> <html:text property="otherCataLogInfo.cataValue" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">��֤����(YYYY-MM-DD)</td>
                  <td align="right"><div align="left">
                       <html:text property="otherCataLogInfo.cataCardDate" size="12"/>
                    </div></td>
                  <td><div align="right">֤��<font color="#FF0000">*</font></div></td>
                  <td> <html:text property="otherCataLogInfo.cataCardNum" size="12"/></td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">������</td>
                  <td align="right"><div align="left">
                      <html:text property="otherCataLogInfo.cataMan" size="12"/>
                    </div></td>
                  <td><div align="right">���</div></td>
                  <td> <html:text property="otherCataLogInfo.cataArea" size="12"/></td>
                  <td>&nbsp;</td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">&nbsp;</td>
                  <td align="right">��ע</td>
                  <td><html:textarea property="otherCataLogInfo.remark"/></td>
                  <td>&nbsp;</td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td align="right">&nbsp;</td>
                  <td align="right">&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr bgcolor="#FFFFFF">
                  <td colspan="2" align="center"><div align="right">
                      <input name="Submit" type="Submit" value="�ύ">
                    </div></td>
                  <td colspan="2" align="center"><div align="left">
                      <input type="reset" name="reset" value="��д">
                    </div></td>
                </tr>
               </html:form>
              </table></td>
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
