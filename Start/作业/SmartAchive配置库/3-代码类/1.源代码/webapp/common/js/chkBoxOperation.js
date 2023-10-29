//选中所有复选框
//form:复选框所属的form
//objName:复选框的Name
function SelectAll(form,objName){

	for (var i = 0; i < form.elements.length; i++) {
	  if (form.elements[i].type == "checkbox") {
	    if (form.elements[i].name == objName) {
	       form.elements[i].checked = true;
	    }
	  }
	}
}

//用途：Web上选中视图中的所有复选框的反操作；
//form:复选框所属的form
//objName:复选框的Name
function UnSelectAll(form,objName){
	
	for (var i = 0; i < form.elements.length; i++) {
	  if (form.elements[i].type == "checkbox") {
	    if (form.elements[i].name == objName) {
	       form.elements[i].checked = false;
	    }
	  }
	}	
}