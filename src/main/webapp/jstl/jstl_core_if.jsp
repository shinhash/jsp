<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
// 		request.setAttribute("name", "brown");
	%>
	<c:set var="name" value="brown"></c:set>
	
	
	<c:if test="${name == 'sally'}">
		sally
	</c:if>
	
	<c:if test="${name == 'brown'}">
		brown
	</c:if>
	
	
	
</body>
</html>