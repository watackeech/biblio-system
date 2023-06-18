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
	href="${pageContext.request.contextPath}/css/common/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/page/account.css">

<!-- Favicons -->
<link href="${pageContext.request.contextPath}/assets/img/favicon.png"
	rel="icon">
<link
	href="${pageContext.request.contextPath}/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

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

	<section id="account"
		class="d-flex align-items-center justify-content-center">
		<div class="container" data-aos="fade-up">
			<div class="row justify-content-center" data-aos="fade-up"
				data-aos-delay="150">
				<div class="col-xl-6 col-lg-8">
					<h1>
						工事中<span>.</span>
					</h1>
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