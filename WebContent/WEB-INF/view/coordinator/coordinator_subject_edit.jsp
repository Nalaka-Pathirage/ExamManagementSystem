<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Subjects</title>
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
					Subject</h4>
			</div>
		</div>
		<div class="row">
			<!-- Extract values from request instance -->
			<c:set var="lecturer" value="${requestScope.subject}" />
			<!-- Data Edit/Submit Form -->
			<form method="post"
				action="${contextPath}/Coordinator/EditSubject?subjectId=${subject.subjectId}">
				<div class="mb-3">
					<label for="subjectName" class="form-label">Subject Name :</label>
					<input type="text" class="form-control" id="subjectName"
						name="subjectName" value="${subject.subjectName}">
				</div>
				<div class="mb-3">
					<label for="subjectCode" class="form-label">Subject Code :</label>
					<input type="text" class="form-control" id="subjectCode"
						name="subjectCode" value="${subject.subjectCode}">
				</div>
				<div class="d-grid gap-2 col-6 mx-auto">
					<button type="submit" class="btn btn-outline-danger">Edit
						Subject</button>
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