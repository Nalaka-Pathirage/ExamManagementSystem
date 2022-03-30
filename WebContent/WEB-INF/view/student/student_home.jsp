<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Home</title>
<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- Nav bar -->
		<div class="row">
			<div class="col">
				<%@include file="student_nav_bar.html"%>
			</div>
		</div>
		<!-- Page content -->
		<div class="row"">
			<div class="col">
				<!-- Admin approval is pending -->
				<c:if test="${requestScope.isAdminApproved == false}">
					<div class="alert alert-warning" role="alert">
						Admin approval for your registration request is pending! <br>Kindly
						try again after some time.
					</div>
				</c:if>
				<!-- Course payment is pending -->
				<c:if test="${requestScope.isPaymentCompleted == false}">
					<div class="card">
						<h5 class="card-header">Student Registration</h5>
						<div class="card-body">
							<h5 class="card-title">Payment confirmation for the course</h5>
							<p class="card-text">
								Please upload the bank pay slip to validate the course payment.
								This is final step of the registration process. <br> Happy
								Learning!
							</p>
							<form action="${contextPath}/payment" method="post"
								enctype="multipart/form-data">
								<div class="input-group">
									<input type="file" class="form-control" id="inputGroupFile04"
										aria-describedby="inputGroupFileAddon04" aria-label="Upload">
									<button class="btn btn-outline-dark" type="submit"
										id="inputGroupFileAddon04">Upload</button>
								</div>
							</form>
						</div>
					</div>
				</c:if>
				<!-- Everything clear, student home landing page -->
				<c:if test="${requestScope.allClear == true}">
					<h3>Default Home Page</h3>
				</c:if>
			</div>
		</div>
		<!-- Footer -->
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