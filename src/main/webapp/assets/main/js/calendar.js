$(document).ready(function() {
	$("textarea.question-body").elastic();
	var $cal = $("#calendar");
	var calendar = $cal.calendar({
		language: 'ru-RU',
		tmpl_path: "/assets/ext/bootstrap-calendar/tmpls/",
		tmpl_cache: false,
		views: {
			year:  {
				slide_events: 1,
				enable: 1
			},
			month: {
				slide_events: 1,
				enable: 1
			},
			week:  {
				enable: 0
			},
			day:   {
				enable: 0
			}
		},
		events_source: function () {
			return [];
		},
		onAfterViewLoad: function(view) {
			$('#calendar-title').text(this.getTitle());
			$('.btn-group button').removeClass('active');
			$('button[data-calendar-view="' + view + '"]').addClass('active');
		}
	});

	$('.btn-group button[data-calendar-nav]').each(function() {
		var $this = $(this);
		$this.click(function() {
			calendar.navigate($this.data('calendar-nav'));
		});
	});

	$('.btn-group button[data-calendar-view]').each(function() {
		var $this = $(this);
		$this.click(function() {
			calendar.view($this.data('calendar-view'));
		});
	});


	$cal.on("click", ".cal-cell", function() {
		console.log($(this).find("div > span").data("cal-date"));
		$('html, body').animate({
			scrollTop: $("#question-day").offset().top
		}, 500);
	})

});