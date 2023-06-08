<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="DTOs.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/page/top.css">
</head>
<body>
	<c:set var="loggedIn" value="${sessionScope.loggedIn}" />
	<jsp:include page="common/header.jsp">
		<jsp:param name="loggedIn" value="${loggedIn}" />
	</jsp:include>

	<c:set var="loggedIn" value="${sessionScope.loggedIn}" />
	<c:choose>
		<c:when test="${not empty loggedIn}">
			loggedIn: ${loggedIn}
		</c:when>
		<c:otherwise>
			<c:set var="defaultLoggedIn" value="false" />
			loggedIn: ${defaultLoggedIn}
		</c:otherwise>
	</c:choose>

	<c:set var="loginUser" value="${sessionScope.loginUser}" />
	<div class="container">
		<c:choose>
			<c:when test="${loggedIn && not empty loginUser}">
				<h1>こんにちは ${loginUser.name}さん！</h1>
			</c:when>
			<c:otherwise>
				<h1>ログインしていません...</h1>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
