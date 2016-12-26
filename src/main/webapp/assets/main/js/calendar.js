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
		modal : "#events-modal",
		modal_type : "text",
		modal_title : function (e) {
			return e.title
		},
		events_source_custom: true,
		events_source_url: '/calendar/getUserAnswersByMonthYear',
		events_source_params: {
			userUuid: userUuid,
			month: getTodayMonth(),
			year: new Date().getFullYear()
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

	$cal.on("click", ".cal-month-day", function() {
		var date = $(this).find('span[data-cal-view="day"]').data("cal-date");
		var $events = $(this).find("div.events-list");
		// если в календаре уже есть событие - то открываем модальное окно с вопросом и ответом
		if ($events.length > 0) {
			$events.find("a").click();
			return;
		}
		var dateSplitted = date.split("-");

		var data = {
			day: dateSplitted[2],
			month: dateSplitted[1],
			year: dateSplitted[0]
		};

		$.ajax({
			type: "GET",
			url: "/calendar/getQuestionByDayMonthYear",
			cache: false,
			data: data,
			success: function (response) {
				var $modal = $("#events-modal");
				$modal.find(".modal-body").find(".question-body").html("");
				$modal.find(".modal-header").find("h3").text(response.data.question);
				$modal.modal('show');
			},
			error: function (response) {
				console.log("error");
				console.log(response);
			}
		});
	})
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