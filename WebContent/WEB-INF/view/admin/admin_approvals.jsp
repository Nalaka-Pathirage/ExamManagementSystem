<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Approvals</title>
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
				<h4 class="p-3 mb-2 bg-warning bg-gradien text-dark text-center">Pending
					Student Registration Approvals</h4>
			</div>
		</div>
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<!-- Approval Search -->
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
				<table class="table table-light table-striped">
					<thead>
						<tr>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Course</th>
							<th scope="col">Course Code</th>
							<th scope="col">Requested On</th>
							<th scope="col">Approve</th>
							<th scope="col">Reject</th>
						</tr>
					</thead>
					<tbody>
						<!-- populating table body -->
						<c:forEach items="${requestScope.students}" var="student">
							<tr>
								<td scope="col">${student.firstName}</td>
								<td scope="col">${student.lastName}</td>
								<td scope="col">${student.course.name}</td>
								<td scope="col">${student.course.code}</td>
								<td scope="col">${student.registration.requestedDateTime}</td>
								<td scope="col"><a class="text-success"
									href="${contextPath}/approval?decision=A&studentId=${student.studentId}">Approve</a></td>
								<td scope="col"><a class="text-danger"
									href="${contextPath}/approval?decision=R&studentId=${student.studentId}">Reject</a></td>
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