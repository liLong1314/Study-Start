function delConfirm(frm,hidden){
  var isDelete = confirm("�����Ҫɾ����Щ��¼��");
  if(isDelete) {
	getCheckedValues(frm,hidden);
	return true;
  }
  return false;
}

function getCheckedValues(frm,hidden){
var str = '';
var delimeter = ',';
var counter = 0;
for(var i=0;i<frm.elements.length;i++){
 if((frm.elements[i].type=="checkbox") && (frm.elements[i].checked)){
	 if(counter==0){str += frm.elements[i].value;}
	 else{str += delimeter + frm.elements[i].value;}
	 counter++;
 }
}
if(counter!=0){
	hidden.value = str;
}
}

function setCheckBoxes(frm,flag){
for(var i=0;i<frm.elements.length;i++){
 if(frm.elements[i].type=="checkbox"){
	 frm.elements[i].checked = flag;
 }
}
}

function gotoPage(pageIndex) {
	var n=pageIndex.length;
	for (var i=0;i<n;i++ )
	{	if(pageIndex.substring(i,i+1)>"9"||pageIndex.substring(i,i+1)<"0") {
			alert("���������֣�" );
			return false;
		}
	}
	location = "?page=" + pageIndex;
}