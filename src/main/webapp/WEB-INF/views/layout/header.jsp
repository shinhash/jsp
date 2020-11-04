<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- <script src="/js/jquery/jquery-1.12.4.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script><!-- Custom styles for this template --> --%>

<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">
	
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			
<!-- 			접속을 안했을때 : 			==> [] -->
<!-- 			접속을 했을때 	: [brown] 	==> [brown] -->
			
			<c:choose>
				<c:when test="${S_MEMBER == null}">
					<a class="navbar-brand" href="#">JSP/SPRING</a>
				</c:when>
				<c:otherwise>
					<a class="navbar-brand" href="#">JSP/SPRING [ ${S_MEMBER.userid} ]</a>
				</c:otherwise>
			</c:choose>
			
			
			
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
				
				<c:choose>
					<c:when test="${S_MEMBER != null}">
						<li><a href="logout">logOut</a></li>
					</c:when>
				</c:choose>
				
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>