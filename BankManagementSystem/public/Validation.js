/**
 * 
 */

function checkEmptyField(fieldId) {

	alert('checkEmptyField ' + fieldId);

}
function validateForm() {
	const isValidEmail = validateEmail();
	const isValidDOB = validateDOB();
	const isValidUsername = validateUsername();
	const isValidPassword = validatePassword();

	return isValidEmail && isValidDOB && isValidUsername && isValidPassword;
}
function validateDOB() {
	const dobInput = document.getElementById("dob");
	const dobErr = document.getElementById("dobErr");

	const dob = new Date(dobInput.value);
	const today = new Date();
	today.setHours(0, 0, 0, 0);
	const minAllowedDOB = new Date(today);
	minAllowedDOB.setFullYear(minAllowedDOB.getFullYear() - 18);

	if (dob > today) {
		dobErr.textContent = "Please enter a date of birth that is not in the future.";
		dobErr.style.color = "red";
		return false;
	} else if (dob > minAllowedDOB) {
		dobErr.textContent = "Please enter a valid date of birth (18 years or older).";
		dobErr.style.color = "red";
		return false;
	} else {
		dobErr.textContent = "";
		return true;
	}
}

function validateUsername() {
	const usernameInput = document.getElementById("username");
	const usernameErr = document.getElementById("usernameErr");

	const username = usernameInput.value;
	if (username.trim() === "") {
		usernameErr.textContent = "Username cannot be blank.";
		usernameErr.style.color = "red";
		return false;
	}

	if (username.length < 8) {
		usernameErr.textContent = "Username must be at least 8 characters long.";
		usernameErr.style.color = "red";
		return false;
	} else {
		usernameErr.textContent = "";
		return true;
	}
}

function validatePassword() {
	const passwordInput = document.getElementById("password");
	const passwordErr = document.getElementById("passwordErr");

	const password = passwordInput.value;

	const minLength = 8;
	const hasUppercase = /[A-Z]/.test(password);
	const hasLowercase = /[a-z]/.test(password);
	const hasDigit = /\d/.test(password);
	const hasSpecialChar = /[!@#$%^&*]/.test(password);
	if (password.trim() === "") {
		passwordErr.textContent = "Password cannot be blank.";
		passwordErr.style.color = "red";
		return false;
	} else if (password.length < minLength) {
		passwordErr.textContent = "Password must be at least 8 characters long.";
		passwordErr.style.color = "red";
		return false;
	} else if (!hasUppercase) {
		passwordErr.textContent = "Password must contain at least one uppercase letter.";
		passwordErr.style.color = "red";
		return false;
	} else if (!hasLowercase) {
		passwordErr.textContent = "Password must contain at least one lowercase letter.";
		passwordErr.style.color = "red";
		return false;
	} else if (!hasDigit) {
		passwordErr.textContent = "Password must contain at least one digit.";
		passwordErr.style.color = "red";
		return false;
	} else if (!hasSpecialChar) {
		passwordErr.textContent = "Password must contain at least one special character (!@#$%^&*).";
		passwordErr.style.color = "red";
		return false;
	} else {
		passwordErr.textContent = "";
		return true;
	}
}


function validate() {
	var username = document.getElementById('uname').value;
	var password = document.getElementById('upass').value;

	console.log('value of username ' + username);
	console.log('value of password ' + password);

	if (username == "") {
		//alert('Username cannot be blank');	
		document.getElementById("nameErr").innerHTML = "Username cannot be blank";
		return false;
	}

	if (password == "") {
		document.getElementById("passErr").innerHTML = "Password cannot be blank";
		return false;
	}
	return true;
}

function validateEmail() {
	const emailInput = document.getElementById("email");
	const emailErr = document.getElementById("emailErr");

	const email = emailInput.value;
	//regex to validate email format
	const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+(\.[^\s@]+)*$/;

	if (email.trim() === "") {
		emailErr.textContent = "Email cannot be blank.";
		emailErr.style.color = "red";
		return false;
	} else if (!emailRegex.test(email)) {
		emailErr.textContent = "Please enter a valid email address.";
		emailErr.style.color = "red";
		return false;
	} else {
		emailErr.textContent = ""; 
		return true;
	}
}

function clearTheRegisterForm() {
	document.getElementById('username').value = "";
	document.getElementById('password').value = "";
	document.getElementById('email').value = "";
	document.getElementById('dob').value = "";

}
function clearTheLoginForm() {
	document.getElementById('username').value = "";
	document.getElementById('password').value = "";

}
function clearEmailErrMsg() {
	document.getElementById('emailErr').innerHTML = "";

}
function clearDobErrMsg() {
	document.getElementById('dobErr').innerHTML = "";

}
function clearNameErrMsg() {
	document.getElementById('usernameErr').innerHTML = "";

}

function clearPassErrMsg() {
	document.getElementById('passwordErr').innerHTML = "";

}