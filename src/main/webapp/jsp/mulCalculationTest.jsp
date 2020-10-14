<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/mulCalculation" method="post">
		firstNum : <input type="text" name="firstNum" value="2"/><br>
		secondNum : <input type="text" name="secondNum" value="12"/><br>
		<input type="submit" value="send"/><br>
	</form>

</body>
</html>