<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	
	<% // 스크립플릿 : 자라 로직을 작성하는 공간
		Date date = new Date();
	%>


	현재시간 => <%= date.getHours() %> : <%= date.getMinutes() %> : <%= date.getSeconds() %>
</body>
</html>