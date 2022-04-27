<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Quizes</title>
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
					<h3>Available Quizes</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<!-- Quiz Add Function -->
				<a class="text-danger" href="${contextPath}/Coordinator/AddQuiz"><b>Create
						New Qiz</b></a>
			</div>
			<div class="col">
				<!-- Quiz Search -->
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
							<th scope="col">Quiz Name</th>
							<th scope="col">Added On</th>
							<th scope="col">Added By</th>
							<th scope="col">Subject</th>
							<th scope="col">Show Quiz</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<!-- populating table body -->
						<c:forEach items="${requestScope.quizes}" var="quiz">
							<tr>
								<td scope="col">${quiz.examQuizName}</td>
								<td scope="col">${quiz.addedOn}</td>
								<td scope="col">${quiz.addedBy.firstName}
									${quiz.addedBy.lastName}</td>
								<td scope="col">${quiz.subject.subjectName}</td>
								<td scope="col"><a class="text-success"
									href="${contextPath}/Coordinator/ShowQuiz?QuizId=${quiz.examQuizId}">Show
										Quiz</a></td>
								<td scope="col"><a class="text-info"
									href="${contextPath}/Coordinator/EditQuiz?QuizId=${quiz.examQuizId}">Edit</a></td>
								<td scope="col"><a class="text-danger"
									href="${contextPath}/Coordinator/DeleteQuiz?QuizId=${quiz.examQuizId}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- Page footer -->
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