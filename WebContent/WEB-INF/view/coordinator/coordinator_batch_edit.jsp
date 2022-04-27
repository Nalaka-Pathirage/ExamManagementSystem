<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Batches</title>
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
					Batch</h4>
			</div>
		</div>
		<div class="row">
			<!-- Extract values from request instance -->
			<c:set var="batch" value="${requestScope.batch}" />
			<!-- Data Edit/Submit Form -->
			<form method="post"
				action="${contextPath}/Coordinator/BatchEdit?batchId=${batch.batchId}">
				<div class="mb-3">
					<label for="batchName" class="form-label">Batch Name :</label> <input
						type="text" class="form-control" id="batchName" name="batchName"
						value="${batch.batchName}">
				</div>
				<div class="mb-3">
					<label for="batchCode" class="form-label">Batch
						Code :</label> <input type="text" class="form-control"
						id="batchCode" name="batchCode"
						value="${batch.batchCode}">
				</div>
				<div class="mb-3">
					<label for="course" class="form-label">Assigned Course :</label> <select
						class="form-select" name="course">
						<option value="${batch.course.courseId}" selected>${batch.course.name}</option>
						<c:forEach items="${requestScope.courses}" var="course">
							<option value="${course.courseId}">${course.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="d-grid gap-2 col-6 mx-auto">
					<button type="submit" class="btn btn-outline-warning">Edit
						Batch</button>
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