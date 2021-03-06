<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Lecturers</title>
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
				<h4 class="p-3 mb-2 bg-light bg-gradien text-dark text-center">Edit
					Lecturer</h4>
			</div>
		</div>
		<div class="row">
			<!-- Extract values from request instance -->
			<c:set var="lecturer" value="${requestScope.lecturer}" />
			<!-- Data Edit/Submit Form -->
			<form method="post"
				action="${contextPath}/Coordinator/LecturerEdit?lecturerId=${lecturer.lecturerId}">
				<div class="mb-3">
					<label for="fullName" class="form-label">Full Name :</label> <input
						type="text" class="form-control" id="fullName" name="fullName"
						value="${lecturer.lecturerName}">
				</div>
				<div class="mb-3">
					<label for="qualification" class="form-label">Highest
						Qualification :</label> <input type="text" class="form-control"
						id="qualification" name="qualification"
						value="${lecturer.highestQualification}">
				</div>
				<div class="mb-3">
					<label for="stream" class="form-label">Subject Stream :</label> <input
						type="text" class="form-control" id="stream" name="stream"
						value="${lecturer.subjectStream}">
				</div>
				<div class="mb-3">
					<label for="mobile" class="form-label">Mobile :</label> <input
						type="text" class="form-control" id="mobile" name="mobile"
						value="${lecturer.mobile}">
				</div>
				<div class="mb-3">
					<label for="course" class="form-label">Teaching Course :</label> <select
						class="form-select" name="course">
						<option value="${lecturer.subject.subjectId}" selected>${lecturer.subject.subjectName}</option>
						<c:forEach items="${requestScope.subjects}" var="subject">
							<option value="${subject.subjectId}">${subject.subjectName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="d-grid gap-2 col-6 mx-auto">
					<button type="submit" class="btn btn-outline-warning">Edit
						Lecturer</button>
				</div>
			</form>
		</div>
		<!-- Footer -->
		<footer>
			<p align="center">?? 2022 eLearning</p>
		</footer>
	</div>
	<script type="text/javascript"
		src="${contextPath}/resource/bootstrap.bundle.min.js"></script>
</body>
</html>