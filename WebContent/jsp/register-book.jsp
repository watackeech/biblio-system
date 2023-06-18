<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/page/login-register.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/common.css">

	<link
	href="${pageContext.request.contextPath}/assets/vendor/aos/aos.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="background-container"></div>
	<!-- 	<div class="container"> -->
	<div class="form-container" id="loginFormContainer">
		<h2 class="text-center mb-4">書籍の登録！</h2>
		<form id="update-book-form">
			<div class="form-floating mb-3 mt-3">
				<input type="text" class="form-control" name="id" id="id" placeholder="a"> <label
					for="id">ISBNコード</label>
			</div>
			<div class="form-floating mb-3 mt-3">
				<input type="text" class="form-control" name="title" id="title" placeholder="a">
				<label for="title">本のタイトル</label>
			</div>
			<div class="form-floating mb-3 mt-3">
				<input type="text" class="form-control" name="author" id="author" placeholder="a">
				<label for="author">著者</label>
			</div>
			<div class="form-floating mb-3 mt-3">
				<input type="text" class="form-control" name="publicationYear"
					id="publicationYear" placeholder="a"> <label for="publicationYear">出版年</label>
			</div>
			<div class="form-floating mb-3 mt-3">
				<textarea class="form-control" name="description" id="description" placeholder="a"></textarea>
				<label for="description">概要</label>
			</div>
			<div class="form-floating mb-3 mt-3">
				<input type="text" class="form-control" name="image" id="image" placeholder="a">
				<label for="image">画像リンク</label>
			</div>
			<button type="submit" formaction="register-book" formmethod="post"
				id="register-book-button" class="btn btn-outline-primary btn-block">書籍を登録！</button>
		</form>
	</div>
	<div id="errorMessageContainer"></div>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/page/login-register.js"></script>
</body>
</html>