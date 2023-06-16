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
			<div class="col-lg-6 mx-auto">
				<form>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="title" name="title" placeholder="書籍名を入力してください">
						<label for="title">書籍名</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="author" name="author" placeholder="著者名を入力してください">
						<label for="author">著者名</label>
					</div>
					<button type="submit" id="register-button" class="btn btn-primary" formaction="search-books" formmethod="post">検索</button>
				</form>
			</div>
		</div>


		<div class="row">



			<div class="col-lg-8 mx-auto">
				<!-- List group-->
				<ul class="list-group shadow">
					<c:forEach var="book" items="${books}">
						<li class="list-group-item">
							<div class="media align-items-center flex-column flex-lg-row p-3">
								<img src="${book.image}" alt="Book Image" class="mr-3" style="width: 100px;">
								<div class="media-body">
									<div class="row">
										<div class="col-lg-3">
											<p class="font-weight-bold mb-1">${book.author}</p>
											<p class="font-italic  mb-1">${book.publicationYear}</p>
											<p class="font-italic  mb-1">貸出可能: ${book.currentStock}</p>
											<p class="font-italic  mb-1">総在庫: ${book.totalStock}</p>
										</div>
										<div class="col-lg-6 d-flex align-items-center">
											<h4 class="mt-0 font-weight-bold mb-2 text-center text-lg-left">${book.title}</h4>
										</div>
										<div class="col-lg-3 d-flex align-items-center justify-content-end">
											<form>
												<input type="hidden" name="bookId" value="${book.id}">
												<button type="submit" class="btn btn-outline-primary btn-sm" formaction="update-book" formmethod="get">
													<i class="ri-login-box-line"></i> 詳細
												</button>
											</form>
										</div>
									</div>
								</div>
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