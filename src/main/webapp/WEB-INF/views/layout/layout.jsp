<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="${pageContext.request.contextPath}/css/favicon.ico">

<title>Jsp</title>

<!-- <script src="/js/jquery/jquery-1.12.4.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/css/bootstrap.js"></script><!-- Custom styles for this template -->

<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">

</head>

<body>

	
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<tiles:insertAttribute name="header" />
	</nav>
	
	
	<div class="container-fluid">
		<div class="row">
			<tiles:insertAttribute name="left" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
				<tiles:insertAttribute name="content" />
				
			</div>
		</div>
	</div>
	
	
	
</body>
</html>