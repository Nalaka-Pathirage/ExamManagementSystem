<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Report</title>
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
				<h4 class="p-3 mb-2 text-dark text-center">Students
					registrations for the year
					${requestScope.registrationReportWrapper.registrations[0].yearOfStart}</h4>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div id="main" style="width: 600px; height: 600px;"></div>
			</div>
			<div class="col">
				<!-- Registration Data Grid -->
				<table class="table table-info table-striped">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Course</th>
							<th scope="col">Code</th>
							<th scope="col">Year</th>
							<th scope="col">Total Registrations</th>
						</tr>
					</thead>
					<tbody>
						<!-- populating table body -->
						<c:set var="count" value="0" scope="page" />
						<c:forEach
							items="${requestScope.registrationReportWrapper.registrations}"
							var="registration">
							<c:set var="count" value="${count + 1}" scope="page" />
							<tr>
								<td scope="col">${count}</td>
								<td scope="col">${registration.courseName}</td>
								<td scope="col">${registration.courseCode}</td>
								<td scope="col">${registration.yearOfStart}</td>
								<td scope="col">${registration.totalRegistrations}</td>
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
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/echarts@5.3.2/dist/echarts.min.js"></script>
	<script type="text/javascript"
		src="${contextPath}/resource/js/charts.js"></script>
</body>
</html>