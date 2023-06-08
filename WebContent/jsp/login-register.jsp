<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="DTOs.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン/登録ページ</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/page/login-register.css">
</head>

<body>
	<div class="background-container"></div>
	<div class="container">
		<div class="form-container" id="loginFormContainer">
			<h2 class="text-center mb-4">ログイン！</h2>
			<form id="loginForm">
				<div class="form-group">
					<label for="student-id">学生番号</label> <input type="text"
						class="form-control" name="studentId" id="studentId"
						placeholder="数字4桁">
				</div>
				<div class="form-group">
					<label for="password">パスワード</label> <input type="password"
						class="form-control" name="password" id="password"
						placeholder="英数字8～16文字">
				</div>
				<input type="hidden" name="action" value="login">
				<button type="submit" formaction="login-register"
					formmethod="post" id="login-button"
					class="btn btn-primary btn-block">ログイン！</button>
				<p id="toggleFormLinkLogin" class="toggleLink text-center mt-3">アカウント未取得の場合→新規登録！</p>
			</form>
		</div>
		<div class="form-container hidden" id="registrationFormContainer">
			<h2 class="text-center mb-4">新規登録！</h2>
			<form id="registrationForm">
				<div class="form-group">
					<label for="regUsername">名前</label> <input type="text"
						class="form-control" id="regUsername" name="regUsername"
						placeholder="ニックネームをご自由に！">
				</div>
				<div class="form-group">
					<label for="regStudentId">学生番号</label> <input type="text"
						class="form-control" id="regStudentId" name="regStudentId"
						placeholder="数字4桁">
				</div>
				<div class="form-group">
					<label for="regPassword">パスワード</label> <input type="password"
						class="form-control" id="regPassword" name="regPassword"
						placeholder="英数字8～16文字">
				</div>
				<input type="hidden" name="action" value="register">
				<button type="submit" id="register-button"
					class="btn btn-primary btn-block" formaction="login-register"
					formmethod="post">登録！</button>
				<p id="toggleFormLinkRegister" class="toggleLink text-center mt-3">アカウント登録済みの場合→ログイン！</p>
			</form>
		</div>
	</div>
	<div class="background-container"></div>
	<div class="container">
		<h1>利用者一覧</h1>
		<form action="login-register" method="post">
			<input type="submit" value="取得">
		</form>
		<table>
			<c:if test="${not empty results}">
				<tr>
					<th>User ID</th>
					<th>Student ID</th>
					<th>Password</th>
					<th>Name</th>
				</tr>
				<c:forEach items="${results}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.studentId}</td>
						<td>${user.password}</td>
						<td>${user.name}</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty results}">
				<tr>
					<td colspan="4">Results not found</td>
				</tr>
			</c:if>
		</table>
	</div>

	<div id="errorMessageContainer"></div>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/page/login-register.js"></script>
</body>
</html>