<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<% String str = "test"; %>
	<% String str1 = "hello"; %>
	<script>
		/*
		서버 사이드 변수에 클라이언트 사이드 값을 대입하는 경우
		서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 안된다.
		*/


	
		//<%= str %> = 'test';
		message = 'test';


		/* 클라이언트 사이드 변수에 서버 사이드 변수값을 대입
		   서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 된다. */
		var msg = '<%= str1 %>'
	</script>

</head>
<body>

</body>
</html>