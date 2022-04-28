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
		<div class="row">
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
						<form action="${contextPath}/Student/Payment" method="post"
							enctype="multipart/form-data">
							<div class="input-group">
								<input type="file" class="form-control" id="inputGroupFile04"
									aria-describedby="inputGroupFileAddon04" aria-label="Upload"
									name="paymentReceipt" required>
								<button class="btn btn-outline-dark" type="submit"
									id="inputGroupFileAddon04">Upload</button>
							</div>
						</form>
					</div>
				</div>
			</c:if>
			<!-- Everything clear, student home landing page -->
			<c:if test="${requestScope.allClear == true}">
				<div class="row">
					<div class="col col-md-1"></div>
					<div class="col col-md-6">
						<label></label>
						<div class="card text-dark bg-light" style="width: 32rem;">
							<div class="card-header fs-5">
								<c:set value="${requestScope.student}" var="student" />
								<b>About Me</b> <br> <img
									src="${contextPath}/resource/images/student.png"
									alt="loading ..." width="100" height="100"> <br>
								<p>
									<b>Logged In as :</b> ${student.firstName} ${student.lastName}
								</p>
							</div>
							<ul class="list-group list-group-flush">
								<li class="list-group-item"><b>First Name :</b>
									${student.firstName}</li>
								<li class="list-group-item"><b>Last Name :</b>
									${student.lastName}</li>
								<li class="list-group-item"><b>NIC :</b> ${student.nic}</li>
								<li class="list-group-item"><b>Address :</b>
									${student.address}</li>
								<li class="list-group-item"><b>Mobile : </b>
									${student.mobile}</li>
								<li class="list-group-item"><b>Course Registerd : </b>
									${student.course.name}</li>
								<li class="list-group-item"><b>Registed On : </b>
									${student.registration.paymentDateTime}</li>
							</ul>
						</div>
					</div>
					<div class="col col-md-5"></div>
				</div>
			</c:if>
		</div>
		<!-- Footer -->
		<footer>
			<p align="center">© 2022 eLearning</p>
		</footer>
	</div>
	<script type="text/javascript"
		src="${contextPath}/resource/bootstrap.bundle.min.js"></script>
</body>
</html>