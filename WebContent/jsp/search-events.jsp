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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/wavy-top.css">

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

	<section id="hero"
		class="d-flex flex-column justify-content-end align-items-center">
		<div id="heroCarousel" data-bs-interval="5000"
			class="container carousel carousel-fade" data-bs-ride="carousel">

			<!-- Slide 1 -->
			<%-- 			<div class="carousel">
				<c:forEach var="event" items="${events}" varStatus="loop">
					<div class="carousel-item ${loop.first ? 'active' : ''}" style="background-image: url('${event.image}');
    background-size: cover;
    background-position: center;">
						<div class="carousel-container">
							<h2 class="animate__animated animate__fadeInDown container">
								${event.eventTitle }</h2>
	<!-- 						<a href="#about"
								class="btn-outline-primary animate__animated animate__fadeInUp scrollto">Read
								More</a> -->
							<button type="submit" id="search-button"
								class="btn btn-outline-primary" formaction="event-details"
								formmethod="get">詳細</button>
						</div>
					</div>
				</c:forEach>
			</div> --%>


			<div class="carousel">
				<c:forEach var="event" items="${events}" varStatus="loop">
					<div class="carousel-item ${loop.first ? 'active' : ''}"
						style="background-image: url('${event.image}');
    background-size: cover;
    background-position: center;">
						<div class="carousel-container">
							<h2 class="animate__animated animate__fadeInDown container hide-till-hover">
								${event.eventTitle }</h2>
							<!-- 						<a href="#about"
								class="btn-outline-primary animate__animated animate__fadeInUp scrollto">Read
								More</a> -->
							<form class="hide-till-hover">
								<input type="hidden" name="eventId" value="${event.id}">
								<button type="submit" id="search-button"
									class="btn btn-outline-primary" formaction="event-details"
									formmethod="get">詳細</button>
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- Slide 2 -->
			<!-- 			<div class="carousel-item">
				<div class="carousel-container">
					<h2 class="animate__animated animate__fadeInDown">Lorem Ipsum
						Dolor</h2>
					<p class="animate__animated animate__fadeInUp">Ut velit est
						quam dolor ad a aliquid qui aliquid. Sequi ea ut et est quaerat
						sequi nihil ut aliquam. Occaecati alias dolorem mollitia ut.
						Similique ea voluptatem. Esse doloremque accusamus repellendus
						deleniti vel. Minus et tempore modi architecto.</p>
					<a href="#about"
						class="btn-get-started animate__animated animate__fadeInUp scrollto">Read
						More</a>
				</div>
			</div>

			Slide 3
			<div class="carousel-item">
				<div class="carousel-container">
					<h2 class="animate__animated animate__fadeInDown">Sequi ea ut
						et est quaerat</h2>
					<p class="animate__animated animate__fadeInUp">Ut velit est
						quam dolor ad a aliquid qui aliquid. Sequi ea ut et est quaerat
						sequi nihil ut aliquam. Occaecati alias dolorem mollitia ut.
						Similique ea voluptatem. Esse doloremque accusamus repellendus
						deleniti vel. Minus et tempore modi architecto.</p>
					<a href="#about"
						class="btn-get-started animate__animated animate__fadeInUp scrollto">Read
						More</a>
				</div>
			</div> -->
			--> <a class="carousel-control-prev" href="#heroCarousel"
				role="button" data-bs-slide="prev"> <span
				class="carousel-control-prev-icon bx bx-chevron-left"
				aria-hidden="true"></span>
			</a> <a class="carousel-control-next" href="#heroCarousel" role="button"
				data-bs-slide="next"> <span
				class="carousel-control-next-icon bx bx-chevron-right"
				aria-hidden="true"></span>
			</a>

		</div>

		<svg class="hero-waves" xmlns="http://www.w3.org/2000/svg"
			xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 24 150 28 "
			preserveAspectRatio="none">
      <defs>
        <path id="wave-path"
				d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z">
      </defs>
      <g class="wave1">
        <use xlink:href="#wave-path" x="50" y="3"
				fill="rgba(255,255,255, .1)">
      </g>
      <g class="wave2">
        <use xlink:href="#wave-path" x="50" y="0"
				fill="rgba(255,255,255, .2)">
      </g>
      <g class="wave3">
        <use xlink:href="#wave-path" x="50" y="9" fill="#fff">
      </g>
    </svg>

	</section>
	<!-- End Hero -->

	<section>
		<div class="container py-5">
			<!-- 			<div class="row">
				<div class="col-lg-8 mx-auto search-box shadow p-4 rounded">
					<form class="row">
						<div class="col-md-6 mb-3">
							<div class="form-floating">
								<input type="text" class="form-control" id="title" name="title"
									placeholder="書籍名を入力してください"> <label for="title">書籍のタイトル</label>
							</div>
						</div>
						<div class="col-md-6 mb-3">
							<div class="form-floating">
								<input type="text" class="form-control" id="author"
									name="author" placeholder="著者名を入力してください"> <label
									for="author">著者名</label>
							</div>
						</div>
						<div class="col-md-12 d-flex justify-content-center">
							<button type="submit" id="search-button"
								class="btn btn-outline-primary" formaction="search-books"
								formmethod="post">検索</button>
						</div>
					</form>
				</div>
			</div> -->

			<div class="mt-4"></div>
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<!-- List group-->
					<ul class="list-group shadow">
						<c:forEach var="event" items="${events}">
							<li class="list-group-item ">
								<div
									class="media align-items-center d-flex justify-content-between">
									<img src="${event.image}" alt="Book Image" class="mr-3"
										style="width: 100px;">
									<div class="media-body">
										<div class="row">
											<div class="col-lg-6 d-flex align-items-center">
												<h3
													class="mt-0 font-weight-bold mb-2 text-center text-lg-left">${event.eventTitle}</h3>
											</div>
											<!-- 											<div
												class="col-lg-6 d-flex align-items-center justify-content-between"> -->
											<div class="row">
												<div class="col">
													<p class="font-weight-bold mb-0 detailed-info">${event.startTime}</p>
												</div>
												<div class="col">
													<p class="font-weight-bold mb-0 detailed-info">${event.endTime}</p>
												</div>
												<div class="col">
													<p class="font-weight-bold mb-0 detailed-info">貸出可能:
														${event.currentParticipants}</p>
												</div>
												<div class="col">
													<p class="font-weight-bold mb-0 detailed-info">総在庫:
														${event.maxCap}</p>
												</div>
											</div>

										</div>
									</div>
									<div class="col-lg-2">
										<h5>
											<c:if test="${event.currentParticipants < event.maxCap}">
												<span
													class="available badge badge-secondary font-weight-normal">在庫あり！</span>
											</c:if>
											<c:if test="${event.currentParticipants >= event.maxCap}">
												<span
													class="unavailable badge badge-secondary font-weight-normal">在庫なし...</span>
											</c:if>
										</h5>
										<form>
											<input type="hidden" name="bookId" value="${book.id}">
											<button type="submit" class="btn btn-outline-primary btn-sm"
												formaction="details" formmethod="get">
												<i class="ri-login-box-line"></i> 詳細
											</button>
										</form>
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