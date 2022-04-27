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
		<!-- page content -->
		<div class="row">
			<div class="col">
				<h4 class="p-3 mb-2 bg-light bg-gradien text-dark text-center">Manage
					Batches</h4>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<!-- Batch Add Function -->
				<a class="text-warning" href="${contextPath}/Coordinator/BatchAdd"><b>Create
						New Batch</b></a>
			</div>
			<div class="col">
				<!-- Batch Search -->
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
				<!-- Batches Data Grid -->
				<table class="table table-light table-striped">
					<thead>
						<tr>
							<th scope="col">Batch Name</th>
							<th scope="col">Batch Code</th>
							<th scope="col">Assigned Course</th>
							<th scope="col">Course Code</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<!-- populating table body -->
						<c:forEach items="${requestScope.batches}" var="batch">
							<tr>
								<td scope="col">${batch.batchName}</td>
								<td scope="col">${batch.batchCode}</td>
								<td scope="col">${batch.course.name}</td>
								<td scope="col">${batch.course.code}</td>
								<td scope="col"><a class="text-info"
									href="${contextPath}/Coordinator/BatchEdit?batchId=${batch.batchId}">Edit</a></td>
								<td scope="col"><a class="text-danger"
									href="${contextPath}/Coordinator/BatchDelete?batchId=${batch.batchId}">Delete</a></td>
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