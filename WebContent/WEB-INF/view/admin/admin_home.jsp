<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
  		<div class="row">
    		<div class="col">
      			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  					<div class="container-fluid">
    					<a class="navbar-brand" href="#">eLearning</a>
    					<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      						<span class="navbar-toggler-icon"></span>
   						 </button>
   						 <div class="collapse navbar-collapse" id="navbarSupportedContent">
      						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
      							<li class="nav-item">
          							<a class="nav-link active" aria-current="page" href="#">Admin Home</a>
        						</li>
								<li class="nav-item">
          							<a class="nav-link active" aria-current="page" href="#">Coordinators</a>
        						</li>
       							<li class="nav-item">
          							<a class="nav-link active" aria-current="page" href="${contextPath}/logout">Logout</a>
        						</li>
      						</ul>
      						<form class="d-flex">
        						<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        						<button class="btn btn-outline-light" type="submit">Search</button>
      						</form>
    					</div>
  					</div>
				</nav>
    		</div>
  		</div>
  		<div class="row">
    		<div class="col">
    		</div>
  		</div>
  		<div class="row">
    		<div class="col">
    			<footer>
        			<p>© 2022 eLearning</p>
    			</footer>
    		</div>
  		</div>
	</div>
	<script type="text/javascript" src="${contextPath}/resource/bootstrap.bundle.min.js"></script>
</body>
</html>