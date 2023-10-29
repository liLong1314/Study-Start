function BASEalert(msg,obj){
	alert(msg);
	obj.focus();
	if (obj.type.indexOf("select")==-1)
		obj.select();
	return false;
}


function BASEtrim(str){
	  str=str.toString()
	  lIdx=0;rIdx=str.length;
	  if (BASEtrim.arguments.length==2)
	    act=BASEtrim.arguments[1].toLowerCase()
	  else
	    act="all"
      for(var i=0;i<str.length;i++){
	  	thelStr=str.substring(lIdx,lIdx+1)
		therStr=str.substring(rIdx,rIdx-1)
        if ((act=="all" || act=="left") && thelStr==" "){
			lIdx++
        }
        if ((act=="all" || act=="right") && therStr==" "){
			rIdx--
        }
      }
	  str=str.slice(lIdx,rIdx)
      return str
}

//检查输入元素是否日期(格式必须为YYYY-MM-DD)
//输入：日期所在的Text对象
//输出：如果非法，则为true；否则为false
function BASEisNotDate(value) {
	//var obj = document.getElementById("test");
	//var value = obj.value;
	var YYYY = value.substring(0,value.indexOf("-"));
	var MM   = value.substring(value.indexOf("-")+1,value.lastIndexOf("-"));
	var DD   = value.substring(value.lastIndexOf("-")+1,value.length);
	//alert(YYYY + "/" + MM + "/" + DD);
	if((YYYY.length)!=4) 	return true;
	if((MM.length)>2) 	return true;
	if((DD.length)>2) 	return true;
	if (isNaN(Date.parse(MM + "/" + DD + "/" + YYYY))) {
		return true;
	}else{
		var dd= parseInt(DD,10);
		var mm = parseInt(MM,10)-1;
		var yy = parseInt(YYYY,10);
		var date = new Date(yy,mm,dd);
		if (dd!=date.getDate() || mm!=date.getMonth() || yy!=date.getFullYear()) {
			return true;
		}
	}
	return false;
}


//检查两个日期的大小(格式必须为YYYY-MM-DD)
//输入：两个日期分别所在的Text对象
//输出：如果第一个日期大于第二个日期，则为false；否则为true
function BASECompareDate(beginDate,endDate) {
	var YYYY1 = beginDate.substring(0,beginDate.indexOf("-"));
	var MM1   = beginDate.substring(beginDate.indexOf("-")+1,beginDate.lastIndexOf("-"));
	var DD1   = beginDate.substring(beginDate.lastIndexOf("-")+1,beginDate.length);
	var YYYY2 = endDate.substring(0,endDate.indexOf("-"));
	var MM2   = endDate.substring(endDate.indexOf("-")+1,endDate.lastIndexOf("-"));
	var DD2   = endDate.substring(endDate.lastIndexOf("-")+1,endDate.length);
	var beginDateNumValue = parseFloat(YYYY1)*10000+parseFloat(MM1)*100+parseFloat(DD1)
	var endDateNumValue = parseFloat(YYYY2)*10000+parseFloat(MM2)*100+parseFloat(DD2)
	if(beginDateNumValue>endDateNumValue)
          return false;
	else
          return true;
}


function NumInput(sTag)
{
 if(sTag=="")
   {
     if((event.keyCode<48)||(event.keyCode>57))
       event.returnValue=false;
   }
 else
   {
     if((event.keyCode<48)||(event.keyCode>57 ))
       if(event.keyCode!=46 || event.keyCode<0) event.returnValue=false;
   }
}

//检查输入元素是否数值
//输入：待检查值
//输出：如果是数值，则为true；非法为false
function BASEisNotNum(theNum){
	if (BASEtrim(theNum)=="")
		return true
	for(var i=0;i<theNum.length;i++){
	    oneNum=theNum.substring(i,i+1)
        if (oneNum<"0" || oneNum>"9")
          return true
    }
	return false
}
function BASEisNotInt(theInt){
	theInt=BASEtrim(theInt)
	if ((theInt.length>1 && theInt.substring(0,1)=="0") || BASEisNotNum(theInt)){
		return true
	}
	return false
}

function BASEisNotFloat(theFloat){
	len=theFloat.length
	dotNum=0
	if (len==0)
		return true
	for(var i=0;i<len;i++){
	    oneNum=theFloat.substring(i,i+1)
		if (oneNum==".")
			dotNum++
        if ( ((oneNum<"0" || oneNum>"9") && oneNum!=".") || dotNum>1)
          return true
    }
	if (len>1 && theFloat.substring(0,1)=="0"){
		if (theFloat.substring(1,2)!=".")
			return true
	}
	return false
}

//dateCompare:比较日期
//date1和date2可以是以'-'分隔的String,遵循年-月-日的顺序.
//返回-1:date1<date2, 0:date1=date2, 1:date1>date2
function dateCompare(date1,date2){
	if(typeof(date1)=='undefined') date1='1900-01-01';
	if(date1==null) date1='1900-01-01';
	if(typeof(date2)=='undefined') date2='1900-01-01';
	if(date2==null) date2='1900-01-01';

	date1=date1.split('-');
	date2=date2.split('-');

	var ret = (parseInt(date1[0])*10000+parseInt(date1[1])*100+parseInt(date1[2]) ) -
				 (parseInt(date2[0])*10000+parseInt(date2[1])*100+parseInt(date2[2]) )
	if(ret>0)
		ret = 1
	else if (ret < 0)
		ret=-1
	else
		ret=0

	return ret;
}
//页面跳转
function PageTo(obj){
	if(BASEisNotInt(obj.value)){
		BASEalert("请输入正确的页码！",obj);
	}else{
		window.location="?page=" + obj.value;
	}
}