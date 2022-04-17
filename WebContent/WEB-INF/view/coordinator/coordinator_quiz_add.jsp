<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Quizes</title>
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
					<h3>Creating a Quiz</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Quiz Generation Form -->
			<form method="post"
				action="${contextPath}/Coordinator/AddQuiz?flag=G">
				<div class="row">
					<div class="col">
						<div class="mb-3">
							<label for="course" class="form-label">Subject Name :</label> <select
								class="form-select" name="course">
								<option selected>Select Subject</option>
								<c:forEach items="${requestScope.subjects}" var="subject">
									<option value="${subject.subjectId}">${subject.subjectName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col">
						<div class="mb-3">
							<label for="qName" class="form-label">Quiz Name :</label> <input
								type="text" class="form-control" id="qName" name="qName"
								placeholder="Enter Quiz Name">
						</div>
						<div class="d-grid gap-2 col-6 mx-auto">
							<button type="submit" class="btn btn-outline-info">Generate
								Quiz</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- Quiz Visualization Grid -->
		<div class="row">
			<div class="col">
				<table class="table table-success table-striped">
					<thead>
						<tr>
							<th scope="col">Question</th>
							<th scope="col">Edit</th>
							<th scope="col">View</th>
						</tr>
					</thead>
					<tbody>
						<!-- populating table body -->
						<!-- <c:forEach items="${requestScope.questions}" var="question">
							<tr>
								<td scope="col">${question.number}</td>
								<td scope="col"><a class="text-info" href="">View</a></td>
								<td scope="col"><a class="text-info" href="">Edit</a></td>
								<td scope="col"><a class="text-danger" href="">Delete</a></td>
							</tr>
						</c:forEach> -->
					</tbody>
				</table>
				<!-- Complete Quiz Submit Form -->
				<form method="post"
					action="${contextPath}/Coordinator/AddQuiz?flag=T">
					<div class="row">
						<div class="col">
							<div class="d-grid gap-2 col-6 mx-auto">
								<button type="submit" class="btn btn-outline-danger">Submit
									Quiz</button>
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
				action="${contextPath}/Coordinator/AddQuiz?submit=F">
				<div class="row">
					<div class="col">
						<div class="mb-3">
							<label for="qNumber" class="form-label">Quiz Name :</label> <input
								type="text" class="form-control" id="qName" name="qName"
								value="Mock Quiz" readonly>
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
							<label for="correctAnswers" class="form-label">Correct
								Answer :</label> <input type="text" class="form-control"
								id="correctAnswers" name="correctAnswers"
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
		<!--  <div class="fixed-bottom"> -->
		<footer>
			<p align="center">© 2022 eLearning</p>
		</footer>
		<!--  </div> -->
	</div>
	<script type="text/javascript"
		src="${contextPath}/resource/bootstrap.bundle.min.js"></script>
</body>
</html>