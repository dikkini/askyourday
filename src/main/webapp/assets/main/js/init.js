$(document).ready(function($) {
	$.extend($.validator.messages, {
		required: validationMessages['validate.required'],
		equalTo: validationMessages['validate.equalTo'],
		email: validationMessages['validate.email'],
		maxlength: $.validator.format(validationMessages['validate.maxlength']),
		minlength: $.validator.format(validationMessages['validate.minlength'])
	});

	$('button').click(function(e) {
		if ($(this).hasClass("disabled")) {
			e.preventDefault();
			return false;
		}
	});
});