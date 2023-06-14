var loginFormContainer = document.getElementById("loginFormContainer");
var registrationFormContainer = document.getElementById("registrationFormContainer");
var errorMessageContainer = document.getElementById("errorMessageContainer");

document.getElementById("loginForm").addEventListener("submit", function(event) {

	var ISBN = document.getElementById("id").value;
	var title = document.getElementById("title").value;
	var author = document.getElementById("author").value;
	var publicationYear = document.getElementById("publicationYear").value;
	var description = document.getElementById("description").value;
	var image = document.getElementById("image").value;
	var isValid = false;
	console.log(サブミット実行);

	// Perform validation (You can customize this based on your requirements)
	if (ISBN === "" || title === "" || author === "" || publicationYear === "" || description === "" || image === "") {
		displayErrorMessage("すべての情報を入力してください");
		console.log("エラーメッセージ表示")
	} else {
		// Successful login, you can redirect to another page or perform other actions
		console.log("ログイン成功！！");
		isValid = true;
	}
	if(!isValid){
		event.preventDefault(); // Prevent form submission
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
	setTimeout(function() {
		errorMessageContainer.style.display = "none";
		errorMessageContainer.innerHTML = "";
	}, 1000);
}