<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resource/login.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-5 mb-5 d-flex justify-content-center">
		<div class="card px-1 py-4">
			<div class="card-body">
				<!-- For authentication error message -->
				<c:if test="${requestScope.isAuthnticated == false}">
					<div class="alert alert-danger" role="alert">Username or
						Password incorrect!</div>
				</c:if>
				<h3 class="information mt-4 text-center">Exam Management System</h3>
				<form method="post" action="${contextPath}/login">
					<div class="mb-3">
						<label for="username" class="form-label"></label> <input
							type="email" name="username" class="form-control" id="username"
							placeholder="Username">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label"></label> <input
							type="password" name="password" class="form-control" id="password"
							placeholder="Password">
					</div>
					<div class=" d-flex flex-column text-center px-5 mt-3 mb-3">
						<small class="agree-text">Haven't you registerd in the
							system yet?</small> <a href="${contextPath}/StudentRegistration"
							class="terms">Sign Up</a>
					</div>
					<div class="d-grid gap-2">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="fixed-bottom">
		<footer>
			<p align="center">© 2022 eLearning</p>
		</footer>
	</div>
</body>
</html>