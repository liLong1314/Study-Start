 // 判断浏览器
 isIE = (document.all ? true : false);

 // 初始月份及各月份天数数组
 var months = new Array("一　月", "二　月", "三　月", "四　月", "五　月", "六　月", "七　月","八　月", "九　月", "十　月", "十一月", "十二月");
 var daysInMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31,30, 31, 30, 31);
 var displayMonth = new Date().getMonth();
 var displayYear = new Date().getFullYear();
 var displayDivName;
 var displayElement;
 document.write("<DIV id=CalendarPicker style=\"POSITION: absolute\"></DIV>");
function getXBrowserRef(divName) {
	return (isIE ? document.all[divName].style : document.layers[divName]);
}

function hideElement(divName) { getXBrowserRef(divName).visibility = 'hidden'; }

// 按不同的浏览器进行处理元件的位置
function moveBy(elt,deltaX,deltaY) {
	if (isIE) {
		elt.left = elt.pixelLeft + deltaX;
		elt.top = elt.pixelTop + deltaY;
	} else {
		elt.left += deltaX;
		elt.top += deltaY;
	}
}

function toggleVisible(divName,inputName) {
	elt = getXBrowserRef(divName);
	if (elt.visibility == 'visible' || elt.visibility == 'show') {
		elt.visibility = 'hidden';
	} else {
		fixPosition(divName,inputName);
		elt.visibility = 'visible';
	}
}

function getIEPosX(elt) { return getIEPos(elt,"Left"); }
function getIEPosY(elt) { return getIEPos(elt,"Top"); }
function getIEPos(elt,which) {
	iPos = 0
	while (elt!=null) {
		iPos += elt["offset" + which];
		//alert(iPos);
		elt = elt.offsetParent;
	}
	return iPos
}

function setPosition(divName,inputName,isPlacedUnder) {
	var positioner = null;
	if (isIE) {
		//alert(inputName);
		positioner = document.all(inputName);
		//alert(divName.pixelLeft);alert(divName.pixelLeft);
		divName.pixelLeft = getIEPosX(positioner);
		divName.pixelTop = getIEPosY(positioner);
	}else{
		positioner = document.images[inputName];
		divName.left = positioner.x;
		divName.top = positioner.y;
	}
	if (isPlacedUnder) { moveBy(divName,0,positioner.height); }
}



//——————————————————————————————————————
 function getDays(month, year) {
	//测试选择的年份是否是润年？
	if (1 == month)
	   return ((0 == year % 4) && (0 != (year % 100))) ||
		  (0 == year % 400) ? 29 : 28;
	else
	   return daysInMonth[month];
 }

 function getToday() {
	// 得到今天的日期
	this.now = new Date();
	this.year = this.now.getFullYear();
	this.month = this.now.getMonth();
	this.day = this.now.getDate();
 }

 // 并显示今天这个月份的日历
 today = new getToday();

function newCalendar(divName,inputName) {
	if (inputName) {
	   if (displayDivName && displayDivName != divName) hideElement(displayDivName);
	   displayElement = document.all(inputName);
	}
	displayDivName = divName;
	today = new getToday();
	var parseYear = parseInt(displayYear + '');
	var newCal = new Date(parseYear,displayMonth,1);
	var day = -1;
	var startDayOfWeek = newCal.getDay();
	if ((today.year == newCal.getFullYear()) && (today.month == newCal.getMonth())){
		day = today.day;
	}
	var intDaysInMonth =getDays(newCal.getMonth(), newCal.getFullYear());
	var daysGrid = makeDaysGrid(startDayOfWeek,day,intDaysInMonth,newCal,divName)
	if (isIE) {
		var elt = document.all[divName];
		elt.innerHTML = daysGrid;
	}else{
		var elt = document.layers[divName].document;
		elt.open();
		elt.write(daysGrid);
		elt.close();
	}
 }

function incMonth(delta,divName) {
	displayMonth += delta;
	if (displayMonth >= 12) {
		displayMonth = 0;
		incYear(1,divName);
	}else if (displayMonth <= -1) {
		displayMonth = 11;
		incYear(-1,divName);
	}else {
		newCalendar(divName);
	}
}

 function incYear(delta,divName) {
   displayYear = parseInt(displayYear + '') + delta;
   newCalendar(divName);
 }

 function makeDaysGrid(startDay,day,intDaysInMonth,newCal,divName) {
	var daysGrid;
	var month = newCal.getMonth();
	var year = newCal.getFullYear();
	var isThisYear = (year == new Date().getFullYear());
	var isThisMonth = (day > -1)
	daysGrid = '<table border=1 cellspacing=0 cellpadding=2><tr><td bgcolor=#ffffff nowrap>';

	daysGrid += '<a href="javascript:incYear(-1,\'' + divName + '\')">&laquo; </a>';
	daysGrid += '<b>';
	if (isThisYear) { daysGrid += '<font color=red>' + year + '</font>'; }
	else { daysGrid += ''+year; }
	daysGrid += '</b>';
	daysGrid += '<a href="javascript:incYear(1,\'' + divName + '\')"> &raquo;</a>';

	daysGrid += '&nbsp;&nbsp;';

	daysGrid += '<a href="javascript:incMonth(-1,\'' + divName + '\')">&laquo; </a>';
	daysGrid += '<b>';
	if (isThisMonth) { daysGrid += '<font color=red>' + months[month] + '</font>'; }
	else { daysGrid += months[month]; }
	daysGrid += '</b>';
	daysGrid += '<a href="javascript:incMonth(1,\'' + divName + '\')"> &raquo;</a>';

	daysGrid += '&nbsp;&nbsp';

	daysGrid += '<font size=2><a href="javascript:hideElement(\'' + divName + '\')">x</a></font>';
	daysGrid += '<hr>';
	//daysGrid += '&nbsp;Su Mo Tu We Th Fr Sa&nbsp;<br>&nbsp;';
	daysGrid += '&nbsp;日 一 二 三 四 五 六&nbsp;<br>&nbsp;';

	var dayOfMonthOfFirstSunday = (7 - startDay + 1);
	for (var intWeek = 0; intWeek < 6; intWeek++) {
	   var dayOfMonth;
	   for (var intDay = 0; intDay < 7; intDay++) {
		 dayOfMonth = (intWeek * 7) + intDay + dayOfMonthOfFirstSunday - 7;
		 if (dayOfMonth <= 0) {
			daysGrid += "&nbsp;&nbsp; ";
		 }else if (dayOfMonth <= intDaysInMonth) {
			var color = "blue";
			if (day > 0 && day == dayOfMonth) color="red";
			daysGrid += '<a href="javascript:setDay(';
			daysGrid += dayOfMonth + ',\'' + divName + '\')" '
			daysGrid += 'style="color:' + color + '">';
			var dayString = dayOfMonth + "</a> ";
			if (dayString.length == 6) dayString = '0' + dayString;
			daysGrid += dayString;
		 }
	   }
	   if (dayOfMonth < intDaysInMonth) daysGrid += "<br>&nbsp;";
	}
	return daysGrid + "</td></tr></table>";
 }

 function setDay(day,divName) {
	var strMon=displayMonth + 1;
	var strDay=day;
	if (strMon.toString().length<2) strMon="0" + strMon;
	if (strDay.toString().length<2) strDay="0" + strDay;
	//alert(strMon);alert(strDay);
	displayElement.value = displayYear + "-" + strMon + "-" + strDay;
	hideElement(divName);
 }

//
function fixPosition(divName,inputName) {
	elt = getXBrowserRef(divName);
	isPlacedUnder = false;
	if (isPlacedUnder) {
		setPosition(elt,inputName,true);
	} else {
		setPosition(elt,inputName)
	}
}

function toggleDatePicker(inputName) {
	var divName = document.getElementById("CalendarPicker").id;
	//alert(divName);
	newCalendar(divName,inputName);
	toggleVisible(divName,inputName);
}
