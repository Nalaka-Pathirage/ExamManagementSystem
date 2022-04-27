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
				<h4 class="p-3 mb-2 bg-light bg-gradien text-dark text-center">Registerd
					Students</h4>
			</div>
		</div>
		<div class="row">
			<!-- Student Search -->
			<div class="col-md-6"></div>
			<div class="col-md-6">
			<form class="row g-3">
				<div class="col-auto">
					<label for="searchBox" class="visually-hidden">Search</label> <input
						type="text" class="form-control" id="searchBox"
						placeholder="Enter Name">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-dark mb-3">Search</button>
				</div>
			</form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<!-- Student Data Grid -->
				<table class="table table-light table-striped">
					<thead>
						<tr>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">NIC</th>
							<th scope="col">Mobile</th>
							<th scope="col">Address</th>
							<th scope="col">Registerd Course</th>
							<th scope="col">Course Code</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<!-- populating table body -->
						<c:forEach items="${requestScope.students}" var="student">
							<tr>
								<td scope="col">${student.firstName}</td>
								<td scope="col">${student.lastName}</td>
								<td scope="col">${student.nic}</td>
								<td scope="col">${student.mobile}</td>
								<td scope="col">${student.address}</td>
								<td scope="col">${student.course.name}</td>
								<td scope="col">${student.course.code}</td>
								<td scope="col"><a class="text-info"
									href="#">Edit</a></td>
								<td scope="col"><a class="text-danger"
									href="#">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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