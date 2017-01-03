$(document).ready(function($) {
	$('button').click(function(e) {
		if ($(this).hasClass("disabled")) {
			e.preventDefault();
			return false;
		}
	});
});