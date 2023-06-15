<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/page/login-register.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/common.css">
</head>
<body>
<!-- 	<div class="background-container"></div>
		<div class="container">
	<div class="form-container" id="loginFormContainer">
		<h2 class="text-center mb-4">書籍の更新！</h2>
		<form id="loginForm">
			<div class="form-group">
				<input type="text" class="form-control" name="id" id="id"
					placeholder="ISBNコード">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="title" id="title"
					placeholder="本のタイトル">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="author" id="author"
					placeholder="著者">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="publicationYear"
					id="publicationYear" placeholder="出版年">
			</div>
			<div class="form-group">
				<textarea class="form-control" name="description" id="description"
					placeholder="概要"></textarea>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="image" id="image"
					placeholder="画像リンク">
			</div>
			<input type="hidden" name="action" value="login">
			<button type="submit" formaction="register-book" formmethod="post"
				id="login-button" class="btn btn-primary btn-block">書籍を登録！</button>
		</form>
	</div> -->

	${book.title}
	${book.author}
	<div id="errorMessageContainer"></div>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/page/login-register.js"></script>
</body>
</html>