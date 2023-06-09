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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/page/login-register.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/common.css">

	<!-- Vendor CSS Files -->
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
<%-- 	<jsp:include page="common/header.jsp">
		<jsp:param name="loggedIn" value="${loggedIn}" />
		<jsp:param name="loginUser" value="${loginUser}" />
	</jsp:include> --%>
	<div class="background-container"></div>


	<div class="container">
		<div class="form-container" id="update-book-container">
			<h2 class="text-center mb-4">書籍情報の更新！</h2>
			<form id="update-book-form">
				<input type="hidden" name="bookId" value="${book.id }">

				<div class="form-floating mb-3 mt-3">
					<input type="text" class="form-control" name="title" id="title"
						value="${book.title}"> <label for="title">タイトル</label>
				</div>

				<div class="form-floating mb-3 mt-3">
					<input type="text" class="form-control" name="author" id="author"
						value="${book.author}"><label for="id">著者</label>
				</div>

				<div class="form-floating mb-3 mt-3">
					<input type="text" class="form-control" name="publicationYear"
						id="publicationYear" value="${book.publicationYear}"><label
						for="publicationYear">出版年</label>
				</div>

				<div class="form-floating mb-3 mt-3">
					<textarea class="form-control" name="description" id="description">${book.description}</textarea>
					<label for="descrioption">概要</label>
				</div>

				<div class="form-floating mb-3 mt-3">
					<input type="text" class="form-control" name="image" id="image"
						value="${book.image}"><label for="image">画像リンク</label>
				</div>

				<div class="form-floating mb-3 mt-3">
					<select class="form-select" name="currentStock" id="currentStock">
						<c:forEach var="i" begin="0" end="20">
							<option value="${i}" ${book.currentStock == i ? 'selected' : ''}>${i}</option>
						</c:forEach>
					</select> <label for="currentStock">在庫数</label>
				</div>

				<div class="form-floating mb-3 mt-3">
					<select class="form-select" name="totalStock" id="totalStock">
						<c:forEach var="i" begin="0" end="20">
							<option value="${i}" ${book.totalStock == i ? 'selected' : ''}>${i}</option>
						</c:forEach>
					</select> <label for="totalStock">総在庫数</label>
				</div>

				<button type="submit" formaction="update-book" formmethod="post" name="action" value="update"
					id="login-button" class="btn btn-outline-primary btn-block">書籍情報を更新！</button>
					<button type="submit" formaction="update-book" formmethod="post" name="action" value="delete" class="btn btn-outline-danger btn-block">書籍を削除する</button>
			</form>
		</div>
	</div>
<!-- 	<div id="preloader"></div> -->
	<div id="errorMessageContainer"></div>

	<script
		src="${pageContext.request.contextPath}/js/page/login-register.js"></script>
		<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
</body>
</html>