<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Lecturers</title>
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
		<!-- page content -->
		<div class="row">
			<div class="col">
				<h4 class="p-3 mb-2 bg-light bg-gradien text-dark text-center">Manage
					Lecturers</h4>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<!-- Lecturer Add Function -->
				<a class="text-warning"
					href="${contextPath}/Coordinator/LecturerAdd"><b>Insert New
						Lecturer</b></a>
			</div>
			<div class="col">
				<!-- Lecturer Search -->
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
				<!-- Lecturer Data Grid -->
				<table class="table table-light table-striped">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Highet Qualification</th>
							<th scope="col">Mobile</th>
							<th scope="col">Subject Stream</th>
							<th scope="col">Teaching Subject</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<!-- populating table body -->
						<c:forEach items="${requestScope.lecturers}" var="lecturer">
							<tr>
								<td scope="col">${lecturer.lecturerName}</td>
								<td scope="col">${lecturer.highestQualification}</td>
								<td scope="col">${lecturer.mobile}</td>
								<td scope="col">${lecturer.subjectStream}</td>
								<td scope="col">${lecturer.subject.subjectName}</td>
								<td scope="col"><a class="text-info"
									href="${contextPath}/Coordinator/LecturerEdit?lecturerId=${lecturer.lecturerId}">Edit</a></td>
								<td scope="col"><a class="text-danger"
									href="${contextPath}/Coordinator/LecturerDelete?lecturerId=${lecturer.lecturerId}">Delete</a></td>
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