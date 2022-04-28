<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attempt Exam</title>
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
		<div class="row">
			<div class="col">
				<div class="p-3 mb-2 bg-light text-dark">
					<h3>Attempt Exam</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<form method="post"
				action="${contextPath}/Student/AttemptExam?ExamId=${requestScope.examId}">
				<div class="mb-3">
					<c:forEach items="${requestScope.quizExamWrapper.questions}"
						var="question">
						<p class="fs-5">${question.questionNumber}.${question.question}</p>
						<c:forEach items="${question.answers}" var="answer">
							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="${question.questionNumber}"
									id="${question.questionNumber}" value="${answer.key}">
								<label class="form-check-label" for="${question.questionNumber}">
									${answer.key}. ${answer.value} </label>
							</div>
						</c:forEach>
						<br>
					</c:forEach>
				</div>
				<div class="d-grid gap-2 col-6 mx-auto">
					<button type="submit" class="btn btn-danger">Submit Quiz</button>
				</div>
			</form>
		</div>
	</div>
	<!-- Footer -->
	<footer>
		<p align="center">© 2022 eLearning</p>
	</footer>
	<script type="text/javascript"
		src="${contextPath}/resource/bootstrap.bundle.min.js"></script>
</body>
</html>