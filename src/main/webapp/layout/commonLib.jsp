<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- <script src="/js/jquery/jquery-1.12.4.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script><!-- Custom styles for this template --> --%>

<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">


<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
				<c:forEach items="${memList}" var="member">
				<tr>
					<td>${member.userid}</td>
					<td>${member.usernm}</td>
					<td>${member.alias}</td>
					<td>${(member.reg_dt)}</td>
				</tr>
				</c:forEach>
				
				
			</table>
		</div>

		<a class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
			
				<c:forEach var="i" begin="1" end="${pageCnt}" step="1">
					<c:choose>
						<c:when test="${pageNum == i}">
							<li class="active"><span>${i}</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/memberList?pageNum=${i}">${i}</a></li>						
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>