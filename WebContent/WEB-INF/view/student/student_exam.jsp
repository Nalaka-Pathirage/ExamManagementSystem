<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Exam</title>
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
		<!-- For available exams -->
		<div class="row">
			<div class="p-3 mb-2 bg-light text-dark">
				<h3>Available Exams</h3>
			</div>
		</div>
		<div class="row">
			<!-- Data grid for availabe Exams -->
			<table class="table table-success table-striped">
				<thead>
					<tr>
						<th scope="col">Exam Name</th>
						<th scope="col">Added On</th>
						<th scope="col">Added By</th>
						<th scope="col">Subject</th>
						<th scope="col">Attempt Exam</th>
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
							<td scope="col"><a class="text-danger"
								href="${contextPath}/Student/AttemptExam?ExamId=${exam.examQuizId}">Attempt
									Exam</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- For attempted exams -->
		<div class="row">
			<div class="p-3 mb-2 bg-light text-dark">
				<h3>Attempted Exams</h3>
			</div>
		</div>
		<div class="row">
			<!-- Data grid for attempted Exams -->
			<table class="table table-success table-striped">
				<thead>
					<tr>
						<th scope="col">Attempted Exam</th>
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