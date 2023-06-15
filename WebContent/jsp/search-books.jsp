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
	<form>
		<input type="text" name="title" placeholder="書籍名を入力してください"> <input
			type="text" name="author" placeholder="著者名を入力してください">
		<button type="submit" id="register-button"
			class="btn btn-primary btn-block" formaction="search-books"
			formmethod="post">検索</button>
	</form>
	<div class="container py-5">
		<!-- 		<div class="row text-center text-white mb-5">
			<div class="col-lg-7 mx-auto">
				<h1 class="display-4">Product List</h1>
			</div>
		</div> -->
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<!-- List group-->
				<ul class="list-group shadow">
					<c:forEach var="book" items="${books}">
						<li class="list-group-item">
							<div
								class="media align-items-lg-center flex-column flex-lg-row p-3">
								<img src="${book.image}" alt="Generic placeholder image"
									width="100" class="align-self-start mr-3">
								<div class="media-body">
									<div class="row">
										<div class="col-lg-6">
											<h5 class="mt-0 font-weight-bold mb-2">${book.title}</h5>
											<p class="font-italic text-muted mb-0 small">${book.publicationYear}</p>
											<p class="font-italic text-muted mb-0 small">${book.currentStock}</p>
										</div>
										<div
											class="col-lg-6 d-flex align-items-center justify-content-end">
											<div>
												<h6 class="font-weight-bold my-2">${book.author}</h6>
											</div>
											<form>
												<input type="hidden" name="bookId" value="${book.id}">
												<button type="submit" class="btn btn-primary btn-sm"
													formaction="update-book" formmethod="get">
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
		<!-- https://bbbootstrap.com/snippets/product-list-65909871# -->
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>