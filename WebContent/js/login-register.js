var loginFormContainer = document.getElementById("loginFormContainer");
var registrationFormContainer = document.getElementById("registrationFormContainer");
var toggleFormLinkLogin = document.getElementById("toggleFormLinkLogin");
var toggleFormLinkRegister = document.getElementById("toggleFormLinkRegister");
var errorMessageContainer = document.getElementById("errorMessageContainer");

toggleFormLinkLogin.addEventListener("click", function () {
    loginFormContainer.classList.add("hidden");
    registrationFormContainer.classList.remove("hidden");
});

toggleFormLinkRegister.addEventListener("click", function () {
    registrationFormContainer.classList.add("hidden");
    loginFormContainer.classList.remove("hidden");
});

document.getElementById("loginForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent form submission

    var studentId = document.getElementById("studentId").value;
    var password = document.getElementById("password").value;

    // Perform validation (You can customize this based on your requirements)
    if (studentId === "" || password === "") {
        displayErrorMessage("学生番号とパスワードの両方を入力してください");
    } else if (!validateStudentId(studentId)) {
        displayErrorMessage("学生番号は4桁の数字を入力してください");
    } else if (!validatePassword(password)) {
        displayErrorMessage("パスワードは英数字を混ぜた8～16文字を入力してください");
    } else {
        // Successful login, you can redirect to another page or perform other actions
        console.log("ログイン成功！！");
    }
});

document.getElementById("registrationForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent form submission

    var username = document.getElementById("regUsername").value;
    var password = document.getElementById("regPassword").value;
    var studentId = document.getElementById("student-id").value;

    // Perform validation (You can customize this based on your requirements)
    if (username === "" || password === "" || studentId === "") {
        displayErrorMessage("すべての項目を入力してください");
    } else if (!validateStudentId(studentId)) {
        displayErrorMessage("学生番号は4桁の数字を入力してください");
    } else if (!validatePassword(password)) {
        displayErrorMessage("パスワードは英数字を混ぜた8～16文字を入力してください");
    } else {
        // Successful registration, you can redirect to another page or perform other actions
        console.log("登録成功！！");
    }
});

function displayErrorMessage(message) {
    var errorMessage = document.createElement("div");
    errorMessage.textContent = message;
    errorMessageContainer.innerHTML = ""; // Clear previous error message
    errorMessageContainer.appendChild(errorMessage);

    // Show the error message container
    errorMessageContainer.style.display = "block";

    // Hide the error message after 1 second
    setTimeout(function () {
        errorMessageContainer.style.display = "none";
        errorMessageContainer.innerHTML = "";
    }, 1000);
}

function validateStudentId(studentId) {
    var regex = /^\d{4}$/;
    return regex.test(studentId);
}

function validatePassword(password) {
    // Use a regular expression to check if the password contains both English characters and numbers
    var regex = /^(?=.*[A-Za-z])(?=.*\d).+$/;
    // Check if the password length is between 8 and 16 characters
    var lengthCheck = password.length >= 8 && password.length <= 16;
    return regex.test(password) && lengthCheck;
}
