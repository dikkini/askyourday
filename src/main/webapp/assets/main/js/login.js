$(document).ready(function () {

	'use strict';

	var USERNAME_SUCCESS = false,
		PASSWORD_SUCCESS = false,
		EMAIL_SUCCESS = false,
		PASSWORD_CONFIRM_SUCCESS = false,
		FORM_ACTION_LOGIN = "login",
		FORM_ACTION_SIGNUP = "signup",
		CURRENT_FORM_ACTION = FORM_ACTION_LOGIN; 
	
	var $loginBtn = $("#login_btn"),
		$emailInput = $("#email_input"),
		$usernameInput = $("#username_input"),
		$passwordInput = $("#password_input"),
		$passwordConfirmInput = $("#password_confirm_input"),
		$loginSignupForm = $("#logsig-form"),
		$userNameInputSignSuccess = $("#username_input-success"),
		$userNameInputSignFailed = $("#username_input-failed"),
		$emailInputSignSuccess = $("#email_input-success"),
		$emailInputSignFailed = $("#email_input-failed"),
		$passwordInputSignSuccess = $("#password_input-success"),
		$passwordInputSignFailed = $("#password_input-failed"),
		$passwordConfirmInputSignSuccess = $("#password_confirm_input-success"),
		$passwordConfirmInputSignFailed = $("#password_confirm_input-failed"),
		$signupPartForm = $("#signup_part_form");

	$loginBtn.click(function(e) {
		if (CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
			ajaxCheckUserName();
			checkPassword();
			if (!USERNAME_SUCCESS || !PASSWORD_SUCCESS) {
				e.preventDefault();
			}
		} else if (CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
			ajaxCheckUserName();
			ajaxCheckEmail();
			checkPassword();
			checkPasswordConfirm();
			if (!USERNAME_SUCCESS || !PASSWORD_SUCCESS || !EMAIL_SUCCESS || !PASSWORD_CONFIRM_SUCCESS) {
				e.preventDefault();
			}
		} else {
			e.preventDefault();
		}
	});

	$("a#login_tab").click(function() {
		ajaxCheckUserName();
		checkPassword();

		if (CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
			return;
		}
		CURRENT_FORM_ACTION = FORM_ACTION_LOGIN;
		$loginBtn.fadeOut(500, function() {
			$(this).text('Log In').fadeIn(500);
			$signupPartForm.fadeOut(1000);
		});
		//$loginBtn.slideDown(500);

		$emailInput.attr("disabled", "disabled");

		$loginSignupForm.attr("action", "/security_check");

		var email = $emailInput.val();
		var username = $usernameInput.val();
		ajaxCheckEmail(email);
		ajaxCheckUserName(username);
	});

	$("a#signup_tab").click(function() {
		ajaxCheckUserName();
		ajaxCheckEmail();
		checkPassword();
		checkPasswordConfirm();

		if (CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
			return;
		}
		CURRENT_FORM_ACTION = FORM_ACTION_SIGNUP;
		$loginBtn.fadeOut(500, function() {
			$(this).text('Sign Up').fadeIn(500);
			$signupPartForm.fadeIn(1000);
		});
		//$loginBtn.slideDown(500);

		$loginSignupForm.attr("action", "/login/signup");
		$emailInput.removeAttr("disabled");

		ajaxCheckEmail();
		ajaxCheckUserName();
	});

	$("#show_password_cb").change(function () {
		var $pwdInput = $passwordInput;
		var $pwdConfirm = $passwordConfirmInput;
		if ($(this).is(':checked')) {
			$pwdInput.attr("type", "text");
			$pwdConfirm.attr("type", "text");
		} else {
			$pwdInput.attr("type", "password");
			$pwdConfirm.attr("type", "password");
		}
	});

	$usernameInput.keyup(function () {
		var username = $usernameInput.val();
		if ($.trim(username).length < 3) {
			////$loginBtn.addClass("disabled");
			USERNAME_SUCCESS = false;
			$userNameInputSignSuccess.hide();
			$userNameInputSignFailed.show();
			return;
		}
		ajaxCheckUserName();
	});

	$passwordInput.keyup(function () {
		checkPassword();
		if (CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
			checkPasswordConfirm();
		}
	});

	function checkPassword() {
		var password = $passwordInput.val();

		if ($.trim(password).length < 6) {
			////$loginBtn.addClass("disabled");
			PASSWORD_SUCCESS = false;
			$passwordInputSignSuccess.hide();
			$passwordInputSignFailed.show();
		} else {
			PASSWORD_SUCCESS = true;
			if (USERNAME_SUCCESS && CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
				//$loginBtn.removeClass("disabled");
			} else if (USERNAME_SUCCESS && PASSWORD_CONFIRM_SUCCESS && EMAIL_SUCCESS
				&& CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
				//$loginBtn.removeClass("disabled");
			}
			$passwordInputSignSuccess.show();
			$passwordInputSignFailed.hide();
		}
	}

	$passwordConfirmInput.keyup(function () {
		checkPassword();
		checkPasswordConfirm();
	});

	function checkPasswordConfirm() {
		var password = $passwordInput.val();
		var password_confirm = $passwordConfirmInput.val();
		if (FORM_ACTION_SIGNUP && password != password_confirm) {
			//$loginBtn.addClass("disabled");
			PASSWORD_CONFIRM_SUCCESS = false;
			$passwordConfirmInputSignSuccess.hide();
			$passwordConfirmInputSignFailed.show();
		} else {
			PASSWORD_CONFIRM_SUCCESS = true;
			if (USERNAME_SUCCESS && PASSWORD_SUCCESS && EMAIL_SUCCESS) {
				//$loginBtn.removeClass("disabled");
			}
			$passwordConfirmInputSignSuccess.show();
			$passwordConfirmInputSignFailed.hide();
		}
	}

	$emailInput.keyup(function () {
		var email = $emailInput.val();

		if ($.trim(email).length < 3 || email.indexOf("@") == -1) {
			EMAIL_SUCCESS = false;
			//$loginBtn.addClass("disabled");
			$emailInputSignSuccess.hide();
			$emailInputSignFailed.show();
			return;
		}
		ajaxCheckEmail();
	});

	function ajaxCheckEmail() {
		var email = $emailInput.val();

		if ($.trim(email).length == 0) {
			$emailInputSignSuccess.hide();
			$emailInputSignFailed.show();
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
				console.log(response);
				if (response.success) {
					$emailInputSignSuccess.show();
					$emailInputSignFailed.hide();
					EMAIL_SUCCESS = true;

					if (USERNAME_SUCCESS && PASSWORD_SUCCESS && PASSWORD_CONFIRM_SUCCESS) {
						//$loginBtn.removeClass("disabled");
					}
				} else {
					$emailInputSignSuccess.hide();
					$emailInputSignFailed.show();
					//$loginBtn.addClass("disabled");
					EMAIL_SUCCESS = false;
				}

				return EMAIL_SUCCESS;
			},
			error: function (response) {
				console.log("error");
				console.log(response);
			}
		});
	}

	function ajaxCheckUserName() {
		var username = $usernameInput.val();

		if ($.trim(username).length < 3) {
			$userNameInputSignSuccess.hide();
			$userNameInputSignFailed.show();
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
				console.log(response);
				if (response.success && CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
					$userNameInputSignSuccess.hide();
					$userNameInputSignFailed.show();
					//$loginBtn.addClass("disabled");
					USERNAME_SUCCESS = false;
				} else if (!response.success && CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
					$userNameInputSignSuccess.show();
					$userNameInputSignFailed.hide();
					USERNAME_SUCCESS = true;

					if (PASSWORD_SUCCESS && CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
						//$loginBtn.removeClass("disabled");
					} else if (PASSWORD_SUCCESS && PASSWORD_CONFIRM_SUCCESS && EMAIL_SUCCESS
						&& CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
						//$loginBtn.removeClass("disabled");
					}
				} else if (response.success && CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
					$userNameInputSignSuccess.show();
					$userNameInputSignFailed.hide();
					USERNAME_SUCCESS = true;

					if (PASSWORD_SUCCESS && CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
						//$loginBtn.removeClass("disabled");
					} else if (PASSWORD_SUCCESS && PASSWORD_CONFIRM_SUCCESS && EMAIL_SUCCESS
						&& CURRENT_FORM_ACTION == FORM_ACTION_SIGNUP) {
						//$loginBtn.removeClass("disabled");
					}
				} else if (!response.success && CURRENT_FORM_ACTION == FORM_ACTION_LOGIN) {
					$userNameInputSignSuccess.hide();
					$userNameInputSignFailed.show();
					//$loginBtn.addClass("disabled");
					USERNAME_SUCCESS = false;
				}
				
				return USERNAME_SUCCESS;
			},
			error: function (response) {
				console.log("error");
				console.log(response);
			}
		});
	}

	setTimeout(function() {
		ajaxCheckUserName();
		checkPassword();
	}, 300);

});