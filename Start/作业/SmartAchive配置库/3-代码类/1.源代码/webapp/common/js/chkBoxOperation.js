//ѡ�����и�ѡ��
//form:��ѡ��������form
//objName:��ѡ���Name
function SelectAll(form,objName){

	for (var i = 0; i < form.elements.length; i++) {
	  if (form.elements[i].type == "checkbox") {
	    if (form.elements[i].name == objName) {
	       form.elements[i].checked = true;
	    }
	  }
	}
}

//��;��Web��ѡ����ͼ�е����и�ѡ��ķ�������
//form:��ѡ��������form
//objName:��ѡ���Name
function UnSelectAll(form,objName){
	
	for (var i = 0; i < form.elements.length; i++) {
	  if (form.elements[i].type == "checkbox") {
	    if (form.elements[i].name == objName) {
	       form.elements[i].checked = false;
	    }
	  }
	}	
}