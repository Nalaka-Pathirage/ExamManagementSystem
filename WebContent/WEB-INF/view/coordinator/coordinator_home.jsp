<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coordinator Home</title>
<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- nav bar -->
		<div class="row">
			<div class="col">
				<%@include file="coordinator_nav_bar.html"%>
			</div>
		</div>
		<!-- page content -->
		<div class="row">
			<div class="col">
				<h3>This is coordinator home page!</h3>
			</div>
		</div>
		<!-- footer -->
		<div class="fixed-bottom">
			<footer>
				<p align="center">© 2022 eLearning</p>
			</footer>
		</div>
	</div>
	<script type="text/javascript"
		src="${contextPath}/resource/bootstrap.bundle.min.js"></script>
</body>
</html>