<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>



</head>
<body>

	<h1>GET</h1>
	userId 파라미터는 brown, sally 두개를 보내지만 getParamater를 호출하면
	첫번째 파라미터 값을 반환 <br>
	request.getParameter("userId") : <%= request.getParameter("userId") %>

	request.getParameterValues("userId") : 
	<%
		String[] userIds = request.getParameterValues("userId");
		for(int i=0; i<userIds.length; i++){
		%>
		
		<%= userIds[i] %>
		
		<%	
		}
	%><br><br>
	
	request.getParameterMap("userId") : <%= request.getParameterMap() %>
		
		

</body>
</html>