$(document).ready(function () {

	var $signupForm = $('#signup-form');

	$.extend($.validator.messages, {
		required: validationMessages['validate.required'],
		equalTo: validationMessages['validate.equalTo'],
		email: validationMessages['validate.email'],
		maxlength: $.validator.format(validationMessages['validate.maxlength']),
		minlength: $.validator.format(validationMessages['validate.minlength'])
	});


	$signupForm.find('input').on('keyup keypress blur change', function(e) {
		var isInvalid = $(this).hasClass("error");
		if (isInvalid == true) {
			$(this).parent().removeClass("has-success");
			$(this).parent().addClass("has-error");
		} else {
			$(this).parent().removeClass("has-error");
			$(this).parent().addClass("has-success");
		}
	});

	$signupForm.validate({
		tooltip_options: {
			username: {
				placement: 'right'
			},
			password: {
				placement: 'right'
			},
			repeatPassword: {
				placement: 'right'
			},
			firstName: {
				placement: 'right'
			},
			email: {
				placement: 'right'
			}
		}
	});
});