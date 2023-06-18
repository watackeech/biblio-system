<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results from all books</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">
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

	<div class="background-container"></div>
	<c:set var="loginUser" value="${sessionScope.loginUser}" />
	<c:set var="loggedIn" value="${sessionScope.loggedIn}" scope="request" />

	<jsp:include page="common/header.jsp">
		<jsp:param name="loggedIn" value="${loggedIn}" />
		<jsp:param name="loginUser" value="${loginUser}" />
	</jsp:include>

	<section>
		<div class="container py-5">


<div class="row">
	<div class="col-lg-8 mx-auto search-box shadow p-4 rounded">
		<form class="row">
			<div class="col-md-6 mb-3">
				<div class="form-floating">
					<input type="text" class="form-control" id="title" name="title" placeholder="書籍名を入力してください">
					<label for="title">書籍のタイトル</label>
				</div>
			</div>
			<div class="col-md-6 mb-3">
				<div class="form-floating">
					<input type="text" class="form-control" id="author" name="author" placeholder="著者名を入力してください">
					<label for="author">著者名</label>
				</div>
			</div>
			<div class="col-md-12 d-flex justify-content-center">
				<button type="submit" id="search-button" class="btn btn-outline-primary" formaction="search-books" formmethod="post">検索</button>
			</div>
		</form>
	</div>
</div>

		<div class="mt-4"></div>
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<!-- List group-->
					<ul class="list-group shadow">
						<c:forEach var="book" items="${books}">
							<li class="list-group-item">
								<div
									class="media align-items-center flex-column flex-lg-row p-3">
									<img src="${book.image}" alt="Book Image" class="mr-3"
										style="width: 100px;">
									<div class="media-body">
										<div class="row">
											<div class="col-lg-6 d-flex align-items-center">
												<h3
													class="mt-0 font-weight-bold mb-2 text-center text-lg-left">${book.title}</h3>
											</div>
											<!-- 											<div
												class="col-lg-6 d-flex align-items-center justify-content-between"> -->
											<div class="row">
												<div class="col">
													<p class="font-weight-bold mb-0 detailed-info">${book.author}</p>
												</div>
												<div class="col">
													<p class="font-weight-bold mb-0 detailed-info">${book.publicationYear}</p>
												</div>
												<div class="col">
													<p class="font-weight-bold mb-0 detailed-info">貸出可能:
														${book.currentStock}</p>
												</div>
												<div class="col">
													<p class="font-weight-bold mb-0 detailed-info">総在庫:
														${book.totalStock}</p>
												</div>
											</div>

										</div>
									</div>
									<form>
										<input type="hidden" name="bookId" value="${book.id}">
										<button type="submit" class="btn btn-outline-primary btn-sm"
											formaction="update-book" formmethod="get">
											<i class="ri-edit-2-fill"></i> 修正
										</button>
									</form>
								</div>
							</li>


						</c:forEach>
					</ul>
				</div>



			</div>


		</div>
	</section>
	<div id="preloader"></div>

	<!-- https://bbbootstrap.com/snippets/product-list-65909871# -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
</body>
</html>