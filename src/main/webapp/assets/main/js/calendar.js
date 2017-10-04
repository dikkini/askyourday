$(document).ready(function() {
	var $cal = $("#calendar");

	var selectedYear, selectedMonth;
	var calendar = $cal.calendar({
		language: language,
		tmpl_path: window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/assets/ext/bootstrap-calendar/tmpls/",
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
		events_source_url: window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + '/calendar/getMonthUserAnswers',
		events_source_params: {
			month: getTodayMonth(),
			year: new Date().getFullYear()
		},
		onAfterViewLoad: function(view) {
			$('#calendar-title').text(this.getTitle());
			$('.btn-group button').removeClass('active');
			$('button[data-calendar-view="' + view + '"]').addClass('active');

            selectedYear = this.options.position.start.getFullYear();
			selectedMonth = this.options.position.start.getMonth();
			if (selectedMonth === 0 && selectedYear === 2017) {
				$('.btn-group button[data-calendar-nav="prev"]').prop('disabled', true);
			} else {
				$('.btn-group button[data-calendar-nav="prev"]').prop('disabled', false);
			}

			disableFutureDays();
		}
	});

	$('.btn-group button[data-calendar-nav]').each(function(e) {
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

	function disableFutureDays() {
		var $today = $cal.find(".cal-day-today");

		if ($today.length > 0) {
			var $todayWeek = $today.parent();
			$todayWeek.nextAll().each(function () {
				$(this).addClass("disabled");
			});
			$todayWeek.parent().nextAll().each(function () {
				$(this).addClass("disabled");
			});
		} else {

            var nowYear = new Date().getFullYear();
            var nowMonth = getTodayMonth();

            selectedMonth += 1;

            // old years disable
            if (selectedYear > nowYear || selectedMonth > nowMonth) {
                $(".cal-cell").addClass("disabled");
			}
		}
	}
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