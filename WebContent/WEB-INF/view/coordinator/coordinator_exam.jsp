<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Exams</title>
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
				<div class="p-3 mb-2 bg-light text-dark">
					<h3>Available Exams</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<!-- Exam Add Function -->
				<a class="text-danger" href="${contextPath}/Coordinator/AddExam"><b>Create
						New Exam</b></a>
			</div>
			<div class="col">
				<!-- Exam Search -->
				<form class="row g-3" method="post" action="">
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
				<!-- Available Quizes Data Grid -->
				<table class="table table-light table-striped">
					<thead>
						<tr>
							<th scope="col">Exam Name</th>
							<th scope="col">Added On</th>
							<th scope="col">Added By</th>
							<th scope="col">Subject</th>
							<th scope="col">Show Exam</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<!-- populating table body -->
						<c:forEach items="${requestScope.exams}" var="exam">
							<tr>
								<td scope="col">${exam.examQuizName}</td>
								<td scope="col">${exam.addedOn}</td>
								<td scope="col">${exam.addedBy.firstName}
									${exam.addedBy.lastName}</td>
								<td scope="col">${exam.subject.subjectName}</td>
								<td scope="col"><a class="text-success"
									href="${contextPath}/Coordinator/ShowExam?ExamId=${exam.examQuizId}">Show
										Exam</a></td>
								<td scope="col"><a class="text-info"
									href="${contextPath}/Coordinator/EditExam?ExamId=${exam.examQuizId}">Edit</a></td>
								<td scope="col"><a class="text-danger"
									href="${contextPath}/Coordinator/DeleteExam?ExamId=${exam.examQuizId}">Delete</a></td>
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