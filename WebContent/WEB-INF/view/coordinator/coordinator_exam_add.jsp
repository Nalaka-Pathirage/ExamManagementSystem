<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Exam</title>
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
					<h3>Creating a Exam</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Exam Generation Form -->
			<form method="post"
				action="${contextPath}/Coordinator/AddExam?flag=G">
				<div class="row">
					<div class="col">
						<div class="mb-3">
							<label for="subject" class="form-label">Subject Name :</label> <select
								class="form-select" name="subject">
								<option selected>${sessionScope.generatedExamQuiz.subject.subjectName}</option>
								<c:forEach items="${requestScope.subjects}" var="subject">
									<option value="${subject.subjectId}">${subject.subjectName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col">
						<div class="mb-3">
							<label for="qName" class="form-label">Exam Name :</label> <input
								type="text" class="form-control" id="qName" name="qName"
								placeholder="${sessionScope.generatedExamQuiz.examQuizName}">
						</div>
						<div class="d-grid gap-2 col-6 mx-auto">
							<button type="submit" class="btn btn-outline-info">Generate
								Exam</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- Exam Questions Visualization Grid -->
		<div class="row">
			<div class="col">
				<table class="table table-success table-striped">
					<thead>
						<tr>
							<th scope="col">Question</th>
							<th scope="col">View</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<!-- populating table body -->
						<c:forEach items="${sessionScope.quizExamWrapper.questions}"
							var="question">
							<tr>
								<td scope="col">${question.questionNumber}</td>
								<td scope="col"><a class="text-info" href="">View</a></td>
								<td scope="col"><a class="text-info" href="">Edit</a></td>
								<td scope="col"><a class="text-danger" href="">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- Complete Quiz Submit Form -->
				<form method="post"
					action="${contextPath}/Coordinator/AddExam?flag=S">
					<div class="row">
						<div class="col">
							<div class="d-grid gap-2 col-6 mx-auto">
								<button type="submit" class="btn btn-outline-danger">Submit
									Exam</button>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="col"></div>
			<div class="col"></div>
		</div>
		<div class="row">
			<!-- Question Add Form -->
			<form method="post"
				action="${contextPath}/Coordinator/AddExam?flag=A">
				<div class="row">
					<div class="col">
						<div class="mb-3">
							<label for="qNumber" class="form-label">Exam Name :</label> <input
								type="text" class="form-control" id="qName" name="qName"
								placeholder="${sessionScope.generatedExamQuiz.examQuizName}"
								readonly>
						</div>
					</div>
					<div class="col">
						<div class="mb-3">
							<label for="qNumber" class="form-label">Question Number :</label>
							<input type="text" class="form-control" id="qNumber"
								name="qNumber" placeholder="Enter Question Number">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<div class="mb-3">
							<label for="question" class="form-label">Enter Question :</label>
							<textarea class="form-control" id="question" name="question"
								rows="3"></textarea>
						</div>
						<div class="mb-3">
							<label for="availableAnswers" class="form-label">Answer
								Selection :</label> <input type="text" class="form-control"
								id="availableAnswers" name="availableAnswers"
								placeholder="Please Add Answers Comma (,) Seperated">
						</div>
						<div class="mb-3">
							<label for="correctAnswer" class="form-label">Correct
								Answer :</label> <input type="text" class="form-control"
								id="correctAnswer" name="correctAnswer"
								placeholder="Please Enter Correct Answer">
						</div>
						<div class="d-grid gap-2 col-6 mx-auto">
							<button type="submit" class="btn btn-outline-warning">Add
								Question</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- Page footer -->
		<footer>
			<p align="center">?? 2022 eLearning</p>
		</footer>
	</div>
	<script type="text/javascript"
		src="${contextPath}/resource/bootstrap.bundle.min.js"></script>
</body>
</html>