<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link href="${cp}/css/bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<link href="${cp}/css/dashboard.css" rel="stylesheet">
<link href="${cp}/css/blog.css?v=2" rel="stylesheet">


<script>
	$(document).ready(function(){
		$("#memberInfo tr").on("click", function(){
			var userid = $(this).data("userid")
			console.log("userid = " + userid)
			document.location = "/memberInfo/view?userid=" + userid;
		})


		$("#memberRegistButton").on("click", function(){
			document.location = "/memberRegist/view"
		})
	})
	
</script>

tiles : memberListContent.jsp

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
				
				<tbody id="memberInfo">
					<c:forEach items="${memList}" var="member">
					<tr data-userid="${member.userid}">
						<td>${member.userid}</td>
						<td>${member.usernm}</td>
						<td>${member.alias}</td>
						<td><fmt:formatDate value="${member.reg_dt }" pattern="yyyy-MM-dd HH:mm" /> </td>
	<%-- 					<td><fmt:formatDate value="${member.reg_dt }" /> </td> --%>
	<%-- 					<td>${(member.reg_dt)}</td> --%>
					</tr>
					</c:forEach>
				
				</tbody>
				
				
			</table>
		</div>

		<a class="btn btn-default pull-right" id="memberRegistButton">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
			
				<c:forEach var="i" begin="1" end="${pageCnt}" step="1">
					<c:choose>
						<c:when test="${pageNum == i}">
							<li class="active"><span>${i}</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/memberList/view?pageNum=${i}">${i}</a></li>						
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>