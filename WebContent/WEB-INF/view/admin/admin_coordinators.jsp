<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Coordinators</title>
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
				<h4 class="p-3 mb-2 bg-info bg-gradien text-dark text-center">Manage Coordiantors</h4>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<!-- Coordinator Add Function -->
				<a class="text-success" href="${contextPath}/Admin/CoordinatorInsertHome"><b>Insert
					New Coordinator</b></a>
			</div>
			<div class="col">
				<!-- Coordinator Search -->
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
				<!-- Coordiantor Data Grid -->
				<table class="table table-light table-striped">
					<thead>
						<tr>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">NIC</th>
							<th scope="col">Mobile</th>
							<th scope="col">User Name</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<!-- populating table body -->
						<c:forEach items="${requestScope.coordinators}" var="coordinator">
							<tr>
								<td scope="col">${coordinator.firstName}</td>
								<td scope="col">${coordinator.lastName}</td>
								<td scope="col">${coordinator.nic}</td>
								<td scope="col">${coordinator.mobile}</td>
								<td scope="col">${coordinator.login.userName}</td>
								<td scope="col"><a class="text-info"
									href="${contextPath}/Admin/CoordinatorEditHome?coordinatorId=${coordinator.coordinatorId}">Edit</a></td>
								<td scope="col"><a class="text-danger"
									href="${contextPath}/Admin/CoordinatorDelete?coordinatorId=${coordinator.coordinatorId}">Delete</a></td>
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