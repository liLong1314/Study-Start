
//打开得到rollID的窗口
function openGetRollIDWindow(newUrl) {
	//设置窗体风格
	var myWidth = 600;
	var myHeight = 400;
	var myLeft = (screen.width - myWidth)/2;
	var myTop = (screen.height - myHeight)/2;
	sty="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=no,left="+ myLeft +",top="+ myTop +",width="+ myWidth +",height="+myHeight; 

	window.open(newUrl, "", sty);
}
//打开检查模块批量修改的窗口
function openPageCheckUpdateWindow(newUrl) {
	//设置窗体风格
	var myWidth = 400;
	var myHeight = 200;
	var myLeft = (screen.width - myWidth)/2;
	var myTop = (screen.height - myHeight)/2;
	sty="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=no,left="+ myLeft +",top="+ myTop +",width="+ myWidth +",height="+myHeight; 

	window.open(newUrl, "", sty);
}

//打开操作结果（成功与否）窗口
function openResultWindow(newUrl) {
	//设置窗体风格
	var myWidth = 400;
	var myHeight = 200;
	var myLeft = (screen.width - myWidth)/2;
	var myTop = (screen.height - myHeight)/2;
	sty="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=no,left="+ myLeft +",top="+ myTop +",width="+ myWidth +",height="+myHeight; 

	window.open(newUrl, "", sty);
}

//打开显示档案信息窗口
function openRollInfoWindow(newUrl) {
	//设置窗体风格
	var myWidth = 800;
	var myHeight = 600;
	var myLeft = (screen.width - myWidth)/2;
	var myTop = (screen.height - myHeight)/2;
	sty="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,left="+ myLeft +",top="+ myTop +",width="+ myWidth +",height="+myHeight; 

	window.open(newUrl, "", sty);
}

//打开窗口
function openWindow(myWidth, myHeight, newUrl) {
	//设置窗体风格
	var myLeft = (screen.width - myWidth)/2;
	var myTop = (screen.height - myHeight)/2;
	sty="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=no,left="+ myLeft +",top="+ myTop +",width="+ myWidth +",height="+myHeight; 

	window.open(newUrl, "", sty);
}

//以modal形式打开自定义的页面
function openDialogWindow(myUrl, myArgu, myWidth, myHeight)
{
	//设置窗体风格
	var myLeft = (screen.width - myWidth)/2;
	var myTop = (screen.height - myHeight)/2;
	sty="dialogWidth:" + myWidth + "px; dialogHeight:" + myHeight + "px; toolbar:no; status:no; location:no; scrolling:no; resize:no;"; 
	return showModalDialog(myUrl,myArgu,sty);
}