<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Subjects</title>
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
					Subjects</h4>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<!-- Subject Add Function -->
				<a class="text-danger" href="${contextPath}/Coordinator/AddSubject"><b>Add
						New Subject</b></a>
			</div>
			<div class="col">
				<!-- Subject Search -->
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
				<!-- Subject Data Grid -->
				<table class="table table-light table-striped">
					<thead>
						<tr>
							<th scope="col">Subject Name</th>
							<th scope="col">Subject Code</th>
							<th scope="col">Attached Course</th>
							<th scope="col">Assigned Lecturer</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<!-- populating table body -->
						<c:forEach items="${requestScope.subjects}" var="subject">

							<c:set value="${subject.course}" var="course" />
							<c:set value="${subject.lecturer}" var="lecturer" />
							<c:set value="${subject.lecturer.lecturerName}"
								var="lecturerName" />

							<tr>
								<td scope="col">${subject.subjectName}</td>
								<td scope="col">${subject.subjectCode}</td>
								<td scope="col"><c:out
										value="${not empty course.name ? course.name : 'NOT ASSIGNED'}" /></td>
								<td scope="col"><c:out
										value="${not empty lecturer.lecturerName ? lecturer.lecturerName : 'NOT ASSIGNED'}" /></td>
								<td scope="col"><a class="text-info"
									href="${contextPath}/Coordinator/EditSubject?subjectId=${subject.subjectId}">Edit</a></td>
								<td scope="col"><a class="text-danger"
									href="${contextPath}/Coordinator/DeleteSubject?subjectId=${subject.subjectId}">Delete</a></td>
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