<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- client form method : post
		 			 encType : multipart/form-data
		 server - servlet : @MultipartConfig
		 		- spring framework : @MultipartResolver -->
	<form action="${cp }/fileupload/upload" method="post" enctype="multipart/form-data">
		userid : <input type="text" name="userid" value="brown" /><br>
		file : <input type="file" name="file" /><br>
		<input type="submit" value="전송"	 /><br>
	</form>

</body>
</html>