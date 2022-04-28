<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>langing</title>
<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resource/landing.css" rel="stylesheet">
</head>
<body>
	<div class="container" id="custom-bg-img">
		<!-- Nav bar -->
		<div class="row">
			<div class="col">
				<%@include file="/WEB-INF/view/landing/landing_nav_bar.html"%>
			</div>
		</div>
		<!-- Page content -->
		<label></label>
		<div class="row">
			<!--  <header class="bg-secondary py-5 mb-5 banner">
				<div class="container h-100">
					<div class="row h-100 align-items-center">
						<div class="col-lg-12 banner-content-wrapper">
							<h1 class="display-4 text-white mt-5 mb-2 text-center">TLA
								Academy</h1>
							<p class="lead mb-5 text-white-50 text-center">An experienced
								young team who are eager to build carrier of our young minds on
								computer programming and cutting-edge technologies. We offer ICT
								courses from age 10 to undergraduate with affordable price.</p>
						</div>
					</div>
				</div>
			</header> -->
		</div>
		<div class="row">
			<div class="card" id="card-quote">
				<div class="card-body">
					<blockquote class="blockquote mb-0">
						<p class="fs-4">
							<i><b>Education is the best friend. An educated person is
									respected everywhere. Education beats the beauty and the
									youth...</b></i>
						</p>
						<footer class="blockquote-footer fs-5">
							<i>Chanakya</i> <cite title="Source Title"></cite>
						</footer>
					</blockquote>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<footer>
		<p align="center">© 2022 eLearning</p>
	</footer>

	<script type="text/javascript"
		src="${contextPath}/resource/bootstrap.bundle.min.js"></script>
</body>
</html>