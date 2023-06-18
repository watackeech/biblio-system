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
	href="${pageContext.request.contextPath}/css/common/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/page/top.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/page/details.css">

<!-- Favicons -->
<link href="${pageContext.request.contextPath}/assets/img/favicon.png"
	rel="icon">
<link
	href="${pageContext.request.contextPath}/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">


<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
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
	<c:set var="loggedIn" value="${sessionScope.loggedIn}" />
	<c:set var="loginUser" value="${sessionScope.loginUser}" />
	<jsp:include page="common/header.jsp">
		<jsp:param name="loggedIn" value="${loggedIn}" />
		<jsp:param name="loginUser" value="${loginUser}" />
	</jsp:include>

	<section id="features" class="features">
		<div class="spacer"></div>
		<div class="container detailed-box" data-aos="fade-up">
			<div class="row">
				<%-- 				<div class="image col-lg-2"
					style='background-image: url("${book.image}");'
					data-aos="fade-right"></div> --%>
				<img src="${book.image}" alt="Book Image" class="m-3"
					style="width: 350px;">
				<div class="col-lg-3" data-aos="fade-left" data-aos-delay="100">
					<div class="icon-box mt-5 d-flex align-items-center"
						data-aos="zoom-in" data-aos-delay="150">
						<i class="ri-book-3-fill"></i>
						<h1 class="mb-0 ml-2">${book.title}</h1>
					</div>
					<div class="icon-box mt-5 d-flex align-items-center"
						data-aos="zoom-in" data-aos-delay="150">
						<i class="ri-user-3-fill"></i>
						<h4 class="mb-0 ml-2">${book.author}</h4>
					</div>
					<div class="icon-box mt-5 d-flex align-items-center"
						data-aos="zoom-in" data-aos-delay="150">
						<i class="ri-calendar-2-fill"></i>
						<h4 class="mb-0 ml-2 custom-font">${book.publicationYear}</h4>
					</div>
					<div class="icon-box mt-5 d-flex align-items-center"
						data-aos="zoom-in" data-aos-delay="150">
						<i class="ri-box-3-fill"></i>
						<h4 class="mb-0 ml-2">現在庫：<span class="custom-font">${book.currentStock}</span>
							 ｜ 総在庫：<span class="custom-font">${book.currentStock}</span></h4>
					</div>
					<div class="icon-box mt-5 d-flex align-items-center"
						data-aos="zoom-in" data-aos-delay="150">
						<i class="ri-map-pin-2-fill"></i>
						<h4 class="mb-0 ml-2 custom-font">${book.location}</h4>
					</div>
				</div>
				<div class="col-lg-5" data-aos="fade-left" data-aos-delay="100">
					<div class="icon-box mt-5 d-flex" data-aos="zoom-in"
						data-aos-delay="150">
						<i class="ri-file-list-3-fill"></i>
						<h4 class="mb-0 ml-2 text-justify font-weight-normal">${book.description}</h4>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Features Section -->

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