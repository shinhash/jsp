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

	<table border="1">
		<c:forEach var="y" begin="1" end="9" step="1">
		<tr>
			<c:forEach var="x" begin="2" end="9" step="1">
			<td>${x} * ${y} = ${y*x}</td>	
			</c:forEach>
		</tr>
		</c:forEach>
	</table>

</body>
</html>