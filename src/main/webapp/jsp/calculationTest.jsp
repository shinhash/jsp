<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="${pageContext.request.contextPath}/sumCalculation" method="post">
		start : <input type="text" name="start" value="1"/><br>
		end : <input type="text" name="end" value="10"/><br>
		<input type="submit" value="send"/><br>
	</form>
	

</body>
</html>