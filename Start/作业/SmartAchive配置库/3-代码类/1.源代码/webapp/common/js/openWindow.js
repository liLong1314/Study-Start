
//�򿪵õ�rollID�Ĵ���
function openGetRollIDWindow(newUrl) {
	//���ô�����
	var myWidth = 600;
	var myHeight = 400;
	var myLeft = (screen.width - myWidth)/2;
	var myTop = (screen.height - myHeight)/2;
	sty="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=no,left="+ myLeft +",top="+ myTop +",width="+ myWidth +",height="+myHeight; 

	window.open(newUrl, "", sty);
}
//�򿪼��ģ�������޸ĵĴ���
function openPageCheckUpdateWindow(newUrl) {
	//���ô�����
	var myWidth = 400;
	var myHeight = 200;
	var myLeft = (screen.width - myWidth)/2;
	var myTop = (screen.height - myHeight)/2;
	sty="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=no,left="+ myLeft +",top="+ myTop +",width="+ myWidth +",height="+myHeight; 

	window.open(newUrl, "", sty);
}

//�򿪲���������ɹ���񣩴���
function openResultWindow(newUrl) {
	//���ô�����
	var myWidth = 400;
	var myHeight = 200;
	var myLeft = (screen.width - myWidth)/2;
	var myTop = (screen.height - myHeight)/2;
	sty="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=no,left="+ myLeft +",top="+ myTop +",width="+ myWidth +",height="+myHeight; 

	window.open(newUrl, "", sty);
}

//����ʾ������Ϣ����
function openRollInfoWindow(newUrl) {
	//���ô�����
	var myWidth = 800;
	var myHeight = 600;
	var myLeft = (screen.width - myWidth)/2;
	var myTop = (screen.height - myHeight)/2;
	sty="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=yes,left="+ myLeft +",top="+ myTop +",width="+ myWidth +",height="+myHeight; 

	window.open(newUrl, "", sty);
}

//�򿪴���
function openWindow(myWidth, myHeight, newUrl) {
	//���ô�����
	var myLeft = (screen.width - myWidth)/2;
	var myTop = (screen.height - myHeight)/2;
	sty="toolbar=no,location=no,directories=no,status=no,resizable=no,scrollbars=no,left="+ myLeft +",top="+ myTop +",width="+ myWidth +",height="+myHeight; 

	window.open(newUrl, "", sty);
}

//��modal��ʽ���Զ����ҳ��
function openDialogWindow(myUrl, myArgu, myWidth, myHeight)
{
	//���ô�����
	var myLeft = (screen.width - myWidth)/2;
	var myTop = (screen.height - myHeight)/2;
	sty="dialogWidth:" + myWidth + "px; dialogHeight:" + myHeight + "px; toolbar:no; status:no; location:no; scrolling:no; resize:no;"; 
	return showModalDialog(myUrl,myArgu,sty);
}