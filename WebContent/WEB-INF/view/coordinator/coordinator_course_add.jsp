<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Courses</title>
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
				<h4 class="p-3 mb-2 bg-light bg-gradien text-dark text-center">Register
					New Course</h4>
			</div>
		</div>
		<div class="row">
			<!-- Data Submit Form -->
			<form method="post" action="${contextPath}/Coordinator/CoursesAdd">
				<div class="mb-3">
					<label for="courseName" class="form-label">Course Name :</label> <input
						type="text" class="form-control" id="courseName" name="courseName"
						placeholder="Enter Course Name" required>
				</div>
				<div class="mb-3">
					<label for="courseCode" class="form-label">Course Code :</label> <input
						type="text" class="form-control" id="courseCode" name="courseCode"
						placeholder="Enter Course Code" required>
				</div>
				<div class="mb-3">
					<label for="courseStart" class="form-label">Course Start :</label>
					<input type="date" class="form-control" id="courseStart"
						name="courseStart" placeholder="Course Commence On"
						value="2022-01-01" min="1992-01-01" max="2099-01-01" required>
				</div>
				<div class="mb-3">
					<label for="courseDuration" class="form-label">Course
						Duration :</label> <input type="text" class="form-control"
						id="courseDuration" name="courseDuration"
						placeholder="Enter Course Duration" required>
				</div>
				<div class="mb-3">
					<label for="courseDescription" class="form-label">Course
						Description :</label>
					<textarea class="form-control" id="courseDescription"
						name="courseDescription" rows="3"></textarea>
				</div>
				<div class="mb-3">
					<label for="courseFee" class="form-label">Course Fee :</label> <input
						type="text" class="form-control" id="courseFee" name="courseFee"
						placeholder="Enter Course Fee in LKR" required>
				</div>
				<div class="d-grid gap-2 col-6 mx-auto">
					<button type="submit" class="btn btn-outline-success">Register
						Course</button>
				</div>
			</form>
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