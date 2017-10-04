$(function() {
	var page = location.pathname.split("/")[1];
	if ($.trim(page) === "") {
		page = "main";
	}
	$('nav a[data-page^="/' + page + '"]').addClass('active');
});