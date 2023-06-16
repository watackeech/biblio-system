<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="DTOs.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VB</title>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/page/top.css">

<%-- <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/header.css"> --%>

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
<%-- 	<c:set var="loggedIn" value="${sessionScope.loggedIn}" /> --%>
	<c:set var="loginUser" value="${sessionScope.loginUser}" />
	<c:set var="loggedIn" value="${sessionScope.loggedIn}" scope="request" />

	<jsp:include page="common/header.jsp">
		<jsp:param name="loggedIn" value="${loggedIn}" />
		<jsp:param name="loginUser" value="${loginUser}" />
	</jsp:include>

	<section id="hero"
		class="d-flex align-items-center justify-content-center">
		<div class="container" data-aos="fade-up">

			<div class="row justify-content-center" data-aos="fade-up"
				data-aos-delay="150">
				<div class="col-xl-6 col-lg-8">
					<h1>
						Value Biblio<span>.</span>
					</h1>
					<h2><span class="custom-font">100</span><span>万冊</span>と<span>泊</span>まる</h2>
				</div>
			</div>

			<div class="row gy-4 mt-5 justify-content-center" data-aos="zoom-in"
				data-aos-delay="250">
				<div class="col-xl-2 col-md-4">
					<a href="search-books" class="box-link">
						<div class="icon-box">
							<i class="ri-search-2-line"></i>
							<h3>探す</h3>
						</div>
					</a>
				</div>
				<c:if test="${loggedIn}">
					<div class="col-xl-2 col-md-4">
						<a href="lend-book" class="box-link">
							<div class="icon-box">
								<i class="ri-logout-box-line"></i>
								<h3>借りる</h3>
							</div>
						</a>
					</div>
					<div class="col-xl-2 col-md-4">
						<a href="return-book" class="box-link">
							<div class="icon-box">
								<i class="ri-login-box-line"></i>
								<h3>返す</h3>
							</div>
						</a>
					</div>
					<c:if test="${loginUser.status =='super'}">
						<div class="col-xl-2 col-md-4">
							<a href="manage-books" class="box-link">
								<div class="icon-box">
									<i class="ri-book-3-fill"></i>
									<h3>蔵書管理</h3>
								</div>
							</a>
						</div>
					</c:if>
				</c:if>
			</div>

		</div>
	</section>



	<div id="preloader"></div>
	<!-- Vendor JS Files -->
	<script
		src="${pageContext.request.contextPath}assets/vendor/purecounter/purecounter_vanilla.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/vendor/aos/aos.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="${pageContext.request.contextPath}/js/common/header.js"></script>
	<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
</body>

</html>