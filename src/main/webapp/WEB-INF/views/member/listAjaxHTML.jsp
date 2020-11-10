<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> --%>

<%-- <link href="${cp}/css/bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS --> --%>
<%-- <link href="${cp}/css/dashboard.css" rel="stylesheet"> --%>
<%-- <link href="${cp}/css/blog.css?v=2" rel="stylesheet"> --%>


<c:forEach items="${memList }" var="member">
	<tr data-userid="${member.userid}">
		<td>${member.userid}</td>
		<td>${member.usernm}</td>
		<td>${member.alias}</td>
		<td><fmt:formatDate value="${member.reg_dt }" pattern="yyyy-MM-dd HH:mm" /> </td>
	</tr>
</c:forEach>
				

$$$$$$$$$$$$$$$$$$$$CHAPTER$$$$$$$$$$$$$$$$$$$$




<c:forEach var="i" begin="1" end="${pageCnt}" step="1">
	<c:choose>
		<c:when test="${pageVO.pageNum == i}">
			<li class="active"><span>${i}</span></li>
		</c:when>
		<c:otherwise>
			<li><a href="javascript:memberListAjaxHTML(${i })">${i}</a></li>						
		</c:otherwise>
	</c:choose>
</c:forEach>






