<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resource/login.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- Nav bar -->
		<div class="row">
			<div class="col">
				<%@include file="../landing/landing_nav_bar.html"%>
			</div>
		</div>
		<!-- Page content -->
		<div class="row">
			<div class="col">
				<div class="card container-color">
					<div class="card-header"></div>
					<div class="card-body">
						<c:if test="${requestScope.registrationStatus == true}">
							<div class="alert alert-success" role="alert">
								Your registration request was successfully submitted! <br>Awaiting
								for admin approval. Sooner the approval is done, you will be
								recieved an email with next steps in registration process.
							</div>
						</c:if>
						<c:if test="${requestScope.passwordDoesNotMatch == true}">
							<div class="alert alert-danger" role="alert">Passwords
								doesn't match, please re-enter and submit!</div>
						</c:if>
						<form class="row" method="post"
							action="${contextPath}/StudentRegistration">
							<div class="row">
								<div class="col-6">
									<div class="mb-3">
										<label for="fName" class="form-label"></label> <input
											type="text" class="form-control" name="fName" id="fName"
											placeholder="Enter First Name">
									</div>
									<div class="mb-3">
										<label for="lName" class="form-label"></label> <input
											type="text" class="form-control" name="lName" id="lName"
											placeholder="Enter Last Name">
									</div>
									<div class="mb-3">
										<label for="address" class="form-label"></label>
										<textarea class="form-control" name="address" id="address"
											rows="3" placeholder="Enter Address"></textarea>
									</div>
									<div class="mb-3">
										<label for="nic" class="form-label"></label> <input
											type="text" class="form-control" name="nic" id="nic"
											placeholder="Enter NIC">
									</div>
									<div class="mb-3">
										<label for="mobile" class="form-label"></label> <input
											type="text" class="form-control" name="mobile" id="mobile"
											placeholder="Enter Mobile">
									</div>
								</div>
								<div class="col-6">
									<div class="mb-3">
										<select class="form-select"
											aria-label="Default select example" name="course">
											<option selected>Select Course</option>
											<c:forEach items="${requestScope.courses}" var="course">
												<option value="${course.courseId}">${course.name}</option>
											</c:forEach>
										</select>
									</div>
									<div class="mb-3">
										<label for="email" class="form-label"></label> <input
											type="email" class="form-control mb-3" name="email"
											id="email" placeholder="Enter Email">
									</div>
									<div class="mb-3">
										<label for="password" class="form-label"></label> <input
											type="password" class="form-control mb-3" name="password"
											id="password" placeholder="Enter Password">
									</div>
									<div class="mb-3">
										<label for="rePassword" class="form-label"></label> <input
											type="password" class="form-control mb-3" name="re-password"
											id="rePassword" placeholder="Re-Enter Password">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="d-grid gap-2 col-6 mx-auto">
									<button type="submit" class="btn btn-dark">Register</button>
								</div>


							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer -->
		<footer>
			<p align="center">© 2022 eLearning</p>
		</footer>
	</div>
</body>
</html>