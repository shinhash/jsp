<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		fileUpload로 부터 위임받은 요청을 처리
		파일을 선택하여 form데이터를 fileUpload에 요청을 다시 위임(post)
	 -->
	<form action="${cp}/fileUpload" method="post" enctype="multipart/form-data">
		userid : <input type="text" name="userid" value="하하" /><br><br>
		file : <input type="file" name="img" /> <br><br>
		<!-- 값을 미리 설정하는것이 불가능 ==> 보안문제 -->
		<button type="submit" >전송</button><br><br>
	</form>

</body>
</html>