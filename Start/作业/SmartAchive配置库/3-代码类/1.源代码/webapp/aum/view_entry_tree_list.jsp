<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>entryTreeList</title>
<script src="/common/tree/alai_tree.js"></script>
<script src="/common/tree/alai_tree_win2k.js"></script>
<style>
body{font-size:9pt;}
</style>
</head>
<body background="../image/2_mainpagebg_01.gif">
<hr>
<table border="0">
    <tr>
      <td><div id="divTree"></div></td>
    </tr>
</table>
<script>
/*��ʼ����Ŀ¼��*/
var tree1=new alai_tree_win2k(divTree)
/********************************************
 ���´�����ʾ����ʹ�ø������Ŀ¼�ڵ�ķ���
*********************************************/
var root=tree1.root
<%
if (request.getAttribute("EntryTree")!=null){
	out.println(request.getAttribute("EntryTree"));
}
%>

/*����Ŀ¼��*/
tree1.expandToTier(1)

/*�򵥵�Ŀ¼���¼�����*/
tree1.onmouseover=function(node)
{
	node.label.style.textDecoration="underline"
}
tree1.onmouseout=function(node)
{
	node.label.style.textDecoration="none"
}

function doClick(url){
	//window.parent.abc.location=url;
	window.parent.hmain.location=url;
}
</script>
<hr>
</body>
</html>

