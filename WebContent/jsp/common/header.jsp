<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Beautiful Header</title>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/header.css">
</head>

<body>
	<div class="header">
		<c:choose>
			<c:when test="${loggedIn}">
				<a href="logout">ログアウト</a>
			</c:when>
			<c:otherwise>
				<a href="login-register">ログイン／登録</a>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- JavaScript code (optional) -->
	<script>
		// You can add JavaScript functionality here
	</script>
</body>
</html>
