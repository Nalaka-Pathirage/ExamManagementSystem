<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Courses</title>
<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- Nav bar -->
		<div class="row">
			<div class="col">
				<%@include file="coordinator_nav_bar.html"%>
			</div>
		</div>
		<!-- Page content -->
		<div class="row">
			<div class="col">
				<h4 class="p-3 mb-2 bg-light bg-gradien text-dark text-center">Manage
					Courses</h4>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<!-- Course Add Function -->
				<a class="text-warning" href="${contextPath}/Coordinator/CoursesAdd"><b>Add
						New Course</b></a>
			</div>
			<div class="col">
				<!-- Course Search -->
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
				<!-- Courses Data Grid -->
				<table class="table table-light table-striped">
					<thead>
						<tr>
							<th scope="col">Course Name</th>
							<th scope="col">Code</th>
							<th scope="col">Duration</th>
							<th scope="col">Commence On</th>
							<th scope="col">Course Details</th>
							<th scope="col">Fee</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<!-- Populating table body -->
						<c:forEach items="${requestScope.courses}" var="course">
							<tr>
								<td scope="col">${course.name}</td>
								<td scope="col">${course.code}</td>
								<td scope="col">${course.duration} Y</td>
								<td scope="col">${course.start}</td>
								<td scope="col">${course.description}</td>
								<td scope="col">${course.fee} LKR</td>
								<td scope="col"><a class="text-info"
									href="${contextPath}/Coordinator/CoursesEdit?courseId=${course.courseId}">Edit</a></td>
								<td scope="col"><a class="text-danger"
									href="${contextPath}/Coordinator/CoursesDelete?courseId=${course.courseId}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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