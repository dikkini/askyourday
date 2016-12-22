$(document).ready(function () {

	'use strict';

	var USERNAME_SUCCESS = false,
		PASSWORD_SUCCESS = false,
		EMAIL_SUCCESS = false,
		PASSWORD_CONFIRM_SUCCESS = false,
		FORM_ACTION_LOGIN = "login",
		FORM_ACTION_SIGNUP = "signup",
		CURRENT_FORM_ACTION = FORM_ACTION_LOGIN;

	var $loginBtn = $("#login_btn");
	$loginBtn.addClass("disabled");

	$("a#login_tab").click(function() {
		CURRENT_FORM_ACTION = FORM_ACTION_LOGIN;
		$("#register_form").slideUp(1000);
		$loginBtn.slideUp(500, function() {
			$(this).text('Log In').fadeIn(500);
		});
		$loginBtn.slideDown(500);

		var email = $("#email_input").val();
		var username = $("#username_input").val();
		ajaxCheckEmail(email);
		ajaxCheckUserName(username);
	});

	$("a#signup_tab").click(function() {
		CURRENT_FORM_ACTION = FORM_ACTION_SIGNUP;
		$("#register_form").slideDown(1000);
		$loginBtn.slideUp(500, function() {
			$(this).text('Sign Up').fadeIn(500);
		});
		$loginBtn.slideDown(500);

		var email = $("#email_input").val();
		var username = $("#username_input").val();
		ajaxCheckEmail(email);
		ajaxCheckUserName(username);
	});

	$("#show_password_cb").change(function () {
		var $pwdInput = $("#password_input");
		var $pwdConfirm = $("#password_confirm_input");
		if ($(this).is(':checked')) {
			$pwdInput.attr("type", "text");
			$pwdConfirm.attr("type", "text");
		} else {
			$pwdInput.attr("type", "password");
			$pwdConfirm.attr("type", "password");
		}
	});

	$loginBtn.click(function () {
		if ($(this).hasClass("disabled")) {
			return;
		}

		var username = $("#username_input").val();
		var password = $("#password_input").val();

		if (CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
			ajaxLogin(username, password);
		} else if (CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
			var email = $("#email_input").val();
			ajaxSignup(username, email, password);
		}
	});

	$("#username_input").keyup(function () {
		var username = $("#username_input").val();
		if ($.trim(username).length < 3) {
			$loginBtn.addClass("disabled");
			USERNAME_SUCCESS = false;
			$("#username_input-success").hide();
			$("#username_input-failed").show();
			return;
		}
		ajaxCheckUserName(username);
	});

	$("#password_input").keyup(function () {
		var password = $("#password_input").val();

		if ($.trim(password).length < 6) {
			$loginBtn.addClass("disabled");
			PASSWORD_SUCCESS = false;
			$("#password_input-success").hide();
			$("#password_input-failed").show();
		} else {
			PASSWORD_SUCCESS = true;
			if (USERNAME_SUCCESS && CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
				$loginBtn.removeClass("disabled");
			} else if (USERNAME_SUCCESS && PASSWORD_CONFIRM_SUCCESS && EMAIL_SUCCESS
				&& CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
				$loginBtn.removeClass("disabled");
			}
			$("#password_input-success").show();
			$("#password_input-failed").hide();
		}
	});

	$("#password_confirm_input").keyup(function () {
		var password = $("#password_input").val();
		var password_confirm = $("#password_confirm_input").val();
		if (FORM_ACTION_SIGNUP && password != password_confirm) {
			$loginBtn.addClass("disabled");
			PASSWORD_CONFIRM_SUCCESS = false;
			$("#password_confirm_input-success").hide();
			$("#password_confirm_input-failed").show();
		} else {
			PASSWORD_CONFIRM_SUCCESS = true;
			if (USERNAME_SUCCESS && PASSWORD_SUCCESS && EMAIL_SUCCESS) {
				$loginBtn.removeClass("disabled");
			}
			$("#password_confirm_input-success").show();
			$("#password_confirm_input-failed").hide();
		}
	});

	$("#email_input").keyup(function () {
		var email = $("#email_input").val();

		if ($.trim(email).length < 3 || email.indexOf("@") == -1) {
			EMAIL_SUCCESS = false;
			$loginBtn.addClass("disabled");
			$("#email_input-success").hide();
			$("#email_input-failed").show();
			return;
		}
		ajaxCheckEmail(email);
	});

	var $logSignModal = $('#login_modal');

	$logSignModal.on('hidden.bs.modal', function() {
		$("#error-alert").hide();
		$("#username_input").val("");
		$("#password_input").val("");
		$("#email_input").val("");
		$("#password_confirm_input").val("");

		$(".glyphicon").hide();
	});

	function showError(errorMessage) {
		$("#error-alert").fadeIn(1000);
		$("#error-message").text(errorMessage);
	}

	function ajaxLogin(username, password) {
		var data = {
			username: username,
			password: password
		};
		$.ajax({
			type: "POST",
			url: "/security_check",
			cache: false,
			data: data,
			success: function (response) {
				response = $.parseJSON(response);
				console.log(response);
				if (response.success) {
					window.location = "calendar";
				} else {
					showError(response.errorMessage);
				}
			},
			error: function (response) {
				console.log("error");
				console.log(response);
			}
		});
	}

	function ajaxSignup(username, email, password) {
		var data = {
			username: username,
			email: email,
			password: password
		};
		$.ajax({
			type: "POST",
			url: "/login/signup",
			cache: false,
			contentType: "application/json",
			dataType: 'json',
			data: JSON.stringify(data),
			success: function (response) {
				response = $.parseJSON(response);
				console.log(response);
				if (response.success) {
					window.location = "calendar";
				} else {
					showError(response.errorMessage);
				}
			},
			error: function (response) {
				console.log("error");
				console.log(response);
			}
		});
	}

	function ajaxCheckEmail(email) {
		if ($.trim(email).length == 0) {
			return;
		}

		var data = {
			email: email
		};
		$.ajax({
			type: "POST",
			url: "/login/isEmailBusy",
			cache: false,
			data: data,
			success: function (response) {
				response = $.parseJSON(response);
				console.log(response);
				if (response.success) {
					$("#email_input-success").show();
					$("#email_input-failed").hide();
					EMAIL_SUCCESS = true;

					if (USERNAME_SUCCESS && PASSWORD_SUCCESS && PASSWORD_CONFIRM_SUCCESS) {
						$loginBtn.removeClass("disabled");
					}
				} else {
					$("#email_input-success").hide();
					$("#email_input-failed").show();
					$loginBtn.addClass("disabled");
					EMAIL_SUCCESS = false;
				}
			},
			error: function (response) {
				console.log("error");
				console.log(response);
			}
		});
	}

	function ajaxCheckUserName(username) {
		if ($.trim(username).length < 3) {
			return;
		}

		var data = {
			username: username
		};
		$.ajax({
			type: "POST",
			cache: false,
			url: "/login/isUsernameBusy",
			data: data,
			success: function (response) {
				response = $.parseJSON(response);
				console.log(response);
				if (response.success && CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
					$("#username_input-success").show();
					$("#username_input-failed").hide();
					USERNAME_SUCCESS = true;

					if (PASSWORD_SUCCESS && CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
						$loginBtn.removeClass("disabled");
					} else if (PASSWORD_SUCCESS && PASSWORD_CONFIRM_SUCCESS && EMAIL_SUCCESS
						&& CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
						$loginBtn.removeClass("disabled");
					}
				} else if (!response.success && CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
					$("#username_input-success").hide();
					$("#username_input-failed").show();
					$loginBtn.addClass("disabled");
					USERNAME_SUCCESS = false;
				} else if (response.success && CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
					$("#username_input-success").hide();
					$("#username_input-failed").show();
					$loginBtn.addClass("disabled");
					USERNAME_SUCCESS = false;
				} else if (!response.success && CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
					$("#username_input-success").show();
					$("#username_input-failed").hide();
					USERNAME_SUCCESS = true;

					if (PASSWORD_SUCCESS && CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
						$loginBtn.removeClass("disabled");
					} else if (PASSWORD_SUCCESS && PASSWORD_CONFIRM_SUCCESS && EMAIL_SUCCESS
						&& CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
						$loginBtn.removeClass("disabled");
					}
				}
			},
			error: function (response) {
				console.log("error");
				console.log(response);
			}
		});
	}
});