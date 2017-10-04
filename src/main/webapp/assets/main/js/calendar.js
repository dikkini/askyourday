$(document).ready(function() {

});

function getTodayMonth() {
	var d = new Date();
	var month = new Array();
	month[0] = "01";
	month[1] = "02";
	month[2] = "03";
	month[3] = "04";
	month[4] = "05";
	month[5] = "06";
	month[6] = "07";
	month[7] = "08";
	month[8] = "09";
	month[9] = "10";
	month[10] = "11";
	month[11] = "12";
	return month[d.getMonth()];
}