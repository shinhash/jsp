<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">JOBS</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>JOB_ID</th>
					<th>JOB_TITLE</th>
				</tr>
				<c:forEach items="${jobList}" var="job">
				<tr>
					<td>${job.JOB_ID}</td>
					<td>${job.JOB_TITLE}</td>
				</tr>
				</c:forEach>
				
				
			</table>
		</div>

		<a class="btn btn-default pull-right">직업 등록</a>

		<div class="text-center">
			<ul class="pagination">
			
				<c:forEach var="i" begin="1" end="${pageCnt}" step="1">
					<c:choose>
						<c:when test="${pageNum == i}">
							<li class="active"><span>${i}</span></li>									
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/JobServlet?pageNum=${i}">${i}</a></li>								
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>