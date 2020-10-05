<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		td{ 
			text-align : center; 
			width : 100px; 
		}
	</style>
</head>
<body>

	<table border='1' align='center'>
	<%
	
	for(int i=1; i<10; i++) {
	%>
		<tr>
		<%
		for(int j=2; j<10; j++) {
		%>
			<td> <%= j %> * <%= i %> = <%= j*i %></td>
		<%
		}
		%>
		</tr>
	<%
	}
	
	%>
	</table>

</body>
</html>