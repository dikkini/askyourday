 $(document).ready(function($) {
/*----------------------------------------------------*/
/*	Make sure that #header-background-image height is
/* equal to the browser height.
------------------------------------------------------ */
	//$('header').css({ 'height': $(window).height() });
	$('section').css({ 'height': $(window).height() });
	$(window).on('resize', function() {
		//$('header').css({ 'height': $(window).height() });
		$('section').css({ 'height': $(window).height() });
		$('body').css({ 'width': $(window).width() })
	});

	$('.smoothscroll').on('click',function (e) {
		e.preventDefault();

		var target = this.hash,
		$target = $(target);

		$('html, body').stop().animate({
			'scrollTop': $target.offset().top
		}, 800, 'swing', function () {
			window.location.hash = target;
		});
	});
});