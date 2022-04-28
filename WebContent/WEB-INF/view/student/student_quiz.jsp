<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Quiz</title>
<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- Nav bar -->
		<div class="row">
			<div class="col">
				<%@include file="student_nav_bar.html"%>
			</div>
		</div>
		<!-- Page content -->
		<!-- For available quizes -->
		<div class="row">
			<div class="p-3 mb-2 bg-light text-dark">
				<h3>Available Quizes</h3>
			</div>
		</div>
		<div class="row">
			<!-- Data grid for availabe Quizes -->
			<table class="table table-success table-striped">
				<thead>
					<tr>
						<th scope="col">Quiz Name</th>
						<th scope="col">Added On</th>
						<th scope="col">Added By</th>
						<th scope="col">Subject</th>
						<th scope="col">Attempt Quiz</th>
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
							<td scope="col"><a class="text-danger"
								href="${contextPath}/Student/AttemptQuiz?QuizId=${quiz.examQuizId}">Attempt
									Quiz</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- For attempted quizes -->
		<div class="row">
			<div class="p-3 mb-2 bg-light text-dark">
				<h3>Attempted Quizes</h3>
			</div>
		</div>
		<div class="row">
			<!-- Data grid for attempted Quizes -->
			<table class="table table-success table-striped">
				<thead>
					<tr>
						<th scope="col">Attempted Quiz</th>
						<th scope="col">Subject</th>
						<th scope="col">Attempted On</th>
						<th scope="col">Marks</th>
						<th scope="col">Status</th>
					</tr>
				</thead>
				<tbody>
					<!-- populating table body -->
					<c:forEach items="${requestScope.attempts}" var="attempt">
						<tr>
							<td scope="col">${attempt.examQuiz.examQuizName}</td>
							<td scope="col">${attempt.examQuiz.subject.subjectName}</td>
							<td scope="col">${attempt.attemptedOn}</td>
							<td scope="col">${attempt.marks}</td>
							<td scope="col"><c:out
									value="${attempt.passFail ? 'PASS' : 'FAIL'}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- Footer -->
		<div class="fixed-bottom">
			<footer>
				<p align="center">© 2022 eLearning</p>
			</footer>
		</div>
	</div>
	<div class="fixed-bottom">
		<footer>
			<p align="center">© 2022 eLearning</p>
		</footer>
	</div>
	<script type="text/javascript"
		src="${contextPath}/resource/bootstrap.bundle.min.js"></script>
</body>
</html>