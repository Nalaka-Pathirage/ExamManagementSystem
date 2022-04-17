<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Coordinators</title>
<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- Nav bar -->
		<div class="row">
			<div class="col">
				<%@include file="admin_nav_bar.html"%>
			</div>
		</div>
		<!-- page content -->
		<div class="row">
			<div class="col">
				<h4 class="p-3 mb-2 bg-info bg-gradien text-dark text-center">Insert
					Coordinator</h4>
			</div>
		</div>
		<div class="row">
			<!-- Data Submit Form -->
			<form method="post" action="${contextPath}/Admin/InsertCoordinator">
				<div class="row">
					<div class="col">
						<div class="mb-3">
							<label for="fName" class="form-label">First Name :</label> <input
								type="text" class="form-control" id="fName" name="fName"
								placeholder="Enter First Name">
						</div>
						<div class="mb-3">
							<label for="lName" class="form-label">Last Name :</label> <input
								type="text" class="form-control" id="lName" name="lName"
								placeholder="Enter Last Name">
						</div>
						<div class="mb-3">
							<label for="nic" class="form-label">NIC :</label> <input
								type="text" class="form-control" id="nic" name="nic"
								placeholder="Enter NIC">
						</div>
						<div class="mb-3">
							<label for="mobile" class="form-label">Mobile :</label> <input
								type="text" class="form-control" id="mobile" name="mobile"
								placeholder="Enter Mobile">
						</div>
					</div>
					<div class="col">
						<div class="mb-3">
							<label for="userName" class="form-label">User Name :</label> <input
								type="email" class="form-control" id="userName" name="userName"
								placeholder="Enter Username">
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">Password :</label> <input
								name="password" type="password" class="form-control"
								id="password" placeholder="Enter Password">
						</div>
						<div class="mb-3">
							<label for="rePassword" class="form-label">Retype
								Password :</label> <input type="password" class="form-control"
								id="rePassword" name="rePassword" placeholder="Retype Password">
						</div>
						<div class="d-grid gap-2 col-6 mx-auto">
							<button type="submit" class="btn btn-outline-success">Insert
								Coordinator</button>
						</div>
					</div>
				</div>
			</form>
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